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
import option.unitoption;
import sql.manage;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class unit extends JPanel {
	private static JTable table;
	public static int selecttable;
	/**
	 * Create the panel.
	 */
	private static manage m = new manage();
	public unit() {
		setLayout(null);
		
		JLabel lblUnit = new JLabel("Unit");
		lblUnit.setOpaque(true);
		lblUnit.setHorizontalAlignment(SwingConstants.CENTER);
		lblUnit.setForeground(Color.BLACK);
		lblUnit.setFont(new Font("Verdana", Font.BOLD, 14));
		lblUnit.setBackground(Color.CYAN);
		lblUnit.setBounds(0, 0, 1141, 52);
		add(lblUnit);
		
		JPanel panel = new JPanel();
		panel.setBounds(37, 189, 964, 293);
		add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 964, 293);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "unit"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton submit = new JButton("Add");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				unitoption un = new unitoption();
				un.setVisible(true);
			}
		});
		submit.setBounds(93, 108, 89, 23);
		add(submit);
		
		JButton update = new JButton("Update");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selecttable = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
				var u = m.updateview("unit",  "id="+selecttable+"");
				try {
					if(u.next()) {
						unitoption un = new unitoption();
						un.setVisible(true);
						un.unit1.setText(u.getString("unit"));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				data();
			}
		});
		update.setBounds(241, 108, 89, 23);
		add(update);
		
		JButton delete = new JButton("Delete");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selecttable = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
				int t =m.delete("unit", "id="+selecttable+"");
				if(t > 0) {
					JOptionPane.showMessageDialog(null, "delete");
				}
				else {
					JOptionPane.showMessageDialog(null, "not delete");
				}
				data();
			}
		});
		delete.setBounds(402, 108, 89, 23);
		add(delete);
		data();
	}
	public static void data() {
		ResultSet u = m.view("unit");
		table.setModel(DbUtils.resultSetToTableModel(u));
	}
}
