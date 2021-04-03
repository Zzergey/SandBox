package ru.zinoviev.springcrudArrayList.DAO;

import org.springframework.stereotype.Component;
import ru.zinoviev.springcrudArrayList.models.Customer;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerDAO {

    private static int CUSTOMER_COUNT = 0;

    private final List<Customer> customers;

    {
        customers = new ArrayList<>();

        customers.add(new Customer(++CUSTOMER_COUNT, "Tim"));
        customers.add(new Customer(++CUSTOMER_COUNT, "Bob"));
        customers.add(new Customer(++CUSTOMER_COUNT, "Rob"));
        customers.add(new Customer(++CUSTOMER_COUNT, "Tom"));
    }

    public List<Customer> list() {
        return customers;
    }

    public Customer show(int id){
        return customers.stream().filter(Customer -> Customer.getId() == id).findAny().orElse(null);
    }

    public void save(Customer customer){
        customer.setId(++CUSTOMER_COUNT);
        customers.add(customer);
    }

    public void update(int id, Customer customer){
        Customer updatedCustomer = show(id);

        updatedCustomer.setName(customer.getName());
    }

    public void delete(int id){
        customers.removeIf(p -> p.getId() == id);
    }
}
