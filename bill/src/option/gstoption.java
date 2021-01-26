package option;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import form.gst;
import sql.manage;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class gstoption extends JFrame {

	private JPanel contentPane;
	public JTextField gst1;
	private manage m = new manage();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gstoption frame = new gstoption();
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
	public gstoption() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 440, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gst");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel.setBounds(193, 11, 53, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Gst");
		lblNewLabel_1.setBounds(123, 90, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		gst1 = new JTextField();
		gst1.setBounds(179, 87, 142, 20);
		contentPane.add(gst1);
		gst1.setColumns(10);
		
		JButton submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HashMap<String,String> map = new HashMap<>();
				map.put("gst", gst1.getText().toString());
				int t = m.insert("gst", map);
				if(t > 0) {
					JOptionPane.showMessageDialog(null, "add");
				}
				else {
					JOptionPane.showMessageDialog(null, "not add");
				}
				gst.data();
				dispose();
			}
		});
		submit.setBounds(123, 167, 89, 23);
		contentPane.add(submit);
		
		JButton update = new JButton("Update");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int gstid = gst.selecttable;
				HashMap<String,String> map = new HashMap<>();
				map.put("gst", gst1.getText());
				int re = m.update("gst", map, "id="+gstid+"");
				if(re == 1) {
					JOptionPane.showMessageDialog(null, "update");
				}
				else {
					JOptionPane.showMessageDialog(null, "not update");
				}
				gst.data();
				dispose();
			}
		});
		update.setBounds(251, 167, 89, 23);
		contentPane.add(update);
	}

}
