package com.cocovrend.springbootwebapp.controller;

import com.cocovrend.springbootwebapp.model.CreateEmployeeRequest;
import com.cocovrend.springbootwebapp.service.contract.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/employee")
public class EmployeeController {

    private final EmployeeService service;

    @GetMapping(path = "/show-all")
    public ModelAndView showEmployees(){
        return service.showEmployee();
    }
    @GetMapping(path = "/addEmployeeForm")
    public ModelAndView addEmployeeForm(){
        return service.addEmployeeForm();
    }

    @PostMapping(path = "/saveEmployee")
    public ModelAndView saveEmployee(@ModelAttribute CreateEmployeeRequest employee){
        return service.saveEmployee(employee);
    }

    @GetMapping(path = "/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam Long employeeId){
        return service.showUpdateForm(employeeId);
    }

    @GetMapping(path = "/deleteEmployee")
    public ModelAndView deleteEmployee(@RequestParam Long employeeId){
        return service.deleteEmployee(employeeId);
    }


}
