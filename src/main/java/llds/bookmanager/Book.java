package llds.bookmanager;

public class Book {
    String bookName;
    String genres;
    Integer rating;

    public Book(String bookName, String genres, Integer rating) {
        this.bookName = bookName;
        this.genres = genres;
        this.rating = rating;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
