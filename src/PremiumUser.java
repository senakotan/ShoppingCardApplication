  
public class PremiumUser extends User {

    private int productLimit;

    public PremiumUser(int id, String firstName, String lastName, double balance) {
        super(id, firstName, lastName, balance);
        this.productLimit = 100;
    }

    public int getProductLimit() {
        return productLimit;
    }

    @Override
    public String toString() {
        return "ID: " + getId() + "  Balance: " + getBalance();
    }
}
