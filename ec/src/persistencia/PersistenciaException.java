package persistencia;

/**
 * Representa a ocorrencia de erros de persistencia utilizada para encapsular as tecnologias
 * usadas dentro da camada de persistencia
 * @author renan
 * @version 1.0 - 23/07/2020
 * @size 23/07/2020
 */

public class PersistenciaException extends Exception{
	
	/**
	 * Cria um novo objeto de mensagem padrao.
	 * @param mensagem descricao da mensagem
	 */
	public PersistenciaException(String mensagem) {
		super(mensagem);
	}

}
