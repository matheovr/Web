/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.dao;

import com.model.Computador;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author User
 */
@Stateless
public class ComputadorDao implements ComputadorDaoLocal {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addComputador(Computador computador) {
        em.persist(computador);
    }

    @Override
    public void editComputador(Computador computador) {
        em.merge(computador);
    }

    @Override
    public void deleteComputador(int computadorId) {
        em.remove(getComputador(computadorId));
    }

    @Override
    public Computador getComputador(int computadorId) {
        return em.find(Computador.class, computadorId);
    }

    @Override
    public List<Computador> getAllComputadores() {
        return em.createNamedQuery("Computador.getAll").getResultList();
    }
}
