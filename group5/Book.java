package group5;

import java.io.Serializable;
import java.util.Objects;

/**
 * Data class representing the book.
 * 
 * @author group5
 * @version 12/2/2018
 */
public class Book implements Comparable<Book>, Serializable {
    
    //private fields
    private String type;
    private String title;
   
    /**
     * Full constructor.
     *
     * @param type the book's type
     * @param title the book's title
     */
    public Book(String type, String title) {
        this.type = type;
        this.title = title;
    }

    /**
     * Provides access to the book's type.
     *
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     * Provides access to the book's title.
     *
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * Allows the book's type to be set.
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Allows the book's title to be set.
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *  Creates a unique identifier for the book.
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.type);
        hash = 19 * hash + Objects.hashCode(this.title);
        return hash;
    }

    /**
     * Determines if one book has the same type and title as another.
     *
     * @param obj the other book
     * @return true if equal, false if not.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        return true;
    }

    /**
     * Provides a string representation of the book data.
     *
     * @return
     */
    @Override
    public String toString() {
        return  "type: " + type + ", title: " + title + " ";
    }

    /**
     * Compares this book campare to the other book
     *
     * @param o the other book
     * @return the book's title compare to the other one. 
     */
    @Override
    public int compareTo(Book o) {
        return this.title.compareTo(o.title);
    }

   

}
