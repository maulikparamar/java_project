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
import option.gstoption;
import sql.manage;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class gst extends JPanel {
	private static JTable table;
	private static manage m = new manage();
	public static int selecttable;
	/**
	 * Create the panel.
	 */
	public gst() {
		setLayout(null);
		
		JLabel lblGst = new JLabel("Gst");
		lblGst.setOpaque(true);
		lblGst.setHorizontalAlignment(SwingConstants.CENTER);
		lblGst.setForeground(Color.BLACK);
		lblGst.setFont(new Font("Verdana", Font.BOLD, 15));
		lblGst.setBackground(Color.CYAN);
		lblGst.setBounds(0, 0, 1141, 52);
		add(lblGst);
		
		JPanel panel = new JPanel();
		panel.setBounds(24, 174, 996, 292);
		add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 986, 292);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"id", "Gst"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton submit = new JButton("Add");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gstoption go = new gstoption();
				go.setVisible(true);
			}
		});
		submit.setBounds(82, 98, 89, 23);
		add(submit);
		
		JButton update = new JButton("Update");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selecttable = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
				var i = m.updateview("gst", "id="+selecttable+"");
				try {
					if(i.next()) {
						gstoption go = new gstoption();
						go.setVisible(true);
						go.gst1.setText(i.getString("gst"));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		update.setBounds(229, 98, 89, 23);
		add(update);
		
		JButton delete = new JButton("Delete");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selecttable = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
				int t = m.delete("gst", "id="+selecttable+"");
				if(t > 0) {
					JOptionPane.showMessageDialog(null, "delete");
				}
				else {
					JOptionPane.showMessageDialog(null, "not delete");
				}
				data();
			}
		});
		delete.setBounds(365, 98, 89, 23);
		add(delete);
		data();
	}
	public static void data() {
		ResultSet rs = m.view("gst");
		table.setModel(DbUtils.resultSetToTableModel(rs));
	}

}
