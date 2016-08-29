package br.com.fiap.am.preload;

import br.com.caelum.vraptor.events.VRaptorInitialized;
import br.com.fiap.am.infra.DefaultWebMasterCreator;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

/**
 * Created by felipeweb on 8/29/16.
 */
@ApplicationScoped
public class PreLoad {
	@Inject
	private DefaultWebMasterCreator webMasterCreator;

	public void execute(@Observes VRaptorInitialized initialized) {
		webMasterCreator.createWebMaster();
	}
}
