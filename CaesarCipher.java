import java.util.*;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("Welcome to Caesar Cipher Generator!");

        while (true) {
            while (true){
                System.out.println("\nOptions:\n1. Encrypt\n2. Decrypt\n3. Exit");
                System.out.print("\nEnter your choice: ");
                choice = sc.nextInt();
                sc.nextLine();
                if (choice == 1 || choice == 2 || choice == 3){
                    break;
                }
            }

            if (choice == 1) {
                System.out.print("\nEnter text to encrypt: ");
                String text = sc.nextLine();
                System.out.print("Enter shift key: ");
                int key = sc.nextInt();
                sc.nextLine();
                String encrypted = encrypt(text, key);
                System.out.println("Encrypted Text: " + encrypted);
            } else if (choice == 2) {
                System.out.print("\nEnter text to decrypt: ");
                String text = sc.nextLine();
                System.out.print("Enter shift key: ");
                int key = sc.nextInt();
                sc.nextLine();
                String decrypted = decrypt(text, key);
                System.out.println("Decrypted Text: " + decrypted);
            } else if (choice == 3) {
                System.out.println("Exiting ");
                break;
            } else {
                System.out.println("Invalid choice, enter again.");
            }
        }
        sc.close();
    }

    public static String encrypt(String text, int key) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) ('A' + (ch - 'A' + key) % 26);
            } else if (ch >= 'a' && ch <= 'z') {
                ch = (char) ('a' + (ch - 'a' + key) % 26);
            }
            result += ch;
        }
        return result;
    }

    public static String decrypt(String text, int key) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) ('A' + (ch - 'A' - key + 26) % 26);
            } else if (ch >= 'a' && ch <= 'z') {
                ch = (char) ('a' + (ch - 'a' - key + 26) % 26);
            }
            result += ch;
        }
        return result;
    }
}
