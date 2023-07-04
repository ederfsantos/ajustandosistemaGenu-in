/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.Prestarservico;
import util.Conexao;

/**
 *
 * @author Brasil
 */
public class ServicoControle {

    public static Collection<?> listarTodos;

    /**
     * METODO REALIZA A PERSISTENCIA E A ATUALIZAÇÃO DO OBJETO NO BANCO DE
     * DADOS.
     *
     * @param s
     */
    public void salvarPrestarServico(Prestarservico s) {
        EntityManager em = Conexao.getConexao();
        Prestarservico prestarservico;
        em.getTransaction().begin();
        prestarservico = em.merge(s);
        em.getTransaction().commit();

    }

    /**
     * METODO REALIZA A REMOÇÃO DO OBJETO DO BANCO DE DADOS.
     *
     * @param s
     */
    public void removerPrestarServico(Prestarservico s) {
        EntityManager em = Conexao.getConexao();
        Prestarservico prestarservico;
        em.getTransaction().begin();
        prestarservico = em.merge(s);
        em.remove(prestarservico);
        em.getTransaction().commit();
    }

    /**
     * METODO RETORNA UMA LISTA COM TODOS AS AGENDAS DO BANCO DE DADOS.
     *
     * @return
     */
    public List listarTodos() {
        EntityManager em = Conexao.getConexao();
        List lista = null;
        em.getTransaction().begin();
        //TypedQuery consulta = em.createQuery("Select f FROM Funcionario f where f.status='ATIVO'", Funcionario.class);
        TypedQuery consulta = em.createQuery("Select a FROM Prestarservico a ", Prestarservico.class);
        lista = consulta.getResultList();
        em.getTransaction().commit();
        return lista;

    }

    /**
     * METODO RECEBE UM ID E RETORNA O OBJETO CORRESPONDENTE.
     *
     * @param id
     * @return
     */
    public Prestarservico buscarPorId(int id) {
        EntityManager em = Conexao.getConexao();
        Prestarservico s = null;
        em.getTransaction().begin();
        s = em.find(Prestarservico.class, id);
        em.getTransaction().commit();
        return s;
    }

    /**
     * METODO RECEBE UMA INSTRUÇÃO JPQL (SQL) E RETORNA OS OBJETOS
     * CORRESPONDENTES
     *
     * @param comando
     * @return
     */
    public List pesquisarRelease(String comando) {
        EntityManager em = Conexao.getConexao();
        List lista = null;
        em.getTransaction().begin();
        TypedQuery consulta = em.createQuery(comando, Prestarservico.class);
        lista = consulta.getResultList();
        em.getTransaction().commit();
        return lista;

    }
/**
 * Metodo recebe duas datas e realiza a consulta no banco de dados
 * dentro do intervalo informado.
 * @param inicio
 * @param fim
 * @return 
 */
    public List consultarPeriodo(Date inicio, Date fim) {
        EntityManager em = Conexao.getConexao();
        List lista = null;
        try {
            em.getTransaction().begin();
            //Select c from Caixa c where c.dataCaixa between :x and :y
            TypedQuery consulta = em.createQuery("Select p from Prestarservico  p where p.data between :x and :y order by p.data", Prestarservico.class);
            consulta.setParameter("x", inicio);
            consulta.setParameter("y", fim);
            lista = consulta.getResultList();
            em.getTransaction().commit();
            return lista;
        } catch (Exception e) {
            System.out.println("Erro ao consultar o periodo! " + e);
        }
        return null;
    }
}
