package com.cocovrend.springbootwebapp.service.implementasi;

import com.cocovrend.springbootwebapp.entity.Employee;
import com.cocovrend.springbootwebapp.errorhandler.ExceptionImpl;
import com.cocovrend.springbootwebapp.model.CreateEmployeeRequest;
import com.cocovrend.springbootwebapp.repository.EmployeeRepository;
import com.cocovrend.springbootwebapp.service.contract.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    @Override
    public ModelAndView showEmployee() {
        ModelAndView mav = new ModelAndView("list-employees");
        List<Employee> list = repository.findAll();
        mav.addObject("employees", list);
        return mav;
    }

    @Override
    public ModelAndView addEmployeeForm() {
        ModelAndView mav = new ModelAndView("add-employee-form");
        Employee employee = new Employee();
        mav.addObject("employee", employee);
        return mav;
    }

    @Override
    public ModelAndView saveEmployee(CreateEmployeeRequest request) {
        try {
            Long employeeId = request.getId();
            if (employeeId==null) {
                Employee newEmployee = Employee.builder()
                        .name(request.getName())
                        .email(request.getEmail())
                        .department(request.getDepartment())
                        .build();
                repository.saveAndFlush(newEmployee);
            } else {
                Employee employee = repository.findById(employeeId).orElseThrow();
                employee.setName(request.getName());
                employee.setDepartment(request.getDepartment());
                employee.setEmail(request.getEmail());
                repository.saveAndFlush(employee);
            }
            return new ModelAndView("redirect:/api/v1/employee/show-all");
        }catch (RuntimeException e){
            throw new ExceptionImpl("email sudah digunakan");
        }
    }

    @Override
    public ModelAndView showUpdateForm(Long employeeId) {
        ModelAndView mav = new ModelAndView("add-employee-form");
        Employee employee = repository.findById(employeeId).orElseThrow();
        mav.addObject("employee", employee);
        return mav;
    }

    @Override
    public ModelAndView deleteEmployee(Long request) {
        repository.deleteById(request);
        return new ModelAndView("redirect:/api/v1/employee/show-all");
    }


}
