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

public class StudentSearch {

	private JDialog frmStudentSearch;
	JComboBox comboBox ;
	
    Functions func=new Functions();
    Statement stmt;
    Connection con;
    JLabel lblEnter;
    JButton btnGo;
    private JTextField textField;
    private JTable table_1;
    private JScrollPane scrollPane;
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
					StudentSearch window = new StudentSearch();
					window.frmStudentSearch.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	
	/**
	 * Create the application.
	 */
	public StudentSearch() {
		
		
		
		initialize();
	}

	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
         
		
		
		
		frmStudentSearch = new JDialog();
		frmStudentSearch.setModal(true);
		frmStudentSearch.setBounds(100, 100, 769, 429);
		frmStudentSearch.setResizable(false);
		frmStudentSearch.setTitle("Student Search");
		frmStudentSearch.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		 frmStudentSearch.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("4.gif")));
		frmStudentSearch.getContentPane().setLayout(null);
		
		JLabel lblPermanentAddress = new JLabel("Search By");
		lblPermanentAddress.setBounds(22, 26, 86, 20);
		lblPermanentAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmStudentSearch.getContentPane().add(lblPermanentAddress);
		
		
		String[] columnNames = {"Borrower_ID","Roll No","Name","Course","Branch","Contact No.","Address","Gender","ID Expiry Date"};
		
		
		
		
		
		
		comboBox = new JComboBox();

		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(comboBox.getSelectedItem().toString()=="All")
				{
					//btnGo.setEnabled(false);
					//lblEnter.setVisible(false);
				}
				
				
				//String a="All";
				//String b=comboBox.getSelectedItem().toString();
			//	if(b.equals(a)==true)
			//	{
			//		textField.setVisible(false);
			//		lblEnter.setVisible(false);
			//	}
			
			}
		});
		comboBox.setBounds(107, 28, 176, 20);
		comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		String [] s1={"All","Roll No","Name","Course","Branch"};
		for(String s: s1)
		{
			comboBox.addItem(s);
		}
		
		
		
		
		
		
		   /*String sms;
			
			ArrayList list=new ArrayList();
			list=func.searchCategory();
			Iterator it=list.iterator();
			while(it.hasNext())
			{
				DataMembers b=(DataMembers)it.next();
				sms=b.getCategory();
				comboBox.addItem(sms);
				
			}*/
		


		
		
		frmStudentSearch.getContentPane().add(comboBox);
		
		 lblEnter = new JLabel("Enter");
		 lblEnter.setVisible(false);
		lblEnter.setBounds(22, 82, 86, 20);
		lblEnter.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmStudentSearch.getContentPane().add(lblEnter);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
scrollPane.setVisible(true);
				
				
			   
				
				//String search=null;
				
				
				
				
			//	{
			//		JOptionPane.showMessageDialog(null, "hmm");
			//		textField.setText("All");
			//	    search=textField.getText().toString();
			//	}
				
			//	
			//	if(search.equals("All")==true)
			//	{
			//		JOptionPane.showMessageDialog(null, "hmm");
				if(comboBox.getSelectedItem().toString()=="All"){
				
					
					textField.setVisible(false);
					lblEnter.setVisible(false);
					
					
				try
				   {
					func.cc2();
				   func.stmt=func.con.createStatement();
				   
				    ResultSet rs=func.stmt.executeQuery("select *from borrower");
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
							String h=rs.getString(8);
							String i=rs.getString(9);
							model.addRow(new Object[]{a,b,c,d,e,f,g,h,i});					   
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
				
				//textField.setVisible(false);
				
				
				
				if(comboBox.getSelectedItem().toString()=="Roll No"){
					
					
					textField.setVisible(true);
					lblEnter.setVisible(true);
				
					if(textField.getText().equals("")==false)
					{
						
					
					 DefaultTableModel model = new DefaultTableModel(columnNames, 0);
					
					
					try
					   {
						
						func.cc2();
					    func.stmt=func.con.createStatement();
					    
					    ResultSet rs=func.stmt.executeQuery("select *from borrower where CRoll_No='"+ textField.getText().toString()+"' ");
					  
					    int x=0;
				     while(rs.next())
					   {			// JOptionPane.showMessageDialog(null, "hmm");   	 
				    	 String a=rs.getString(1);
							String b=rs.getString(2);
							String c=rs.getString(3);
							String d=rs.getString(4);
							String e=rs.getString(5);
							String f=rs.getString(6);
							String g=rs.getString(7);
							String h=rs.getString(8);
							String i=rs.getString(9);
							model.addRow(new Object[]{a,b,c,d,e,f,g,h,i});					   
							    table_1.setModel(model);
						        scrollPane.setViewportView(table_1);
						 x++;
					   }
				    if(x==0)
				    {
				    	  JOptionPane.showMessageDialog(null, "Invalid Borrower ID.");
				    }
				   
				     textField.setText(null);
				     	func.con.close();
					   }
					   	    
					catch(Exception e4)
					{
						e4.printStackTrace();
						
					}	 
					}
					
			}
					
				
				
				
                       if(comboBox.getSelectedItem().toString()=="Name"){
                    	 
					
					textField.setVisible(true);
					lblEnter.setVisible(true);
					  if(textField.getText().equals("")==false)
     					{
					 DefaultTableModel model = new DefaultTableModel(columnNames, 0);
					
					
					try
					   {
						
						func.cc2();
					    func.stmt=func.con.createStatement();
					   
					    ResultSet rs=func.stmt.executeQuery("select *from borrower where Name='"+ textField.getText().toString()+"' ");
					  
					  int x=0;
				     while(rs.next())
					   {		x++;    	 
					   String a=rs.getString(1);
						String b=rs.getString(2);
						String c=rs.getString(3);
						String d=rs.getString(4);
						String e=rs.getString(5);
						String f=rs.getString(6);
						String g=rs.getString(7);
						String h=rs.getString(8);
						String i=rs.getString(9);
						model.addRow(new Object[]{a,b,c,d,e,f,g,h,i});					   
							    table_1.setModel(model);
						        scrollPane.setViewportView(table_1);
						 
					   }
				     if(x==0)
					    {
					    	  JOptionPane.showMessageDialog(null, "Invalid Name.");
					    }
				     textField.setText(null);
				     	func.con.close();
					   }
					   	    
					catch(Exception e4)
					{
						e4.printStackTrace();
						
					}
       					}
																					
			}
					
					
                       if(comboBox.getSelectedItem().toString()=="Course"){
       					
                    	   textField.setVisible(true);
          					lblEnter.setVisible(true);
                    	   
                    	   
                    	   if(textField.getText().equals("")==false)
       					{
       					
       				
       					 DefaultTableModel model = new DefaultTableModel(columnNames, 0);
       					
       					
       					try
       					   {
       						
       						func.cc2();
       					    func.stmt=func.con.createStatement();
       					   
       					    ResultSet rs=func.stmt.executeQuery("select *from borrower where Course='"+ textField.getText().toString()+"' ");
       					int x=0;
       				     while(rs.next())
       					   {		  x++; 	 
       					String a=rs.getString(1);
						String b=rs.getString(2);
						String c=rs.getString(3);
						String d=rs.getString(4);
						String e=rs.getString(5);
						String f=rs.getString(6);
						String g=rs.getString(7);
						String h=rs.getString(8);
						String i=rs.getString(9);
						model.addRow(new Object[]{a,b,c,d,e,f,g,h,i});				   
       								table_1.setModel(model);
       							    scrollPane.setViewportView(table_1);
       						 
       					   }
       				  if(x==0)
  				    {
  				    	  JOptionPane.showMessageDialog(null, "Invalid Course.");
  				    }
       				     textField.setText(null);
       				     	func.con.close();
       					   }
       					   	    
       					catch(Exception e4)
       					{
       						e4.printStackTrace();
       						
       					}	} 
       																					
       			}
       						
				
				
                       if(comboBox.getSelectedItem().toString()=="Branch"){
          					
          					
          					textField.setVisible(true);
          					lblEnter.setVisible(true);
          					if(textField.getText().equals("")==false)
        					{
          					 DefaultTableModel model = new DefaultTableModel(columnNames, 0);
          					
          					
          					try
          					   {
          						
          						func.cc2();
          					    func.stmt=func.con.createStatement();
          					   
          					    ResultSet rs=func.stmt.executeQuery("select *from borrower where Branch='"+ textField.getText().toString()+"' ");
          					   
          					  int x=0;
          				     while(rs.next())
          					   {		x++;	    	 
          					 String a=rs.getString(1);
 							String b=rs.getString(2);
 							String c=rs.getString(3);
 							String d=rs.getString(4);
 							String e=rs.getString(5);
 							String f=rs.getString(6);
 							String g=rs.getString(7);
 							String h=rs.getString(8);
 							String i=rs.getString(9);
 							model.addRow(new Object[]{a,b,c,d,e,f,g,h,i});				   
          							    table_1.setModel(model);
          						        scrollPane.setViewportView(table_1);
          						 
          					   }
          				   if(x==0)
       				    {
       				    	  JOptionPane.showMessageDialog(null, "Invalid Branch.");
       				    }
          				     textField.setText(null);
          				     	func.con.close();
          					   }
          					   	    
          					catch(Exception e4)
          					{
          						e4.printStackTrace();
          						
          					}	 }
          																					
          			}
          						
   				
                       
				
					
				
				
				
				
				
			}
		});
		textField.setVisible(false);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(107, 79, 176, 28);
		frmStudentSearch.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		
		
		
		 btnGo = new JButton("Go");
		 btnGo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		 btnGo.setSelected(true);
		 btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				scrollPane.setVisible(true);
				
				
			   
				
				//String search=null;
				
				
				
				
			//	{
			//		JOptionPane.showMessageDialog(null, "hmm");
			//		textField.setText("All");
			//	    search=textField.getText().toString();
			//	}
				
			//	
			//	if(search.equals("All")==true)
			//	{
			//		JOptionPane.showMessageDialog(null, "hmm");
				if(comboBox.getSelectedItem().toString()=="All"){
				
					
					textField.setVisible(false);
					lblEnter.setVisible(false);
					
					
				try
				   {
					func.cc2();
				   func.stmt=func.con.createStatement();
				   
				    ResultSet rs=func.stmt.executeQuery("select *from borrower");
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
							String h=rs.getString(8);
							String i=rs.getString(9);
							model.addRow(new Object[]{a,b,c,d,e,f,g,h,i});					   
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
				
				//textField.setVisible(false);
				
				
				
				if(comboBox.getSelectedItem().toString()=="Roll No"){
					
					
					textField.setVisible(true);
					lblEnter.setVisible(true);
				
					if(textField.getText().equals("")==false)
					{
						
					
					 DefaultTableModel model = new DefaultTableModel(columnNames, 0);
					
					
					try
					   {
						
						func.cc2();
					    func.stmt=func.con.createStatement();
					    
					    ResultSet rs=func.stmt.executeQuery("select *from borrower where CRoll_No='"+ textField.getText().toString()+"' ");
					  
					    int x=0;
				     while(rs.next())
					   {			// JOptionPane.showMessageDialog(null, "hmm");   	 
				    	 String a=rs.getString(1);
							String b=rs.getString(2);
							String c=rs.getString(3);
							String d=rs.getString(4);
							String e=rs.getString(5);
							String f=rs.getString(6);
							String g=rs.getString(7);
							String h=rs.getString(8);
							String i=rs.getString(9);
							model.addRow(new Object[]{a,b,c,d,e,f,g,h,i});					   
							    table_1.setModel(model);
						        scrollPane.setViewportView(table_1);
						 x++;
					   }
				    if(x==0)
				    {
				    	  JOptionPane.showMessageDialog(null, "Invalid Borrower ID.");
				    }
				   
				     textField.setText(null);
				     	func.con.close();
					   }
					   	    
					catch(Exception e4)
					{
						e4.printStackTrace();
						
					}	 
					}
					
			}
					
				
				
				
                       if(comboBox.getSelectedItem().toString()=="Name"){
                    	 
					
					textField.setVisible(true);
					lblEnter.setVisible(true);
					  if(textField.getText().equals("")==false)
     					{
					 DefaultTableModel model = new DefaultTableModel(columnNames, 0);
					
					
					try
					   {
						
						func.cc2();
					    func.stmt=func.con.createStatement();
					   
					    ResultSet rs=func.stmt.executeQuery("select *from borrower where Name='"+ textField.getText().toString()+"' ");
					  
					  int x=0;
				     while(rs.next())
					   {		x++;    	 
					   String a=rs.getString(1);
						String b=rs.getString(2);
						String c=rs.getString(3);
						String d=rs.getString(4);
						String e=rs.getString(5);
						String f=rs.getString(6);
						String g=rs.getString(7);
						String h=rs.getString(8);
						String i=rs.getString(9);
						model.addRow(new Object[]{a,b,c,d,e,f,g,h,i});					   
							    table_1.setModel(model);
						        scrollPane.setViewportView(table_1);
						 
					   }
				     if(x==0)
					    {
					    	  JOptionPane.showMessageDialog(null, "Invalid Name.");
					    }
				     textField.setText(null);
				     	func.con.close();
					   }
					   	    
					catch(Exception e4)
					{
						e4.printStackTrace();
						
					}
       					}
																					
			}
					
					
                       if(comboBox.getSelectedItem().toString()=="Course"){
       					
                    	   textField.setVisible(true);
          					lblEnter.setVisible(true);
                    	   
                    	   
                    	   if(textField.getText().equals("")==false)
       					{
       					
       				
       					 DefaultTableModel model = new DefaultTableModel(columnNames, 0);
       					
       					
       					try
       					   {
       						
       						func.cc2();
       					    func.stmt=func.con.createStatement();
       					   
       					    ResultSet rs=func.stmt.executeQuery("select *from borrower where Course='"+ textField.getText().toString()+"' ");
       					int x=0;
       				     while(rs.next())
       					   {		  x++; 	 
       					String a=rs.getString(1);
						String b=rs.getString(2);
						String c=rs.getString(3);
						String d=rs.getString(4);
						String e=rs.getString(5);
						String f=rs.getString(6);
						String g=rs.getString(7);
						String h=rs.getString(8);
						String i=rs.getString(9);
						model.addRow(new Object[]{a,b,c,d,e,f,g,h,i});				   
       								table_1.setModel(model);
       							    scrollPane.setViewportView(table_1);
       						 
       					   }
       				  if(x==0)
  				    {
  				    	  JOptionPane.showMessageDialog(null, "Invalid Course.");
  				    }
       				     textField.setText(null);
       				     	func.con.close();
       					   }
       					   	    
       					catch(Exception e4)
       					{
       						e4.printStackTrace();
       						
       					}	} 
       																					
       			}
       						
				
				
                       if(comboBox.getSelectedItem().toString()=="Branch"){
          					
          					
          					textField.setVisible(true);
          					lblEnter.setVisible(true);
          					if(textField.getText().equals("")==false)
        					{
          					 DefaultTableModel model = new DefaultTableModel(columnNames, 0);
          					
          					
          					try
          					   {
          						
          						func.cc2();
          					    func.stmt=func.con.createStatement();
          					   
          					    ResultSet rs=func.stmt.executeQuery("select *from borrower where Branch='"+ textField.getText().toString()+"' ");
          					   
          					  int x=0;
          				     while(rs.next())
          					   {		x++;	    	 
          					 String a=rs.getString(1);
 							String b=rs.getString(2);
 							String c=rs.getString(3);
 							String d=rs.getString(4);
 							String e=rs.getString(5);
 							String f=rs.getString(6);
 							String g=rs.getString(7);
 							String h=rs.getString(8);
 							String i=rs.getString(9);
 							model.addRow(new Object[]{a,b,c,d,e,f,g,h,i});				   
          							    table_1.setModel(model);
          						        scrollPane.setViewportView(table_1);
          						 
          					   }
          				   if(x==0)
       				    {
       				    	  JOptionPane.showMessageDialog(null, "Invalid Branch.");
       				    }
          				     textField.setText(null);
          				     	func.con.close();
          					   }
          					   	    
          					catch(Exception e4)
          					{
          						e4.printStackTrace();
          						
          					}	 }
          																					
          			}
          						
   				
                       
				
					
				
				
				
				
				
				
	}
																									
		});
		btnGo.setBounds(312, 27, 52, 23);
		frmStudentSearch.getContentPane().add(btnGo);
		
		scrollPane = new JScrollPane();
		scrollPane.setVisible(false);
		scrollPane.setBounds(0, 176, 763, 187);
		frmStudentSearch.getContentPane().add(scrollPane);
		
		table_1 = new JTable();
		 table_1.setFont(new Font("SansSerif", Font.PLAIN, 12));
		 table_1.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		 table_1.setEnabled(false);
	     //table_1.getColumnModel().getColumn(0).setPreferredWidth(70);
	   //  table_1.getColumnModel().getColumn(1).setPreferredWidth(200);
	   //  table_1.getColumnModel().getColumn(2).setPreferredWidth(90);
	   //  table_1.getColumnModel().getColumn(3).setPreferredWidth(200);
		
		scrollPane.setViewportView(table_1);
		
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setRequestFocusEnabled(false);
		lblNewLabel.setBounds(0, 0, 763, 401);
		lblNewLabel.setIcon(new ImageIcon(StudentSearch.class.getResource("/ldbms/7.jpg")));
		frmStudentSearch.getContentPane().add(lblNewLabel);
		
	}
}
