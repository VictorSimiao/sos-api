package br.com.victorreis.sosapi.domain.exception;

public class OrdemServicoNaoEncontradaException extends EntidadeNaoEncontradaException{

    public OrdemServicoNaoEncontradaException(String mensagem) {
        super(mensagem);
    }

    public OrdemServicoNaoEncontradaException(Long id) {
        this(String.format("Não existe uma ordem de serviço cadastrada com código %d", id));
    }

}
