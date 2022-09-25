package mx.ulsa.dao.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import mx.ulsa.modelo.Producto;
import util.HibernateUtil;

public class ProductoDAO {
	public void createProducto(Producto prodcuto) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			session.save(prodcuto);
			
			transaction.commit();
		} catch (Exception e) {
			if(transaction !=null) {
				transaction.rollback();
			}
			
			e.printStackTrace();
		}
	}
	
	public void updateProducto(Producto producto) {
		Transaction transaction = null;
		try (Session session =HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			session.update(producto);			
			transaction.commit();
		} catch (Exception e) {
			if(transaction !=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	
	public void deleteProducto(Integer id) {
		Transaction transaction = null;
		try (Session session =HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			Producto producto = session.get(Producto.class, id);
			if(producto!=null) {
				session.delete(producto);
			}			
			transaction.commit();
		} catch (Exception e) {
			if(transaction !=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	
	public Producto getProducto(Integer id){
		Transaction transaction = null;
		Producto producto = null;
		try (Session session =HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			producto = session.get(Producto.class, id);		
			transaction.commit();
		} catch (Exception e) {
			if(transaction !=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return producto;
	}
	
	public List<Producto> getProductos(){
		Transaction transaction = null;
		List<Producto> producto = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			producto = session.createQuery("from Producto").getResultList();	
			transaction.commit();
		} catch (Exception e) {
			if(transaction !=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return producto;
	}
}
