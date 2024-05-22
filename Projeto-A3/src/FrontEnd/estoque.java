package FrontEnd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class estoque {

	private JFrame frameEstoque;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					estoque window = new estoque();
					window.frameEstoque.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public estoque() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		// CONFIG DA JANELA
		frameEstoque = new JFrame("Estoque");
		frameEstoque.setBounds(100, 100, 667, 512);
		frameEstoque.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameEstoque.getContentPane().setLayout(null);
		
		// DATA DA TABELA
		
		String[][] data = {
				{"001", "Motor", "2", "150.0", "kg", "Toyota", "V6", "2022", "Preto", "2500.0"},
                {"002", "Transmissão", "1", "80.0", "kg", "Honda", "Automatic", "2023", "Prata", "1800.0"},
                {"003", "Pneu", "4", "10.0", "kg", "Michelin", "Sport", "2024", "Preto", "300.0"}
		};
		
		String[] colunas = {"CÓD", "PEÇA", "QTD", "PESO", "MEDIDA", "MARCA", "MODELO", "ANO", "COR", "VALOR"};
		
		// CONFIG DA TABELA
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 121, 631, 319);
		frameEstoque.getContentPane().add(scrollPane);
		
		tableEstoque = new JTable(data, colunas);
		scrollPane.setViewportView(tableEstoque);
		
		// CONFIG DOS LABELS
		
		codLabel = new JLabel("CÓD: ");
		codLabel.setBounds(10, 31, 37, 14);
		frameEstoque.getContentPane().add(codLabel);
		
		pecaLabel = new JLabel("PEÇA: ");
		pecaLabel.setBounds(10, 59, 37, 14);
		frameEstoque.getContentPane().add(pecaLabel);
		
		modeloLabel = new JLabel("MODELO:");
		modeloLabel.setBounds(314, 31, 62, 14);
		frameEstoque.getContentPane().add(modeloLabel);
		
		anoLabel = new JLabel("ANO:");
		anoLabel.setBounds(314, 59, 46, 14);
		frameEstoque.getContentPane().add(anoLabel);
		
		marcaLabel = new JLabel("MARCA:");
		marcaLabel.setBounds(153, 31, 56, 14);
		frameEstoque.getContentPane().add(marcaLabel);
		
		// CONFIG DOS INPUTS
		
		COD_INPUT = new JTextField();
		COD_INPUT.setBounds(57, 28, 86, 20);
		frameEstoque.getContentPane().add(COD_INPUT);
		COD_INPUT.setColumns(10);
		
		PECA_INPUT = new JTextField();
		PECA_INPUT.setColumns(10);
		PECA_INPUT.setBounds(57, 56, 238, 20);
		frameEstoque.getContentPane().add(PECA_INPUT);
				
		MARCA_INPUT = new JTextField();
		MARCA_INPUT.setColumns(10);
		MARCA_INPUT.setBounds(209, 28, 86, 20);
		frameEstoque.getContentPane().add(MARCA_INPUT);
		
		MODELO_INPUT = new JTextField();
		MODELO_INPUT.setColumns(10);
		MODELO_INPUT.setBounds(386, 28, 86, 20);
		frameEstoque.getContentPane().add(MODELO_INPUT);
		
		
		// CONFIG DO DROPDOWN
		
		JComboBox<Object> ANO_DROPDOWN = new JComboBox<Object>();
		ANO_DROPDOWN.setModel(new DefaultComboBoxModel<Object>(new String[] {"", "2024", "2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982"}));
		ANO_DROPDOWN.setEditable(true);
		ANO_DROPDOWN.setBounds(386, 55, 86, 22);
		frameEstoque.getContentPane().add(ANO_DROPDOWN);
		
		JButton PESQUISAR_BTN = new JButton("PESQUISAR");
		PESQUISAR_BTN.setBounds(10, 87, 112, 23);
		frameEstoque.getContentPane().add(PESQUISAR_BTN);
		
		JButton CADASTRAR_BTN = new JButton("CADASTRAR");
		CADASTRAR_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroPeca cadastro = new CadastroPeca();
				cadastro.setVisible(true);
			}
		});
		CADASTRAR_BTN.setBounds(529, 27, 112, 23);
		frameEstoque.getContentPane().add(CADASTRAR_BTN);
		
		JButton CADASTRAR_BTN_1 = new JButton("EDITAR");
		CADASTRAR_BTN_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame editar = new EditarPeca();
				editar.setVisible(true);
			}
		});
		CADASTRAR_BTN_1.setBounds(529, 55, 112, 23);
		frameEstoque.getContentPane().add(CADASTRAR_BTN_1);
	}
}
