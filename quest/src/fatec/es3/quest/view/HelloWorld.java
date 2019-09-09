package fatec.es3.quest.view;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import fatec.es3.quest.model.entidades.Cachorro;
import fatec.es3.quest.model.entidades.Raca;
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

//			Cachorro cachorro = new Cachorro();
//			cachorro.setNome(this.nomeCachorro);
//			cachorro.setObservacoes("obs obs obs");
//			cachorro.setSexo(Sexo.FEMININO);
//			cachorro.setData(new GregorianCalendar());
//
//			Raca raca = (Raca) dao.find(Raca.class, 1);
//
//			dao.persist(cachorro);
//
//			cachorro.setObservacoes("cachorro relacionado");
//			cachorro.setRaca(raca);
//
//			List<Habilidade> lista = new LinkedList<Habilidade>();
//			lista.add((Habilidade) dao.find(Habilidade.class, 1));
//			lista.add((Habilidade) dao.find(Habilidade.class, 2));
//			lista.add((Habilidade) dao.find(Habilidade.class, 3));
//			lista.add((Habilidade) dao.find(Habilidade.class, 4));
//
//			cachorro.setHabilidades(lista);
//
//			Dono dono = new Dono();
//			dono.setNome(Long.toString(new Date().getTime()));
//
//			dao.persist(dono);
//
//			cachorro.setDono(dono);
			
		
//			Raca raca = (Raca) dao.find(Raca.class, 1);
//			for(Cachorro cachorro : raca.getCachorros()) {
//				System.out.println(cachorro.getNome());
//			}

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
