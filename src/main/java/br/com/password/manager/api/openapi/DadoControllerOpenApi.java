package br.com.password.manager.api.openapi;

import br.com.password.manager.api.exceptionhandler.Problem;
import br.com.password.manager.api.model.DadoModel;
import br.com.password.manager.api.model.input.DadoInput;
import io.swagger.annotations.*;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Api(tags = "Dados")
public interface DadoControllerOpenApi {

    @ApiOperation("Lista as cidades")
    public CollectionModel<DadoModel> listar();

    @ApiOperation("busca de um dado por ID")
    @ApiResponses({
            @ApiResponse(code = 400, message = "ID do dado inválido", response = Problem.class),
            @ApiResponse(code = 404, message = "Dado não encontrado", response = Problem.class)
    })
    public DadoModel buscar(@ApiParam(value = "ID de um dado", example = "1", required = true)
                                    Long dadoId);

    @ApiOperation("Cadastra um dado")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Dado Cadastrado")
    })
    public DadoModel adicionar(@ApiParam(name = "corpo", value = "Representação de um novo dado",
            required = true)
                                            DadoInput dadoInput);

    @ApiOperation("Atualiza uma cidade por ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Dado atualizado"),
            @ApiResponse(code = 404, message = "Dado não encontrada", response = Problem.class)
    })
    public DadoModel atualizar(@ApiParam(value = "ID de um dado", example = "1")
                                       Long dadoId,
                               @ApiParam(name = "corpo", value = "Representação de um novo dado com novas informações",
                                       required = true)
                                        DadoInput dadoInput);

    @ApiOperation("Exclui um dado")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Dado excluído"),
            @ApiResponse(code = 404, message = "Dado não encontrada", response = Problem.class)
    })
    void remover(@ApiParam(value = "ID de um dado", example = "1", required = true)
                                Long dadoId);


}
