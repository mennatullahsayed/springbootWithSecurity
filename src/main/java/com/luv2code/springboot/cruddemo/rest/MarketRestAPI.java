package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo.dao.ProductDAO;
import com.luv2code.springboot.cruddemo.dao.UserDAO;
import com.luv2code.springboot.cruddemo.entity.Product;
import com.luv2code.springboot.cruddemo.entity.User;

@RestController
@RequestMapping("/plant")
public class MarketRestAPI {

	@Autowired
	ProductDAO productDAO;
	@Autowired
	UserDAO userDAO;
	@Autowired
	EntityManager entityManager;

	@Autowired
	ProductDAO productDAO2;

//مش هجيب صاحب ال product	
	@GetMapping("/store")
	public List<Product> showAllProduct() {

		return productDAO.findAll();
	}

//my store
	@GetMapping("/store/{userId}")
	public List<Product> showProductForSpecificUser(@PathVariable int userId) {
		try {
			User user = userDAO.findById(userId).get();
			return user.getProducts();
		} catch (Exception e) {
			return null;
		}

	}

	@GetMapping("/store/search/{productName}")
	public List<Product> searchForProduct(@PathVariable String productName) {
		try {
			List<Product> resultList2 = entityManager
					.createQuery("select c from Product c where productName =: productName")
					.setParameter("productName", productName).getResultList();

			return resultList2;

		} catch (Exception e) {
			return null;
		}

	}

	@GetMapping("/store/search/{productName}/{userId}")
	public List<Product> searchForMyProduct(@PathVariable String productName, @PathVariable User userId) {

		try {
			// List<Product> resultList2 = entityManager.createQuery("select c from Product
			// c where productName =: productName and ProductId
			// =:userId").setParameter("productName", productName).setParameter("userId",
			// userId).getResultList();
			List<Product> resultList2 = entityManager
					.createQuery("select c from Product c where productName =: productName and UserId =:id")
					.setParameter("productName", productName).setParameter("id", userId).getResultList();

			System.out.println(4);

			return resultList2;
		} catch (Exception e) {
			return null;
		}

	}

	@PostMapping(value = "/store/save/{userId}", consumes = { "application/json" })
	public int AddProduct(@PathVariable int userId, @RequestBody Product product) {
		try {
			User user = userDAO.findById(userId).get();
			user.addProduct(product);
			userDAO.save(user);
			return 1;
		} catch (Exception e) {
			return 0;
		}

	}

	@GetMapping("/store/details/{productId}")
	public List<Product> seeDetails(@PathVariable int productId) {
		List<Product> resultList2 = entityManager.createQuery("select c from Product c where id =: productId")
				.setParameter("productId", productId).getResultList();
		return resultList2;

	}

	/// TODO errorrrrrrrrrrrrrrrrr
	@PutMapping(value = "/store/edite/{userId}")
	public int edite(@PathVariable int userId, @RequestBody Product product) {
		try {
			int productId = product.getId();

			productDAO.findById(productId).get();

			System.out
					.println(entityManager.createQuery("select c from Product c where id =: productId and UserId =:id")
							.setParameter("productName", productId).setParameter("id", userId).getResultList());
			User user = userDAO.findById(userId).get();
			System.out.println(productId);
			user.addProduct(product);
			System.out.println(productId);
			userDAO.save(user);
			System.out.println(productId);
			return 1;
		} catch (Exception e) {
			return 0;
		}

	}

	@DeleteMapping("/store/delete/{productId}")
	public int deleteProduct(@PathVariable int productId) {
		try {
			productDAO.deleteById(productId);
			return 1;
		} catch (Exception e) {
			return 0;
		}

	}

}
