package br.udesc.ceavi.teste_rest.persistence;

import br.udesc.ceavi.teste_rest.model.Veiculo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class ModeloDao extends DAOGenerico{
    
    public static List<Veiculo> listar(){
        EntityManagerFactory emf = 
                javax.persistence.Persistence.createEntityManagerFactory(NOME_PU );
        EntityManager em = emf.createEntityManager();
        return em.createQuery( "SELECT m FROM Modelo m ").getResultList();
    }
}
