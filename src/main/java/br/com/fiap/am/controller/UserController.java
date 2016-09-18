package br.com.fiap.am.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.fiap.am.model.User;

/**
 * Created by felipeweb on 12/09/16.
 */
@Controller
public class UserController {
    @Get("/user/form")
    public void form() {

    }
    
    @Post("/user/save")
    public void saveUser(User user){
    	
    }
    
    @Get("/user/edit/{id}")
    public void edit(Long id){
    	user  = findById(id)
    	result.include("user", user)
    	result.forward(this).form()
    }
}
