/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.Cliente;
import util.Conexao;

/**
 *
 * @author nato-
 */
public class ClienteControle {

    /**
     * METODO REALIZA A PERSISTENCIA E A ATUALIZAÇÃO DO OBJETO NO BANCO DE
     * DADOS.
     *
     * @param cli
     */
    public void salvarCliente(Cliente cli) {
        EntityManager em = Conexao.getConexao();
        Cliente cliente;
        em.getTransaction().begin();
        cliente = em.merge(cli);
        em.getTransaction().commit();

    }

    /**
     * METODO REALIZA A REMOÇÃAO DO OBJETO DO BANCO DE dADOS.
     *
     * @param cli
     */
    public void removerCiente(Cliente cli) {
        EntityManager em = Conexao.getConexao();
        Cliente cliente;
        em.getTransaction().begin();;
        cliente = em.merge(cli);
        em.remove(cliente);
        em.getTransaction().commit();
    }
     /**
     * METODO RECEBE UMA INSTRUÇÃO JPQL (SQL) E RETORNA OS OBJETOS CORRESPONDENTES
     * @param comando
     * @return 
     */
    public List pesquisarRelease(String comando) {
        EntityManager em = Conexao.getConexao();
        List lista = null;
        em.getTransaction().begin();
        TypedQuery consulta = em.createQuery(comando, Cliente.class);
        lista = consulta.getResultList();
        em.getTransaction().commit();
        return lista;

    }

    /**
     * METODO RETORNA UMA LISTA COM TODOS OS CLIENTES DO BANCO DE DADOS.
     *
     * @return
//     */
   public List listarTodos() {
        EntityManager em = Conexao.getConexao();
        List lista = null;
        em.getTransaction().begin();
        TypedQuery consulta = em.createQuery("Select c FROM Cliente c ", Cliente.class);
        lista = consulta.getResultList();
        em.getTransaction().commit();
        return lista;

    }
    
       public Cliente buscarPorId(int id){
           EntityManager em = Conexao.getConexao();
           Cliente cli = null;
           cli = em.find(Cliente.class, id);
           em.getTransaction().commit();
           return cli;
       }
}
