package br.com.fiap.am.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Severity;
import br.com.caelum.vraptor.validator.Validator;
import br.com.fiap.am.dao.NewsDAO;
import br.com.fiap.am.dao.UserDAO;
import br.com.fiap.am.model.News;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by felipeweb on 17/09/16.
 */
@Controller
public class NewsController {
    private final Validator validator;
    private final Result result;
    private final NewsDAO newsDAO;

    /**
     * @deprecated CDI eyes only
     */
    protected NewsController() {
        this(null, null, null);
    }

    @Inject
    public NewsController(Validator validator, Result result, NewsDAO newsDAO) {
        this.validator = validator;
        this.result = result;
        this.newsDAO = newsDAO;
    }

    @Get("/news/form")
    public void form() {

    }

    @Post("/news/save")
    public void save(@Valid News news) {
        validator.onErrorRedirectTo(this).form();
        if (news.getId() == null) {
            newsDAO.insert(news);
            validator.add(new I18nMessage("success", "success.created", Severity.SUCCESS));
            result.redirectTo(DashboardController.class).dashboard(null, null);
            return;
        }
        newsDAO.update(news);
        validator.add(new I18nMessage("success", "success.updated", Severity.SUCCESS));
        result.redirectTo(DashboardController.class).dashboard(null, null);
    }

    @Get("/news/{id}")
    public void edit(Long id) {
        News news = newsDAO.findById(id);
        result.include("news", news);
        result.forwardTo(this).form();
    }

    @Get("/news")
    public void list() {
        List<News> all = newsDAO.findAll();
        if (all != null && !all.isEmpty()) {
            result.include("newsList", all);
            return;
        }
        validator.add(new I18nMessage("info", "nothing.show", Severity.INFO));
    }

    @Get("/news/remove/{id}")
    public void delete(Long id) {
        News news = newsDAO.findById(id);
        newsDAO.delete(news);
        validator.add(new I18nMessage("success", "success.deleted", Severity.SUCCESS));
        result.redirectTo(DashboardController.class).dashboard(null, null);
    }
}
