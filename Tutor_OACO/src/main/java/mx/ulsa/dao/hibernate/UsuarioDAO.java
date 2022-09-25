package mx.ulsa.dao.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import mx.ulsa.modelo.Usuario;
import util.HibernateUtil;

public class UsuarioDAO {

	public boolean saveUsuario(Usuario usuario) {
		boolean exito = false;
		Transaction transaction = null;
		try(Session session =  HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(usuario);
			transaction.commit();
			exito=true;
		} catch (Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return exito;
	}
	
	public void updateUsuario(Usuario usuario) {		
		Transaction transaction = null;
		try(Session session =  HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.update(usuario);
			transaction.commit();
		} catch (Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	
	public void deleteUsuario(Integer id) {		
		Transaction transaction = null;
		try(Session session =  HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Usuario usuario = session.get(Usuario.class, id);
			if(usuario!=null) {
				session.delete(usuario);
			}
			transaction.commit();
		} catch (Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	
	public Usuario getUsuario(int id) {
		Transaction transaction = null;
		Usuario usuario = null;
		try(Session session =  HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			usuario = session.get(Usuario.class, id);			
			transaction.commit();
		} catch (Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return usuario;
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> getUsuarios(){
		Transaction transaction = null;
		List<Usuario> usuario = null;
		try(Session session =  HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			usuario = session.createQuery("from Usuario").getResultList();			
			transaction.commit();
		} catch (Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return usuario;
	}
	
	public Usuario getUsuarioByCorreoAndPassword(String correo, String password) {
		Transaction transaction = null;
		Usuario usuario = null;
		try(Session session =  HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			usuario = (Usuario)session.
					createQuery("from Usuario where correo= :param_correo and "
							+ "password= :param_pass").
					setParameter("param_correo", correo).
					setParameter("param_pass", password).uniqueResult();		
			transaction.commit();
		} catch (Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return usuario;
	}
	
	public Boolean getUsuarioByCorreo(String correo){
		Transaction transaction = null;
		Boolean usuario = false;
		try(Session session =  HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();		
			Usuario u = (Usuario)session.createQuery("from Usuario where correo= :param_correo").setParameter("param_correo", correo).uniqueResult();
			
			if(u!=null) {
				usuario=true;
			}			
			transaction.commit();			
		} catch (Exception e) {
			if(transaction!=null) {				
				transaction.rollback();
			}
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return usuario;
	}
	
	
}
