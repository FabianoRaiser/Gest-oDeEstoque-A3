package FrontEnd;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Pedidos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablePedidos;
	private JTextField N_PEDIDOS_INPUT;
	private JTextField COD_PECA_INPUT;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pedidos frame = new Pedidos();
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
	public Pedidos() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 423);
		setTitle("Pedidos de Peças");
		try {
			String pedidosIconPath = "src/FrontEnd/images/pedidos-icon.png";
			Image pedidosIcon = Toolkit.getDefaultToolkit().getImage(pedidosIconPath);
			setIconImage(pedidosIcon);
		} catch (Exception e) {
			e.printStackTrace();
		}
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 75, 614, 300);
		contentPane.add(scrollPane);
		
		tablePedidos = new JTable();
		scrollPane.setViewportView(tablePedidos);
		
		JLabel nPedidoLabel = new JLabel("Nº PEDIDO:");
		nPedidoLabel.setBounds(10, 11, 75, 14);
		contentPane.add(nPedidoLabel);
		
		N_PEDIDOS_INPUT = new JTextField();
		N_PEDIDOS_INPUT.setBounds(84, 8, 114, 20);
		contentPane.add(N_PEDIDOS_INPUT);
		N_PEDIDOS_INPUT.setColumns(10);
		
		JLabel codPecaLabel = new JLabel("Nº PEÇA:");
		codPecaLabel.setBounds(230, 10, 55, 16);
		contentPane.add(codPecaLabel);
		
		COD_PECA_INPUT = new JTextField();
		COD_PECA_INPUT.setBounds(284, 8, 114, 20);
		contentPane.add(COD_PECA_INPUT);
		COD_PECA_INPUT.setColumns(10);
		
		JButton PESQUISAR_BTN = new JButton("PESQUISAR");
		PESQUISAR_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		PESQUISAR_BTN.setBounds(10, 37, 98, 26);
		contentPane.add(PESQUISAR_BTN);
		
		JButton CADASTRAR_INPUT = new JButton("CADASTRAR");
		CADASTRAR_INPUT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NovoPedido novoPedido = new NovoPedido();
				novoPedido.setVisible(true);
			}
		});
		CADASTRAR_INPUT.setBounds(526, 7, 98, 23);
		contentPane.add(CADASTRAR_INPUT);
		
		JButton EDITAR_BTN = new JButton("EDITAR");
		EDITAR_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		EDITAR_BTN.setBounds(527, 39, 98, 23);
		contentPane.add(EDITAR_BTN);
	}
}
