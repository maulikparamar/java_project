package form;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;
import option.areaoption;
import sql.manage;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class area extends JPanel {
	private static JTable table;
	public static int selecttable;
	private static manage m = new manage();
	/**
	 * Create the panel.
	 */
	public area() {
		setLayout(null);
		
		JLabel lblArea = new JLabel("Area");
		lblArea.setOpaque(true);
		lblArea.setHorizontalAlignment(SwingConstants.CENTER);
		lblArea.setForeground(Color.BLACK);
		lblArea.setFont(new Font("Verdana", Font.BOLD, 14));
		lblArea.setBackground(Color.CYAN);
		lblArea.setBounds(0, 0, 1141, 52);
		add(lblArea);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 155, 948, 311);
		add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 948, 311);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "city", "area"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton submit = new JButton("Add");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				areaoption ao = new areaoption();
				ao.setVisible(true);
			}
		});
		submit.setBounds(74, 88, 89, 23);
		add(submit);
		
		JButton update = new JButton("Update");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selecttable = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
				var y = m.updateview("area", "id="+selecttable+"");
				try {
					if(y.next()) {
						areaoption ao = new areaoption();
						ao.setVisible(true);
						ao.area1.setText(y.getString("area"));
						ao.city.setSelectedItem(y.getString("city"));
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		update.setBounds(231, 88, 89, 23);
		add(update);
		
		JButton delete = new JButton("Delete");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selecttable = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
				int t = m.delete("area", "id="+selecttable+"");
				if(t > 0) {
					JOptionPane.showMessageDialog(null, "delete");
				}
				else {
					JOptionPane.showMessageDialog(null, "not delete");
				}
				data();
			}
		});
		delete.setBounds(392, 88, 89, 23);
		add(delete);
		data();
	}
	
	public static void data() {
		ResultSet r = m.view("area");
		table.setModel(DbUtils.resultSetToTableModel(r));
	}

}
