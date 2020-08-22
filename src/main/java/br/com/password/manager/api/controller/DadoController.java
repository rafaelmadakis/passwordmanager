package br.com.password.manager.api.controller;

import br.com.password.manager.api.model.DadoModel;
import br.com.password.manager.api.model.input.DadoInput;
import br.com.password.manager.api.openapi.DadoControllerOpenApi;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/dados", produces = MediaType.APPLICATION_JSON_VALUE)
public class DadoController implements DadoControllerOpenApi {

    @Override
    public CollectionModel<DadoModel> listar() {
        return null;
    }

    @Override
    public DadoModel buscar(Long dadoId) {
        return null;
    }

    @Override
    public DadoModel adicionar(DadoInput dadoInput) {
        return null;
    }

    @Override
    public DadoModel atualizar(Long dadoId, DadoInput dadoInput) {
        return null;
    }

    @Override
    public void remover(Long dadoId) {

    }
}
