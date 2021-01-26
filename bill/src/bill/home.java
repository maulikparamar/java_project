package bill;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.PanelUI;

import form.*;
import menuitem.menu;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.BoxLayout;


public class home extends JFrame {

	private JPanel contentPane;
	private JPanel menus;
	private JPanel bodypanel;

	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home frame = new home();
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
	public home() {
		setResizable(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 859, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Invoice");
		menus = new JPanel();
		menus.setBorder(null);
		menus.setBackground(new Color(0, 128, 128));
		menus.setBounds(0, 0, 229, 705);
		contentPane.add(menus);
		menus.setLayout(new BoxLayout(menus, BoxLayout.Y_AXIS));
		
		createBody();
		execute();
	}
	
	private void execute() {
		ImageIcon iconemployee = new ImageIcon(getClass().getResource("/menuitem/employee.png"));
		ImageIcon subiconemployee = new ImageIcon(getClass().getResource("/menuitem/d.png"));
		ImageIcon subiconprodcut = new ImageIcon(getClass().getResource("/menuitem/subproduct.png"));
		ImageIcon iconproduct = new ImageIcon(getClass().getResource("/menuitem/product.png"));
		ImageIcon subshopping = new ImageIcon(getClass().getResource("/menuitem/subshopping.png"));
		ImageIcon sublocation = new ImageIcon(getClass().getResource("/menuitem/sublocation.png"));
		ImageIcon iconshopping = new ImageIcon(getClass().getResource("/menuitem/shopping.png"));
		ImageIcon iconlocation = new ImageIcon(getClass().getResource("/menuitem/location.png"));
		menu menustuff1 = new menu(subiconemployee,"role",new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				    contentPane.remove(bodypanel);
				    createBody();
					bodypanel.add(new role());
					bodypanel.revalidate();
					bodypanel.repaint();
			}
		});
		menu menustuff2 = new menu(subiconemployee,"employee",new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				 contentPane.remove(bodypanel);
				 createBody();
				bodypanel.add(new employee());
				bodypanel.revalidate();
				bodypanel.repaint();
			}
			
		});
		menu menustuff = new menu(iconemployee,"employee",null,menustuff1,menustuff2);
		
		menu menucatagorytstuff = new menu(subiconprodcut,"catagory",new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 contentPane.remove(bodypanel);
				 createBody();
				bodypanel.add(new category());
				bodypanel.revalidate();
				bodypanel.repaint();
				
			}
		});
		menu menuunittstuff = new menu(subiconprodcut,"unit",new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				contentPane.remove(bodypanel);
				createBody();
				bodypanel.add(new unit());
				bodypanel.revalidate();
				bodypanel.repaint();
				
			}
		});
		menu menuprocuttstuff = new menu(subiconprodcut,"product",new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				contentPane.remove(bodypanel);
				createBody();
				bodypanel.add(new product());
				bodypanel.revalidate();
				bodypanel.repaint();
				
			}
		});
		
		menu menuproduct = new menu(iconproduct,"product",null,menucatagorytstuff,menuunittstuff,menuprocuttstuff);
		
		menu menucity = new menu(sublocation,"city",new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				contentPane.remove(bodypanel);
				createBody();
				bodypanel.add(new city());
				bodypanel.revalidate();
				bodypanel.repaint();
			}
		});
		menu menuarea = new menu(sublocation,"Area",new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				contentPane.remove(bodypanel);
				createBody();
				bodypanel.add(new area());
				bodypanel.revalidate();
				bodypanel.repaint();
				
			}
		});
		menu menulocation = new menu(iconlocation,"Location",null,menucity,menuarea);
		
		menu menupurchasparty = new menu(subshopping,"purchaseparty",new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				contentPane.remove(bodypanel);
				createBody();
				bodypanel.add(new purchaseparty());
				bodypanel.revalidate();
				bodypanel.repaint();
				
			}
		});
		menu menugst = new menu(subshopping,"gst",new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				contentPane.remove(bodypanel);
				createBody();
				bodypanel.add(new gst());
				bodypanel.revalidate();
				bodypanel.repaint();
				
			}
		});
		menu menupurchase = new menu(subshopping,"shopping",new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				contentPane.remove(bodypanel);
				createBody();
				bodypanel.add(new shopping());
				bodypanel.revalidate();
				bodypanel.repaint();
				
			}
		});
		menu menushopping = new menu(iconshopping,"purchase",null,menupurchasparty,menugst,menupurchase);
		addmenu(menustuff,menuproduct,menulocation,menushopping);
	}
	private void addmenu(menu... menu) {
		for(int i =0;i < menu.length; i++) {
			menus.add(menu[i]);
			ArrayList<menu> submenu = menu[i].getSubmenu();
			for(menu m: submenu ) {
				addmenu(m);
			}
		}
	}
	
	private void createBody() {
		 bodypanel = new JPanel();
	     bodypanel.setBackground(new Color(0, 191, 255));
		 bodypanel.setBounds(227, 0, 1141, 705);
		 contentPane.add(bodypanel);
		 bodypanel.setLayout(new BorderLayout(0, 0));
	}
}
