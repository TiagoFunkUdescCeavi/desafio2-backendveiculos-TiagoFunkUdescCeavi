package br.udesc.ceavi.teste_rest.persistence;

import br.udesc.ceavi.teste_rest.model.Produto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class ProdutoDAO extends DAOGenerico {
    
    public static List<Produto> listar(){
        EntityManagerFactory emf = 
                javax.persistence.Persistence.createEntityManagerFactory( nomePU );
        EntityManager em = emf.createEntityManager();
        return em.createQuery( "SELECT p FROM Produto p").getResultList();
    }
}
