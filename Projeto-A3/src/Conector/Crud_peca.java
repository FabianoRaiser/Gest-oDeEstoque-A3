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


	public class Crud_peca {
		
		public void Deletar(int IdPeca)
		{
			Connection conexao = null;
			PreparedStatement comando = null;
			
			
			try {
				conexao = ClasseConexao.Conectar();
				String sql = "DELETE FROM peca where IdPeca=?";
				
				comando = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				comando.setInt(1,IdPeca);
				
				
				if(comando.executeUpdate()>0) {
					
					
					JOptionPane.showMessageDialog(null, "Peça Excluída");
					
					
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
		
		public void Alterar(int IdPeca, String Nome, double Peso, String Medida, String Marca, String Modelo, int Ano, String Cor, double Valor)
		{
			Connection conexao = null;
			PreparedStatement comando = null;
			
			
			try {
				conexao = ClasseConexao.Conectar();
				String sql = "UPDATE peca SET Nome=?,Peso=?,Medida=?,Marca=?,Modelo=?,Ano=?,Cor=?,Valor=? WHERE IdPeca=?";
				
				comando = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				comando.setString(1,Nome);
				comando.setDouble(2,Peso);
				comando.setString(3,Medida);
				comando.setString(4,Marca);
				comando.setString(5,Modelo);
				comando.setInt(6,Ano);
				comando.setString(7,Cor);
				comando.setDouble(8,Valor);
				comando.setInt(9,IdPeca);
				
				if(comando.executeUpdate()>0) {
					
					
					JOptionPane.showMessageDialog(null,"Dados alterados com sucesso");
					
					
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
				String sql = "SELECT * FROM peca";
				comando = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
				resultado = comando.executeQuery(sql);
				
				return resultado;
				
			} catch (SQLException e) {
				return null;
				
			}
		}
		
		

		public void Inserir(String Nome,double Peso, String Medida, String Marca, String Modelo, int Ano, String Cor, double Valor)
		{
			Connection conexao = null;
			PreparedStatement comando = null;
			ResultSet resultado = null;
			
			try {
				conexao = ClasseConexao.Conectar();
				String sql = "INSERT INTO peca(Nome,Peso,Medida,Marca,Modelo,Ano,Cor,Valor) VALUES(?,?,?,?,?,?,?,?)";
				
				comando = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				comando.setString(1,Nome);
				comando.setDouble(2,Peso);
				comando.setString(3,Medida);
				comando.setString(4,Marca);
				comando.setString(5,Modelo);
				comando.setInt(6,Ano);
				comando.setString(7,Cor);
				comando.setDouble(8,Valor);
				
				
				
				
				if(comando.executeUpdate()>0) {
					resultado = comando.getGeneratedKeys(); // Pega o código gerado
					if(resultado.next()) {
						JOptionPane.showMessageDialog(null,"Peça Cadastrada com o codigo: " + resultado.getInt(1));
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
		public void baixar_estoque(int IdPeca, double Quantidade) {
	        Connection conexao = null;
	        PreparedStatement comando = null;

	        try {
	            conexao = ClasseConexao.Conectar();
	            String sql = "UPDATE peca SET Quantidade = Quantidade - ? WHERE idPeca = ? AND Quantidade >= ?";

	            comando = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	            comando.setDouble(1, Quantidade);
	            comando.setInt(2, IdPeca);
	            comando.setDouble(3, Quantidade);

	            int rowsAffected = comando.executeUpdate();
	            if (rowsAffected > 0) {
	                JOptionPane.showMessageDialog(null, "Baixa de Estoque Realizada com Sucesso");
	            } else {
	                JOptionPane.showMessageDialog(null, "Falha ao realizar baixa de estoque: estoque insuficiente ou produto não encontrado");
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Erro ao realizar baixa de estoque: " + e.getMessage());
	        } finally {
	            if (comando != null) {
	                try {
	                    comando.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	            if (conexao != null) {
	                ClasseConexao.FecharConexao(conexao);
	            }
	        }
	    }
		
	}


