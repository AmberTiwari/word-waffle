package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bean.User;
import com.service.HangmanServiceInt;
import com.service.JumbledServiceInt;
import com.service.RiddlerServiceInt;
import com.service.UserServiceInt;

@Controller
public class WordController {

	@Autowired
	private HangmanServiceInt hangmanService;
	@Autowired
	private JumbledServiceInt jumbledService;
	@Autowired
	private RiddlerServiceInt riddlerService;
	@Autowired
	private UserServiceInt userService;
	
	@RequestMapping("/")
	public String openingPageController() {
		return "index";
	}
	
	@RequestMapping("/userLogin")
	public String getEmpIDForSearchPage() {
		return "inputUserIdForSearch";
	}
	
	@RequestMapping("/searchUser")
	public ModelAndView searchEmpController(@RequestParam("userId") String id) {
		User user = null;
		try {
			user = userService.findUser(Integer.parseInt(id));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (user != null) {
			return new ModelAndView("displayUserMenu", "user", user);
		}
		return new ModelAndView("output", "message", "User with id " + id + " does not exist");
	}	
}
