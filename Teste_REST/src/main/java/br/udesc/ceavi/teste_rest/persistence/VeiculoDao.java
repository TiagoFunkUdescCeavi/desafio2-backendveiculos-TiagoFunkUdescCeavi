package br.udesc.ceavi.teste_rest.persistence;

import br.udesc.ceavi.teste_rest.model.Veiculo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class VeiculoDao extends DAOGenerico{
    
    public static List<Veiculo> listar(){
        EntityManagerFactory emf = 
                javax.persistence.Persistence.createEntityManagerFactory(NOME_PU );
        EntityManager em = emf.createEntityManager();
        return em.createQuery( "SELECT v FROM Veiculo v").getResultList();
    }
    
    public static List<Veiculo> buscarComFiltro( String filtro ){
        EntityManagerFactory emf = 
                javax.persistence.Persistence.createEntityManagerFactory(NOME_PU );
        EntityManager em = emf.createEntityManager();
        return em.createQuery( "SELECT v FROM Veiculo v WHERE " + filtro ).getResultList();
    }
}
