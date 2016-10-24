package br.com.fiap.am.dao;

import br.com.fiap.am.infra.Digester;
import br.com.fiap.am.model.Investor;
import br.com.fiap.am.model.User;

import java.util.List;

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
	
	public List<User> filterBy(String column, String value){
		if(column != null && !column.equals("*")){
			String sql = "SELECT u FROM User u WHERE " + column + " = :value";
			return (List<User>) getEntityManager().createQuery(sql).setParameter("value", value).getResultList();
		}
		return findAll();		
	}

	public List<Investor> findAllInvestor() {
		return (List<Investor>) getEntityManager().createQuery("SELECT i FROM Investor i").getResultList();
	}
}
