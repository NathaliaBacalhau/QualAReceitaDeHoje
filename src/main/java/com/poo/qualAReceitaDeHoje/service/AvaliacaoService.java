package com.poo.qualAReceitaDeHoje.service;


import com.poo.qualAReceitaDeHoje.exception.NotFoundEntityException;
import com.poo.qualAReceitaDeHoje.model.Avaliacao;
import com.poo.qualAReceitaDeHoje.model.Usuario;
import com.poo.qualAReceitaDeHoje.repository.AvaliacaoRepository;
import com.poo.qualAReceitaDeHoje.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvaliacaoService {
    @Autowired
    private AvaliacaoRepository avaliacaoRepository;
    //@Autowired
    //UsuarioRepository usuarioRepository;

    public List<Avaliacao> getAllAvaliacoes() {
        return avaliacaoRepository.findAll();
    }

    public Avaliacao getAvaliacaoById(Integer id) throws NotFoundEntityException {
        return avaliacaoRepository.findById(id)
                .orElseThrow(() -> new NotFoundEntityException("Avaliação não encontrado"));
    }

    public Avaliacao createAvaliacao(Avaliacao avaliacao) {
        return avaliacaoRepository.save(avaliacao);
    }

    public Avaliacao updateAvaliacao(Integer id, Avaliacao avaliacao) throws NotFoundEntityException {

        Avaliacao existingAvaliacao = avaliacaoRepository.findById(id)
                .orElseThrow(() -> new NotFoundEntityException("Avaliacao não encontrado"));

        existingAvaliacao.setComentario(avaliacao.getComentario());
        existingAvaliacao.setNota(avaliacao.getNota());
        //Usuario existingUsuario = usuarioRepository.findByConta(avaliacao.getUsuario());
        existingAvaliacao.setUsuario(avaliacao.getUsuario());
        existingAvaliacao.setReceita(avaliacao.getReceita());
        //Usuario existingUsuario = usuarioRepository.findByConta(avaliacao.getUsuario();
        //existingAvaliacao.setUsuario(existingUsuario);
        return avaliacaoRepository.save(existingAvaliacao);
    }

    public void deleteAvaliacao(Integer id)  throws NotFoundEntityException {
        Avaliacao existingAvaliacao = avaliacaoRepository.findById(id)
                .orElseThrow(() -> new NotFoundEntityException("Avaliacao não encontrado"));
        avaliacaoRepository.deleteById(id);
    }
}
