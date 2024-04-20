package Lab4;


import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author Mariam
 */
public class User {
    private String name;
    private String email;
    private String username;
    private String password;
    private int phoneNo;
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
        switch(op)
        {
        case 2:
        {
            register();
            break;
        }
        default:
            login();
            break;
            //default is to login not to register
        }

    }

    public User(String email){
        register(email);
    }
    
    public void register(String email){
        this.email=email;
        accountNo++;
        username = "User" + Integer.toString(accountNo); //first user will be User1 and 2nd will be User2 and so on
        //we need to generate random password
        String pw="";
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@?$ ";
        Random r = new Random();
        for (int i=0;i<12;i++){
            int x= r.nextInt(63); //generates random integer between 0 and 63 excluding 63
            x++;
            String c = characters.substring(x-1, x); //obtains a random character
            pw = pw.concat(c);
        }
        this.password=pw;
        System.out.println(toString() + ", password: " + password);
    }
    
    public void register(){
        accountNo++;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter email address: ");
        this.email = input.next();
        System.out.println("Enter Name: ");
        this.name = input.next();
        System.out.println("Enter Username: ");
        this.username = input.next();
        System.out.println("Enter Password: ");
        this.password = input.next();
        System.out.println("Enter Phone number: ");
        setPhoneNo(input.nextInt());
        System.out.println("Enter Age: ");
        setAge(input.nextInt());
        System.out.println("Enter Address: ");
        this.address = input.next();
        System.out.println(toString());
    }
    
    public void login(){
        accountNo++;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter email address: ");
        String enteredEmail = input.next();
        System.out.println("Enter Password: ");
        String enteredPassword = input.next();
        
        if(enteredPassword!=this.getPassword()){
            System.out.println("Invalid Password, retry");
            if(error>=2){
                System.out.println(error+1+ " invalid attempts");
                try{
                    System.out.println("Please retry in a few seconds...");
                    Thread.sleep(3000);
                } 
                catch (InterruptedException e){
                    e.printStackTrace();
                }
                error++;
                //cooldown 
                login();
            } 
            error++;
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
    
    public void setName(String name){
        this.name = name;
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
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public int getAge(){
        return age;
    }
    
    public void setAge(int age){
        if(age<0 | age >100){
            System.out.println("Invalid age");
            System.out.println("Re enter the age: ");
            Scanner input = new Scanner(System.in);
            setAge(input.nextInt());
        } else {
            this.age = age;
        }
    }
    
    public String getAddress(){
        return address;
    }
    
    public void setAddress(String address){
        this.address = address;
    }

    public int getPhoneNo(){
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo){
        if(phoneNo<0){
            System.out.println("Invalid phone number");
            System.out.println("Re enter the phone number: ");
            Scanner input = new Scanner(System.in);
            setPhoneNo(input.nextInt());
        } else {
            this.phoneNo = phoneNo;
        }
    }

    public static int getAccountNo(){
            return accountNo;
    }
}



