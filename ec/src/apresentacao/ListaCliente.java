package apresentacao;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import negocio.Cliente;
import persistencia.ClienteRepositorio;
import persistencia.FabricaPersistencia;

/**
 * Interface grafica desktop de listagem de cliente usando framework Java Swing
 * @author renan
 * @version 1.0 - 23/07/2020
 * @size 23/07/2020
 */
public class ListaCliente extends JFrame{
	
	
	/**
	 * Constroi e inicializa os componentes visuais
	 */
	public ListaCliente() {
		ClienteRepositorio repositorio = FabricaPersistencia.fabricarCliente();
		List<Cliente> clientes = null;
		try {
			clientes = repositorio.getClientes();
		} catch (Exception e) {
			e.printStackTrace();
			clientes = new ArrayList<Cliente>();
		}
		Object[][] grid = new Object[clientes.size()][3];
		for (int ct = 0; ct < clientes.size(); ct++) {
			grid[ct] = new Object[] {clientes.get(ct).getNome(),
					clientes.get(ct).getEmail()};
		}
		JTable table= new JTable(grid, new String[] {"NOME", "EMAIL"});
		JScrollPane scroll = new JScrollPane(table);
		getContentPane().add(scroll, BorderLayout.CENTER);
		setTitle("Clientes Cadastrados");
		setSize(600,400);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	

}
