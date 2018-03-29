package br.udesc.ceavi.teste_rest.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class DAOGenerico {
    
    protected final static String NOME_PU = "Teste_REST_PU";
    
    public static void salvar(Object object){
        EntityManagerFactory emf = 
                javax.persistence.Persistence.createEntityManagerFactory(NOME_PU );
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        } 
    }
    
    public static Object ler(Class classe, long id){
        EntityManagerFactory emf = 
                javax.persistence.Persistence.createEntityManagerFactory(NOME_PU );
        EntityManager em = emf.createEntityManager();
        Object obj = null;
        em.getTransaction().begin();
        try {
            obj = em.find( classe, id );
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return obj;
    }
    
    public static void update(Object object){
        EntityManagerFactory emf = 
                javax.persistence.Persistence.createEntityManagerFactory(NOME_PU );
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.merge(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        } 
    }
}
