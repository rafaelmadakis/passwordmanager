package br.com.password.manager.api.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@ApiModel("DadoModel")
@Relation(collectionRelation = "dados")
@Setter
@Getter
public class DadoModel extends RepresentationModel<DadoModel> {

    @ApiModelProperty(example = "1")
    private Long idDado;

    @ApiModelProperty(example = "Stefanini - Nova intranet")
    private String sistema;

    @ApiModelProperty(example = "rmadakis")
    private String usuario;

    @ApiModelProperty(example = "C!elo_2020")
    private String senha;
}
