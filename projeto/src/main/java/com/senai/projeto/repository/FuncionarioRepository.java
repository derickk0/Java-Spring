package com.senai.projeto.repository;

import com.senai.projeto.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    Funcionario findByMatricula(String matricula);
}
