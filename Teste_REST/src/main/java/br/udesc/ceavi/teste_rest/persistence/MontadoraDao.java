package br.udesc.ceavi.teste_rest.persistence;

import br.udesc.ceavi.teste_rest.model.Montadora;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class MontadoraDao extends DAOGenerico{
    
    public static List<Montadora> listar(){
        EntityManagerFactory emf = 
                javax.persistence.Persistence.createEntityManagerFactory(NOME_PU );
        EntityManager em = emf.createEntityManager();
        return em.createQuery( "SELECT m FROM Montadora m").getResultList();
    }
}
