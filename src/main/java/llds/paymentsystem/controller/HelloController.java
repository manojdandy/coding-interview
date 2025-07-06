package llds.paymentsystem.controller;

import llds.paymentsystem.dto.UserDTO;
import llds.paymentsystem.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//@RestController                 // marks class as REST endpoint
//#@RequestMapping("/api/users")
@Controller
@RequestMapping("/users")
//use @RestController and return objects/DTOs.
public class HelloController {

    @GetMapping("/")            // GET http://localhost:8080/
    public String hello() {
        return "Hello, World!";
    }

    /* HTML view */
    @GetMapping("/{id}")
    public String getUser(@PathVariable Long id, Model model) {
        System.out.println("id :: " + id);
        //User user = userService.findById(id);
        UserDTO user = new UserDTO(1,"ram");
        user.setEmail("ram@gmail.com");
        model.addAttribute("user", user);
        return "userView";  // Thymeleaf/JSP view
    }

    @GetMapping(value = "/json/{id}",produces = "application/json")            // GET /api/users/42
    @ResponseBody
    public UserDTO getUser(@PathVariable Long id) {
        UserDTO user = new UserDTO(1,"ram");
        user.setEmail("ram@gmail.com");
        return user;   // returned as JSON
    }

}