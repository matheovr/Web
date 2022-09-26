/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package com.dao;

import com.model.Computador;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author User
 */
@Local
public interface ComputadorDaoLocal {
    void addComputador(Computador computador);
    void editComputador(Computador computador);
    void deleteComputador(int computadorId);
    Computador getComputador(int computadorId);
    List<Computador> getAllComputadores();
}
