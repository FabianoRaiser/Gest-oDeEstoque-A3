package FrontEnd;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Conector.Crud_estoque;
import Conector.Crud_peca;
import net.proteanit.sql.DbUtils;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class estoque extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTable tableEstoque;
	
	private JTextField COD_INPUT;
	private JTextField PECA_INPUT;
	private JTextField MARCA_INPUT;
	private JTextField MODELO_INPUT;
	
	private JLabel codLabel;
	private JLabel pecaLabel;
	private JLabel marcaLabel;
	private JLabel modeloLabel;
	private JLabel anoLabel;
	
	Crud_peca dataServer = new Crud_peca();
	ResultSet dataTabela;
	
	
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
	 * Create the application.
	 */
	public estoque() {
	
		// CONFIG DA JANELA
		setSize(650, 450);
		setLayout(null);
		
		// CONFIG DA TABELA
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 105, 631, 334);
		add(scrollPane);
				
		tableEstoque = new JTable();
		AtualizaTabela(tableEstoque);
		scrollPane.setViewportView(tableEstoque);
		
		// CONFIG DOS LABELS
		
		codLabel = new JLabel("CÓD: ");
		codLabel.setBounds(10, 15, 37, 14);
		add(codLabel);
		
		pecaLabel = new JLabel("PEÇA: ");
		pecaLabel.setBounds(10, 43, 37, 14);
		add(pecaLabel);
		
		modeloLabel = new JLabel("MODELO:");
		modeloLabel.setBounds(314, 15, 62, 14);
		add(modeloLabel);
		
		anoLabel = new JLabel("ANO:");
		anoLabel.setBounds(314, 43, 46, 14);
		add(anoLabel);
		
		marcaLabel = new JLabel("MARCA:");
		marcaLabel.setBounds(153, 15, 56, 14);
		add(marcaLabel);
		
		// CONFIG DOS INPUTS
		
		COD_INPUT = new JTextField(); 
			
		COD_INPUT.setBounds(57, 12, 86, 20);
		add(COD_INPUT);
		COD_INPUT.setColumns(10);
		COD_INPUT.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String codigoText = COD_INPUT.getText().trim();
	            if (codigoText.isEmpty()) {
	            	AtualizaTabela(tableEstoque);
	            } else {
	            }
				
				dataServer.pesquisar_codigo(Integer.parseInt(COD_INPUT.getText()), tableEstoque);
			}
		});
		
		PECA_INPUT = new JTextField();
		PECA_INPUT.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				dataServer.pesquisar_peca(PECA_INPUT.getText(), tableEstoque);	
			}
			
		});
		PECA_INPUT.setColumns(10);
		PECA_INPUT.setBounds(57, 40, 238, 20);
		add(PECA_INPUT);
				
		MARCA_INPUT = new JTextField();
		MARCA_INPUT.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				dataServer.pesquisar_marca(MARCA_INPUT.getText(), tableEstoque);
				
			}
		});
		MARCA_INPUT.setColumns(10);
		MARCA_INPUT.setBounds(209, 12, 86, 20);
		add(MARCA_INPUT);
		
		MODELO_INPUT = new JTextField();
		MODELO_INPUT.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				dataServer.pesquisar_modelo(MODELO_INPUT.getText(), tableEstoque);
			}
		});
		MODELO_INPUT.setColumns(10);
		MODELO_INPUT.setBounds(386, 12, 86, 20);
		add(MODELO_INPUT);
		
		
		// CONFIG DO DROPDOWN
		
		JComboBox<Object> ANO_DROPDOWN = new JComboBox<Object>();
		ANO_DROPDOWN.setModel(new DefaultComboBoxModel<Object>(new String[] {"", "2024", "2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982"}));
		ANO_DROPDOWN.setEditable(true);
		ANO_DROPDOWN.setBounds(386, 39, 86, 22);
		add(ANO_DROPDOWN);
		ANO_DROPDOWN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dataServer.pesquisar_ano(ANO_DROPDOWN, tableEstoque);
			}
			});
		
		JButton ATUALIZAR_BTN = new JButton("ATUALIZAR");
		ATUALIZAR_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AtualizaTabela(tableEstoque);
			}
		});
		ATUALIZAR_BTN.setBounds(10, 71, 112, 23);
		add(ATUALIZAR_BTN);
		
		JButton CADASTRAR_BTN = new JButton("CADASTRAR");
		CADASTRAR_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroPeca cadastro = new CadastroPeca();
				cadastro.setVisible(true);
			}
		});
		CADASTRAR_BTN.setBounds(529, 11, 112, 23);
		add(CADASTRAR_BTN);
		
		JButton EDITAR_BTN = new JButton("EDITAR");
		EDITAR_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame editar = new EditarPeca();
				editar.setVisible(true);
			}
		});
		EDITAR_BTN.setBounds(529, 39, 112, 23);
		add(EDITAR_BTN);
		
		JButton BAIXA_BTN = new JButton("DAR BAIXA");
		BAIXA_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame darBaixa = new BaixaPeca();
				darBaixa.setVisible(true);
			}
		});
		BAIXA_BTN.setBounds(529, 68, 112, 23);
		add(BAIXA_BTN);
	}
}


