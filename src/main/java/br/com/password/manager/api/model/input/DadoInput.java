package br.com.password.manager.api.model.input;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;


@ApiModel("DadoInput")
@Setter
@Getter
public class DadoInput {

    @ApiModelProperty(example = "Stefanini - nova Intranet", required = true)
    @NotBlank
    private String sistema;

    @ApiModelProperty(example = "rmadakis", required = true)
    @NotBlank
    private String usuario;

    @ApiModelProperty(example = "C!elo_2020", required = true)
    @NotBlank
    private String senha;
}
