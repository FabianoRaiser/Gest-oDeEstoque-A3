package Conector;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	import javax.swing.JOptionPane;


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
			
		
	}


