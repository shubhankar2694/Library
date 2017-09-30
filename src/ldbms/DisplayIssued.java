package ldbms;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.awt.Cursor;

public class DisplayIssued {

	private JDialog frmDisplayIssued;
	JComboBox comboBox;
	JComboBox comboBox_1;
    Functions func=new Functions();
    Statement stmt;
    Connection con;
    private JTable table_1;
    JLabel lblIssuedDate;
    private JScrollPane scrollPane;
    private JButton button_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try { UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					DisplayIssued window = new DisplayIssued();
					window.frmDisplayIssued.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	
	/**
	 * Create the application.
	 */
	public DisplayIssued() {
		
		
		
		initialize();
	}

	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
         
		
		
		
		frmDisplayIssued = new JDialog();
		frmDisplayIssued.setModal(true);
		frmDisplayIssued.setBounds(100, 100, 675, 429);
		frmDisplayIssued.setResizable(false);
		frmDisplayIssued.setTitle("Issued Book Search");
		frmDisplayIssued.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		 frmDisplayIssued.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("4.gif")));
		frmDisplayIssued.getContentPane().setLayout(null);
		
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 120, 624, 258);
		frmDisplayIssued.getContentPane().add(scrollPane);
		
		table_1 = new JTable();
		 table_1.setFont(new Font("SansSerif", Font.PLAIN, 12));
		 table_1.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		 table_1.setEnabled(false);
	     //table_1.getColumnModel().getColumn(0).setPreferredWidth(70);
	   //  table_1.getColumnModel().getColumn(1).setPreferredWidth(200);
	   //  table_1.getColumnModel().getColumn(2).setPreferredWidth(90);
	   //  table_1.getColumnModel().getColumn(3).setPreferredWidth(200);
		
		scrollPane.setViewportView(table_1);
		
		JLabel label = new JLabel("Search By");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(22, 35, 86, 20);
		frmDisplayIssued.getContentPane().add(label);
		
		comboBox = new JComboBox();
		String s[]={"All","Issued Date"};
		for(String s1: s)
		{
			comboBox.addItem(s1);
		}
		
		
		comboBox.setBounds(107, 37, 176, 25);
		frmDisplayIssued.getContentPane().add(comboBox);
		
		
		comboBox_1 = new JComboBox();
		comboBox_1.setVisible(false);
		comboBox_1.setBounds(107, 86, 176, 25);
		
		
		 String[] columnNames1 = {"Book_ID","Book Name","Borrower_ID","Borrower Name","Issued Date","Return Date"};
			
			try
			   {
				func.cc2();
			   func.stmt=func.con.createStatement();
			   
			    ResultSet rs=func.stmt.executeQuery("select distinct(Issued_date) from issue ");
			    DefaultTableModel model = new DefaultTableModel(columnNames1, 0);
			    
		     while(rs.next())
			   {			    	 
				        String a=rs.getString(1);
						
				        comboBox_1.addItem(a);
						
				 
			   }
		     	func.con.close();
			   }
			   	    
			catch(Exception e4)
			{
				e4.printStackTrace();
			}	 
			
			
			
			
		
		
		
		
		JButton button = new JButton("Go");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				if(comboBox.getSelectedItem().toString().equals("All")==true)
				{
					 String[] columnNames = {"Roll No","Borrower_ID","Book_ID","Book Name","Borrower Name","Issued Date","Return Date"};
						
						try
						   {
							func.cc2();
						   func.stmt=func.con.createStatement();
						   
						    ResultSet rs=func.stmt.executeQuery("select *from issue ");
						    DefaultTableModel model = new DefaultTableModel(columnNames, 0);
						    
					     while(rs.next())
						   {			    	 
							        String a=rs.getString(1);
									String b=rs.getString(2);
									String c=rs.getString(3);
									String d=rs.getString(4);
									String e=rs.getString(5);
									String f=rs.getString(6);
									String g=rs.getString(7);
									model.addRow(new Object[]{a,b,c,d,e,f,g});					   
								    table_1.setModel(model);
							        scrollPane.setViewportView(table_1);
							 
						   }
					     	func.con.close();
						   }
						   	    
						catch(Exception e4)
						{
							e4.printStackTrace();
						}	 
												
				}
						
						if(comboBox.getSelectedItem().toString().equals("Issued Date")==true)
						{
							
							lblIssuedDate.setVisible(true);
							comboBox_1.setVisible(true);
							button_1.setVisible(true);
								 
						}	 
			
			}});
		
		
		frmDisplayIssued.getContentPane().add(comboBox_1);
		button.setSelected(true);
		button.setBounds(312, 36, 52, 23);
		frmDisplayIssued.getContentPane().add(button);
		
		 lblIssuedDate = new JLabel("Issued Date");
		lblIssuedDate.setVisible(false);
		lblIssuedDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIssuedDate.setBounds(18, 87, 86, 20);
		frmDisplayIssued.getContentPane().add(lblIssuedDate);
		
		button_1 = new JButton("Go");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				
				 String[] columnNames = {"Roll No","Borrower_ID","Book_ID","Book Name","Borrower Name","Issued Date","Return Date"};
					
					try
					   {
						func.cc2();
					   func.stmt=func.con.createStatement();
					   
					    ResultSet rs=func.stmt.executeQuery("select *from issue where Issued_date='"+comboBox_1.getSelectedItem().toString()+"' ");
					    DefaultTableModel model = new DefaultTableModel(columnNames, 0);
					    
				     while(rs.next())
					   {			    	 
						        String a=rs.getString(1);
								String b=rs.getString(2);
								String c=rs.getString(3);
								String d=rs.getString(4);
								String e=rs.getString(5);
								String f=rs.getString(6);
								String g=rs.getString(7);
								model.addRow(new Object[]{a,b,c,d,e,f,g});					   
							    table_1.setModel(model);
						        scrollPane.setViewportView(table_1);
						 
					   }
				     	func.con.close();
					   }
					   	    
					catch(Exception e4)
					{
						e4.printStackTrace();
					}	 
						
				
				
				
			}
		});
		button_1.setVisible(false);
		button_1.setSelected(true);
		button_1.setBounds(312, 88, 52, 23);
		frmDisplayIssued.getContentPane().add(button_1);
		
		
		
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setRequestFocusEnabled(false);
		lblNewLabel.setBounds(0, 0, 669, 401);
		lblNewLabel.setIcon(new ImageIcon(DisplayIssued.class.getResource("/ldbms/6.jpg")));
		frmDisplayIssued.getContentPane().add(lblNewLabel);
		
		
		
		
		
		
		
	}
}
