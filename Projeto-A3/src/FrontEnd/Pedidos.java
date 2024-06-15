package FrontEnd;


import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Pedidos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tablePedidos;
	private JTextField N_PEDIDOS_INPUT;
	private JTextField COD_PECA_INPUT;

	
	public Pedidos() {
		
		setSize(650, 450);
		setLayout(null);
				
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 75, 630, 364);
		add(scrollPane);
		
		tablePedidos = new JTable();
		scrollPane.setViewportView(tablePedidos);
		
		JLabel nPedidoLabel = new JLabel("Nº PEDIDO:");
		nPedidoLabel.setBounds(10, 11, 75, 14);
		add(nPedidoLabel);
		
		N_PEDIDOS_INPUT = new JTextField();
		N_PEDIDOS_INPUT.setBounds(84, 8, 114, 20);
		add(N_PEDIDOS_INPUT);
		N_PEDIDOS_INPUT.setColumns(10);
		
		JLabel codPecaLabel = new JLabel("Nº PEÇA:");
		codPecaLabel.setBounds(230, 10, 55, 16);
		add(codPecaLabel);
		
		COD_PECA_INPUT = new JTextField();
		COD_PECA_INPUT.setBounds(284, 8, 114, 20);
		add(COD_PECA_INPUT);
		COD_PECA_INPUT.setColumns(10);
		
		JButton PESQUISAR_BTN = new JButton("PESQUISAR");
		PESQUISAR_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		PESQUISAR_BTN.setBounds(10, 37, 98, 26);
		add(PESQUISAR_BTN);
		
		JButton CADASTRAR_INPUT = new JButton("CADASTRAR");
		CADASTRAR_INPUT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NovoPedido novoPedido = new NovoPedido();
				novoPedido.setVisible(true);
			}
		});
		CADASTRAR_INPUT.setBounds(541, 8, 98, 23);
		add(CADASTRAR_INPUT);
		
		JButton EDITAR_BTN = new JButton("EDITAR");
		EDITAR_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		EDITAR_BTN.setBounds(542, 40, 98, 23);
		add(EDITAR_BTN);
	}
}
