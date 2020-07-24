package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import negocio.Cliente;
import sistema.Sistema;

/**
 * Implementacao do contrato de persistencia de clientes utilizando o framework jdbc simples
 * Padrao de projeto Strategy do livro Padroes de Projeto Java
 * A classe nao é publica para nao expor o servico para fora da camada
 * @author renan
 * @version 1.0 - 23/07/2020
 * @size 23/07/2020
 */
class ClienteJdbcImp implements ClienteRepositorio{

	/** armazena o sql utilizado para inserir um cliente **/
	private static final String INSERT = "insert into cliente(nome,email) values (?,?)";
	
	/** armazena o sql utilizado carregar os clientes ordenado pelo nome **/
	private static final String SELECT = "select * from cliente order by nome asc";
	
	@Override
	public void inserir(Cliente cliente) throws PersistenciaException {
		PreparedStatement insert = null;
		try {
			insert = Sistema.getConexao().prepareStatement(INSERT);
			insert.setObject(1, cliente.getNome());
			insert.setObject(2, cliente.getEmail());
			insert.execute();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaException("Erro ao inserir um cliente");
		} finally {
			try {
				insert.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}

	@Override
	public List<Cliente> getClientes() throws PersistenciaException {
		
		Statement select = null;
		try {
			select = Sistema.getConexao().createStatement();
			ResultSet rs = select.executeQuery(SELECT);
			List<Cliente> lista = new ArrayList<>();
			while(rs.next()) {
				lista.add(new Cliente(rs.getLong(1),rs.getString(2),rs.getString(3)));
			}
			rs.close();
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaException("Erro ao carregar clientes");
		} finally {
			try {
				select.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	
	
}
