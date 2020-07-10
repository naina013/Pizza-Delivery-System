package question5;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import databaseSetup.DBoperations;
import databaseSetup.csvdata;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;

public class MainDisplay {

	private JFrame frame;
	private JTextField id;
	private JTextField name;
	private JTextField base;
	private JTextField top;
	private JTable table = new JTable();
	clientImpl cl = new clientImpl();
	DBoperations dbop = new DBoperations();
	csvdata csv = new csvdata();
	DefaultTableModel  model = new DefaultTableModel();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainDisplay window = new MainDisplay();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainDisplay() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 734, 738);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pizza Menu");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(283, 11, 130, 21);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PizzaID");
		lblNewLabel_1.setBounds(91, 46, 88, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Pizza Name");
		lblNewLabel_2.setBounds(91, 81, 88, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		id = new JTextField();
		id.setBounds(471, 43, 86, 20);
		frame.getContentPane().add(id);
		id.setColumns(10);
		
		name = new JTextField();
		name.setBounds(471, 78, 86, 20);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		base = new JTextField();
		base.setBounds(471, 111, 86, 20);
		frame.getContentPane().add(base);
		base.setColumns(10);
		
		top = new JTextField();
		top.setBounds(471, 141, 86, 20);
		frame.getContentPane().add(top);
		top.setColumns(10);
		
		JButton btnNewButton = new JButton("GET");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(250, 235, 215));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				     if(id.getText().isEmpty()) {
				
						 try {
							model = cl.Clientget();
							table.setModel(model);
						} catch (URISyntaxException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} 
				     else{
						 try {
							 int data = Integer.parseInt(id.getText());
							model = cl.Clientgetbyid(data);
							table.setModel(model);
						} catch (URISyntaxException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						}
				
					
				}
				
			
			
		});
		btnNewButton.setBounds(48, 197, 101, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("POST");
		btnNewButton_1.setBackground(new Color(250, 235, 215));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(id.getText().isEmpty()||name.getText().isEmpty()||base.getText().isEmpty()||top.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "FILL DATA");
				}
				else {
				int data = Integer.parseInt(id.getText());
				String name1 = name.getText();
				String base1 = base.getText();
				String top1 = top.getText();
				try {
					cl.clientPost(data,name1,base1,top1);
					model = cl.Clientget();
					table.setModel(model);
					JOptionPane.showMessageDialog(null, "DATA SUCCESSFULLY INSERTED");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			}
		});
		btnNewButton_1.setBounds(283, 197, 107, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("DELETE");
		btnNewButton_2.setBackground(new Color(250, 235, 215));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(id.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Insert id ");
				}
				else {
				int data = Integer.parseInt(id.getText());
				try {
				   boolean check = cl.clientDelete(data);
				   model = cl.Clientget();
					table.setModel(model);
				   JOptionPane.showMessageDialog(null, "DELETED SUCCESSFULLY");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			}
		});
		btnNewButton_2.setBounds(48, 263, 101, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("PUT");
		btnNewButton_3.setBackground(new Color(250, 235, 215));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(id.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "ENTER id ");
				}
				else {
				int data = Integer.parseInt(id.getText());
				String name1 = name.getText();
				String base1 = base.getText();
				String top1 = top.getText();
				try {
					boolean check = cl.ClientPut(data,name1,base1,top1);
					model = cl.Clientget();
					table.setModel(model);
					JOptionPane.showMessageDialog(null, "DATA SUCCESSFULLY UPDATED");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			}
		});
		btnNewButton_3.setBounds(544, 197, 107, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("CLEAR ");
		btnNewButton_4.setBackground(new Color(250, 235, 215));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int res;
				try {
					res = dbop.deldata();
					model = cl.Clientget();
					table.setModel(model);
					if(res==1) {JOptionPane.showMessageDialog(null, " ALL DATA DELETED");
					
					}
						else
						{
							JOptionPane.showMessageDialog(null, "NOT DONE");
						}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_4.setBounds(283, 263, 107, 23);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("EXPORT CSV");
		btnNewButton_5.setBackground(new Color(250, 235, 215));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int res;
				try {
					res = csv.csvprint();
					if(res==1) {JOptionPane.showMessageDialog(null, "EXPORTED");
					
					}
						else
						{
							JOptionPane.showMessageDialog(null, "NOT DONE");
						}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_5.setBounds(544, 263, 107, 23);
		frame.getContentPane().add(btnNewButton_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 356, 607, 284);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		
		
		JLabel lblNewLabel_3 = new JLabel("Pizza Base");
		lblNewLabel_3.setBounds(91, 114, 88, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Pizza Topping");
		lblNewLabel_4.setBounds(91, 144, 88, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("VIEW");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(304, 327, 59, 16);
		frame.getContentPane().add(lblNewLabel_5);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("CREATE TABLE");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int res;
				try {
					res = dbop.createdata();
					if(res==1) {JOptionPane.showMessageDialog(null, "NEW TABLE CREATED");
					
					}
						else
						{
							JOptionPane.showMessageDialog(null, "NOT DONE");
						}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("INSERT DATA IN TABLE");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int res;
				try {
					res = dbop.filldata();
					if(res==1) {JOptionPane.showMessageDialog(null, " DONE");
					
					}
						else
						{
							JOptionPane.showMessageDialog(null, "NOT DONE");
						}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("INFO");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "NAME : DRISHTI SINGH ROLLNO:A00268741");
					
					
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
	}
}
