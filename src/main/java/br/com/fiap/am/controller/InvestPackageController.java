package br.com.fiap.am.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Severity;
import br.com.caelum.vraptor.validator.Validator;
import br.com.fiap.am.dao.InvestPackageDAO;
import br.com.fiap.am.dao.QuantidadePorPacoteDAO;
import br.com.fiap.am.dao.UserDAO;
import br.com.fiap.am.model.InvestPackage;
import br.com.fiap.am.model.Investor;
import br.com.fiap.am.model.QuantidadePorPacote;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by felipeweb on 17/09/16.
 */
@Controller
public class InvestPackageController {
    private final Validator validator;
    private final Result result;
    private final InvestPackageDAO investPackageDAO;
    private final QuantidadePorPacoteDAO quatidadePorPacoteDAO;
    private final UserDAO userDAO;

    /**
     * @deprecated CDI eyes only
     */
    protected InvestPackageController() {
        this(null, null, null, null, null);
    }

    @Inject
    public InvestPackageController(Validator validator, Result result, InvestPackageDAO investPackageDAO, QuantidadePorPacoteDAO quatidadePorPacoteDAO, UserDAO userDAO) {
        this.validator = validator;
        this.result = result;
        this.investPackageDAO = investPackageDAO;
        this.quatidadePorPacoteDAO = quatidadePorPacoteDAO;
        this.userDAO = userDAO;
    }

    @Get("/packages/form")
    public void form() {

    }

    @Post("/packages/save")
    public void save(@Valid InvestPackage investPackage) {
        validator.onErrorRedirectTo(this).form();
        if (investPackage.getId() == null) {
            investPackageDAO.insert(investPackage);
            validator.add(new I18nMessage("success", "success.created", Severity.SUCCESS));
            result.redirectTo(DashboardController.class).dashboard(null, null);
            return;
        }
        investPackageDAO.update(investPackage);
        validator.add(new I18nMessage("success", "success.updated", Severity.SUCCESS));
        result.redirectTo(DashboardController.class).dashboard(null, null);
    }

    @Get("/packages/{id}")
    public void edit(Long id) {
        InvestPackage investPackage = investPackageDAO.findById(id);
        result.include("investPackage", investPackage);
        result.forwardTo(this).form();
    }

    @Get("/packages")
    public void list() {
        List<InvestPackage> all = investPackageDAO.findAll();
        if (all != null && !all.isEmpty()) {
            result.include("investPackageList", all);
            return;
        }
        validator.add(new I18nMessage("info", "nothing.show", Severity.INFO));
    }

    @Get("/packages/remove/{id}")
    public void delete(Long id) {
        List<QuantidadePorPacote> l = new ArrayList<>();
        InvestPackage investPackage = investPackageDAO.findById(id);
        List<Investor> investors = userDAO.findAllInvestorByInvestPackage(investPackage);
        investors.forEach(u -> {
            List<QuantidadePorPacote> collect = u.getQuantidadePackage().stream().filter(q -> !q.getInvestPackage().equals(investPackage)).collect(Collectors.toList());
            u.setQuantidadePackage(collect);
            userDAO.update(u);
        });
        quatidadePorPacoteDAO.deleteByInvestPackage(investPackage);
        investPackageDAO.delete(investPackage);
        validator.add(new I18nMessage("success", "success.deleted", Severity.SUCCESS));
        result.redirectTo(DashboardController.class).dashboard(null, null);
    }
}
