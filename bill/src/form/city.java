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
import option.cityoption;
import sql.manage;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class city extends JPanel {
	private static JTable table;
	private static manage m = new manage();
	public static int selecttable;

	/**
	 * Create the panel.
	 */
	public city() {
		setLayout(null);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setOpaque(true);
		lblCity.setHorizontalAlignment(SwingConstants.CENTER);
		lblCity.setForeground(Color.BLACK);
		lblCity.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCity.setBackground(Color.CYAN);
		lblCity.setBounds(0, 0, 1141, 52);
		add(lblCity);
		
		JPanel panel = new JPanel();
		panel.setBounds(22, 131, 985, 349);
		add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 985, 349);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "city"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cityoption co = new cityoption();
				co.setVisible(true);
			}
		});
		submit.setBounds(102, 97, 89, 23);
		add(submit);
		
		JButton update = new JButton("Update");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selecttable = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
				var u = m.updateview("city", "id="+selecttable+"");
				try {
					if(u.next()) {
						cityoption co = new cityoption();
						co.setVisible(true);
						co.city1.setText(u.getString("city"));
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		update.setBounds(245, 97, 89, 23);
		add(update);
		
		JButton delete = new JButton("Delete");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selecttable = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
				int t = m.delete("city", "id="+selecttable+"");
				if(t > 0) {
					JOptionPane.showMessageDialog(null, "delete");
				}
				else {
					JOptionPane.showMessageDialog(null, "not delete");
				}
				data();

			}
		});
		delete.setBounds(387, 97, 89, 23);
		add(delete);
		data();
	}
	public static void data() {
		ResultSet t = m.view("city");
		table.setModel(DbUtils.resultSetToTableModel(t));
	}

}
