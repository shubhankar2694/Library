package ldbms;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Image;

import javax.swing.SpringLayout;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;

import net.miginfocom.swing.MigLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Color;

import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JPasswordField;
import javax.swing.DropMode;

import java.awt.Cursor;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class LoginForm {

	private JFrame frame;
	private JLabel label;
	private JTextField textField;
	private JPasswordField passwordField;
    static Functions func=new Functions();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			 UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
			 func.main(null);
			
			 
			//UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm window = new LoginForm();
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
	public LoginForm() {
		
		 
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		
		
		
		
		frame = new JFrame();
		
		frame.setBounds(100, 100, 496, 324);
		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
	    
		
				
		
		//title
		frame.setTitle("ACET Library Login");
		
		//non resize
		frame.setResizable(false);
		
		//center positioning
		
		 Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	     frame.setLocation(dim.width/2-480/2, dim.height/2-280/2);
		
		
		//set favIcon
		 frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("3.jpg")));
		 frame.getContentPane().setLayout(null);
		 
		 JLabel lblNewLabel_1 = new JLabel("Username");
		 lblNewLabel_1.setBounds(30, 76, 102, 32);
		 lblNewLabel_1.setForeground(new Color(0, 0, 51));
		 lblNewLabel_1.setFont(new Font("Raavi", Font.PLAIN, 18));
		 frame.getContentPane().add(lblNewLabel_1);
		 
		 JLabel lblPassword = new JLabel("Password");
		 lblPassword.setBounds(31, 119, 88, 29);
		 lblPassword.setForeground(new Color(0, 0, 51));
		 lblPassword.setFont(new Font("Raavi", Font.PLAIN, 18));
		 frame.getContentPane().add(lblPassword);
		 
		 JLabel lblNewLabel_3 = new JLabel();
		 lblNewLabel_3.setForeground(new Color(255, 69, 0));
		 lblNewLabel_3.setFont(new Font("SansSerif", Font.PLAIN, 14));
		 lblNewLabel_3.setBounds(144, 160, 201, 60);
		 frame.getContentPane().add(lblNewLabel_3);
		 
		 
		
		 
		 
		 textField = new JTextField();
		 textField.setBounds(153, 79, 153, 28);
		 frame.getContentPane().add(textField);
		 textField.setColumns(10);
		 
		 
		 passwordField = new JPasswordField();
		
		 
		 passwordField.setBounds(153, 120, 153, 28);
		
		 passwordField.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		//JOptionPane.showMessageDialog(null, "hmm");
		 		
		 		String user,pass,access=null;
		 		boolean sms;
		 		user=textField.getText().toString();
		 		access=textField.getText().toString();
		 		
		 		
		 		pass=passwordField.getText().toString();
		 		sms=func.verifyPassword(user,pass);
		 		
		 		if(sms==true)
		 		{
		 			
		 			
		 			
		 			
		 		
		 			
		 			
		 			
		 		 func.createTempTable(user,pass,access);
		 		 if(access.equals("admin")==true)
		 		 {
		 			 //JOptionPane.showMessageDialog(null, "yo");
		 			 frame.dispose();
		 		     MainForm1.main(null);}
		 		 else
		 		 {
		 			frame.dispose();
			 		 MainForm.main(null);
		 		 }
	 			 
	 			 }
		 		else
		 		{	passwordField.setText(null);
		 		 lblNewLabel_3.setText( "Wrong Username or Password.");
		 		}   
		 			
		 		   
		 		
		 		//algo
		 		
		 		
		 		
		 		
		 		
		 	}
		 });
		 frame.getContentPane().add(passwordField);
		 
		 
		 
		 JButton btnLogin = new JButton("Login");
		 btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		 
		 btnLogin.setBounds(30, 175, 102, 32);
		 btnLogin.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 	
		 		
		 		String user,pass,access=null;
		 		boolean sms;
		 		user=textField.getText().toString();
		 		access=textField.getText().toString();
		 		pass=passwordField.getText().toString();
		 		sms=func.verifyPassword(user,pass);
		 		
		 		if(sms==true)
		 			{
		 			 
		 			func.createTempTable(user,pass,access);
		 			 if(access.equals("admin")==true)
			 		 {
			 			// JOptionPane.showMessageDialog(null, "yo");
			 			 frame.dispose();
			 		     MainForm1.main(null);}
			 		 else
			 		 {
			 			frame.dispose();
				 		 MainForm.main(null);
			 		 }
		 			 
		 			 
		 			}
		 			
		 		else
		 		{
		 			passwordField.setText(null);
		 		 lblNewLabel_3.setText( "Wrong Username or Password.");
		 		}
		 		
		 		
		 	}
		 });
		 btnLogin.setFont(new Font("Raavi", Font.PLAIN, 17));
		 frame.getContentPane().add(btnLogin);
		 
		 JLabel lblNewLabel_2 = new JLabel("");
		 lblNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
		 lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		 lblNewLabel_2.setForeground(new Color(0, 0, 0));
		 lblNewLabel_2.setPreferredSize(new Dimension(102, 102));
		 lblNewLabel_2.setBackground(new Color(192, 192, 192));
		 lblNewLabel_2.setIcon(new ImageIcon(LoginForm.class.getResource("/ldbms/2.png")));
		 lblNewLabel_2.setBounds(382, 6, 102, 108);
		 
		 frame.getContentPane().add(lblNewLabel_2);
		 
		 JLabel lblNewLabel = new JLabel("");
		 lblNewLabel.setBounds(0, 0, 489, 296);
		 lblNewLabel.setForeground(Color.BLACK);
		 //Image img=ImageIcon.getImage(getClass().getResource("1.jpg"));
		 //Image img=new ImageIcon(this.getClass().getResource("1.jpg")).getImage();
		 lblNewLabel.setIcon(new ImageIcon(LoginForm.class.getResource("/ldbms/1.jpg")));
		 //lblNewLabel.setIcon(new ImageIcon("D:\\ldbms\\images\\1.jpg"));
		 frame.getContentPane().add(lblNewLabel);
		 
		 
		 
		 
		
	}
}
