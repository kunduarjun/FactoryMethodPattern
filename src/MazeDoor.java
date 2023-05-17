
// Used to scan in user input for password attempts.
import java.util.Scanner;


// Abstract class for the Maze doors that all concrete maze doors will inherit from.
public abstract class MazeDoor {

    private String doorStatus; // Indicates whether a door is locked or openable.
    private int numericPassword; // Stores numeric password if it exists.
    private boolean hasNumericPassword; // Indicates whether numeric password exists.
    private String alphabeticalPassword; // Stores alphabetical password if it exists.
    private boolean hasAlphabeticalPassword; // Indicates whether alphabetical password exists.
    private String Quiz; // Stores the quiz riddle if it exists.
    private boolean hasQuiz; // Indicates if the quiz riddle exists.
    private String QuizResponse; // Stores the answer to the quiz riddle.

    // Protected Setters for private variables. Only used within subclass implementation.
    // In my implementation, you can only have, at most, one of a quiz, a numeric password, or an alphabetical password.
    // You may also choose to have a simple door that always remains openable.
    protected void setNumericPassword(int password){
        hasNumericPassword = true;
        numericPassword = password;
        hasAlphabeticalPassword = false;
        hasQuiz = false;
    }

    protected void setAlphabeticalPassword(String password){
        hasAlphabeticalPassword = true;
        alphabeticalPassword = password;
        hasNumericPassword = false;
        hasQuiz = false;
    }

    protected void setQuiz(String quiz, String quizResponse){
        hasQuiz = true;
        Quiz = quiz;
        QuizResponse = quizResponse;
        hasNumericPassword = false;
        hasAlphabeticalPassword = false;
    }

    // Action event to attempt to open door.
    public void openDoor(){
        if (doorStatus.equals("openable")){
            System.out.println("Door has been opened.");
        }
        else {System.out.println("It appears that this door can't be opened...");}
    }

    // Action event to attempt to unlock the door.
    public void unlock(){
        if (doorStatus.equals("locked")) {
            Scanner reader = new Scanner(System.in);
            System.out.println("Please enter in your guess at the password or your response to the associated quiz if applicable (Call showQuiz method to take a look at quiz if applicable):");

            if (hasNumericPassword) {
                int attempt = reader.nextInt();
                if (numericPassword == attempt) {
                    this.setDoorStatusOpenable();
                    System.out.println("Congratulations on guessing the numeric password, the door is now openable.");
                } else
                    System.out.println("The numeric password attempt is incorrect");
            }
            else if (hasAlphabeticalPassword) {
                String attempt = reader.nextLine();
                if (alphabeticalPassword.equals(attempt)) {
                    this.setDoorStatusOpenable();
                    System.out.println("Congratulations on guessing the alphabetical password, the door is now openable.");
                } else
                    System.out.println("The alphabetical password attempt is incorrect");
            }
            else if (hasQuiz) {
                String attempt = reader.nextLine();
                if (QuizResponse.equals(attempt)) {
                    this.setDoorStatusOpenable();
                    System.out.println("Congratulations on solving the quiz, the door is now openable. ");
                } else
                    System.out.println("Your response to the quiz was incorrect");
            }
        }
        else
            System.out.println("It appears the door is already openable");
    }

    // Quiz gets displayed to user through the system.
    public void showQuiz(){
        if (hasQuiz)
            System.out.println(Quiz);
        else
            System.out.println("It appears that there is no quiz on this door.");
    }

    // Protected setters for private variables. Only used within subclass implementation.
    protected void setDoorStatusOpenable(){
        this.doorStatus = "openable";
    }

    protected void setDoorStatusLocked(){
        this.doorStatus = "locked";
    }

    // Print whether a door is locked or openable.
    public void getDoorStatus(){
        System.out.println("This door is " + this.doorStatus + ".");
    }

    // If a door is password protected, this public method will return the (numeric or alphabetic) password.
    // This method doesn't have to exist if we want the user to find a different way to retrieve the password.
    // For simplicity, I just made this a public method in my design.
    public void getPassword(){
        if (hasNumericPassword){System.out.println("Password:" + numericPassword);}
        else if (hasAlphabeticalPassword) { System.out.println("Password: " + alphabeticalPassword);}
        else System.out.println("Password not applicable");
    }

}
