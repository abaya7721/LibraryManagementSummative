package learn.library.ui;

import learn.library.data.model.Book;
import learn.library.data.model.Category;

import java.util.List;
import java.util.Scanner;

public class View {

    private Scanner scanner = new Scanner(System.in);

    public MenuOption displayMenu() {
        printHeader("Main Menu \n Book Management");

        MenuOption[] menu = MenuOption.values();
        for (int i = 0; i < menu.length; i++) {
            System.out.printf("%s. %s%n", i + 1, menu[i].getMessage());
        }

        String msg = String.format("Select [%s-%s]:", 1, menu.length);
        int value = readInt(msg, 1, menu.length);
        return menu[value - 1];
    }

    public void printHeader(String message) {
        System.out.println(message);
    }

    public void printBooksByCategory(List<Book> books) {
        printHeader(MenuOption.FIND_BY_CATEGORY.getMessage());

        if (books.isEmpty() || books == null) {
            System.out.println("No books were found.");
        } else {
            printHeader("Shelf  Pos  Year  Author       ISBN ") ;
            for (Book book : books) {
                System.out.printf("%s   %s   %s  %s  %s", book.getShelfNumber(), book.getPosition(), book.getYear(), book.getAuthor(), book.getISBN());
            }
        }
    }

    public Book addBook() {
        printHeader(MenuOption.ADD_BOOK.getMessage());
        Book newBook = new Book();

        newBook.setShelfNumber(readInt("Enter shelf number"));
        newBook.setPosition(readInt("Enter position number on shelf."));
        newBook.setYear(readInt("Enter book year."));
        newBook.setAuthor(readStringValid("Enter author."));
        newBook.setTitle("Enter title");
        newBook.setCategory(readCategory());
        newBook.setISBN(readStringValid("Enter ISBN e.g. 978-0451524935"));

        return newBook;
    }

    private String readString(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    private String readStringValid(String message) {
        String result;
        do {
            result = readString(message);
            if (result.trim().isEmpty()) {
                System.out.println("Value is required.");
            }
        } while (result.trim().isEmpty());
        return result;
    }


    private int readInt(String message) {
        int output = 0;
        boolean isValid = false;
        String input = null;

        do {
            try {
                input = readString(message);
                output = Integer.parseInt(input);
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.printf("Entered %s, is not valid", input);
            }
        } while (!isValid);

        return output;
    }

    private int readInt(String message, int min, int max) {
        int output;
        do {
            output = readInt(message);
            if (output < min || output > max) {
                System.out.printf("You selected %s. This is not valid.%n", output);
            }
        }
        while (output < min || output > max);
        return output;
    }

    public Category readCategory() {
        int index = 1;
        for (Category category : Category.values()) {
            System.out.printf("%s %s%n", index++, category);
        }
        index--;
        String message = String.format("Select Category [1 - %s]", index);
        return Category.values()[readInt(message, 1, index) - 1];
    }


}
