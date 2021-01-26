package option;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import form.area;
import sql.manage;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class areaoption extends JFrame {

	private JPanel contentPane;
	public JTextField area1;
	public JComboBox city;
	private manage m = new manage();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					areaoption frame = new areaoption();
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
	private void getdata() {
		var t = m.viewitem("city", "city");
		try {
			while(t.next()) {
				city.addItem(t.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public areaoption() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 476, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Area");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel.setBounds(204, 11, 55, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("City");
		lblNewLabel_1.setBounds(76, 87, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		city = new JComboBox();
		city.setBounds(155, 83, 177, 22);
		contentPane.add(city);
		
		JLabel lblNewLabel_2 = new JLabel("Area");
		lblNewLabel_2.setBounds(76, 158, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		area1 = new JTextField();
		area1.setBounds(155, 155, 177, 20);
		contentPane.add(area1);
		area1.setColumns(10);
		
		JButton submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HashMap<String,String> map = new HashMap<>();
				map.put("city", city.getSelectedItem().toString());
				map.put("area", area1.getText());
				int t = m.insert("area", map);
				if(t > 0) {
					JOptionPane.showMessageDialog(null, "add");
				}
				else {
					JOptionPane.showMessageDialog(null, "not add");
				}
				area.data();
				dispose();
			}
		});
		submit.setBounds(113, 265, 89, 23);
		contentPane.add(submit);
		
		JButton update = new JButton("Update");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int categoryid = area.selecttable;
				HashMap<String,String> map = new HashMap<>();
				map.put("city", city.getSelectedItem().toString());
				map.put("area", area1.getText());
				int re = m.update("area", map, "id="+categoryid+"");
				if(re == 1) {
					JOptionPane.showMessageDialog(null, "update");
				}
				else {
					JOptionPane.showMessageDialog(null, "not update");
				}
				area.data();
				dispose();
			}
		});
		update.setBounds(243, 265, 89, 23);
		contentPane.add(update);
		getdata();
	}

}
