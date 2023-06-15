package com.poo.qualAReceitaDeHoje.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Usuario {
    private String nome;
    private String email;
    private String senha;
    @Id
    private String conta;

    @OneToMany(mappedBy = "usuario")
    private List<Receita> receitas;

   @OneToMany(mappedBy="usuario")
    private List<Avaliacao> avaliacoes;


}
