package org.hocviencntt.transaction.jdbc.main;

import org.hocviencntt.transaction.jdbc.model.Address;
import org.hocviencntt.transaction.jdbc.model.Customer;
import org.hocviencntt.transaction.jdbc.service.CustomerManager;
import org.hocviencntt.transaction.jdbc.service.CustomerManagerImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransactionManagerMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring.xml");

		CustomerManager customerManager = (CustomerManager) ctx.getBean("customerManager",
				CustomerManagerImpl.class);

		Customer cust = createDummyCustomer();
		customerManager.createCustomer(cust);

		ctx.close();
	}

	private static Customer createDummyCustomer() {
		Customer customer = new Customer();
		customer.setId(2);
		customer.setName("Pankaj");
		Address address = new Address();
		address.setId(2);
		address.setCountry("India");
		// setting value more than 20 chars, so that SQLException occurs
		address.setAddress("Albany Dr, San Jose, CA 95129");
		customer.setAddress(address);
		return customer;
	}

}
