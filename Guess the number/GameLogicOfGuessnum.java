import java.util.Random;
import java.util.Scanner;
public class GameLogicOfGuessnum {
    static int gen_num() {


        Random random = new Random();  //here we are using the random class which pick a number randomly from the givin bound
        int num = random.nextInt(50); // providing the boundation of number
        return num;
    }
    static void guessNumber(){
        Scanner sc=new Scanner(System.in);
        int cnt=0;

        int gen = gen_num();  // calling the gen num funcation

        for(int i=5;i!=1;i++) {

            System.out.println("enter your number");

            int guess = sc.nextInt();



            if (guess == gen) {
                System.out.println("you guess it correctly,you won!");
                cnt++;
                break;
            } else if (guess > gen) {
                System.out.println("you entered a bigger number");

            } else if (guess < gen) {
                System.out.println("you enterd a smaller number");

            }
            System.out.println("attempts left="+i);
        }
        if(cnt==0) {
            System.out.println("you are fail");
 }

}}
