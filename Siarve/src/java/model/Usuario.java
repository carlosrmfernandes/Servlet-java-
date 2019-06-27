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
public class Usuario {

    protected int id;
    protected String name;
    protected String email;
    protected String setor;
    protected String senha;

    public Usuario() {
    }

    public Usuario(String name, String email, String setor, String senha) {
        super();
        this.name = name;
        this.email = email;
        this.setor = setor;
        this.senha = senha;
    }

    public Usuario(int id, String name, String email, String setor, String senha) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.setor = setor;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
