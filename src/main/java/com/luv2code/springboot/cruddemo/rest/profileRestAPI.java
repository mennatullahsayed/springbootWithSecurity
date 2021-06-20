package com.luv2code.springboot.cruddemo.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.luv2code.springboot.cruddemo.dao.PlantDAO;
import com.luv2code.springboot.cruddemo.dao.ProductDAO;
import com.luv2code.springboot.cruddemo.dao.UserDAO;
import com.luv2code.springboot.cruddemo.dao.UserPlantDAO;
import com.luv2code.springboot.cruddemo.entity.Plant;
import com.luv2code.springboot.cruddemo.entity.Post;
import com.luv2code.springboot.cruddemo.entity.Product;
import com.luv2code.springboot.cruddemo.entity.User;
import com.luv2code.springboot.cruddemo.entity.UserPlant;
import com.luv2code.springboot.cruddemo.service.EmailService;

@RestController
@RequestMapping("/plant")
public class profileRestAPI {

	
	 @Autowired
	  EmailService emailService2;
	
	@Autowired
	private EmailService emailService;	
	@Autowired
	UserDAO userDAO;

	
    private JavaMailSender javaMailSender;
	
	@Autowired
	UserPlantDAO userPlantDAO;

	@Autowired
	PlantDAO plantDAO;

	@Autowired
	ProductDAO productDAO;

	@Autowired
	EntityManager entityManager;

	@GetMapping("/profile/countposts/{userId}")
	public int showCountMyPosts(@PathVariable int userId) {
		try {

			User user = userDAO.findById(userId).get();

			return user.getPosts().size();
		} catch (Exception e) {
			return 0;
		}

	}

	@PostMapping("/profile/addpost/{userId}")
	public int addPost(@PathVariable int userId, @RequestBody Post post) {
		try {

			User user = userDAO.findById(userId).get();
			user.addPost(post);
			userDAO.save(user);
			return 1;
		} catch (Exception e) {
			return 0;
		}

	}

	@GetMapping("/profile/myplant/{userid}")
	public List<UserPlant> myplant(@PathVariable String userid) {
		try {
			List<UserPlant> userPlants = entityManager.createQuery("select c from UserPlant c where user_ID =: userid")
					.setParameter("userid", userid).getResultList();

			return userPlants;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(1);
			return null;
		}

	}

	@PostMapping("/profile/addtomygarden/{userId}/{plantname}")
	public int addPlant(@PathVariable int userId, @PathVariable String plantname, @RequestBody UserPlant userPlant) {
		try {
			if (plantDAO.findById(plantname).isEmpty()) {
				plantDAO.save(new Plant(plantname));
			}
			User user = new User();
			user.setId(userId);
			userPlant.setUser(user);
			userPlant.setPlant(new Plant(plantname));
			System.out.println(userPlant);
			userPlantDAO.save(userPlant);
			return 1;
		} catch (Exception e) {
			return 0;
		}

	}
//my products
	@GetMapping("/profile/mygarden/{userid}")
	public List<Product> mygarden(@PathVariable int userid) {
		try {
			 
			User user = userDAO.findById(userid).get();

			return user.getProducts();
		} catch (Exception e) {
			return new ArrayList<Product>();
		}

	}

	@PostMapping("/profile/addtomygarden")
	public Product addToMyGallary(@RequestBody Product product) {
		try {
			System.out.println(product.getClass());

			/*User user = new User();
			user.setId(userId);
			product.setUserId(user);
			System.out.println(product);
		    user.addProduct(product);*/
			productDAO.save(product);
			return product;
		} catch (Exception e) {
			return new Product();
		}

	}

	@PostMapping("profile/addimage/{userid}")
	public int addphoto(@RequestPart("file") MultipartFile file, @PathVariable int userid) throws IOException {
		try {
			User user = userDAO.findById(userid).get();
			user.setPhoto(file.getBytes());
			userDAO.save(user);
			System.out.println("not error");
			return 1;
		} catch (Exception e) {
			return 0;

		}

	}

	@PostMapping("/editprofile")
	public int editProfile(@RequestBody User olduser) throws IOException {
		try {	
			User user = userDAO.findById(olduser.getId()).get();
			
			if(olduser.getUserName()!=null) 
				user.setUserName(olduser.getUserName());
			else if(olduser.getEmail()!=null) 
				user.setEmail(olduser.getEmail());
			else if(olduser.getTitle()!=null) 
				user.setTitle(olduser.getTitle());
			else if(olduser.getPassword()!=null) 
				user.setPassword(olduser.getPassword());
			else if(olduser.getPhone()!=null) 
				user.setPhone(olduser.getPhone());
			else if(olduser.getFacebookUrl()!=null) 
				user.setFacebookUrl(olduser.getFacebookUrl());
			else if(olduser.getCreatedAt()!=null) 
				user.setCreatedAt(olduser.getCreatedAt());
			else if(olduser.getOtp()!=0) 
				user.setOtp(olduser.getOtp());
			else if(olduser.getFirstTime()!=0) 
				user.setFirstTime(olduser.getFirstTime());
			else if(olduser.getRole()!=0) 
				user.setRole(olduser.getRole());
			else if(olduser.getToken()!=null) 
				user.setToken(olduser.getToken());
				userDAO.save(user);
			
			return 1;
		} catch (Exception e) {
			return 0;

		}

	
	}
	
	
	@PostMapping("/addproductimage/{prouductid}")
	public int productphoto(@RequestPart("file") MultipartFile file,@PathVariable int prouductid) throws IOException {
		try {
			Product product =productDAO.findById(prouductid).get();
			product.setPhoto(file.getBytes());
			
			productDAO.save(product);
			 
			return 1;
		} catch (Exception e) {
			return 0;

		}

	}

	@PostMapping("/addproduct/{userid}")
	
	public Product addproduct(@PathVariable int userid,@RequestBody Product product) throws IOException {
		try {

			User user = new User();
			user.setId(userid);
			product.setUserId(user);
			//System.out.println(product);
		   // user.addProduct(product);
			productDAO.save(product);
			
			return product;
		} catch (Exception e) {
			return new Product();

		}

	}

	
	
	
	@DeleteMapping("/deleteproduct/{prouductid}")	
	public int deleteproduct(@PathVariable int prouductid) throws IOException {
		try {	
			Product product =productDAO.findById(prouductid).get();

			productDAO.delete(product);
			return 1;
		} catch (Exception e) {
			return 0;

		}

	}

	
	//ignor
	@GetMapping("/allproducts")	
	public List<Product> allproducts() throws IOException {
		try {	
			List<Product> products =productDAO.findAll();

			
			return products;
		} catch (Exception e) {
			return new ArrayList<Product>();

		}

	}
	
	
	
//TODO 
	@PostMapping("/search/{productName}")	
	public List<Product> search(@PathVariable String productName)  {
		try {	
			List<Product> products = entityManager.createQuery("select c from Product c where productName =: productName")
					.setParameter("productName", productName).getResultList();
			
			return products;
		} catch (Exception e) {
			return new ArrayList<Product>();

		}

	}
	
	
	
	
	
	
	
	
	 


	    @PostMapping("/verify/{userid}/{productname}/{quantity}")
	    public int verificataion(@PathVariable int userid ,@PathVariable String productname , @PathVariable int quantity )
	    {
	    	
	    	try {
	    		User user = userDAO.findById(userid).get();
		        emailService.buyByMail(user.getEmail(),productname,quantity );
		        return 1;
			} catch (Exception e) {
				return 0;
			}
	    
	    }
	
	
	
	
	
	
	
	
	

}
