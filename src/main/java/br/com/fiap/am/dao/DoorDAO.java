package br.com.fiap.am.dao;

import br.com.fiap.am.model.Door;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by felipeweb on 09/10/16.
 */
public class DoorDAO extends GenericDAO<Door> {

    private final EntityManager manager;

    /**
     * @deprecated CDI eyes only
     */
    protected DoorDAO() {
        this(null);
    }

    @Inject
    public DoorDAO(EntityManager manager) {
        super(Door.class);
        this.manager = manager;
    }

    @Override
    protected EntityManager getEntityManager() {
        return manager;
    }

    public List<Door> findDoorByUser(Long id) {
        return (List<Door>) getEntityManager().createQuery("SELECT p FROM Door p WHERE p.client.id = :id")
                .setParameter("id", id).getResultList();
    }
}
