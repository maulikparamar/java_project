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
import option.shoppingoption;
import sql.manage;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class shopping extends JPanel {
	private static JTable table;
	private static manage m = new manage();
	public static int selecttable;
	public static int data;
	/**
	 * Create the panel.
	 */
	public shopping() {
		setLayout(null);
		
		JLabel lblShopping = new JLabel("Shopping");
		lblShopping.setOpaque(true);
		lblShopping.setHorizontalAlignment(SwingConstants.CENTER);
		lblShopping.setForeground(Color.BLACK);
		lblShopping.setFont(new Font("Verdana", Font.BOLD, 14));
		lblShopping.setBackground(Color.CYAN);
		lblShopping.setBounds(0, 0, 1141, 52);
		add(lblShopping);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 130, 998, 330);
		add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 998, 330);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "purchaseno", "date", "billno", "purchaseparty", "billdate", "remarks"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton submit = new JButton("Add");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shoppingoption so;
				try {
					so = new shoppingoption();
					so.setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		submit.setBounds(87, 77, 89, 23);
		add(submit);
		
		JButton update = new JButton("Update");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selecttable	=Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
				data = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 1).toString());
				var da = m.updateview("purchaseparty", "id="+selecttable+"");
			var t = m.updateview("purchasedata", "purchaseno="+data+"");
			String category ="";
			String product ="";
			String price ="";
			String qulity ="";
			String unit ="";
			String gst ="";
			String subtotal ="";
			String gsttotal ="";
			try {
				if(da.next()) {
					shoppingoption op = new shoppingoption();
					op.setVisible(true);
					op.billdate.setText(da.getString("billdate"));
					op.billno.setText(da.getString("billno"));
					op.date.setText(da.getString("date"));
					op.purchaseno.setText(da.getString("purchaseno"));
					op.party.setSelectedItem(da.getString("purchaseparty"));
					op.remarks.setText(da.getString("remarks"));
					 int i = 0;
					while(t.next()) {
						category = t.getString("category");
						product = t.getString("product");
						price = t.getString("price");
						qulity = t.getString("qulity");
						unit = t.getString("unit");
						gst = t.getString("gst");
						subtotal = t.getString("subtotal");
						gsttotal = t.getString("gsttotal");
						op.dppp += Integer.parseInt(gsttotal);
						i++;
						op.model.addRow(new Object[] {i,category,product,price,qulity,unit,gst,subtotal,gsttotal});
					}
					op.finaltotal.setText(String.valueOf(op.dppp));
				}

			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
				
			}
		});
		update.setBounds(216, 77, 89, 23);
		add(update);
		
		JButton delete = new JButton("Delete");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			selecttable	=Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
			 data = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 1).toString());
			 m.delete("purchasedata", "purchaseno="+data+"");
			int t = m.delete("purchaseparty", "id="+selecttable+"");
			if(t > 0) {
				JOptionPane.showMessageDialog(null, "delete");
			}
			else {
				JOptionPane.showMessageDialog(null, "not delete");
			}
			data();
			}
		});
		delete.setBounds(354, 77, 89, 23);
		add(delete);
		data();
	}
	public static void data() {
		ResultSet rs = m.view("purchaseparty");
		table.setModel(DbUtils.resultSetToTableModel(rs));
	}
}
