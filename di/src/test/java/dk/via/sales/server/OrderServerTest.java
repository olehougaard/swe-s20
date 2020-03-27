package dk.via.sales.server;

import dk.via.sales.model.Customer;
import dk.via.sales.model.Item;
import dk.via.sales.model.Money;
import dk.via.sales.model.OrderLine;
import org.junit.Before;
import org.junit.Test;

import java.rmi.RemoteException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class OrderServerTest {
	private OrderServer orderServer;
	private Customer customer;

	@Before
	public void setUp() throws Exception {
		customer = new Customer("hello@example.com", "Hello World");
		SalesPersistenceStub stub = new SalesPersistenceStub();
		stub.createCustomer(customer);
		ArrayList<OrderLine> lines = new ArrayList<>();
		lines.add(new OrderLine(2, new Item(1, "Scissors", new Money(12, "USD"))));
		lines.add(new OrderLine(1, new Item(4, "Drill", new Money(82, "USD"))));
		stub.createOrderForCustomer(customer, "USD", lines);
		lines = new ArrayList<>();
		lines.add(new OrderLine(7, new Item(1, "Scissors", new Money(12, "USD"))));
		stub.createOrderForCustomer(customer, "USD", lines);
		orderServer = new OrderServer(stub);
		customer = orderServer.getCustomerByEmail("hello@example.com");
	}

	@Test
	public void totalForCustomerIsAddedCorrectly() throws Exception {
		assertEquals(new Money(190, "USD"), orderServer.getTotalAmountForCustomer(customer));
	}

	@Test(expected = RemoteException.class)
	public void totalForCustomerThrowsOnUnexpectedCustomer() throws Exception {
		orderServer.getTotalAmountForCustomer(new Customer("who?", "Not Here"));
	}

	@Test(expected = RemoteException.class)
	public void totalForCustomerThrowsRemoteExceptionOnSQLException() throws Exception {
		OrderServer server = new OrderServer(new SalesPersistenceFailureStub());
		server.getTotalAmountForCustomer(customer);
	}
}
