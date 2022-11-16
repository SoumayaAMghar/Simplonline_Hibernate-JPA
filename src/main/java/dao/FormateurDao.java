package dao;


import config.Config;
import entity.Formateur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class FormateurDao {
    public boolean add(Formateur formateur) {
        try {
            EntityManager em = Config.getConfig().getEntityManager();
            em.getTransaction().begin();
            em.persist(formateur);
            em.getTransaction().commit();
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;

    }

    public Formateur findbyId(int id) {
        try {
            EntityManager em = Config.getConfig().getEntityManager();
            return em.find(Formateur.class, id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public boolean update(Formateur formateur) {
        try {

            EntityManager em = Config.getConfig().getEntityManager();
            em.getTransaction().begin();
            em.merge(formateur);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean deleteByID(int id) {
        try {

            EntityManager em = Config.getConfig().getEntityManager();
            em.getTransaction().begin();
            Formateur formateur = em.find(Formateur.class, id);
            em.remove(formateur);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public List<Formateur> getAll() {
        try {

            EntityManager em = Config.getConfig().getEntityManager();

            Query query = em.createQuery("SELECT f FROM Formateur f");

            return query.getResultList();

//            em.getTransaction().begin();
//            TypedQuery<Formateur> query = em.createQuery("SELECT f FROM Formateur f", Formateur.class);
//            List<Formateur> list = query.getResultList();
//            em.getTransaction().commit();
//            System.out.println(list.get(0).getEmail());
//            return list;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
