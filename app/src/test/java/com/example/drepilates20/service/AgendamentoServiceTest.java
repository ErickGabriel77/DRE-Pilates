
package com.example.drepilates20.service;

import com.example.drepilates20.model.Agendamento;
import com.example.drepilates20.model.Aluno;

import org.junit.Test;

import static org.junit.Assert.*;

public class AgendamentoServiceTest {

    @Test
    public void agendar_agendamentoValido_retornaTrue() {
        // Arrange
        AgendamentoService service = new AgendamentoService();
        Aluno aluno = new Aluno(1, "Maria", "61999999999", "maria@email.com");
        Agendamento agendamento = new Agendamento(
                1, aluno, "27/11/2026", "09:00", "Pilates"
        );

        // Act
        boolean resultado = service.agendar(agendamento);

        // Assert
        assertTrue(resultado);
    }

    @Test
    public void agendar_agendamentoNulo_retornaFalse() {
        // Arrange
        AgendamentoService service = new AgendamentoService();

        // Act
        boolean resultado = service.agendar(null);

        // Assert
        assertFalse(resultado);
    }

    @Test
    public void agendar_alunoInativo_retornaFalse() {
        // Arrange
        AgendamentoService service = new AgendamentoService();
        Aluno aluno = new Aluno(1, "Maria", "61999999999", "maria@email.com");
        aluno.setAtivo(false);

        Agendamento agendamento = new Agendamento(
                1, aluno, "27/11/2026", "09:00", "Pilates"
        );

        // Act
        boolean resultado = service.agendar(agendamento);

        // Assert
        assertFalse(resultado);
    }

    @Test
    public void agendar_dataVazia_retornaFalse() {
        // Arrange
        AgendamentoService service = new AgendamentoService();
        Aluno aluno = new Aluno(1, "Maria", "61999999999", "maria@email.com");
        Agendamento agendamento = new Agendamento(
                1, aluno, "", "09:00", "Pilates"
        );

        // Act
        boolean resultado = service.agendar(agendamento);

        // Assert
        assertFalse(resultado);
    }

    @Test
    public void agendar_horarioDuplicado_retornaFalse() {
        // Arrange
        AgendamentoService service = new AgendamentoService();
        Aluno aluno = new Aluno(1, "Maria", "61999999999", "maria@email.com");

        Agendamento primeiro = new Agendamento(
                1, aluno, "27/11/2026", "09:00", "Pilates"
        );

        Agendamento segundo = new Agendamento(
                2, aluno, "27/11/2026", "09:00", "Pilates"
        );

        service.agendar(primeiro);

        // Act
        boolean resultado = service.agendar(segundo);

        // Assert
        assertFalse(resultado);
    }

    @Test
    public void cancelar_agendamentoExistente_retornaTrue() {
        // Arrange
        AgendamentoService service = new AgendamentoService();
        Aluno aluno = new Aluno(1, "Maria", "61999999999", "maria@email.com");
        Agendamento agendamento = new Agendamento(
                1, aluno, "27/11/2026", "09:00", "Pilates"
        );
        service.agendar(agendamento);

        // Act
        boolean resultado = service.cancelar(1);

        // Assert
        assertTrue(resultado);
        assertEquals("CANCELADO", agendamento.getStatus());
    }

    @Test
    public void cancelar_idInexistente_retornaFalse() {
        // Arrange
        AgendamentoService service = new AgendamentoService();

        // Act
        boolean resultado = service.cancelar(99);

        // Assert
        assertFalse(resultado);
    }
    @Test
    public void agendar_dataNula_retornaFalse() {
        AgendamentoService service = new AgendamentoService();
        Aluno aluno = new Aluno(1, "Maria", "61999999999", "maria@email.com");

        Agendamento agendamento = new Agendamento(
                1, aluno, null, "09:00", "Pilates"
        );

        boolean resultado = service.agendar(agendamento);

        assertFalse(resultado);
    }

    @Test
    public void agendar_horarioVazio_retornaFalse() {
        AgendamentoService service = new AgendamentoService();
        Aluno aluno = new Aluno(1, "Maria", "61999999999", "maria@email.com");

        Agendamento agendamento = new Agendamento(
                1, aluno, "27/11/2026", "", "Pilates"
        );

        boolean resultado = service.agendar(agendamento);

        assertFalse(resultado);
    }

    @Test
    public void agendar_modalidadeVazia_retornaFalse() {
        AgendamentoService service = new AgendamentoService();
        Aluno aluno = new Aluno(1, "Maria", "61999999999", "maria@email.com");

        Agendamento agendamento = new Agendamento(
                1, aluno, "27/11/2026", "09:00", ""
        );

        boolean resultado = service.agendar(agendamento);

        assertFalse(resultado);
    }

}

