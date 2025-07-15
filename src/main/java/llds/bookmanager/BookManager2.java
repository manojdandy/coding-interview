package llds.bookmanager;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class BookManager2 {
    private Map<String, Book> namesToBook = new HashMap<>();
    private Map<String, TreeSet<Book>> generesToBook = new HashMap<>();

    public static void main(String[] args) {
        String[] books = {"Inferno", "Davinci", "Angels", "Shining", "Carrie"};
        String[] genres = {"Thriller", "Thriller", "Thriller", "Horror", "Horror"};
        int[] ratings = {9, 9, 7, 8, 9};
        BookManager2 manager = new BookManager2(books, genres, ratings);

        System.out.println(manager.getHighestRatingBookByGenre("Thriller")); // Davinci
        System.out.println(manager.getHighestRatingBookByGenre("Horror"));   // Carrie

        manager.updateBookRatingbyBookName("Inferno", 10);
        System.out.println(manager.getHighestRatingBookByGenre("Thriller")); // Inferno
    }

    private Comparator<Book> bookComparator = (b1, b2) -> {
        if (b1.getRating() != b2.getRating()) {
            return Integer.compare(b2.getRating(), b1.getRating());
        }
        return b1.getBookName().compareTo(b2.bookName);
    };

    public BookManager2(String[] books, String[] genres, int[] ratings) {
        for (int i = 0; i < books.length; i++) {
            Book newBook = new Book(books[i], genres[i], ratings[i]);
            namesToBook.put(newBook.getBookName(), newBook);
            TreeSet<Book> bookSet = generesToBook.getOrDefault(genres[i], new TreeSet<>(bookComparator));
            bookSet.add(newBook);
            generesToBook.put(newBook.getGenres(), bookSet);
        }
    }

    // 1. Get the highest-rated book by genre
    public String getHighestRatingBookByGenre(String genreName) {
        TreeSet<Book> books = generesToBook.get(genreName);
        if (books == null) {
            return null;
        }
        return books.first().getBookName();
    }

    // 2. Update rating by book name
    public void updateBookRatingbyBookName(String bookName, int newRating) {
        Book book = namesToBook.get(bookName);
        TreeSet<Book> bookTreeSet = generesToBook.get(book.getGenres());
        bookTreeSet.remove(book);
        book.setRating(newRating);
        bookTreeSet.add(book);
    }
}
