package option;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import form.unit;
import sql.manage;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class unitoption extends JFrame {

	private JPanel contentPane;
	public JTextField unit1;
	private manage m = new manage();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					unitoption frame = new unitoption();
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
	public unitoption() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 431, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Unit");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(160, 24, 53, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("unit");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(97, 151, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		unit1 = new JTextField();
		unit1.setBounds(150, 150, 148, 20);
		contentPane.add(unit1);
		unit1.setColumns(10);
		
		JButton submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HashMap<String,String> map = new HashMap<>();
				map.put("unit", unit1.getText());
				var t = m.insert("unit", map);
				if(t > 0) {
					JOptionPane.showMessageDialog(null, "add");
				}
				else {
					JOptionPane.showMessageDialog(null, "not add");
				}
				unit.data();
				dispose();
			}
		});
		submit.setBounds(147, 242, 89, 23);
		contentPane.add(submit);
		
		JButton update = new JButton("Update");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int categoryid = unit.selecttable;
				HashMap<String,String> map = new HashMap<>();
				map.put("unit", unit1.getText());
				int re = m.update("unit", map, "id="+categoryid+"");
				if(re == 1) {
					JOptionPane.showMessageDialog(null, "update");
				}
				else {
					JOptionPane.showMessageDialog(null, "not update");
				}
				unit.data();
				dispose();
			}
		});
		update.setBounds(267, 242, 89, 23);
		contentPane.add(update);
	}
}
