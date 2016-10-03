package br.com.fiap.am.infra;

import static br.com.fiap.am.enums.AccessLevel.WEBMASTER;
import static br.com.fiap.am.infra.Digester.encrypt;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.log4j.Logger;

import br.com.fiap.am.model.User;
import br.com.fiap.am.model.Webmaster;

/**
 * Created by felipeweb on 8/29/16.
 */
@ApplicationScoped
public class DefaultWebMasterCreator {
	@Inject
	private EntityManagerFactory factory;
	private static Logger LOG = Logger.getLogger(DefaultWebMasterCreator.class);

	public void createWebMaster() {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		long result = (long) manager.createQuery("select count(*) from User").getSingleResult();
		if (result == 0) {
			String senha = "webmaster1234";
			User user = new Webmaster("WEBMASTER", "webmaster", encrypt(senha));
			manager.persist(user);
			LOG.info("===================================");
			LOG.info("NEW WEBMASTER CREATED");
			LOG.info("Login: " + user.getLogin());
			LOG.info("Senha: " + senha);
			LOG.info("===================================");
		}
		manager.getTransaction().commit();
	}
}
