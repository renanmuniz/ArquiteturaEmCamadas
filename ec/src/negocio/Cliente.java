package negocio;

/**
 * Representa a entidade de negocio cliente. Padrão do projeto Domain-Model
 * do livro Padroes de Arquitetura de aplicações Corporativas.
 * @author renan
 * @version 1.0 - 23/07/2020
 * @size 23/07/2020
 */
public class Cliente {

	/** Armazena o identificador unico. **/
	private long id;
	/** Armazena o nome. **/
	private String nome;
	/** Armazena o email. **/
	private String email;
	
	/** Cria um novo cliente vazio **/
	public Cliente() {
		
	}

	/** Cria um novo cliente recebendo informacoes.
	 * @param id identificador unico a ser informado
	 * @param nome  nome a ser informado
	 * @param email email a ser informado
	 *  **/
	public Cliente(long id, String nome, String email) {
		this.id = id;
		this.nome = nome;
		this.email = email;
	}
	
	/**
	 * Regra de negocio que valida a operacao inserir
	 * @throws NegocioException caso ocorrer erros de negocio
	 */
	public void validarInserir() throws NegocioException{
		if ("".equals(nome)) {
			throw new NegocioException("Nome obrigatório.");
		} else if (nome.trim().equals("")) {
			throw new NegocioException("Nome obrigatório.");
		}
		
		if ("".equals(email)) {
			throw new NegocioException("email obrigatório.");
		} else if (email.trim().equals("")) {
			throw new NegocioException("email obrigatório.");
		}
		if (!email.contains("@")) {
			throw new NegocioException("email inválido.");
		}
	}

	
	// get e set nao precisa de javadoc.
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
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
	
}
