package FrontEnd;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField NOME_INPUT;
	private JTextField TELEFONE_INPUT;
	private JTextField ENDERECO_INPUT;
	private JTextField TELEFONE2_INPUT;
	private JButton SALVAR_BTN;
	private JButton CANCELAR_BTN;

	/**
	 * Create the frame.
	 */
	public CadastroCliente() {
		setTitle("Cadastrar Novo Cliente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 175);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nomeLabel = new JLabel("NOME:");
		nomeLabel.setBounds(10, 24, 46, 14);
		contentPane.add(nomeLabel);
		
		JLabel telefoneLabel = new JLabel("TELEFONE:");
		telefoneLabel.setBounds(10, 49, 73, 14);
		contentPane.add(telefoneLabel);
		
		JLabel telefone2Label = new JLabel("TELEFONE2:");
		telefone2Label.setBounds(216, 49, 73, 14);
		contentPane.add(telefone2Label);
		
		JLabel enderecoLabel = new JLabel("ENDEREÇO:");
		enderecoLabel.setBounds(10, 74, 73, 14);
		contentPane.add(enderecoLabel);
		
		NOME_INPUT = new JTextField();
		NOME_INPUT.setBounds(66, 21, 358, 20);
		contentPane.add(NOME_INPUT);
		NOME_INPUT.setColumns(10);
		
		TELEFONE_INPUT = new JTextField();
		TELEFONE_INPUT.setColumns(10);
		TELEFONE_INPUT.setBounds(76, 46, 125, 20);
		contentPane.add(TELEFONE_INPUT);
		
		ENDERECO_INPUT = new JTextField();
		ENDERECO_INPUT.setColumns(10);
		ENDERECO_INPUT.setBounds(86, 71, 338, 20);
		contentPane.add(ENDERECO_INPUT);
		
		TELEFONE2_INPUT = new JTextField();
		TELEFONE2_INPUT.setColumns(10);
		TELEFONE2_INPUT.setBounds(299, 46, 125, 20);
		contentPane.add(TELEFONE2_INPUT);
		
		SALVAR_BTN = new JButton("SALVAR");
		SALVAR_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// >> CRUD INSERT
			}
		});
		SALVAR_BTN.setBounds(194, 102, 110, 23);
		contentPane.add(SALVAR_BTN);
		
		CANCELAR_BTN = new JButton("CANCELAR");
		CANCELAR_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		CANCELAR_BTN.setBounds(314, 102, 110, 23);
		contentPane.add(CANCELAR_BTN);
	}

}
