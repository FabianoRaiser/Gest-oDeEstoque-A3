package FrontEnd;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Conector.ClasseConexao;
import Conector.Crud_OS;
import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class OrdensDeServico extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tableOrdens;
	private JTextField OS_INPUT;
	private JTextField CLI_COD_INPUT;
	private JTextField CLI_NOME_INPUT;
	Crud_OS PESQUISA = new Crud_OS();
	
	/**
	 * Create the frame.
	 */
	public OrdensDeServico() {
		setSize( 650, 400);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 70, 630, 319);
		add(scrollPane);
		
		tableOrdens = new JTable();
		scrollPane.setViewportView(tableOrdens);
		tableOrdens.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "IdCliente", "IdOS", "IdPeca", "Quantidade","ValorTotal"
			}
		));
		
		JLabel ordemLabel = new JLabel("Nº OS:");
		ordemLabel.setBounds(10, 14, 56, 14);
		add(ordemLabel);
		
		JLabel cliCodLabel = new JLabel("CÓD:");
		cliCodLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		cliCodLabel.setBounds(172, 14, 56, 14);
		add(cliCodLabel);
		
		OS_INPUT = new JTextField();
		OS_INPUT.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				String OSText = OS_INPUT.getText().trim();
	            if (OSText.isEmpty()) {
	            	Tabela_OS();
	            } else {
	            }
				PESQUISA.pesquisar_OS(Integer.parseInt(OS_INPUT.getText()), tableOrdens);
			}
		});
		OS_INPUT.setBounds(76, 11, 86, 20);
		add(OS_INPUT);
		OS_INPUT.setColumns(10);
		
		CLI_COD_INPUT = new JTextField();
		CLI_COD_INPUT.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String CliText = CLI_COD_INPUT.getText().trim();
	            if (CliText.isEmpty()) {
	            	Tabela_OS();
	            } else {
	            }
				PESQUISA.pesquisar_idCli(Integer.parseInt(CLI_COD_INPUT.getText()), tableOrdens);
				 
			}
		});
		CLI_COD_INPUT.setBounds(239, 11, 86, 20);
		add(CLI_COD_INPUT);
		CLI_COD_INPUT.setColumns(10);
		
		CLI_NOME_INPUT = new JTextField();
		CLI_NOME_INPUT.setEditable(false);
		CLI_NOME_INPUT.setBounds(76, 39, 444, 20);
		add(CLI_NOME_INPUT);
		CLI_NOME_INPUT.setColumns(10);
		
		JLabel cliNomeLabel = new JLabel("CLIENTE:");
		cliNomeLabel.setBounds(10, 42, 56, 14);
		add(cliNomeLabel);
		
		JButton NOVA_OS_BTN = new JButton("NOVA OS");
		NOVA_OS_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					NovaOS novaOS = new NovaOS();
					novaOS.setVisible(true);
			}
		});
		try {
			String newOSIconPath = "src/FrontEnd/images/newOS-btnIcon.png";
			Image newOSIcon = Toolkit.getDefaultToolkit().getImage(newOSIconPath).getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH);
			NOVA_OS_BTN.setIcon(new ImageIcon(newOSIcon));
		} catch (Exception e) {
			e.printStackTrace();
		}
		NOVA_OS_BTN.setBounds(529, 8, 110, 23);
		add(NOVA_OS_BTN);
		
		JButton EDITAR_BTN = new JButton("EDITAR");
		EDITAR_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditarOS editarOS = new EditarOS();
				editarOS.setVisible(true);
			}
		});
		EDITAR_BTN.setBounds(530, 36, 110, 23);
		add(EDITAR_BTN);
		
		JButton ATUALIZAR_BTN = new JButton("ATUALIZAR");
		ATUALIZAR_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tabela_OS();
				
				
			}
		});
		ATUALIZAR_BTN.setBounds(410, 10, 110, 23);
		add(ATUALIZAR_BTN);
	}

	private void Tabela_OS() {
	    Connection conexao = null;
	    PreparedStatement comando = null;
	    ResultSet resultado = null;

	    try {
	        conexao = ClasseConexao.Conectar();
	        String sql = "SELECT c.Nome, c.IdCliente, o.IdOS, op.IdPeca, op.Quantidade, o.ValorTotal FROM cliente c JOIN os o ON c.IdCliente = o.IdCliente JOIN os_peca op ON o.IdOS = op.IdOS;";
	        comando = conexao.prepareStatement(sql);
	        resultado = comando.executeQuery();
	        // Cria o modelo de tabela manualmente
	        DefaultTableModel model = new DefaultTableModel();
	        model.addColumn("Nome");
	        model.addColumn("IdCliente");
	        model.addColumn("IdOS");
	        model.addColumn("IdPeca");
	        model.addColumn("Quantidade");
	        model.addColumn("ValorTotal");

	        // Adiciona as linhas ao modelo de tabela
	        while (resultado.next()) {
	            Object[] row = new Object[6]; // 5 colunas
	            row[0] = resultado.getString("Nome");
	            row[1] = resultado.getInt("IdCliente");
	            row[2] = resultado.getInt("IdOS");
	            row[3] = resultado.getString("IdPeca");
	            row[4] = resultado.getDouble("Quantidade");
	            row[5] = resultado.getDouble("ValorTotal");
	            model.addRow(row);
	        }

	        // Define o modelo de tabela para a tabelaPecasOS
	        tableOrdens.setModel(model);

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
