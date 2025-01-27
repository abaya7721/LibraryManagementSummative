package learn.library.data.model;

import java.util.Objects;

public class Book {
    private String ISBN;
    private String title;
    private String author;
    private Category category;
    private int shelfNumber;
    private int position;

    public Book(String ISBN, String title, String author, Category category, int shelfNumber, int position ) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.category = category;
        this.shelfNumber = shelfNumber;
        this.position = position;
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
