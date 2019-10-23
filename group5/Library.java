package group5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author group5
 * @version 12/2/2018
 */
public class Library implements Serializable {

    private final String FILENAME = "contacts.ser";
    private ArrayList<Book> bookList;
    
    /**
     * Default constructor.
     */
    public Library() {
        bookList = new ArrayList<>();
        readCollection();
        writeCollection();
    }

    /**
     *  Adds a book to the collection.
     *
     * @param the book object to add
     */
    public void checkIn(Book b) {
        bookList.add(b);
        writeCollection();

    }

    /**
     * Deletes a book from the collection.
     *
     * @param b the book object to delete.
     */
    public void checkOut(Book b) {
    
            bookList.remove(b);
            writeCollection();
        
    }

    /**
     * Provides access to the collection of books as a sorted array.
     *
     * @return the sorted array
     */
    public Book[] getSortedArray() {
        Collections.sort(bookList);
        return bookList.toArray(new Book[bookList.size()]);
    }
    
     /**
     * Private method to write collection to a file.
     *
     * @return true if saved, false if not
     */
    private boolean writeCollection() {
        boolean success = true;
        try (FileOutputStream fos = new FileOutputStream(FILENAME);
                ObjectOutputStream output = new ObjectOutputStream(fos)) {
            output.writeObject(bookList);
        } catch (Exception ex) {
            success = false;
        }
        return success;
    }
    
     /**
     * Private method to read collection from a file.
     *
     * @return true if read, false if not
     */
    private boolean readCollection() {
        boolean success = true;
        File file = new File(FILENAME);
        if (file.exists()) {
            try (FileInputStream fis = new FileInputStream(FILENAME);
                    ObjectInputStream input = new ObjectInputStream(fis)) {
                bookList = (ArrayList<Book>) input.readObject();
            } catch (Exception ex) {
                System.out.println("Cannot write to file:\n"
                        + ex.getMessage());
                success = false;
            }
        }
        return success;
    }

    /**
     * Private counts the number of textbook, novel and magazine have been check
     * in or check out.
     *
     * @return the number of the textbook, novel and magazine.
     */
    public String countBooks() {
        int textBooks = 0;
        int novels = 0;
        int magazines = 0;
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getType().equalsIgnoreCase("textbook")) {
                textBooks++;
                writeCollection();
            } else if (bookList.get(i).getType().equalsIgnoreCase("novel")) {
                novels++;
                writeCollection();
            } else if (bookList.get(i).getType().equalsIgnoreCase("magazine")) {
                magazines++;
                writeCollection();
            } else {
                System.out.print("Wrong type.");
            }
        }

        String result = "Books in Library: " + textBooks + " textbooks, "
                + novels + " novels, and " + magazines + " magazines.";
        return result;
    }

    /**
     *  Updates the stored collection.
     *
     */
    public void update() {
        writeCollection();
    }
}
