package com.example.SAEP_SIM.DTO;


import com.example.SAEP_SIM.Model.Perfis;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UsuarioDTO(

        @NotNull(message = "Informe qual é o perfil!")
        Perfis perfil,

        @NotBlank(message = "Preencha o nome!")
        String nome,

        @NotBlank(message = "Preencha a senha!")
        String senha
) {
}
