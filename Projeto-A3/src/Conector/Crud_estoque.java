package Conector;



	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;


	public class Crud_estoque {
		
		public void Deletar(int IdEstoque)
		{
			Connection conexao = null;
			PreparedStatement comando = null;
			
			
			try {
				conexao = ClasseConexao.Conectar();
				String sql = "DELETE FROM estoque where IdEstoque=?";
				
				comando = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				comando.setInt(1,IdEstoque);
				
				
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
		
		public void Alterar(int IdEstoque, int IdPeca, double QuantidadeDisponivel	)
		{
			Connection conexao = null;
			PreparedStatement comando = null;
			
			
			try {
				conexao = ClasseConexao.Conectar();
				String sql = "UPDATE estoque SET QuantidadeDisponivel=?,IdPeca=? WHERE IdEstoque=?";
				
				comando = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				comando.setDouble(1,QuantidadeDisponivel);
				comando.setInt(2,IdPeca);
				comando.setInt(3,IdEstoque);
				
				
				if(comando.executeUpdate()>0) {
					
					
					System.out.println("Dados alterados com sucesso");
					
					
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
				String sql = "SELECT * FROM estoque";
				comando = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
				resultado = comando.executeQuery(sql);
				
				return resultado;
				
			} catch (SQLException e) {
				return null;
				
			}
		}
		
		
		
		

		public void Inserir(int IdEstoque, int IdPeca, double QuantidadeDisponivel)
		{
			Connection conexao = null;
			PreparedStatement comando = null;
			ResultSet resultado = null;
			
			try {
				conexao = ClasseConexao.Conectar();
				String sql = "INSERT INTO estoque(QuantidadeDisponivel,IdPeca,IdEstoque) VALUES(?,?,?)";
				
				comando = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				comando.setDouble(1,QuantidadeDisponivel);
				comando.setInt(2,IdPeca);
				comando.setInt(3,IdEstoque);
				
				
				
				if(comando.executeUpdate()>0) {
					resultado = comando.getGeneratedKeys(); // Pega o código gerado
					if(resultado.next()) {
						System.out.println("Dados gravados na tabela com o código: " + resultado.getInt(1));
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
		
		public void pesquisar_peca(String Nome, JTable tableEstoque) {
			Connection conexao = null;
		    PreparedStatement comando = null;
		    String sql= "select * from peca where Nome like ?";
			
			try {
				conexao = ClasseConexao.Conectar();
				comando = conexao.prepareStatement(sql);
				comando.setString(1, Nome + "%");
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

		public void pesquisar_modelo(String Modelo, JTable tableEstoque) {
			Connection conexao = null;
		    PreparedStatement comando = null;
		    String sql= "select * from peca where Modelo like ?";
			
			try {
				conexao = ClasseConexao.Conectar();
				comando = conexao.prepareStatement(sql);
				comando.setString(1, Modelo + "%");
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
			
		public void pesquisar_marca(String Marca, JTable tableEstoque) {
			Connection conexao = null;
		    PreparedStatement comando = null;
		    String sql= "select * from peca where Marca like ?";
			
			try {
				conexao = ClasseConexao.Conectar();
				comando = conexao.prepareStatement(sql);
				comando.setString(1,Marca + "%");
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
		public void pesquisar_ano(JComboBox<Object> ANO_DROPDOWN, JTable tableEstoque) {

	        Connection conexao = null;
	        PreparedStatement comando = null;
	        String sql = "SELECT * FROM peca WHERE Ano=?";

	        try {
	            conexao = ClasseConexao.Conectar();
	            comando = conexao.prepareStatement(sql);
	            comando.setString(1, ANO_DROPDOWN.getSelectedItem() .toString());
	            ResultSet resultado = comando.executeQuery();

	            tableEstoque.setModel(DbUtils.resultSetToTableModel(resultado));

	        } catch (SQLException e) {
	            e.printStackTrace();
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
		
		public void pesquisar_codigo(int IdPeca, JTable tableEstoque) {
			Connection conexao = null;
		    PreparedStatement comando = null;
		    String sql= "select * from peca where IdPeca=?";
			
			try {
				conexao = ClasseConexao.Conectar();
				comando = conexao.prepareStatement(sql);
				comando.setString(1,IdPeca + "%"); 
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
	}

