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

public class DeleteExpired {

	private JDialog frmDeleteExpired;
	
    Functions func=new Functions();
    Statement stmt;
    Connection con;
    JButton btnGo;
    private JTable table_1;
    private JScrollPane scrollPane;
    private JButton btnDelete;
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
					DeleteExpired window = new DeleteExpired();
					window.frmDeleteExpired.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	
	/**
	 * Create the application.
	 */
	public DeleteExpired() {
		
		
		
		initialize();
	}

	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
         
		
		
		
		frmDeleteExpired = new JDialog();
		frmDeleteExpired.setModal(true);
		frmDeleteExpired.setBounds(100, 100, 769, 429);
		frmDeleteExpired.setResizable(false);
		frmDeleteExpired.setTitle("Delete Expired IDs");
		frmDeleteExpired.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		 frmDeleteExpired.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("4.gif")));
		frmDeleteExpired.getContentPane().setLayout(null);
		
		JLabel lblPermanentAddress = new JLabel("Display All");
		lblPermanentAddress.setBounds(22, 26, 86, 20);
		lblPermanentAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmDeleteExpired.getContentPane().add(lblPermanentAddress);
		
		
		
		String[] columnNames = {"Borrower_ID","Roll No","Name","Course","Branch","Contact No.","Address","Gender","ID Expiry Date"};
		
		
		 btnGo = new JButton("Go");
		 btnGo.setFont(new Font("SansSerif", Font.PLAIN, 14));
		 btnGo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		 btnGo.setSelected(true);
		 btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				scrollPane.setVisible(true);
				
				
				 btnDelete.setEnabled(true);
				 DefaultTableModel model = new DefaultTableModel(columnNames, 0);
				
				try
				   {
					func.cc2();
				   func.stmt=func.con.createStatement();
				   
				    ResultSet rs=func.stmt.executeQuery("select *from borrower where Expiry_date <= CURDATE() ");
				    
				    
			     while(rs.next())
				   {			    	 
					        String a=rs.getString(1);
							String b=rs.getString(2);
							
							boolean sms=func.alreadyIssued1(b);
							if(sms==true)
							{
								JOptionPane.showMessageDialog(null, "Books issued on this Roll No.Go to Book -> Search Issued books");
								break;
							}
							
							
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
																									
		});
		btnGo.setBounds(120, 26, 58, 26);
		frmDeleteExpired.getContentPane().add(btnGo);
		
		scrollPane = new JScrollPane();
		scrollPane.setVisible(false);
		scrollPane.setBounds(0, 137, 763, 219);
		frmDeleteExpired.getContentPane().add(scrollPane);
		
		table_1 = new JTable();
		 table_1.setFont(new Font("SansSerif", Font.PLAIN, 12));
		 table_1.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		 table_1.setEnabled(false);
	     
		scrollPane.setViewportView(table_1);
		
		btnDelete = new JButton("Delete");
		btnDelete.setEnabled(false);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					MainForm1.lblNewLabel_3.setText(null);
					MainForm.lblNewLabel_3.setText(null);
					
					btnDelete.setEnabled(false);
					btnGo.setEnabled(false);
					func.cc2();
					
					func.stmt=func.con.createStatement();
					func.stmt.executeUpdate("delete from borrower where  Expiry_date <= CURDATE()");
					JOptionPane.showMessageDialog(null, "Data deleted.");
					func.con.close();
					scrollPane.setVisible(false);
					//
				}
				catch(Exception e1)
				{
					
					System.out.println(e1.getMessage());
					
				}
				
				
			}
		});
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnDelete.setSelected(true);
		btnDelete.setBounds(120, 64, 86, 28);
		frmDeleteExpired.getContentPane().add(btnDelete);
		
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setRequestFocusEnabled(false);
		lblNewLabel.setBounds(0, 0, 763, 401);
		lblNewLabel.setIcon(new ImageIcon(DeleteExpired.class.getResource("/ldbms/7.jpg")));
		frmDeleteExpired.getContentPane().add(lblNewLabel);
		
	}
}
