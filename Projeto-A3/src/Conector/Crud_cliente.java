package Conector;


	
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	
	import javax.swing.JOptionPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;
	
	public class Crud_cliente {
		
		
		public void Deletar(int IdCliente)
		{
		
			Connection conexao = null;
			PreparedStatement comando = null;
			
			
			try {
				conexao = ClasseConexao.Conectar();
				String sql = "DELETE FROM cliente where IdCliente=?";
				
				comando = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				comando.setInt(1,IdCliente);
				
				
				if(comando.executeUpdate()>0) {
					
					
					JOptionPane.showMessageDialog(null, "Dados Excluidos");
					
					
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally {
				ClasseConexao.FecharConexao(conexao);
				try {
					comando.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		
		public void Alterar(int IdCliente, String Nome, String Telefone, String Endereco)	
		{
			Connection conexao = null;
			PreparedStatement comando = null;
			
			
			try {
				conexao = ClasseConexao.Conectar();
				String sql = "UPDATE cliente SET Nome=?,Telefone=?, Endereco=? WHERE IdCliente=?";
				
				comando = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				comando.setString(1,Nome);
				comando.setString(2,Telefone);
				comando.setString(3,Endereco);
				comando.setInt(4,IdCliente);
				
				if(comando.executeUpdate()>0) {
					
					
					JOptionPane.showMessageDialog(null, "Dados alterados com sucesso");
					
					
					
				}
	           		
			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally {
				ClasseConexao.FecharConexao(conexao);
				try {
					comando.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		public ResultSet Selecionar()
		{
			Connection conexao = null;
			Statement comando = null;
			ResultSet resultado = null;
			
			try {
				conexao = ClasseConexao.Conectar();
				String sql = "SELECT * FROM cliente";
				comando = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
				resultado = comando.executeQuery(sql);
				
				return resultado;
				
			} catch (SQLException e) {
				return null;
				
			} 
		}
		
		
		
		

		public void Inserir(String Nome, String Telefone, String Endereco)
		{
			Connection conexao = null;
			PreparedStatement comando = null;
			ResultSet resultado = null;
			
			try {
				conexao = ClasseConexao.Conectar();
				String sql = "INSERT INTO cliente(Nome,Telefone,Endereco) VALUES(?,?,?)";
				
				comando = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				comando.setString(1,Nome);
				comando.setString(2,Telefone);
				comando.setString(3,Endereco);
				
				
				
				
				if(comando.executeUpdate()>0) {
					resultado = comando.getGeneratedKeys(); // Pega o código gerado
					if(resultado.next()) {
						JOptionPane.showMessageDialog(null, "Cliente Cadastrado com o código: " + resultado.getInt(1));
						
					}
					
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally {
				ClasseConexao.FecharConexao(conexao);
				try {
					comando.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		public void pesquisar_cliente(String Nome, JTable tableCliente) {
			Connection conexao = null;
		    PreparedStatement comando = null;
		    String sql= "select * from cliente where Nome like ?";
			
			try {
				conexao = ClasseConexao.Conectar();
				comando = conexao.prepareStatement(sql);
				comando.setString(1, Nome + "%");
				ResultSet resultado = comando.executeQuery();
				
				tableCliente.setModel(DbUtils.resultSetToTableModel(resultado)); 
				
			} catch (SQLException e) {
		        e.printStackTrace();
		        return;

		    } finally {
		        ClasseConexao.FecharConexao(conexao);
		        try {
		            if (comando != null) {
		                comando.close();
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		  }
		public void pesquisar_codigo(int IdCliente, JTable tableCliente) {
			Connection conexao = null;
		    PreparedStatement comando = null;
		    String sql= "select * from cliente where IdCliente=?";
			
			try {
				conexao = ClasseConexao.Conectar();
				comando = conexao.prepareStatement(sql);
				comando.setInt(1, IdCliente);
				ResultSet resultado = comando.executeQuery();
				
				tableCliente.setModel(DbUtils.resultSetToTableModel(resultado)); 
				
			} catch (SQLException e) {
		        e.printStackTrace();
		        return;

		    } finally {
		        ClasseConexao.FecharConexao(conexao);
		        try {
		            if (comando != null) {
		                comando.close();
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		  }
	}	