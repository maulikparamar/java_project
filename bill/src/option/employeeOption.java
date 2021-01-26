package option;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import form.employee;
import form.role;
import sql.manage;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class employeeOption extends JFrame {

	private JPanel contentPane;
	public JTextField job;
	public JTextField birthday;
	public JTextField email;
	public JTextField textarea;
	public JTextField image;
	public JTextField numberadd;
	private JLabel imageadd;
	public JComboBox role;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					employeeOption frame = new employeeOption();
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
	public employeeOption() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 490, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Employee");
		JLabel lblNewLabel = new JLabel("job");
		lblNewLabel.setBounds(25, 121, 80, 25);
		contentPane.add(lblNewLabel);
		
		job = new JTextField();
		job.setBounds(90, 123, 140, 20);
		contentPane.add(job);
		job.setColumns(10);
		
		JLabel lblBirthdate = new JLabel("Birthdate");
		lblBirthdate.setBounds(25, 172, 80, 25);
		contentPane.add(lblBirthdate);
		
		birthday = new JTextField();
		birthday.setColumns(10);
		birthday.setBounds(90, 174, 140, 20);
		contentPane.add(birthday);
		
		JLabel email1 = new JLabel("Email");
		email1.setBounds(261, 63, 80, 25);
		contentPane.add(email1);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(299, 65, 148, 20);
		contentPane.add(email);
		
		JLabel lblNewLabel_3 = new JLabel("Role");
		lblNewLabel_3.setBounds(25, 68, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		role = new JComboBox();
		role.setBounds(90, 64, 140, 22);
		manage m = new manage();
		var u = m.viewitem("role", "role");
		try {
			while(u.next()) {
				role.addItem(u.getString(1));	
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		contentPane.add(role);
		
		JLabel lblTextarea = new JLabel("TextArea");
		lblTextarea.setBounds(247, 121, 80, 25);
		contentPane.add(lblTextarea);
		
		textarea = new JTextField();
		textarea.setColumns(10);
		textarea.setBounds(299, 123, 148, 20);
		contentPane.add(textarea);
		
		JLabel lblImage = new JLabel("image");
		lblImage.setBounds(264, 172, 80, 25);
		contentPane.add(lblImage);
		
		image = new JTextField();
		image.setColumns(10);
		image.setBounds(316, 174, 148, 20);
		contentPane.add(image);
		
		JLabel number = new JLabel("Number");
		number.setBounds(25, 242, 80, 25);
		contentPane.add(number);
		
		numberadd = new JTextField();
		numberadd.setColumns(10);
		numberadd.setBounds(90, 244, 140, 20);
		contentPane.add(numberadd);
//		String imageww = image.getText();
//		imageww = imageww.replace("\\", "\\\\");
		
		JButton submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HashMap<String,String> map = new HashMap<>();
				map.put("role", role.getSelectedItem().toString());
				map.put("job", job.getText());
				map.put("email", email.getText());
				map.put("birthdate", birthday.getText());
				map.put("textarea", textarea.getText());
				map.put("image", image.getText());
				map.put("emp_number", numberadd.getText());
					manage m= new manage();
				int t = m.insert("employee", map);
				if(t > 0) {
					JOptionPane.showMessageDialog(null, "add");
				}
				else {
					JOptionPane.showMessageDialog(null, "not add");
				}
				employee.data();
				dispose();
			}
		});
		submit.setBounds(60, 342, 89, 23);
		contentPane.add(submit);
		
		JLabel lblNewLabel_1 = new JLabel("Employee Add");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_1.setBounds(154, 11, 155, 25);
		contentPane.add(lblNewLabel_1);
		
		
		JButton btnNewButton = new JButton("Add Image");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				File i = chooser.getSelectedFile();
				String filename = i.getAbsolutePath();
				image.setText(filename);
				ImageIcon icon = new ImageIcon(filename);
				Image image = icon.getImage().getScaledInstance(imageadd.getWidth(), imageadd.getHeight(), Image.SCALE_SMOOTH);
				imageadd.setIcon(icon);
			}
		});
		btnNewButton.setBounds(337, 208, 94, 23);
		contentPane.add(btnNewButton);
		
		imageadd = new JLabel("");
		imageadd.setBounds(261, 247, 186, 178);
		contentPane.add(imageadd);
		
		JButton update = new JButton("update");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int employee_id = employee.selecttable;
				
				HashMap<String,String>up = new HashMap<>();
				up.put("role", role.getSelectedItem().toString());
				up.put("job", job.getText());
				up.put("email", email.getText());
				up.put("birthdate", birthday.getText());
				up.put("textarea", textarea.getText());
				up.put("image", image.getText());
				up.put("emp_number", numberadd.getText());
				manage m = new manage();
				
				var re = m.update("employee", up,"id='"+employee_id+"'");
				if(re == 1) {
					JOptionPane.showMessageDialog(null, "update");
				}
				else {
					JOptionPane.showMessageDialog(null, "not update");
				}
				employee.data();
				dispose();
			}
		});
		update.setBounds(209, 342, 89, 23);
		contentPane.add(update);
		
	}
}
