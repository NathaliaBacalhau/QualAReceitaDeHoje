package com.poo.qualAReceitaDeHoje.model;

import com.poo.qualAReceitaDeHoje.enumeradores.EstiloDeVida;
import com.poo.qualAReceitaDeHoje.enumeradores.TipoDeRefeicao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.util.List;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //gerada automaticamente
    private Integer id;
    private String nome;
    private String imagem;
    private String tempodepreparo;
    private String passoapasso;
    private Integer quantidadediversadeitens;
    private EstiloDeVida estilodevida;
    private TipoDeRefeicao tipoderefeicao;


    @ManyToOne
    @JoinColumn(name = "usuario_conta")
    private Usuario usuario;

    @OneToMany(mappedBy = "receita")
    private List<Avaliacao> avaliacoes;

    @OneToMany(mappedBy = "receita")
    private List<Item> itens;

}
