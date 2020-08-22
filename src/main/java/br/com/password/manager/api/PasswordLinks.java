package br.com.password.manager.api;

import br.com.password.manager.api.controller.DadoController;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;



@Component
public class PasswordLinks {

    public Link linkToDados(String rel){
        return linkTo(DadoController.class).withRel(rel);
    }

    public Link linkToDados(){
        return linkToDados(IanaLinkRelations.SELF.value());
    }
}
