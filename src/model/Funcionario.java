/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author nato-
 */
@Entity
@Table(name = "funcionario")
public class Funcionario  implements Serializable{
    
    @Id // indica o indentificador da tela
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "idfuncionario",nullable = false)
    
    private Integer idFuncionario; 
    
    @Column(name = "nome",length = 30, nullable = false)
    private String nome;
    
    @Column(name ="telefone",length = 20 )
    private String telefone;

    public Funcionario() {
    }

    public Funcionario(Integer idFuncionario, String nome, String telefone) {
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.telefone = telefone;
    }
    
    

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "idFuncionario=" + idFuncionario + ", nome=" + nome + ", telefone=" + telefone + '}';
    }
    
    
    
}
