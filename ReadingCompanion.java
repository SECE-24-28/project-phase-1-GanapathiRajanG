import java.util.*;

public class ReadingCompanion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Manager m = new Manager();
        int ch;
        do {
            System.out.println("\n1. Add Book");
            System.out.println("2. Update Progress");
            System.out.println("3. View Books");
            System.out.println("4. Exit");
            System.out.print("Choice: ");
            ch = sc.nextInt();
            sc.nextLine();
            switch (ch) {
                case 1:
                    System.out.print("Title: ");
                    String t = sc.nextLine();
                    System.out.print("Author: ");
                    String a = sc.nextLine();
                    System.out.print("Total Pages: ");
                    int p = sc.nextInt();
                    m.add(t, a, p);
                    break;
                case 2:
                    m.show();
                    System.out.print("Select book: ");
                    int idx = sc.nextInt() - 1;
                    System.out.print("Pages read: ");
                    int pr = sc.nextInt();
                    m.update(idx, pr);
                    break;
                case 3:
                    m.view();
                    break;
                case 4:
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Invalid");
            }
        } while (ch != 4);
    }
}
