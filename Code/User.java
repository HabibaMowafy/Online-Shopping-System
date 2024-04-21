package Code;

import java.util.Scanner;
import java.util.InputMismatchException;
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
    private long phoneNo;
    private int age;
    private String address;
    private static int accountNo = 0;
    public static int error = 0;

    public User() {
        int op = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Login or Register");
        String option = input.next();
        if (option.equalsIgnoreCase("Register")) {
            op = 2;
        }
        switch (op) {
            case 2: {
                register();
                break;
            }
            case 1: {
                login();
                break;
            }
            default: {
                System.out.println("Invalid option");
                System.exit(1);
            }
        }
    }

    public User(String name, String email, String username, String password, long phoneNo, int age, String address) {
        accountNo++;
        setName(name);
        this.email = email;
        setUsername(username);
        setPassword(password);
        setPhoneNo(phoneNo);
        setAge(age);
        this.address = address;
        System.out.println(toString());
    }

    public User(String email, String name, long phoneNo, int age, String address) {
        setName(name);
        this.email = email;
        setUsername(username);
        setPhoneNo(phoneNo);
        setAge(age);
        this.address = address;
        accountNo++;
        username = "User" + Integer.toString(accountNo); // first user will be User1 and 2nd will be User2 and so on
        // we need to generate random password
        String pw = "";
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@?$ ";
        Random r = new Random();
        for (int i = 0; i < 12; i++) {
            int x = r.nextInt(63); // generates random integer between 0 and 63 excluding 63
            x++;
            String c = characters.substring(x - 1, x); // obtains a random character
            pw = pw.concat(c);
        }
        this.password = pw;
        System.out.println("Your password is: " + password);
        System.out.println(toString());
    }

    public void register() {
        accountNo++;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter name: ");
        setName(input.next());
        System.out.println("Enter email address: ");
        setEmail(input.next());
        System.out.println("Enter Username: ");
        this.username = input.next();
        System.out.println("Enter password: ");
        setPassword(input.next());
        System.out.println("Enter phone number: ");
        setPhoneNo(input.nextLong());
        System.out.println("Enter age: ");
        setAge(input.nextInt());
        System.out.println("Enter Address: ");
        this.address = input.next();
        System.out.println(toString());
    }

    public void login() {
        accountNo++;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter email address: ");
        String enteredEmail = input.next();
        System.out.println("Enter Password: ");
        String enteredPassword = input.next();

        if (enteredEmail == this.email && enteredPassword != this.getPassword()) {
            System.out.println("Invalid Password, retry");
            if (error >= 2) {
                System.out.println(error + 1 + " invalid attempts");
                System.out.println("Please retry...");
                error++;
                login();
            }
            error++;
            login();
        }
    }

    @Override
    public String toString() {
        return "User information: Name: " + name + ", email: " + email + ", username: " + username + ", age: " + age
                + ", address: " + address + ", account number: " + accountNo + ", phone number: " + phoneNo;
    }

    // setters and getters
    public String getName() {
        return name;
    }

    public void setName(String enteredName) {
        int errorName = 0;
        Scanner input = new Scanner(System.in);
        try {
            for (int i = 1; i <= enteredName.length(); i++) {
                if (enteredName.substring(i - 1, i).matches(".*[0-9].*")) {
                    errorName = 1;

                }

            }
            if (errorName == 0) {
                this.name = enteredName;
            } else {
                System.out.println("Invalid name, retry:");
                setName(input.next());
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid Name");
            System.exit(1);
        }

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String enteredPassword) {
        Scanner input = new Scanner(System.in);
        if (enteredPassword.length() < 8) {
            System.out.println("Password can't be less than 8 characters, retry: ");
            setPassword(input.next());
        } else {
            this.password = enteredPassword;
        }

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws IllegalArgumentException {
        Scanner input = new Scanner(System.in);
        try {
            if (age < 0 | age > 100) {

                System.out.println("Invalid age, age must be an integer between 0 and 100, retry: ");
                setAge(input.nextInt());
            } else {
                this.age = age;
            }

        } catch (InputMismatchException e) {
            System.out.println("Invalid age, age must be an integer between 0 and 100, retry: ");
            setAge(input.nextInt());
        }

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(long enteredphoneNo) throws IllegalArgumentException {
        Scanner input = new Scanner(System.in);
        try {
            String phone = Long.toString(enteredphoneNo);
            if (phone.length() != 11) { // checks if number is not 11 digits
                System.out.println("Invalid phone number, phone number must be 11 digit integer, retry: ");
                setPhoneNo(input.nextLong());
            } else {
                this.phoneNo = enteredphoneNo;
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid phone number, phone number must be 11 digit integer, retry: ");
            setPhoneNo(input.nextLong());
        }
    }

    public static int getAccountNo() {
        return accountNo;
    }
}
