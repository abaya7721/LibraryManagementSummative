package learn.library.data.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Book {
    private String ISBN;
    private String title;
    private String author;
    private int year;
    private Category category;
    private int shelfNumber;
    private int position;

    private final ArrayList<String> messages = new ArrayList<>();

    public Book() {

    }

    public Book(String ISBN, String title, String author, int year, Category category, int shelfNumber, int position ) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.year = year;
        this.category = category;
        this.shelfNumber = shelfNumber;
        this.position = position;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getShelfNumber() {
        return shelfNumber;
    }

    public void setShelfNumber(int shelfNumber) {
        this.shelfNumber = shelfNumber;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }


    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    // for validation
    public List<String> getMessages() {
        return messages;
    }

    public boolean isSuccess() {
        return messages.isEmpty();
    }

    public void addErrorMessage(String message) {
        messages.add(message);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(ISBN, book.ISBN) && Objects.equals(title, book.title) && Objects.equals(author, book.author) && category == book.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ISBN, title, author, category);
    }
}
