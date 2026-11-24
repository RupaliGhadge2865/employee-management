package com.train.mvc.controller;

import com.train.mvc.model.Employee;
import com.train.mvc.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/employees";
    }

    // List page
    @GetMapping("/employees")
    public String list(Model model) {
        model.addAttribute("employees", service.getAllEmployees());
        return "employee-list";
    }

    // Empty form
    @GetMapping("/employees/new")
    public String showForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee-form";
    }

    // Form submit
    @PostMapping("/employees")
    public String register(@ModelAttribute("employee") Employee employee,
                           BindingResult result,
                           Model model,
                           RedirectAttributes redirectAttributes) {

        // ID madhe number nahi (ex. "abc")
        if (result.hasErrors()) {
            model.addAttribute("error", "ID must be a number");
            return "employee-form";
        }

        // Service validation + duplicate ID check
        try {
            service.register(employee);
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "employee-form";
        }

        // Success: message ani details list page la pathva
        redirectAttributes.addFlashAttribute("message", "Employee registered successfully");
        redirectAttributes.addFlashAttribute("registered", employee);
        return "redirect:/employees";
    }
}