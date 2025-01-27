package learn.library.data;

import learn.library.data.model.Book;
import learn.library.data.model.Category;

import java.util.ArrayList;

import  java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class BookFileRepository implements BookRepository{
    private static final String DELIMITER = "##";
    private final Path path;

    public BookFileRepository(String filePath) {
        this.path = Paths.get(filePath);
    }

    @Override
    public ArrayList<Book> getAllBooks() throws DataAccessException {
        ArrayList<Book> bookList = new ArrayList<>();
        try {
            for (String bookDataLine : Files.readAllLines(path)) {
                  bookList.add(stringToBook(bookDataLine));
            }
            return bookList;
        } catch (IOException e) {
            throw new DataAccessException("Problem accessing file", e);
        }
    }

    @Override
    public Book addBook(Book book) throws DataAccessException {
        List<Book> allBooks = getAllBooks();
        allBooks.add(book);

        //saveBooks(allBooks);
        // Returns book for validation in BookService
        return book;
    }

    @Override
    public void removeBook(String ISBN) throws DataAccessException {
        ArrayList<Book> books = getAllBooks();
        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) {
                books.remove(book);
                saveBooks(books);
            }
        }
    }

    @Override
    public boolean updateBook(Book book) throws DataAccessException {
        ArrayList<Book> books = getAllBooks();
        for (Book thisBook : books) {
            if (thisBook.getISBN().equals(book.getISBN())) {
                thisBook.setShelfNumber(book.getShelfNumber());
                thisBook.setPosition(book.getPosition());
                thisBook.setYear(book.getYear());
                thisBook.setAuthor(book.getAuthor());
                thisBook.setTitle(book.getTitle());
                thisBook.setCategory(book.getCategory());
                thisBook.setISBN(book.getISBN());
                return true;
            }
        }
        return false;
    }

    public Book stringToBook(String textLine){
        String [] bookFields = textLine.split(DELIMITER, -1);
        if (bookFields.length == 7) {
            Book book = new Book();
            book.setShelfNumber(Integer.parseInt(bookFields[0]));
            book.setPosition(Integer.parseInt(bookFields[1]));
            book.setYear(Integer.parseInt(bookFields[2]));
            book.setAuthor(bookFields[3]);
            book.setTitle(bookFields[4]);
            book.setCategory(Category.valueOf(bookFields[5]));
            book.setISBN(bookFields[6]);
            return book;
        }
        return null;
    }

    public String bookToString(Book book){
        return String.format("%s##%s##%s##%s##$s##%s##%s",
                book.getShelfNumber(),
                book.getPosition(),
                book.getYear(),
                book.getAuthor(),
                book.getCategory(),
                book.getISBN());
    }

    public void saveBooks(List<Book> books) throws DataAccessException{

        ArrayList<String> bookDataLines = new ArrayList<>();
        for (Book book : books) {
            bookDataLines.add(bookToString(book));
        }
        try{
            Files.write(path, bookDataLines);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
