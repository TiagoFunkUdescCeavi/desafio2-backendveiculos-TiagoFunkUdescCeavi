package br.udesc.ceavi.teste_rest.persistence;

import br.udesc.ceavi.teste_rest.model.Fornecedor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class FornecedorDAO extends DAOGenerico{
    
    public static List<Fornecedor> listar(){
        EntityManagerFactory emf = 
                javax.persistence.Persistence.createEntityManagerFactory( nomePU );
        EntityManager em = emf.createEntityManager();
        return em.createQuery( "SELECT f FROM Fornecedor f").getResultList();
    }
}
