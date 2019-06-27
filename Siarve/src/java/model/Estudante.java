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
public class Estudante {

    protected int id;
    protected String nome;
    protected String rne;
    protected String passaport;
    protected String pais;
    protected String endereco_atual;
    protected String data_entrada;


    public Estudante(String nome, String rne, String passaport, String pais, String endereco_atual, String data_entrada) {
        super();
        this.nome = nome;
        this.rne = rne;
        this.passaport = passaport;
        this.pais = pais;
        this.endereco_atual = endereco_atual;
        this.data_entrada = data_entrada;
    }

    public Estudante(int id, String nome, String rne, String passaport, String pais, String endereco_atual, String data_entrada) {
        super();
        this.id = id;
        this.nome = nome;
        this.rne = rne;
        this.passaport = passaport;
        this.pais = pais;
        this.endereco_atual = endereco_atual;
        this.data_entrada = data_entrada;
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

    public String getPassaport() {
        return passaport;
    }

    public void setPassaport(String passaport) {
        this.passaport = passaport;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEndereco_atual() {
        return endereco_atual;
    }

    public void setEndereco_atual(String endereco_atual) {
        this.endereco_atual = endereco_atual;
    }

    public String getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(String data_entrada) {
        this.data_entrada = data_entrada;
    }

}
