package fatec.es3.quest.view;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import fatec.es3.quest.model.entidades.Cachorro;
import fatec.es3.quest.persistencia.ConexaoBanco;
import fatec.es3.quest.persistencia.DAO;

@ViewScoped
@ManagedBean
public class HelloWorld {

	private String mensagem;
	private String nomeCachorro;

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getNomeCachorro() {
		return nomeCachorro;
	}

	public void setNomeCachorro(String nomeCachorro) {
		this.nomeCachorro = nomeCachorro;
	}
	
	@PostConstruct
	private void init() {
		this.mensagem = "Hello world!";
	}

	public void persisteCachorro() {

		boolean sucesso = true;
		ConexaoBanco con = null;
		try {
			con = new ConexaoBanco();

			DAO dao = new DAO(con);

			Cachorro cachorro = new Cachorro();
			cachorro.setNome(this.nomeCachorro);
			cachorro.setObservacoes("obs obs obs");

			dao.create(cachorro);

		} catch (Exception e) {
			e.printStackTrace();
			sucesso = false;
		} finally {
			if (con != null) {
				con.fechaConexao(sucesso);
			}
		}

	}

}
