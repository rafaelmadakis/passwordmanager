package br.com.password.manager.core;

import br.com.password.manager.api.model.input.DadoInput;
import br.com.password.manager.domain.model.Dado;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        var modelmapper = new ModelMapper();

        modelmapper.createTypeMap(DadoInput.class, Dado.class)
                .addMappings(mapper -> mapper.skip(Dado :: setId));

        return modelmapper;
    }
}
