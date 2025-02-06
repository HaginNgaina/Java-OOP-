import java.util.Scanner;  

public class LoginSystem {  
    public static void main(String[] args) {  
        Scanner scanner = new Scanner(System.in);  
        
        // Define the correct username and password.  
        String correctUsername = "admin";  
        String correctPassword = "password123";  
        boolean loggedIn = false;  
        int attempts = 3; // Maximum attempts  
        
        // Loop for a maximum of 3 attempts  
        while (attempts > 0) {  
            System.out.print("Enter username: ");  
            String username = scanner.nextLine();  

            System.out.print("Enter password: ");  
            StringBuilder password = new StringBuilder();  
            char ch;  

            // Mask the input with asterisks  
            while (true) {  
                ch = scanner.nextLine().charAt(0);  
                if (ch == '\n') break; // Break on Enter key  
                
                password.append(ch); // Append the entered character  
                System.out.print("*"); // Print asterisk for each character  
            }  
            System.out.println(); // Move to the next line after password input  

            // Check if the username and password are correct  
            if (username.equals(correctUsername) && password.toString().equals(correctPassword)) {  
                loggedIn = true; // Set loggedIn to true on successful login  
                break; // Exit the loop  
            } else {  
                attempts--; // Decrement attempts remaining  
                System.out.println("Incorrect username or password. You have " + attempts + " attempts left.");  
            }  
        }  
        
        // Output result of login attempt  
        if (loggedIn) {  
            System.out.println("Login successful!");  
        } else {  
            System.out.println("Login failed. You are locked out.");  
        }  

        // Close scanner  
        scanner.close();  
    }  
}