import java.sql.*;
import java.util.*;
public class Test
{
	Scanner sc= new Scanner(System.in);
	//load driver ands create connection
	public Connection getConnection()
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pritika","root","123456");
			return con;
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}

//insert record in database
	public  void insertRecord()
	{
		System.out.print("Enter employee id:");
		int eid=sc.nextInt();

		System.out.print("Enter employee name:");
		String ename=sc.next(); 

		System.out.print("Enter employee phone no:");
		int ephone = sc.nextInt();

		System.out.print("Enter employee email id:");
		String eemail=sc.next();

		System.out.print("Enter employee salary");
		int esalary=sc.nextInt();
	
		try{
				PreparedStatement ps = con.prepareStatement("insert into employee values(?,?,?,?,?)");
				ps.setInt(1,eid);
				ps.setString(2,ename);
				ps.setInt(3,ephone);
				ps.setString(4,eemail);
				ps.setInt(5,esalary);

				int x=ps.executeUpdate();
				if(x==1)
				{
					System.out.println("\t\t\t ****** Record inserted Successfully ******");
				}
			}catch(Exception e)
			{
				System.out.println(e);
			}
	}
	//update Database Record
	public void updateRecord()
	{
		try
		{
			Connection con=getConnection();
			System.out.print("Enter the employee id, whose record we want to update:");
			int emp_id = sc.nextInt();
			System.out.print("Enter the employee name:");
			String emp_name = sc.next();
			System.out.print("Enter the employee phone number:");
			int emp_phoneno = sc.nextInt();
			System.out.print("Enter the employee email id:");
			String emp_emailid = sc.next();	
			System.out.print("Enter the employee salary:");
			int emp_salary = sc.nextInt();
		
			PreparedStatement ps = con.prepareStatement("update employee set emp_name=?,emp_phoneno=?,emp_emailid=?,emp_salary=? where emp_id=?");
			ps.setInt(5,emp_id);
			ps.setString(1,emp_name);
			ps.setInt(2,emp_phoneno);
			ps.setString(3,emp_emailid);
			ps.setInt(4,emp_salary);
			ps.executeUpdate();		
		
			System.out.println("\t\t\t ****** Record Update ******");
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	//delete record from database
	public void deleteRecord()
	{
		try
		{
			Connection con=getConnection();
			System.out.print("Enter the no:");
			Integer emp_id = sc.nextInt();
	
			PreparedStatement ps = con.prepareStatement
								("delete from employee where emp_id=?");
			ps.setInt(1,emp_id);

			int x = ps.executeUpdate();	
			System.out.println("\t\t\t ****** Record delete :" + x );
			System.out.print(" ******");
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	//Find record in database by using where clause
	public void findRecord()
	{
		try
		{
			Connection con=getConnection();
			PreparedStatement ps = con.prepareStatement("select * from employee where emp_id= ? ");
			System.out.print("Enter the employee id,whose record we want to see:");
			int emp_id = sc.nextInt();
			ps.setInt(1,emp_id);

			ResultSet rs =ps.executeQuery();
			System.out.println("-----------------------------------------------------------------------------------------------------");
			System.out.println("emp_no\t\t emp_name\t\t emp_phoneno\t\t emp_emailid\t\t emp_salary ");
			System.out.println("-----------------------------------------------------------------------------------------------------");
		
			while(rs.next()==true)
			{
				int eid=rs.getInt(1);	
				String ename = rs.getString(2);
				int ephone = rs.getInt(3);
				String eemail = rs.getString(4);
				int esalary = rs.getInt(5);
	
				System.out.print(emp_id);
				System.out.print("\t\t");
				System.out.print(ename);
				System.out.print("\t\t");
				System.out.print(ephone);
				System.out.print("\t\t");
				System.out.print(eemail);
				System.out.print("\t\t");
				System.out.print(esalary);
				System.out.println(" /-");
				
			}	
			System.out.println("-----------------------------------------------------------------------------------------------------");
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	//find or print all record from table 
	public void findAllRecord()
	{
		try
		{
			Connection con=getConnection();
			Statement st = con.createStatement();

			ResultSet rs =st.executeQuery("select * from employee");
			System.out.println("-----------------------------------------------------------------------------------------------------");
			System.out.println("emp_no\t\t emp_name\t\t emp_phoneno\t\t emp_emailid\t\t emp_salary ");
			System.out.println("-----------------------------------------------------------------------------------------------------");
			while(rs.next()==true)
			{
				int eid = rs.getInt(1);
				String ename = rs.getString(2);
				int ephone = rs.getInt(3);
				String eemail = rs.getString(4);
				int esalary = rs.getInt(5);
	
				System.out.print(eid);
				System.out.print("\t\t");
				System.out.print(ename);
				System.out.print("\t\t");
				System.out.print(ephone);
				System.out.print("\t\t");
				System.out.print(eemail);
				System.out.print("\t\t");
				System.out.print(esalary);
				System.out.println(" /-");
				
			}
			System.out.println("-----------------------------------------------------------------------------------------------------");
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static void main(String[] args) throws Exception
	{		Scanner sc =new Scanner(System.in);
		while(true)
		{
			System.out.println("\n\t\t\t\t~~~---~~~ (: ` WeLcOmE ` :) ~~~---~~~");
			System.out.println("-----------------------------------------------------------------------------------------------------");
			System.out.println("\t\t\t\t******  EMPLOYEEE INFORMATION  ******");
			System.out.println("-----------------------------------------------------------------------------------------------------");
			System.out.println("\t\t\t1. Add Record ");
			System.out.println("\t\t\t2. Update Record");
			System.out.println("\t\t\t3. Delete Record");
			System.out.println("\t\t\t4. Find Record");
			System.out.println("\t\t\t5. Find All Record");
			System.out.println("\t\t\t6. Exit");
			System.out.print("Enter the Choice:");
			int choice = sc.nextInt();
			Test t =new Test();
	switch(choice)
	{
		case 1:
			t.insertRecord();
		break;
		
		case 2:
			t.updateRecord();
		break;	
	
		case 3:
			t.deleteRecord();
		break;
	
		case 4:
			t.findRecord();
		break;
	
		case 5:
			t.findAllRecord();
		break;
		
		case 6:
			System.out.println("\t\t\t ****** Thank u for visiting ******");
		break;
	}
	System.out.print("Do u want to continue:");
	String option = sc.next();
	if(option.equalsIgnoreCase("no"))
	{
		System.out.println("-----------------------------------------------------------------------------------------------------");
		System.out.println("\t\t\t\t******  \tEND\t  ******");
		System.out.println("-----------------------------------------------------------------------------------------------------");
			break;
	}		
}	
}
}