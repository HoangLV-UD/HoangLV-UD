package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class jdbc {
	static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static String dbUrl = "jdbc:sqlserver://localhost:1433;databaseName=app;encrypt=true;trustServerCertificate=true;";
	static String user = "sa";
	static String pass ="123456";
	
	static {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public static PreparedStatement getStmt(String sql, Object...args)throws Exception{
	
			Connection conn = DriverManager.getConnection(dbUrl, user,pass);
			PreparedStatement stmt = null;
			if(sql.trim().startsWith("{")) {
				stmt = conn.prepareCall(sql); 
			}else {
				stmt = conn.prepareStatement(sql); 
			}
			for (int i=0; i <args.length; i++) {
				stmt.setObject(i +1, args[i]);
			}
		
		return stmt;
				
	}
	public static ResultSet query(String sql, Object... args) throws Exception {
        PreparedStatement stmt = jdbc.getStmt(sql, args);
        return stmt.executeQuery();
    }
	
	public static PreparedStatement preparedStatement(String sql,Object...args)throws SQLException{
		Connection connection = DriverManager.getConnection(dbUrl,user,pass);
		PreparedStatement statment = null;
		if(sql.trim().startsWith("{")) {
			statment = connection.prepareCall(sql);
		}else {
			statment =connection.prepareStatement(sql);
		}
		for(int i =0; i < args.length; i++) {
			statment.setObject(i + 1, args[i]);
		}
		return statment;
		
	}
	public static ResultSet executeQuery(String sql, Object... args) {
        try {
            PreparedStatement statement = preparedStatement(sql, args);
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
	 public static Object value(String sql, Object... args) {
	        try {
	            ResultSet rs = jdbc.query(sql, args);
	            if (rs.next()) {
	                return rs.getObject(0);
	            }
	            rs.getStatement().getConnection().close();
	            return null;
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }
	 public static int update(String sql, Object... args) {
	        try {
	            PreparedStatement stmt = jdbc.getStmt(sql, args);
	            try {
	                return stmt.executeUpdate();
	            } finally {
	                stmt.getConnection().close();
	            }
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }
}	
