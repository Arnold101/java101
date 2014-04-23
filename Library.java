import java.util.ArrayList;

public class Library {
    String address;
    ArrayList<Book> books;
    
    public Library (String address){
        this.address = address;
        books = new ArrayList<Book>();
    }    
    
    public void addBook(Book book_obj){
        books.add(book_obj);
    }

    public static void printOpeningHours(){
        System.out.println("Libraries are open daily form 9am to 5pm");
    }
    
    public void printAddress(){
        System.out.println(address);
    }
    
    public void borrowBook(String book_name){
        boolean available_flag = false;
        for (Book book: books){
            if ( book.title == book_name && !book.isBorrowed() ){
                book.rented();
                available_flag = true;
                System.out.println("Successfully borrow: " + book.title );
            }
        }
        
        if ( !available_flag ){
            System.out.println("Sorry, this book is not available");
        }
    }
    
    public void returnBook(String book_name){
        for (Book book: books){
            if (book.title == book_name){
                book.returned();
                System.out.println("Successfully return: " + book.title );
            }
        }
    }
    
    public void printAvailableBooks(){
        boolean available_flag = false;
        for (Book book: books){
            if ( !book.isBorrowed() ){
                System.out.println(book.title);
                available_flag = true;
            }
        }
        if ( !available_flag ){
            System.out.println("Sorry, no book is available");
        }
    }
    
    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
} 