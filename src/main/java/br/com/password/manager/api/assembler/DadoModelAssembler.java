package br.com.password.manager.api.assembler;

import br.com.password.manager.api.PasswordLinks;
import br.com.password.manager.api.controller.DadoController;
import br.com.password.manager.api.model.DadoModel;
import br.com.password.manager.domain.model.Dado;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Component
public class DadoModelAssembler
        extends RepresentationModelAssemblerSupport<Dado, DadoModel> {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordLinks passwordLinks;


    public DadoModelAssembler() {
        super(DadoController.class, DadoModel.class);
    }

    @Override
    public DadoModel toModel(Dado dado) {

        DadoModel dadoModel = createModelWithId(dado.getId(), dado);

        modelMapper.map(dado, dadoModel);

        dadoModel.add(passwordLinks.linkToDados("dados"));


        return dadoModel;
    }

    @Override
    public CollectionModel<DadoModel> toCollectionModel(Iterable<? extends Dado> entities) {
        return super.toCollectionModel(entities)
                .add(linkTo(DadoController.class).withSelfRel());
    }
}
