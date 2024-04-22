package Project;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.HashMap;


public abstract class User {
	private static final HashMap<String, String> users = new HashMap<>();
	private String name;
    private String email;
    private String username;
    private String password;
    private long phoneNo;
    private int age;
    private String address;
    private static int accountNo =0;
    public static int error=0;
    public User(){
        int op=0;
        Scanner input = new Scanner(System.in);
        System.out.println("Login or Register");
        String option=input.next();
        if(option.equalsIgnoreCase("Register")){
            op=2;
        }
        else if(option.equalsIgnoreCase("Login")){
            op=1;
        }
        switch(op)
        {
        case 2:
        {
            register();
            break;
        }
        case 1:
        {
        	login();
            break;
        }
            default:
            {
            	System.out.println("Invalid option");
            	System.exit(1);
            }
        }
    }
   
    public void register(){
        accountNo++;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter name: ");
        setName(input.next());
        System.out.println("Enter email address: ");
        setEmail(input.next());
        System.out.println("Enter Username: ");
        String enteredUsername= input.next();
        this.username = enteredUsername;
        System.out.println("Enter password: ");
        String enteredPassword = input.next();
        setPassword(enteredPassword);
        users.put(enteredUsername, enteredPassword);
        System.out.println("Enter phone number: ");
        setPhoneNo(input.nextLong());
        System.out.println("Enter age: ");
        setAge(input.nextInt());
        System.out.println("Enter Address: ");
        this.address = input.next();
        System.out.println(toString());
    }
    public void login(){
    	Scanner input = new Scanner(System.in);
    	System.out.print("Enter username: "); 
    	String username = input.next(); 
    	System.out.print("Enter password: "); 
    	String password = input.next(); 
    	if (users.containsKey(username)==false)
    	{
    		System.out.println("Username does not exist, retry");
        	login();
    	}
    	else if (users.containsKey(username) && users.get(username).equals(password)) {
    		System.out.println("Login successful!");
    	} 
    	else 
    	{
    	System.out.println("Invalid password, retry");
    	login();
    	}
    }
    @Override
    public String toString(){
        return "User information: Name: " + name + ", email: " + email + ", username: " + username + ", age: " + age + ", address: " + address + ", account number: " + accountNo + ", phone number: " + phoneNo ;
    }
  //setters and getters
    public String getName(){
        return name;
    }
    public void setName(String enteredName){
    	int errorName=0;
    	Scanner input = new Scanner(System.in);
    	try {
    		for(int i=1; i <= enteredName.length();i++)
    		{
    			if(enteredName.substring(i-1, i).matches(".*[0-9].*"))
    		{
            errorName=1;

        } 
   			
    	}
    		if(errorName==0)
    		{
    			this.name=enteredName;
    		}
    		else
    		{
    			System.out.println("Invalid name, retry:");
    			setName(input.next());
    		}
    	}
        catch (InputMismatchException e) {
        System.out.println("Invalid Name");
        System.exit(1);
    }
    
    }
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getUsername(){
        return username;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public String getPassword(){
        return password;
    }
    public void setPassword(String enteredPassword){
    	Scanner input = new Scanner(System.in);
    	if(enteredPassword.length()<8)
    	{
    		System.out.println("Password can't be less than 8 characters, retry: ");
    		setPassword(input.next());
    	}
    	else
    	{
            this.password = enteredPassword;
    	}

    }
    public int getAge(){
        return age;
    }
public void setAge(int age)throws IllegalArgumentException {
    	Scanner input = new Scanner(System.in);
    	try {          
            if (age<0 | age >100)
   	 	 {
   	 	 
   	     System.out.println("Invalid age, age must be an integer between 0 and 100, retry: ");
   	     setAge(input.nextInt());
   	 	 }
   		 else
   		 {
   			 this.age =  age;
   		 }

        } 
    	catch (InputMismatchException e) {
            System.out.println("Invalid age, age must be an integer between 0 and 100, retry: ");
            setAge(input.nextInt());
            }

    } 
public String getAddress(){
    return address;
}

public void setAddress(String address){
    this.address = address;
}

public long getPhoneNo(){
    return phoneNo;
}
public void setPhoneNo(long enteredphoneNo) {
	Scanner input = new Scanner(System.in);
	try {
    String phone = Long.toString(enteredphoneNo);
    if(phone.length()!=13 ){ //checks if number is not 11 digits
        System.out.println("Invalid phone number, phone number must be 13 digits, retry: ");
        setPhoneNo(input.nextLong());
        } 
    else {
        this.phoneNo = enteredphoneNo;
    }
	}
    catch (IllegalArgumentException e) {
    System.out.println("Invalid phone number, phone number must be 13 digits, retry: ");
    setPhoneNo(input.nextLong());
}
}
public static int getAccountNo(){
    return accountNo;
}
}


