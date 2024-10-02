/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Brasil
 */
@Entity
@Table(name = "prestarservico")
public class Prestarservico implements Serializable {

    @Id // indicando o indentificador da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prestarservico", nullable = false)
    private Integer prestarservico;

    @Id
    @ManyToOne
    @JoinColumn(name = " idcliente", referencedColumnName = "idcliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "idfuncionario", referencedColumnName = "idfuncionario")
    private Funcionario funcionario;

    @Temporal(TemporalType.DATE)
    @Column(name = "data")
    private Date data;

    @Temporal(TemporalType.TIME)
    @Column(name = "horario")
    private Date horario;
    @Column(name = "descricao", length = 200)
    private String descricao;
    @Column(name = "valor")
    private Float valor;
   
   

    public Prestarservico() {
    }

    public Prestarservico(Integer prestarservico, Cliente cliente, Funcionario funcionario, Date data, Date horario, String descricao, Float valor) {
        this.prestarservico = prestarservico;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.data = data;
        this.horario = horario;
        this.descricao = descricao;
        this.valor = valor;
       
    }

   

  public Cliente localizarCliente(String nome) {
        Iterable<Cliente> clientes = null;
        for (Cliente c : clientes) {
            if (c.getNome().equals(nome)) {
                return c;
            }

        }
        return null;
    }

    public void setPrestarservico(Integer prestarservico) {
        this.prestarservico = prestarservico;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

 
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.prestarservico);
        hash = 53 * hash + Objects.hashCode(this.data);
        hash = 53 * hash + Objects.hashCode(this.descricao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Prestarservico other = (Prestarservico) obj;
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
      
        if (!Objects.equals(this.prestarservico, other.prestarservico)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        return true;
    }

  
    

          
}
