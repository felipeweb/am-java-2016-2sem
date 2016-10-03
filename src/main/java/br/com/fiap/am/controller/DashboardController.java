package br.com.fiap.am.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.com.fiap.am.dao.UserDAO;
import br.com.fiap.am.model.User;

/**
 * Created by felipeweb on 14/09/16.
 */
@Controller
public class DashboardController {
	private final Result result;
	private final UserDAO userDAO;
	
	/**
	 * @deprecated CDI eyes only
	 */
    protected DashboardController() {
    	this(null, null);
	}
    
    @Inject
	public DashboardController(Result result, UserDAO userDAO) {
		this.result = result;
		this.userDAO = userDAO;
	}

	@Get("/dashboard")
    public void dashboard(String column, String value) {
    	result.include("users", userDAO.filterBy(column, value));
    }
}
