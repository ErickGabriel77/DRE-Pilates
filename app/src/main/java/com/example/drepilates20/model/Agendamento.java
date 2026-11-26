
package com.example.drepilates20.model;

public class Agendamento {

    private int id;
    private Aluno aluno;
    private String data;
    private String horario;
    private String modalidade;
    private String status;

    public Agendamento(int id, Aluno aluno, String data,
                       String horario, String modalidade) {
        this.id = id;
        this.aluno = aluno;
        this.data = data;
        this.horario = horario;
        this.modalidade = modalidade;
        this.status = "AGENDADO";
    }

    public int getId() {
        return id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public String getData() {
        return data;
    }

    public String getHorario() {
        return horario;
    }

    public String getModalidade() {
        return modalidade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
