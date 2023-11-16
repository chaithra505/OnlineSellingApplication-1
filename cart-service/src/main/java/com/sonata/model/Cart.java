package com.sonata.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.sonata.dto.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart_details")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartId;

    private int totalItems;
    private double totalCost;
    

       List<Product> products = new ArrayList<>(); 

    private String user;
    private int user_id;
    private String product;
    
   

    public Cart() {
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
        
        
    }
    
    
    

    public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public void addProduct(Product product, int quantity) {
        // Check if the product is already in the cart
        Optional<Product> existingProduct = products.stream()
                .filter(p -> p.getpId() == product.getpId())
                .findFirst();

        if (existingProduct.isPresent()) {
            // If the product is already in the cart, update the quantity
            Product existing = existingProduct.get();
            existing.setQuantity(existing.getQuantity() + quantity);
        } else {
            // If the product is not in the cart, add it
            product.setQuantity(quantity);
            products.add(product);
        }

        // Update total items, total cost, or any other relevant cart details
        updateCartDetails();
    }

    private void updateCartDetails() {
        int totalItems = 0;
        double totalCost = 0.0;

        for (Product product : products) {

            totalItems += product.getQuantity();
            totalCost += product.getQuantity() * product.getPrice();
        }

        setTotalItems(totalItems);
        setTotalCost(totalCost);
    }
}


