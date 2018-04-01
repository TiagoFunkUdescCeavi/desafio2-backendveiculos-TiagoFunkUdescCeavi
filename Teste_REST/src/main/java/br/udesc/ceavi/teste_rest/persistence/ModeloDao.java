package br.udesc.ceavi.teste_rest.persistence;

import br.udesc.ceavi.teste_rest.model.Modelo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class ModeloDao extends DAOGenerico{
    
    public static List<Modelo> listar(){
        EntityManagerFactory emf = 
                javax.persistence.Persistence.createEntityManagerFactory(NOME_PU );
        EntityManager em = emf.createEntityManager();
        return em.createQuery( "SELECT m FROM Modelo m ").getResultList();
    }

    public static void excluir(long id ) {
        EntityManagerFactory emf = 
                javax.persistence.Persistence.createEntityManagerFactory( NOME_PU );
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createQuery( "DELETE FROM Modelo m WHERE m.id = " + id ).executeUpdate();
    }
}
