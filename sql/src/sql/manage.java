package sql;

import java.sql.*;

public class manage {
		public int insert(String table,String tablename,String values) {
			var t = drive.getConnection();
			try {
			
				PreparedStatement ps = t.prepareStatement("INSERT INTO "+table+"("+tablename+") values("+values+")");
					int u = ps.executeUpdate();
					if(u > 0) {
						return 1;
					}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			return 0;
		}
		
		public int update(String table,String value,String ids) {
			var t = drive.getConnection();
			String sql = "UPDATE '"+table+"' SET '"+value+"' WHERE '"+ids+"'";
			try {
				PreparedStatement ps = t.prepareStatement(sql);
				int u = ps.executeUpdate();
				if(u > 0) {
					return 1;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return 0;
			
		}
		
		public Connection view(String view) {
			var t = drive.getConnection();
			String sql = "SELECT * FROM '"+view+"'";
			try {
				Statement statement = t.createStatement();
				ResultSet rs = statement.executeQuery(sql);
				return (Connection) rs;
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return null;
				
		}
		
		public int delete(String table,String ids) {
			var t = drive.getConnection();
			
			try {
				String sql = "DELETE FROM "+table+" WHERE "+ids+"";
				
				PreparedStatement ps = t.prepareStatement(sql);
				
				int u = ps.executeUpdate();
				if(u > 0) {
					return 1;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return 0;
		}

}
