package br.com.fiap.am.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Severity;
import br.com.caelum.vraptor.validator.Validator;
import br.com.fiap.am.authorization.Public;
import br.com.fiap.am.dao.InvestPackageDAO;
import br.com.fiap.am.dao.QuatidadePorPacoteDAO;
import br.com.fiap.am.dao.UserDAO;
import br.com.fiap.am.enums.AccessLevel;
import br.com.fiap.am.infra.Digester;
import br.com.fiap.am.model.*;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by felipeweb on 12/09/16.
 */
@Controller
public class UserController {

    private final UserDAO userDAO;
    private final Result result;
    private final Validator validator;
    private final InvestPackageDAO investPackageDAO;

    /**
     * @deprecated CDI eyes only
     */
    protected UserController() {
        this(null, null, null, null);
    }

    @Inject
    public UserController(UserDAO userDAO, Result result, Validator validator, InvestPackageDAO investPackageDAO) {
        this.userDAO = userDAO;
        this.result = result;
        this.validator = validator;
        this.investPackageDAO = investPackageDAO;
    }

    @Get("/user/form")
    public void form() {
    }

    @Post("/user/save")
    public void saveUser(@Valid Administrator user) {
        validator.onErrorRedirectTo(this).form();
        if (user.getId() == null) {
            user.setPassword(Digester.encrypt(user.getPassword()));
            userDAO.insert(user);
            validator.add(new I18nMessage("success", "success.created", Severity.SUCCESS));
            result.redirectTo(DashboardController.class).dashboard(null, null);
            return;
        }
        user.setPassword(Digester.encrypt(user.getPassword()));
        userDAO.update(user);
        validator.add(new I18nMessage("success", "success.updated", Severity.SUCCESS));
        result.redirectTo(DashboardController.class).dashboard(null, null);
    }

    @Post("/user/save/investor")
    @Public
    public void saveHome(@Valid Investor user) {
        validator.onErrorRedirectTo(HomeController.class).home();
        user.getQuantidadePackage()
                .forEach(qp -> {
                    if (qp.getInvestPackage().getId() != null) {
                        investPackageDAO.update(qp.getInvestPackage());
                    }
                });
        save(user);
    }

    @Post("/user/save/client")
    @Public
    public void saveHome(@Valid Client user) {
        validator.onErrorRedirectTo(HomeController.class).home();
        save(user);

    }

    private void save(User user) {
        if (user.getId() == null) {
            user.setPassword(Digester.encrypt(user.getPassword()));
            userDAO.insert(user);
            validator.add(new I18nMessage("success", "success.created", Severity.SUCCESS));
            result.redirectTo(HomeController.class).home();
            return;
        }
        user.setPassword(Digester.encrypt(user.getPassword()));
        userDAO.update(user);
        validator.add(new I18nMessage("success", "success.updated", Severity.SUCCESS));
        result.redirectTo(HomeController.class).home();
    }

    @Get("/user/{id}")
    public void edit(Long id) {
        User user = userDAO.findById(id);
        result.include("user", user);
        result.forwardTo(this).form();
    }

    @Get("/users")
    public void list() {
        List<User> all = userDAO.findAll();
        if (all != null && !all.isEmpty()) {
            result.include("usersList", all);
            return;
        }
        validator.add(new I18nMessage("info", "nothing.show", Severity.INFO));
    }

    @Get("/user/remove/{id}")
    public void delete(Long id) {
        User user = userDAO.findById(id);
        userDAO.delete(user);
        validator.add(new I18nMessage("success", "success.deleted", Severity.SUCCESS));
        result.redirectTo(DashboardController.class).dashboard(null, null);
    }
}
