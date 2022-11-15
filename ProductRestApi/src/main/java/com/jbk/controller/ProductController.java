package com.jbk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entity.Product;
import com.jbk.model.Product_Supplier;
import com.jbk.service.ProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
	@Autowired
	private ProductService service;
	
	@PostMapping(value = "/saveproduct")
	public ResponseEntity<Boolean> saveProduct(@RequestBody Product product){
		boolean isAdded=service.saveProduct(product);
		if(isAdded)
			return new ResponseEntity<Boolean>(isAdded,HttpStatus.CREATED);
		else 
			return new ResponseEntity<Boolean>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	@GetMapping(value = "/getproductbyid")
	public ResponseEntity<Product> getProduct(@RequestParam int productId){
		Product product=service.getProduct(productId);
		if (product!=null)
			return new ResponseEntity<Product>(product,HttpStatus.FOUND);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	@DeleteMapping(value = "/deleteproductbyid/{productId}")
	public ResponseEntity<Boolean> deleteProductById(@PathVariable int productId) {
		boolean isDeleted=service.deleteProduct(productId);
		if (isDeleted) {
			return new ResponseEntity<Boolean>(isDeleted,HttpStatus.OK);
		} else {
			return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);}
		}
	@PutMapping(value = "/updateproduct")
	public ResponseEntity<Boolean> updateProduct(@RequestBody Product product) {
		boolean isUpdated=service.updateProduct(product);
		if (isUpdated) {
			return new  ResponseEntity<Boolean>(isUpdated,HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);}
		}
	@GetMapping(value = "/getProductWithSupplierByProductId/{productId}")
	public ResponseEntity<Product_Supplier> getProductWithSupplierByProductId(@PathVariable int productId){
		Product_Supplier product_Supplier=service.getProductWithSupplierByProductId(productId);
		if (product_Supplier!=null)
			return new ResponseEntity<Product_Supplier>(product_Supplier,HttpStatus.FOUND);
		else
			return new ResponseEntity<Product_Supplier>(HttpStatus.NOT_FOUND);
	}
	@GetMapping(value = "/getallproducts")
	public ResponseEntity<List<Product>> getListOfProduct(){
		List<Product> list=service.getAllProducts();
		if (list!=null)
			return new ResponseEntity<List<Product>>(list,HttpStatus.FOUND);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

}
