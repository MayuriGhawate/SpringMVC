package com.mayuri;

import java.util.List;

import javax.jws.WebMethod;

public class ProductService {
	
	ProductCatalog productService = new ProductCatalog();
	
	@WebMethod
	public List<String> getProductCategories(){
		return productService.getProductCatagories();
	}
	
	@WebMethod
	public List<String> getProducts(String category){
		return productService.getProduct(category);
	}
	
	@WebMethod
	public boolean addProduct(String category,String product){
		return true;
	}

}
