package FrontEnd;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import net.proteanit.sql.DbUtils;

public class JanelaUI {
	
	public void LookAndFeel() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void BloqueiaTeclasPonto(JTextField input) {
		input.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c)) {
					e.consume(); // Ignora caracteres não numéricos
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public void BloqueiaTeclas(JTextField input) {
		input.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)&& c != '.') {
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
	}
	
	public void ImagemIcon(JFrame janela, String iconName) {
		try {
			String iconPath = "src/FrontEnd/images/" + iconName + ".png";
			Image icon = Toolkit.getDefaultToolkit().getImage(iconPath);
			janela.setIconImage(icon);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void BotaoIcon(JButton botao, String iconName) {
		try {
			String iconPath = "src/FrontEnd/images/" + iconName + ".png";
			Image icon = Toolkit.getDefaultToolkit().getImage(iconPath).getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH);
			botao.setIcon(new ImageIcon(icon));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void AtualizaTabela(JTable table, ResultSet resultado) {
		try {
			while(resultado.next()) {
				// DATA para COMBOBOX
				//System.out.println(resultado.getString("nome"));
			}
			resultado.beforeFirst();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		table.setModel(DbUtils.resultSetToTableModel(resultado));
	}
	


}
