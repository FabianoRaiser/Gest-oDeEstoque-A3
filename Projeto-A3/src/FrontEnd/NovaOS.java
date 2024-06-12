package FrontEnd;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NovaOS extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField NOME_INPUT;
	private JTable tablePecasOS;
	private JTextField MAO_OBRA_INPUT;
	private JTextField textField_1;

	JanelaUI UI = new JanelaUI();

	/**
	 * Create the frame.
	 */
	public NovaOS() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 530);
		setTitle("Nova OS");
		try {
			String novaOSIconPath = "src/FrontEnd/images/newOS-icon.png";
			Image novaOSIcon = Toolkit.getDefaultToolkit().getImage(novaOSIconPath);
			setIconImage(novaOSIcon);
		} catch (Exception e) {
			e.printStackTrace();
		}
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel codClienteLabel = new JLabel("CLIENTE:");
		codClienteLabel.setBounds(10, 13, 73, 14);
		contentPane.add(codClienteLabel);
		
		textField = new JTextField();
		textField.setBounds(93, 10, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel cliNomeLabel = new JLabel("NOME:");
		cliNomeLabel.setBounds(10, 43, 73, 14);
		contentPane.add(cliNomeLabel);
		
		NOME_INPUT = new JTextField();
		NOME_INPUT.setEditable(false);
		NOME_INPUT.setBounds(93, 40, 381, 20);
		contentPane.add(NOME_INPUT);
		NOME_INPUT.setColumns(10);
		
		JLabel DescricaoLabel = new JLabel("DESCRIÇÃO:");
		DescricaoLabel.setBounds(10, 73, 73, 14);
		contentPane.add(DescricaoLabel);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 98, 464, 80);
		contentPane.add(textPane);
		
		JLabel pecasLabel = new JLabel("PEÇAS:");
		pecasLabel.setBounds(10, 214, 73, 14);
		contentPane.add(pecasLabel);
		
		tablePecasOS = new JTable();
		tablePecasOS.setBounds(10, 239, 464, 150);
		contentPane.add(tablePecasOS);
		
		JLabel valorMaoObraLabel = new JLabel("VALOR MÃO DE OBRA:");
		valorMaoObraLabel.setBounds(10, 189, 150, 14);
		contentPane.add(valorMaoObraLabel);
		
		MAO_OBRA_INPUT = new JTextField();
		MAO_OBRA_INPUT.setBounds(160, 186, 86, 20);
		contentPane.add(MAO_OBRA_INPUT);
		MAO_OBRA_INPUT.setColumns(10);
		
		JLabel valorTotalLabel = new JLabel("VALOR TOTAL:");
		valorTotalLabel.setBounds(10, 403, 85, 14);
		contentPane.add(valorTotalLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(115, 400, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton CANCELAR_BTN = new JButton("CANCELAR");
		CANCELAR_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		CANCELAR_BTN.setBounds(364, 457, 110, 23);
		contentPane.add(CANCELAR_BTN);
		
		JButton SALVAR_INPUT = new JButton("SALVAR");
		SALVAR_INPUT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// CRUD SALVAR
			}
		});
		SALVAR_INPUT.setBounds(243, 457, 110, 23);
		contentPane.add(SALVAR_INPUT);
		
		JButton ADD_PECA_BTN = new JButton("");
		ADD_PECA_BTN.setBounds(416, 205, 24, 23);
		UI.BotaoIcon(ADD_PECA_BTN, "add_icon");
		contentPane.add(ADD_PECA_BTN);
		
		JButton DEL_PECA_BTN = new JButton("");
		DEL_PECA_BTN.setBounds(450, 205, 24, 23);
		UI.BotaoIcon(DEL_PECA_BTN, "del_icon");
		contentPane.add(DEL_PECA_BTN);
	}
}
