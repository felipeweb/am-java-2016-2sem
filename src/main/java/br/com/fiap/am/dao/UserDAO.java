package br.com.fiap.am.dao;

import br.com.fiap.am.infra.Digester;
import br.com.fiap.am.model.User;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

/**
 * Created by felipeweb on 8/30/16.
 */
public class UserDAO extends GenericDAO<User> {

	private final EntityManager manager;

	/**
	 * @deprecated CDI eyes only
	 */
	protected UserDAO() {
		this(null);
	}

	@Inject
	public UserDAO(EntityManager manager) {
		super(User.class);
		this.manager = manager;
	}

	@Override
	protected EntityManager getEntityManager() {
		return manager;
	}
	
	public User findUserByLoginAndPassword(String login, String password){
		try{
			return (User)
					getEntityManager().createQuery("select u from User u where u.login = :login and password = :password")
					.setParameter("login", login)
					.setParameter("password", Digester.encrypt(password))
					.getSingleResult();
		}catch (NoResultException e){
			return null;
		}
	}	
}
