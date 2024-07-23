import java.util.*; // Importing the entire java.util package for utility classes like Scanner

class Bot {
    public static void main(String[] args) {
        Bot b = new Bot(); // Creating an instance of the Bot class
        System.out.println("Bot : \nHow may I help you?\n\nYou : \n");
        
        Scanner sc = new Scanner(System.in); // Creating a Scanner object to read user input
        String cnv = sc.nextLine(); // Reading the user's input
        b.botchat(cnv); // Calling the botchat method with the user's input
        sc.close(); // Closing the Scanner object to free up resources
    }

    public void botchat(String cnn) {
        Scanner sc = new Scanner(System.in); // Creating a new Scanner object for further user input
        
        // Checking if the user's input contains "Hi" or the input itself (which is redundant)
        if (cnn.contains("Hi") || cnn.contains(cnn)) {
            System.out.println("\nBot : \nHey there! I'm your Bot. I can help with some functionalities.\n Would you like to know what are those?\n\nYou : ");
            String answr = sc.nextLine(); // Reading the user's response
            
            // Checking if the user wants to know the functionalities
            if (answr.equals("yes") || answr.equals("y")) {
                System.out.println("\n\nBot : \nGreat to hear!\n1. Open computer applications on your computer.\n2. Browse something.\n\nYou : ");
                answr = sc.nextLine(); // Reading the user's choice
            } else {
                System.out.println("Session closed");
            }
            
            // Checking if the user wants to open an application
            if (answr.contains("1") || answr.contains("open application")) {
                System.out.println("\n\nBot : \nEnter app name you want to open : \n\nYou : ");
                String n = sc.nextLine(); // Reading the application name
                openApp(n); // Calling the openApp method with the application name
                sc.close(); // Closing the Scanner object
            } else if (answr.contains("Browse") || answr.contains("2")) {
                System.out.println("Enter command : 'Browser'");
                String n = sc.nextLine(); // Reading the command
                System.out.println();
                openApp(n); // Calling the openApp method with the command
                System.out.println();
            }
        }
    }

    public void openApp(String name) {
        Scanner sc = new Scanner(System.in); // Creating a new Scanner object for further user input
        
        // Two-dimensional array to store application names and their file paths
        String[][] array = {
            {"Word", "Excel", "Powerpoint", "Onenote", "Browser"},
            {
                "C:\\Program Files\\Microsoft Office\\root\\Office16\\WINWORD.EXE",
                "C:\\Program Files\\Microsoft Office\\root\\Office16\\EXCEL.EXE",
                "C:\\Program Files\\Microsoft Office\\root\\Office16\\POWERPNT.EXE",
                "C:\\Program Files\\Microsoft Office\\root\\Office16\\ONENOTE.EXE",
                "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe"
            }
        };
        
        // Looping through the array to find the application name
        for (int j = 0; j < 5; j++) {
            if (name.equals(array[0][j])) { // Checking if the name matches an application
                if (array[0][j].equals("Browser")) { // Special case for the browser
                    System.out.println("Tell me what you need to explore?");
                    String find = sc.nextLine(); // Reading the search query
                    
                    try {
                        String url = "https://www.google.com/search?q=" + find;  
                        ProcessBuilder processBuilder = new ProcessBuilder(array[1][4], url); // Browser path and search URL as arguments
                        processBuilder.start(); // Opening the browser and searching
                        System.out.println(array[0][4] + " opened successfully!");
                    } catch (Exception e) {
                        System.err.println("Error opening: " + e.toString());
                    }
                    sc.close(); // Closing the Scanner object
                    break;
                } else {
                    try {
                        // Open application
                        ProcessBuilder processBuilder = new ProcessBuilder(array[1][j]);
                        processBuilder.start(); // Starting the application
                        System.out.println(array[0][j] + " opened successfully!\nSession closed!");
                    } catch (Exception e) {
                        System.err.println("Error opening: " + e.toString());
                    }
                }
            }
        }
    }
}
