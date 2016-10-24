package demo;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by ZhenYu on 24/10/2016.
 */
public class BookDBAO {
    // get book details given the bookId
    // this method is dummy for now
    public BookDetails getBookDetails(String bookId) {
        // return dummy book for testing now
        return createDummyBook(bookId);
    }
    public List<BookDetails> getAllBookDetails() {
        // return dummy book for testing now
        ArrayList<BookDetails> arr = new ArrayList<BookDetails>();
        for(int i=0;i<2;i++) {
            BookDetails details = new BookDetails();
            details.setBookId(""+i);
            details.setDescription("Web "+i);
            details.setFirstName("Java"+i);
            details.setSurname("Expert"+i);
            details.setInventory(5+i);
            details.setOnSale(false);
            details.setPrice(5.9f+i);
            details.setTitle("Web components for developers "+i);
            details.setYear(2015+i);
            arr.add(details);
        }
        return arr;
    }

    // convenient method to create a dummy book detail
    // this method is meant for testing
    private BookDetails createDummyBook(String bookId) {
        BookDetails details = new BookDetails();
        details.setBookId(bookId);
        details.setDescription("Web components for developers talks about how web components can transfor the way you develop application for the web");
        details.setFirstName("Java");
        details.setSurname("Expert");
        details.setInventory(5);
        details.setOnSale(false);
        details.setPrice(5.9f);
        details.setTitle("Web components for developers");
        details.setYear(2015);
        return details;
    }
}
