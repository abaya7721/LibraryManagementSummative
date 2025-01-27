package learn.library.ui;

public enum MenuOption {

    EXIT("Exit management system."),
    FIND_BY_CATEGORY("Find book by category."),
    ADD_BOOK("Add a new book."),
    REMOVE_BOOK("Remove a book");

    private String message;

    MenuOption(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

}
