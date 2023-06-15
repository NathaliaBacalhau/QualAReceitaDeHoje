package com.poo.qualAReceitaDeHoje.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioDTO{
    private String nome;
    private String email;
    private String senha;
    private String conta;

}


