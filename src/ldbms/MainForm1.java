package ldbms;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.JMenuItem;
import javax.swing.UIManager;

import java.awt.Component;

import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;

import javax.swing.JSeparator;

import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JPopupMenu;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Cursor;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;














import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;

import javax.swing.border.CompoundBorder;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JComboBox;

public class MainForm1 {
    int c=0;
	private JFrame frame;
	public static JLabel lblNewLabel_3;
	private JMenuItem mntmChangeUsernamdpassword;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
    Functions func=new Functions();
    private JTextField textField_9;
    private JTextField textField_10;
    private JTextField textField_11;
    private JTable table;
    private JTextField textField_13;
    private JTextField textField_14;
    JScrollPane scrollPane;
    JScrollPane scrollPane_1;
    JMenuItem mntmCreateNewUser;
    JMenuItem mntmDeleteUser;
    private JTextField textField_12;
    JButton btnSave ;
    JPanel panel_1;
    JButton button;
    JButton button_1;
    JButton button_2 ;
    JButton btnCalculate;
    JButton btnReturn;
    JComboBox comboBox ;
    JTextArea textArea;
    private final JLabel lblNewLabel_2 = new JLabel("Logout");
    private JTextField textField_15;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			 //UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				 MainForm1 window = new MainForm1();
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
	public MainForm1() {
	    //frame.setVisible(true);
		initialize();
		checkExpired();
		
	}

	
	public void access()
	{  String yo=null;
		ArrayList list=new ArrayList();
		list=func.readTemp();
		Iterator it=list.iterator();
		while(it.hasNext())
		{
			DataMembers b=(DataMembers)it.next();
			yo=b.getAccess();

		}
		//JOptionPane.showMessageDialog(null, hmm);
		if(yo.equals("normal")==false)
		{
			JOptionPane.showMessageDialog(null, yo);
			
		}
		
	}
	
	
	
	
	public String refreshTable2(String id)
	{
		//JOptionPane.showMessageDialog(null, id);
		scrollPane.setVisible(true);
		 String date3=null;

		 

		 String[] columnNames = {"Roll No","Borrower_ID","Book_ID","Book Name","Borrower Name","Issued Date","Return Date"};
		
		try
		   {
			func.cc2();
		   func.stmt=func.con.createStatement();
		   
		    ResultSet rs=func.stmt.executeQuery("select *from issue where Bid='"+id+"' ");
		   
		    
	     while(rs.next())
		   {
			 Object [] [] rows={{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)}};
			  DefaultTableModel model = new DefaultTableModel(rows, columnNames);
			  date3=rs.getString(6);
			   table = new JTable(model);
			 
			   table.setEnabled(false);
			   table.setFont(new Font("SansSerif", Font.PLAIN, 12));
			     table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			     table.getColumnModel().getColumn(0).setPreferredWidth(70);
			     table.getColumnModel().getColumn(1).setPreferredWidth(80);
			     table.getColumnModel().getColumn(2).setPreferredWidth(70);
			     table.getColumnModel().getColumn(3).setPreferredWidth(200);
			     table.getColumnModel().getColumn(4).setPreferredWidth(200);
			     table.getColumnModel().getColumn(5).setPreferredWidth(90);
			     table.getColumnModel().getColumn(6).setPreferredWidth(90);
			     scrollPane.setViewportView(table);
			     scrollPane_1.setViewportView(table);
			  // JOptionPane.showMessageDialog(null, rs.getString("Boid"));
		   }
	     	func.con.close();
		    }
		   	    
		
		catch(Exception e4)
		{
			e4.printStackTrace();
		}	 
		
		
		
		return date3;
		
		
		
		
		
		
		
	}
	
	
	
	public void checkExpired()
	{
		
		  Date date1=new Date();
		     SimpleDateFormat simpleDateFormat1=new SimpleDateFormat("MM-yyyy");
		    
		     String issuedate=simpleDateFormat1.format(date1);
		
		     long current=date1.getTime();
		     //JOptionPane.showMessageDialog(null, current);
		   //  SELECT * FROM borrower WHERE  >= CURDATE();
		
		     try
			   {
				func.cc2();
			   func.stmt=func.con.createStatement();
			   
			    //ResultSet rs=func.stmt.executeQuery(" SELECT * FROM borrower WHERE Expiry_date <= CURDATE()" );
			   ResultSet rs=func.stmt.executeQuery("SELECT * FROM borrower WHERE  DATE(Expiry_date) < DATE(NOW())" );
			  if(rs.next()==true)
			  {
				  lblNewLabel_3.setText("Many cards has been expired.Go to Borrower -> Delete Expired Cards to delete them!!");
				   
			  }
			  else{
				  lblNewLabel_3.setText(null);
			  }
		     	func.con.close();
			    }
			   	    
			
			catch(Exception e4)
			{
				e4.printStackTrace();
			}	 
			
		     
		     
		     
		     
		     
		     
	}
	
	
	
	public void refreshTable1(String id)
	{
		 scrollPane.setVisible(true);
		 

		 String[] columnNames = {"Roll No","Borrower_ID","Book_ID","Book Name","Borrower Name","Issued Date","Return Date"};
		
		try
		   {
			func.cc2();
		   func.stmt=func.con.createStatement();
		   
		    ResultSet rs=func.stmt.executeQuery("select *from issue where Boid='"+id+"' ");
		   
		    
	     while(rs.next())
		   {
			 Object [] [] rows={{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)}};
			  DefaultTableModel model = new DefaultTableModel(rows, columnNames);
			   table = new JTable(model);
			  
			   table.setEnabled(false);
			   table.setFont(new Font("SansSerif", Font.PLAIN, 12));
			     table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			     table.getColumnModel().getColumn(0).setPreferredWidth(70);
			     table.getColumnModel().getColumn(1).setPreferredWidth(80);
			     table.getColumnModel().getColumn(2).setPreferredWidth(70);
			     table.getColumnModel().getColumn(3).setPreferredWidth(200);
			     table.getColumnModel().getColumn(4).setPreferredWidth(200);
			     table.getColumnModel().getColumn(5).setPreferredWidth(90);
			     table.getColumnModel().getColumn(6).setPreferredWidth(90);
			     scrollPane.setViewportView(table);

			  // JOptionPane.showMessageDialog(null, rs.getString("Boid"));
		   }
	     	func.con.close();
		    }
		   	    
		
		catch(Exception e4)
		{
			e4.printStackTrace();
		}	 
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frame = new JFrame();
		frame.setTitle("ACET Central Library DBMS");
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		
		//set favIcon
		 frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("4.gif")));
		 frame.getContentPane().setLayout(null);
		 
		
		 frame.addWindowListener(new java.awt.event.WindowAdapter(){
			   
			    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
			        if (JOptionPane.showConfirmDialog(frame, 
			            "Are you sure ?", "Really Closing?", 
			            JOptionPane.YES_NO_OPTION,
			            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
			        {
	                      func.deleteTemp();
			              System.exit(0);
			              frame.dispose();
			        }
			        
			    	
			    	//JOptionPane.showConfirmDialog(frame,"Are you sure ?", "Really Closing?", JOptionPane.YES_NO_OPTION);
			    	//JOptionPane.QUESTION_MESSAGE
			    	
			    	
			    }
			    
			});
		 
		 
		 
		frame.setSize(1200,600);
		// Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	    //frame.setSize(dim.width,dim.height);
	     
		 //maximized state
	     frame.setExtendedState(frame.MAXIMIZED_BOTH);
	     // frame.setResizable(false);
	     JMenuBar menuBar = new JMenuBar();
	     frame.setJMenuBar(menuBar);
	     
	     JMenu mnStudent = new JMenu("Borrower");
	     mnStudent.setMnemonic(KeyEvent.VK_B);
	     mnStudent.setAlignmentX(Component.RIGHT_ALIGNMENT);
	     mnStudent.setSize(new Dimension(12, 0));
	     mnStudent.setMargin(new Insets(0, 2, 0, 0));
	     mnStudent.setFont(new Font("SansSerif", Font.PLAIN, 14));
	     mnStudent.setBounds(new Rectangle(0, 0, 18, 18));
	     menuBar.add(mnStudent);
	     
	     JMenuItem mntmNewMenuItem = new JMenuItem("Add Borrower");
	     mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(
	    	        KeyEvent.VK_A, ActionEvent.ALT_MASK));
	     
	     mntmNewMenuItem.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent arg0) {
	     		//frame.setEnabled(false);
	     		AddStudent add=new AddStudent();
	     		add.main(null);
	     	}
	     });
	     mntmNewMenuItem.setAlignmentX(Component.LEFT_ALIGNMENT);
	     mnStudent.add(mntmNewMenuItem);
	     
	     JMenuItem mntmUpdateDetails = new JMenuItem("Update / Delete Borrower");
	     mntmUpdateDetails.setAccelerator(KeyStroke.getKeyStroke(
	    	        KeyEvent.VK_U, ActionEvent.ALT_MASK));
	     mntmUpdateDetails.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		UpDeStudent upde=new UpDeStudent();
	     		upde.main(null);
	     	}
	     });
	     mnStudent.add(mntmUpdateDetails);
	     
	     JSeparator separator = new JSeparator();
	     mnStudent.add(separator);
	     
	     JMenuItem mntmNewMenuItem_5 = new JMenuItem("Search Borrower");
	     mntmNewMenuItem_5.setAccelerator(KeyStroke.getKeyStroke(
	    	        KeyEvent.VK_S, ActionEvent.ALT_MASK));
	     mntmNewMenuItem_5.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent arg0) {
	     		StudentSearch.main(null);
	     	}
	     });
	     mnStudent.add(mntmNewMenuItem_5);
	     
	     JMenuItem mntmDeleteExpiredIds = new JMenuItem("Delete Expired IDs");
	     mntmDeleteExpiredIds.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		DeleteExpired.main(null);
	     	}
	     });
	     mntmDeleteExpiredIds.setAccelerator(KeyStroke.getKeyStroke(
	    	        KeyEvent.VK_D, ActionEvent.ALT_MASK));
	     mnStudent.add(mntmDeleteExpiredIds);
	     
	     JMenu mnBooks = new JMenu("Books");
	     mnBooks.setMnemonic(KeyEvent.VK_O);
	     mnBooks.setMargin(new Insets(0, 2, 0, 0));
	     mnBooks.setFont(new Font("SansSerif", Font.PLAIN, 14));
	     mnBooks.setBounds(new Rectangle(0, 0, 18, 18));
	     menuBar.add(mnBooks);
	     
	     JMenuItem mntmNewMenuItem_3 = new JMenuItem("Add Book");
	     mntmNewMenuItem_3.setAccelerator(KeyStroke.getKeyStroke(
	    	        KeyEvent.VK_A, ActionEvent.CTRL_MASK));
	     mntmNewMenuItem_3.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent arg0) {
	     		
	     		AddBook.main(null);
	     	}
	     });
	     mnBooks.add(mntmNewMenuItem_3);
	     
	     JMenuItem mntmNewMenuItem_4 = new JMenuItem("Update / Delete Details");
	     mntmNewMenuItem_4.setAccelerator(KeyStroke.getKeyStroke(
	    	        KeyEvent.VK_U, ActionEvent.CTRL_MASK));
	     mntmNewMenuItem_4.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     	
	     	UpDeBook.main(null);
	     	 
	     	}
	     });
	     mnBooks.add(mntmNewMenuItem_4);
	     
	     JSeparator separator_2 = new JSeparator();
	     mnBooks.add(separator_2);
	     
	     JMenuItem mntmBooksearch = new JMenuItem("Count / Search Book");
	     mntmBooksearch.setAccelerator(KeyStroke.getKeyStroke(
	    	        KeyEvent.VK_S, ActionEvent.CTRL_MASK));
	     mntmBooksearch.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent arg0) {
	     		BookSearch.main(null);
	     	}
	     });
	     mnBooks.add(mntmBooksearch);
	     
	     JMenuItem mntmDisplayIssuedBooks = new JMenuItem("Search Issued Books");
	     mntmDisplayIssuedBooks.setAccelerator(KeyStroke.getKeyStroke(
	    		 KeyEvent.VK_I, ActionEvent.CTRL_MASK));
	     mntmDisplayIssuedBooks.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent arg0) {
	     		
	     		DisplayIssued.main(null);
	     	}
	     });
	     mnBooks.add(mntmDisplayIssuedBooks);
	     
	     JMenu mnAccountSettings = new JMenu("Account Settings");
	     mnAccountSettings.setMargin(new Insets(0, 2, 0, 0));
	     mnAccountSettings.setFont(new Font("SansSerif", Font.PLAIN, 14));
	     mnAccountSettings.setBounds(new Rectangle(0, 0, 18, 18));
	     menuBar.add(mnAccountSettings);
	     
	     mntmChangeUsernamdpassword = new JMenuItem("Change Password");
	     mntmChangeUsernamdpassword.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		ChangePassword.main(null);
	     	}
	     });
	     mnAccountSettings.add(mntmChangeUsernamdpassword);
	     
	      mntmCreateNewUser = new JMenuItem("Create New User");
	     mntmCreateNewUser.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		
	     		CreateUser.main(null);
	     	}
	     });
	     mnAccountSettings.add(mntmCreateNewUser);
	     
	     mntmDeleteUser = new JMenuItem("Delete User");
	     mntmDeleteUser.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent arg0) {
	     		DeleteUser.main(null);
	     	}
	     });
	     mnAccountSettings.add(mntmDeleteUser);
	     
	     JPanel panel_4 = new JPanel();
	     panel_4.setBackground(Color.WHITE);
	     panel_4.setBorder(UIManager.getBorder("List.cellNoFocusBorder"));
	     panel_4.setBounds(1, 1, 1192, 535);
	     frame.getContentPane().add(panel_4);
	     panel_4.setLayout(null);
	     
	     JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	     tabbedPane.setBounds(1, 1, 1164, 502);
	     panel_4.add(tabbedPane);
	     tabbedPane.setBackground(Color.WHITE);
	     
	     JPanel panel_2 = new JPanel();
	     panel_2.setBackground(new Color(255, 255, 204));
	     tabbedPane.addTab("Book Issue", null, panel_2, null);
	     panel_2.setLayout(null);
	     
	     JLabel lblNewLabel_1 = new JLabel("Borrower");
	     lblNewLabel_1.setBounds(-35, 12, 239, 49);
	     panel_2.add(lblNewLabel_1);
	     lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	     lblNewLabel_1.setFont(new Font("Sakkal Majalla", Font.PLAIN, 30));
	     
	     JPanel panel = new JPanel();
	     panel.setBackground(Color.WHITE);
	     panel.setBorder(new TitledBorder(null, "",TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
	     panel.setBounds(16, 17, 139, 38);
	     panel_2.add(panel);
	     panel.setLayout(null);
	     
	     JLabel label = new JLabel("ID");
	     label.setHorizontalAlignment(SwingConstants.CENTER);
	     label.setFont(new Font("Tahoma", Font.PLAIN, 16));
	     label.setBounds(16, 108, 56, 14);
	     panel_2.add(label);
	     
	     JLabel label_1 = new JLabel("Name");
	     label_1.setHorizontalAlignment(SwingConstants.CENTER);
	     label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
	     label_1.setBounds(6, 158, 69, 14);
	     panel_2.add(label_1);
	     
	     JLabel label_2 = new JLabel("Course");
	     label_2.setHorizontalAlignment(SwingConstants.CENTER);
	     label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
	     label_2.setBounds(6, 212, 69, 14);
	     panel_2.add(label_2);
	     
	     JLabel label_3 = new JLabel("Branch");
	     label_3.setHorizontalAlignment(SwingConstants.CENTER);
	     label_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
	     label_3.setBounds(6, 266, 69, 14);
	     panel_2.add(label_3);
	     
	     JLabel label_4 = new JLabel("Contact No.");
	     label_4.setHorizontalAlignment(SwingConstants.CENTER);
	     label_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
	     label_4.setBounds(6, 318, 96, 14);
	     panel_2.add(label_4);
	     
	     JLabel label_5 = new JLabel("Address");
	     label_5.setHorizontalAlignment(SwingConstants.CENTER);
	     label_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
	     label_5.setBounds(6, 379, 86, 14);
	     panel_2.add(label_5);
	     
	     JLabel label_6 = new JLabel("ID");
	     label_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
	     label_6.setBounds(400, 108, 56, 14);
	     panel_2.add(label_6);
	     
	     JLabel label_7 = new JLabel("Name");
	     label_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
	     label_7.setBounds(387, 158, 69, 14);
	     panel_2.add(label_7);
	     
	     JLabel label_8 = new JLabel("Author");
	     label_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
	     label_8.setBounds(387, 207, 69, 14);
	     panel_2.add(label_8);
	     
	     JLabel label_9 = new JLabel("Category");
	     label_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
	     label_9.setBounds(387, 250, 96, 24);
	     panel_2.add(label_9);
	     
	     textField = new JTextField();
	     textField.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	
	     		
	     		boolean sms=func.checkBorid1(textField.getText());
	     		boolean sms1=func.alreadyIssued(textField.getText());
	     		//JOptionPane.showMessageDialog(null, sms1);
				if(sms==true && sms1==false)
				{
				    scrollPane.setVisible(false);
					
					ArrayList list=new ArrayList();
					list=func.searchStudent1(textField.getText());
					
					Iterator it=list.iterator();
					while(it.hasNext())
		    		{
		    			DataMembers b=(DataMembers)it.next();
		    			textField_1.setText(b.getName());
		    			textField_2.setText(b.getCourse());
		    			textField_3.setText(b.getBranch());
		    			textField_4.setText(b.getCno());
		    			textArea.setText(b.getAddress());
		    			c++;
		    		}
					
				}
					
					
				
				else
					{
					if(sms==false)
					{
					JOptionPane.showMessageDialog(null, "Invalid ID");
					
					scrollPane.setVisible(false);
					
		     			btnSave.setEnabled(false);
		     			textField_1.setText(null);
		    			textField_2.setText(null);
		    			textField_3.setText(null);
		    			textField_4.setText(null);
		    			textArea.setText(null);

					
					
					textField.setText(null);
					}
					
					if (sms1==true)
					{
						String id=textField.getText().toString();
						JOptionPane.showMessageDialog(null, "Book Issuing Limit Exceeds.One Book Per ID");
						textField.setText(null);
						
						btnSave.setEnabled(false); 
						refreshTable1(id);
						 scrollPane.setViewportView(table);
						//ResultSet r;
						//r=func.searchIssuedBook(id);
						 textField_1.setText(null);
			    			textField_2.setText(null);
			    			textField_3.setText(null);
			    			textField_4.setText(null);
			    			textArea.setText(null);
						
					
						
						
						
						
						
					}
					}
				
				if(c==2)
	     		{
	     			btnSave.setEnabled(true);
	     		}
	     	}
	     });
	     textField.addKeyListener(new KeyAdapter() {
	     	@Override
	     	public void keyReleased(KeyEvent arg0) {
	     		button.setEnabled(true);
	     	}
	     });
	     textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
	     textField.setColumns(10);
	     textField.setBounds(119, 100, 86, 32);
	     panel_2.add(textField);
	     
	     textField_1 = new JTextField();
	     textField_1.setEditable(false);
	     textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
	     textField_1.setColumns(10);
	     textField_1.setBounds(119, 150, 205, 32);
	     panel_2.add(textField_1);
	     
	     textField_2 = new JTextField();
	     textField_2.setEditable(false);
	     textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
	     textField_2.setColumns(10);
	     textField_2.setBounds(119, 204, 80, 32);
	     panel_2.add(textField_2);
	     
	     textField_3 = new JTextField();
	     textField_3.setEditable(false);
	     textField_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
	     textField_3.setColumns(10);
	     textField_3.setBounds(119, 258, 80, 32);
	     panel_2.add(textField_3);
	     
	     textField_4 = new JTextField();
	     textField_4.setEditable(false);
	     textField_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
	     textField_4.setColumns(10);
	     textField_4.setBounds(119, 308, 145, 32);
	     panel_2.add(textField_4);
	     
	     textField_5 = new JTextField();
	     textField_5.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		
	     		String id=textField_5.getText().toString();
	     		boolean sms=func.checkBokid(textField_5.getText());	
	     		boolean sms1=func.alreadyIssued2(textField_5.getText());
				if(sms==true &&sms1==false)
				{
					scrollPane.setVisible(false);
					ArrayList list=new ArrayList();
					list=func.searchBook(textField_5.getText());
					
					Iterator it=list.iterator();
					while(it.hasNext())
		    		{
		    			DataMembers b=(DataMembers)it.next();
		    			textField_6.setText(b.getName());
		    			textField_7.setText(b.getAuthor());
		    			textField_8.setText(b.getCategory());
		    			
		    		   
		    		     
		    		     
		    		     
		    		     Date date1=new Date();
		    		     SimpleDateFormat simpleDateFormat1=new SimpleDateFormat("yyyy-MM-dd");
		    		    // date=c1.getTime();
		    		     String issuedate=simpleDateFormat1.format(date1);
		    		     
		    		     Date date2=new Date();
		    		     SimpleDateFormat simpleDateFormat2=new SimpleDateFormat("yyyy-MM-dd");
		    		     
		    		 	Calendar c1=new GregorianCalendar();
		    		    c1.add(Calendar.DAY_OF_MONTH,7);
		    		    
		    		    date2=c1.getTime();
		    		     
		    		    String returndate=simpleDateFormat2.format(date2);
		    			
		    			
		    			textField_13.setText(issuedate);
		    			textField_14.setText(returndate);
		    			 c++;
		    			
		    		}
					
					
				}
				else
					{
					if(sms==false)
					{
						scrollPane.setVisible(false);
						JOptionPane.showMessageDialog(null, "Invalid ID");
						btnSave.setEnabled(false);
						textField_5.setText(null);
						textField_6.setText(null);
		    			textField_7.setText(null);
		    			textField_8.setText(null);	
		    			
		    			textField_13.setText(null);
		    			textField_14.setText(null);			    
			        }
					if(sms1==true)
					{
						
						JOptionPane.showMessageDialog(null, "Book Already Issued");
						textField_5.setText(null);
						String ans=refreshTable2(id);
						btnSave.setEnabled(false);
						scrollPane_1.setVisible(false);
						scrollPane.setViewportView(table);
						textField_6.setText(null);
		    			textField_7.setText(null);
		    			textField_8.setText(null);	
		    			
		    			textField_13.setText(null);
		    			textField_14.setText(null);
			        }
					}
	     		
				if(c==2)
	     		{
	     			btnSave.setEnabled(true);
	     		}
	     	}
	     });
	     textField_5.addKeyListener(new KeyAdapter() {
	     	
	     	public void keyReleased(KeyEvent arg0) {
	     		button_1.setEnabled(true);
	     		
	     	}
	     });
	     textField_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
	     textField_5.setColumns(10);
	     textField_5.setBounds(492, 100, 86, 32);
	     panel_2.add(textField_5);
	     
	     textField_6 = new JTextField();
	     textField_6.setEditable(false);
	     textField_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
	     textField_6.setColumns(10);
	     textField_6.setBounds(492, 150, 205, 32);
	     panel_2.add(textField_6);
	     
	     textField_7 = new JTextField();
	     textField_7.setEditable(false);
	     textField_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
	     textField_7.setColumns(10);
	     textField_7.setBounds(492, 199, 202, 32);
	     panel_2.add(textField_7);
	     
	     textField_8 = new JTextField();
	     textField_8.setEditable(false);
	     textField_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
	     textField_8.setColumns(10);
	     textField_8.setBounds(492, 247, 202, 32);
	     panel_2.add(textField_8);
	     
	      textArea = new JTextArea();
	     textArea.setEditable(false);
	     textArea.setWrapStyleWord(true);
	     textArea.setLineWrap(true);
	     textArea.setBounds(119, 369, 155, 49);
	     panel_2.add(textArea);
	     
	     
	     
	     scrollPane = new JScrollPane();
	     scrollPane.setVisible(false);
	     
	     scrollPane.setFont(new Font("SansSerif", Font.PLAIN, 12));
	     scrollPane.setBounds(728, 53, 430, 146);
	     
	     
	     
	     
	     panel_2.add(scrollPane);
	     
	     
	     
	      button = new JButton("Go");
	     button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	     button.setEnabled(false);
	     button.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		
	     		
	     		
	     		
	     		
	     		boolean sms=func.checkBorid1(textField.getText());
	     		boolean sms1=func.alreadyIssued(textField.getText());
	     		//JOptionPane.showMessageDialog(null, sms1);
				if(sms==true && sms1==false)
				{
				    scrollPane.setVisible(false);
					
					ArrayList list=new ArrayList();
					list=func.searchStudent1(textField.getText());
					
					Iterator it=list.iterator();
					while(it.hasNext())
		    		{
		    			DataMembers b=(DataMembers)it.next();
		    			textField_1.setText(b.getName());
		    			textField_2.setText(b.getCourse());
		    			textField_3.setText(b.getBranch());
		    			textField_4.setText(b.getCno());
		    			textArea.setText(b.getAddress());
		    			c++;
		    		}
					
				}
					
					
				
				else
					{
					if(sms==false)
					{
					JOptionPane.showMessageDialog(null, "Invalid ID");
					
					scrollPane.setVisible(false);
					
		     			btnSave.setEnabled(false);
		     			textField_1.setText(null);
		    			textField_2.setText(null);
		    			textField_3.setText(null);
		    			textField_4.setText(null);
		    			textArea.setText(null);

					
					
					textField.setText(null);
					}
					
					if (sms1==true)
					{
						String id=textField.getText().toString();
						JOptionPane.showMessageDialog(null, "Book Issuing Limit Exceeds.One Book Per ID");
						textField.setText(null);
						
						btnSave.setEnabled(false); 
						refreshTable1(id);
						 scrollPane.setViewportView(table);
						//ResultSet r;
						//r=func.searchIssuedBook(id);
						
						 textField_1.setText(null);
			    			textField_2.setText(null);
			    			textField_3.setText(null);
			    			textField_4.setText(null);
			    			textArea.setText(null);

						
					
						
						
						
						
						
					}
					}
				
				if(c==2)
	     		{
	     			btnSave.setEnabled(true);
	     		}
	     	}
	     });
	     
	     
	     
	     button.setFont(new Font("Tahoma", Font.PLAIN, 12));
	     button.setBounds(226, 106, 56, 23);
	     panel_2.add(button);
	     
	     
	   	     
	     
	     
	   button_1 = new JButton("Go");
	     
	     button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	     button_1.setEnabled(false);
	     button_1.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		
	     			     		
	     		String id=textField_5.getText().toString();
	     		boolean sms=func.checkBokid(textField_5.getText());	
	     		boolean sms1=func.alreadyIssued2(textField_5.getText());
				if(sms==true &&sms1==false)
				{
					scrollPane.setVisible(false);
					ArrayList list=new ArrayList();
					list=func.searchBook(textField_5.getText());
					
					Iterator it=list.iterator();
					while(it.hasNext())
		    		{
		    			DataMembers b=(DataMembers)it.next();
		    			textField_6.setText(b.getName());
		    			textField_7.setText(b.getAuthor());
		    			textField_8.setText(b.getCategory());
		    			
		    		   
		    		     
		    		     
		    		     
		    		     Date date1=new Date();
		    		     SimpleDateFormat simpleDateFormat1=new SimpleDateFormat("yyyy-MM-dd");
		    		    // date=c1.getTime();
		    		     String issuedate=simpleDateFormat1.format(date1);
		    		     
		    		     Date date2=new Date();
		    		     SimpleDateFormat simpleDateFormat2=new SimpleDateFormat("yyyy-MM-dd");
		    		     
		    		 	Calendar c1=new GregorianCalendar();
		    		    c1.add(Calendar.DAY_OF_MONTH,7);
		    		    
		    		    date2=c1.getTime();
		    		     
		    		    String returndate=simpleDateFormat2.format(date2);
		    			
		    			
		    			textField_13.setText(issuedate);
		    			textField_14.setText(returndate);
		    			 c++;
		    			
		    		}
					
					
				}
				else
					{
					if(sms==false)
					{
						scrollPane.setVisible(false);
						JOptionPane.showMessageDialog(null, "Invalid ID");
						btnSave.setEnabled(false);
						textField_5.setText(null);
						textField_6.setText(null);
		    			textField_7.setText(null);
		    			textField_8.setText(null);	
		    			
		    			textField_13.setText(null);
		    			textField_14.setText(null);
			        }
					if(sms1==true)
					{
						
						JOptionPane.showMessageDialog(null, "Book Already Issued");
						textField_5.setText(null);
						String ans=refreshTable2(id);
						btnSave.setEnabled(false);
						scrollPane_1.setVisible(false);
						scrollPane.setViewportView(table);
						textField_6.setText(null);
		    			textField_7.setText(null);
		    			textField_8.setText(null);	
		    			
		    			textField_13.setText(null);
		    			textField_14.setText(null);
			        }
					}
	     		
				if(c==2)
	     		{
	     			btnSave.setEnabled(true);
	     		}

				
				
	     	}
	     });
	     button_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
	     button_1.setBounds(607, 106, 56, 23);
	     panel_2.add(button_1);
	     
	      btnSave = new JButton("Issue");
	      btnSave.setEnabled(false);
	      btnSave.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent e) {
	      		
	      		String s1,s2,s3,s4,s5,s6;
	      		
	      		
	      		String s=null;
	      		
	      		
	      		ArrayList list=new ArrayList();
				list=func.searchStudent1(textField.getText());
				
				Iterator it=list.iterator();
				while(it.hasNext())
	    		{
	    			DataMembers b=(DataMembers)it.next();
	    			
	    			s=b.getAccess().toString();
	    			
	    		}
	      		
	      		
	      		
	      		
	      		
	      		
	      		
	      		
	      		
	      		
	      		
	      		
	      		
	      		
	      		s1=textField.getText().toString();
	      		s2=textField_1.getText().toString();
	      		s3=textField_5.getText().toString();
	      		s4=textField_6.getText().toString();
	      		s5=textField_13.getText().toString();
	      		s6=textField_14.getText().toString();
	      		
	      		
	      		if(func.dateValid(s6)==false)
	      		{
	      			textField_14.setText(null);
	      			JOptionPane.showMessageDialog(null, "Invalid Date Format.");
	      		}
	      		
	      		
	      		else
	      		{
	      			 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	      			 Date d1=null;
	      			 Date d2=null;
	      		
	      			try {

		     			 d1 = formatter.parse(s6);
		     			 d2=formatter.parse(s5);
		     			
		     		} catch (ParseException e6) {
		     			JOptionPane.showMessageDialog(null, "Invalid Date Format.");
		     			textField_14.setText(null);
		     			//e6.printStackTrace();
		     		}
	      		
	      		long diff3=d1.getTime()-d2.getTime();
	      		if(diff3<0)
	      		{
	      			JOptionPane.showMessageDialog(null, "Return date is less than Issue date");
	      			textField_14.setText(null);
	      			
	      		}
	      		
	      		else{
	      		if(func.addIssuedBook(s,s1, s3, s4, s2, s5, s6)==true){
	      		JOptionPane.showMessageDialog(null, "Issued Successfully.");
	      		textField.setText(null);
	      		textField_1.setText(null);
	      		textField_2.setText(null);
	      		textField_3.setText(null);
	      		textField_4.setText(null);
	      		textField_5.setText(null);
	      		textField_6.setText(null);
	      		textField_7.setText(null);
	      		textField_8.setText(null);
	      		textField_13.setText(null);
	      		textField_14.setText(null);
	      		textArea.setText(null);
	      		scrollPane.setVisible(false);
	      		button.setEnabled(false);
	      		button_1.setEnabled(false);
	      		btnSave.setEnabled(false);
	      		c=0;}
	      		else{
	      		JOptionPane.showMessageDialog(null, "Invalid Date");
	      		textField_14.setText(null);
	      		
	      		
	      		}
	      		}
	      		}}
	      	}
	      );
	      btnSave.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	      btnSave.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	      btnSave.setBounds(820, 367, 104, 38);
	      panel_2.add(btnSave);
	      
	      JLabel lblBook = new JLabel("Book");
	      lblBook.setHorizontalAlignment(SwingConstants.CENTER);
	      lblBook.setFont(new Font("Sakkal Majalla", Font.PLAIN, 30));
	      lblBook.setBounds(328, 12, 239, 49);
	      panel_2.add(lblBook);
	      
	      JPanel panel_3 = new JPanel();
	      panel_3.setLayout(null);
	      panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
	      panel_3.setBackground(Color.WHITE);
	      panel_3.setBounds(379, 17, 139, 38);
	      panel_2.add(panel_3);
	      
	      JLabel lblIssueDate = new JLabel("Issue Date");
	      lblIssueDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
	      lblIssueDate.setBounds(387, 318, 96, 24);
	      panel_2.add(lblIssueDate);
	      
	      JLabel lblReturnDate = new JLabel("Return Date");
	      lblReturnDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
	      lblReturnDate.setBounds(387, 379, 96, 24);
	      panel_2.add(lblReturnDate);
	      
	    
	      
	      
	      
	  
	      
	      
	      
	      textField_13 = new JTextField();
	      textField_13.setEditable(false);
	      textField_13.setFont(new Font("Tahoma", Font.PLAIN, 14));
	      textField_13.setColumns(10);
	      textField_13.setBounds(492, 312, 145, 32);
	      panel_2.add(textField_13);
	      
	      textField_14 = new JTextField();
	      textField_14.addKeyListener(new KeyAdapter() {
	      	@Override
	      	public void keyReleased(KeyEvent e) {
	      		btnCalculate.setEnabled(true);
	      	}
	      });
	      textField_14.setFont(new Font("Tahoma", Font.PLAIN, 14));
	      textField_14.setColumns(10);
	      textField_14.setBounds(492, 373, 145, 32);
	      panel_2.add(textField_14);
	      
	       lblNewLabel_3 = new JLabel("");
	       lblNewLabel_3.setForeground(Color.RED);
	       lblNewLabel_3.setBounds(649, 434, 518, 32);
	       panel_2.add(lblNewLabel_3);
	      
	      JLabel lblddmmyyy = new JLabel("(YYYY-MM-DD)");
	      lblddmmyyy.setForeground(Color.GRAY);
	      lblddmmyyy.setFont(new Font("Tahoma", Font.PLAIN, 12));
	      lblddmmyyy.setBounds(649, 319, 96, 24);
	      panel_2.add(lblddmmyyy);
	      
	      JLabel lblyyyymmdd = new JLabel("(YYYY-MM-DD)");
	      lblyyyymmdd.setForeground(Color.GRAY);
	      lblyyyymmdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
	      lblyyyymmdd.setBounds(649, 379, 96, 24);
	      panel_2.add(lblyyyymmdd);
	     
	     panel_1 = new JPanel();
	     panel_1.setBackground(new Color(255, 255, 204));
	     tabbedPane.addTab("Book Return", null, panel_1, null);
	     panel_1.setLayout(null);
	
	     JLabel lblBookId = new JLabel("Book ID");
	     lblBookId.setHorizontalAlignment(SwingConstants.LEFT);
	     lblBookId.setHorizontalTextPosition(SwingConstants.LEFT);
	     lblBookId.setBounds(20, 39, 118, 20);
	     lblBookId.setFont(new Font("Tahoma", Font.PLAIN, 16));
	     panel_1.add(lblBookId);
	     
	     textField_9 = new JTextField();
	     textField_9.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		String id=textField_9.getText().toString();
	     		boolean sms=func.checkBokid(textField_9.getText());	
	     		boolean sms1=func.alreadyIssued2(textField_9.getText());
	     		if(sms==true && sms1==true)
	     		{
	     		
	     			scrollPane.setVisible(false);
	     			String ans=refreshTable2(id);
	     			scrollPane_1.setVisible(true);
	     			
	     			textField_12.setText(ans);
	     			scrollPane_1.setViewportView(table);
	     			
	     		}
	     		
	     			if(sms==false)
	     			{
	     				scrollPane_1.setVisible(false);
	     				JOptionPane.showMessageDialog(null, "Invalid ID.");
	     			textField_9.setText(null);
	     			}
	     			if(sms==true &&sms1==false)
	     			{
	     				scrollPane_1.setVisible(false);
	     				JOptionPane.showMessageDialog(null, "Book Not Issued.");
		     			textField_9.setText(null);
	     			
	     		}
	     		
	     			String id1=textField_9.getText().toString();
	     		
	     			try
					   {
						func.cc2();
					   func.stmt=func.con.createStatement();
					   
					    ResultSet rs=func.stmt.executeQuery("select Category from book where Bid='"+id1+"' ");
					    
					    
				     while(rs.next())
					   {			    	 
						        String a=rs.getString(1);
								
								textField_15.setText(a);
						 
					   }
				     	func.con.close();
					   }
					   	    
					catch(Exception e4)
					{
						e4.printStackTrace();
					}	 
	     		
	     		
	     		
	     		
	     	}
	     });
	     textField_9.addKeyListener(new KeyAdapter() {
	     	
	     	public void keyReleased(KeyEvent arg0) {
	     		button_2.setEnabled(true);
	     	}
	     });
	     textField_9.setBounds(150, 37, 75, 29);
	     textField_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
	     textField_9.setColumns(10);
	     panel_1.add(textField_9);
	     
	   //  scrollPane_1.setVisible(false);
	     
	     
	    button_2 = new JButton("Go");
	     button_2.setEnabled(false);
	     button_2.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		//btnCalculate.setEnabled(true);
	     		//button_3.setEnabled(true);
	     		String id=textField_9.getText().toString();
	     		boolean sms=func.checkBokid(textField_9.getText());	
	     		boolean sms1=func.alreadyIssued2(textField_9.getText());
	     		if(sms==true && sms1==true)
	     		{
	     			
	     			scrollPane.setVisible(false);
	     			String ans=refreshTable2(id);
	     			scrollPane_1.setVisible(true);
	     			
	     			textField_12.setText(ans);
	     			scrollPane_1.setViewportView(table);
	     			
	     		}
	     		
	     			if(sms==false)
	     			{
	     				scrollPane_1.setVisible(false);
	     				JOptionPane.showMessageDialog(null, "Invalid ID.");
	     			textField_9.setText(null);
	     			}
	     			if(sms==true &&sms1==false)
	     			{
	     				scrollPane_1.setVisible(false);
	     				JOptionPane.showMessageDialog(null, "Book Not Issued.");
		     			textField_9.setText(null);
	     			
	     		}
	     		
	     			String id1=textField_9.getText().toString();
	     		
	     			try
					   {
						func.cc2();
					   func.stmt=func.con.createStatement();
					   
					    ResultSet rs=func.stmt.executeQuery("select Category from book where Bid='"+id1+"' ");
					    
					    
				     while(rs.next())
					   {			    	 
						        String a=rs.getString(1);
								
								textField_15.setText(a);
						 
					   }
				     	func.con.close();
					   }
					   	    
					catch(Exception e4)
					{
						e4.printStackTrace();
					}	 
	     		
	     		
	     		
	     	}
	     });
	     button_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	     button_2.setBounds(265, 39, 43, 27);
	     button_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
	     panel_1.add(button_2);
	     
	     JLabel lblReturnedDate = new JLabel("Return Date");
	     lblReturnedDate.setHorizontalTextPosition(SwingConstants.LEFT);
	     lblReturnedDate.setHorizontalAlignment(SwingConstants.LEFT);
	     lblReturnedDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
	     lblReturnedDate.setBounds(20, 185, 118, 20);
	     panel_1.add(lblReturnedDate);
	     
	     textField_10 = new JTextField();
	     textField_10.addKeyListener(new KeyAdapter() {
	     	@Override
	     	public void keyReleased(KeyEvent e) {
	     		btnCalculate.setEnabled(true);
	     		btnReturn.setEnabled(true);
	     	}
	     });
	     textField_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
	     textField_10.setColumns(10);
	     textField_10.setBounds(150, 181, 156, 29);
	     panel_1.add(textField_10);
	     
	     JLabel lblFine = new JLabel("Total Fine");
	     lblFine.setHorizontalTextPosition(SwingConstants.LEFT);
	     lblFine.setHorizontalAlignment(SwingConstants.LEFT);
	     lblFine.setFont(new Font("Tahoma", Font.PLAIN, 16));
	     lblFine.setBounds(20, 289, 118, 20);
	     panel_1.add(lblFine);
	     
	     textField_11 = new JTextField();
	     textField_11.setEditable(false);
	     textField_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
	     textField_11.setColumns(10);
	     textField_11.setBounds(150, 287, 75, 29);
	     panel_1.add(textField_11);
	     
	     btnCalculate = new JButton("Calculate");
	     btnCalculate.setEnabled(false);
	     btnCalculate.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent arg0) {
	     		btnReturn.setEnabled(true);
	     		String returndate=null;
	     		
	     		String returned_date=textField_10.getText().toString();   
	     		String issued_date=textField_12.getText().toString();
	     	    String d=null;
	     	  
	            
	            Date returndate1=null;
	     		Date returndate2=null;
	     		Date issue=null;
	            
	     		
	     		
	     		
	     	      
	            String id=textField_9.getText().toString();
		     		
		     		try
		 		   {
		 			func.cc2();
		 		   func.stmt=func.con.createStatement();
		 		   
		 		    ResultSet rs=func.stmt.executeQuery("select *from issue where Bid='"+id+"' ");
		 		   
		 		    
		 	     while(rs.next())
		 		   {
		 	    	
		 			 returndate=rs.getString(6);                    //return date
		 			   
		 		   }
		 	     	func.con.close();
		 		    }
		 		   	    
		 		
		 		catch(Exception e4)
		 		{
		 			e4.printStackTrace();
		 			//JOptionPane.showConfirmDialog(null, "Invalid Date Format.");
		 		}	 
	     		
	     		
	     		
	     		
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	     		
                
                
                
                
                
	     		try {

	     			 returndate2 = formatter.parse(returned_date);
	     			 returndate1=formatter.parse(returndate);
	     			 issue=formatter.parse(issued_date);
	     		} catch (ParseException e6) {
	     			JOptionPane.showMessageDialog(null, "Invalid Date Format.");
	     			textField_10.setText(null);
	     			//e6.printStackTrace();
	     		}
	      if(func.dateValid2(returned_date)==false)
	      {
	    	  textField_10.setText(null);
	    	  JOptionPane.showMessageDialog(null, "Invalid Date Format.");
	      }
	     		
	     
	      else{
	     		long diff1 = returndate2.getTime() - returndate1.getTime();
	     		long diff2= diff1 / (1000 * 60 * 60 * 24) ;
	     		//long diff3=returndate2.getTime()-issue.getTime();
	     		//JOptionPane.showMessageDialog(null, diff2);
	     		
	     		//if(diff3<0)
	     	//	{
	     		//	JOptionPane.showMessageDialog(null, "Invalid Returned Date.");
	     		//	textField_10.setText(null);
	     		//}
	     		
	     		
	     		long diff3=returndate2.getTime()-issue.getTime();
	     		
	     		if(diff3<0)
	     		{
	     			textField_10.setText(null);
	     			JOptionPane.showMessageDialog(null, "Returned date is less than Issued date.");
	     		}
	     		else{
	     		if(diff2>0)
	     	{
	     		    long fine=diff2*Integer.parseInt(comboBox.getSelectedItem().toString());
	     			String ans=Long.toString(fine);
	     			textField_11.setText(ans);
	     	}
	     		else
	     			textField_11.setText("0");
	     		
	      }
	      }
	     	}
	     });
	     btnCalculate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	     btnCalculate.setFont(new Font("Tahoma", Font.PLAIN, 12));
	     btnCalculate.setBounds(301, 287, 86, 27);
	     panel_1.add(btnCalculate);
	     
	     JLabel lblyyyymmdd_2 = new JLabel("(YYYY-MM-DD)");
	     lblyyyymmdd_2.setForeground(Color.GRAY);
	     lblyyyymmdd_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
	     lblyyyymmdd_2.setBounds(320, 185, 96, 24);
	     panel_1.add(lblyyyymmdd_2);
	     
	     scrollPane_1 = new JScrollPane();
	     scrollPane_1.setVisible(false);
	     scrollPane_1.setFont(new Font("SansSerif", Font.PLAIN, 12));
	     scrollPane_1.setBounds(411, 37, 556, 150);
	     panel_1.add(scrollPane_1);
	     
	     btnReturn = new JButton("Return");
	     btnReturn.setEnabled(false);
	     btnReturn.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent arg0) {
	     		
	     		
	     		
String returndate=null;
	     		
	     		String returned_date=textField_10.getText().toString();   
	     		String issued_date=textField_12.getText().toString();
	     	    String d=null;
	     	  
	            
	            Date returndate1=null;
	     		Date returndate2=null;
	     		Date issue=null;
	            
	     		
	     		
	     		
	     	      
	            String id=textField_9.getText().toString();
		     		
		     		try
		 		   {
		 			func.cc2();
		 		   func.stmt=func.con.createStatement();
		 		   
		 		    ResultSet rs=func.stmt.executeQuery("select *from issue where Bid='"+id+"' ");
		 		   
		 		    
		 	     while(rs.next())
		 		   {
		 	    	
		 			 returndate=rs.getString(6);                    //return date
		 			   
		 		   }
		 	     	func.con.close();
		 		    }
		 		   	    
		 		
		 		catch(Exception e4)
		 		{
		 			e4.printStackTrace();
		 			//JOptionPane.showConfirmDialog(null, "Invalid Date Format.");
		 		}	 
	     		
	     		
	     		
	     		
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	     		
                
                
                
                boolean ans1=true;
                
	     		try {

	     			 returndate2 = formatter.parse(returned_date);
	     			 returndate1=formatter.parse(returndate);
	     			 issue=formatter.parse(issued_date);
	     		} catch (ParseException e6) {
	     			JOptionPane.showMessageDialog(null, "Invalid Date Format.");
	     			textField_10.setText(null);
	     			//e6.printStackTrace();
	     		}
	      if(func.dateValid(returned_date)==false)
	      {
	    	  
	    	  textField_10.setText(null);
	    	  JOptionPane.showMessageDialog(null, "Invalid Date Format1.");
	      }
	     		
	     
	      else{
	     		long diff1 = returndate2.getTime() - returndate1.getTime();
	     		long diff2= diff1 / (1000 * 60 * 60 * 24) ;
	     		//long diff3=returndate2.getTime()-issue.getTime();
	     		//JOptionPane.showMessageDialog(null, diff2);
	     		
	     		//if(diff3<0)
	     	//	{
	     		//	JOptionPane.showMessageDialog(null, "Invalid Returned Date.");
	     		//	textField_10.setText(null);
	     		//}
	     		
	     		
	     		long diff3=returndate2.getTime()-issue.getTime();
	     		
	     		if(diff3<0)
	     		{
	     			textField_10.setText(null);
	     			JOptionPane.showMessageDialog(null, "Returned date is less than Issued date.");
	     			ans1=false;
	     		}
	     		else{
	     		if(diff2>0)
	     	{
	     		    long fine=diff2*Integer.parseInt(comboBox.getSelectedItem().toString());
	     			String ans=Long.toString(fine);
	     			textField_11.setText(ans);
	     	}
	     		else
	     			textField_11.setText("0");
	     		
	      }
	      
	      }		
	     		
	     		
	     		
	     		
	     		
	     		
	     		
	     		
	     		
	     		
	     		
	     		if(ans1==true)
	     		{
	     		
	     		func.deleteIssue(textField_9.getText().toString());
	     		JOptionPane.showMessageDialog(null, "Book Returned.");
	     		textField_9.setText(null);
	     		textField_10.setText(null);
	     		textField_11.setText(null);
	     		textField_12.setText(null);
	     		textField_15.setText(null);
	     		scrollPane_1.setVisible(false);
	     		btnReturn.setEnabled(false);
	     		button_2.setEnabled(false);
	     		btnCalculate.setEnabled(false);
	     		
	     		}
	     		
	     	}
	     });
	     btnReturn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	     btnReturn.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	     btnReturn.setBounds(150, 357, 104, 38);
	     panel_1.add(btnReturn);
	     
	     JLabel lblIssuedDate = new JLabel("Issued Date");
	     lblIssuedDate.setHorizontalTextPosition(SwingConstants.LEFT);
	     lblIssuedDate.setHorizontalAlignment(SwingConstants.LEFT);
	     lblIssuedDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
	     lblIssuedDate.setBounds(20, 143, 118, 20);
	     panel_1.add(lblIssuedDate);
	     
	     textField_12 = new JTextField();
	     textField_12.setEditable(false);
	     textField_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
	     textField_12.setColumns(10);
	     textField_12.setBounds(150, 140, 156, 29);
	     panel_1.add(textField_12);
	     
	     JLabel lblyyyymmdd_1 = new JLabel("(YYYY-MM-DD)");
	     lblyyyymmdd_1.setForeground(Color.GRAY);
	     lblyyyymmdd_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
	     lblyyyymmdd_1.setBounds(320, 146, 96, 24);
	     panel_1.add(lblyyyymmdd_1);
	     
	     JLabel lblFinePerDay = new JLabel("Fine per Day (Rs.)");
	     lblFinePerDay.setHorizontalTextPosition(SwingConstants.LEFT);
	     lblFinePerDay.setHorizontalAlignment(SwingConstants.LEFT);
	     lblFinePerDay.setFont(new Font("Tahoma", Font.PLAIN, 16));
	     lblFinePerDay.setBounds(20, 245, 128, 20);
	     panel_1.add(lblFinePerDay);
	     
	      comboBox = new JComboBox();
	      
	     String [] s1={"0","1","2","3","4","5","6","7","8","9","10"};
			for(String s: s1)
			{
				comboBox.addItem(s);
			}
			comboBox.setSelectedIndex(2);
	     comboBox.setBounds(160, 243, 52, 26);
	     
	     panel_1.add(comboBox);
	     
	     JLabel lblCategory = new JLabel("Category");
	     lblCategory.setHorizontalTextPosition(SwingConstants.LEFT);
	     lblCategory.setHorizontalAlignment(SwingConstants.LEFT);
	     lblCategory.setFont(new Font("Tahoma", Font.PLAIN, 16));
	     lblCategory.setBounds(20, 94, 118, 20);
	     panel_1.add(lblCategory);
	     
	     textField_15 = new JTextField();
	     textField_15.setFont(new Font("Tahoma", Font.PLAIN, 14));
	     textField_15.setColumns(10);
	     textField_15.setBounds(150, 92, 156, 29);
	     panel_1.add(textField_15);
	     
	     JButton btnLogout = new JButton("");
	     btnLogout.setToolTipText("Logout");
	     btnLogout.setIcon(new ImageIcon(MainForm1.class.getResource("/ldbms/9.png")));
	     btnLogout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	     btnLogout.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent arg0) {
	     		func.deleteTemp();
	     		
	     		frame.dispose();
	     		LoginForm.main(null);
	     	}
	     });
	    // btnLogout.setIcon(new ImageIcon("D:\\ldbms\\images\\7.png"));
	     btnLogout.setBounds(1298, 15, 44, 44);
	     frame.getContentPane().add(btnLogout);
	     btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 14));
	     lblNewLabel_2.setForeground(new Color(0, 0, 0));
	     lblNewLabel_2.setBackground(new Color(255, 0, 0));
	     lblNewLabel_2.setFont(new Font("Sylfaen", Font.PLAIN, 18));
	     lblNewLabel_2.setBounds(1236, 24, 72, 24);
	     frame.getContentPane().add(lblNewLabel_2);
	     
	     
	     
	     JLabel lblNewLabel = new JLabel("");
	     lblNewLabel.setIcon(new ImageIcon(MainForm1.class.getResource("/ldbms/5.jpg")));
		 lblNewLabel.setBounds(0, 0, 1400, 712);
		// lblNewLabel.setIcon(new ImageIcon(MainForm1.class.getResource("/ldbms/5.jpg")));
		 frame.getContentPane().add(lblNewLabel);
	     
		 
			
	     
	     
	     
	     
	     
	     
	}
}
