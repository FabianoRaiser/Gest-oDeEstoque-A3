package FrontEnd;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaPrincipal {

    private JFrame frame;
    private JDesktopPane painel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaPrincipal window = new TelaPrincipal();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public TelaPrincipal() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 800, 580);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        painel = new JDesktopPane();
        painel.setBounds(10, 33, 764, 497);
        frame.getContentPane().add(painel);
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 784, 22);
        frame.getContentPane().add(menuBar);
        
        JMenu menuPeca = new JMenu("Peças");
        menuPeca.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        	}
        });
        menuBar.add(menuPeca);
        
        
        
        JMenu menuCliente = new JMenu("Clientes");
        menuBar.add(menuCliente);
        
        OrdensDeServico telaOS = new OrdensDeServico();
        
        JMenu menuOS = new JMenu("OS");
        menuOS.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		telaOS.setVisible(true);
        		painel.add(telaOS);
        	}
        });
        menuBar.add(menuOS);
        
        Pedidos telaPedido = new Pedidos();
        
        JMenu menuPedido = new JMenu("Pedidos");
        menuPedido.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		telaPedido.setVisible(true);
        		painel.add(telaPedido);
        	}
        });
        menuBar.add(menuPedido);
    }
}
