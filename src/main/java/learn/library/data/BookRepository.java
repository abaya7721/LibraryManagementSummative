package learn.library.data;

import learn.library.data.model.Book;

import java.util.ArrayList;

public interface BookRepository{

    ArrayList<Book> getAllBooks()  throws DataAccessException;

    Book addBook(Book book) throws DataAccessException;

    void removeBook(String ISBN)  throws DataAccessException;

    boolean updateBook(Book book) throws DataAccessException;

}
