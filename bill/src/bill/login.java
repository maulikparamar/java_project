package bill;
import sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	manage me = new manage();
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 15));
		lblNewLabel.setBounds(80, 98, 93, 27);
		contentPane.add(lblNewLabel);
		
		username = new JTextField();
		username.setToolTipText("");
		username.setBounds(164, 99, 169, 22);
		contentPane.add(username);
		username.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 15));
		lblPassword.setBounds(80, 157, 93, 27);
		contentPane.add(lblPassword);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(164, 158, 169, 22);
		contentPane.add(password);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(username.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Input Username");
				}else if(password.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Input Password");
				}else {
					dispose();
				int k = me.login("login", "username='"+username.getText()+"'", "password='"+password.getText()+"'");
				if(k == 1) {
					home t = new home();
					t.setVisible(true);
				}
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(164, 276, 127, 22);
		contentPane.add(btnNewButton);
		
		lblNewLabel_1 = new JLabel("Login Page");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(109, 35, 195, 27);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Register");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				dispose();
				register u = new register();
				u.setVisible(true);
				
			}
		});
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(163, 234, 128, 22);
		contentPane.add(lblNewLabel_2);
	}
}
