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

public class ChangePassword {

	private JDialog frmAddCategory;
	
    Functions func=new Functions();
    Statement stmt;
    Connection con;
    private JLabel lblName;
    private JPasswordField passwordField;
    private JPasswordField passwordField_1;
    private JPasswordField passwordField_2;
    int c=0;
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
				try {UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					ChangePassword window = new ChangePassword();
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
	public ChangePassword() {
		
		
		
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
		frmAddCategory.setTitle("Change Password");
		frmAddCategory.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		 frmAddCategory.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("4.gif")));
		frmAddCategory.getContentPane().setLayout(null);
		
		
		JLabel lblS = new JLabel("");
		lblS.setForeground(new Color(50, 205, 50));
		lblS.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblS.setBounds(267, 193, 159, 44);
		frmAddCategory.getContentPane().add(lblS);
		
		JLabel label_2 = new JLabel("");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(342, 32, 159, 44);
		frmAddCategory.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(342, 82, 183, 44);
		frmAddCategory.getContentPane().add(label_3);
		
		
		
		
		
		
		
		
		JButton btnChange = new JButton("Change");
		btnChange.setEnabled(false);
		btnChange.setSelected(true);
		btnChange.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				
			
				
				
			String p1,p2,p3,user=null;	
			p1=passwordField.getText().toString();
			p2=passwordField_1.getText().toString();
			boolean ch=true;
			if(p1.equals("")==true)
			{
				ch=false;
				JOptionPane.showMessageDialog(null, "Empty Field.");
			}
			p3=passwordField_2.getText().toString();
			
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
				}
				else
				{
					label_2.setText(null);
					lblS.setText("");
				}
				if(p2.equals(p3)==false)
				{
					label_3.setText("Password Not Matched");
					lblS.setText("");
				}
				else
				{
					label_3.setText(null);
				}
				if(sms==true && p2.equals(p3)==true && ch==true)
				{
					
					func.updateTemp(user, p3);
					func.updatePassword(user, p3);
					label_2.setText(null);
					label_3.setText(null);
					lblS.setText("Password Changed.");
				}
			        
				
			}
		});
		
		
		
		
		
		btnChange.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnChange.setBounds(148, 201, 86, 25);
		frmAddCategory.getContentPane().add(btnChange);
		
		lblName = new JLabel("Current Password");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(10, 32, 159, 44);
		frmAddCategory.getContentPane().add(lblName);
		
		JLabel lblPassword = new JLabel("New Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(10, 82, 118, 44);
		frmAddCategory.getContentPane().add(lblPassword);
		
		JLabel lblEnterAgain = new JLabel("Enter Again");
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
						btnChange.setEnabled(true);
					}
			}
		});
		
		passwordField.setBounds(148, 44, 183, 25);
		frmAddCategory.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
			
					if(passwordField_1.getText().isEmpty()==true)
					{}
					else
					c++;
					
					if(c==3)
					{
						btnChange.setEnabled(true);
					}
			}
		});
		passwordField_1.setBounds(148, 94, 183, 25);
		frmAddCategory.getContentPane().add(passwordField_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.addKeyListener(new KeyAdapter() {
			
			public void keyReleased(KeyEvent e) {
				

				if(passwordField_2.getText().isEmpty()==true)
				{}
				else
				c++;
				
				if(c==3)
				{
					btnChange.setEnabled(true);
				}
			}
		});
		passwordField_2.setBounds(148, 146, 183, 25);
		frmAddCategory.getContentPane().add(passwordField_2);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ChangePassword.class.getResource("/ldbms/2.png")));
		label.setBounds(0, 201, 102, 102);
		frmAddCategory.getContentPane().add(label);
		
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ChangePassword.class.getResource("/ldbms/6.jpg")));
		lblNewLabel.setBounds(-11, 0, 536, 314);
		frmAddCategory.getContentPane().add(lblNewLabel);
		
	}
}
