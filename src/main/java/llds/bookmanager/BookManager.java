package llds.bookmanager;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * List of books, list of Genre of books and book ratings was given, all list were of equal length.
 * book[], genre[], rating[] of equal length n
 *
 * Now there were 2 methods which we need to implement,
 * 1. getHighestRatingBookByGenre("Genre_name") If same rating books then lexographical order
 * 2. updateBookRatingbyBookName("book_name", int rating)
 */
public class BookManager {
    static Map<String,Book> bookMap = new HashMap<>();
    public static void main(String[] args) {
        String[] books = {"Inferno", "Davinci", "Angels", "Shining", "Carrie"};
        String[] genres = {"Thriller", "Thriller", "Thriller", "Horror", "Horror"};
        int[] ratings = {9, 9, 7, 8, 9};
        bookMap.put("Inferno",new Book("Inferno","Thriller",9));
        bookMap.put("Davinci",new Book("Davinci","Thriller",9));
        bookMap.put("Angels",new Book("Angels","Thriller",7));
        bookMap.put("Shining",new Book("Shining","Horror",8));
        bookMap.put("Carrie",new Book("Carrie","Horror",9));
        System.out.println(getHighestRatingBookByGenre("Horror"));
        //update Rating
        updateBookRatingbyBookName("Shining",10);
        System.out.println(getHighestRatingBookByGenre("Horror"));
    }

    // 1. Get the highest-rated book by genre
    public static String getHighestRatingBookByGenre(String genreName) {
        Comparator<Book> comp = (a,b) -> a.getRating().compareTo(b.getRating());

        return bookMap.values().stream().filter(e -> e.getGenres().equals(genreName))
                .sorted(comp.reversed()).findFirst().get().getBookName();
    }
    // 2. Update rating by book name
    public static void updateBookRatingbyBookName(String bookName, int newRating) {
        bookMap.get(bookName).setRating(newRating);

    }
}
