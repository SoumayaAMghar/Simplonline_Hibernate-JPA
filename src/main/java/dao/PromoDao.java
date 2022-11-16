package dao;

import config.Config;
import entity.Promos;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class PromoDao {
    public boolean add(Promos promos){
        EntityManager em = Config.getConfig().getEntityManager();
        em.getTransaction().begin();
        em.persist(promos);
        em.getTransaction().commit();
        return true;
    }
    public Promos findbyId(int id){
        try{

            EntityManager em = Config.getConfig().getEntityManager();
            return em.find(Promos.class, id);
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        return null;
    }
    public boolean update(Promos promos)
    {
        try{

            EntityManager em = Config.getConfig().getEntityManager();
            em.getTransaction().begin();
            em.merge(promos);
            em.getTransaction().commit();
            return true;
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }
    public boolean deleteByID(int id)
    {
        try{

            EntityManager em = Config.getConfig().getEntityManager();
            em.getTransaction().begin();
            Promos promos = em.find(Promos.class, id);
            em.remove(promos);
            em.getTransaction().commit();
            return true;
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public List<Promos> getAll()
    {
        try{

            EntityManager em = Config.getConfig().getEntityManager();

            em.getTransaction().begin();
            TypedQuery<Promos> query = em.createQuery("SELECT p FROM Promos p", Promos.class);
            List<Promos> list = query.getResultList();
            em.getTransaction().commit();
            return list;
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public List<Promos> getAllNulls() {
        try {
            EntityManager em = Config.getConfig().getEntityManager();
            em.getTransaction().begin();
                TypedQuery<Promos> query = em.createQuery("SELECT a FROM Promos a WHERE a.formateurId is NULL", Promos.class);
            List<Promos> promoList = query.getResultList();
            em.getTransaction().commit();
            return promoList;
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public Promos findByFormateurId(int id) {
        try {
            EntityManager em = Config.getConfig().getEntityManager();
            TypedQuery<Promos> query = em.createQuery("SELECT a FROM Promos a WHERE a.formateurId = " + id, Promos.class);
            Promos promo = query.getSingleResult();
            return promo;
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}

