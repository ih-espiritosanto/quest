package fatec.es3.quest.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class ConexaoBanco {

	private EntityManagerFactory emf;
	protected EntityManager manager;

	public ConexaoBanco() {
		this.emf = Persistence.createEntityManagerFactory("quest-persistence");
		this.manager = emf.createEntityManager();
		this.manager.getTransaction().begin();
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
			//doNothing();
		}
	}
	
	@Override
	protected void finalize() throws Throwable {
		this.fechaConexao(false);
		super.finalize();
	}

}
