package Conector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class Crud_faturamento {

	public void Deletar(int IdFatu) {
		Connection conexao = null;
		PreparedStatement comando = null;
		
		try {
			conexao = ClasseConexao.Conectar();
			String sql = "DELETE FROM faturamento WHERE IdFaturamento = ?";
			
			comando = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			comando.setInt(1, IdFatu);
			
			if (comando.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "Faturamento Excluído");
			}
		} catch( SQLException e) {
			e.printStackTrace();
		} finally {
			ClasseConexao.FecharConexao(conexao);
			try {
				comando.close();
			} catch (SQLException e) {
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
			String sql = "SELECT f.IdFaturamento, fo.IdOS, f.IdCliente, o.ValorTotal FROM faturamento f JOIN faturamento_os fo ON f.IdFaturamento = fo.IdFaturamento JOIN os o ON o.IdOS = fo.IdOS";
			comando = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			resultado = comando.executeQuery(sql);
			
			return resultado;
			
		} catch (SQLException e) {
			return null;
			
		}
	}
	
	public void pesquisar_OS(int IdOS, JTable tableEstoque) {
		Connection conexao = null;
	    PreparedStatement comando = null;
	    String sql= "SELECT f.IdFaturamento, fo.IdOS, f.IdCliente, o.ValorTotal FROM faturamento f JOIN faturamento_os fo ON f.IdFaturamento = fo.IdFaturamento JOIN os o ON o.IdOS = fo.IdOS WHERE f.IdOS = ?";
		
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
	
	public void pesquisar_Fat(int IdFaturamento, JTable tableEstoque) {
		Connection conexao = null;
	    PreparedStatement comando = null;
	    String sql= "SELECT f.IdFaturamento, fo.IdOS, f.IdCliente, o.ValorTotal FROM faturamento f JOIN faturamento_os fo ON f.IdFaturamento = fo.IdFaturamento JOIN os o ON o.IdOS = fo.IdOS WHERE f.IdFaturamento = ?";
		
		try {
			conexao = ClasseConexao.Conectar();
			comando = conexao.prepareStatement(sql);
			comando.setInt(1,IdFaturamento);
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
	
	public void pesquisar_Cliente(int IdCliente, JTable tableEstoque) {
		Connection conexao = null;
	    PreparedStatement comando = null;
	    String sql= "SELECT f.IdFaturamento, f.IdOS, f.IdCliente, o.ValorTotal FROM faturamento f JOIN faturamento_os fo ON f.IdFaturamento = fo.IdFaturamento WHERE f.IdCliente = ?";
		
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
	
//	public void add_OS()
//}
}