package ldbms;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.DefaultListModel;
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
import java.text.SimpleDateFormat;
import java.awt.Cursor;
import java.awt.Color;

import javax.swing.JList;

public class AddStudent {

	private JDialog frame;
	private JTextField textField_1;
	JList list;
	JComboBox comboBox;
	DefaultListModel model;
	/**
	 * @wbp.nonvisual location=442,309
	 */
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTextField textField_4;
	JComboBox comboBox_1;
    Functions func=new Functions();
    Statement stmt;
    Connection con;
    private JTextField textField_5;
    public static JTextField textField_2;
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
					AddStudent window = new AddStudent();
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
	public AddStudent() {
		
		
		
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
		frame.setTitle("Add Borrower");
		frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		 frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("4.gif")));
		frame.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblName.setBounds(22, 117, 69, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblBranch = new JLabel("Course");
		lblBranch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBranch.setBounds(22, 166, 69, 14);
		frame.getContentPane().add(lblBranch);
		
		JLabel lblContactNo = new JLabel("Mobile No.");
		lblContactNo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContactNo.setBounds(22, 221, 96, 14);
		frame.getContentPane().add(lblContactNo);
		
		JLabel lblPermanentAddress = new JLabel("Address");
		lblPermanentAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPermanentAddress.setBounds(22, 282, 86, 14);
		frame.getContentPane().add(lblPermanentAddress);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGender.setBounds(394, 18, 56, 14);
		frame.getContentPane().add(lblGender);
		
		JLabel label = new JLabel("Branch");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(236, 166, 69, 14);
		frame.getContentPane().add(label);
		
		JLabel lblmmyyyy = new JLabel("(YYYY-MM-DD)");
		lblmmyyyy.setForeground(Color.BLACK);
		lblmmyyyy.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblmmyyyy.setBounds(236, 353, 96, 24);
		frame.getContentPane().add(lblmmyyyy);
		
		JLabel lblExpiryDate = new JLabel("ID_Expiry Date");
		lblExpiryDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblExpiryDate.setBounds(6, 352, 121, 24);
		frame.getContentPane().add(lblExpiryDate);
		
		textField_5 = new JTextField((String) null);
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_5.setColumns(10);
		textField_5.setBounds(127, 349, 96, 32);
		frame.getContentPane().add(textField_5);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		buttonGroup_1.add(rdbtnFemale);
		rdbtnFemale.setBounds(486, 48, 109, 23);
		frame.getContentPane().add(rdbtnFemale);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		buttonGroup_1.add(rdbtnMale);
		rdbtnMale.setBounds(486, 18, 109, 23);
		frame.getContentPane().add(rdbtnMale);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(127, 278, 161, 48);
		frame.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setText(null);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		scrollPane.setViewportView(textArea);
		
		
		
		
		 String cards=null;
		 int mani=0;
			try
			   {
				func.cc2();
			    func.stmt=func.con.createStatement();
			    ResultSet r=func.stmt.executeQuery("select *from policy");
		     	while(r.next())
		     	{
		     		
		     	    
		     	 cards =r.getString("x");
		     	   mani=Integer.parseInt(cards);
		     	}
		     	//JOptionPane.showMessageDialog(null,cards);
		     	func.con.close();
			    }
			 
			
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		
		
		   	 int x=mani;  
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//JOptionPane.showMessageDialog(null,cards);
				
		textField_1 = new JTextField(null);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setBounds(127, 109, 205, 32);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_4 = new JTextField(null);
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_4.setColumns(10);
		textField_4.setBounds(128, 213, 178, 32);
		frame.getContentPane().add(textField_4);
		
		JButton btnSave = new JButton("Save");
		btnSave.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSave.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				
    		   
				
				
				
				int flag;
				String name,course,branch,gender,address,cno,date,rno;
			    gender="";	
				boolean sms1=true;
				
				rno=textField_2.getText().toString();
				name=textField_1.getText().toString();
				
				char ch []={'0','1','2','3','4','5','6','7','8','9'};
				
				char [] a=name.toCharArray();
				for(char c: a)
				{
					for(char k:ch)
					{
						if(c==k)
						{
							sms1=false;
						}
					}
				}
				
				course=comboBox.getSelectedItem().toString();
				branch=comboBox_1.getSelectedItem().toString();
				cno=textField_4.getText();
				address=textArea.getText();
				date=textField_5.getText();
				long g=0,f=0;
				
				boolean sms=func.dateValid2(date);
				
				if(cno.length()!=10)
					if(cno.isEmpty()==true)
					  f=2;
					else
					  f=1;
				
				try
				{
			          g=Long.parseLong(cno);
			          
				}
				catch(Exception e1)
				{
					
					if(cno.isEmpty()==true)
						g=2;
					else
						g=1;
					//JOptionPane.showMessageDialog(null, g);
					
					
				}
				
				if(rdbtnFemale.isSelected())
				{
					gender=rdbtnFemale.getText();
				}
				
				else if(rdbtnMale.isSelected())
				{
					gender=rdbtnMale.getText();
				}
				

				//  if(cno.isEmpty()==true)
				 // {
				//	  g=2;
				  
				//	  f=2;
				//  }
		        
				if((rno.isEmpty()==true)||(sms1==false)||(g==1)||(f==1)||(name.isEmpty()==true)||(cno.isEmpty()==true)||(date.isEmpty()==true)||(address.isEmpty()==true)||(gender.isEmpty()==true))
			    {
					if(g==1||f==1)
						{
						JOptionPane.showMessageDialog(null, "Invalid Contact No.");
						textField_5.setText(null);
						}
					else if(sms==false)
					{
						JOptionPane.showMessageDialog(null, "Invalid Date/Fields Empty.");
						textField_5.setText(null);
					}
					else if(sms1==false)
					{
						JOptionPane.showMessageDialog(null, "Invalid Name.");
					textField_1.setText(null);
					}
					else 
					    JOptionPane.showMessageDialog(null,"All Fields Must Be Filled");
					
					flag=0;
			    }
                
				else
					flag=1;
				
				
				
				//JOptionPane.showMessageDialog(null, x);
				
		       // JOptionPane.showMessageDialog(null,id+name+course+ branch+cno+address+gender);
				
				boolean sms3=true;			
				
				if(flag==1)
				{
					
					
					
				for(int i=0;i<x;i++)	
				{
					String id=model.getElementAt(i).toString();
					sms3=func.addStudent(id,rno,name,course,branch,cno,address,gender,date);
				}
					
                
                if(sms3==true){
				JOptionPane.showMessageDialog(null, "Data Saved Successfully.");
				
				
			    
				textField_1.setText(null);
				textField_2.setText(null);
				textField_4.setText(null);
				textField_5.setText(null);
				textArea.setText(null);
				model.clear();
				buttonGroup_1.clearSelection();
                }
                else
                {
                	JOptionPane.showMessageDialog(null, "Invalid Date");
        		    textField_5.setText(null);
                }
				}
				
				
				
				
				
				
				
				
				
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSave.setBounds(554, 348, 96, 33);
		frame.getContentPane().add(btnSave);
		
		String[] sms={"B.Tech.","M.Tech.","BCA","MCA","B.Sc.","HMT","MBA"};
		String[] sms1={"","CSE","ECE","ME","CIVIL","CE","IT","EE","EEE","Agriculture","Maths Hons.","Physics Hons","Chemistry Hons"};
		 
		 JLabel lblCollegeRoll = new JLabel(" Roll No.");
		 lblCollegeRoll.setFont(new Font("Tahoma", Font.PLAIN, 16));
		 lblCollegeRoll.setBounds(18, 15, 86, 22);
		 frame.getContentPane().add(lblCollegeRoll);
		 
		 textField_2 = new JTextField();
		 textField_2.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		
                        int x=0;
                        SimpleDateFormat simpleDateFormat1=new SimpleDateFormat("yyyy-MM-dd");
            		    // date=c1.getTime();
            		    
            		     Date date2=new Date();
            		    
            		 	Calendar c1=new GregorianCalendar();
            		    c1.add(Calendar.YEAR,4);
            		    date2=c1.getTime();
            		    
            		    Date date3=new Date();
            		    Calendar c2=new GregorianCalendar();
            		    date3=c2.getTime();
            		    
            		    String current_date=simpleDateFormat1.format(date3);
            			
            		     
            		    String expiry_date=simpleDateFormat1.format(date2);
            			
            		    
            		    
            		    long diff6=date2.getTime()-date3.getTime();
            		    
            		    
            		    
        				
        				
        				
        				
        				
				
				//JOptionPane.showMessageDialog(null,textField_2.getText());
				
				if(textField_2.getText().toString().equals("")==true)
				{
					x++;
					JOptionPane.showMessageDialog(null, "Empty Field.");
					model.removeAllElements();
				}
				
				
				
				if(x==0){
				
				boolean check=true;
				
				textField_5.setText(expiry_date);
				try
				   {
					func.cc2();
				    func.stmt=func.con.createStatement();
				    ResultSet r=func.stmt.executeQuery("select * from borrower where CRoll_No='"+textField_2.getText().toString()+"'");
			        check=r.next();
			     	
			     	func.con.close();
				    }
				   	    
				
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
			
			
				
				
				
				
				
				if(check==true)
				{
					JOptionPane.showMessageDialog(null,"Roll No. already exists.");
					textField_2.setText(null);
				}
				
				else{
				 String cards=null;
					try
					   {
						func.cc2();
					    func.stmt=func.con.createStatement();
					    ResultSet r=func.stmt.executeQuery("select *from policy");
				     	while(r.next())
				     	{
				     		
				     	    
				     	 cards =r.getString("x");
				     	   
				     	}
				     	//JOptionPane.showMessageDialog(null,cards);
				     	func.con.close();
					    }
					   	    
					
					catch(Exception e)
					{
						System.out.println(e.getMessage());
					}
				
				
				int x1=func.generateBorid();
				String id[]=new String[100];
				
				int mani=Integer.parseInt(cards);
				for(int i=0;i<Integer.parseInt(cards);i++)
				{
				id[i]="CL_"+Integer.toString(x1); 
				//JOptionPane.showMessageDialog(null,id[i]);
				x1++;
				}
				
				model.removeAllElements();
				
				for (int i = 0; i < mani; i++) 
		            model.addElement(id[i]);
				
				
				}
				
		
				}
	
		 	}
		 });
		 textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 textField_2.setColumns(10);
		 textField_2.setBounds(129, 13, 86, 32);
		 frame.getContentPane().add(textField_2);
		 comboBox = new JComboBox(sms);
		comboBox.setBounds(127, 161, 96, 26);
		frame.getContentPane().add(comboBox);
		
	    comboBox_1 = new JComboBox(sms1);
		comboBox_1.setBounds(303, 161, 161, 26);
		frame.getContentPane().add(comboBox_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(299, 12, 69, 80);
		frame.getContentPane().add(scrollPane_1);
		
		 model = new DefaultListModel();
		list = new JList(model);
		scrollPane_1.setViewportView(list);
		
		JLabel lblIds = new JLabel("IDs");
		lblIds.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIds.setBounds(253, 13, 86, 22);
		frame.getContentPane().add(lblIds);
		
		JButton btnGo = new JButton("Go");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int x=0;
				
				//JOptionPane.showMessageDialog(null,textField_2.getText());
				
				if(textField_2.getText().toString().equals("")==true)
				{
					x++;
					JOptionPane.showMessageDialog(null, "Empty Field.");
					model.removeAllElements();
				}
				
				
				
				if(x==0){
				
				boolean check=true;
				
				
				try
				   {
					func.cc2();
				    func.stmt=func.con.createStatement();
				    ResultSet r=func.stmt.executeQuery("select * from borrower where CRoll_No='"+textField_2.getText().toString()+"'");
			        check=r.next();
			     	
			     	func.con.close();
				    }
				   	    
				
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
			
			
				
				
				
				
				
				if(check==true)
				{
					JOptionPane.showMessageDialog(null,"Roll No. already exists.");
					textField_2.setText(null);
				}
				
				else{
				 String cards=null;
					try
					   {
						func.cc2();
					    func.stmt=func.con.createStatement();
					    ResultSet r=func.stmt.executeQuery("select *from policy");
				     	while(r.next())
				     	{
				     		
				     	    
				     	 cards =r.getString("x");
				     	   
				     	}
				     	//JOptionPane.showMessageDialog(null,cards);
				     	func.con.close();
					    }
					   	    
					
					catch(Exception e)
					{
						System.out.println(e.getMessage());
					}
				
				
				int x1=func.generateBorid();
				String id[]=new String[100];
				
				int mani=Integer.parseInt(cards);
				for(int i=0;i<Integer.parseInt(cards);i++)
				{
				id[i]="CL_"+Integer.toString(x1); 
				//JOptionPane.showMessageDialog(null,id[i]);
				x1++;
				}
				
				model.removeAllElements();
				
				for (int i = 0; i < mani; i++) 
		            model.addElement(id[i]);
				
				
				}
				
		
				}
			}
		});
		btnGo.setBounds(130, 57, 56, 28);
		frame.getContentPane().add(btnGo);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AddStudent.class.getResource("/ldbms/6.jpg")));
		lblNewLabel.setBounds(0, 0, 669, 401);
		frame.getContentPane().add(lblNewLabel);
		
	}
}
