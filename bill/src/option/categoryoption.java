package option;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import form.category;
import form.employee;
import sql.manage;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class categoryoption extends JFrame {

	private JPanel contentPane;
	public JTextField category1;
	public JTextField image;
	public JTextField decription;
	private JLabel imageadd;
	private manage m = new manage();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					categoryoption frame = new categoryoption();
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
	public categoryoption() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 417, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Category");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(86, 11, 215, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Category");
		lblNewLabel_1.setBounds(50, 104, 66, 14);
		contentPane.add(lblNewLabel_1);
		
		category1 = new JTextField();
		category1.setBounds(126, 101, 165, 20);
		contentPane.add(category1);
		category1.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Image");
		lblNewLabel_1_1.setBounds(50, 153, 66, 14);
		contentPane.add(lblNewLabel_1_1);
		
		image = new JTextField();
		image.setColumns(10);
		image.setBounds(126, 150, 165, 20);
		contentPane.add(image);
		
		JLabel lblNewLabel_1_2 = new JLabel("Description");
		lblNewLabel_1_2.setBounds(50, 230, 66, 14);
		contentPane.add(lblNewLabel_1_2);
		
		decription = new JTextField();
		decription.setColumns(10);
		decription.setBounds(126, 227, 165, 20);
		contentPane.add(decription);
		
		JButton add = new JButton("Add");
		add.addActionListener(new ActionListener() {
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
		add.setBounds(157, 181, 89, 23);
		contentPane.add(add);
		
		JButton submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HashMap<String,String> map = new HashMap<>();
				map.put("category", category1.getText());
				map.put("image", image.getText());
				map.put("description", decription.getText());
				
			int t = m.insert("category", map);
				if(t > 0) {
					JOptionPane.showMessageDialog(null, "add");
				}
				else {
					JOptionPane.showMessageDialog(null, "not add");
				}
				category.data();
				dispose();
			}
		});
		submit.setBounds(263, 334, 89, 23);
		contentPane.add(submit);
		
		imageadd = new JLabel("");
		imageadd.setBounds(10, 296, 215, 117);
		contentPane.add(imageadd);
		
		JButton update = new JButton("Update");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int categoryid = category.selecttable;
				HashMap<String,String> map = new HashMap<>();
				map.put("category", category1.getText());
				map.put("image", image.getText());
				map.put("description", decription.getText());
				var re = m.update("category", map, "id="+categoryid+"");
				if(re == 1) {
					JOptionPane.showMessageDialog(null, "update");
				}
				else {
					JOptionPane.showMessageDialog(null, "not update");
				}
				category.data();
				dispose();
			}
		});
		update.setBounds(263, 383, 89, 23);
		contentPane.add(update);
	}
}
