package form;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Caret;

import net.proteanit.sql.DbUtils;
import option.employeeOption;
import option.roleoption;
import sql.*;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class employee extends JPanel {
	private static JTable table;
	public static int selecttable;
	/**
	 * Create the panel.
	 */
	public employee() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Employee");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(Color.CYAN);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(0, 0, 1141, 52);
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(24, 108, 990, 367);
		add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 980, 367);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{new Integer(1), "maulik", "java devloper", null, "hello", "null", new Long(7435864306L), null},
				{new Integer(2), "fhtfh", "asd", null, "asd", "C:UsersmauliOneDriveDocumentsm.jpeg", new Long(165465L), null},
				{new Integer(3), "fhtfh", "asd", null, "asd", "C:UsersmauliOneDriveDocumentsm.jpeg", new Long(165465L), null},
				{new Integer(4), "maulik", "hg", null, "iutfiyt", "C:UsersmauliOneDriveDocumentsm.jpeg", new Long(16L), null},
				{new Integer(5), "hvhv", "naaaa", null, "khghj", "C:UsersmauliOneDriveDocumentsm.jpeg", new Long(7435864306L), null},
				{new Integer(6), "fhtfhasd", "asd", null, "asd", "C:UsersmauliOneDriveDocumentsm.jpeg", new Long(741L), null},
			},
			new String[] {
				"id", "role", "job", "birthdate", "textarea", "image", "emp_number", "dateandtime"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				employeeOption m = new employeeOption();
				m.setVisible(true);
			}
		});
		btnNewButton.setBounds(72, 74, 89, 23);
		add(btnNewButton);
		
	
		
		JButton delete = new JButton("delete");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selecttable = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
				manage m = new manage();
				int t = m.delete("employee","id="+selecttable+"");
				if(t > 0) {
					JOptionPane.showMessageDialog(null, "delete");
				}
				else {
					JOptionPane.showMessageDialog(null, "not delete");
				}
				data();
			}
		});
		delete.setBounds(357, 74, 89, 23);
		add(delete);
		
		JButton update = new JButton("update");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selecttable = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
				 manage m = new manage();
				 var y = m.updateview("employee","id="+selecttable+"");
				 try {
					if(y.next()) {
						employeeOption r = new employeeOption();
						r.setVisible(true);
						r.role.setSelectedItem(y.getString("role"));
						r.job.setText(y.getString("job"));
						r.email.setText(y.getString("email"));
						r.birthday.setText(y.getString("birthdate"));
						r.numberadd.setText(y.getString("emp_number"));
						r.image.setText(y.getString("image"));
						r.textarea.setText(y.getString("textarea"));
					 }
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		update.setBounds(209, 74, 89, 23);
		add(update);
		data();
	}
	
	public static void data() {
		manage m = new manage();
		var aa = m.view("employee");
		table.setModel(DbUtils.resultSetToTableModel(aa));
	}
}
