import java.lang.Math.*;
import java.security.SecureRandom;
import java.util.Scanner;
import java.util.Random;

public class MathPractice
{

    public static void call_operation(int option, int rand1, int rand2){

        switch(option){
            case 1:
                System.out.printf("How much is %d plus %d?\n", rand1, rand2);
                break;
            case 2:
                System.out.printf("How much is %d times %d?\n", rand1, rand2);
                break;
            case 3:
                System.out.printf("How much is %d minus %d?\n", rand1, rand2);
                break;
            default:
                System.out.printf("How much is %d divided by %d?\n", rand1, rand2);
                break;
        }
    }

    public static double answer_operation(int option, int rand1, int rand2){
        Random rand = new Random();
        int random = rand.nextInt(4);
        random = random + 1;


        switch(option){
            case 1:
                call_operation(option, rand1, rand2);
                return (rand1 + rand2);
            case 2:
                call_operation(option, rand1, rand2);
                return (rand1 * rand2);
            case 3:
                call_operation(option, rand1, rand2);
                return (rand1 - rand2);
            case 4:
                call_operation(option,rand1, rand2);
                return ((double)rand1 / (double)rand2);
            default:
                return answer_operation(random, rand1, rand2);
        }
    }

    public static void choose_statement(int answer){
        // Answer is from i in random_Multiple 0 = right 1 = wrong
        Random rand = new Random();
        int random = rand.nextInt(4);
        String response;
        random = random + 1;


        switch(random){
            case 1:
                response = (answer == 0) ? "Very good!" : "No. Please try again.";
                break;
            case 2:
                response = (answer == 0) ? "Excellent!" : "Wrong. Try once more.";
                break;
            case 3:
                response = (answer == 0) ? "Nice work!" : "Don’t give up!";
                break;
            default:
                response = (answer == 0) ? "Keep up the good work!" : "No. Keep trying.";
                break;
        }
        System.out.println(response);
    }

    public static int random_Multiple(int difficulty, int option) {

        Scanner scnr = new Scanner(System.in);
        SecureRandom rand = new SecureRandom();

        int rand1 = rand.nextInt(((int)(Math.pow(10, difficulty)) - 1));
        int rand2 = rand.nextInt(((int)(Math.pow(10, difficulty)) - 1));
        rand1 = rand1 + 1;
        rand2 = rand2 + 1;
        double answer;
        double correct;
        int i = 1;


        // while (i == 1) {
        //System.out.printf("How much is %d times %d?\n", rand1, rand2);
        correct = answer_operation(option, rand1, rand2);
        answer = scnr.nextDouble();

        if ((Math.abs(answer - (correct))) < 0.001 ) {
            i = 0;
            choose_statement(i);
            return 1;
        }
        else {
            choose_statement(i);
            return 0;
        }
        // }
    }

    public static void main(String[] args) {
        // write your code here
        Scanner scnr = new Scanner(System.in);
        int i = 0;
        int num_right;
        int percentage;
        int difficulty = 0;
        int option = 0;
        int reset = 1;
        boolean reset_system = true;


        while (reset_system) {
            num_right = 0;
            percentage = 0;

            System.out.println("What difficulty level would you like? Please input 1 through 4. ");
            System.out.println("1 being the easiest and 4 being the hardest");
            difficulty = scnr.nextInt();
            if((difficulty < 1)||(difficulty > 4)){
                System.out.println("That is not a proper difficulty level, please input 1 through 4.");
                difficulty = scnr.nextInt();
            }

            System.out.println("What operation option would you like? Please input 1 through 5.");
            System.out.println("1 : addition, 2 : Multiplication, 3 : Subtraction, 4: Division, 5 : A mixture");
            option = scnr.nextInt();
            if((option < 1)||(option > 5)){
                System.out.println("That is not a proper difficulty level, please input 1 through 4.");
                option = scnr.nextInt();
            }

            for (i = 0; i < 10; i++) {
                num_right = num_right + random_Multiple(difficulty, option);
            }
            percentage = num_right * 10;
            System.out.printf("%d correct, %d incorrect\n",num_right, 10 - num_right);

            if (percentage > 75) {
                System.out.println("Congratulations, you are ready to go to the next level!");
            } else {
                System.out.println("Please ask your teacher for extra help.\n");
            }
            System.out.println("Would you like to begin another session? If yes input 1, for no input 0.");
            reset = scnr.nextInt();
            if(reset == 0) {
                reset_system = false;
            }
        }
    }
}

