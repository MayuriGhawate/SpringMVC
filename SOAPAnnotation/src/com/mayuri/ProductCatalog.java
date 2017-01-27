package com.mayuri;

import java.util.ArrayList;
import java.util.List;

public class ProductCatalog {
	
	List<String> carList =new ArrayList<>();
	List<String> vanList =new ArrayList<>();
	List<String> suvList =new ArrayList<>();
	
	public ProductCatalog(){
		carList.add("Chevy Cruise");
		carList.add("Honda Civic");
		carList.add("Toyota Corolla");
		carList.add("Nissan Sentra");
		
		vanList.add("Honda Odyssey");
		vanList.add("Toyota Sienna");
		vanList.add("Chrysler");
		vanList.add("Dodge ");
		
		suvList.add("Range Rover");
		suvList.add("");
		suvList.add("Toyota RAV4");
		suvList.add("Acura MDX");



	}
	
	public List<String> getProductCatagories(){
		List<String> categories = new ArrayList<>();
		categories.add("Cars");
		categories.add("Van");
		categories.add("suv");
		return categories;
	}

	public boolean addProduct(String category,String product){
		switch(category){
		case "Cars" :
			carList.add(product);
		break;
		case "Van" :
			vanList.add(product);
		break;
		case "suv" :
			suvList.add(product);
		break;
		default: return false;
		}
		return true;
	}
	public List<String> getProduct(String category){
		switch(category){
		case "Cars" :
			return carList;
		
		case "Van" :
			return vanList;
		
		case "suv" :
			return suvList;
		
		
		}
		return null;
	}
}
