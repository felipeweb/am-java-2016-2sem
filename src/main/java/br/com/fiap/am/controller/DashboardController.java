package br.com.fiap.am.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;

/**
 * Created by felipeweb on 14/09/16.
 */
@Controller
public class DashboardController {
    @Get("/dashboard")
    public void dashboard() {}
}
