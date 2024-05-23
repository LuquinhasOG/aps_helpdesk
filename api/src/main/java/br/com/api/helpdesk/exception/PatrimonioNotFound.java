package br.com.api.helpdesk.exception;

public class PatrimonioNotFound extends RuntimeException{
    public PatrimonioNotFound() {
        super("Patrimônio não foi encontrado.");
    }
    public PatrimonioNotFound(String mensagem) {
        super(mensagem);
    }
}
