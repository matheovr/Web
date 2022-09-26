/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author User
 */

@Entity
@Table
@NamedQueries(
@NamedQuery(name = "Computador.getAll", query = "SELECT e FROM Computador e"))
public class Computador implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int computadorId;
    @Column
    private String board;
    @Column
    private String procesador;
    @Column
    private String gpu;
    @Column
    private String memoria;
    @Column
    private String monitor;

    public Computador(int computadorId, String board, String procesador, String gpu, String memoria, String monitor) {
        this.computadorId = computadorId;
        this.board = board;
        this.procesador = procesador;
        this.gpu = gpu;
        this.memoria = memoria;
        this.monitor = monitor;
    }
    
    public Computador(){
        
    }

    public int getComputadorId() {
        return computadorId;
    }

    public void setComputadorId(int computadorId) {
        this.computadorId = computadorId;
    }

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getMemoria() {
        return memoria;
    }

    public void setMemoria(String memoria) {
        this.memoria = memoria;
    }

    public String getMonitor() {
        return monitor;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }
    
    
}