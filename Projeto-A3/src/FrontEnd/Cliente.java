package FrontEnd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frameCliente = new JFrame();
		frameCliente.setTitle("Cliente");
		frameCliente.setBounds(100, 100, 560, 464);
		frameCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameCliente.getContentPane().setLayout(null);
		
		String[][] data = {
				{"001", "Maria Silva", "(11) 1234-5678", "Rua A, 123"},
				{"002", "João Santos", "(21) 9876-5432", "Avenida B, 456"},
				{"003", "Ana Pereira", "(31) 5555-1234", "Praça C, 789"},
		};
		
		String[] colunas = {"CÓD", "NOME", "TELEFONE", "ENDEREÇO"};
		
		@SuppressWarnings("serial")
		DefaultTableModel model = new DefaultTableModel(data, colunas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Torna todas as células não editáveis
            }
        };
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 108, 524, 306);
		frameCliente.getContentPane().add(scrollPane);
		
		tableCliente = new JTable(model);
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
		NOME_INPUT.setColumns(10);
		NOME_INPUT.setBounds(66, 46, 204, 20);
		frameCliente.getContentPane().add(NOME_INPUT);
		
		JButton PESQUISAR_BTN = new JButton("PESQUISAR");
		PESQUISAR_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// >> CRUD SELECT
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
		EDITAR_BTN.setBounds(424, 49, 110, 23);
		frameCliente.getContentPane().add(EDITAR_BTN);
	}
}
