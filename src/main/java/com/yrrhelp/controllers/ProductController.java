package com.yrrhelp.controllers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yrrhelp.dbconn.Dbconn;
import com.yrrhelp.models.Product;
import com.yrrhelp.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

      @Autowired
	  private ProductService productService;
      @GetMapping("/all")  
	  public String getAllProducts(Model model) {	 
 		model.addAttribute("products",productService.getAllProducts());
 		
		  return "product_all";
	  }
     
      @GetMapping("/{productId}")
      public String getProductById(Model model, @PathVariable("productId") String productId) {
    	 
    	  model.addAttribute("product",productService.getProductById(productId));
    	  return "product";
      }
      
      @GetMapping("/add")
      public String addNewProduct(Model model) {
    	 
//    	  model.addAttribute("add",productService.getProductById(productId));
    	  return "add";
      }
      
      @GetMapping("/edit/{productId}")
      public String editProductById(Model model, @PathVariable("productId") String productId) {
    	 
    	  model.addAttribute("product",productService.getProductById(productId));
    	  return "edit";
      }
      
      @GetMapping("/delete/{productId}")
      public @ResponseBody String deleteProductById(@PathVariable("productId") String productId) {
    	  try {
    		  System.out.println(Integer.parseInt(productId));
			Dbconn.delete(Integer.parseInt(productId));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	  return "Deleted!";
      }
      
      @RequestMapping("/addnewproduct")
      public @ResponseBody String addProduct(@RequestParam(required=false,name="name") String name, @RequestParam(required=false,name="price") String price, @RequestParam(required=false,name="gst") String gst) {
		  Double pr = Double.parseDouble(price);
		  Integer g = Integer.parseInt(gst);
		  try {
			Dbconn.add(name, pr, g);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	  return "Added!";
      }
      
      @RequestMapping("/update/{id}")
      public @ResponseBody String updateProductById(@PathVariable String id, @RequestParam(required=false,name="price") String price, @RequestParam(required=false,name="gst") String gst) {
    	  Double pr = null;
    	  Integer g = null;
//    	  Product p = productService.getProductById(id);
    	  if(price != null && !price.trim().isEmpty()) {
    		  pr = Double.parseDouble(price);
    	  }
    	  if(gst != null && !gst.trim().isEmpty()) {
    		  g = Integer.parseInt(gst);
    	  }
    	  System.out.println(pr);
    	  System.out.println(g);
    	  try {
			Dbconn.edit(Integer.parseInt(id), pr, g);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	  
    	  System.out.println("Success");
          return "Successfully updated!";
      }
}
