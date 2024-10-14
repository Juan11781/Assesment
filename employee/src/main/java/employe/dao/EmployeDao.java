package employe.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

import employe.dto.EmployeDTO;
import employe.entity.Employe;

public class EmployeDao extends Actions<Employe> {
	
		
public List<EmployeDTO> getAll() {
		
		SessionFactory sessionFactory = getSessionFactory();
		Session  session = 	sessionFactory.openSession();
		Transaction t = session.beginTransaction();
	
		Criteria criteria = session.createCriteria(Employe.class,"employe");		
	    criteria.setProjection(Projections.projectionList()	    		
	    		.add(Projections.property("employe.id").as("id"))
	    		.add(Projections.property("employe.nombre"  ).as("nombre")));
	   
	    	 

	    criteria.setResultTransformer(Transformers.aliasToBean(EmployeDTO.class));
	    List<EmployeDTO> lstEmploye =  criteria.list();
	    t.commit();
	  	session.close();
	    return lstEmploye;
	}



public EmployeDTO getById(Long id) {
SessionFactory sessionFactory = getSessionFactory();
Session  session = 	sessionFactory.openSession();
Transaction t = session.beginTransaction();

Criteria criteria = session.createCriteria(Employe.class,"employe");		
criteria.setProjection(Projections.projectionList()	    		
		.add(Projections.property("employe.id").as("id"))
		.add(Projections.property("employe.nombre"  ).as("nombre")));

criteria.add(Restrictions.eq("prestamo.id", id));

criteria.setResultTransformer(Transformers.aliasToBean(EmployeDTO.class));
EmployeDTO employe =  (EmployeDTO)criteria.uniqueResult();
t.commit();
	session.close();
return employe;
}

	
}
                              