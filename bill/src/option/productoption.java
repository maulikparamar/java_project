package option;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import form.product;
import sql.manage;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class productoption extends JFrame {

	private JPanel contentPane;
	public JTextField productcode;
	public JTextField productname;
	public JTextField price;
	public JTextField hsncode;
	public JTextField alertqulity;
	public JTextField description;
	private manage m = new manage();
	public JComboBox category;
	public JComboBox unit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					productoption frame = new productoption();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void categorydata() {
		var u =m.viewitem("category",	"category");
		try {
			while(u.next()) {
				category.addItem(u.getString(1));	
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		var i = m.viewitem("unit", "unit");
		try {
			while(i.next()) {
				unit.addItem(i.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public productoption() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 776, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("product");
		JLabel lblNewLabel = new JLabel("Product");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel.setBounds(343, 11, 117, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Product Code");
		lblNewLabel_1.setBounds(455, 90, 73, 14);
		contentPane.add(lblNewLabel_1);
		
		productcode = new JTextField();
		productcode.setBounds(538, 87, 173, 20);
		contentPane.add(productcode);
		productcode.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Category");
		lblNewLabel_2.setBounds(63, 91, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		category = new JComboBox();
		category.setBounds(124, 87, 173, 22);
		contentPane.add(category);
		
		JLabel lblNewLabel_3 = new JLabel("Product Name");
		lblNewLabel_3.setBounds(42, 152, 67, 14);
		contentPane.add(lblNewLabel_3);
		
		productname = new JTextField();
		productname.setColumns(10);
		productname.setBounds(124, 149, 173, 20);
		contentPane.add(productname);
		
		JLabel lblNewLabel_3_1 = new JLabel("Price");
		lblNewLabel_3_1.setBounds(63, 203, 46, 14);
		contentPane.add(lblNewLabel_3_1);
		
		price = new JTextField();
		price.setColumns(10);
		price.setBounds(124, 200, 183, 20);
		contentPane.add(price);
		
		unit = new JComboBox();
		unit.setBounds(526, 195, 173, 22);
		contentPane.add(unit);
		
		JLabel lblNewLabel_2_1 = new JLabel("Unit");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setBounds(426, 203, 46, 14);
		contentPane.add(lblNewLabel_2_1);
		
		hsncode = new JTextField();
		hsncode.setColumns(10);
		hsncode.setBounds(526, 144, 173, 20);
		contentPane.add(hsncode);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Hsn Code");
		lblNewLabel_3_1_1.setBounds(451, 152, 46, 14);
		contentPane.add(lblNewLabel_3_1_1);
		
		alertqulity = new JTextField();
		alertqulity.setColumns(10);
		alertqulity.setBounds(124, 264, 183, 20);
		contentPane.add(alertqulity);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Alert Qulity");
		lblNewLabel_3_1_1_1.setBounds(42, 267, 67, 14);
		contentPane.add(lblNewLabel_3_1_1_1);
		
		description = new JTextField();
		description.setColumns(10);
		description.setBounds(134, 317, 467, 32);
		contentPane.add(description);
		
		JLabel lblNewLabel_3_1_1_2 = new JLabel("Description");
		lblNewLabel_3_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3_1_1_2.setBounds(63, 320, 474, 29);
		contentPane.add(lblNewLabel_3_1_1_2);
		
		JButton submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HashMap<String,String> map = new HashMap<>();
				map.put("category", category.getSelectedItem().toString());
				map.put("productcode", productcode.getText());
				map.put("productname", productname.getText());
				map.put("hsncode", hsncode.getText());
				map.put("price", price.getText());
				map.put("unit", unit.getSelectedItem().toString());
				map.put("qulity", alertqulity.getText());
				map.put("description", description.getText());
				int t = m.insert("product", map);
				if(t > 0) {
					JOptionPane.showMessageDialog(null, "add");
				}
				else {
					JOptionPane.showMessageDialog(null, "not add");
				}
				product.data();
				dispose();
			}
		});
		submit.setBounds(176, 394, 89, 23);
		contentPane.add(submit);
		
		JButton update = new JButton("Update");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int categoryid = product.selecttable;
				HashMap<String,String> map = new HashMap<>();
				map.put("category", category.getSelectedItem().toString());
				map.put("productcode", productcode.getText());
				map.put("productname", productname.getText());
				map.put("hsncode", hsncode.getText());
				map.put("price", price.getText());
				map.put("unit", unit.getSelectedItem().toString());
				map.put("qulity", alertqulity.getText());
				map.put("description", description.getText());
				int re =m.update("product", map, "id="+categoryid+"");
				if(re == 1) {
					JOptionPane.showMessageDialog(null, "update");
				}
				else {
					JOptionPane.showMessageDialog(null, "not update");
				}
				product.data();
				dispose();
			}
		});
		update.setBounds(349, 394, 89, 23);
		contentPane.add(update);
		categorydata();
	}
}
