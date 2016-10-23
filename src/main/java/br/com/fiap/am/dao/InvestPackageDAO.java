package br.com.fiap.am.dao;

import br.com.fiap.am.model.InvestPackage;
import br.com.fiap.am.model.News;

import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Created by felipeweb on 18/10/16.
 */
public class InvestPackageDAO extends GenericDAO<InvestPackage> {

    private final EntityManager manager;

    /**
     * @deprecated CDI eyes only
     */
    protected InvestPackageDAO() {
        this(null);
    }

    @Inject
    public InvestPackageDAO(EntityManager manager) {
        super(InvestPackage.class);
        this.manager = manager;
    }

    @Override
    protected EntityManager getEntityManager() {
        return manager;
    }
}
