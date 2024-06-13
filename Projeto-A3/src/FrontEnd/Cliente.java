package FrontEnd;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import Conector.ClasseConexao;
import Conector.Crud_cliente;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
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

public class Cliente {

	private JFrame frameCliente;
	private JTable tableCliente;
	private JLabel nomeLabel;
	private JTextField COD_INPUT;
	private JTextField NOME_INPUT;
	private JButton CADASTRAR_BTN;
	private JButton EDITAR_BTN;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cliente window = new Cliente();
					window.frameCliente.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Cliente() {
		initialize();
	}
	
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
	private void initialize() {
		
		frameCliente = new JFrame();
		try {
			String estIconPath = "src/FrontEnd/images/cli-icon.png";
			Image estIcon = Toolkit.getDefaultToolkit().getImage(estIconPath);
			frameCliente.setIconImage(estIcon);
		}catch (Exception e) {
			e.printStackTrace();
		}
		frameCliente.setTitle("Cliente");
		frameCliente.setBounds(100, 100, 560, 464);
		frameCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameCliente.getContentPane().setLayout(null);
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 108, 524, 306);
		frameCliente.getContentPane().add(scrollPane);
		
		tableCliente = new JTable();
		AtualizaTabela(tableCliente);
		tableCliente.setColumnSelectionAllowed(true);
		scrollPane.setViewportView(tableCliente);
		
		JLabel codLabel = new JLabel("CÓD:");
		codLabel.setBounds(10, 24, 46, 14);
		frameCliente.getContentPane().add(codLabel);
		
		nomeLabel = new JLabel("NOME:");
		nomeLabel.setBounds(10, 49, 46, 14);
		frameCliente.getContentPane().add(nomeLabel);
		
		COD_INPUT = new JTextField();
		COD_INPUT.setBounds(66, 21, 86, 20);
		frameCliente.getContentPane().add(COD_INPUT);
		COD_INPUT.setColumns(10);
		
		NOME_INPUT = new JTextField();
		NOME_INPUT.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pesquisar_cliente(NOME_INPUT.getText());
			}
			
		});
		NOME_INPUT.setColumns(10);
		NOME_INPUT.setBounds(66, 46, 204, 20);
		frameCliente.getContentPane().add(NOME_INPUT);
		
		JButton PESQUISAR_BTN = new JButton("PESQUISAR");
		PESQUISAR_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AtualizaTabela(tableCliente);
			}
		});
		PESQUISAR_BTN.setBounds(10, 74, 110, 23);
		frameCliente.getContentPane().add(PESQUISAR_BTN);
		
		CADASTRAR_BTN = new JButton("CADASTRAR");
		CADASTRAR_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroCliente cadastro = new CadastroCliente();
				cadastro.setVisible(true);
			}
		});
		CADASTRAR_BTN.setBounds(424, 20, 110, 23);
		frameCliente.getContentPane().add(CADASTRAR_BTN);
		
		EDITAR_BTN = new JButton("EDITAR");
		EDITAR_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditarCliente editar = new EditarCliente();
				editar.setVisible(true);
			}
		});
		EDITAR_BTN.setBounds(424, 49, 110, 23);
		frameCliente.getContentPane().add(EDITAR_BTN);
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