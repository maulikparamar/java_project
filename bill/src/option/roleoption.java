package option;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import form.role;
import sql.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class roleoption extends JFrame {

	private JPanel contentPane;
	public JTextField roleadd;
	private manage m;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					roleoption frame = new roleoption();
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
	public roleoption() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 459, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Role Add");
		lblNewLabel.setBounds(73, 109, 70, 33);
		contentPane.add(lblNewLabel);
		setTitle("Role");
		
		roleadd = new JTextField();
		roleadd.setBounds(153, 115, 167, 20);
		contentPane.add(roleadd);
		roleadd.setColumns(10);
		
		JButton submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
					HashMap<String,String> map = new HashMap<>();
					map.put("role", roleadd.getText());
					 m = new manage();
					var u = m.insert("role", map);
					if(u == 1) {
						JOptionPane.showMessageDialog(null, "Add Value");
					}
					else {
						JOptionPane.showMessageDialog(null, "not Add value");
					}
					role.data();
					dispose();
				}
			
		});
		submit.setBounds(153, 224, 89, 23);
		contentPane.add(submit);
		
		JButton update = new JButton("update");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int roleid = role.selecttable;
				HashMap<String,String>map = new HashMap<>();
				map.put("role", roleadd.getText());
				System.out.println(map);
				 m = new manage();
				var re = m.update("role", map,"id="+roleid+"");
				roleid = 0;
				if(re == 1) {
					JOptionPane.showMessageDialog(null, "update");
				}
				else {
					JOptionPane.showMessageDialog(null, "not update");
				}
				role.data();
				dispose();

			}
		});
		update.setBounds(254, 224, 89, 23);
		contentPane.add(update);
	}
}
