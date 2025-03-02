package com.gerenciador.esig.dao;

import com.gerenciador.esig.model.Tarefa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List;
import java.util.logging.Logger;


public class TarefaDAO {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gerenciadorPU");

    private static final Logger logger = Logger.getLogger(TarefaDAO.class.getName());


    public void salvar(Tarefa tarefa) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(tarefa);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback(); // em caso de erro, desfaz as alterações
            logger.severe("Erro ao salvar a tarefa: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public void atualizar(Tarefa tarefa) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(tarefa);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            logger.severe("Erro ao atualizar a tarefa: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public void remover(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Tarefa tarefa = em.find(Tarefa.class, id);
            if (tarefa != null) {
                em.remove(tarefa);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            logger.severe("Erro ao remover a tarefa: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public List<Tarefa> listarTodas() {
        EntityManager em = emf.createEntityManager();
        try {
            // cria uma consulta JPQL
            TypedQuery<Tarefa> query = em.createQuery("SELECT t FROM Tarefa t", Tarefa.class);
            return query.getResultList(); // retorna a lista de todas as tarefas encontradas
        } finally {
            em.close();
        }
    }

    public Tarefa buscarPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Tarefa.class, id);
        } finally {
            em.close();
        }
    }

}
