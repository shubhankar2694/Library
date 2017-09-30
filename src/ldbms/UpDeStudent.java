package ldbms;

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
import javax.swing.UIManager;




import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.Cursor;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class UpDeStudent {

	private JDialog frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	JButton btnUpdate;
	JButton btnGo ;
	Functions func=new Functions();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTextField textField_4;
	private JTextField textField_5;

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
					UpDeStudent window = new UpDeStudent();
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
	public UpDeStudent() {
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
		frame.setTitle("Update/ Delete Borrower");
		frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		 frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("4.gif")));
		frame.getContentPane().setLayout(null);
		
		
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Roll No");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(22, 65, 56, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblName.setBounds(22, 117, 69, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblBranch = new JLabel("Course");
		lblBranch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBranch.setBounds(22, 166, 69, 14);
		frame.getContentPane().add(lblBranch);
		
		JLabel lblContactNo = new JLabel("Contact No.");
		lblContactNo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContactNo.setBounds(22, 221, 96, 14);
		frame.getContentPane().add(lblContactNo);
		
		JLabel lblPermanentAddress = new JLabel("Address");
		lblPermanentAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPermanentAddress.setBounds(22, 282, 86, 14);
		frame.getContentPane().add(lblPermanentAddress);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGender.setBounds(383, 59, 56, 14);
		frame.getContentPane().add(lblGender);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		buttonGroup_1.add(rdbtnFemale);
		rdbtnFemale.setBounds(475, 89, 109, 23);
		frame.getContentPane().add(rdbtnFemale);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		buttonGroup_1.add(rdbtnMale);
		rdbtnMale.setBounds(475, 59, 109, 23);
		frame.getContentPane().add(rdbtnMale);
		
		JLabel label = new JLabel("Branch");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(228, 168, 69, 14);
		frame.getContentPane().add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(127, 278, 161, 48);
		frame.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		scrollPane.setViewportView(textArea);
		

		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				
				if(func.alreadyIssued1(textField.getText())==false)
				{
				
				
				int x=JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?","Delete",JOptionPane.YES_NO_OPTION);
				if (x==0)
				{
					
				func.deleteStudent(textField.getText());
				
				JOptionPane.showMessageDialog(null, "Data Deleted Successfully");
				    textField.setText(null);
					textField_1.setText(null);
					textField_2.setText(null);
					textField_3.setText(null);
					textField_4.setText(null);
					textField_5.setText(null);
					buttonGroup_1.clearSelection();
					btnUpdate.setEnabled(true);
				    btnDelete.setEnabled(true);
					textArea.setText(null);
					int ch=1;
					textField.setEditable(true);
					func.genExtra1Table(ch);
					
				}}
				else{
					JOptionPane.showMessageDialog(null, "Book Issued On this Roll No.Go to Borrower->Search Issued Books to check.");
					textField.setText(null);
					textField_1.setText(null);
					textField_2.setText(null);
					textField_3.setText(null);
					textField_4.setText(null);
					textField_5.setText(null);
					buttonGroup_1.clearSelection();
					btnUpdate.setEnabled(true);
				    btnDelete.setEnabled(true);
					textArea.setText(null);
				}
				
					
			}
		});
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete.setEnabled(false);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDelete.setBounds(518, 147, 96, 33);
		frame.getContentPane().add(btnDelete);
		
		 btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
                
				String id,name,date1,course,branch,gender,address,cno;
			    gender="";				
				id=textField.getText();
				name=textField_1.getText().toString();
				course=textField_2.getText();
				branch=textField_3.getText();
				cno=textField_4.getText();
				address=textArea.getText();
				date1=textField_5.getText();
				if(rdbtnFemale.isSelected())
				{
					gender=rdbtnFemale.getText();
				}
				
				else if(rdbtnMale.isSelected())
				{
					gender=rdbtnMale.getText();
				}
				if(func.dateValid2(date1)==true){
					textField.setEditable(true);
				 func.updateStudent(id,name,course,branch,cno,address,gender,date1);
				 JOptionPane.showMessageDialog(null, "Data Updated Successfully.");
				 textField.setText(null);
				 textField_1.setText(null);
				 textField_2.setText(null);
				 textField_3.setText(null);
				 textField_4.setText(null);
				 textField_5.setText(null);
				 textArea.setText(null);
				 btnUpdate.setEnabled(true);
				    btnDelete.setEnabled(true);
				}
				else
				{
					textField_5.setText(null);
					JOptionPane.showMessageDialog(null, "Invalid Date Format.");
				}
				
			}
		});
		btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdate.setEnabled(false);
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUpdate.setBounds(410, 147, 96, 33);
		frame.getContentPane().add(btnUpdate);

		
		
		
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String gender=null;	
				boolean sms=func.checkBorid(textField.getText());	
					if(sms==true)
					{
						textField.setEditable(false);
						ArrayList list=new ArrayList();
						list=func.searchStudent(textField.getText());
						Iterator it=list.iterator();
						while(it.hasNext())
			    		{
			    			DataMembers b=(DataMembers)it.next();
			    			textField_1.setText(b.getName());
			    			textField_2.setText(b.getCourse());
			    			textField_3.setText(b.getBranch());
			    			textField_4.setText(b.getCno());
			    			textField_5.setText(b.getDate1());
			    			textArea.setText(b.getAddress());
			    			gender=b.getGender();
			    			
			    			if(gender.equals("Male"))
			    			{
			    				rdbtnMale.setSelected(true);
			    			}
			    			else
			    			{
			    				rdbtnFemale.setSelected(true);
			    			}
			    		}
						
						btnUpdate.setEnabled(true);
						btnDelete.setEnabled(true);
						
						
						
					}
					else
						{
						JOptionPane.showMessageDialog(null, "Invalid ID");
						
					    textField.setText(null);
				}

				
				
				
				
				
			}
		});
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(127, 59, 86, 32);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setBounds(127, 109, 205, 32);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_2.setColumns(10);
		textField_2.setBounds(127, 158, 80, 32);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_3.setColumns(10);
		textField_3.setBounds(289, 158, 69, 32);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_4.setColumns(10);
		textField_4.setBounds(130, 213, 145, 32);
		frame.getContentPane().add(textField_4);
		
				
		 btnGo = new JButton("Go");
		btnGo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			String gender=null;	
			boolean sms=func.checkBorid(textField.getText());	
				if(sms==true)
				{
				
					textField.setEditable(false);
					ArrayList list=new ArrayList();
					list=func.searchStudent(textField.getText());
					
					Iterator it=list.iterator();
					while(it.hasNext())
		    		{
		    			DataMembers b=(DataMembers)it.next();
		    			textField_1.setText(b.getName());
		    			textField_2.setText(b.getCourse());
		    			textField_3.setText(b.getBranch());
		    			textField_4.setText(b.getCno());
		    			textArea.setText(b.getAddress());
		    			textField_5.setText(b.getDate1());
		    			
		    			gender=b.getGender();
		    			
		    			if(gender.equals("Male"))
		    			{
		    				rdbtnMale.setSelected(true);
		    			}
		    			else
		    			{
		    				rdbtnFemale.setSelected(true);
		    			}
		    		}
					
					btnUpdate.setEnabled(true);
					btnDelete.setEnabled(true);
					
					
					
				}
				else
					{
					JOptionPane.showMessageDialog(null, "Invalid ID");
					
				    textField.setText(null);
			}}
		});
		
		JLabel lblIdExpiryDate = new JLabel("ID Expiry Date");
		lblIdExpiryDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdExpiryDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIdExpiryDate.setBounds(-14, 341, 161, 24);
		frame.getContentPane().add(lblIdExpiryDate);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_5.setColumns(10);
		textField_5.setBounds(130, 338, 145, 32);
		frame.getContentPane().add(textField_5);
		btnGo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnGo.setBounds(242, 65, 56, 23);
		frame.getContentPane().add(btnGo);
		
		JLabel lblYyyymmdd = new JLabel("(YYYY-MM-DD)");
		lblYyyymmdd.setBounds(303, 346, 116, 16);
		frame.getContentPane().add(lblYyyymmdd);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(UpDeStudent.class.getResource("/ldbms/6.jpg")));
		lblNewLabel.setBounds(0, 0, 669, 401);
		frame.getContentPane().add(lblNewLabel);
	}
}
