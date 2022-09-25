package mx.ulsa.dao.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import mx.ulsa.modelo.Rol;
import util.HibernateUtil;

public class RolDAO {

	public void createRol(Rol rol) {
		Transaction transaction = null;
		try (Session session =HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			session.save(rol);
			
			transaction.commit();
		} catch (Exception e) {
			if(transaction !=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	
	public void updateRol(Rol rol) {
		Transaction transaction = null;
		try (Session session =HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			session.update(rol);			
			transaction.commit();
		} catch (Exception e) {
			if(transaction !=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	
	public void deleteRol(Integer id) {
		Transaction transaction = null;
		try (Session session =HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			Rol rol = session.get(Rol.class, id);
			if(rol!=null) {
				session.delete(rol);
			}			
			transaction.commit();
		} catch (Exception e) {
			if(transaction !=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	
	public Rol getRol(Integer id){
		Transaction transaction = null;
		Rol rol = null;
		try (Session session =HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			rol = session.get(Rol.class, id);		
			transaction.commit();
		} catch (Exception e) {
			if(transaction !=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return rol;
	}
	
	public List<Rol> getRols(){
		Transaction transaction = null;
		List<Rol> roles = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			roles = session.createQuery("from Rol").getResultList();	
			transaction.commit();
		} catch (Exception e) {
			if(transaction !=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return roles;
	}
}
