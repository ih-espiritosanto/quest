package fatec.es3.quest.persistencia;

public class DAO {
	
	private ConexaoBanco conexao;	
	
	public DAO(ConexaoBanco conexao) {
		this.conexao = conexao;
	}
	
	public void create(Object obj) {
		this.conexao.getManager().persist(obj);
	}
}
