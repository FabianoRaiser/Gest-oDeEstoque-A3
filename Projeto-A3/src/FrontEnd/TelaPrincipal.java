package FrontEnd;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class TelaPrincipal {

    private JFrame frame;
    private JTabbedPane painel;
    
    JanelaUI ui = new JanelaUI();

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
    
    private void abrirNovaTela() {
		TelaPrincipal novaTela = new TelaPrincipal();
		novaTela.frame.setVisible(true);
	}

    /**
     * Create the application.
     */
    public TelaPrincipal() {
    
        frame = new JFrame();
        frame.setBounds(100, 100, 690, 545);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        ui.LookAndFeel();
        
        painel = new JTabbedPane();
        painel.setBounds(5, 25, 665, 490);
        frame.getContentPane().add(painel);
        
        JPanel estoque = new estoque();
        JPanel pedidos = new Pedidos();
        JPanel clientes = new Cliente();
        JPanel ordens	= new OrdensDeServico();
        JPanel faturamento = new Faturamento();
        
        painel.addTab("Estoque", estoque);
        painel.addTab("Pedidos", pedidos);
        painel.addTab("Clientes", clientes);
        painel.addTab("Ordens", ordens);
        painel.addTab("Faturamento", faturamento);
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 784, 22);
        frame.getContentPane().add(menuBar);
        
        JMenuItem itemNovaTela = new JMenuItem("Nova Janela");
        itemNovaTela.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
        itemNovaTela.addActionListener(e -> abrirNovaTela());
        
        
        JMenuItem itemSair = new JMenuItem("Sair");
        itemSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, InputEvent.SHIFT_DOWN_MASK));
        itemSair.addActionListener(e -> frame.dispose());
        
        JMenu menu = new JMenu("Menu");
        menu.add(itemNovaTela);
        menu.addSeparator();
        menu.add(itemSair);
        
        menuBar.add(menu);
        
    }
}
