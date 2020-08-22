package br.com.password.manager.api.openapi;

import br.com.password.manager.api.model.DadoModel;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.hateoas.Links;

import java.util.List;

@ApiModel("DadosModel")
@Data
public class DadosModelOpenApi {

    private DadosEmbeddedModelOpenApi _embedded;
    private Links _links;

    public class DadosEmbeddedModelOpenApi {
        private List<DadoModel> dados;
    }

}
