package br.com.fiap.am.dao;

import br.com.fiap.am.model.News;

import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Created by felipeweb on 17/09/16.
 */
public class NewsDAO extends GenericDAO<News> {

    private final EntityManager manager;

    /**
     * @deprecated CDI eyes only
     */
    protected NewsDAO() {
        this(null);
    }

    @Inject
    public NewsDAO(EntityManager manager) {
        super(News.class);
        this.manager = manager;
    }

    @Override
    protected EntityManager getEntityManager() {
        return manager;
    }
}
