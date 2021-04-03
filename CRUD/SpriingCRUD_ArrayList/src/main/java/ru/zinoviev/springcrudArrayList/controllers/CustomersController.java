package ru.zinoviev.springcrudArrayList.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.zinoviev.springcrudArrayList.DAO.CustomerDAO;
import ru.zinoviev.springcrudArrayList.models.Customer;

@Controller
@RequestMapping("/customers")
public class CustomersController {

    private final CustomerDAO customerDAO;

    @Autowired
    public CustomersController(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @GetMapping()
    public String list(Model model){

        model.addAttribute("customerList", customerDAO.list());
        return "/one/index";
    };


    // @PathVariable("id") можно не писать указание переменной запроса, если она совпадает с именем переменной
    // то есть   "id"
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id,  Model model){

        model.addAttribute("pipka", customerDAO.show(id));
        return "/one/show";
    }

    @GetMapping("/new")
    public String newCustomer(Model model){
        model.addAttribute("newCustomer", new Customer());
        return "/one/newCustomer";
    }

    @PostMapping()
    public String create(@ModelAttribute("customer") Customer customer){
        customerDAO.save(customer);
        return "redirect:/customers";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("person", customerDAO.show(id));

        return "/one/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("edited") Customer person,
                         @PathVariable("id") int id ){
        customerDAO.update(id, person);
        return "redirect:/customers";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        customerDAO.delete(id);
        return "redirect:/customers";
    }
}
