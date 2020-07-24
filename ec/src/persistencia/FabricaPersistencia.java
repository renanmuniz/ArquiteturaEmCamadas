package persistencia;

/**
 * Fabrica de criacao de estrategias de persistencias. Implementa o padrao de projeto Utily Class [item 4]
 * @author renan
 * @version 1.0 - 23/07/2020
 * @size 23/07/2020
 */
public class FabricaPersistencia {

	/** nao pode ser criado **/
	private FabricaPersistencia() {
		throw new IllegalStateException();
	}
	
	
	/** 
	 * Fabrica a estrategia de persistencia para clientes
	 * @return persistencia de clientes
	 */
	public static ClienteRepositorio fabricarCliente() {
		return new ClienteJdbcImp();
	}
}
