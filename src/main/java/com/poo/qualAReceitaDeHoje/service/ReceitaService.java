package com.poo.qualAReceitaDeHoje.service;


import com.poo.qualAReceitaDeHoje.exception.NotFoundEntityException;
import com.poo.qualAReceitaDeHoje.model.Receita;
import com.poo.qualAReceitaDeHoje.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceitaService {
    @Autowired
    private ReceitaRepository receitaRepository;

    public List<Receita> getAllReceita() {
        return receitaRepository.findAll();
    }

    public Receita getReceitaById(Integer id) throws NotFoundEntityException {
        return receitaRepository.findById(id)
                .orElseThrow(() -> new NotFoundEntityException("Receita não encontrada"));
    }

    public Receita createReceita(Receita receita) {
        return receitaRepository.save(receita);
    }

    public Receita updateReceita(Integer id, Receita receita) throws NotFoundEntityException {
        Receita existingReceita = receitaRepository.findById(id)
                .orElseThrow(() -> new NotFoundEntityException("Receita não encontrada"));
        existingReceita.setNome(receita.getNome());
        existingReceita.setImagem(receita.getImagem());
        existingReceita.setTempodepreparo(receita.getTempodepreparo());
        existingReceita.setPassoapasso(receita.getPassoapasso());
        existingReceita.setQuantidadediversadeitens(receita.getQuantidadediversadeitens());
        existingReceita.setEstilodevida(receita.getEstilodevida());
        existingReceita.setTipoderefeicao(receita.getTipoderefeicao());
        existingReceita.setUsuario(receita.getUsuario());
        return receitaRepository.save(existingReceita);
    }


    public void deleteReceita(Integer id) {
        receitaRepository.deleteById(id);
    }
}
