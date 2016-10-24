package br.com.fiap.am.controller;

import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.com.fiap.am.dao.InvestPackageDAO;
import br.com.fiap.am.dao.UserDAO;
import br.com.fiap.am.model.User;

/**
 * Created by felipeweb on 14/09/16.
 */
@Controller
public class DashboardController {
	private final Result result;
	private final UserDAO userDAO;
	private final InvestPackageDAO investPackageDAO;
	
	/**
	 * @deprecated CDI eyes only
	 */
    protected DashboardController() {
    	this(null, null, null);
	}
    
    @Inject
	public DashboardController(Result result, UserDAO userDAO, InvestPackageDAO investPackageDAO) {
		this.result = result;
		this.userDAO = userDAO;
		this.investPackageDAO = investPackageDAO;
	}

	@Get("/dashboard")
    public void dashboard(String column, String value) {
		List<User> users = userDAO.filterBy(column, value);
		users.sort(Comparator.comparing(User::getId));
    	result.include("users", users);
    }
	@Get("/dashboard/invest")
	public void dashboardInvest() {

	}
}
