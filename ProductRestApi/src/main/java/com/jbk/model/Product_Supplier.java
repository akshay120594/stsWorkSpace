package com.jbk.model;

import com.jbk.entity.Product;

public class Product_Supplier {
	Product product;
	Supplier supplier;
	
	public Product_Supplier() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Product_Supplier(Product product, Supplier supplier) {
		super();
		this.product = product;
		this.supplier = supplier;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	@Override
	public String toString() {
		return "Product_Supplier [product=" + product + ", supplier=" + supplier + "]";
	}
	
	

}
