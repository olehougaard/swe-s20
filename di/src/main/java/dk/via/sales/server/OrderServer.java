package dk.via.sales.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import dk.via.sales.data.PersistenceImpl;
import dk.via.sales.model.Customer;
import dk.via.sales.model.Item;
import dk.via.sales.model.Money;
import dk.via.sales.model.Order;
import dk.via.sales.model.OrderLine;

public class OrderServer extends UnicastRemoteObject implements SalesModel {
	private static final long serialVersionUID = 1L;

	public OrderServer() throws RemoteException {
	}

	@Override
	public Money getTotalAmountForCustomer(Customer customer) throws RemoteException {
		try {
			List<Order> orders = PersistenceImpl.getInstance().getOrdersForCustomer(customer);
			if (orders.isEmpty() && PersistenceImpl.getInstance().getCustomerByEmail(customer.getEmail()) == null)
				throw new RemoteException("Unknown customer: " + customer.getEmail());
			Money total = Money.ZERO;
			for (Order order : orders) {
				total = total.add(order.getPrice());
			}
			return total;
		} catch (SQLException e) {
			throw new RemoteException(e.getMessage());
		}
	}

	@Override
	public List<Customer> getCustomers() throws RemoteException {
		try {
			return PersistenceImpl.getInstance().getCustomers();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RemoteException(e.getMessage(), e);
		}
	}

	@Override
	public Customer getCustomerByEmail(String email) throws RemoteException {
		try {
			return PersistenceImpl.getInstance().getCustomerByEmail(email);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RemoteException(e.getMessage(), e);
		}
	}

	@Override
	public void createCustomer(Customer customer) throws RemoteException {
		try {
			PersistenceImpl.getInstance().createCustomer(customer);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RemoteException(e.getMessage(), e);
		}
	}

	@Override
	public void updateCustomer(Customer customer) throws RemoteException {
		try {
			PersistenceImpl.getInstance().updateCustomer(customer);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RemoteException(e.getMessage(), e);
		}
	}

	@Override
	public void deleteCustomer(Customer customer) throws RemoteException {
		try {
			PersistenceImpl.getInstance().deleteCustomer(customer);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RemoteException(e.getMessage(), e);
		}
	}

	@Override
	public List<Order> getOrdersFor(Customer customer) throws RemoteException {
		try {
			return PersistenceImpl.getInstance().getOrdersForCustomer(customer);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RemoteException(e.getMessage(), e);
		}
	}

	@Override
	public Order createOrderForCustomer(Customer customer, String currency, Collection<OrderLine> lines)
			throws RemoteException {
		try {
			return PersistenceImpl.getInstance().createOrderForCustomer(customer, currency, lines);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RemoteException(e.getMessage(), e);
		}
	}
	
	@Override 
	public Item createItem(String name, Money price) throws RemoteException {
		try {
			return PersistenceImpl.getInstance().createItem(name, price);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RemoteException(e.getMessage(), e);
		}
	}

	@Override
	public List<Item> getItems() throws RemoteException {
		try {
			return PersistenceImpl.getInstance().getItems();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RemoteException(e.getMessage(), e);
		}
	}
}
