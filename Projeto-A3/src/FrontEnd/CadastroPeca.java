package FrontEnd;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CadastroPeca extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField NOME_INPUT;
	private JTextField PESO_INPUT;
	private JTextField MEDIDA_INPUT;
	private JTextField MARCA_INPUT;
	private JTextField MODELO_INPUT;
	private JTextField ANO_INPUT;
	private JTextField COR_INPUT;
	private JTextField VALOR_INPUT;

	

	/**
	 * Create the frame.
	 */
	public CadastroPeca() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 224);
		setTitle("Novo Cadastro");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton SALVAR_BTN = new JButton("SALVAR");
		SALVAR_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		SALVAR_BTN.setBounds(274, 149, 89, 23);
		contentPane.add(SALVAR_BTN);
		
		JButton CANCELAR_BTN = new JButton("CANCELAR");
		CANCELAR_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		CANCELAR_BTN.setBounds(373, 149, 89, 23);
		contentPane.add(CANCELAR_BTN);
		
		JLabel nomeLabel = new JLabel("NOME:");
		nomeLabel.setBounds(10, 22, 46, 14);
		contentPane.add(nomeLabel);
		
		JLabel pesoLabel = new JLabel("PESO:");
		pesoLabel.setBounds(10, 50, 46, 14);
		contentPane.add(pesoLabel);
		
		JLabel medidaLabel = new JLabel("MEDIDA:");
		medidaLabel.setBounds(106, 50, 58, 14);
		contentPane.add(medidaLabel);
		
		JLabel marcaLabel = new JLabel("MARCA:");
		marcaLabel.setBounds(263, 50, 46, 14);
		contentPane.add(marcaLabel);
		
		JLabel modeloLabel = new JLabel("MODELO:");
		modeloLabel.setBounds(10, 78, 67, 14);
		contentPane.add(modeloLabel);
		
		JLabel corLabel = new JLabel("COR:");
		corLabel.setBounds(368, 78, 46, 14);
		contentPane.add(corLabel);
		
		JLabel anoLabel = new JLabel("ANO:");
		anoLabel.setBounds(263, 79, 36, 14);
		contentPane.add(anoLabel);
		
		JLabel valorLabel = new JLabel("VALOR:");
		valorLabel.setBounds(10, 113, 46, 14);
		contentPane.add(valorLabel);
		
		NOME_INPUT = new JTextField();
		NOME_INPUT.setBounds(50, 19, 419, 20);
		contentPane.add(NOME_INPUT);
		NOME_INPUT.setColumns(10);
		
		PESO_INPUT = new JTextField();
		PESO_INPUT.setBounds(50, 47, 46, 20);
		contentPane.add(PESO_INPUT);
		PESO_INPUT.setColumns(10);
		
		MEDIDA_INPUT = new JTextField();
		MEDIDA_INPUT.setColumns(10);
		MEDIDA_INPUT.setBounds(174, 47, 67, 20);
		contentPane.add(MEDIDA_INPUT);
		
		MARCA_INPUT = new JTextField();
		MARCA_INPUT.setColumns(10);
		MARCA_INPUT.setBounds(319, 47, 150, 20);
		contentPane.add(MARCA_INPUT);
		
		MODELO_INPUT = new JTextField();
		MODELO_INPUT.setColumns(10);
		MODELO_INPUT.setBounds(87, 75, 154, 20);
		contentPane.add(MODELO_INPUT);
		
		ANO_INPUT = new JTextField();
		ANO_INPUT.setColumns(10);
		ANO_INPUT.setBounds(298, 75, 60, 20);
		contentPane.add(ANO_INPUT);
		
		COR_INPUT = new JTextField();
		COR_INPUT.setColumns(10);
		COR_INPUT.setBounds(401, 75, 68, 20);
		contentPane.add(COR_INPUT);
		
		VALOR_INPUT = new JTextField();
		VALOR_INPUT.setColumns(10);
		VALOR_INPUT.setBounds(55, 110, 89, 20);
		contentPane.add(VALOR_INPUT);
	}
}
