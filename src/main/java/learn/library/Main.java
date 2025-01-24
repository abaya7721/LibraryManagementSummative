package learn.library;

public class Main {
    public static void main(String[] args) {


        /*
            /library
                /data
                    /model
                        Book.java -pojo storing info for a book
                        Category.java -enum for storing types of books(Fantasy, Thriller)
                    DataAccessException.java -custom exception thrown by repositories
                    BookRepository.java -interface defining CRUD operations for a book
                    BookFileRepository.java -implement the methods from BookRepository
                        ^ interacts with filesystem to read and write from text file

                /domain
                    BookService.java -validate user input before saving
                        validate(Book)

                /ui
                    View.java -handles all input/output operations
                    Controller.java -runs application, manages operations

                Main.java


        */
    }
}