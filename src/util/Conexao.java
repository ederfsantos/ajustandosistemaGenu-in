/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Brasil
 */
public class Conexao {

    private static EntityManagerFactory emf = null;

    /**
     * METODO REALIZA UMA CONEXAO COM O BANCO DE DADOS.
     * @return 
     */
    public static EntityManager getConexao() {

        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("Genu-inprestacaoservicoPU");

        }
        return emf.createEntityManager();

    }

}
