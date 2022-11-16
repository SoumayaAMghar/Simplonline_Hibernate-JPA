package dao;
import config.Config;
import entity.Admin;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class AdminDao {
    public List<Admin> getAll()
    {
        try{
            EntityManager em = Config.getConfig().getEntityManager();
            em.getTransaction().begin();
            TypedQuery<Admin> query = em.createQuery("SELECT a FROM Admin a", Admin.class);
            List<Admin> list = query.getResultList();
            em.getTransaction().commit();
            return list;
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public Admin login(String email , String password){
        try{
            EntityManager em = Config.getConfig().getEntityManager();
            em.getTransaction().begin();
//            TypedQuery<Admin> query = em.createQuery("SELECT a FROM Admin a where a.email =: email", Admin.class).setParameter("email",email);
//            Admin admin = (Admin) query.getResultList();
            Query query = em.createQuery("SELECT a FROM Admin a where a.email =: email").setParameter("email",email);
            Admin admin = (Admin) query.getSingleResult();
            em.getTransaction().commit();

            if(admin.getPassword().equals(password)){
                return admin;
            }
            return null;

        }catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public long nbOfApprenant(){
        try {

            EntityManager em = Config.getConfig().getEntityManager();
            em.getTransaction().begin();

            Long nbApprenant = em.createQuery("SELECT COUNT(a) FROM Apprenant a", Long.class).getSingleResult();
            em.getTransaction().commit();
            return nbApprenant;
            }catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
            return 0;
             }
    public long nbOfFormateur(){
        try {

            EntityManager em = Config.getConfig().getEntityManager();

            em.getTransaction().begin();

            Long nbFormateur = em.createQuery("SELECT COUNT(f) FROM Formateur f", Long.class).getSingleResult();
            em.getTransaction().commit();
            return nbFormateur;
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return 0;
    }
    public long nbOfPromotion(){
        try {

            EntityManager em = Config.getConfig().getEntityManager();

            em.getTransaction().begin();

            Long nbPromotion = em.createQuery("SELECT COUNT(p) FROM Promos p", Long.class).getSingleResult();
            em.getTransaction().commit();
            return nbPromotion;
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return 0;
    }
}
