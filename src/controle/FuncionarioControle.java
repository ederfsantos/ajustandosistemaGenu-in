/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.Funcionario;
import util.Conexao;

/**
 *
 * @author nato-
 */
public class FuncionarioControle {

    /**
     * METODO REALIZA A PERSISTENCIA E A ATUALIZAÇÃO DO OBJETO NO BANCO DE
     * DADOS.
     *
     * @param fun
     */
    public void salvarFuncionario(Funcionario fun) {
        EntityManager em = Conexao.getConexao();
        Funcionario funcionario;
        em.getTransaction().begin();
        funcionario = em.merge(fun);
        em.getTransaction().commit();

    }
       public List pesquisarRelease(String comando) {
        EntityManager em = Conexao.getConexao();
        List lista = null;
        em.getTransaction().begin();
        TypedQuery consulta = em.createQuery(comando, Funcionario.class);
        lista = consulta.getResultList();
        em.getTransaction().commit();
        return lista;

    }

    /**
     * METODO REALIZA A REMOÇÃAO DO OBJETO DO BANCO DE dADOS.
     *
     * @param fun
     */
    public void removerFuncionario(Funcionario fun) {
        EntityManager em = Conexao.getConexao();
        Funcionario funcionario;
        em.getTransaction().begin();;
        funcionario = em.merge(fun);
        em.remove(funcionario);
        em.getTransaction().commit();
    }

    /**
     * METODO RETORNA UMA LISTA COM TODOS OS CLIENTES DO BANCO DE DADOS.
     *
     * @return //
     */
    public List listarTodos() {
        EntityManager em = Conexao.getConexao();
        List lista = null;
        em.getTransaction().begin();
        TypedQuery consulta = em.createQuery("Select f FROM Funcionario f ", Funcionario.class);
        lista = consulta.getResultList();
        em.getTransaction().commit();
        return lista;

    }

    public Funcionario buscarPorId(int id) {
        EntityManager em = Conexao.getConexao();
        Funcionario fun = null;
        fun = em.find(Funcionario.class, id);
        em.getTransaction().commit();
        return fun;
    }
}
