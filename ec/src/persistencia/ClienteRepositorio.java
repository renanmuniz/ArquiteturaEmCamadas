package persistencia;

import java.util.List;

import negocio.Cliente;

/**
 * Contrato de servico utilizado para definir as operacoes de persistencia de cliente
 * é aplicacao do conceito de DbC. Padrao de projeto: Repository do livro Domain Drive Design (DDD)
 * @author renan
 * @version 1.0 - 23/07/2020
 * @size 23/07/2020
 */

public interface ClienteRepositorio {
	
	/**
	 * Insere um novo cliente na base
	 * @param cliente informacoes de cliente a serem inseridas
	 * @throws PersistenciaException caso ocorrer erro de persistencia
	 */
	void inserir(Cliente cliente) throws PersistenciaException;
	
	/**
	 * Pesquisa e retorna todos os clientes existentes ordenados pelo nome
	 * @return todos os clientes existentes ordenados pelo nome
	 * @throws PersistenciaException caso ocorrer erros de acesso
	 */
	List<Cliente> getClientes() throws PersistenciaException;
}
