package fatec.es3.quest.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexaoBanco {

	private EntityManagerFactory emf;
	private EntityManager manager;

	public ConexaoBanco() throws Exception {
		this.emf = Persistence.createEntityManagerFactory("quest-persistence");
		this.manager = emf.createEntityManager();
		this.manager.getTransaction().begin();
	}

	public EntityManager getManager() {
		return manager;
	}

	public void fechaConexao(boolean sucesso) {
		try {

			if (sucesso) {
				this.manager.getTransaction().commit();
			} else {
				this.manager.getTransaction().rollback();
			}

			this.manager.close();
			this.emf.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
