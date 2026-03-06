package com.tec.demo.controller;

import com.tec.demo.model.Restaurant;
import com.tec.demo.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/")
    public String ViewhomePage(Model model) {
        model.addAttribute("listRestaurants", restaurantService.getAllRestaurants());
        return "index";
    }

    //create new restaurant
    @GetMapping("/new")
    public String showNewRestaurantForm(Model model) {
        model.addAttribute("restaurant", new com.tec.demo.model.Restaurant());
        return "new_restaurant";

    }
    @PostMapping("/save")
    public String saveRestaurant(@ModelAttribute("restaurant")Restaurant restaurant) {
        restaurantService.saveRestaurant(restaurant);
        return "redirect:/";

    }
    @GetMapping("/edit/{id}")
    public String showEditRestaurantForm(@PathVariable Integer id, Model model) {
        model.addAttribute("restaurant", restaurantService.getRestaurantById(id));
        return "edit";
    }
    @GetMapping("/delete/{id}")
     public String deleteRestaurant(@PathVariable Integer id) {
        restaurantService.deleteRestaurant(id);
        return "redirect:/";


     }
}
