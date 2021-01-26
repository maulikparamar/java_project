package sql;

import java.sql.*;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class manage {
		public int insert(String table,HashMap<String,String> values) {
			var t = drive.getConnection();
			try {
				System.out.println(values.toString());
				String tablename = "";
				String valuesname =" ";
				int e =	1;
				for(String a : values.keySet())
				{
					
					if(e == 1) {
							tablename = a;
							valuesname = "'"+ values.get(a)+"'";
					}
					else {
						tablename = tablename + "," +a;
						valuesname = valuesname + "," + "'"+ values.get(a)+"'";
					}
					e++;
					
				}	
//				values.forEach((a,b) -> System.out.println(a + " " + b));
				
				PreparedStatement ps = t.prepareStatement("INSERT INTO "+table+"("+tablename+") values("+valuesname+")");
					int u = ps.executeUpdate();
					if(u > 0) {
						return 1;
					}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			return 0;
		}
		
		
		public ResultSet viewitem(String table,String view) {
			var t = drive.getConnection();
			String sql = "SELECT distinct "+view+" FROM "+table+"";
			try {
				Statement statement = t.createStatement();
				ResultSet rs = statement.executeQuery(sql);
					return rs;
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return null;
				
		}
		
		public int update(String table,HashMap<String,String> values,String ids) {
			var t = drive.getConnection();
			String ff = "";
			int g = 1;
			for(String a : values.keySet()) {
				if(g == 1) {
					ff = a +"="+ "'" + values.get(a)+"'";
				}
				else {
					ff = ff+","+a+"="+"'"+values.get(a)+"'";
				}
				g++;
			}	
			String sql = "update "+table+" set "+ff+" where "+ids+"";
			PreparedStatement ps;
			try {
				ps = t.prepareStatement(sql);
				ps.executeUpdate();
				return 1;
			} catch (SQLException e) {
				System.out.println(e);
			}
			return 0;
			
		}
		
		
		public ResultSet updateview(String table,String ids) {
			var t = drive.getConnection();
			String sql = "select * from "+table+" where "+ids+"";
			try {
				Statement ps = t.createStatement();
				ResultSet u = ps.executeQuery(sql);
					return u;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
			
		}
		
		public int login(String table,String username,String password) {
			var t = drive.getConnection();
			String sql = "SELECT * FROM "+table+" WHERE "+username+" and "+password+"";
			try {
				PreparedStatement ps = t.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
					return 1;
				}
				else {
					JOptionPane.showMessageDialog(null, "Incorrect Username Or Password");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			return 0;
		}
		public ResultSet view(String view) {
			var t = drive.getConnection();
			String sql = "SELECT * FROM "+view+"";
			try {
				Statement statement = t.createStatement();
				ResultSet rs = statement.executeQuery(sql);
					return rs;
				
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
