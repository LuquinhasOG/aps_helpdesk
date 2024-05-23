package br.com.api.helpdesk.exception;

import org.springframework.stereotype.Component;

@Component
public class IdPatrimonioBadRequest extends RuntimeException{
    public IdPatrimonioBadRequest() {
        super("ID do Patrimônio está incorreto ou não existe.");
    }
    public IdPatrimonioBadRequest(String mensagem) {
        super(mensagem);
    }
}
