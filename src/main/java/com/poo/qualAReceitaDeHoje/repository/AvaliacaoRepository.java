package com.poo.qualAReceitaDeHoje.repository;


import com.poo.qualAReceitaDeHoje.model.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Integer> {
    List<Avaliacao> findByNota(double nota);

    void deleteById(Integer id);
     /*
    FAZER
    @Modifying
    @Query("SELECT * from Avaliacao where ")
    int updateEmailById(Long id, String email);

     */
}

