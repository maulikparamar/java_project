package option;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import form.purchaseparty;
import sql.manage;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class partyoption extends JFrame {

	private JPanel contentPane;
	public JTextField partyname;
	public JTextField city;
	public JTextField number;
	public JTextField address;
	public JTextField pincode;
	public JTextField number1;
	public JTextField email;
	public JTextField gst;
	public JTextField bank;
	public JTextField company;
	public JTextField url;
	private manage m = new manage();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					partyoption frame = new partyoption();
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
	public partyoption() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 614, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Purchase Party");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel.setBounds(237, 11, 244, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Partyname");
		lblNewLabel_1.setBounds(40, 86, 81, 14);
		contentPane.add(lblNewLabel_1);
		
		partyname = new JTextField();
		partyname.setBounds(131, 83, 125, 20);
		contentPane.add(partyname);
		partyname.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("City");
		lblNewLabel_1_1.setBounds(40, 136, 81, 14);
		contentPane.add(lblNewLabel_1_1);
		
		city = new JTextField();
		city.setColumns(10);
		city.setBounds(131, 133, 125, 20);
		contentPane.add(city);
		
		JLabel lblNewLabel_1_2 = new JLabel("Number");
		lblNewLabel_1_2.setBounds(40, 189, 81, 14);
		contentPane.add(lblNewLabel_1_2);
		
		number = new JTextField();
		number.setColumns(10);
		number.setBounds(131, 186, 125, 20);
		contentPane.add(number);
		
		JLabel lblNewLabel_1_3 = new JLabel("Address");
		lblNewLabel_1_3.setBounds(331, 83, 81, 14);
		contentPane.add(lblNewLabel_1_3);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(422, 80, 125, 20);
		contentPane.add(address);
		
		JLabel lblNewLabel_1_4 = new JLabel("PinCode");
		lblNewLabel_1_4.setBounds(331, 139, 81, 14);
		contentPane.add(lblNewLabel_1_4);
		
		pincode = new JTextField();
		pincode.setColumns(10);
		pincode.setBounds(422, 136, 125, 20);
		contentPane.add(pincode);
		
		JLabel lblNewLabel_1_5 = new JLabel("Number ");
		lblNewLabel_1_5.setBounds(331, 192, 81, 14);
		contentPane.add(lblNewLabel_1_5);
		
		number1 = new JTextField();
		number1.setColumns(10);
		number1.setBounds(422, 189, 125, 20);
		contentPane.add(number1);
		
		JLabel lblNewLabel_2 = new JLabel("or");
		lblNewLabel_2.setBounds(286, 189, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(131, 237, 125, 20);
		contentPane.add(email);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Email");
		lblNewLabel_1_2_1.setBounds(40, 240, 81, 14);
		contentPane.add(lblNewLabel_1_2_1);
		
		gst = new JTextField();
		gst.setColumns(10);
		gst.setBounds(422, 237, 125, 20);
		contentPane.add(gst);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Gst No.");
		lblNewLabel_1_2_2.setBounds(331, 240, 81, 14);
		contentPane.add(lblNewLabel_1_2_2);
		
		bank = new JTextField();
		bank.setColumns(10);
		bank.setBounds(131, 289, 125, 20);
		contentPane.add(bank);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("Bank");
		lblNewLabel_1_2_3.setBounds(40, 292, 81, 14);
		contentPane.add(lblNewLabel_1_2_3);
		
		company = new JTextField();
		company.setColumns(10);
		company.setBounds(422, 289, 125, 20);
		contentPane.add(company);
		
		JLabel lblNewLabel_1_2_4 = new JLabel("Company ");
		lblNewLabel_1_2_4.setBounds(331, 292, 81, 14);
		contentPane.add(lblNewLabel_1_2_4);
		
		url = new JTextField();
		url.setColumns(10);
		url.setBounds(131, 339, 263, 20);
		contentPane.add(url);
		
		JLabel lblNewLabel_1_2_5 = new JLabel("Url");
		lblNewLabel_1_2_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_5.setBounds(40, 342, 81, 14);
		contentPane.add(lblNewLabel_1_2_5);
		
		JButton submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HashMap<String,String> map = new HashMap<>();
				map.put("partyname", partyname.getText());
				map.put("address", address.getText());
				map.put("city", city.getText());
				map.put("pincode", pincode.getText());
				map.put("number", number.getText());
				map.put("number1", number1.getText());
				map.put("email", email.getText());
				map.put("gstno", gst.getText());
				map.put("bank", bank.getText());
				map.put("companyname", company.getText());
				map.put("url", url.getText());
				int t = m.insert("party", map);
				if(t > 0) {
					JOptionPane.showMessageDialog(null, "add");
				}
				else {
					JOptionPane.showMessageDialog(null, "not add");
				}
				purchaseparty.data();
				dispose();
			}
		});
		submit.setBounds(145, 398, 89, 23);
		contentPane.add(submit);
		
		JButton update = new JButton("Update");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int categoryid = purchaseparty.selecttable;
				HashMap<String,String> map = new HashMap<>();
				map.put("partyname", partyname.getText());
				map.put("address", address.getText());
				map.put("city", city.getText());
				map.put("pincode", pincode.getText());
				map.put("number", number.getText());
				map.put("number1", number1.getText());
				map.put("email", email.getText());
				map.put("gstno", gst.getText());
				map.put("bank", bank.getText());
				map.put("companyname", company.getText());
				map.put("url", url.getText());
				int re = m.update("party", map, "id="+categoryid+"");
				if(re == 1) {
					JOptionPane.showMessageDialog(null, "update");
				}
				else {
					JOptionPane.showMessageDialog(null, "not update");
				}
				purchaseparty.data();
				dispose();
			}
		});
		update.setBounds(347, 398, 89, 23);
		contentPane.add(update);
	}

}
