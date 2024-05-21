package br.com.api.helpdesk.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

public record PatrimonioDto(@NotBlank String nomePatrimonio, @NotNull BigDecimal preco, @NotNull int quantidade, String descricao, @NotNull Date dataCriacao) {

}
