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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPasswordField;

import java.awt.Color;

public class CreateUser {

	private JDialog frmAddCategory;
	
    Functions func=new Functions();
    Statement stmt;
    Connection con;
    private JLabel lblName;
    private JPasswordField passwordField;
    private JPasswordField passwordField_1;
    int c=0;
    private JTextField textField;
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
					CreateUser window = new CreateUser();
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
	public CreateUser() {
		
	initialize();
	}

	
	
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmAddCategory = new JDialog();
		frmAddCategory.setModal(true);
		frmAddCategory.setBounds(100, 100, 521, 342);
		frmAddCategory.setResizable(false);
		frmAddCategory.setTitle("Create User");
		frmAddCategory.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		 frmAddCategory.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("4.gif")));
		frmAddCategory.getContentPane().setLayout(null);
		
		
		JLabel lblS = new JLabel("");
		lblS.setForeground(new Color(50, 205, 50));
		lblS.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblS.setBounds(266, 191, 159, 44);
		frmAddCategory.getContentPane().add(lblS);
		
		JLabel label_2 = new JLabel("");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(342, 32, 159, 44);
		frmAddCategory.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(342, 89, 183, 44);
		frmAddCategory.getContentPane().add(label_3);
		
		
		
		
		
		
		
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setEnabled(false);
		btnCreate.setSelected(true);
		btnCreate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				
			
				
				
			String p1,p2,p3,user=null;	
			p1=passwordField.getText().toString();
			p2=textField.getText().toString();
			p3=passwordField_1.getText().toString();
			
			ArrayList list=new ArrayList();
			list=func.readTemp();
			Iterator it=list.iterator();
			while(it.hasNext())
			{
				DataMembers b=(DataMembers)it.next();
    			user=b.getUser();
			}
				   
			 
				boolean sms=func.verifyPassword(user, p1);
				if(sms==false)
				{
				  label_2.setText("Wrong Password.");
				  passwordField.setText(null);
				}
				else
				{
					label_2.setText(null);
					lblS.setText("");
				}
				
				boolean sms1=func.checkUser(p2);
				if(sms1==true)
				{
					label_3.setText("User Already exists.");
					textField.setText(null);
				}
				else
				{
					label_3.setText(null);
					lblS.setText("");
				}
				
				
				
				if(sms==true && sms1==false )
				{
					
					String access="normal";
					func.createPassword(p2, p3,access);
					passwordField.setText(null);
					passwordField_1.setText(null);
					textField.setText(null);
					label_2.setText(null);
					label_3.setText(null);
					lblS.setText("New User Created.");
					btnCreate.setEnabled(false);
					c=0;
				}
			        
				
			}
		});
		
		passwordField_1 = new JPasswordField();
		passwordField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String p1,p2,p3,user=null;	
				p1=passwordField.getText().toString();
				p2=textField.getText().toString();
				p3=passwordField_1.getText().toString();
				
				ArrayList list=new ArrayList();
				list=func.readTemp();
				Iterator it=list.iterator();
				while(it.hasNext())
				{
					DataMembers b=(DataMembers)it.next();
	    			user=b.getUser();
				}
					
				 
					boolean sms=func.verifyPassword(user, p1);
					if(sms==false)
					{
					  label_2.setText("Wrong Password.");
					  passwordField.setText(null);
					}
					else
					{
						label_2.setText(null);
						lblS.setText("");
					}
					
					boolean sms1=func.checkUser(p2);
					if(sms1==true)
					{
						label_3.setText("User Already exists.");
						textField.setText(null);
					}
					else
					{
						label_3.setText(null);
						lblS.setText("");
					}
					
					
					
					if(sms==true && sms1==false )
					{
						
						String access="normal";
						func.createPassword(p2, p3,access);
						passwordField.setText(null);
						passwordField_1.setText(null);
						textField.setText(null);
						label_2.setText(null);
						label_3.setText(null);
						lblS.setText("New User Created.");
					    btnCreate.setEnabled(false);
					    c=0;
					}
				        
				
				
				
				
			}
		});
		passwordField_1.addKeyListener(new KeyAdapter() {
			
			public void keyReleased(KeyEvent e) {
				

				if(passwordField_1.getText().isEmpty()==true)
				{}
				else
				c++;
				
				if(c==3)
				{
					btnCreate.setEnabled(true);
				}
			}
		});
		passwordField_1.setBounds(148, 146, 183, 25);
		frmAddCategory.getContentPane().add(passwordField_1);
		
		
		
		
		
		btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCreate.setBounds(148, 201, 86, 25);
		frmAddCategory.getContentPane().add(btnCreate);
		
		lblName = new JLabel("Current Password");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(10, 32, 159, 44);
		frmAddCategory.getContentPane().add(lblName);
		
		JLabel lblPassword = new JLabel("New User");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(10, 89, 118, 44);
		frmAddCategory.getContentPane().add(lblPassword);
		
		JLabel lblEnterAgain = new JLabel("Password");
		lblEnterAgain.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEnterAgain.setBounds(10, 137, 118, 44);
		frmAddCategory.getContentPane().add(lblEnterAgain);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				

				if(passwordField.getText().isEmpty()==true)
				{}
				else
				c++;
				
				
			
					if(c==3)
					{
						btnCreate.setEnabled(true);
					}
			}
		});
		
		passwordField.setBounds(148, 44, 183, 25);
		frmAddCategory.getContentPane().add(passwordField);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				
				if(textField.getText().isEmpty()==true)
				{}
				else
				c++;
				
				if(c==3)
				{
					btnCreate.setEnabled(true);
				}
				
				
				
			}
		});
		textField.setBounds(148, 101, 184, 25);
		frmAddCategory.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(CreateUser.class.getResource("/ldbms/2.png")));
		label.setBounds(0, 201, 102, 102);
		frmAddCategory.getContentPane().add(label);
		
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CreateUser.class.getResource("/ldbms/6.jpg")));
		lblNewLabel.setBounds(-11, 0, 536, 314);
		frmAddCategory.getContentPane().add(lblNewLabel);
		
	}
}
