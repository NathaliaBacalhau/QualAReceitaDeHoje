package com.poo.qualAReceitaDeHoje.repository;

import com.poo.qualAReceitaDeHoje.enumeradores.EstiloDeVida;
import com.poo.qualAReceitaDeHoje.enumeradores.TipoDeRefeicao;
import com.poo.qualAReceitaDeHoje.model.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Integer> {

    List<Receita> findByTipoderefeicaoAndEstilodevida(TipoDeRefeicao tipoderefeicao, EstiloDeVida estilodevida);
    List<Receita> findByTipoderefeicaoAndTempodepreparo(TipoDeRefeicao tipoderefeicao, String tempodepreparo);
    List<Receita> findByEstilodevidaAndTempodepreparo(EstiloDeVida estilodevida, String tempodepreparo);
    List<Receita> findByTipoderefeicaoAndEstilodevidaAndTempodepreparo(TipoDeRefeicao tipoderefeicao,EstiloDeVida estilodevida, String tempodepreparo);

    long countByNome(String nome);
    void deleteById(Integer id);
    boolean existsByNome(String nome);

    /* FAZER
    @Modifying
    @Query("SELECT * from Receita where ")
    int updateEmailById(Long id, String email);

     List<Receita> findByNome(String nome);
    List<Receita> findByTipoderefeicao(TipoDeRefeicao tipoderefeicao);
    List<Receita> findByRecestilodevida(estilodevida estilodevida);
    List<Receita> findByTempodepreparo(String tempodepreparo);
     */
}
