package sistema;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Inicializador responsavel por executar os processos de inicializacao do sistema.
 * Padrao de projeto Utily Class do Livro Java Efetivo [item 4.]
 * @author renan
 * @version 1.0 - 23/07/2020
 * @size 23/07/2020
 */
public class Sistema {
	
	/** Armazena  gerenciado de conexao com o banco de dados 
	 *  Padrao Singleton 
	 */
	private static Connection conexao;
	
	/** Nao pode ser criado **/
	private Sistema() {
		throw new IllegalStateException();
	}
	
	/** Executar a inicializacao do sistema **/
	public static void iniciarSistema() {
		if(conexao==null) {
			try {
				Class.forName("org.hsqldb.jdbcDriver");
				conexao=DriverManager.getConnection(Parametros.BASE_SGDB, Parametros.USUARIO, Parametros.SENHA);
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Erro na comunicacao com banco de dados");
			}
		}
	}
	
	/** Retorna a conexao ativa **/
	public static Connection getConexao() {
		if(conexao==null) {
			iniciarSistema();
		}
		return conexao;
	}
	
	/** Executar o desligamento do sistema **/
	public static void desligarSistema() {
		try {
			conexao.close();
			conexao = null;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Erro no encerramento da conexao com banco de dados");
		}
	}
	
	

}
