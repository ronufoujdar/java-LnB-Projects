import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args)
    {

        Scanner sc =new Scanner(System.in);
        Random rc= new Random();
        System.out.println("Play rock ,paper ,scissor game");
        int human= sc.nextInt();
        if(human==1)
        {
            System.out.println("choose rock ");
        }
        if(human==2)
        {
            System.out.println("choose paper");
        }
        if(human==3)
        {
            System.out.println("choose scissor");
        }
        System.out.println("now computer turn");
        int computer= sc.nextInt();
        if(computer==1)
        {
            System.out.println("choose rock");
        }
        if(computer==2)
        {
            System.out.println("choose scissor");
        }
        if(computer==3)
        {
            System.out.println("choose paper");
        }
        if(human==computer)
        {
            System.out.println("match is draw");
        }
        else if (human==1&&computer==3||human==3&&computer==3||human==0&&computer==0)
        {
            System.out.println("you won the match");
        }
        else
        {
            System.out.println("better luck next time");
        }
    }
}