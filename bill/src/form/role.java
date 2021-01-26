package form;
import sql.*;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Font;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
import option.roleoption;

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class role extends JPanel {
	
	/**
	 * Create the panel.
	 */
	private static JTable table;
	public static int selecttable ;
	public role() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Role");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.CYAN);
		lblNewLabel.setBounds(0, 0, 1141, 45);
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 99, 969, 333);
		add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 959, 322);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"id", "role"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton button = new JButton("New button");
		button.setBounds(105, 54, 46, -45);
		add(button);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				roleoption r = new roleoption();
				r.setVisible(true);
			}
		});
		btnNewButton.setBounds(122, 56, 89, 23);
		add(btnNewButton);
		
		JButton update = new JButton("update");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selecttable = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
				 manage m = new manage();
				 var y = m.updateview("role", "id="+selecttable+"");
				 try {
					if(y.next()) {
						roleoption r = new roleoption();
						r.setVisible(true);
						r.roleadd.setText(y.getString(2));
					 }
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		update.setBounds(272, 56, 89, 23);
		add(update);
		
		JButton delete = new JButton("delete");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var u = selecttable = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
				 manage m = new manage();
				 int k = m.delete("role", "id="+u+"");
				 
				 if(k ==1) {
					 JOptionPane.showMessageDialog(null, "value delete");
				 }
				 else {
					 JOptionPane.showMessageDialog(null, "not delete");
				 }
				 role.data();
			}
		});
		delete.setBounds(419, 56, 89, 23);
		add(delete);
		data();
	}
	
	public static void data() {
		manage m = new manage();
		var getdata = m.view("role");
		
		table.setModel(DbUtils.resultSetToTableModel(getdata));
	}
}
