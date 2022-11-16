package dao;

import config.Config;
import entity.Apprenant;
import entity.Promostoapprenant;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class PromostoapprenantDao {
    public boolean add(Promostoapprenant promostoapprenant)
    {
        try{
            EntityManager em = Config.getConfig().getEntityManager();
            em.getTransaction().begin();
            em.persist(promostoapprenant);
            em.getTransaction().commit();
            return true;
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public Promostoapprenant findbyId(int id)
    {
        try{

            EntityManager em = Config.getConfig().getEntityManager();
            return em.find(Promostoapprenant.class, id);
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public boolean update(Promostoapprenant promostoapprenant)
    {
        try{

            EntityManager em = Config.getConfig().getEntityManager();
            em.getTransaction().begin();
            em.merge(promostoapprenant);
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
            Promostoapprenant promostoapprenant = em.find(Promostoapprenant.class, id);
            em.remove(promostoapprenant);
            em.getTransaction().commit();
            return true;
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public List<Promostoapprenant> getAll()
    {
        try{

            EntityManager em = Config.getConfig().getEntityManager();

            em.getTransaction().begin();
            TypedQuery<Promostoapprenant> query = em.createQuery("SELECT a FROM Promostoapprenant a", Promostoapprenant.class);
            List<Promostoapprenant> list = query.getResultList();
            em.getTransaction().commit();
            return list;
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
