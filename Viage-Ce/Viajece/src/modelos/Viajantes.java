package modelos;

public class Viajantes {

	//atributos
	private int id;
	private String nome;
	private String email;
	private String senha;
	
	//construtores
	
	public Viajantes() {
	}

	public Viajantes(int id, String nome, String email, String senha) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	public Viajantes(String nome, String email, String senha) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}
	
	//getters e setters
	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	//tostring

	@Override
	public String toString() {
		return "Viajantes [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + "]";
	}	

}