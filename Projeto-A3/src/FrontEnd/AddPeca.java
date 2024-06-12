package FrontEnd;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddPeca extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField NOME_INPUT;
	private JTextField PESO_INPUT;
	private JTextField MEDIDA_INPUT;
	private JTextField MARCA_INPUT;
	private JTextField MODELO_INPUT;
	private JTextField ANO_INPUT;
	private JTextField COR_INPUT;
	private JTextField COD_INPUT;

	JanelaUI UI = new JanelaUI();

	/**
	 * Create the frame.
	 */
	public AddPeca() {	
		
		// Config da janela
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 195);
		setTitle("Adiciopnar Peça");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		// Config dos Botões
		JButton ADD_BTN = new JButton("ADICIONAR");
		ADD_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		ADD_BTN.setBounds(244, 126, 110, 23);
		contentPane.add(ADD_BTN);
		
		JButton CANCELAR_BTN = new JButton("CANCELAR");
		CANCELAR_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		CANCELAR_BTN.setBounds(364, 126, 110, 23);
		contentPane.add(CANCELAR_BTN);
		
		
		// Config dos Labels
		JLabel nomeLabel = new JLabel("NOME:");
		nomeLabel.setBounds(10, 42, 46, 14);
		contentPane.add(nomeLabel);
		
		JLabel pesoLabel = new JLabel("PESO:");
		pesoLabel.setBounds(10, 70, 46, 14);
		contentPane.add(pesoLabel);
		
		JLabel medidaLabel = new JLabel("MEDIDA:");
		medidaLabel.setBounds(106, 70, 58, 14);
		contentPane.add(medidaLabel);
		
		JLabel marcaLabel = new JLabel("MARCA:");
		marcaLabel.setBounds(263, 70, 46, 14);
		contentPane.add(marcaLabel);
		
		JLabel modeloLabel = new JLabel("MODELO:");
		modeloLabel.setBounds(10, 98, 67, 14);
		contentPane.add(modeloLabel);
		
		JLabel corLabel = new JLabel("COR:");
		corLabel.setBounds(368, 98, 46, 14);
		contentPane.add(corLabel);
		
		JLabel anoLabel = new JLabel("ANO:");
		anoLabel.setBounds(263, 99, 36, 14);
		contentPane.add(anoLabel);
		
		// Config dos Inputs
		
		NOME_INPUT = new JTextField();
		NOME_INPUT.setEditable(false);
		NOME_INPUT.setBounds(50, 39, 419, 20);
		contentPane.add(NOME_INPUT);
		NOME_INPUT.setColumns(10);
		
		PESO_INPUT = new JTextField();
		PESO_INPUT.setEditable(false);
		PESO_INPUT.setBounds(50, 67, 46, 20);
		contentPane.add(PESO_INPUT);
		PESO_INPUT.setColumns(10);
		PESO_INPUT.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != '.') {
                    e.consume(); // Ignora caracteres não numéricos
                } else if (c == '.') {
                	JTextField source = (JTextField)e.getSource();
                    String text = source.getText();

                    // Se já houver um ponto no texto, não permite um novo ponto
                    if (text.contains(".")) {
                        e.consume();
                    }
                }
            }
			@Override
			public void keyPressed(KeyEvent e) {
				// NÃO UTILIZADO
			}
			@Override
			public void keyReleased(KeyEvent e) {
				// NÃO UTILIZADO
			}
		});
		
		MEDIDA_INPUT = new JTextField();
		MEDIDA_INPUT.setEditable(false);
		MEDIDA_INPUT.setColumns(10);
		MEDIDA_INPUT.setBounds(174, 67, 67, 20);
		contentPane.add(MEDIDA_INPUT);
		
		MARCA_INPUT = new JTextField();
		MARCA_INPUT.setEditable(false);
		MARCA_INPUT.setColumns(10);
		MARCA_INPUT.setBounds(319, 67, 150, 20);
		contentPane.add(MARCA_INPUT);
		
		MODELO_INPUT = new JTextField();
		MODELO_INPUT.setEditable(false);
		MODELO_INPUT.setColumns(10);
		MODELO_INPUT.setBounds(87, 95, 154, 20);
		contentPane.add(MODELO_INPUT);
		
		ANO_INPUT = new JTextField();
		ANO_INPUT.setEditable(false);
		ANO_INPUT.setColumns(10);
		ANO_INPUT.setBounds(298, 95, 60, 20);
		contentPane.add(ANO_INPUT);
		ANO_INPUT.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume(); // Ignora caracteres não numéricos
                }
            }
			@Override
			public void keyPressed(KeyEvent e) {
				// NÃO UTILIZADO
			}
			@Override
			public void keyReleased(KeyEvent e) {
				// NÃO UTILIZADO
			}
		});
		
		COR_INPUT = new JTextField();
		COR_INPUT.setEditable(false);
		COR_INPUT.setColumns(10);
		COR_INPUT.setBounds(401, 95, 68, 20);
		contentPane.add(COR_INPUT);
		
		JLabel codLabel = new JLabel("CÓD:");
		codLabel.setBounds(10, 11, 36, 14);
		contentPane.add(codLabel);
		
		COD_INPUT = new JTextField();
		COD_INPUT.setBounds(50, 8, 86, 20);
		contentPane.add(COD_INPUT);
		COD_INPUT.setColumns(10);
		
		JButton CONSULTA_BTN = new JButton("CONSULTAR");
		CONSULTA_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		CONSULTA_BTN.setBounds(152, 7, 100, 23);
		contentPane.add(CONSULTA_BTN);
	}
}
