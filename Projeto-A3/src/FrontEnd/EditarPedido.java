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
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class EditarPedido extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField COD_PEDIDO;


	/**
	 * Create the frame.
	 */
	public EditarPedido() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 306);
		setTitle("Editar Pedido");
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
		pecasLabel.setBounds(10, 36, 46, 14);
		contentPane.add(pecasLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 61, 414, 170);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton CANCELAR_BTN = new JButton("CANCELAR");
		CANCELAR_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		CANCELAR_BTN.setBounds(335, 242, 89, 23);
		contentPane.add(CANCELAR_BTN);
		
		JButton SALVAR_BTN = new JButton("SALVAR");
		SALVAR_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// CRUD
			}
		});
		SALVAR_BTN.setBounds(236, 242, 89, 23);
		contentPane.add(SALVAR_BTN);
		
		JLabel codPedidoLabel = new JLabel("Nº PEDIDO:");
		codPedidoLabel.setBounds(10, 11, 57, 14);
		contentPane.add(codPedidoLabel);
		
		COD_PEDIDO = new JTextField();
		COD_PEDIDO.setEditable(false);
		COD_PEDIDO.setBounds(77, 8, 86, 20);
		contentPane.add(COD_PEDIDO);
		COD_PEDIDO.setColumns(10);
		
		JLabel statusLabel = new JLabel("STATUS:");
		statusLabel.setBounds(260, 12, 46, 14);
		contentPane.add(statusLabel);
		
		JComboBox<String> STATUS_INPUT = new JComboBox<String>();
		STATUS_INPUT.setModel(new DefaultComboBoxModel<String>(new String[] {"PROCESSANDO", "FECHADO", "CONCLUIDO"}));
		STATUS_INPUT.setBounds(316, 8, 108, 22);
		contentPane.add(STATUS_INPUT);
	}
}
