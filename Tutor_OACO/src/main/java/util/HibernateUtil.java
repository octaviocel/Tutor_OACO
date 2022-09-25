package util;



import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import mx.ulsa.modelo.Persona;
import mx.ulsa.modelo.Producto;
import mx.ulsa.modelo.Rol;
import mx.ulsa.modelo.Usuario;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();
				
				Properties setting = new Properties();
				setting.put(Environment.DRIVER, "org.postgresql.Driver");
				setting.put(Environment.URL, "jdbc:postgresql://localhost:5432/db_tutor");
				setting.put(Environment.USER, "administrador");
				setting.put(Environment.PASS, "123");
				setting.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
				
				setting.put(Environment.SHOW_SQL, "true");
				
				setting.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				
				setting.put(Environment.HBM2DDL_AUTO, "update"); //update   create-drop
				
				configuration.setProperties(setting);
				configuration.addAnnotatedClass(Rol.class);				
				configuration.addAnnotatedClass(Persona.class);	
				configuration.addAnnotatedClass(Usuario.class);
				configuration.addAnnotatedClass(Producto.class);
				
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				
				System.out.println("Hibernate Java Config service Registry Creado");
				sessionFactory =  configuration.buildSessionFactory(serviceRegistry);
				
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
		return sessionFactory;
	}
}
