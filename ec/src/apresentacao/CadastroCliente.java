package apresentacao;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import negocio.Cliente;
import negocio.NegocioException;
import persistencia.ClienteRepositorio;
import persistencia.FabricaPersistencia;
import persistencia.PersistenciaException;

/**
 * Interface grafica desktop de cadastro de cliente usando framework Java Swing
 * @author renan
 * @version 1.0 - 23/07/2020
 * @size 23/07/2020
 */
public class CadastroCliente extends JFrame{

	/**
	 * Armazena o repositorio de clientes
	 */
	private ClienteRepositorio repositorio;
	
	/**
	 * Armazena o botao que entra na listagem de clientes
	 */
	private JButton btLista;
	
	/**
	 * Armazena o botao que grava os clientes
	 */
	private JButton btOk;
	
	/**
	 * Armazena o campo que recebe o nome do cliente
	 */
	private JTextField tfNome;
	
	/**
	 * Armazena o campo que recebe o email do cliente
	 */
	private JTextField tfEmail;
	
	
	/** Constroe e inicializa os componentes visuais **/
	public CadastroCliente() {
		repositorio = FabricaPersistencia.fabricarCliente();
		btLista = new JButton("Lista");
		JPanel pn1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		pn1.add(btLista);
		getContentPane().add(pn1, BorderLayout.NORTH);
		
		tfNome = new JTextField(30);
		tfEmail = new JTextField(30);
		JPanel pn2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pn2.add(new JLabel("Nome:"));
		pn2.add(tfNome);
		pn2.add(new JLabel("Email:"));
		pn2.add(tfEmail);
		getContentPane().add(pn2, BorderLayout.CENTER);
		
		
		btOk = new JButton("OK");
		JPanel pn3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		pn3.add(btOk);
		getContentPane().add(pn3, BorderLayout.SOUTH);
		
		eventos();
		
		setTitle("Estudo de caso");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(360,210);
		setLocationRelativeTo(null);
	}
	
	/** limpa os campos visuais apos cadastro**/
	private void limparCampos() {
		tfNome.setText("");
		tfEmail.setText("");
	}
	
	/** configura os eventos visuais **/
	private void eventos() {
		btOk.addActionListener(e->{
			if(inserir()) {
				limparCampos();
			}
		});
		btLista.addActionListener(e -> {
			ListaCliente lista = new ListaCliente();
			lista.setVisible(true);
		});
	}
	
	/** grava um novo cliente no repositorio **/
	private boolean inserir() {
		Cliente cliente = new Cliente();
		cliente.setNome(tfNome.getText());
		cliente.setEmail(tfEmail.getText());
		try {
			cliente.validarInserir();
			repositorio.inserir(cliente);
			return true;
		} catch (NegocioException | PersistenciaException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, e.getMessage(), "Erro de gravacao", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	
}
