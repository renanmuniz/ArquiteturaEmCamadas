package negocio;

/**
 * Representa a ocorrencia de erros de negocio utilizada para encapsular as tecnologias
 * usadas dentro da camada de negocio
 * @author renan
 * @version 1.0 - 23/07/2020
 * @size 23/07/2020
 */

public class NegocioException extends Exception{
	/**
	 * Cria um novo objeto com mensagem padrao
	 * @param mensagem descricao da mensagem de erro
	 */
	public NegocioException(String mensagem) {
		super(mensagem);
	}

}
