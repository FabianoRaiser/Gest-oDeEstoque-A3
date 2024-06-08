package FrontEnd;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrdensDeServico extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableOrdens;
	private JTextField OS_INPUT;
	private JTextField CLI_COD_INPUT;
	private JTextField CLI_NOME_INPUT;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrdensDeServico frame = new OrdensDeServico();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OrdensDeServico() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 400);
		setTitle("Ordens de Serviço");
		try {
			String osIconPath = "src/FrontEnd/images/os-icon.png";
			Image osIcon = Toolkit.getDefaultToolkit().getImage(osIconPath);
			setIconImage(osIcon);
		}catch (Exception e) {
			e.printStackTrace();
		}
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 104, 435, 246);
		contentPane.add(scrollPane);
		
		tableOrdens = new JTable();
		scrollPane.setViewportView(tableOrdens);
		
		JLabel ordemLabel = new JLabel("Nº OS:");
		ordemLabel.setBounds(10, 14, 56, 14);
		contentPane.add(ordemLabel);
		
		JLabel cliCodLabel = new JLabel("CÓD:");
		cliCodLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		cliCodLabel.setBounds(172, 14, 56, 14);
		contentPane.add(cliCodLabel);
		
		OS_INPUT = new JTextField();
		OS_INPUT.setBounds(76, 11, 86, 20);
		contentPane.add(OS_INPUT);
		OS_INPUT.setColumns(10);
		
		CLI_COD_INPUT = new JTextField();
		CLI_COD_INPUT.setBounds(239, 11, 86, 20);
		contentPane.add(CLI_COD_INPUT);
		CLI_COD_INPUT.setColumns(10);
		
		CLI_NOME_INPUT = new JTextField();
		CLI_NOME_INPUT.setEditable(false);
		CLI_NOME_INPUT.setBounds(76, 39, 250, 20);
		contentPane.add(CLI_NOME_INPUT);
		CLI_NOME_INPUT.setColumns(10);
		
		JLabel cliNomeLabel = new JLabel("CLIENTE:");
		cliNomeLabel.setBounds(10, 42, 56, 14);
		contentPane.add(cliNomeLabel);
		
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
		NOVA_OS_BTN.setBounds(335, 10, 110, 23);
		contentPane.add(NOVA_OS_BTN);
		
		JButton EDITAR_BTN = new JButton("EDITAR");
		EDITAR_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditarOS editarOS = new EditarOS();
				editarOS.setVisible(true);
			}
		});
		EDITAR_BTN.setBounds(336, 38, 110, 23);
		contentPane.add(EDITAR_BTN);
		
		JButton PESQUISAR_BTN = new JButton("PESQUISAR");
		PESQUISAR_BTN.setBounds(10, 70, 110, 23);
		contentPane.add(PESQUISAR_BTN);
	}
}
