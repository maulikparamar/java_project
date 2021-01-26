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
import option.partyoption;
import sql.manage;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class purchaseparty extends JPanel {
	private static JTable table;
	private static manage m = new manage();
	public static int selecttable;

	/**
	 * Create the panel.
	 */
	public purchaseparty() {
		setLayout(null);
		
		JLabel lblPurchaseParty = new JLabel("Purchase Party");
		lblPurchaseParty.setOpaque(true);
		lblPurchaseParty.setHorizontalAlignment(SwingConstants.CENTER);
		lblPurchaseParty.setForeground(Color.BLACK);
		lblPurchaseParty.setFont(new Font("Verdana", Font.BOLD, 14));
		lblPurchaseParty.setBackground(Color.CYAN);
		lblPurchaseParty.setBounds(0, 0, 1141, 52);
		add(lblPurchaseParty);
		
		JPanel panel = new JPanel();
		panel.setBounds(21, 124, 999, 336);
		add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 999, 336);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "purchase party", "address", "city", "pincode", "number", "number1", "email", "gstno", "bank", "companyname", "url"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton submit = new JButton("Add");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					partyoption po = new partyoption();
					po.setVisible(true);
			}
		});
		submit.setBounds(84, 71, 89, 23);
		add(submit);
		
		JButton update = new JButton("Update");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selecttable = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
				var t = m.updateview("party",  "id="+selecttable+"");
				try {
					if(t.next()) {
						partyoption po = new partyoption();
						po.setVisible(true);
						po.address.setText(t.getString("address"));
						po.bank.setText(t.getString("bank"));
						po.city.setText(t.getString("city"));
						po.company.setText(t.getString("companyname"));
						po.email.setText(t.getString("email"));
						po.gst.setText(t.getString("gstno"));
						po.number.setText(t.getString("number"));
						po.number1.setText(t.getString("number1"));
						po.partyname.setText(t.getString("partyname"));
						po.pincode.setText(t.getString("pincode"));
						po.url.setText(t.getString("url"));
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		update.setBounds(229, 71, 89, 23);
		add(update);
		
		JButton delete = new JButton("Delete");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selecttable = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
				int t = m.delete("party", "id="+selecttable+"");
				if(t > 0) {
					JOptionPane.showMessageDialog(null, "delete");
				}
				else {
					JOptionPane.showMessageDialog(null, "not delete");
				}
				data();
			}
		});
		delete.setBounds(393, 71, 89, 23);
		add(delete);
		data();
	}
	public static void data() {
		ResultSet r = m.view("party");
		table.setModel(DbUtils.resultSetToTableModel(r));
	}

}
