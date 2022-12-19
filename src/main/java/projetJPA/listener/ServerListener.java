package projetJPA.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import projetJPA.util.JpaContext;



public class ServerListener implements ServletContextListener {

	public ServerListener() {
		
	}
	
	public void contextDestroyed(ServletContextEvent sce) {
		JpaContext.DestroyJpaContext();
	}
	
	public void contextInitialized(ServletContextEvent sce) {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JpaContext.getEntityManagerFactory();
	}
	
	
	
}
