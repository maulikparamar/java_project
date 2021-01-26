package form;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;
import option.categoryoption;
import sql.manage;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class category extends JPanel {
	public static JTable table;
	public static int selecttable;

	/**
	 * Create the panel.
	 */
	private static manage m = new manage();
	public category() {
		setLayout(null);
		
		JLabel lblCatagory = new JLabel("Catagory");
		lblCatagory.setOpaque(true);
		lblCatagory.setHorizontalAlignment(SwingConstants.CENTER);
		lblCatagory.setForeground(Color.BLACK);
		lblCatagory.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCatagory.setBackground(Color.CYAN);
		lblCatagory.setBounds(0, 0, 1141, 52);
		add(lblCatagory);
		
		JPanel panel = new JPanel();
		panel.setBounds(21, 123, 993, 355);
		add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 983, 355);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "category", "image", "decscription"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton submit = new JButton("Add");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				categoryoption option = new categoryoption();
				option.setVisible(true);
			}
		});
		submit.setBounds(54, 89, 89, 23);
		add(submit);
		
		JButton update = new JButton("Update");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selecttable = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
				var t = m.updateview("category", "id="+selecttable+"");
				try {
					if(t.next()) {
						categoryoption ca = new categoryoption();
						ca.setVisible(true);
						ca.category1.setText(t.getString("category"));
						ca.decription.setText(t.getString("description"));
						ca.image.setText(t.getString("image"));
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				data();
			}
		});
		update.setBounds(201, 89, 89, 23);
		add(update);
		
		JButton delete = new JButton("Delete");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selecttable = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
				var t = m.delete("category", "id="+selecttable+"");
				if(t > 0) {
					JOptionPane.showMessageDialog(null, "delete");
				}
				else {
					JOptionPane.showMessageDialog(null, "not delete");
				}
				category.data();
			
			}
		});
		delete.setBounds(356, 89, 89, 23);
		add(delete);
		data();
	}
	public static void data() {
		ResultSet t = m.view("category");
		table.setModel(DbUtils.resultSetToTableModel(t));
	}
}
