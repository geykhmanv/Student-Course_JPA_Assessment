package jpa.dao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AbstractDAO {
	
	private static EntityManagerFactory emf = null;
	protected static EntityManager em = null;
	private final static String PERSISTENCE_UNIT_NAME = "SMS";
	
	protected static void connectToDB() {
		emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em = emf.createEntityManager();
		
//		System.out.println(em.isOpen() ? "Connected" : "Not Connected");
		
	}//protected void connectToDB() 
	
	protected static void dispose() {
		em.close();
		emf.close();
	}//protected void dispose()
		

}//public class AbstractDAO
