
package com.poo.qualAReceitaDeHoje.dto;
import com.poo.qualAReceitaDeHoje.enumeradores.GrupoAlimentar;
import com.poo.qualAReceitaDeHoje.enumeradores.UnidadeDeMedida;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDTO {
    private Integer id;
    private double quantidade;
    private GrupoAlimentar grupoalimentar;
    private UnidadeDeMedida unidadedemedida;
    private String nome;
    private Integer receita_id;
}
