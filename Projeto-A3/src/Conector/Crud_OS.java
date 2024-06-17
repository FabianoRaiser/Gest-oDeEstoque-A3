package Conector;



	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;


	public class Crud_OS {
		
		public void Deletar(int IdOS)
		{
			Connection conexao = null;
			PreparedStatement comando = null;
			
			
			try {
				conexao = ClasseConexao.Conectar();
				String sql = "DELETE FROM os where IdOS=?";
				
				comando = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				comando.setInt(1,IdOS);
				
				
				if(comando.executeUpdate()>0) {
					
					
					JOptionPane.showMessageDialog(null, "Ordem de Serviço Excluída");
					
					
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
		
		public void Alterar_OS(String Descricao, double ValorServico,double ValorTotal, int IdOS  )
		{
			Connection conexao = null;
			PreparedStatement comando = null;
			
			
			try {
				conexao = ClasseConexao.Conectar();
				String sql = "UPDATE os SET Descricao = ?, ValorServico = ?, ValorTotal = ? WHERE IdOS = ?";
				
				comando = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				comando.setString(1,Descricao);
				comando.setDouble(2,ValorServico);
				comando.setDouble(3,ValorTotal);
				comando.setInt(4,IdOS);
				
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
				String sql = "SELECT * FROM os";
				comando = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
				resultado = comando.executeQuery(sql);
				
				return resultado;
				
			} catch (SQLException e) {
				return null;
				
			}
		}
		
		
		
		

		public void Inserir(int IdCliente, String Descricao, double ValorServico, double ValorTotal)
		{
			Connection conexao = null;
			PreparedStatement comando = null;
			ResultSet resultado = null;
			
			try {
				conexao = ClasseConexao.Conectar();
				String sql = "INSERT INTO os(IdCliente,Descricao,ValorServico,ValorTotal) VALUES(?,?,?,?)";
				
				comando = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				comando.setInt(1,IdCliente);
				comando.setString(2,Descricao);
				comando.setDouble(3,ValorServico);
				comando.setDouble(4,ValorTotal);
				
				
				if(comando.executeUpdate()>0) {
					resultado = comando.getGeneratedKeys(); // Pega o código gerado
					if(resultado.next()) {
						JOptionPane.showMessageDialog(null, "Ordem de Serviço Gerado com o numero:  " + resultado.getInt(1));
						
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
		
		public void Inserir_peca(int IdOS, int IdPeca, int Quantidade)
		{
			Connection conexao = null;
			PreparedStatement comando = null;
			ResultSet resultado = null;
			
			try {
				conexao = ClasseConexao.Conectar();
				String sql = "INSERT INTO os_peca(IdOS, IdPeca,Quantidade) VALUES(?,?,?)";
				
				comando = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				comando.setInt(1,IdOS);
				comando.setInt(2,IdPeca);
				comando.setInt(3,Quantidade);
				if(comando.executeUpdate()>0) {
					resultado = comando.getGeneratedKeys(); // Pega o código gerado
					if(resultado.next()) {
						JOptionPane.showMessageDialog(null, "PEÇA ADICIONADA COM SUCESSO  ");
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
		
		public void pesquisar_OS(int IdOS, JTable tableEstoque) {
			Connection conexao = null;
		    PreparedStatement comando = null;
		    String sql= "SELECT c.Nome, c.IdCliente, op.IdOS, op.IdPeca, op.Quantidade, o.ValorTotal FROM cliente c JOIN os o ON c.IdCliente = o.IdCliente JOIN os_peca op ON o.IdOS = op.IdOS WHERE op.IdOS=?";
			
			try {
				conexao = ClasseConexao.Conectar();
				comando = conexao.prepareStatement(sql);
				comando.setInt(1,IdOS);
				ResultSet resultado = comando.executeQuery();
				
				tableEstoque.setModel(DbUtils.resultSetToTableModel(resultado)); 
				
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
		
		public void pesquisar_idCli(int IdCliente, JTable tableEstoque) {
			Connection conexao = null;
		    PreparedStatement comando = null;
		    String sql= "SELECT c.Nome, c.IdCliente, op.IdOS, op.IdPeca, op.Quantidade, o.ValorTotal FROM cliente c JOIN os o ON c.IdCliente = o.IdCliente JOIN os_peca op ON o.IdOS = op.IdOS WHERE c.IdCliente=?";
			
			try {
				conexao = ClasseConexao.Conectar();
				comando = conexao.prepareStatement(sql);
				comando.setInt(1,IdCliente);
				ResultSet resultado = comando.executeQuery();
				
				tableEstoque.setModel(DbUtils.resultSetToTableModel(resultado)); 
				
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
		
		
		
		
		//TENTATIVA DE SETAR O NOME NA TELA ORDEM DE SERVIÇO QUANDO CHAMA O IdOS - NÃO FUNCIONAL ATE O MOMENTO
		public void setar_nome(int IdOS) {       
			Connection conexao = null;
		    PreparedStatement comando = null;
		    String sql= "SELECT c.Nome FROM cliente c JOIN os o ON c.IdCliente = o.IdCliente WHERE o.IdOS =?";
			
			try {
				conexao = ClasseConexao.Conectar();
				comando = conexao.prepareStatement(sql);
				comando.setInt(1,IdOS);
			    comando.executeQuery();
				
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
		