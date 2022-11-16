package dao;


import config.Config;
import entity.Brief;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class BriefDao {
    public boolean add(Brief brief){
        try {
            EntityManager em= Config.getConfig().getEntityManager();
            em.getTransaction().begin();
            em.persist(brief);
            em.getTransaction().commit();
            return false;
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return false;

    }
    public Brief findbyId(int id){
        try{

            EntityManager em = Config.getConfig().getEntityManager();
            em.getTransaction().begin();
            Brief brief = em.find(Brief.class, id);
            em.getTransaction().commit();
            return brief;
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        return null;
    }
    public boolean update(Brief brief)
    {
        try{

            EntityManager em = Config.getConfig().getEntityManager();
            em.getTransaction().begin();
            em.merge(brief);
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
            Brief brief = em.find(Brief.class, id);
            em.remove(brief);
            em.getTransaction().commit();
            return true;
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public List<Brief> getAll()
    {
        try{

            EntityManager em = Config.getConfig().getEntityManager();

            em.getTransaction().begin();
            TypedQuery<Brief> query = em.createQuery("SELECT b FROM Brief b", Brief.class);
            List<Brief> list = query.getResultList();
            em.getTransaction().commit();
            return list;
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
