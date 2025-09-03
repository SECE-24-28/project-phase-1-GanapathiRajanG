import java.io.*;
import java.util.*;

public class Manager {
    private List<Book> list;
    private static final String FOLDER = "books";

    public Manager() {
        list = load();
    }

    public void add(String t, String a, int p) {
        Book b = new Book(t, a, p);
        list.add(b);
        save(b);
        System.out.println("Book added!");
    }

    public void update(int i, int p) {
        if (i >= 0 && i < list.size()) {
            Book b = list.get(i);
            b.update(p);
            save(b);
            System.out.println("Updated!");
        } else {
            System.out.println("Invalid choice");
        }
    }

    public void view() {
        if (list.isEmpty()) {
            System.out.println("No books.");
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println("[" + (i+1) + "] " + list.get(i));
        }
    }

    public void show() {
        if (list.isEmpty()) {
            System.out.println("No books.");
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i+1) + ". " + list.get(i).getTitle());
        }
    }

    private void save(Book b) {
        try {
            File f = new File(FOLDER);
            if (!f.exists()) f.mkdir();
            String safe = b.getTitle().replaceAll("[^a-zA-Z0-9]", "_");
            File file = new File(f, "Book_" + safe + ".txt");
            try (PrintWriter w = new PrintWriter(new FileWriter(file))) {
                w.println(b.getTitle());
                w.println(b.getAuthor());
                w.println(b.getTotal());
                w.println(b.getRead());
            }
        } catch (IOException e) {
            System.out.println("Error saving");
        }
    }

    private List<Book> load() {
        List<Book> l = new ArrayList<>();
        File f = new File(FOLDER);
        if (!f.exists() || !f.isDirectory()) return l;
        File[] files = f.listFiles((d, n) -> n.endsWith(".txt"));
        if (files == null) return l;
        for (File file : files) {
            try (Scanner sc = new Scanner(file)) {
                String t = sc.nextLine();
                String a = sc.nextLine();
                int tot = Integer.parseInt(sc.nextLine());
                int r = Integer.parseInt(sc.nextLine());
                Book b = new Book(t, a, tot, r);
                l.add(b);
            } catch (Exception e) {
                System.out.println("Error loading " + file.getName());
            }
        }
        return l;
    }
}
