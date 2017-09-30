package ldbms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;



public class Functions 
{

	    Scanner sc=new Scanner(System.in);
	    String driver="com.mysql.jdbc.Driver";
	    
	    String url2="jdbc:mysql://localhost:3306/library";
	    
	    String url1="jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
	    String user="root";
	    String pass="sms";
	    
		public Connection con=null;
		public Statement stmt=null;
		
		
		
	
		
		int flag;
		
		
		public void createDate()
		{
			try
			{
				cc2();
			
				stmt=con.createStatement();
				stmt.executeUpdate("create table validate (y date)");
				
				
				con.close();
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			
			
		}
		
		
		public boolean dateValid2(String d)
		{
			try
			{
				cc2();
			
				stmt=con.createStatement();
				
				stmt.executeUpdate("insert into validate (y) values ('"+d+"')");
				
				
				con.close();
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
				 return false;
			}
				 
			 return true; 			    
			   
		}
		
		
		
		
		
		
		public boolean dateValid(String d)
		{
			 Pattern pattern;
			 Matcher matcher;
			 
			  String exp= "((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])";
				  
			  
				  pattern = Pattern.compile(exp);
			  
				  
			  /**
			   * Validate date format with regular expression
			   * @param date date address for validation
			   * @return true valid date format, false invalid date format
			   */
			   
					  
			     matcher = pattern.matcher(d);

			     if(matcher.matches()){
						 
				 matcher.reset();
						  
				 if(matcher.find()){
				
			             String month = matcher.group(3);
				     String day = matcher.group(2);
				     int year = Integer.parseInt(matcher.group(1));
							 
				 //    JOptionPane.showMessageDialog(null, day+" "+month+" "+year);
				     
				     
				     if (day.equals("31") && 
					  (month.equals("4") || month .equals("6") || month.equals("9") ||
			                  month.equals("11") || month.equals("04") || month .equals("06") ||
			                  month.equals("09"))) {
						return false; // only 1,3,5,7,8,10,12 has 31 days
				     } else if (month.equals("2") || month.equals("02")) {
			                  //leap year
					  if(year % 4==0){
						  if(day.equals("30") || day.equals("31")){
							  return false;
						  }else{
							  return true;
						  }
					  }else{
					         if(day.equals("29")||day.equals("30")||day.equals("31")){
							  return false;
					         }else{
							  return true;
						  }
					  }
				      }else{				 
					return true;				 
				      }
				   }else{
			    	      return false;
				   }		  
			     }else{
				  return false;
			     }			    
			   
		}
		
		
		
		
		
		
		public void cc1()         //Creating Connection with jdbc
		{
			try
			{
				Class.forName(driver);
			
				con=DriverManager.getConnection(url1,user,pass);
			}
			catch(Exception e)
			{
				
				System.out.println(e.getMessage());
			}
	
		}
		
		public void cc2()         //Creating Connection with jdbc
		{
			try
			{
				Class.forName(driver);
			
				con=DriverManager.getConnection(url2,user,pass);
			}
			catch(Exception e)
			{
				
				System.out.println(e.getMessage());
			}
	
		}
		
			
		public void createTempTable(String user,String pass,String access)
		{
		   if(user.equals(access)==false)
		   {
			   access="normal";
		   }
			try
			{
				cc2();
			
				stmt=con.createStatement();
				stmt.executeUpdate("create table temp (username varchar(20),password varchar(20),access varchar(20))");
				stmt.executeUpdate("insert into  temp (username,password,access) values ('"+user+"','"+pass+"','"+access+"')");
				
				
				con.close();
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			
			
			
		}
		
		
		
		public ArrayList readTemp()       //password verification
		{
		  ArrayList list=new ArrayList();
		  
		  try
		  {   cc2();
			  stmt = con.createStatement();
			  ResultSet r=stmt.executeQuery("select * from temp ");
			  while(r.next())
			  {
				  DataMembers b=new DataMembers();
		     	    b.setUser(r.getString("username"));
		     	   b.setAccess(r.getString("access"));
		     		list.add(b);
			  }
		      con.close();
			  
		  }
		  catch(Exception e)
		  {
			  System.out.println(e.getMessage());
		  }
		return list;
		  
		}
		
		
		
		public void updateTemp(String user,String pass)
		{
			 try
			    {   
				 cc2();
									
				stmt=con.createStatement();
				stmt.executeUpdate("update temp set password='"+pass+"' where username='"+user+"'");
				con.close();
				
			 }
					
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}

		}	
		
		
		
		
		
		
        public void deleteTemp()
        {
        	try
			{
				cc2();
				stmt=con.createStatement();
				stmt.executeUpdate("drop table temp");
			
				
				
				con.close();
			}
			catch(Exception e)
			{
				System.out.println("hmm");
			}
			
			
        }
		
		public boolean checkUser(String user)                    //create user 
		{
			
			
			boolean sms=true;
			  
			  try
			  {   cc2();
				  stmt = con.createStatement();
				  ResultSet r=stmt.executeQuery("select *from login  where Username='"+user+"'");
				  sms=r.next();
			      con.close();
				  
			  }
			  catch(Exception e)
			  {
				  System.out.println(e.getMessage());
				  
			  }
			return sms;

		}
		
		
		
		
		
		
		public ArrayList getUser()       //password verification
		{
		  ArrayList list=new ArrayList();
		  String access="normal";
		  try
		  {   cc2();
			  stmt = con.createStatement();
			  ResultSet r=stmt.executeQuery("select Username from login where Access='"+access+"' ");
			  while(r.next())
			  {
				  DataMembers b=new DataMembers();
		     	    b.setUser(r.getString("Username"));
		     		list.add(b);
			  }
		      con.close();
			  
		  }
		  catch(Exception e)
		  {
			  System.out.println(e.getMessage());
		  }
		return list;
		  
		}
		
		
		  public void deleteUser(String user)
	        {
	        	try
				{
					cc2();
					stmt=con.createStatement();
					stmt.executeUpdate("delete from login where Username='"+user+"'");
				
					
					
					con.close();
				}
				catch(Exception e)
				{
					System.out.println("hmm");
				}
				
				
	        }
		
		  
		  
		  public void deleteIssue(String id)
	        {
	        	try
				{
					cc2();
					stmt=con.createStatement();
					stmt.executeUpdate("delete from issue where Bid='"+id+"'");
				
					
					
					con.close();
				}
				catch(Exception e)
				{
					System.out.println("hmm");
				}
				
				
	        }
		
		
		
		public boolean verifyPassword(String user,String pass)       //password verification
		{
		  boolean sms=true;
		  int x=0;
		  try
		  {   cc2();
			  stmt = con.createStatement();
			  ResultSet r=stmt.executeQuery("select *from login  where Username='"+user+"' and Password='"+pass+"'");
			  while(r.next())
			  {
				  x++;
				  DataMembers b=new DataMembers();
		     	    if(r.getString("Password").equals(pass)==true)
		     	    {
		     	    	sms=true;
		     	    }
		     	    else
		     	    	sms=false;
			  }
		      con.close();
			  
		  }
		  catch(Exception e)
		  {
			  System.out.println(e.getMessage());
			  
		  }
		  if(x==0)
		  {
			  sms=false;
		  }
		return sms;
		  
		}
		
	
		
		public void createPassword(String user,String pass,String access)           // create user
		{
			
			try
			{
				cc2();
				stmt=con.createStatement();
				
				stmt.executeUpdate("insert into login (Username,Password,Access) values ('"+user+"','"+pass+"','"+access+"')");
				
				
				con.close();
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			
			
			
		}
		
		
		
		
		public void updatePassword(String user,String pass)             //change password
		{
			 try
			    {   
				 cc2();
									
				stmt=con.createStatement();
				stmt.executeUpdate("update login set Password='"+pass+"' where username='"+user+"'");
				con.close();
				
			 }
					
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}

		}	
		
		
		
		
		
		
		
		public void createExtra1Table()
		{
			
			
				
				try
				{
					cc2();
					stmt=con.createStatement();
					stmt.executeUpdate("create table extra1 (x int)");
					
					con.close();
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
			}	
			
		
		
		
		public void genExtra1Table(int ch)
		{
		

			
			try
			{   cc2();
				stmt=con.createStatement();
			    stmt.executeUpdate("insert into extra1(x) values ('"+ch+"')");
				con.close();
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			
			
		}
			
		
		
		
		public int getExtra1Table()
		{ 
			int x=0;
			 
			 
			  
			  try
			  {    cc2();
				  stmt = con.createStatement();
				  ResultSet r=stmt.executeQuery("select count(*) from extra1");
				
				  while(r.next())
				  {
					x= r.getInt("count(*)");
				  }
				 
				 
				 con.close();
			  }
			  catch(Exception e)
			  {
				  System.out.println(e.getMessage());
			  }
			  
			  return x;
			
		}
		
		
			
		
		
		
	
			
		
		
		
		
		
		
		
		
		
		

		public void createExtra2Table()
		{
			
			
				
				try
				{
					cc2();
					stmt=con.createStatement();
					stmt.executeUpdate("create table extra2 (x int)");
					
					con.close();
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
			}	
			
		
		public void genExtra2Table(int ch)
		{

			try
			{    cc2();
				stmt=con.createStatement();
			    stmt.executeUpdate("insert into extra2(x) values ('"+ch+"')");
				con.close();
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			
		}
		
		public int getExtra2Table()
		{ 
			int x=0;
			  cc2();
			 
			  
			  try
			  {   cc2();
				  stmt = con.createStatement();
				  ResultSet r=stmt.executeQuery("select count(*) from extra2");
				
				  while(r.next())
				  {
					x= r.getInt("count(*)");
				  }
				 
				 
				 con.close();
			  }
			  catch(Exception e)
			  {
				  System.out.println(e.getMessage());
			  }
			  
			  return x;
			
		}
		

		
		
		
		
		
		public int createDatabase()
		{
			
			cc1();
			try 
			{
			String sql = "CREATE DATABASE library";
	        stmt = con.createStatement();
	        flag= stmt.executeUpdate(sql);
            con.close();
			}
			catch(Exception e)
			{
				//System.out.println(e.getMessage());
				flag=0;
			}
			
			return flag;
		}
		
		
	public void createLoginTable()
	{
		String user="admin";
		String access="admin";
		cc2();
		try
		{
			stmt=con.createStatement();
			stmt.executeUpdate("create table login (Username varchar(20) not null primary key,Password varchar(20),Access varchar(10))");
			stmt.executeUpdate("insert into login(Username,Password,Access) values ('"+user+"','"+user+"','"+access+"')");
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
		
	
	public void createBorrowerTable()
	{
		
		cc2();
		try
		{
			stmt=con.createStatement();
			stmt.executeUpdate("create table borrower (Boid varchar(20) not null  primary key,CRoll_No varchar(20),Name varchar(50),Course varchar(10),Branch varchar(10),Cno varchar(15) ,Address varchar(50),Gender varchar(10),Expiry_date date)");
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	
	public void createBookTable()
	{
		
		cc2();
		try
		{
			stmt=con.createStatement();
			stmt.executeUpdate("create table book (Bid varchar(20) not null primary key,Name varchar(50),Author varchar(30),Category varchar(30))");
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	
	
	public void createBookIssueTable()
	{
		
		cc2();
		try
		{
			stmt=con.createStatement();
			stmt.executeUpdate("create table issue (CRoll_No varchar(20),Boid varchar(10),Bid varchar(10) not null primary key,Book_Name varchar(50),Student_Name varchar(50),Issued_date date,Return_date date)");
		
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}


	
	
	public boolean alreadyIssued(String id)
	{
		
		  boolean sms=true;
		  
		  try
		  {   cc2();
			  stmt = con.createStatement();
			  ResultSet r=stmt.executeQuery("select *from issue  where Boid='"+id+"'");
			  sms=r.next();
		      con.close();
			  
		  }
		  catch(Exception e)
		  {
			  System.out.println(e.getMessage());
			  
		  }
		return sms;
		  
		}
	
	
	public boolean alreadyIssued1(String id)
	{
		
		  boolean sms=true;
		  
		  try
		  {   cc2();
			  stmt = con.createStatement();
			  ResultSet r=stmt.executeQuery("select *from issue  where CRoll_No='"+id+"'");
			  sms=r.next();
		      con.close();
			  
		  }
		  catch(Exception e)
		  {
			  System.out.println(e.getMessage());
			  
		  }
		return sms;
		  
		}
	
	public boolean alreadyIssued2(String id)
	{
		
		  boolean sms=true;
		  
		  try
		  {   cc2();
			  stmt = con.createStatement();
			  ResultSet r=stmt.executeQuery("select *from issue  where Bid='"+id+"'");
			  sms=r.next();
		      con.close();
			  
		  }
		  catch(Exception e)
		  {
			  System.out.println(e.getMessage());
			  
		  }
		return sms;
		  
		}
	
	
	
	
	public void createCategoryTable()
	{
	
		
		try
		{   cc2();
			stmt=con.createStatement();
			stmt.executeUpdate("create table category (Category varchar(20) not null primary key)");
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public void createBoridTable()
	{

		cc2();
		try
		{
			stmt=con.createStatement();
			stmt.executeUpdate("create table borid (id bigint)");
			stmt.executeUpdate("insert into borid(id) values ('0')");
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	

	
	public void createBokidTable()
	{

	
		try
		{   cc2();
			stmt=con.createStatement();
			stmt.executeUpdate("create table bokid (id bigint)");
			stmt.executeUpdate("insert into bokid(id) values ('0')");
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	
	
	
	
	public int generateBorid()
	{
		 
		  int ch=0;
		 int y=getExtra1Table();
		  try
		  {   cc2();
			  stmt = con.createStatement();
			  ResultSet r=stmt.executeQuery("select count(*) from borrower");
			
			  while(r.next())
			  {
				ch= r.getInt("count(*)");
			  }
			 
			 ch=ch+y+100;
			
			 con.close();
		  }
		  catch(Exception e)
		  {
			  System.out.println(e.getMessage());
		  }
		  
		  return ch;
					
		
	}
	
	
	public int generateBokid()
	{
		  
		  int ch=0;
		  int y=getExtra2Table();
		  try
		  {   cc2();
			  stmt = con.createStatement();
			  ResultSet r=stmt.executeQuery("select count(*) from book");
			
			  while(r.next())
			  {
				ch= r.getInt("count(*)");
			  }
			 
			 ch=ch+y+100;
			 con.close();
		  }
		  catch(Exception e)
		  {
			  System.out.println(e.getMessage());
		  }
		  
		  return ch;
					
		
	}

	public boolean checkBorid(String id)
	{   
		boolean sms=true;
		
		cc2();
		try
		{
			stmt=con.createStatement();
			ResultSet r=stmt.executeQuery("select CRoll_No from borrower where CRoll_No='"+id+"'");
			sms=r.next();
			con.close();
		}
		catch(Exception e1)
		{
			System.out.println(e1.getMessage());
		}
						
		return sms;
	}
	
	public boolean checkBorid1(String id)
	{   
		boolean sms=true;
		
		cc2();
		try
		{
			stmt=con.createStatement();
			ResultSet r=stmt.executeQuery("select * from borrower where Boid='"+id+"'");
			sms=r.next();
			con.close();
		}
		catch(Exception e1)
		{
			System.out.println(e1.getMessage());
		}
						
		return sms;
	}
	
	public boolean addStudent(String id,String rno,String name,String course,String branch,String cno,String address,String gender,String date)
	{
		try
		{
			
			
			cc2();
			
			stmt=con.createStatement();
			stmt.executeUpdate("insert into borrower(Boid,CRoll_No,Name,Course,Branch,Cno,Address,Gender,Expiry_date) values ('"+id+"','"+rno+"','"+name+"','"+course+"','"+branch+"','"+cno+"','"+address+"','"+gender+"','"+date+"')");
			
			con.close();
			
		}
		catch(Exception e1)
		{
			System.out.println(e1.getMessage());
			
			return false;
			
		}
		return true;
	}
	
	
		
		public ArrayList searchStudent(String id)                   //search students
		{
			
			ArrayList list=new ArrayList();
			try
			   {
				cc2();
			    stmt=con.createStatement();
			    ResultSet r=stmt.executeQuery("select *from borrower where CRoll_No='"+id+"' ");
		     	while(r.next())
		     	{
		     		DataMembers b=new DataMembers();
		     	    b.setId(r.getString("Boid"));
		     	    b.setAddress(r.getString("Address"));
		     	    b.setBranch(r.getString("Branch"));
		     	    b.setCno(r.getString("Cno"));
		     	    b.setCourse(r.getString("Course"));
		     	    b.setGender(r.getString("Gender"));
		     	    b.setName(r.getString("Name"));
		     	    b.setDate1(r.getString("Expiry_date"));
		     	    
		     	    
		     		list.add(b);
		     	}
		     	con.close();
			    }
			   	    
			
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			    
			 return list;
		}

		public ArrayList searchStudent1(String id)                   //search students
		{
			
			ArrayList list=new ArrayList();
			try
			   {
				cc2();
			    stmt=con.createStatement();
			    ResultSet r=stmt.executeQuery("select *from borrower where Boid='"+id+"' ");
		     	while(r.next())
		     	{
		     		DataMembers b=new DataMembers();
		     	    b.setId(r.getString("Boid"));
		     	    b.setAddress(r.getString("Address"));
		     	    b.setBranch(r.getString("Branch"));
		     	    b.setCno(r.getString("Cno"));
		     	    b.setCourse(r.getString("Course"));
		     	    b.setGender(r.getString("Gender"));
		     	    b.setName(r.getString("Name"));
		     	    b.setDate1(r.getString("Expiry_date"));
		     	    b.setAccess(r.getString("CRoll_No"));
		     	    
		     		list.add(b);
		     	}
		     	con.close();
			    }
			   	    
			
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			    
			 return list;
		}

			
		
		
	public void updateStudent(String id,String name,String course,String branch,String cno,String address,String gender,String date)
	{
		cc2();
		 try
		    {   
			
			
			stmt=con.createStatement();
			stmt.executeUpdate("update borrower set Name='"+name+"',Course='"+course+"',Branch='"+branch+"',Cno='"+cno+"',Address='"+address+"',Gender='"+gender+"',Expiry_date='"+date+"' where CRoll_No='"+id+"'");
			con.close();
			
		 }
				
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

	}
	
	public void deleteStudent(String id)
	{
		try
		{    
		    cc2();
			stmt=con.createStatement();
			stmt.executeUpdate("delete from borrower where CRoll_No='"+id+"'");
			con.close();
		    
		 
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
		
	
	
	
		public ArrayList searchCategory()                   //search students
		{
			
			ArrayList list=new ArrayList();
			try
			   {
				cc2();
			    stmt=con.createStatement();
			    ResultSet r=stmt.executeQuery("select *from category ");
		     	while(r.next())
		     	{
		     		DataMembers b=new DataMembers();
		     	    b.setCategory(r.getString("Category"));
		     	    
		     	    
		     		list.add(b);
		     	}
		     	con.close();
			    }
			   	    
			
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			    
			 return list;
		}
		
	
		
		public int addCategory(String category)
		{
			try
			{
				
				
				cc2();
				
				stmt=con.createStatement();
				stmt.executeUpdate("insert into category(Category) values ('"+category+"')");
				
				con.close();
				
			}
			catch(Exception e1)
			{
				JOptionPane.showMessageDialog(null, "Data Limit Exceeds.Maximum 20 characters.");
				
				
				System.out.println(e1.getMessage());
				return 0;
			}
			return 1;
		}
		
		public void deleteCategory(String category)
		{
			try
			{
				
				
				cc2();
				
				stmt=con.createStatement();
				stmt.executeUpdate("delete from category where Category='"+category+"'");
				
				con.close();
				
			}
			catch(Exception e1)
			{
				
				System.out.println(e1.getMessage());
				
			}
			
		}
		
		
		
		public void addBook(String id,String name,String author,String category)
		{
			try
			{
				
				
				cc2();
				
				stmt=con.createStatement();
				stmt.executeUpdate("insert into book(Bid,Name,Author,Category) values ('"+id+"','"+name+"','"+author+"','"+category+"')");
				
				con.close();
				
			}
			catch(Exception e1)
			{
				System.out.println(e1.getMessage());
				
			}
		}	
		
		
		
		public boolean addIssuedBook(String id3,String id1,String id2,String name2,String name1,String date1,String date2)
		{
			try
			{
				
				
				cc2();
				
				stmt=con.createStatement();
				stmt.executeUpdate("insert into issue(CRoll_No,Boid,Bid,Book_Name,Student_Name,Issued_date,Return_date) values ('"+id3+"','"+id1+"','"+id2+"','"+name2+"','"+name1+"','"+date1+"','"+date2+"')");
				
				con.close();
				
			}
			catch(Exception e1)
			{
				System.out.println(e1.getMessage());
				return false;
			}
			return true;
		}	
		
		
		
		
		public boolean checkBokid(String id)
		{   
			boolean sms=true;
			
			
			try
			{
				cc2();
				stmt=con.createStatement();
				ResultSet r=stmt.executeQuery("select Bid from book where Bid='"+id+"'");
				sms=r.next();
				con.close();
			}
			catch(Exception e1)
			{
				System.out.println(e1.getMessage());
			}
							
			return sms;
		}
		
		
		
		public ResultSet searchIssuedBook(String id)                   //search students
		{
			
			ResultSet r=null;
			try
			   {
				cc2();
			    stmt=con.createStatement();
			     r=stmt.executeQuery("select *from issue where Boid='"+id+"' ");
			   
		     	con.close();
			    }
			   	    
			
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			 return r;   
			
		}

		
		
		
		
		
		
		
		
	
		
		
		public ArrayList searchBook(String id)                   //search students
		{
			
			ArrayList list=new ArrayList();
			try
			   {
				cc2();
			    stmt=con.createStatement();
			    ResultSet r=stmt.executeQuery("select *from book where Bid='"+id+"' ");
		     	while(r.next())
		     	{
		     		DataMembers b=new DataMembers();
		     	 
		     	    
		     	    b.setName(r.getString("Name"));
		     	    b.setAuthor(r.getString("Author"));
		     	    b.setCategory(r.getString("Category"));
		     	    
		     	    
		     		list.add(b);
		     	}
		     	con.close();
			    }
			   	    
			
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			    
			 return list;
		}

		
		
		public void updateBook(String id,String name,String author,String category)
		{
			 try
			    {   
				 cc2();
									
				stmt=con.createStatement();
				stmt.executeUpdate("update book set Name='"+name+"',Author='"+author+"',Category='"+category+"' where Bid='"+id+"'");
				con.close();
				
			 }
					
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}

		}	
		
		
	
		public void deleteBook(String id)
		{
			try
			{    
			    cc2();
				stmt=con.createStatement();
				stmt.executeUpdate("delete from book where Bid='"+id+"'");
				con.close();
			    
			 
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			
		}
		
		
		public void createPolicy()
		{
			int x=3;
		try
		{
			cc2();
		
			stmt=con.createStatement();
			stmt.executeUpdate("create table policy (x varchar(10))");
			stmt.executeUpdate("insert into  policy (x) values ('"+x+"')");
			
			
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		}
		
		
	
		
	public static void main(String args[])
	{   int x;
		Functions func=new Functions();
		x=func.createDatabase();
		if(x==1)
		{
		func.createLoginTable();
		func.createBorrowerTable();
		func.createBookTable();
		func.createCategoryTable();
		func.createBookIssueTable();
		func.createExtra1Table();
		func.createExtra2Table();
		func.createDate();
		func.createPolicy();
	//	func.createBoridTable();
	//	func.createBokidTable();
		}
		
	}
	
	
	
	
	
	
	
	
	
}
