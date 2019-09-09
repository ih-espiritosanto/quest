package fatec.es3.quest.model.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Raca {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private boolean rara;
	
	@OneToMany(mappedBy = "raca")
	private List<Cachorro> cachorros;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public boolean isRara() {
		return rara;
	}
	public void setRara(boolean rara) {
		this.rara = rara;
	}
	public List<Cachorro> getCachorros() {
		return cachorros;
	}
	public void setCachorros(List<Cachorro> cachorros) {
		this.cachorros = cachorros;
	}
	
	
	
	
}
