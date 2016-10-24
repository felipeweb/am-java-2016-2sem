package br.com.fiap.am.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.com.fiap.am.authorization.Public;
import br.com.fiap.am.dao.InvestPackageDAO;
import br.com.fiap.am.dao.NewsDAO;

import javax.inject.Inject;

@Controller
public class HomeController {
    private final Result result;
    private final NewsDAO newsDAO;
    private final InvestPackageDAO investPackageDAO;

    /**
     * @deprecated CDI eyes
     */
    public HomeController() {
        this(null, null, null);
    }

    @Inject
    public HomeController(Result result, NewsDAO newsDAO, InvestPackageDAO investPackageDAO) {
        this.result = result;
        this.newsDAO = newsDAO;
        this.investPackageDAO = investPackageDAO;
    }

    @Get("/")
    @Public
    public void home() {
        result.include("newsList", newsDAO.findAll());
        result.include("pkgs", investPackageDAO.findAll());
    }
}