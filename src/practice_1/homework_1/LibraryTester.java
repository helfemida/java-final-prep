package practice_1.homework_1;

import java.util.ArrayList;
import java.util.List;

public class LibraryTester {
    public static void main(String[] args) throws Exception {
        try {
            //Book book1 = new Book(" ", " ", 1, 2);
            //Book book2 = new Book("A", "C", -6, 2);
            Book book3 = new Book("B", "D", 1, 9);

            Library library = new Library();
            //library.addBooks(book1);

            //library.addBooks(book2);
            library.addBooks(book3);
            library.displayBooks();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}

class Book {
    private String title;
    private String author;
    private int pages;
    private float price;

    public Book(String title, String author, int pages, float price) throws ValueError {
        if (title.isEmpty() || author.isEmpty() || pages < 0 || price < 0) {
            throw new ValueError("Enter valid values");
        }
        if (title.trim().length() == 1 && title.contains("-")){
            throw new ValueError("Enter valid values");
        }
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.price = price;
    }

    public void setTitle(String title) throws ValueError {
        if (title.isEmpty()) throw new ValueError("birnarse");
        this.title = title;
    }

    public void setAuthor(String author) throws ValueError {
        if (author.isEmpty()) throw new ValueError("birnarse");
        this.author = author;
    }

    public void setPages(int pages) throws ValueError {
        if (pages < 0) throw new ValueError("birnarse");
        this.pages = pages;
    }

    public void setPrice(float price) throws ValueError {
        if (price < 0) throw new ValueError("birnarse");
        this.price = price;
    }

    public void displayInfo() {
        System.out.println("Title of book: " + title);
        System.out.println("Author: " + author);
        System.out.println("Pages: " + pages);
        System.out.println("Price: " + price);
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    public float getPrice() {
        return price;
    }
}

class Library {

    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }
    public void addBooks(Book book) {
        books.add(book);
    }
    public void displayBooks() throws EmptyLibraryError{
        if (books.isEmpty()) {
            throw new EmptyLibraryError("Library is empty. There are no books.");
        }
        for(Book book : books) {
            System.out.println("Title: " + book.getTitle() +
                    "\nAuthor: " + book.getAuthor() +
                    "\nPages: " + book.getPages() +
                    "\nPrice: " + book.getPrice());
        }
    }

}

class ValueError extends Exception {
    public ValueError(String message) {
        super(message);
    }
}

class EmptyLibraryError extends Exception{
    public EmptyLibraryError(String message) {
        super(message);
    }
}


