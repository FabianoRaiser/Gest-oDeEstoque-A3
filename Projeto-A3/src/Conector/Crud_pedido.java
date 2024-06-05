package Conector;



	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	import javax.swing.JOptionPane;


	public class Crud_pedido {
		
		public void DeletarPedido(int IdPedidoCompra) // METODO PARA DELETAR O PEDIDO
		{
			Connection conexao = null;
			PreparedStatement comando = null;
			
			
			try {
				conexao = ClasseConexao.Conectar();
				String sql = "DELETE FROM pedido where IdPedidoCompra=?";
				
				comando = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				comando.setInt(1,IdPedidoCompra);
				
				
				if(comando.executeUpdate()>0) {
					
					
					JOptionPane.showMessageDialog(null, "Pedido de Compra Excluído");
					
					
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
		
		
		public void DeletarPeca(int IdPedidoCompra, int IdPeca) // METODO PARA DELETAR 1 ITEM DO PEDIDO
		{
			Connection conexao = null;
			PreparedStatement comando = null;
			
			
			try {
				conexao = ClasseConexao.Conectar();
				String sql = "DELETE FROM pedido where IdPedidoCompra=? AND IdPeca=?";
				
				comando = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				comando.setInt(1,IdPedidoCompra);
				comando.setInt(2,IdPeca);
				
				
				if(comando.executeUpdate()>0) {
					
					
					JOptionPane.showMessageDialog(null, "Peça excluída do Pedido de Compra");
					
					
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
		
		
		public void Alterar(int IdPeca, double Quantidade, int IdPedidoCompra ) // METODO PARA ALTERAR O PEDIDO
		{
			Connection conexao = null;
			PreparedStatement comando = null;
			
			
			try {
				conexao = ClasseConexao.Conectar();
				String sql = "UPDATE pedido SET IdPeca=?,Quantidade=? WHERE IdPedidoCompra=?";
				
				comando = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				comando.setInt(1,IdPeca);
				comando.setDouble(2,Quantidade);
				comando.setInt(3,IdPedidoCompra);
				
				
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
				String sql = "SELECT * FROM pedido";
				comando = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
				resultado = comando.executeQuery(sql);
				
				return resultado;
				
			} catch (SQLException e) {
				return null;
				
			}
		}
		
		
		
		

		public void InserirPedido(int IdPeca, double Quantidade) // METODO PARA CRIAR O PEDIDO DE COMPRA
		{
			Connection conexao = null;
			PreparedStatement comando = null;
			ResultSet resultado = null;
			
			try {
				conexao = ClasseConexao.Conectar();
				String sql = "INSERT INTO pedido(IdPeca,Quantidade) VALUES(?,?)";
				
				comando = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				comando.setInt(1,IdPeca);
				comando.setDouble(2,Quantidade);
				
				
				
				
				if(comando.executeUpdate()>0) {
					resultado = comando.getGeneratedKeys(); // Pega o código gerado
					if(resultado.next()) {
						JOptionPane.showMessageDialog(null, "Pedido de Compra Gerado com o numero:  " + resultado.getInt(1));
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
		
		/*
		  				METODO PARA ADICIONAR 1 ITEM DIFERENTE NO MESMO PEDIDO DE COMPRA - PRECISA ARRUMAR O DATABASE
		 
		public void InserirPeca(int IdPeca, double Quantidade, int IdPedidoCompra) // METODO PARA ADICIONAR 1 PEÇA AO PEDIDO DE COMPRA
		{
			Connection conexao = null;
			PreparedStatement comando = null;
			ResultSet resultado = null;
			
			try {
				conexao = ClasseConexao.Conectar();
				String sql = "INSERT INTO pedido(IdPeca,Quantidade,IdPedidoCompra) VALUES(?,?,?)";
				
				comando = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				comando.setInt(1,IdPeca);
				comando.setDouble(2,Quantidade);
				comando.setInt(3,IdPedidoCompra);
				
				
				if(comando.executeUpdate()>0) {
					resultado = comando.getGeneratedKeys(); // Pega o código gerado
					if(resultado.next()) {
						JOptionPane.showMessageDialog(null, "Pedido de Compra Gerado com o numero:  " + resultado.getInt(1));
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
		*/    
	
	}