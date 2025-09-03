public class Book {
    private String title;
    private String author;
    private int totalPages;
    private int pagesRead;

    public Book(String title, String author, int totalPages) {
        this.title = title;
        this.author = author;
        this.totalPages = totalPages;
        this.pagesRead = 0;
    }

    public Book(String title, String author, int totalPages, int pagesRead) {
        this.title = title;
        this.author = author;
        this.totalPages = totalPages;
        this.pagesRead = pagesRead;
    }

    public void update(int pages) {
        if (pagesRead + pages <= totalPages) {
            pagesRead += pages;
        } else {
            pagesRead = totalPages;
        }
    }

    public int getPercent() {
        return (pagesRead * 100) / totalPages;
    }

    public int getRemain() {
        return totalPages - pagesRead;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getRead() { return pagesRead; }
    public int getTotal() { return totalPages; }

    public String toString() {
        return title + " by " + author +
               "\nRead: " + pagesRead + "/" + totalPages +
               "\nProgress: " + getPercent() + "%" +
               "\nRemaining: " + getRemain();
    }
}
