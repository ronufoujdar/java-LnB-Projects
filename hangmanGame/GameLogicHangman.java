import java.util.*;
public class GameLogicHangman{
    static String[] animals={"dog","horse","rabbit","cat","deer","hippopotamus","lion","tiger","gorilla","monkey","giraffe","wolf","kangaroo","alligator","eel","jellyfish"};
    static int chances=1;

    static void position(int size,char[] ansArray)
    {   chances++;
        for(int i=0;i<size;i++)
        {
            // this loop is used for showing the position of input you have entered
            if(ansArray[i]!=0)
            {
                System.out.print(ansArray[i]+"  ");
            }
            else{
                System.out.print("_ " + "  ");

            }

        }
        System.out.print("      Chances left "+chances+"/"+(size+5) );
    }

    static int input(int size,char[] wordarray,char[] ansArray,int check){
        int k=1;                             //this method is used for taking input
        Scanner sc=new Scanner(System.in);
        while(k!=size+5)
        {


            System.out.print("Enter your guess :- ");
            char ans=sc.next().charAt(0);
            System.out.println("                                                                                            ");

            for(int i=0;i<size;i++)
            {
                if(wordarray[i]==ans )
                {
                    ansArray[i]=ans;    //this is used for inserting input in ans1 array
                    check++;


                }

            }
            position(size,ansArray);     //this method is used for giving the positions of the characters after input

            System.out.print("\n");

            if(check==size)
            {
                System.out.println("You won the game!!!! :-)");
                break;
            }
            k++;
        }
        return check;
    }
    static int genNum(){
        Random random=new Random();
        int genNum=random.nextInt(animals.length);  //this method is used for generating the random num for indexing of string
        return genNum;
    }

    static String getSt(){                       //with the random number return the rendom string
        String st=animals[genNum()];             // calling the genNum funcation
        return st;
    }

    static void intro(int size)                  // printing the (---)  on the position of the charaters
    {   System.out.println("\n  WELCOME TO HANGMAN WORLD  ");
        System.out.println("                                                                          ");
        System.out.println("Guess the animal name !!! ---->");

        for(int i=0;i<size;i++)
        {
            System.out.print("_ "+"  ");
        }
        System.out.println("");
    }
    static void start() {


        String word = getSt();        // calling the random string

        char[] ansArray;

        ansArray = new char[word.length()];     // providing the ans array the size of spelling

        int size = word.length();

        char[] wordarray = word.toCharArray();      // converting the word string into the array for comparing by indexing

        intro(size);                     // this method is calling the intro function

        int check = 0;

        check = input(size, wordarray, ansArray, check);   // calling the input method for input and also providing a check

        if (check != size) {
            System.out.println("Oh Nooo!!! You Lost, Better luck Next Time :-(");
        }
    }
}