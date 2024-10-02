import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        printRooles(); // Печатает правила
        Scanner sc = new Scanner(System.in);

        int playerChoice = sc.nextInt();

        if (playerChoice == 0) { // Если игрок выберет 0 или 1, вызовется метод с основоной логикой игры
            System.out.println("You're playing on [0, 100] Difficulty with 7 tries");
            gameSection1(playerChoice);
        } else if (playerChoice == 1) {
            System.out.println("You're playing on [0, 1000] Difficulty with 10 tries");
            gameSection1(playerChoice);
        } else if(playerChoice == 2) {
            System.out.println("Goodbay!!!");
        }
    }
    public static void printRooles() {
        System.out.println("Choose your level:");
        System.out.println("\t0 - [0, 100] + 7 tries");
        System.out.println("\t1 - [0, 1000] + 10 tries");
        System.out.println("\t2 - Exit");
    }

    public static void gameSection1(int playerChoice) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int highGround = 0; // Верхняя граница
        int counter1 = 0; // Счетчик

        if(playerChoice == 0) { // Если игрок выбрал 0, то выбирается первый режим, при 1 - второй
            highGround = 100;
            counter1 = 7;
        } else if(playerChoice == 1) {
            highGround = 1000;
            counter1 = 10;
        }

        int lowGround = 0; // Нижняя граница


        int num = rand.nextInt(lowGround, highGround); // В этой переменной хранится загаданное число

        while (counter1 >= 0) { // Основной игровой цикл
            int playerNum = sc.nextInt();
            if (playerNum == num) {
                youWon();
                break;
            } else if (playerNum > num) {
                numIsGreater();
                System.out.println("You have " + counter1-- + " tries left");
            } else if (playerNum < num) {
                numIsLess();
                System.out.println("You have " + counter1-- + " tries left");
            }
            if (counter1 == -1) {
                youLoosed();
                break;
            }
        }



    }
    public static void youWon() { // Несколько методов для вывода фраз
        System.out.println("You Won!");
    }

    public static void numIsLess() {
        System.out.println("Number I guessed is less!");
    }

    public static void numIsGreater() {
        System.out.println("Number I guessed is greater!");
    }

    public static void youLoosed() {
        System.out.println("You Looser...");
    }
}