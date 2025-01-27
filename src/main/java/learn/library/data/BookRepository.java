package learn.library.data;

import learn.library.data.model.Book;

import java.util.ArrayList;

public interface BookRepository{

    ArrayList<Book> getAllBooks()  throws DataAccessException;

    Book addBook()  throws DataAccessException;

    void removeBook(int shelf, int position)  throws DataAccessException;



}
