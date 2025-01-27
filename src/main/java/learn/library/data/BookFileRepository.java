package learn.library.data;

import learn.library.data.model.Book;

import java.util.ArrayList;

import  java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class BookFileRepository implements BookRepository{
    private static final String DELIMITER = ",,,";
    private static final String DELIMITER_REPLACEMENT = "@@@";
    private final Path path;

    public BookFileRepository(String filePath) {
        this.path = Paths.get(filePath);
    }

    @Override
    public ArrayList<Book> getAllBooks() throws DataAccessException {
        List<Book> bookList = new ArrayList<>();
        try {
            for (String bookDataLine : Files.readAllLines(path)) {
                  bookList.add(stringToBook(bookDataLine));
            }
        } catch (IOException e) {
            throw new DataAccessException("Problem accessing file", e);
        }
        return null;
    }

    @Override
    public Book addBook() throws DataAccessException {
        return null;
    }

    @Override
    public void removeBook(int shelf, int position) throws DataAccessException {

    }

    public void updateBook(Book book) throws DataAccessException {

    }

    public Book stringToBook(String textLine){
        

        return null;
    }

    public void bookToString(Book book){

    }

}
