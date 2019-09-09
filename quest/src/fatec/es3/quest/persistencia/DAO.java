package fatec.es3.quest.persistencia;

import java.io.Serializable;

public class DAO extends ConexaoBanco {
	
	public void persist(Object obj) {
		manager.persist(obj);
	}
	
	public Object find(Class<?> clazz, Serializable id) {
		return manager.find(clazz, id); 
	}
	
	public void merge(Object obj) {
		manager.merge(obj);
	}
	
	public void remove(Class<?> clazz, Serializable id) {
		Object obj = manager.find(clazz, id);
		manager.remove(obj);
	}
}
