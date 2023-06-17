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
    @RequestMapping(value="/create", method={RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE})
    public ResponseEntity<String> createAvaliacaoError() {
        String message = "O método deve ser post.";
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED)
                .body(message);

    }

    @CrossOrigin(origins="*", allowedHeaders="*")
    @RequestMapping(value="/list", method=RequestMethod.GET)
    public ResponseEntity<List<Avaliacao>> readAvaliacao() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(avaliacaoService.getAllAvaliacoes());
    }

    @CrossOrigin(origins="*", allowedHeaders="*")
    @RequestMapping(value="/list", method={RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
    public ResponseEntity<String> readAvaliacaoError() {
        String message = "O método deve ser get.";
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED)
                .body(message);
    }

    @CrossOrigin(origins="*", allowedHeaders="*")
    @RequestMapping(value="/update/{avaliacaoId}", method=RequestMethod.PUT)
    public ResponseEntity<Avaliacao> updateAvaliacao(
            @PathVariable(value = "avaliacaoId") Integer id,
            @RequestBody Avaliacao avaliacao) throws ChangeSetPersister.NotFoundException, NotFoundEntityException {
        return ResponseEntity.status(HttpStatus.OK).body(avaliacaoService.updateAvaliacao(id, avaliacao));

    }

    @CrossOrigin(origins="*", allowedHeaders="*")
    @RequestMapping(value="/update/{avaliacaoId}", method={RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
    public ResponseEntity<String> updateAvaliacaoError(){
        String message = "O método deve ser put.";
            return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(message);

    }

    @CrossOrigin(origins="*", allowedHeaders="*")
    @RequestMapping(value="/delete/{avaliacaoId}", method=RequestMethod.DELETE)
    public ResponseEntity<Avaliacao> deleteAvaliacao(
            @PathVariable(value = "avaliacaoId") Integer id) throws NotFoundEntityException {
        avaliacaoService.deleteAvaliacao(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @CrossOrigin(origins="*", allowedHeaders="*")
    @RequestMapping(value="/delete/{avaliacaoId}", method= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<String> deleteAvaliacaoError(){
        String message = "O método deve ser delete.";
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(message);
    }
}
