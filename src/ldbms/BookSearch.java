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
import java.awt.Color;

public class BookSearch {

	private JDialog frmBookSearch;
	JComboBox comboBox ;
	
    Functions func=new Functions();
    Statement stmt;
    Connection con;
    JLabel lblEnter;
    JButton btnGo;
    private JTextField textField;
    private JTable table_1;
    private JScrollPane scrollPane;
    private JTextField textField_1;
    private JLabel lblIssued;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try { UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					BookSearch window = new BookSearch();
					window.frmBookSearch.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	
	/**
	 * Create the application.
	 */
	public BookSearch() {
		
		
		
		initialize();
	}

	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
         
		
		
		
		frmBookSearch = new JDialog();
		frmBookSearch.setModal(true);
		frmBookSearch.setBounds(100, 100, 675, 429);
		frmBookSearch.setResizable(false);
		frmBookSearch.setTitle("Count / Search Books");
		frmBookSearch.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		 frmBookSearch.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("4.gif")));
		frmBookSearch.getContentPane().setLayout(null);
		
		JLabel lblPermanentAddress = new JLabel("Search By");
		lblPermanentAddress.setBounds(22, 26, 86, 20);
		lblPermanentAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmBookSearch.getContentPane().add(lblPermanentAddress);
		
		
		
		
		
		
		
		
		
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
		String [] s1={"All","Book ID","Book Name","Author","Category"};
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
		


		
		
		frmBookSearch.getContentPane().add(comboBox);
		
		 lblEnter = new JLabel("Enter");
		 lblEnter.setVisible(false);
		lblEnter.setBounds(22, 82, 86, 20);
		lblEnter.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmBookSearch.getContentPane().add(lblEnter);
		
		textField = new JTextField();
		textField.setVisible(false);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(107, 79, 176, 28);
		frmBookSearch.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		String[] columnNames = {"Book_ID","Book Name","Author","Category","Issue Status"};
		
		
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
				   
				    ResultSet rs=func.stmt.executeQuery("select *from book ");
				    DefaultTableModel model = new DefaultTableModel(columnNames, 0);
				    String e=null;
			     while(rs.next())
				   {			    	 
					        String a=rs.getString(1);
					        boolean ans=func.alreadyIssued2(a);
					        if(ans==true)
					        {
					        	e="           ■";
					        }
					        else
					        {
					        	e=null;
					        }
							String b=rs.getString(2);
							String c=rs.getString(3);
							String d=rs.getString(4);
							model.addRow(new Object[]{a,b,c,d,e});					   
						    table_1.setModel(model);
					        scrollPane.setViewportView(table_1);
					 
				   }
			     textField_1.setText(Integer.toString(model.getRowCount()));
			  //  JOptionPane.showMessageDialog(null, model.getRowCount());
			     	func.con.close();
				   }
				   	    
				catch(Exception e4)
				{
					e4.printStackTrace();
				}	 
																				
		}
				
				//textField.setVisible(false);
				
				
				
				if(comboBox.getSelectedItem().toString()=="Book Name"){
					
					
					textField.setVisible(true);
					lblEnter.setVisible(true);
				
					if(textField.getText().equals("")==false)
					{
						
					
					 DefaultTableModel model = new DefaultTableModel(columnNames, 0);
					
					
					try
					   {
						
						func.cc2();
					    func.stmt=func.con.createStatement();
					    
					    ResultSet rs=func.stmt.executeQuery("select *from book where Name='"+ textField.getText().toString()+"' ");
					  
					    int x=0;
				     while(rs.next())
					   {			// JOptionPane.showMessageDialog(null, "hmm");   	 
						        String a=rs.getString(1);
								String b=rs.getString(2);
								String c=rs.getString(3);
								String d=rs.getString(4);
								model.addRow(new Object[]{a,b,c,d});					   
							    table_1.setModel(model);
						        scrollPane.setViewportView(table_1);
						 x++;
					   }
				    if(x==0)
				    {
				    	  JOptionPane.showMessageDialog(null, "Invalid Book Name.");
				    }
				   
				     textField.setText(null);
				     textField_1.setText(Integer.toString(model.getRowCount()));
				     	func.con.close();
					   }
					   	    
					catch(Exception e4)
					{
						e4.printStackTrace();
						
					}	 
					}
					
			}
					
				
				
				
                       if(comboBox.getSelectedItem().toString()=="Book ID"){
                    	 
					
					textField.setVisible(true);
					lblEnter.setVisible(true);
					  if(textField.getText().equals("")==false)
     					{
					 DefaultTableModel model = new DefaultTableModel(columnNames, 0);
					
					
					try
					   {
						
						func.cc2();
					    func.stmt=func.con.createStatement();
					   
					    ResultSet rs=func.stmt.executeQuery("select *from book where Bid='"+ textField.getText().toString()+"' ");
					  
					  int x=0;
				     while(rs.next())
					   {		x++;    	 
						        String a=rs.getString(1);
								String b=rs.getString(2);
								String c=rs.getString(3);
								String d=rs.getString(4);
								model.addRow(new Object[]{a,b,c,d});					   
							    table_1.setModel(model);
						        scrollPane.setViewportView(table_1);
						 
					   }
				     if(x==0)
					    {
					    	  JOptionPane.showMessageDialog(null, "Invalid Book ID.");
					    }
				     textField_1.setText(Integer.toString(model.getRowCount()));
				     textField.setText(null);
				     	func.con.close();
					   }
					   	    
					catch(Exception e4)
					{
						e4.printStackTrace();
						
					}
       					}
																					
			}
					
					
                       if(comboBox.getSelectedItem().toString()=="Author"){
       					
                    	   
                    	   textField.setVisible(true);
          					lblEnter.setVisible(true);
                    	   if(textField.getText().equals("")==false)
       					{
       					
       				
       					 DefaultTableModel model = new DefaultTableModel(columnNames, 0);
       					
       					
       					try
       					   {
       						
       						func.cc2();
       					    func.stmt=func.con.createStatement();
       					   
       					    ResultSet rs=func.stmt.executeQuery("select *from book where Author='"+ textField.getText().toString()+"' ");
       					int x=0;
       				     while(rs.next())
       					   {		  x++; 	 
       						        String a=rs.getString(1);
       								String b=rs.getString(2);
       								String c=rs.getString(3);
       								String d=rs.getString(4);
       								model.addRow(new Object[]{a,b,c,d});					   
       								table_1.setModel(model);
       							    scrollPane.setViewportView(table_1);
       						 
       					   }
       				  if(x==0)
  				    {
  				    	  JOptionPane.showMessageDialog(null, "Invalid Author Name.");
  				    }
       				 textField_1.setText(Integer.toString(model.getRowCount()));
       				     textField.setText(null);
       				     	func.con.close();
       					   }
       					   	    
       					catch(Exception e4)
       					{
       						e4.printStackTrace();
       						JOptionPane.showMessageDialog(null, "Book Does Not Exist.");
       					}	} 
       																					
       			}
       						
				
				
                       if(comboBox.getSelectedItem().toString()=="Category"){
          					
          					
          					textField.setVisible(true);
          					lblEnter.setVisible(true);
          					if(textField.getText().equals("")==false)
        					{
          					 DefaultTableModel model = new DefaultTableModel(columnNames, 0);
          					
          					
          					try
          					   {
          						
          						func.cc2();
          					    func.stmt=func.con.createStatement();
          					   
          					    ResultSet rs=func.stmt.executeQuery("select *from book where Category='"+ textField.getText().toString()+"' ");
          					   
          					  int x=0;
          				     while(rs.next())
          					   {		x++;	    	 
          						        String a=rs.getString(1);
          								String b=rs.getString(2);
          								String c=rs.getString(3);
          								String d=rs.getString(4);
          								model.addRow(new Object[]{a,b,c,d});					   
          							    table_1.setModel(model);
          						        scrollPane.setViewportView(table_1);
          						 
          					   }
          				   if(x==0)
       				    {
       				    	  JOptionPane.showMessageDialog(null, "Invalid Category.");
       				    }
          				 textField_1.setText(Integer.toString(model.getRowCount()));
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
		frmBookSearch.getContentPane().add(btnGo);
		
		scrollPane = new JScrollPane();
		scrollPane.setVisible(false);
		scrollPane.setBounds(22, 131, 624, 219);
		frmBookSearch.getContentPane().add(scrollPane);
		
		table_1 = new JTable();
		 table_1.setFont(new Font("SansSerif", Font.PLAIN, 12));
		 table_1.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		 table_1.setEnabled(false);
	     //table_1.getColumnModel().getColumn(0).setPreferredWidth(70);
	   //  table_1.getColumnModel().getColumn(1).setPreferredWidth(200);
	   //  table_1.getColumnModel().getColumn(2).setPreferredWidth(90);
	   //  table_1.getColumnModel().getColumn(3).setPreferredWidth(200);
		
		scrollPane.setViewportView(table_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(107, 370, 86, 25);
		frmBookSearch.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblCount = new JLabel("TotaL");
		lblCount.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCount.setBounds(54, 373, 75, 14);
		frmBookSearch.getContentPane().add(lblCount);
		
		lblIssued = new JLabel("■ : ISSUED");
		lblIssued.setBounds(395, 24, 75, 28);
		frmBookSearch.getContentPane().add(lblIssued);
		
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setRequestFocusEnabled(false);
		lblNewLabel.setBounds(0, 0, 669, 401);
		lblNewLabel.setIcon(new ImageIcon(BookSearch.class.getResource("/ldbms/6.jpg")));
		frmBookSearch.getContentPane().add(lblNewLabel);
		
	}
}
