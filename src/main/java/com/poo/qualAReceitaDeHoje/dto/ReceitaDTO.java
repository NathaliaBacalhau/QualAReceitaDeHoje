package com.poo.qualAReceitaDeHoje.dto;
import com.poo.qualAReceitaDeHoje.enumeradores.EstiloDeVida;
import com.poo.qualAReceitaDeHoje.enumeradores.TipoDeRefeicao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReceitaDTO{
    private Integer id;
    private String nome;
    private String imagem;
    private String tempodepreparo;
    private String passoapasso;
    private Integer quantidadediversadeitens;
    private EstiloDeVida estilodevida;
    private TipoDeRefeicao tipoderefeicao;
    private String conta;
}
