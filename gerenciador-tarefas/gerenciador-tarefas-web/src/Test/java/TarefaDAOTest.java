package com.gerenciador.esig;

import com.gerenciador.esig.dao.TarefaDAO;
import com.gerenciador.esig.model.Tarefa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TarefaDAOTest {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static TarefaDAO tarefaDAO;

    @BeforeAll
    public static void setUp() {
        // Inicializando o EntityManager e o TarefaDAO
        entityManagerFactory = Persistence.createEntityManagerFactory("gerenciadorPU");
        entityManager = entityManagerFactory.createEntityManager();
        tarefaDAO = new TarefaDAO(entityManager);
    }

    @Test
    public void testSalvarTarefa() {
        Tarefa tarefa = new Tarefa();
        tarefa.setDescricao("Estudar JPA");
        tarefa.setStatus("Pendente");

        tarefaDAO.salvar(tarefa);

        assertNotNull(tarefa.getId(), "A tarefa não foi salva corretamente.");
    }

    @AfterAll
    public static void tearDown() {
        if (entityManager != null) {
            entityManager.close();
        }
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }
}
