package com.user.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.user.domain.UserDomain;
import com.user.impl.entity.User;
import com.user.impl.entity.UserExamEntity;
import com.user.impl.repository.UserDao;
import com.user.impl.repository.UserExamRepository;
import com.user.impl.transformer.UserTransformer;
import com.user.impl.validator.Validator;
import com.user.service.UserServiceInterface;


//use xml root element for xml conversion good for json
@Controller    // This means that this class is a Controller
@RequestMapping(path="/user")
public class UserService implements UserServiceInterface {
	@Autowired
	private UserDao userRepository;
	
	@RequestMapping(path = "/login")
    public String home() {
    	System.out.println("index2");
        return "login";
    }
     
    @RequestMapping(path = "/register")
    public String register() {
    	System.out.println("index2");
        return "register";
    }
	
    @RequestMapping(path = "hello")
    public String welcome() {
    	System.out.println("index2");
        return "welcome";
    }
	
	
	
	@CrossOrigin(origins = {"http://192.168.0.165:4201","http://localhost:4201","https://test-6780f.firebaseapp.com"})
	@PostMapping(path="/") // Map ONLY POST Requests
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public String addNewUser (@ModelAttribute("user_register") UserDomain c, RedirectAttributes redir) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		 //Customer c = new Customer(name,product_id);
		
		//validate user
		//all fields mandatory
		//limit to 100 characters
		//username only max 10 no special characters
		//pass 16 characters max
		// as best practice use to sql injection or fields not suppposed to be saved, create
		//new User to push to database if validation is passed(domain to entity conversion)
		//return user domain in case front end needs it like id of object for instance
		//create separate user classes fro entity and domain
		//for fail return "400 whatever reason"
		//use excdeption in va;idate class for validation. Separate exception class from validqtion)
		System.out.println("here");
		System.out.println(c.getFirstname());
		Object a = null;
		//u.setUserID(7);
		try {
			
			a = Validator.validate(c);
			System.out.println(c.getFirstname());
		} catch (Exception m){System.out.println("Exception occured: "+m);}
		finally {
			System.out.println(a);
			System.out.println(c.getFirstname());
		}
		/*
		if(Validator.stringTest(a)) {
			return a;
		}*/
		System.out.println(c.getFirstname());
	  
		String res = (String)a;
		res = res.substring(4);
		redir.addFlashAttribute("response",res);
		if(a != "200 success") {
			//return Collections.singletonMap("response", a);
			return "redirect:register";
		}
		User u = UserTransformer.domainToEntity(c);
		
		userRepository.save(u);
		//return Collections.singletonMap("response", a);
		return "redirect:home";
	}
	
	@PutMapping(path="/")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public @ResponseBody Object updateUser (@RequestBody UserDomain c) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		Object a = null;
		//u.setUserID(7);
		try {
			a = Validator.validate(c);
			
		} catch (Exception m){System.out.println("Exception occured: "+m);}
		finally {
			//System.out.println(a);
		}
		if(Validator.stringTest(a)) {
			return a;
		}
		User u = new User(c.getUserID(),c.getFirstname(),c.getLastname(),c.getUsername(),c.getPassword());
		userRepository.save(u);
		return a;
		
	}
	
	@GetMapping(path="/")
	@Produces(MediaType.APPLICATION_JSON)
	//@Path("/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		System.out.println("getAll");
		return userRepository.findAll();
	}
	
	@GetMapping(path="/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	//@Path("/all")
	public @ResponseBody User findById(@PathVariable("id") int Id){
		// This returns a JSON or XML with the users
		return userRepository.findById(Id);
	}
	
	@CrossOrigin(origins = {"http://192.168.0.165:4201","http://localhost:4201","https://test-6780f.firebaseapp.com"})
	@PostMapping(path="/login")
	@Produces(MediaType.APPLICATION_JSON)
	//@Path("/all")
	public String verifyUser(@ModelAttribute("user_login") User user, RedirectAttributes redir){
		// This returns a JSON or XML with the users
		
		System.out.println(user.getUsername() + " " + user.getPassword());
		
		User u = userRepository.verifyUser(user.getUsername(),user.getPassword());
		if(u!=null) {
			redir.addFlashAttribute("User",u);
			return "redirect:hello";	
		}
		String fail = "username or password is incorrect";
		redir.addFlashAttribute("fail",fail);
		return "redirect:login";
	}
	
	
	@PostMapping(path="/checkUsername")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	//@Path("/all")
	public @ResponseBody User verifyUsername(@RequestBody User user){
		// This returns a JSON or XML with the users
		
		System.out.println(user.getUsername());
		return userRepository.verifyUsername(user.getUsername());
	}
	
	
}
