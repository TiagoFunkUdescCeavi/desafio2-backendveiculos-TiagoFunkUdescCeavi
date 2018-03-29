package br.udesc.ceavi.teste_rest.persistence;

import br.udesc.ceavi.teste_rest.model.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class ClienteDAO extends DAOGenerico{
    
    public static List<Cliente> listar(){
        EntityManagerFactory emf = 
                javax.persistence.Persistence.createEntityManagerFactory( nomePU );
        EntityManager em = emf.createEntityManager();
        return em.createQuery( "SELECT c FROM Cliente c").getResultList();
    }
}
