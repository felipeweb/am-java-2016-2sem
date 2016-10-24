package br.com.fiap.am.dao;

import br.com.fiap.am.model.InvestPackage;
import br.com.fiap.am.model.QuantidadePorPacote;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by felipeweb on 24/10/16.
 */
public class QuantidadePorPacoteDAO extends GenericDAO<QuantidadePorPacote> {
    private final EntityManager manager;

    /**
     * @deprecated CDI eyes only
     */
    protected QuantidadePorPacoteDAO() {
        this(null);
    }

    @Inject
    public QuantidadePorPacoteDAO(EntityManager manager) {
        super(QuantidadePorPacote.class);
        this.manager = manager;
    }

    @Override
    protected EntityManager getEntityManager() {
        return manager;
    }

    public void deleteByInvestPackage(InvestPackage investPackage) {
        List<QuantidadePorPacote> qpp = getEntityManager()
                .createQuery("SELECT q FROM QuantidadePorPacote q WHERE  q.investPackage = :package")
                .setParameter("package", investPackage).getResultList();
        qpp.forEach(this::delete);
    }
}
