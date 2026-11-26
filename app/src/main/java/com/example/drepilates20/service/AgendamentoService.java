
package com.example.drepilates20.service;

import com.example.drepilates20.model.Agendamento;
import com.example.drepilates20.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AgendamentoService {

    private final List<Agendamento> agendamentos = new ArrayList<>();

    public boolean agendar(Agendamento novo) {

        if (novo == null) {
            return false;
        }

        if (novo.getAluno() == null || !novo.getAluno().isAtivo()) {
            return false;
        }

        if (novo.getData() == null || novo.getData().trim().isEmpty()) {
            return false;
        }

        if (novo.getHorario() == null || novo.getHorario().trim().isEmpty()) {
            return false;
        }

        if (novo.getModalidade() == null || novo.getModalidade().trim().isEmpty()) {
            return false;
        }

        for (Agendamento existente : agendamentos) {

            if (existente.getData().equals(novo.getData())
                    && existente.getHorario().equals(novo.getHorario())
                    && existente.getStatus().equals("AGENDADO")) {
                return false;
            }
        }

        agendamentos.add(novo);
        return true;
    }

    public boolean cancelar(int id) {

        for (Agendamento agendamento : agendamentos) {

            if (agendamento.getId() == id
                    && agendamento.getStatus().equals("AGENDADO")) {

                agendamento.setStatus("CANCELADO");
                return true;
            }
        }

        return false;
    }

    public List<Agendamento> listarTodos() {
        return new ArrayList<>(agendamentos);
    }
}
