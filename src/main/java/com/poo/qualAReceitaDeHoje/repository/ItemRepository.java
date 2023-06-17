package com.poo.qualAReceitaDeHoje.repository;

import com.poo.qualAReceitaDeHoje.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {



    /*
    FAZER
     List<Item> findByRecId(Integer recId);

    @Modifying
    @Query("SELECT * from Item where ")
    int updateEmailById(Long id, String email);

     */

}

