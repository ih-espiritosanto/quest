package fatec.es3.quest.view;

import java.util.GregorianCalendar;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import fatec.es3.quest.model.entidades.Cachorro;
import fatec.es3.quest.model.entidades.Sexo;
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
		DAO dao = new DAO();
		try {

			Cachorro cachorro = new Cachorro();
			cachorro.setNome(this.nomeCachorro);
			cachorro.setObservacoes("obs obs obs");
			cachorro.setSexo(Sexo.FEMININO);
			cachorro.setData(new GregorianCalendar());

			dao.persist(cachorro);
			
			cachorro.setObservacoes("oie oie oie");

		} catch (Exception e) {
			e.printStackTrace();
			sucesso = false;
		} finally {
			if (dao != null) {
				dao.fechaConexao(sucesso);
			}
		}

	}

}
