package FrontEnd;


import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NovoPedido extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;


	/**
	 * Create the frame.
	 */
	public NovoPedido() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Novo Pedido");
		try {
			String novoPedidoIconPath = "src/FrontEnd/images/pedidos-icon.png";
			Image novoPedidoIcon = Toolkit.getDefaultToolkit().getImage(novoPedidoIconPath);
			setIconImage(novoPedidoIcon);
		} catch (Exception e) {
			e.printStackTrace();
		}
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel pecasLabel = new JLabel("PEÇAS");
		pecasLabel.setBounds(10, 11, 46, 14);
		contentPane.add(pecasLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 38, 414, 170);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton CANCELAR_BTN = new JButton("CANCELAR");
		CANCELAR_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		CANCELAR_BTN.setBounds(335, 227, 89, 23);
		contentPane.add(CANCELAR_BTN);
		
		JButton SALVAR_BTN = new JButton("SALVAR");
		SALVAR_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		SALVAR_BTN.setBounds(236, 227, 89, 23);
		contentPane.add(SALVAR_BTN);
	}
}
