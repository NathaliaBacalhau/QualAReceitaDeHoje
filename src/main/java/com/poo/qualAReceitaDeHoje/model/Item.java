
package com.poo.qualAReceitaDeHoje.model;

import com.poo.qualAReceitaDeHoje.enumeradores.GrupoAlimentar;
import com.poo.qualAReceitaDeHoje.enumeradores.UnidadeDeMedida;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private double quantidade;
    private GrupoAlimentar grupoalimentar;
    private UnidadeDeMedida unidadedemedida;
    private String nome;

    @ManyToOne
    @JoinColumn(name="receita_id")
    private Receita receita;


}


