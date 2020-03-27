package dk.via.sales.server;

import dk.via.sales.data.SalesPersistence;
import dk.via.sales.model.*;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class SalesPersistenceFailureStub implements SalesPersistence {
    @Override
    public List<Customer> getCustomers() throws SQLException {
        throw new SQLException();
    }

    @Override
    public Customer getCustomerByEmail(String email) throws SQLException {
        throw new SQLException();
    }

    @Override
    public void createCustomer(Customer customer) throws SQLException {
        throw new SQLException();
    }

    @Override
    public void updateCustomer(Customer customer) throws SQLException {
        throw new SQLException();
    }

    @Override
    public void deleteCustomer(Customer customer) throws SQLException {
        throw new SQLException();
    }

    @Override
    public List<Order> getOrdersForCustomer(Customer customer) throws SQLException {
        throw new SQLException();
    }

    @Override
    public Order createOrderForCustomer(Customer customer, String currency, Collection<OrderLine> lines) throws SQLException {
        throw new SQLException();
    }

    @Override
    public Item createItem(String name, Money price) throws SQLException {
        throw new SQLException();
    }

    @Override
    public List<Item> getItems() throws SQLException {
        throw new SQLException();
    }
}
