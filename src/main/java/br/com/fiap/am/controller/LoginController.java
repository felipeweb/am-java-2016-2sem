package br.com.fiap.am.controller;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Severity;
import br.com.caelum.vraptor.validator.Validator;
import br.com.fiap.am.authorization.Public;
import br.com.fiap.am.dao.UserDAO;
import br.com.fiap.am.model.User;
import br.com.fiap.am.model.UserSession;

@Controller
public class LoginController {

	private final Validator validator;
	private final UserDAO users;
	private final UserSession session;
	private final Result result;
	/**
	 * @deprecated CDI eyes only
	 */
	protected LoginController() {
		this(null, null, null, null);
	}
	
	@Inject
	public LoginController(Validator validator, UserDAO users, UserSession session, Result result) {
		this.validator = validator;
		this.users = users;
		this.session = session;
		this.result = result;
	}

	@Get("/login")
	@Public
	public void login() {

	}

	@Post("/login")
	@Public
	public void auth(@NotNull String login, @NotNull String password) {
		validator.onErrorRedirectTo(this).login();
		User user = users.findUserByLoginAndPassword(login, password);
		if(user == null){
			validator.add(new I18nMessage("error", "login.fail", Severity.ERROR));
			validator.onErrorRedirectTo(this).login();
			return;
		}
		
		session.add(user);
		result.redirectTo(HomeController.class).home();
	}
	
	@Get("/logout")
	public void logout(){
		session.invalidate();
		validator.add(new I18nMessage("success", "login.logout", Severity.SUCCESS));
		result.redirectTo(this).login();
	}
}
