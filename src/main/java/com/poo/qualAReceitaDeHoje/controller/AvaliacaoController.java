package com.poo.qualAReceitaDeHoje.controller;

import com.poo.qualAReceitaDeHoje.exception.NotFoundEntityException;
import com.poo.qualAReceitaDeHoje.model.Avaliacao;
import com.poo.qualAReceitaDeHoje.service.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;
    @CrossOrigin(origins="*", allowedHeaders="*")
    @RequestMapping(value="/create", method= RequestMethod.POST)
    public ResponseEntity<Avaliacao> createAvaliacao
            (@RequestBody Avaliacao avaliacao) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(avaliacaoService.createAvaliacao(avaliacao));

    }
    @CrossOrigin(origins="*", allowedHeaders="*")
    @RequestMapping(value="/list", method=RequestMethod.GET)
    public ResponseEntity<List<Avaliacao>> readAvaliacao() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(avaliacaoService.getAllAvaliacoes());

    }
    @CrossOrigin(origins="*", allowedHeaders="*")
    @RequestMapping(value="/update/{avaliacaoId}", method=RequestMethod.PUT)
    public ResponseEntity<Avaliacao> updateAvaliacao(
            @PathVariable(value = "avaliacaoId") Integer id,
            @RequestBody Avaliacao avaliacao) throws ChangeSetPersister.NotFoundException, NotFoundEntityException {
        return ResponseEntity.status(HttpStatus.OK).body(avaliacaoService.updateAvaliacao(id, avaliacao));

    }

    @CrossOrigin(origins="*", allowedHeaders="*")
    @RequestMapping(value="/delete/{avaliacaoId}", method=RequestMethod.DELETE)
    public ResponseEntity<Avaliacao> deleteAvaliacao(
            @PathVariable(value = "avaliacaoId") Integer id) {
        avaliacaoService.deleteAvaliacao(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
