package com.gerenciador.esig.bean;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import java.util.List;
import com.gerenciador.esig.model.Tarefa;
import com.gerenciador.esig.dao.TarefaDAO;

@Named
@RequestScoped
public class TarefaBean {
    private Tarefa tarefa = new Tarefa();
    private List<Tarefa> tarefas;
    private final TarefaDAO tarefaDAO = new TarefaDAO();

    public TarefaBean() {
        tarefas = tarefaDAO.listarTodas();
    }

    public void salvar() {
        tarefaDAO.salvar(tarefa);
        tarefa = new Tarefa();
        tarefas = tarefaDAO.listarTodas();
    }

    // getters e setters
    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }
}