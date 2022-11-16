package dao;

import config.Config;
import entity.Admin;
import entity.Apprenant;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ApprenantDao {

    public boolean add(Apprenant apprenant)
    {
        try{
            EntityManager em = Config.getConfig().getEntityManager();
            em.getTransaction().begin();
            em.persist(apprenant);
            em.getTransaction().commit();
            return true;
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public Apprenant findbyId(int id)
    {
        try{

            EntityManager em = Config.getConfig().getEntityManager();
            return em.find(Apprenant.class, id);
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        return null;
    }
    public int findEmail(String email)
    {
        try{
            EntityManager em = Config.getConfig().getEntityManager();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT a FROM Apprenant a where a.email=:email", Apprenant.class).setParameter("email",email);
            Apprenant apprenant = (Apprenant) query.getSingleResult();
            em.getTransaction().commit();
            if(apprenant!=null){
                return apprenant.getId();
            }

        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        return 0;
    }

    public boolean update(Apprenant apprenant)
    {
        try{

            EntityManager em = Config.getConfig().getEntityManager();
            em.getTransaction().begin();
            em.merge(apprenant);
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
            Apprenant apprenant = em.find(Apprenant.class, id);
            em.remove(apprenant);
            em.getTransaction().commit();
            return true;
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public List<Apprenant> getAll()
    {
        try{

            EntityManager em = Config.getConfig().getEntityManager();

            em.getTransaction().begin();
            TypedQuery<Apprenant> query = em.createQuery("SELECT a FROM Apprenant a", Apprenant.class);
            List<Apprenant> list = query.getResultList();
            em.getTransaction().commit();
            return list;
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
