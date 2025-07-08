

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AuthServerConn {

	
	private final  String userName =  "sa";
	private final  String password = "BDLusofona2023";
	private final  String dbUrl = "jdbc:sqlserver://localhost:1433;databaseName=AuthServer;encrypt=false";
	
	
	public  Connection dataBaseConnection () {
		
		
		Connection conn = null;
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			System.out.println("Connection to database ... ");
			
			conn = DriverManager.getConnection(dbUrl, userName, password);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	} 
	
	
	public int obterIdUtilizador (String email) {
		
		PreparedStatement pstmt = null;
		Connection conn = dataBaseConnection();
		
		String sql = "SELECT * FROM usuarios WHERE email = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt(1);
				
				return id;

			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
	}
	
	public boolean registarUtilizador (String email, String password) {
		
		Integer passwordHash = password.hashCode();
		
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		
		int linhasAfetadas = 0;
		Connection conn = dataBaseConnection();
		
		String sql = "INSERT INTO usuarios (email, senha_hash) VALUES (?, ?)";
		String sqlConfirmacao = "SELECT * FROM usuarios WHERE email = ?";
		
		
		try {
			
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,email);
			pstmt.setInt(2, passwordHash);
			
			pstmt2 = conn.prepareStatement(sqlConfirmacao);
			pstmt2.setString(1, email);
			
			ResultSet rs = pstmt2.executeQuery();
			
			
			
			if(rs.next() == false) {
				linhasAfetadas = pstmt.executeUpdate();
			}
			
			
			return linhasAfetadas > 0;
			
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	
	public int getIdUsuario(String email) {
		
		
		PreparedStatement pstmt = null;
		int idUsuario = 0;
		
		Connection conn = dataBaseConnection();
		
		String sql = "SELECT * FROM usuarios WHERE email = ?";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				idUsuario = rs.getInt(1);
				
				return idUsuario;

			}
			
			
			
			
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
		
		return idUsuario;
		
		
		
	}
	
	
	public boolean loginUtilizador(String email, String password) {
		
		Integer passwordHash = password.hashCode();
		PreparedStatement pstmt = null;
		
		
		Connection conn = dataBaseConnection();
		
		String sql = "SELECT * FROM usuarios WHERE email = ? and senha_hash = ?";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setInt(2,passwordHash);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next() == false) {
				return  false;
			}else {
				return true;
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return false;
		
		
	}
	
	
	
	public  List<String> queryAuthServerTest() { 
		
		List<String> results = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = dataBaseConnection();
		
		String sql = "SELECT * FROM usuarios";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				results.add(rs.getString("email"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return results;
	}
	
	

	
	
	
}
