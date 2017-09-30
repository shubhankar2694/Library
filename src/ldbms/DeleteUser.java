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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPasswordField;

import java.awt.Color;

import javax.swing.UIManager;

public class DeleteUser {

	private JDialog frmAddCategory;
	
    Functions func=new Functions();
    Statement stmt;
    Connection con;
    private JLabel lblName;
    private JPasswordField passwordField;
    int c=0;
    JComboBox comboBox ;
    JLabel label_1;
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
				try {
					DeleteUser window = new DeleteUser();
					window.frmAddCategory.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

}

	/**
	 * Create the application.
	 */
	public DeleteUser() {
		
	initialize();
	refreshUser();
	}

	public void  refreshUser()
	{
		String user2;
		ArrayList list1=new ArrayList();
		list1=func.getUser();
		Iterator it1=list1.iterator();
		while(it1.hasNext())
		{
			DataMembers b=(DataMembers)it1.next();
			user2=b.getUser();
			comboBox.addItem(user2);
		}
	}
	
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmAddCategory = new JDialog();
		frmAddCategory.setModal(true);
		frmAddCategory.setBounds(100, 100, 521, 342);
		frmAddCategory.setResizable(false);
		frmAddCategory.setTitle("Delete User");
		frmAddCategory.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		 frmAddCategory.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("4.gif")));
		frmAddCategory.getContentPane().setLayout(null);
		
		
		JLabel lblS = new JLabel("");
		lblS.setForeground(new Color(50, 205, 50));
		lblS.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblS.setBounds(263, 162, 159, 44);
		frmAddCategory.getContentPane().add(lblS);
		

		
			
		
		
		
		
		
		
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setEnabled(false);
		btnDelete.setSelected(true);
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				
				
				
				
				
				
				String p1,user1=null;
				
				p1=passwordField.getText().toString();
				
				ArrayList list=new ArrayList();
				list=func.readTemp();
				Iterator it=list.iterator();
				while(it.hasNext())
				{
					DataMembers b=(DataMembers)it.next();
	    			user1=b.getUser();
				}
				
				
				
				
				boolean sms=func.verifyPassword(user1, p1);
				if(sms==false)
				{
				  label_1.setText("Wrong Password.");
				  passwordField.setText(null);
				}
				else
				{
					label_1.setText(null);
					lblS.setText("");
				}
				
				

			
			 
				
				
				
				
			
					
				if(sms==true )
				{
					int x=JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?","Delete",JOptionPane.YES_NO_OPTION);
					if (x==0)
					{
					String user=comboBox.getSelectedItem().toString();
					
					func.deleteUser(user);
					
					
					passwordField.setText(null);
					
					label_1.setText(null);
			
					lblS.setText("User Deleted.");
					btnDelete.setEnabled(false);
					c=0;
					}
				}
			        
					
			}
		});
		 
		  label_1 = new JLabel("");
		 label_1.setForeground(Color.RED);
		 label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 label_1.setBounds(341, 32, 159, 44);
		 frmAddCategory.getContentPane().add(label_1);
		
		 comboBox = new JComboBox();
		comboBox.setBounds(148, 103, 141, 25);
		frmAddCategory.getContentPane().add(comboBox);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBox.removeAllItems();
				refreshUser();
			}
		});
		btnRefresh.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRefresh.setSelected(true);
		btnRefresh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRefresh.setEnabled(false);
		btnRefresh.setBounds(322, 104, 86, 25);
		frmAddCategory.getContentPane().add(btnRefresh);
		
		
		
		
		
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDelete.setBounds(148, 168, 86, 25);
		frmAddCategory.getContentPane().add(btnDelete);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\ldbms\\images\\2.png"));
		label.setBounds(0, 201, 102, 102);
		frmAddCategory.getContentPane().add(label);
		
		lblName = new JLabel("Current Password");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(10, 32, 159, 44);
		frmAddCategory.getContentPane().add(lblName);
		
		JLabel lblPassword = new JLabel("Select User");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(10, 91, 118, 44);
		frmAddCategory.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
                  String p1,user1=null;
				
				p1=passwordField.getText().toString();
				
				ArrayList list=new ArrayList();
				list=func.readTemp();
				Iterator it=list.iterator();
				while(it.hasNext())
				{
					DataMembers b=(DataMembers)it.next();
	    			user1=b.getUser();
				}
				
				
				
				
				boolean sms=func.verifyPassword(user1, p1);
				if(sms==false)
				{
				  label_1.setText("Wrong Password.");
				  passwordField.setText(null);
				}
				else
				{
					label_1.setText(null);
					lblS.setText("");
				}
				
				
				
				
				
				
			}
		});
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				

				if(passwordField.getText().isEmpty()==true)
				{}
				else
				c++;
				
				
			
					if(c==1)
					{
						btnDelete.setEnabled(true);
						btnRefresh.setEnabled(true);
					}
			}
		});
		
		passwordField.setBounds(148, 44, 183, 25);
		frmAddCategory.getContentPane().add(passwordField);
		
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(DeleteUser.class.getResource("/ldbms/6.jpg")));
		lblNewLabel.setBounds(-21, 11, 536, 314);
		frmAddCategory.getContentPane().add(lblNewLabel);
		
	}
}
