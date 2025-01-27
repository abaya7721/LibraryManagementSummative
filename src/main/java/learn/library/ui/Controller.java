package learn.library.ui;

import learn.library.data.DataAccessException;
import learn.library.domain.BookService;

import java.util.List;

public class Controller {

    private final BookService service;
    private final View view;

    public Controller(BookService service, View view) {
        this.service = service;
        this.view = view;
    }

    public void run() {
        view.printHeader("Welcome to the Library Management System");

        try {
            runMenuLoop();
        } catch (DataAccessException ex) {
            view.printHeader("Error " + ex.getMessage());
        }

        view.printHeader("Goodbye");
    }

    private void runMenuLoop() throws DataAccessException {
        MenuOption option;
        do {
            option = view.displayMenu();
            switch (option) {
                case FIND_BY_CATEGORY:
                    view.printBooksByCategory(service.allBooksCategory(view.readCategory()));
                    break;
                case ADD_BOOK:
                    service.addBook(view.addBook());
                    break;
            }
        } while (option != MenuOption.EXIT);
    }






}
