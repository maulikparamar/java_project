package option;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import form.purchaseparty;
import form.shopping;
import sql.manage;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class shoppingoption extends JFrame {

	private JPanel contentPane;
	public JTable table;
	public JTextField purchaseno;
	public JTextField date;
	public JTextField billno;
	public JTextField billdate;
	public JTextField remarks;
	public JTextField price;
	public JTextField qulity;
	public JTextField unit;
	public JTextField subtotal;
	public JTextField gsttotal;
	private manage m = new manage();
	private JComboBox category;
	private JComboBox product;
	private JComboBox gst;
	public JComboBox party;
	private int y = 1;
	private int sub;
	private int gstsub;
	public static int selecttable;
	public DefaultTableModel model;
	public JTextField finaltotal;
	public  int dppp;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					shoppingoption frame = new shoppingoption();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	
	public void getdata() throws SQLException {
		var t = m.viewitem("category", "category");
			while(t.next()) {
				category.addItem(t.getString(1));
			}
		var u = m.viewitem("party", "partyname");
		while(u.next()) {
			party.addItem(u.getString(1));
		}
		
		var o = m.viewitem("product", "category");
		while(o.next()) {
			product.addItem(o.getString(1));
		}
		var p = m.viewitem("gst", "gst");
		while(p.next()) {
			gst.addItem(p.getString(1));
		}
	}
	public shoppingoption() throws SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 995, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Shopping");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel.setBounds(522, 11, 139, 29);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 216, 959, 208);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 959, 205);
		panel.add(scrollPane);
		
		table = new JTable();
		Object[] colums = {"id","category","product","price","qulity","unit","gst","subtotal","gsttotal"};
		 model = new DefaultTableModel();
		model.setColumnIdentifiers(colums);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("purchase no.");
		lblNewLabel_1.setBounds(30, 61, 73, 14);
		contentPane.add(lblNewLabel_1);
		
		purchaseno = new JTextField();
		purchaseno.setBounds(125, 58, 144, 20);
		contentPane.add(purchaseno);
		purchaseno.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("date");
		lblNewLabel_1_1.setBounds(30, 105, 73, 14);
		contentPane.add(lblNewLabel_1_1);
		
		date = new JTextField();
		date.setColumns(10);
		date.setBounds(125, 102, 144, 20);
		contentPane.add(date);
		
		JLabel lblNewLabel_1_2 = new JLabel("Bill No.");
		lblNewLabel_1_2.setBounds(311, 58, 73, 14);
		contentPane.add(lblNewLabel_1_2);
		
		billno = new JTextField();
		billno.setColumns(10);
		billno.setBounds(406, 55, 144, 20);
		contentPane.add(billno);
		
		JLabel lblNewLabel_1_3 = new JLabel("Bill Date");
		lblNewLabel_1_3.setBounds(311, 102, 73, 14);
		contentPane.add(lblNewLabel_1_3);
		
		billdate = new JTextField();
		billdate.setColumns(10);
		billdate.setBounds(406, 99, 144, 20);
		contentPane.add(billdate);
		
		JLabel lblNewLabel_1_4 = new JLabel("purchase party");
		lblNewLabel_1_4.setBounds(592, 54, 73, 14);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("remarks");
		lblNewLabel_1_5.setBounds(592, 108, 73, 14);
		contentPane.add(lblNewLabel_1_5);
		
		remarks = new JTextField();
		remarks.setColumns(10);
		remarks.setBounds(687, 105, 144, 20);
		contentPane.add(remarks);
		
		JLabel lblNewLabel_2 = new JLabel("Category");
		lblNewLabel_2.setBounds(40, 140, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("product");
		lblNewLabel_2_1.setBounds(166, 140, 46, 14);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("price");
		lblNewLabel_2_2.setBounds(289, 140, 46, 14);
		contentPane.add(lblNewLabel_2_2);
		
		price = new JTextField();
		price.setColumns(10);
		price.setBounds(277, 173, 86, 20);
		contentPane.add(price);
		
		JLabel lblNewLabel_2_3 = new JLabel("qulity");
		lblNewLabel_2_3.setBounds(407, 140, 46, 14);
		contentPane.add(lblNewLabel_2_3);
		
		qulity = new JTextField();
		qulity.setColumns(10);
		qulity.setBounds(395, 173, 86, 20);
		contentPane.add(qulity);
		
		JLabel lblNewLabel_2_4 = new JLabel("unit");
		lblNewLabel_2_4.setBounds(526, 140, 46, 14);
		contentPane.add(lblNewLabel_2_4);
		
		unit = new JTextField();
		unit.setColumns(10);
		unit.setBounds(514, 173, 86, 20);
		contentPane.add(unit);
		
		JLabel lblNewLabel_2_5 = new JLabel("gst");
		lblNewLabel_2_5.setBounds(652, 140, 46, 14);
		contentPane.add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_2_6 = new JLabel("subtotal");
		lblNewLabel_2_6.setBounds(757, 140, 46, 14);
		contentPane.add(lblNewLabel_2_6);
		
		subtotal = new JTextField();
		subtotal.setColumns(10);
		subtotal.setBounds(745, 173, 86, 20);
		contentPane.add(subtotal);
		
		JLabel lblNewLabel_2_7 = new JLabel("gsttotal");
		lblNewLabel_2_7.setBounds(867, 140, 46, 14);
		contentPane.add(lblNewLabel_2_7);
		
		gsttotal = new JTextField();
		gsttotal.setColumns(10);
		gsttotal.setBounds(855, 173, 86, 20);
		contentPane.add(gsttotal);
		
		finaltotal = new JTextField();
		finaltotal.setBounds(867, 435, 102, 20);
		contentPane.add(finaltotal);
		finaltotal.setColumns(10);
		
		JButton submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idd,cate,pro,pri,quli,uni,g,su,gssu;
				for(int i = 0; i < table.getRowCount(); i++) {
					idd = table.getValueAt(i, 0).toString();
					cate = table.getValueAt(i, 1).toString();
					pro = table.getValueAt(i, 2).toString();
					pri = table.getValueAt(i, 3).toString();
					quli = table.getValueAt(i, 4).toString();
					uni = table.getValueAt(i, 5).toString();
					 g = table.getValueAt(i, 6).toString();
					 su = table.getValueAt(i, 7).toString();
					 gssu = table.getValueAt(i, 8).toString();
					 HashMap<String,String> ma = new HashMap<>();
					 ma.put("purchaseno", purchaseno.getText());
					 ma.put("category",cate);
					 ma.put("product", pro);
					 ma.put("price",pri);
					 ma.put("qulity", quli);
					 ma.put("unit",uni);
					 ma.put("gst", g);
					 ma.put("subtotal",su);
					 ma.put("gsttotal", gssu);
					 m.insert("purchasedata", ma);
					 System.out.println(idd);
				}
				
				HashMap<String,String> map = new HashMap<>();
				map.put("purchaseno ", purchaseno.getText());
				map.put("date ", date.getText());
				map.put("billno ", billno.getText());
				map.put("purchaseparty",party.getSelectedItem().toString());
				map.put("billdate", billdate.getText());
				map.put("remarks", remarks.getText());
				int t = m.insert("purchaseparty", map);
				if(t > 0) {
					JOptionPane.showMessageDialog(null, "add");
				}
				else {
					JOptionPane.showMessageDialog(null, "not add");
				}
				shopping.data();
				dispose();
			}
		});
		submit.setBounds(880, 16, 89, 23);
		contentPane.add(submit);
		
		gst = new JComboBox();
		gst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int pri,quli,gs;
				 try {
					 pri = Integer.parseInt(price.getText());
					 quli =  Integer.parseInt(qulity.getText());
					 gs =  Integer.parseInt(gst.getSelectedItem().toString());
					 sub = pri + quli;
					 gstsub = sub + gs;
			}
				 catch(NumberFormatException ex ) {
					 quli = 0;
					 pri = 0;
					 gs = 0;
					 sub = 0;
					 gstsub = 0;
				 }
				 gsttotal.setText(String.valueOf(gstsub));
				 subtotal.setText(String.valueOf(sub));
		}
		});
		gst.setBounds(640, 172, 71, 22);
		contentPane.add(gst);
		
		product = new JComboBox();
		product.setBounds(148, 172, 79, 22);
		contentPane.add(product);
		
		category = new JComboBox();
		category.setBounds(30, 172, 71, 22);
		contentPane.add(category);
	
		JButton add = new JButton("Add");
		Object[] row = new Object[9];
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				row[0] = String.valueOf(y);
				row[1] = category.getSelectedItem().toString();
				row[2] = product.getSelectedItem().toString();
				row[3] = price.getText();
				row[4] = qulity.getText();
				row[5] = unit.getText();
				row[6] = gst.getSelectedItem().toString();
				row[7] = subtotal.getText();
				row[8] = gsttotal.getText();
				int ufinaltotal =Integer.parseInt(gsttotal.getText());
						y++;
						model.addRow(row);
				category.setSelectedIndex(0);
				product.setSelectedIndex(0);
				price.setText("");
				qulity.setText("");
				unit.setText("");
				gst.setSelectedIndex(0);
				subtotal.setText("");
				gsttotal.setText("");
				
				dppp += ufinaltotal; 
				finaltotal.setText(String.valueOf(dppp));
			}

		});
		add.setBounds(880, 106, 89, 23);
		contentPane.add(add);
		
		party = new JComboBox();
		party.setBounds(687, 50, 144, 22);
		contentPane.add(party);
		
		JButton delete = new JButton("Delete");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int t = table.getSelectedRow();
				int h  = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 8).toString());
				dppp -= h; 
				finaltotal.setText(String.valueOf(dppp));
				if(t >= 0) {
					model.removeRow(t);	
				}
				else {
					System.out.print("delete not");
				}
			}
		});
		delete.setBounds(880, 72, 89, 23);
		contentPane.add(delete);
		
		JButton update = new JButton("Update");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int part = shopping.selecttable;
				int data = shopping.data;
				
				String idd,cate,pro,pri,quli,uni,g,su,gssu;
				for(int i = 0; i < table.getRowCount(); i++) {
					idd = table.getValueAt(i, 0).toString();
					cate = table.getValueAt(i, 1).toString();
					pro = table.getValueAt(i, 2).toString();
					pri = table.getValueAt(i, 3).toString();
					quli = table.getValueAt(i, 4).toString();
					uni = table.getValueAt(i, 5).toString();
					 g = table.getValueAt(i, 6).toString();
					 su = table.getValueAt(i, 7).toString();
					 gssu = table.getValueAt(i, 8).toString();
					 HashMap<String,String> ma = new HashMap<>();
					 ma.put("purchaseno", purchaseno.getText());
					 ma.put("category",cate);
					 ma.put("product", pro);
					 ma.put("price",pri);
					 ma.put("qulity", quli);
					 ma.put("unit",uni);
					 ma.put("gst", g);
					 ma.put("subtotal",su);
					 ma.put("gsttotal", gssu);
					 m.update("purchasedata", ma,"purchaseno="+data+"");
				}
				
				HashMap<String,String> map = new HashMap<>();
				map.put("purchaseno ", purchaseno.getText());
				map.put("date ", date.getText());
				map.put("billno ", billno.getText());
				map.put("purchaseparty",party.getSelectedItem().toString());
				map.put("billdate", billdate.getText());
				map.put("remarks", remarks.getText());
				int re = m.update("purchaseparty", map, "id="+part+"");
				
				if(re == 1) {
					JOptionPane.showMessageDialog(null, "update");
				}
				else {
					JOptionPane.showMessageDialog(null, "not update");
				}
				shopping.data();
				dispose();
			}
		});
		update.setBounds(880, 45, 89, 23);
		contentPane.add(update);
		
		
		
		getdata();
	}
}
