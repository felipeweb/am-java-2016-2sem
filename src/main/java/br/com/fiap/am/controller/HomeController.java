package br.com.fiap.am.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.fiap.am.authorization.Public;

@Controller
public class HomeController {
	
	@Get("/")
	@Public
	public void home() {
		
	}
}