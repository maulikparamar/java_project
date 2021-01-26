package menuitem;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Icon;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class menu extends JPanel {

	/**
	 * Create the panel.
	 */
	private final ArrayList<menu> submenu = new ArrayList<>();
	private JLabel lblicon;
	private JLabel lblNewLabel;
	private ActionListener act;
	public ArrayList<menu> getSubmenu() {
		return submenu;
	}
	
	
	public menu(Icon icon,String menuname,ActionListener act,menu...submenu) {
		
		if(act != null) {
			this.act = act;
		}
		
		addMouseListener(new MouseAdapter() {
			private boolean showing=false;
			@Override
			public void mousePressed(MouseEvent e) {
				if(showing) {
					hideMenu();
					showing = false;
				}else {
					showMenu();
					showing = true;
				}
				if(act != null) {
					act.actionPerformed(null);
				}
			}
		});
		setLayout(null);
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(0, 50, 413, 9);
		add(separator);
		
		lblicon = new JLabel("");
		lblicon.setHorizontalAlignment(SwingConstants.CENTER);
		lblicon.setBounds(0, 11, 64, 28);
		add(lblicon);

		lblNewLabel = new JLabel("Enter Your Menu");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(67, 11, 202, 28);
		add(lblNewLabel);
		
		
		lblicon.setIcon(icon);
		lblNewLabel.setText(menuname);
		this.setSize(new Dimension(207, 58));
		this.setMaximumSize(new Dimension(Integer.MAX_VALUE,60));
		this.setMinimumSize(new Dimension(Integer.MAX_VALUE,45));
		for(int i = 0; i < submenu.length; i++) {
			this.submenu.add(submenu[i]);
			submenu[i].setVisible(false);
		}

	}
	
	private void showMenu() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i =0; i < submenu.size(); i++) {
					sleep();
					submenu.get(i).setVisible(true);
				}
				
			}
		}).start();
	}
	
	private void hideMenu() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i =submenu.size() -1; i>=0 ; i--) {
					sleep();
					submenu.get(i).setVisible(false);
				}
				
			}
		}).start();
	}
	
	private void sleep() {
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
