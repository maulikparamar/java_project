package option;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import form.city;
import sql.manage;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class cityoption extends JFrame {

	private JPanel contentPane;
	public JTextField city1;
	private manage m = new manage();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cityoption frame = new cityoption();
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
	public cityoption() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("City");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel.setBounds(185, 11, 59, 26);
		contentPane.add(lblNewLabel);
		
		JLabel City = new JLabel("City");
		City.setFont(new Font("Tahoma", Font.PLAIN, 12));
		City.setBounds(102, 121, 46, 14);
		contentPane.add(City);
		
		city1 = new JTextField();
		city1.setBounds(158, 119, 166, 20);
		contentPane.add(city1);
		city1.setColumns(10);
		
		JButton submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HashMap<String,String> map = new HashMap<>();
				map.put("city", city1.getText());
				int t = m.insert("city", map);
				if(t > 0) {
					JOptionPane.showMessageDialog(null, "add");
				}
				else {
					JOptionPane.showMessageDialog(null, "not add");
				}
				city.data();
				dispose();
			}
		});
		submit.setBounds(155, 210, 89, 23);
		contentPane.add(submit);
		
		JButton update = new JButton("Update");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int categoryid = city.selecttable;
				HashMap<String,String> map = new HashMap<>();
				map.put("city", city1.getText());
				int re = m.update("city", map, "id="+categoryid+"");
				if(re == 1) {
					JOptionPane.showMessageDialog(null, "update");
				}
				else {
					JOptionPane.showMessageDialog(null, "not update");
				}
				city.data();
				dispose();
			}
		});
		update.setBounds(275, 210, 89, 23);
		contentPane.add(update);
	}

}
