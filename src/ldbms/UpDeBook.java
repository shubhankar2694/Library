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
import javax.swing.JComboBox;

public class UpDeBook {

	private JDialog frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	JButton btnUpdate;
	Functions func=new Functions();
	/**
	 * @wbp.nonvisual location=442,309
	 */
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
    JComboBox comboBox;
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
					UpDeBook window = new UpDeBook();
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
	public UpDeBook() {
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
		frame.setTitle("Update/ Delete Book");
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
		
		JLabel lblBranch = new JLabel("Author");
		lblBranch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBranch.setBounds(22, 166, 69, 14);
		frame.getContentPane().add(lblBranch);
		
		JLabel lblContactNo = new JLabel("Category");
		lblContactNo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContactNo.setBounds(22, 221, 96, 24);
		frame.getContentPane().add(lblContactNo);
		

		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				boolean sms=func.alreadyIssued2(textField.getText());
				if(sms==true)
				{
					JOptionPane.showMessageDialog(null, "Books are issued on this Roll No.Go to Book -> Search Issued books");
					textField.setText(null);
					textField_1.setText(null);
					textField_2.setText(null);
				}
				
				else{
				int x=JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?","Delete",JOptionPane.YES_NO_OPTION);
				if (x==0)
				{
				func.deleteBook(textField.getText());
				
				JOptionPane.showMessageDialog(null, "Data Deleted Successfully");
				    textField.setText(null);
					textField_1.setText(null);
					textField_2.setText(null);
					btnUpdate.setEnabled(true);
					btnDelete.setEnabled(true);
					
					int ch=1;
					
					func.genExtra2Table(ch);
					
				}	
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
				
				String id,name,author,category;
						
				id=textField.getText();
				name=textField_1.getText().toString();
				author=textField_2.getText();
				
				category=comboBox.getSelectedItem().toString();
				
				
				
				
				
				 func.updateBook(id,name,author,category);
				 JOptionPane.showMessageDialog(null, "Data Updated Successfully.");
				 textField.setText(null);
				 textField_1.setText(null);
				 textField_2.setText(null);
				 btnUpdate.setEnabled(true);
				 btnDelete.setEnabled(true);
				
				
				
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
				
				
				
				boolean sms=func.checkBokid(textField.getText());	
				if(sms==true)
				{
					
					ArrayList list=new ArrayList();
					list=func.searchBook(textField.getText());
					
					Iterator it=list.iterator();
					while(it.hasNext())
		    		{
		    			DataMembers b=(DataMembers)it.next();
		    			textField_1.setText(b.getName());
		    			textField_2.setText(b.getAuthor());
		    			refreshCategory();
		    			comboBox.setSelectedItem(b.getCategory());
		    			
		    			
		    			
		    			
		    			btnUpdate.setEnabled(true);
					    btnDelete.setEnabled(true);
		    		}
					
					
				}
				else
					{
					JOptionPane.showMessageDialog(null, "Invalid ID");
					
				    textField.setText(null);
			}	
				
				
				
			}
		});
		
	    comboBox = new JComboBox();
		comboBox.setBounds(130, 221, 180, 26);
		frame.getContentPane().add(comboBox);
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
		
				
		JButton btnGo = new JButton("Go");
		btnGo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			boolean sms=func.checkBokid(textField.getText());	
				if(sms==true)
				{
					
					ArrayList list=new ArrayList();
					list=func.searchBook(textField.getText());
					
					Iterator it=list.iterator();
					while(it.hasNext())
		    		{
		    			DataMembers b=(DataMembers)it.next();
		    			textField_1.setText(b.getName());
		    			textField_2.setText(b.getAuthor());
		    			refreshCategory();
		    			comboBox.setSelectedItem(b.getCategory());
		    			
		    			
		    			
		    			
		    			btnUpdate.setEnabled(true);
					    btnDelete.setEnabled(true);
		    		}
					
					
				}
				else
					{
					JOptionPane.showMessageDialog(null, "Invalid ID");
					
				    textField.setText(null);
			}}
		});
		btnGo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnGo.setBounds(242, 65, 56, 23);
		frame.getContentPane().add(btnGo);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(UpDeBook.class.getResource("/ldbms/6.jpg")));
		lblNewLabel.setBounds(0, 0, 669, 401);
		frame.getContentPane().add(lblNewLabel);
	}
}
