package com.poo.qualAReceitaDeHoje.controller;

import com.poo.qualAReceitaDeHoje.exception.NotFoundEntityException;
import com.poo.qualAReceitaDeHoje.model.Usuario;
import com.poo.qualAReceitaDeHoje.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    @CrossOrigin(origins="*", allowedHeaders="*")
    @RequestMapping(value="/create", method= RequestMethod.POST)
    public ResponseEntity<Usuario> createUsuario
            (@RequestBody Usuario usuario) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(usuarioService.createUsuario(usuario));
    }
    @CrossOrigin(origins="*", allowedHeaders="*")
    @RequestMapping(value="/create", method= {RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE})
    public ResponseEntity<String> createUsuarioError
            (@RequestBody Usuario usuario) {
    String message = "O método deve ser post.";
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED)
                .body(message);
    }

    @CrossOrigin(origins="*", allowedHeaders="*")
    @RequestMapping(value="/list", method=RequestMethod.GET)
    public ResponseEntity<List<Usuario>> readUsuario() {

        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED)
                .body(usuarioService.getAllUsuarios());

    }

    @CrossOrigin(origins="*", allowedHeaders="*")
    @RequestMapping(value="/list", method={RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
    public ResponseEntity<String> readUsuarioError() {
        String message = "O método deve ser get.";
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED)
                .body(message);
    }


    @CrossOrigin(origins="*", allowedHeaders="*")
    @RequestMapping(value="/update/{usuarioConta}", method=RequestMethod.PUT)
    public ResponseEntity<Usuario> updateUsuario(
            @PathVariable(value = "usuarioConta") String conta,
            @RequestBody Usuario usuario) throws ChangeSetPersister.NotFoundException, NotFoundEntityException {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.updateUsuario(conta, usuario));
    }

    @CrossOrigin(origins="*", allowedHeaders="*")
    @RequestMapping(value="/update/{usuarioConta}", method={RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
    public ResponseEntity<String> updateUsuarioError(){
            String message = "O método deve ser put.";
            return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(message);
    }


    @CrossOrigin(origins="*", allowedHeaders="*")
    @RequestMapping(value="/delete/{conta}", method=RequestMethod.DELETE)
    public ResponseEntity<Usuario> deleteUsuario(
            @PathVariable(value = "conta") String conta) {
        usuarioService.deleteUsuario(conta);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @CrossOrigin(origins="*", allowedHeaders="*")
    @RequestMapping(value="/delete/{conta}", method={RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<Usuario> deleteUsuarioError(){
        String message = "O método deve ser delete.";
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(null);
    }
}
