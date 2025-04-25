
# 🛒 Shopping App Project
Welcome to the Shopping App! This is an e-commerce application built using Java that simulates a basic shopping experience. Users can create accounts, add products to their cart, and purchase items while managing their balance and product limits. It features different types of users, such as Standard and Premium users, with varying product limits and discounts.

🎯 Features
User Types:

Standard User: Has a limited number of products they can purchase.

Premium User: Can purchase more products and gets a higher discount.

Products:

Users can view, add to cart, remove, and purchase products.

Each product has details such as name, price, and category.

Shopping Cart:

Users can manage their cart, view total price (with applicable discounts), and clear the cart.

Balance Management:

Each user has a balance, and the application ensures they have enough funds to make purchases.

Discount System:

Standard users get a 20% discount, while Premium users get a 50% discount on their total purchase.

💡 Technologies Used
Java (Object-Oriented Programming)

Collections Framework (for product management and user handling)

Console-based interface for interaction

🖥 Project Structure
User.java: The base class representing a user with basic information like ID, name, and balance.

StandardUser.java: A subclass of User, representing a standard user with specific limits on the number of products they can add to the cart.

PremiumUser.java: A subclass of User, representing a premium user with higher product limits and discounts.

Product.java: Represents a product in the shopping app, including its details such as name, price, and category.

Cart.java: Manages the user's shopping cart, including adding/removing products, calculating total price, and applying discounts.

🚀 How to Run
Clone the repository:

bash
Kopyala
Düzenle
git clone https://github.com/your-username/shopping-app.git
Navigate to the project folder.

Open and run the main Java file to start the shopping experience.

📌 Future Enhancements
Implement a Graphical User Interface (GUI) for a more user-friendly shopping experience using JavaFX or Swing.

Add additional features like order history or multiple payment options.

Include more product categories and a search function for products.
