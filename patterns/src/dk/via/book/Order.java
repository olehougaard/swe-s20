package dk.via.book;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Order {
    private final ArrayList<OrderLine> lines;

    public Order() {
        lines = new ArrayList<>();
    }

    public void add(Book book, int amount) {
        lines.add(new OrderLine(book, amount));
    }

    public void add(Book book) {
        add(book, 1);
    }

    public BigDecimal getTotal() {
        var total = BigDecimal.ZERO;
        for(OrderLine line: lines) {
            total = total.add(line.price());
        }
        return total;
    }
}
