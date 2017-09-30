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

public class AddCategory {

	private JDialog frmAddCategory;
	private JTextField textField;
	
    Functions func=new Functions();
    Statement stmt;
    Connection con;
    private JLabel lblName;
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
					AddCategory window = new AddCategory();
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
	public AddCategory() {
		
		
		
		initialize();
	}

	
	
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmAddCategory = new JDialog();
		frmAddCategory.setModal(true);
		frmAddCategory.setBounds(100, 100, 439, 257);
		frmAddCategory.setResizable(false);
		frmAddCategory.setTitle("Add Category");
		frmAddCategory.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		 frmAddCategory.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("4.gif")));
		frmAddCategory.getContentPane().setLayout(null);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdd.setEnabled(false);
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				String sms=textField.getText().toString();
				
				 
					int x=func.addCategory(sms);
					if(x==1)
					{
						JOptionPane.showMessageDialog(null, "Category Added.");
						textField.setText(null);
           
						
						
					}
					
				
					else
					{  
						textField.setText(null);
						
					}
			        
				
			}
		});
		
		
		
		
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdd.setBounds(160, 106, 86, 25);
		frmAddCategory.getContentPane().add(btnAdd);
		
		lblName = new JLabel("Category Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblName.setBounds(22, 25, 118, 44);
		frmAddCategory.getContentPane().add(lblName);
		
		
		
		textField = new JTextField(null);
		
		textField.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				int x=func.addCategory(textField.getText().toString());
				if(x!=0)
				{
					JOptionPane.showMessageDialog(null, "Category Added.");
					textField.setText(null);
				}
				else
				{
					textField.setText(null);
					
				}
				
				
				
			}
		});
		textField.addKeyListener(new KeyAdapter() {
			
			public void keyReleased(KeyEvent arg0) {
				if(textField.getText().isEmpty()==true)
					btnAdd.setEnabled(false);
				else
					btnAdd.setEnabled(true);
			}
		});
		
		
		
		
		
		
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(159, 32, 176, 32);
		frmAddCategory.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AddCategory.class.getResource("/ldbms/6.jpg")));
		lblNewLabel.setBounds(0, 0, 433, 229);
		frmAddCategory.getContentPane().add(lblNewLabel);
		
	}
}
