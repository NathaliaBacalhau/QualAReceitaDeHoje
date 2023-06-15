
package com.poo.qualAReceitaDeHoje.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Avaliacao {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String comentario;
    private double nota;


    @ManyToOne
    @JoinColumn(name="usuario_conta")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name="receita_id")
    private Receita receita;



}

