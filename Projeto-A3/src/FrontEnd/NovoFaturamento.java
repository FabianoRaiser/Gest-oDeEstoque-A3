package FrontEnd;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class NovoFaturamento extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField N_OS_INPUT;


	/**
	 * Create the frame.
	 */
	public NovoFaturamento() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton CANCELAR_BTN = new JButton("CANCELAR");
		CANCELAR_BTN.setBounds(335, 227, 89, 23);
		contentPane.add(CANCELAR_BTN);
		
		JButton SALVAR_BTN = new JButton("SALVAR");
		SALVAR_BTN.setBounds(236, 227, 89, 23);
		contentPane.add(SALVAR_BTN);
		
		JLabel OSLabel = new JLabel("Nº OS:");
		OSLabel.setBounds(10, 11, 46, 14);
		contentPane.add(OSLabel);
		
		N_OS_INPUT = new JTextField();
		N_OS_INPUT.setBounds(66, 8, 86, 20);
		contentPane.add(N_OS_INPUT);
		N_OS_INPUT.setColumns(10);
	}

}
