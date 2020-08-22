package br.com.password.manager.api.assembler;

import br.com.password.manager.api.model.input.DadoInput;
import br.com.password.manager.domain.model.Dado;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DadoInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Dado toDomainObject(DadoInput dadoInput) {
        return modelMapper.map(dadoInput, Dado.class);
    }

    public void copyToDomainObject(DadoInput dadoInput, Dado dado) {

        // Para evitar org.hibernate.HibernateException: identifier of an instance of
        // com.algaworks.algafood.domain.model.Estado was altered from 1 to 2
//        cidade.setEstado(new Estado());

        modelMapper.map(dadoInput, dado);

    }
}
