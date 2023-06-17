package com.poo.qualAReceitaDeHoje.repository;

import com.poo.qualAReceitaDeHoje.enumeradores.EstiloDeVida;
import com.poo.qualAReceitaDeHoje.enumeradores.TipoDeRefeicao;
import com.poo.qualAReceitaDeHoje.model.Receita;
import com.poo.qualAReceitaDeHoje.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    Usuario findByConta(String conta);
}
