package FrontEnd;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Conector.ClasseConexao;
import Conector.Crud_OS;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class EditarOS extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Id_Cli;
	private JTextField NOME_INPUT;
	private JTable tablePecasOS;
	private JTextField MAO_OBRA_INPUT;
	private JTextField VALOR_TOTAL_INPUT;
	private JTextField N_OS_INPUT;

	JanelaUI UI = new JanelaUI();
	private JTextField dsc_serv;
	Crud_OS edita_os = new Crud_OS();

	/**
	 * Create the frame.
	 */
	public EditarOS() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 530);
		setTitle("Editar OS");
		try {
			String editarOSIconPath = "src/FrontEnd/images/Pencil.png";
			Image editarOSIcon = Toolkit.getDefaultToolkit().getImage(editarOSIconPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel codClienteLabel = new JLabel("CLIENTE:");
		codClienteLabel.setBounds(10, 13, 52, 14);
		contentPane.add(codClienteLabel);
		
		Id_Cli = new JTextField();
		Id_Cli.setEditable(false);
		Id_Cli.setBounds(61, 10, 86, 20);
		contentPane.add(Id_Cli);
		Id_Cli.setColumns(10);
		
		JLabel cliNomeLabel = new JLabel("NOME:");
		cliNomeLabel.setBounds(10, 47, 52, 14);
		contentPane.add(cliNomeLabel);
		
		NOME_INPUT = new JTextField();
		NOME_INPUT.setEditable(false);
		NOME_INPUT.setBounds(62, 43, 412, 20);
		contentPane.add(NOME_INPUT);
		NOME_INPUT.setColumns(10);
		
		JLabel DescricaoLabel = new JLabel("DESCRIÇÃO:");
		DescricaoLabel.setBounds(10, 73, 73, 14);
		contentPane.add(DescricaoLabel);
		
		JLabel pecasLabel = new JLabel("PEÇAS:");
		pecasLabel.setBounds(10, 214, 73, 14);
		contentPane.add(pecasLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 242, 464, 150);
		contentPane.add(scrollPane);
		
		
		tablePecasOS = new JTable();
		scrollPane.setViewportView(tablePecasOS);
		tablePecasOS.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"IdOS", "IdPeca", "Quantidade", "Nome", "Valor"
			}
		));
		
		
		JLabel valorMaoObraLabel = new JLabel("VALOR MÃO DE OBRA:");
		valorMaoObraLabel.setBounds(10, 189, 116, 14);
		contentPane.add(valorMaoObraLabel);
		
		MAO_OBRA_INPUT = new JTextField();
		MAO_OBRA_INPUT.setBounds(131, 186, 86, 20);
		contentPane.add(MAO_OBRA_INPUT);
		MAO_OBRA_INPUT.setColumns(10);
		
		JLabel valorTotalLabel = new JLabel("VALOR TOTAL:");
		valorTotalLabel.setBounds(10, 403, 85, 14);
		contentPane.add(valorTotalLabel);
		
		VALOR_TOTAL_INPUT = new JTextField();
		VALOR_TOTAL_INPUT.setBounds(93, 400, 86, 20);
		contentPane.add(VALOR_TOTAL_INPUT);
		VALOR_TOTAL_INPUT.setColumns(10);
		
		JButton CANCELAR_BTN = new JButton("CANCELAR");
		CANCELAR_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		CANCELAR_BTN.setBounds(381, 457, 93, 23);
		contentPane.add(CANCELAR_BTN);
		
		JButton SALVAR_INPUT = new JButton("SALVAR");
		SALVAR_INPUT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// CRUD SALVAR
				edita_os.Alterar_OS(dsc_serv.getText(), Double.parseDouble(MAO_OBRA_INPUT.getText()),Double.parseDouble(VALOR_TOTAL_INPUT.getText()),Integer.parseInt(N_OS_INPUT.getText()));
				Id_Cli.setText(null);
	        	NOME_INPUT.setText(null);
	        	dsc_serv.setText(null);
	        	MAO_OBRA_INPUT.setText(null);
	        	VALOR_TOTAL_INPUT.setText(null);
	        	N_OS_INPUT.setText(null);
			}
		});
		SALVAR_INPUT.setBounds(278, 457, 93, 23);
		contentPane.add(SALVAR_INPUT);
		
		N_OS_INPUT = new JTextField();
		N_OS_INPUT.setColumns(10);
		N_OS_INPUT.setBounds(388, 10, 86, 20);
		contentPane.add(N_OS_INPUT);
		
		JLabel nOSLabel = new JLabel("Nº OS:");
		nOSLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		nOSLabel.setBounds(342, 13, 36, 14);
		contentPane.add(nOSLabel);
		
		JButton DELETAR_INPUT = new JButton("DELETAR");
		DELETAR_INPUT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edita_os.Deletar(Integer.parseInt(N_OS_INPUT.getText()));
				Id_Cli.setText(null);
	        	NOME_INPUT.setText(null);
	        	dsc_serv.setText(null);
	        	MAO_OBRA_INPUT.setText(null);
	        	VALOR_TOTAL_INPUT.setText(null);
	        	N_OS_INPUT.setText(null);
				
			}
		});
		DELETAR_INPUT.setBounds(10, 457, 93, 23);
		contentPane.add(DELETAR_INPUT);
		
		JButton CONSULTA_BTN = new JButton("CONSULTAR");
		CONSULTA_BTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Consultar_OS(Integer.parseInt(N_OS_INPUT.getText()));
				Tabela_peca(Integer.parseInt(N_OS_INPUT.getText()));
			}
		});
		CONSULTA_BTN.setBounds(239, 9, 93, 23);
		contentPane.add(CONSULTA_BTN);
		
		JButton ADD_PECA_BTN = new JButton("");
		ADD_PECA_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddPeca addPeca = new AddPeca();
				addPeca.setVisible(true);
			}
		});
		ADD_PECA_BTN.setBounds(416, 205, 24, 23);
		UI.BotaoIcon(ADD_PECA_BTN, "add_icon");
		contentPane.add(ADD_PECA_BTN);
		
		JButton DEL_PECA_BTN = new JButton("");
		DEL_PECA_BTN.setBounds(450, 205, 24, 23);
		UI.BotaoIcon(DEL_PECA_BTN, "del_icon");
		contentPane.add(DEL_PECA_BTN);
		
		dsc_serv = new JTextField();
		dsc_serv.setBounds(10, 98, 464, 80);
		contentPane.add(dsc_serv);
		dsc_serv.setColumns(10);
	}
	
	//Metodo para consultar e preencher os dados
	
	private ResultSet Consultar_OS(int IdOS) {
	    Connection conexao = null;
	    PreparedStatement comando = null;
	    ResultSet resultado = null;

	    try {
	        conexao = ClasseConexao.Conectar();
	        String sql = "SELECT o.IdCliente, c.Nome, o.Descricao, o.ValorServico, o.ValorTotal FROM os o JOIN cliente c ON o.IdCliente = c.IdCliente WHERE o.IdOS = ?";;
	        comando = conexao.prepareStatement(sql);
	        comando.setInt(1, IdOS);
	        resultado = comando.executeQuery();
	        if (resultado.next()) {
	        	Id_Cli.setText(resultado.getString(1));
	        	NOME_INPUT.setText(resultado.getString(2));
	        	dsc_serv.setText(resultado.getString(3));
	        	MAO_OBRA_INPUT.setText(resultado.getString(4));
	        	VALOR_TOTAL_INPUT.setText(resultado.getString(5));
			} else {

			}

	        return resultado;

	    } catch (SQLException e) {
	        e.printStackTrace();
	        return null;

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
	private void Tabela_peca(int IdOS) {
	    Connection conexao = null;
	    PreparedStatement comando = null;
	    ResultSet resultado = null;

	    try {
	        conexao = ClasseConexao.Conectar();
	        String sql = "SELECT os_p.IdOS, os_p.IdPeca, os_p.Quantidade, p.Nome, p.Valor FROM os_peca os_p INNER JOIN peca p ON os_p.IdPeca = p.IdPeca WHERE os_p.IdOS = ?";
	        comando = conexao.prepareStatement(sql);
	        comando.setInt(1, IdOS);
	        resultado = comando.executeQuery();

	        // Cria o modelo de tabela manualmente
	        DefaultTableModel model = new DefaultTableModel();
	        model.addColumn("IdOS");
	        model.addColumn("IdPeca");
	        model.addColumn("Quantidade");
	        model.addColumn("Nome");
	        model.addColumn("Valor");

	        // Adiciona as linhas ao modelo de tabela
	        while (resultado.next()) {
	            Object[] row = new Object[5]; // 5 colunas
	            row[0] = resultado.getInt("IdOS");
	            row[1] = resultado.getInt("IdPeca");
	            row[2] = resultado.getInt("Quantidade");
	            row[3] = resultado.getString("Nome");
	            row[4] = resultado.getDouble("Valor");
	            model.addRow(row);
	        }

	        // Define o modelo de tabela para a tabelaPecasOS
	        tablePecasOS.setModel(model);

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
