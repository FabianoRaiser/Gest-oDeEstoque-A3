package FrontEnd;

import javax.swing.JTable;
import javax.swing.JScrollPane;

import Conector.ClasseConexao;
import Conector.Crud_cliente;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
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
	JanelaUI ui = new JanelaUI();
	ResultSet resultado = dataServer.Selecionar();
	
	public Cliente() {
		
		setSize(650, 450);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 118, 630, 321);
		add(scrollPane);
		
		tableCliente = new JTable();
		ui.AtualizaTabela(tableCliente, resultado);
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
		COD_INPUT.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String codigoText = COD_INPUT.getText().trim();
	            if (codigoText.isEmpty()) {
	            	Tabela_Cliente();
	            } else {
	            }
				dataServer.pesquisar_codigo(Integer.parseInt(COD_INPUT.getText()), tableCliente);
			}
		});
		
		NOME_INPUT = new JTextField();
		NOME_INPUT.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String NomeText = NOME_INPUT.getText().trim();
	            if (NomeText.isEmpty()) {
	            	Tabela_Cliente();
	            } else {
	            }
				dataServer.pesquisar_cliente(NOME_INPUT.getText(),tableCliente);
			}
			
		});
		NOME_INPUT.setColumns(10);
		NOME_INPUT.setBounds(66, 53, 454, 20);
		add(NOME_INPUT);
		
		JButton ATUALIZAR_BTN = new JButton("ATUALIZAR");
		ATUALIZAR_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tabela_Cliente();
			}
		});
		ATUALIZAR_BTN.setBounds(10, 84, 110, 23);
		add(ATUALIZAR_BTN);
		
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
	private void Tabela_Cliente() {
	    Connection conexao = null;
	    PreparedStatement comando = null;
	    ResultSet resultado = null;

	    try {
	        conexao = ClasseConexao.Conectar();
	        String sql = "SELECT * FROM cliente";
	        comando = conexao.prepareStatement(sql);
	        resultado = comando.executeQuery();
	        // Cria o modelo de tabela manualmente
	        DefaultTableModel model = new DefaultTableModel();
	        model.addColumn("IdCliente");
	        model.addColumn("Nome");
	        model.addColumn("Telefone");
	        model.addColumn("Endereço");

	        // Adiciona as linhas ao modelo de tabela
	        while (resultado.next()) {
	            Object[] row = new Object[4]; // 5 colunas
	            row[0] = resultado.getInt("IdCliente");
	            row[1] = resultado.getString("Nome");
	            row[2] = resultado.getString("Telefone");
	            row[3] = resultado.getString("Endereco");
	            model.addRow(row);
	        }

	        // Define o modelo de tabela para a tabelaPecasOS
	        tableCliente.setModel(model);

	    } catch (SQLException e) {
	        e.printStackTrace();
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