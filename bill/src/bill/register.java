package bill;
import sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class register extends JFrame {

	private JPanel text;
	private JTextField role;
	private JTextField username;
	private JTextField password;
	private JTextField repassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					register frame = new register();
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
	public register() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 418, 433);
		text = new JPanel();
		text.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(text);
		text.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(91, 11, 195, 32);
		text.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Role");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(50, 91, 76, 25);
		text.add(lblNewLabel_1);
		
		role = new JTextField();
		role.setBounds(138, 91, 154, 22);
		text.add(role);
		role.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Username");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(50, 151, 76, 25);
		text.add(lblNewLabel_1_1);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(138, 151, 154, 22);
		text.add(username);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Password");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1.setBounds(50, 201, 76, 25);
		text.add(lblNewLabel_1_1_1);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(138, 201, 154, 22);
		text.add(password);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Repassword");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_2.setBounds(50, 250, 76, 25);
		text.add(lblNewLabel_1_1_2);
		
		repassword = new JTextField();
		repassword.setColumns(10);
		repassword.setBounds(138, 250, 154, 22);
		text.add(repassword);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(role.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Enter role");
				}else if(username.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Enter Username");
				}else if(password.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Enter Password");
				}else if(repassword.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Enter Repassword");
				}else if(password.getText() == repassword.getText()) {
					JOptionPane.showMessageDialog(null, "Same Password Please");
				}
				else {
					HashMap<String,String> map = new HashMap<>();
					map.put("role", role.getText().toString());
					
					HashMap<String,String> ma = new HashMap<>();
					ma.put("username", username.getText().toString());
					ma.put("password", password.getText().toString());
					manage m = new manage();
					m.insert("role", map);
					m.insert("login", ma);
					System.out.println(ma.toString());
					login v = new login();
					v.setVisible(true);
					dispose();
				}
				
			}
		});
		btnNewButton.setBounds(138, 322, 89, 23);
		text.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				password.setText("");
				role.setText("");
				repassword.setText("");
				username.setText("");
				
			}
		});
		btnNewButton_1.setBounds(255, 322, 89, 23);
		text.add(btnNewButton_1);
	}

}
