package br.com.fiap.am.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Severity;
import br.com.caelum.vraptor.validator.Validator;
import br.com.fiap.am.dao.UserDAO;
import br.com.fiap.am.enums.AccessLevel;
import br.com.fiap.am.model.News;
import br.com.fiap.am.model.User;

/**
 * Created by felipeweb on 12/09/16.
 */
@Controller
public class UserController {

	private final UserDAO userDAO;
	private final Result result;
	private final Validator validator;

	/**
	 * @deprecated CDI eyes only
	 */
	protected UserController() {
		this(null, null, null);
	}

	@Inject
	public UserController(UserDAO userDAO, Result result, Validator validator) {
		this.userDAO = userDAO;
		this.result = result;
		this.validator = validator;
	}

	@Get("/user/form")
	public void form() {
		result.include("levelsList", AccessLevel.levels());
	}

	@Post("/user/save")
	public void saveUser(@Valid User user) {
		validator.onErrorRedirectTo(this).form();
		if (user.getId() == null) {
			userDAO.insert(user);
			validator.add(new I18nMessage("success", "success.created", Severity.SUCCESS));
			result.redirectTo(DashboardController.class).dashboard();
			return;
		}
		userDAO.update(user);
		validator.add(new I18nMessage("success", "success.updated", Severity.SUCCESS));
		result.redirectTo(DashboardController.class).dashboard();
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
		result.redirectTo(DashboardController.class).dashboard();
	}
}
