package br.udesc.ceavi.teste_rest.persistence;

import br.udesc.ceavi.teste_rest.model.Veiculo;
import static br.udesc.ceavi.teste_rest.persistence.DAOGenerico.nomePU;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class VeiculoDao extends DAOGenerico{
    
    public static List<Veiculo> listar(){
        EntityManagerFactory emf = 
                javax.persistence.Persistence.createEntityManagerFactory( nomePU );
        EntityManager em = emf.createEntityManager();
        return em.createQuery( "SELECT v FROM Veiculo v").getResultList();
    }
    
    public static void excluir( long id ){
        EntityManagerFactory emf = 
                javax.persistence.Persistence.createEntityManagerFactory( nomePU );
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("DELETE FROM Veiculo v WHERE V.id = " + id);
        query.executeUpdate();
    }
}
