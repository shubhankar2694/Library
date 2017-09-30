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

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
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

public class DeleteCategory {

	private JDialog frmAddCategory;
	
    Functions func=new Functions();
    Statement stmt;
    Connection con;
    private JLabel lblName;
    private JComboBox comboBox;
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
					DeleteCategory window = new DeleteCategory();
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
	public DeleteCategory() {
		
		
	
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
		frmAddCategory.setTitle("Delete Category");
		frmAddCategory.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		 frmAddCategory.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("4.gif")));
		frmAddCategory.getContentPane().setLayout(null);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				int x=JOptionPane.showConfirmDialog(null, "Are you sure?","Delete",JOptionPane.YES_NO_OPTION);
				 if(x==0)
				     {
					 func.deleteCategory(comboBox.getSelectedItem().toString());
					 JOptionPane.showMessageDialog(null, "Category Deleted.");
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
				 
					
			        
				
			}
		});
		
		comboBox = new JComboBox();
		comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
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
		
		
		comboBox.setBounds(118, 39, 184, 20);
		frmAddCategory.getContentPane().add(comboBox);
		
        
		
		
		
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDelete.setBounds(160, 106, 86, 25);
		frmAddCategory.getContentPane().add(btnDelete);
		
		lblName = new JLabel("Category");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblName.setBounds(22, 25, 118, 44);
		frmAddCategory.getContentPane().add(lblName);
		

		
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(DeleteCategory.class.getResource("/ldbms/1.jpg")));
		lblNewLabel.setBounds(0, 0, 494, 229);
		frmAddCategory.getContentPane().add(lblNewLabel);
		
	}
}
