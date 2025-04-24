
public class StandardUser extends User {

    private int productLimit;

    public StandardUser(int id, String firstName, String lastName, double balance) {
        super(id, firstName, lastName, balance);
        this.productLimit = 20;
    }

    public int getProductLimit() {
        return productLimit;
    }

    @Override
    public String toString() {
        return "Name: " + getFirstName() + " " + getLastName() + " Balance: " + getBalance();
    }
}
