package com.javachess.dao;

import com.javachess.persistencyData.Log_xadrez;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.Time;
import java.util.Date;

public class LogXadrezDAO {
    private static EntityManagerFactory emf;
    // inicia a instância do banco
    public static void initialize() {
        emf = Persistence.createEntityManagerFactory("Log_xadrez");
    }

    public static void addLogXadrez(Date dataPartida, String peca, int saidaX, int saidaY, int chegadaX, int chegadaY, Time horaJogada) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Log_xadrez log = new Log_xadrez();
            //log.setId(id); não é necessário atribuir o ID pois ele é SERIAL
            log.setData_partida(dataPartida);
            log.setPeca(peca);
            log.setSaida_x(saidaX);
            log.setSaida_y(saidaY);
            log.setChegada_x(chegadaX);
            log.setChegada_y(chegadaY);
            log.setHora_jogada(horaJogada);

            em.persist(log); // realiza um insert no banco

            tx.commit(); // faz um commit da transação
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }
    // finaliza a instância do banco
    public static void close() {
        emf.close();
    }
}
