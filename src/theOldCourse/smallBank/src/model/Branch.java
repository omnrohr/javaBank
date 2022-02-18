package theOldCourse.smallBank.src.model;


import java.util.ArrayList;

public class Branch {
    private int id;
    private String name;
    private ArrayList<Customer> customers;

    public Branch(int id, String name) {
        this.id = id;
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public Branch(Branch source){
        this.id = source.id;
        this.name = source.name;
        this.customers = new ArrayList<>(source.customers);
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Customer> getCustomers() {
        return new ArrayList<>(customers);
    }

    private void setCustomer(int index, Customer customer) {
        this.customers.set(index, customer);
    }

    public boolean addCustomer(Customer customer){
        return customers.add(new Customer(customer));
    }

    public boolean removeCustomer(Customer customer){
        return customers.remove(customer);
    }

    @Override
    public String toString() {
        return  "id= " + id +
                "  name= " + name +
                "  customers= " + customers;
    }
}
