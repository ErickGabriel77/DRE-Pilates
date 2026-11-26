
package com.example.drepilates20.service;

import com.example.drepilates20.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoService {

    private final List<Aluno> alunos = new ArrayList<>();

    public boolean cadastrar(Aluno aluno) {

        if (aluno == null) {
            return false;
        }

        if (aluno.getNome() == null || aluno.getNome().trim().isEmpty()) {
            return false;
        }

        if (aluno.getTelefone() == null || aluno.getTelefone().trim().isEmpty()) {
            return false;
        }

        if (aluno.getEmail() == null || !aluno.getEmail().contains("@")) {
            return false;
        }

        for (Aluno existente : alunos) {
            if (existente.getId() == aluno.getId()
                    || existente.getEmail().equalsIgnoreCase(aluno.getEmail())) {
                return false;
            }
        }

        alunos.add(aluno);
        return true;
    }

    public Aluno buscarPorId(int id) {

        for (Aluno aluno : alunos) {
            if (aluno.getId() == id) {
                return aluno;
            }
        }

        return null;
    }

    public List<Aluno> listarTodos() {
        return new ArrayList<>(alunos);
    }

    public boolean desativar(int id) {

        Aluno aluno = buscarPorId(id);

        if (aluno == null || !aluno.isAtivo()) {
            return false;
        }

        aluno.setAtivo(false);
        return true;
    }
}
