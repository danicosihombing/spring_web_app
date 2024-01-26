package com.cocovrend.springbootwebapp.service.contract;

import com.cocovrend.springbootwebapp.entity.Employee;
import com.cocovrend.springbootwebapp.model.CreateEmployeeRequest;
import org.springframework.web.servlet.ModelAndView;


public interface EmployeeService {
    ModelAndView showEmployee();
    ModelAndView addEmployeeForm();
    ModelAndView saveEmployee(CreateEmployeeRequest request);
    ModelAndView showUpdateForm(Long request);
    ModelAndView deleteEmployee(Long request);
}
