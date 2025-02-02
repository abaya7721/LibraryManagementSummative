package learn.library.domain;

import learn.library.data.BookRepository;
import learn.library.data.DataAccessException;
import learn.library.data.model.Book;
import learn.library.data.model.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BookService {

    private BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> allBooks() throws DataAccessException {
            return repository.getAllBooks();
    }

    public List<Book> allBooksCategory(Category category) throws DataAccessException {
        ArrayList<Book> booksCategory = new ArrayList<>();

        for(Book book : repository.getAllBooks()) {
            if (book.getCategory() == category) {
                booksCategory.add(book);
            }
        }
        return booksCategory;
    }

    public Book addBook(Book book) throws DataAccessException {
        Book validatedBook = duplicateValidationCheck(book);
        if(!validatedBook.isSuccess()) {
            return validatedBook;
        }
        book = repository.addBook(book);
        return book;
    }

    public void removeBook(Book book) throws DataAccessException {
        String ISBN = null;
        for (Book loopingBook : allBooks()){
            if(book.getISBN().equals(loopingBook.getISBN())) {
                ISBN = book.getISBN();
            }
         }
        repository.removeBook(ISBN);
    }


    public Book validateBookEntry(Book book) {
        Book evaluateBook = new Book();

        if(book == null) {
            evaluateBook.addErrorMessage("Book cannot have empty values");
            return evaluateBook;
        }
        if(book.getISBN() == null || book.getISBN().trim().isEmpty()) {
            evaluateBook.addErrorMessage("ISBN is required.");
        }
        if(book.getShelfNumber() <= 0) {
            evaluateBook.addErrorMessage("Shelf number required");
        }
        if(book.getPosition() <= 0) {
            evaluateBook.addErrorMessage("Position number is required");
        }
        if(book.getAuthor() == null || book.getAuthor().trim().isEmpty()) {
            evaluateBook.addErrorMessage("Author is required");
        }
        if(book.getTitle() == null || book.getTitle().trim().isEmpty() ) {
            evaluateBook.addErrorMessage("Title is required");
        }
        return evaluateBook;
    }


    public Book duplicateValidationCheck(Book book) throws DataAccessException{
        Book bookCheck = validateBookEntry(book);
        for (Book validatingBook : repository.getAllBooks()) {
            if(book.equals(validatingBook)) {
                bookCheck.addErrorMessage("Cannot have duplicate book entry");
                return bookCheck;
            }
        }
        return bookCheck;
    }

}


