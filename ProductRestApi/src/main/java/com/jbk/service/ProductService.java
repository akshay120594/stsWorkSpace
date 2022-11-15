package com.jbk.service;

import java.util.List;

import com.jbk.entity.Product;
import com.jbk.model.Product_Supplier;

public interface ProductService {
	public boolean saveProduct(Product product);
	public Product getProduct(int productId);
	public List<Product> getAllProducts();
	public boolean deleteProduct(int productId);
	public boolean updateProduct(Product product);
    public Product_Supplier getProductWithSupplierByProductId(int productId);
}
