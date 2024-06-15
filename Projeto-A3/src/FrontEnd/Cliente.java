package FrontEnd;

import javax.swing.JTable;
import javax.swing.JScrollPane;

import Conector.ClasseConexao;
import Conector.Crud_cliente;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Cliente extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tableCliente;
	private JLabel nomeLabel;
	private JTextField COD_INPUT;
	private JTextField NOME_INPUT;
	private JButton CADASTRAR_BTN;
	private JButton EDITAR_BTN;

	/**
	 * Create the application.
	 */
	Crud_cliente dataServer = new Crud_cliente();
	
	private void AtualizaTabela(JTable table) {
		ResultSet resultado = dataServer.Selecionar();
		try {
			while(resultado.next()) {
				// DATA para COMBOBOX
				//System.out.println(resultado.getString("nome"));
			}
			resultado.beforeFirst();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		table.setModel(DbUtils.resultSetToTableModel(resultado));
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public Cliente() {
		
		setSize(650, 450);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 118, 630, 321);
		add(scrollPane);
		
		tableCliente = new JTable();
		AtualizaTabela(tableCliente);
		tableCliente.setColumnSelectionAllowed(true);
		scrollPane.setViewportView(tableCliente);
		
		JLabel codLabel = new JLabel("CÓD:");
		codLabel.setBounds(10, 21, 46, 14);
		add(codLabel);
		
		nomeLabel = new JLabel("NOME:");
		nomeLabel.setBounds(10, 56, 46, 14);
		add(nomeLabel);
		
		COD_INPUT = new JTextField();
		COD_INPUT.setBounds(66, 18, 86, 20);
		add(COD_INPUT);
		COD_INPUT.setColumns(10);
		
		NOME_INPUT = new JTextField();
		NOME_INPUT.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pesquisar_cliente(NOME_INPUT.getText());
			}
			
		});
		NOME_INPUT.setColumns(10);
		NOME_INPUT.setBounds(66, 53, 454, 20);
		add(NOME_INPUT);
		
		JButton PESQUISAR_BTN = new JButton("PESQUISAR");
		PESQUISAR_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AtualizaTabela(tableCliente);
			}
		});
		PESQUISAR_BTN.setBounds(10, 84, 110, 23);
		add(PESQUISAR_BTN);
		
		CADASTRAR_BTN = new JButton("CADASTRAR");
		CADASTRAR_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroCliente cadastro = new CadastroCliente();
				cadastro.setVisible(true);
			}
		});
		CADASTRAR_BTN.setBounds(530, 21, 110, 23);
		add(CADASTRAR_BTN);
		
		EDITAR_BTN = new JButton("EDITAR");
		EDITAR_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditarCliente editar = new EditarCliente();
				editar.setVisible(true);
			}
		});
		EDITAR_BTN.setBounds(530, 52, 110, 23);
		add(EDITAR_BTN);
	}
	
	// metodo para pesquisas com filtro

	private void pesquisar_cliente(String Nome) {
		Connection conexao = null;
	    PreparedStatement comando = null;
	    String sql= "select * from cliente where Nome like ?";
		
		try {
			conexao = ClasseConexao.Conectar();
			comando = conexao.prepareStatement(sql);
			comando.setString(1, NOME_INPUT.getText() + "%");
			ResultSet resultado = comando.executeQuery();
			
			tableCliente.setModel(DbUtils.resultSetToTableModel(resultado)); 
			
		} catch (SQLException e) {
	        e.printStackTrace();
	        return;

	    } finally {
	        ClasseConexao.FecharConexao(conexao);
	        try {
	            if (comando != null) {
	                comando.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	  }
}