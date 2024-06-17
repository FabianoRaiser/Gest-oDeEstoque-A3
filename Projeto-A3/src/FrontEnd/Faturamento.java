package FrontEnd;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Conector.Crud_faturamento;

import java.sql.ResultSet;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class Faturamento extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tableFaturamento;
	private JTextField FAT_INPUT;
	private JTextField OS_INPUT;
	private JTextField CLIENTE_INPUT;
	Crud_faturamento dataServer = new Crud_faturamento();
	JanelaUI ui = new JanelaUI();

	/**
	 * Create the panel.
	 */
	public Faturamento() {
		
		ResultSet resultado = dataServer.Selecionar();
		
		setLayout(null);
		setSize(650, 450);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 98, 630, 341);
		add(scrollPane);
		
		tableFaturamento = new JTable();
		//ui.AtualizaTabela(tableFaturamento, resultado);
		scrollPane.setViewportView(tableFaturamento);
		
		JLabel nFaturamentoLabel = new JLabel("Nº FATURAMENTO:");
		nFaturamentoLabel.setBounds(10, 11, 96, 14);
		add(nFaturamentoLabel);
		
		FAT_INPUT = new JTextField();
		FAT_INPUT.setBounds(116, 8, 96, 20);
		FAT_INPUT.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				dataServer.pesquisar_Fat(Integer.parseInt(FAT_INPUT.getText()), tableFaturamento);
			}
		});
		add(FAT_INPUT);
		FAT_INPUT.setColumns(10);
		
		JLabel nOSLabel = new JLabel("Nº OS:");
		nOSLabel.setBounds(222, 10, 44, 14);
		add(nOSLabel);
		
		OS_INPUT = new JTextField();
		OS_INPUT.setColumns(10);
		OS_INPUT.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				dataServer.pesquisar_OS(Integer.parseInt(OS_INPUT.getText()), tableFaturamento);
			}
		});
		OS_INPUT.setBounds(276, 9, 96, 20);
		add(OS_INPUT);
		
		JLabel nClienteLabel = new JLabel("Nº CLIENTE:");
		nClienteLabel.setBounds(10, 39, 96, 14);
		add(nClienteLabel);
		
		CLIENTE_INPUT = new JTextField();
		CLIENTE_INPUT.setColumns(10);
		CLIENTE_INPUT.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				dataServer.pesquisar_Cliente(Integer.parseInt(CLIENTE_INPUT.getText()), tableFaturamento);
			}
		});
		CLIENTE_INPUT.setBounds(116, 36, 96, 20);
		add(CLIENTE_INPUT);
		
		JButton ATUALIZAR_BTN = new JButton("ATUALIZAR");
		ATUALIZAR_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.AtualizaTabela(tableFaturamento, resultado);
			}
		});
		ATUALIZAR_BTN.setBounds(10, 64, 96, 23);
		add(ATUALIZAR_BTN);
		
		JButton NOVO_FAT_BTN = new JButton("NOVO");
		NOVO_FAT_BTN.setBounds(539, 11, 89, 23);
		add(NOVO_FAT_BTN);
		
		JButton EDITAR_BTN = new JButton("EDITAR");
		EDITAR_BTN.setBounds(540, 42, 89, 23);
		add(EDITAR_BTN);

	}
}
