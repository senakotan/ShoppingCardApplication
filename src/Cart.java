import java.util.ArrayList;
import java.util.List;

public class Cart {

    private int id;
    private User user;
    private List<Product> productList;
    private String createdDate;

    public Cart(int id, User user) {
        this.id = id;
        this.user = user;
        this.productList = new ArrayList<>();
        this.createdDate = java.time.LocalDate.now().toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void addProduct(Product product) {
        int limit = (user instanceof PremiumUser) ? ((PremiumUser) user).getProductLimit() : ((StandardUser) user).getProductLimit();
        if (productList.size() < limit && user.getBalance() >= product.getPrice()) {
            productList.add(product);
            user.setBalance(user.getBalance() - product.getPrice());
            System.out.println(product.getName() + " added to cart...");
        } else if (user.getBalance() < product.getPrice()) {
            System.out.println("Insufficient balance...");
        } else {
            System.out.println("Product limit reached.");
        }
    }

    public void removeProduct(int productId) {
        Product toRemove = null;
        for (Product product : productList) {
            if (product.getId() == productId) {
                toRemove = product;
                break;
            }
        }
        if (toRemove != null) {
            productList.remove(toRemove);
            user.setBalance(user.getBalance() + toRemove.getPrice());
            System.out.println(toRemove.getName() + " removed from cart and refunded.");
        } else {
            System.out.println("Product not found in cart.");
        }
    }

    public void clearCart() {
        for (Product product : productList) {
            user.setBalance(user.getBalance() + product.getPrice());
        }
        productList.clear();
        System.out.println("Cart cleared. All products refunded.");
    }

    public double calculateTotalPrice() {
        double total = 0;
        for (Product product : productList) {
            total += product.getPrice();
        }
        if (user instanceof StandardUser) {
            total -= total * 0.20;
        } else if (user instanceof PremiumUser) {
            total -= total * 0.50;
        }
        return total;
    }

    public double calculateAveragePrice() {
        if (productList.isEmpty()) return 0;
        return calculateTotalPrice() / productList.size();
    }

    public void displayCartDetails() {
        System.out.println("Cart ID: " + id);
        System.out.println("User: " + user.getFirstName() + " " + user.getLastName());
        System.out.println("Date Created: " + createdDate);
        System.out.println("Products in Cart:");
        for (Product product : productList) {
            System.out.println("- " + product.getName() + " by " + product.getProducer() + " | Price: " + product.getPrice() + " | Category: " + product.getCategory());
        }
        System.out.println("Total Price (after discount): " + calculateTotalPrice());
        System.out.println("Average Product Price: " + calculateAveragePrice());
    }
}
