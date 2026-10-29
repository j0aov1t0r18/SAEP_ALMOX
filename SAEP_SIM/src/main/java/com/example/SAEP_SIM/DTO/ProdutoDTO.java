package com.example.SAEP_SIM.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProdutoDTO(

        @NotBlank(message = "Preencha o nome do produto!")
         String nome,
        @NotNull(message = "Preencha a quantidade!")
         Integer quantidade
) {
}
