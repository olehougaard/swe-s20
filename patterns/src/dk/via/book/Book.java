package dk.via.book;

import java.math.BigDecimal;

public class Book {
    private final String isbn;
    private final String[] authors;
    private final int pages;
    private final BigDecimal price;

    public Book(String isbn, String[] authors, int pages, BigDecimal price) {
        this.isbn = isbn;
        this.authors = authors;
        this.pages = pages;
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public String[] getAuthors() {
        return authors;
    }

    public int getPages() {
        return pages;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
