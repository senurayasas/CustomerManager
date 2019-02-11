package com.cms.controller;

import com.cms.domain.Customer;
import com.cms.domain.Department;
import com.cms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    private static final String UPDATE_SUCCESS_MESSAGE = "User %s %s updated successfully!";
    private static final String ADD_SUCCESS_MESSAGE = "User %s %s added successfully!";
    private static final String DELETE_SUCCESS_MESSAGE = "User %s %s deleted successfully!";

    /**
     * View all customers
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String showAllCustomers(Model model) {
        model.addAttribute("customers", customerService.findAllCustomers());
        model.addAttribute("test", "abc");
        return "listCustomers";
    }


    /**
     * Show add customer view
     * @param model
     * @return
     */
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String showNewCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "addCustomer";
    }

    /**
     * Create New Customer
     * @param model
     * @param customer
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String saveNewCustomer(Model model, @Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "addCustomer";
        }
        customerService.saveCustomer(customer);
        model.addAttribute("customer", new Customer());
        model.addAttribute("msg", String.format(ADD_SUCCESS_MESSAGE, customer.getFirstName(), customer.getLastName()));
        return "addCustomer";
    }

    /**
     * Show an existing customer
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showCustomer(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "editCustomer";
    }

    /**
     * Update customer
     * @param model
     * @param customer
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String updateCustomer(Model model, @Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editCustomer";
        }
        customerService.saveCustomer(customer);
        model.addAttribute("customer", customer);
        model.addAttribute("msg", String.format(UPDATE_SUCCESS_MESSAGE, customer.getFirstName(), customer.getLastName()));
        return "editCustomer";
    }


    /**
     * Delete customer
     * @param model
     * @param customer
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteCustomer(Model model, @ModelAttribute("customer") Customer customer, final RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("msg", String.format(DELETE_SUCCESS_MESSAGE, customer.getFirstName(), customer.getLastName()));
        customerService.deleteCustomer(customer.getId());
        return "redirect:";
    }

    @ModelAttribute("departments")
    public List<Department> populateRoster() {
        return Arrays.asList(Department.values());
    }

    private void MainBranchEvolve(){

    }
}