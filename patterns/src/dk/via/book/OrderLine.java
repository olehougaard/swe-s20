package dk.via.book;

import java.math.BigDecimal;

public class OrderLine {
    private final Book book;
    private final int amount;

    public OrderLine(Book book, int amount) {
        this.book = book;
        this.amount = amount;
    }

    public Book getBook() {
        return book;
    }

    public int getAmount() {
        return amount;
    }

    public BigDecimal price() {
        return book.getPrice().multiply(new BigDecimal(amount));
    }
}
