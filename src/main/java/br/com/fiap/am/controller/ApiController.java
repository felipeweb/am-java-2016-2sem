package br.com.fiap.am.controller;

import br.com.caelum.vraptor.*;
import br.com.caelum.vraptor.validator.Validator;
import br.com.fiap.am.authorization.Public;
import br.com.fiap.am.dao.DoorDAO;
import br.com.fiap.am.dao.UserDAO;
import br.com.fiap.am.model.Client;
import br.com.fiap.am.model.Door;
import br.com.fiap.am.model.User;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import java.util.List;

import static br.com.caelum.vraptor.view.Results.http;
import static br.com.caelum.vraptor.view.Results.json;

/**
 * Created by felipeweb on 09/10/16.
 */
@Controller
@Path("/api/v1")
public class ApiController {
    private final Result result;
    private final Validator validator;
    private final UserDAO users;
    private final DoorDAO ports;

    /**
     * @deprecated CDI eyes only
     */
    protected ApiController() {
        this(null, null, null, null);
    }

    @Inject
    public ApiController(Result result, Validator validator, UserDAO users, DoorDAO ports) {
        this.result = result;
        this.validator = validator;
        this.users = users;
        this.ports = ports;
    }

    @Get("/login")
    @Public
    public void login(@NotNull String login, @NotNull String senha) {
        validator.onErrorSendBadRequest();
        User user = users.findUserByLoginAndPassword(login, senha);
        result.use(json()).withoutRoot().from(user).recursive().serialize();
    }

    @Post("/user")
    @Public
    @Consumes("application/json")
    public void saveUser(@Valid Client client) {
        validator.onErrorSendBadRequest();
        if (client.getId() == null) {
            users.insert(client);
        } else {
            users.update(client);
        }
        result.use(http()).setStatusCode(201);
        result.use(json()).withoutRoot().from(client).recursive().serialize();
    }

    @Get("/user/{id}")
    @Public
    public void listUser(Long id) {
        validator.onErrorSendBadRequest();
        User user = users.findById(id);
        result.use(json()).withoutRoot().from(user).recursive().serialize();
    }

    @Post("/door")
    @Public
    @Consumes("application/json")
    public void saveDoor(@Valid Door door) {
        validator.onErrorSendBadRequest();
        result.use(http()).setStatusCode(201);
        if (door.getId() == null) {
            ports.insert(door);
        } else {
            ports.update(door);
        }
        result.use(json()).withoutRoot().from(door).recursive().serialize();
    }

    @Get("/door/{id}")
    @Public
    public void listDoor(Long id) {
        validator.onErrorSendBadRequest();
        Door door = ports.findById(id);
        result.use(json()).withoutRoot().from(door).recursive().serialize();
    }

    @Get("/user/{id}/doors")
    @Public
    public void listUserDoors(Long id) {
        validator.onErrorSendBadRequest();
        List<Door> doors = ports.findDoorByUser(id);
        result.use(json()).withoutRoot().from(doors).recursive().serialize();
    }
}
