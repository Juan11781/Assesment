package employe.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.metamodel.Metadata;
import org.hibernate.metamodel.MetadataSources;

public abstract class Actions<T>  {
	
	private static SessionFactory sessionFactory;
	public Actions() {}
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
		    Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		    sessionFactory = meta.getSessionFactoryBuilder().build(); 
		   }
		return sessionFactory;  
	}
	
	
	public void save(T object) {		

		SessionFactory sessionFactory = getSessionFactory();
		Session  session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		session.save(object);
		t.commit();
		session.close();
		
	}


	public void delete(T object) {		
		
		SessionFactory sessionFactory = getSessionFactory();
		Session  session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		session.delete(object);
		t.commit();
		session.close();
		
	}

	public void update(T object) {
		
	
		SessionFactory sessionFactory = getSessionFactory();
		Session  session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		session.update(object);
		t.commit();
		session.close();
		
	}
}
