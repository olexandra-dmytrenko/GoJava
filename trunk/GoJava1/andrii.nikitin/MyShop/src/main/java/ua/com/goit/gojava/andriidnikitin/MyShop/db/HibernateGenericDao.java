package ua.com.goit.gojava.andriidnikitin.MyShop.db;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import ua.com.goit.gojava.andriidnikitin.MyShop.db.util.MyShopDaoException;


public abstract class HibernateGenericDao <T> implements GenericDao<T> {
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public abstract Class<T> getType();
	

	public Integer create(T o) {
		 SessionFactory factory = getSessionFactory();
		 Session session = factory.openSession();
		 Integer result = createInstance(o, session);
		 session.close();
		 return result;
	}
	
	public T read(Integer id) {
		SessionFactory factory = getSessionFactory();
		Session session = factory.openSession();
		T result = retrieveInstance(id, session);
		session.close();
		return result;
	}
	
	public void update(T object) {
		SessionFactory factory =  getSessionFactory();
		Session session = factory.openSession();
		updateInstance(object, session);
		session.close();
	}
	
	public void delete(T object) {
		SessionFactory factory =  getSessionFactory();
		Session session = factory.openSession();
		deleteInstance(object, session);
		session.close();
	}
	
	public List<T> getAll(){
		SessionFactory factory =  getSessionFactory();
		Session session = factory.openSession();
		List<T> result = retrieveAllInstances(session);
		session.close();
		return result;
	}	
	
	public List<T> getFilteringByName(String query) throws MyShopDaoException {
		List<T> all = getAll();
		List<T> result = new ArrayList<T>();
		for (int i = 0; i < all.size(); i++) {
	          T good = all.get(i);
	          if(getName(good).toLowerCase().startsWith(query)) {
	        	  result.add(good);
	          }
		}      
		return result;
	}
	
	private Integer createInstance(T object, Session session) {
		Transaction transaction = session.beginTransaction();
		Integer result =  (Integer) session.save(object);	 
		transaction.commit();
		return result;
	}	
	
	private T retrieveInstance(Integer id, Session session) {
		Transaction transaction = session.beginTransaction();
		@SuppressWarnings("unchecked")
		T result =  (T) session.get(getType(), id);	 
		transaction.commit();
		return result;
	}	

	private void updateInstance(T object, Session session) {
		Transaction transaction = session.beginTransaction();
		session.update(object);
		transaction.commit();		
	}
	
	private void deleteInstance(T object, Session session) {
		Transaction transaction = session.beginTransaction();
		session.delete(object);
		transaction.commit();		
	}	
	
	private List<T> retrieveAllInstances(Session session) {
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(getType());	
		@SuppressWarnings("unchecked")
		List<T> list = (List<T>) criteria.list();
		List<T> resultList = new ArrayList<T>();
		for (T element : list){
			if (!resultList.contains(element)){
				resultList.add(element);
			}
		}
		transaction.commit();		
		return resultList ;
	}		
	
	protected abstract String getName(T object);
}	