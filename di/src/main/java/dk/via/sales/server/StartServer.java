package dk.via.sales.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.DriverManager;

import dk.via.sales.data.PersistenceImpl;
import org.postgresql.Driver;

public class StartServer {
	public static void main(String[] args) throws Exception {
		DriverManager.registerDriver(new Driver());
		Registry registry = LocateRegistry.createRegistry(1099);
		registry.bind("dk.via.sales", new OrderServer(PersistenceImpl.getInstance()));
	}
}
