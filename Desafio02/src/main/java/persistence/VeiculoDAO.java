package persistence;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import model.Veiculo;

public class VeiculoDAO extends DAOGenerico{
    
    public static List< Veiculo > ordenarVeiculos(){
        EntityManagerFactory emf = 
                javax.persistence.Persistence.createEntityManagerFactory( nomePU );
        EntityManager em = emf.createEntityManager();
        return em.createQuery("SELECT v FROM Veiculo v").getResultList();
    }
}
