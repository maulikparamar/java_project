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
import option.productoption;
import sql.manage;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class product extends JPanel {
	private static JTable table;
	public static int selecttable;
	private static manage m = new manage();

	/**
	 * Create the panel.
	 */
	public product() {
		setLayout(null);
		
		JLabel lblProduct = new JLabel("Product");
		lblProduct.setOpaque(true);
		lblProduct.setHorizontalAlignment(SwingConstants.CENTER);
		lblProduct.setForeground(Color.BLACK);
		lblProduct.setFont(new Font("Verdana", Font.BOLD, 14));
		lblProduct.setBackground(Color.CYAN);
		lblProduct.setBounds(0, 0, 1141, 52);
		add(lblProduct);
		
		JPanel panel = new JPanel();
		panel.setBounds(36, 167, 1009, 308);
		add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 980, 308);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "category", "product code", "product name", "hsn code", "price", "unit", "qulity", "description"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton submit = new JButton("Add");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productoption pr = new productoption();
				pr.setVisible(true);
			}
		});
		submit.setBounds(100, 88, 89, 23);
		add(submit);
		
		JButton update = new JButton("Update");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selecttable = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
				var t = m.updateview("product","id="+selecttable+"");
				try {
					if(t.next()) {
						productoption pr = new productoption();
						pr.setVisible(true);
						pr.unit.setSelectedItem(t.getString("unit"));
						pr.productname.setText(t.getString("productname"));
						pr.productcode.setText(t.getString("productcode"));
						pr.price.setText(t.getString("price"));
						pr.hsncode.setText(t.getString("hsncode"));
						pr.description.setText(t.getString("description"));
						pr.category.setSelectedItem(t.getString("category"));
						pr.alertqulity.setText(t.getString("qulity"));
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
				int t = m.delete("product","id="+selecttable+"");
				if(t > 0) {
					JOptionPane.showMessageDialog(null, "delete");
				}
				else {
					JOptionPane.showMessageDialog(null, "not delete");
				}
				data();
			}
		});
		delete.setBounds(369, 88, 89, 23);
		add(delete);
		data();
	}
	public static void data() {
		ResultSet v = m.view("product");
		table.setModel(DbUtils.resultSetToTableModel(v));
	}

}
