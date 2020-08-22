package exception;

public class DadoNaoEncontradoException extends EntidadeNaoEncontradaException  {

    public DadoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public DadoNaoEncontradoException(Long dadoId) {

        this(String.format("Não existe um dado com o código %d ", dadoId));
    }
}
