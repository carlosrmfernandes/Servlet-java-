/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author carlosfernandes
 */
public class Agendamento {

    protected int id;
    protected String nome;
    protected String rne;
    protected String codigo;
    protected String dataAgendamento;

    public Agendamento(String nome, String rne, String codigo, String dataAgendamento) {
        super();
        this.nome = nome;
        this.rne = rne;
        this.codigo = codigo;
        this.dataAgendamento = dataAgendamento;
    }

    public Agendamento(int id, String nome, String rne, String codigo, String dataAgendamento) {
        super();
        this.id = id;
        this.nome = nome;
        this.rne = rne;
        this.codigo = codigo;
        this.dataAgendamento = dataAgendamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRne() {
        return rne;
    }

    public void setRne(String rne) {
        this.rne = rne;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(String dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

}
