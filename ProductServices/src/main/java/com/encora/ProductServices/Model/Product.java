package com.encora.ProductServices.Model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;

@Entity
@Table(name="products")
public class Product {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    @Column(nullable = false)
    private String name;
 
    @DecimalMin(value = "0.0", message = "Price cannot be less than zero")
    private Double price;
 
    
    private int  quantity;
   
  
   
	public Product(Long id, String name,
			@DecimalMin(value = "0.0", message = "Price cannot be less than zero") Double price, int  quantity) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}



	public Product() {
		// TODO Auto-generated constructor stub
	}

	// Getters and setters
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public Double getPrice() {
        return price;
    }
 
    public void setPrice(Double price) {
        this.price = price;
    }

	public int  getQuantity() {
		return quantity;
	}

	public void setQuantity(int  quantity) {
		this.quantity = quantity;
	}
    
    
    
	
}
