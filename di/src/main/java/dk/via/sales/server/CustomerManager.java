package dk.via.sales.server;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

import dk.via.sales.model.Customer;
import dk.via.sales.model.Money;

public interface CustomerManager {
	Money getTotalAmountForCustomer(Customer customer) throws RemoteException;

	List<Customer> getCustomers() throws RemoteException;

	Customer getCustomerByEmail(String email) throws RemoteException;

	void createCustomer(Customer customer) throws RemoteException;

	void updateCustomer(Customer customer) throws RemoteException;

	void deleteCustomer(Customer customer) throws RemoteException;
}