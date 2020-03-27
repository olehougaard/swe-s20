package dk.via.sales.server;

import dk.via.sales.data.SalesPersistence;
import dk.via.sales.model.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class OrderServer extends UnicastRemoteObject implements SalesModel {
	private static final long serialVersionUID = 1L;
	private SalesPersistence persistence;

	public OrderServer(SalesPersistence persistence) throws RemoteException {
		this.persistence = persistence;
	}

	@Override
	public Money getTotalAmountForCustomer(Customer customer) throws RemoteException {
		try {
			List<Order> orders = persistence.getOrdersForCustomer(customer);
			if (orders.isEmpty() && persistence.getCustomerByEmail(customer.getEmail()) == null)
				throw new RemoteException("Unknown customer: " + customer.getEmail());
			Money total = Money.ZERO;
			for (Order order : orders) {
				total = total.add(order.getPrice());
			}
			return total;
		} catch (SQLException e) {
			throw new RemoteException(e.getMessage(), e);
		}
	}

	@Override
	public List<Customer> getCustomers() throws RemoteException {
		try {
			return persistence.getCustomers();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RemoteException(e.getMessage(), e);
		}
	}

	@Override
	public Customer getCustomerByEmail(String email) throws RemoteException {
		try {
			return persistence.getCustomerByEmail(email);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RemoteException(e.getMessage(), e);
		}
	}

	@Override
	public void createCustomer(Customer customer) throws RemoteException {
		try {
			persistence.createCustomer(customer);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RemoteException(e.getMessage(), e);
		}
	}

	@Override
	public void updateCustomer(Customer customer) throws RemoteException {
		try {
			persistence.updateCustomer(customer);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RemoteException(e.getMessage(), e);
		}
	}

	@Override
	public void deleteCustomer(Customer customer) throws RemoteException {
		try {
			persistence.deleteCustomer(customer);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RemoteException(e.getMessage(), e);
		}
	}

	@Override
	public List<Order> getOrdersFor(Customer customer) throws RemoteException {
		try {
			return persistence.getOrdersForCustomer(customer);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RemoteException(e.getMessage(), e);
		}
	}

	@Override
	public Order createOrderForCustomer(Customer customer, String currency, Collection<OrderLine> lines)
			throws RemoteException {
		try {
			return persistence.createOrderForCustomer(customer, currency, lines);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RemoteException(e.getMessage(), e);
		}
	}
	
	@Override 
	public Item createItem(String name, Money price) throws RemoteException {
		try {
			return persistence.createItem(name, price);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RemoteException(e.getMessage(), e);
		}
	}

	@Override
	public List<Item> getItems() throws RemoteException {
		try {
			return persistence.getItems();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RemoteException(e.getMessage(), e);
		}
	}
}
