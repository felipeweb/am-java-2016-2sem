package br.com.fiap.am.dao;

import br.com.fiap.am.model.QuantidadePorPacote;

import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Created by felipeweb on 24/10/16.
 */
public class QuatidadePorPacoteDAO extends GenericDAO<QuantidadePorPacote> {
    private final EntityManager manager;

    /**
     * @deprecated CDI eyes only
     */
    protected QuatidadePorPacoteDAO() {
        this(null);
    }

    @Inject
    public QuatidadePorPacoteDAO(EntityManager manager) {
        super(QuantidadePorPacote.class);
        this.manager = manager;
    }

    @Override
    protected EntityManager getEntityManager() {
        return manager;
    }
}
