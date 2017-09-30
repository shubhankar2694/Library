package ldbms;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.awt.EventQueue;
import java.awt.Image;
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

public class AddBook {

	private JDialog frame;
	private JTextField textField;
	private JTextField textField_1;
	JComboBox comboBox ;
	/**
	 * @wbp.nonvisual location=442,309
	 */
	
	private JTextField textField_2;
	
    Functions func=new Functions();
    Statement stmt;
    Connection con;
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
					AddBook window = new AddBook();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	public void refreshCategory()
	{
        comboBox.removeAllItems();
		String sms;
		
		ArrayList list=new ArrayList();
		list=func.searchCategory();
		Iterator it=list.iterator();
		while(it.hasNext())
		{
			DataMembers b=(DataMembers)it.next();
			sms=b.getCategory();
			comboBox.addItem(sms);
			
		}
	}
	/**
	 * Create the application.
	 */
	public AddBook() {
		
		
		
		initialize();
	}

	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
      
		
		
		
		
		
		frame = new JDialog();
		frame.setModal(true);
		frame.setBounds(100, 100, 675, 429);
		frame.setResizable(false);
		frame.setTitle("Add Book");
		frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("4.gif")));
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(22, 59, 56, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblName.setBounds(22, 117, 69, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblContactNo = new JLabel("Author");
		lblContactNo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContactNo.setBounds(22, 176, 96, 14);
		frame.getContentPane().add(lblContactNo);
		
		JLabel lblPermanentAddress = new JLabel("Category");
		lblPermanentAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPermanentAddress.setBounds(22, 240, 86, 20);
		frame.getContentPane().add(lblPermanentAddress);
		
		
		int x=func.generateBokid();
		
		String id="BK_"+Integer.toString(x); 
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			AddCategory.main(null);
		
		       // frame.
				//comboBox.removeAllItems();
				//refreshCategory();
			    	
			 
				
				
				
				
			}
		});
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				refreshCategory();
			}
		});
		btnRefresh.setBounds(22, 271, 96, 23);
		frame.getContentPane().add(btnRefresh);
		
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdd.setBounds(329, 238, 86, 25);
		frame.getContentPane().add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DeleteCategory.main(null);
				
			 
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDelete.setBounds(425, 238, 86, 25);
		frame.getContentPane().add(btnDelete);
	
		
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(127, 59, 86, 32);
		textField.setText(id);                                   //auto generated id
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField(null);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setBounds(127, 109, 277, 32);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField(null);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_2.setColumns(10);
		textField_2.setBounds(128, 168, 210, 32);
		frame.getContentPane().add(textField_2);
		
		comboBox = new JComboBox();
		comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBox.setBounds(127, 242, 176, 20);
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
		

		refreshCategory();
		
		
		frame.getContentPane().add(comboBox);
		
		JButton btnSave = new JButton("Save");
		btnSave.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSave.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				int flag;
				String id,name,author,category;
			   
				
				id=textField.getText();
				name=textField_1.getText().toString();
				author=textField_2.getText();
				category=comboBox.getSelectedItem().toString();
	
				
						        
				if((name.isEmpty()==true)||(author.isEmpty()==true))
			    {
					
					    JOptionPane.showMessageDialog(null,"All Fields Must Be Filled");
					
					flag=0;
			    }
                
				else
					flag=1;
								      
								
				if(flag==1)
				{
                func.addBook(id,name,author,category);
				JOptionPane.showMessageDialog(null, "Data Saved Successfully.");
				
				int x=func.generateBokid();
			    id="BK_"+Integer.toString(x);
			    textField.setText(id);
				textField_1.setText(null);
				textField_2.setText(null);
				
				}
				
				
				
				
				
				
				
				
				
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSave.setBounds(127, 329, 96, 33);
		frame.getContentPane().add(btnSave);
		
		
		
		JLabel lblNewLabel = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("1.jpg")).getImage();
		
		//lblNewLabel.setIcon(new ImageIcon("D:\\ldbms\\images\\6.jpg"));
		lblNewLabel.setIcon(new ImageIcon(AddBook.class.getResource("/ldbms/6.jpg")));
		lblNewLabel.setBounds(0, 0, 669, 401);
		frame.getContentPane().add(lblNewLabel);
		
	}
}
