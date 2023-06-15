package com.poo.qualAReceitaDeHoje.controller;

import com.poo.qualAReceitaDeHoje.exception.NotFoundEntityException;
import com.poo.qualAReceitaDeHoje.model.Receita;
import com.poo.qualAReceitaDeHoje.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/receita")
public class ReceitaController {

    @Autowired
    private ReceitaService receitaService;

    @CrossOrigin(origins="*", allowedHeaders="*")
    @RequestMapping(value="/create", method= RequestMethod.POST)
    public ResponseEntity<Receita> createReceita
            (@RequestBody Receita receita) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(receitaService.createReceita(receita));

    }
    @CrossOrigin(origins="*", allowedHeaders="*")
    @RequestMapping(value="/list", method=RequestMethod.GET)
    public ResponseEntity<List<Receita>> readReceita() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(receitaService.getAllReceita());

    }
    @CrossOrigin(origins="*", allowedHeaders="*")
    @RequestMapping(value="/update/{receitaId}", method=RequestMethod.PUT)
    public ResponseEntity<Receita> updateReceita(
            @PathVariable(value = "receitaId") Integer id,
            @RequestBody Receita receita) throws ChangeSetPersister.NotFoundException, NotFoundEntityException {
        return ResponseEntity.status(HttpStatus.OK).body(receitaService.updateReceita(id, receita));

    }
    @CrossOrigin(origins="*", allowedHeaders="*")
    @RequestMapping(value="/delete/{receitaId}", method=RequestMethod.DELETE)
    public ResponseEntity<Receita> deleteReceita(
            @PathVariable(value = "receitaId") Integer id) {
        receitaService.deleteReceita(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
