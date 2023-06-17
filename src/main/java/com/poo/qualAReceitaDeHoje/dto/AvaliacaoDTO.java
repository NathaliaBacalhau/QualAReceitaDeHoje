package com.poo.qualAReceitaDeHoje.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AvaliacaoDTO {
    private Integer id;
    private String comentario;
    private double nota;
    private String usuario_conta;
    private Integer receita_id;
}
