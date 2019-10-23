/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group5;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author irennanicole
 */
public class LibraryTest {
    
    //fields for testing
    Library collection;
    Book b;
     ArrayList<Book> bookList = new ArrayList<>();
     Book c;
    
    public LibraryTest() {
    }
    
    @Before
    public void setUp() {
        //initialize collection
        collection = new Library();
        //bookList = collection.getSortedArray();
        //clear existing contacts
        //ArrayList<Book> bookList = new ArrayList<>();
       // for (int i =0; i< bookList.size();i++) {
       //     collection.checkOut(b);
       // }
        //add one contact
        b = new Book("Textbook", "123");
        c = new Book ("Novel", "1234");
        //b = new Book("Test Book")
        //collection.checkIn(b);
    }

    /**
     * Test of checkIn method, of class Library.
     */
    @Test
    public void testCheckIn() {
         //test adding a new contact
         
    collection.checkIn(b);
    assertTrue(bookList.get(0).getTitle().equals("123"));
//        assertTrue(collection.checkIn(new Book("Novel", "wqwer")));
//        //test adding an existing contact
        assertFalse(bookList.get(0).getTitle().equals("321"));
        //test that the number of contacts is correct after adding
        int count = bookList.size();
        assertSame(count, 1);
//        //test that the file contains the correct entries
//        Library collection2 = new Library();
//        ArrayList<Book> bookList2 = new ArrayList<>();
//        collection.checkIn(b);
//        assertSame(bookList2.size(), 1);
        assertEquals(bookList.get(0), b);
    }

    /**
     * Test of checkOut method, of class Library.
     */
    @Test
    public void testCheckOut() {
        collection.checkIn(c);
        collection.checkOut(b);
        
        int count = bookList.size();
        assertSame(count, 1);
    }

    /**
     * Test of countBooks method, of class Library.
     */
    @Test
    public void testCountBooks() {
        Book magazine1 = new Book("Magazine", "1234");
        Book novel1 = new Book("Novel", "1234");
        Book textbook1 = new Book("textbook", "1234");
        
        //collection.countBooks();
        assertSame(collection.countBooks(), "Books in Library: " + 1 + " textbooks, "
                + 2 + " novels, and " + 1 + " magazines.");
    }

    /**
     * Test of update method, of class Library.
     */
    @Test
    public void testUpdate() {
        bookList.get(0).setTitle("booktest");
        collection.update();
        assertEquals(bookList.get(0).getTitle(), "booktest");
    }
    
}
