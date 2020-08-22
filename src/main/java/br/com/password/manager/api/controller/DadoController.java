package br.com.password.manager.api.controller;

import br.com.password.manager.api.assembler.DadoInputDisassembler;
import br.com.password.manager.api.assembler.DadoModelAssembler;
import br.com.password.manager.api.model.DadoModel;
import br.com.password.manager.api.model.input.DadoInput;
import br.com.password.manager.api.openapi.DadoControllerOpenApi;
import br.com.password.manager.domain.model.Dado;
import br.com.password.manager.domain.repository.DadoRepository;
import br.com.password.manager.domain.service.CadastroDadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/dados", produces = MediaType.APPLICATION_JSON_VALUE)
public class DadoController implements DadoControllerOpenApi {


    @Autowired
    private DadoRepository dadoRepository;

    @Autowired
    private CadastroDadoService cadastroDado;

    @Autowired
    private DadoInputDisassembler dadoInputDisassembler;

    @Autowired
    private DadoModelAssembler dadoModelAssembler;

     @Autowired
    private PagedResourcesAssembler<Dado> pagedResourcesAssembler;


    @GetMapping
    public CollectionModel<DadoModel> listar() {
        List<Dado> todosDados = dadoRepository.findAll();

        return dadoModelAssembler.toCollectionModel(todosDados);

    }


    @Override
    @GetMapping("/{dadoId}")
    public DadoModel buscar(@PathVariable Long dadoId) {

        Dado dado = cadastroDado.buscarOuFalhar(dadoId);

        return dadoModelAssembler.toModel(dado);
    }

    @Override
    @PostMapping
    public DadoModel adicionar(@RequestBody DadoInput dadoInput) {
        Dado dado = dadoInputDisassembler.toDomainObject(dadoInput);
        dado = cadastroDado.salvar(dado);

        return dadoModelAssembler.toModel(dado);
    }


    @Override
    public DadoModel atualizar(Long dadoId, DadoInput dadoInput) {
        return null;
    }



//    @Override
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public DadoModel adicionar(@RequestBody @Valid DadoInput dadoInput) {
//
//        Dado dado = dadoInputDisassembler.toDomainObject(dadoInput);
//        dado = cadastroDado.salvar(dado);
//
//        return dadoModelAssembler.toModel(dado);
//    }
//
//    @Override
//    @PutMapping("/{dadoId}")
//    public DadoModel atualizar(@PathVariable Long dadoId,
//                               @RequestBody @Valid DadoInput dadoInput) {
//
//        Dado dadoAtual = cadastroDado.buscarOuFalhar(dadoId);
//        dadoInputDisassembler.copyToDomainObject(dadoInput, dadoAtual);
//        dadoAtual = cadastroDado.salvar(dadoAtual);
//
//        return dadoModelAssembler.toModel(dadoAtual);
//    }

    @Override
    @DeleteMapping("/{dadoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long dadoId) {
        cadastroDado.exluir(dadoId);
    }
}
