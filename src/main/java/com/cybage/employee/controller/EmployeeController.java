package com.cybage.employee.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cybage.employee.bean.EmployeeBean;
import com.cybage.employee.model.Employee;
import com.cybage.employee.service.EmployeeService;

// TODO: Auto-generated Javadoc
/**
 * The Class EmployeeController.
 *
 * @author Janardhan
 */
@Controller
public class EmployeeController {

	/** The employee service. */
	@Autowired
	private EmployeeService employeeService;

	/**
	 * Save employee.
	 *
	 * @param employeeBean the employee bean
	 * @param result the result
	 * @return the model and view
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute("command") EmployeeBean employeeBean, BindingResult result) {
		System.out.println("In save method");
		Employee employee = prepareModel(employeeBean);
		employeeService.addEmployee(employee);
		return new ModelAndView("redirect:/add.html");
	}

	/**
	 * List employees.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public ModelAndView listEmployees() {
		Map<String, Object> model = new HashMap<String, Object>();
		System.out.println("In listEmployees method");
		model.put("employees",
				prepareListofBean(employeeService.listEmployeess()));
		return new ModelAndView("employeesList", model);
	}

	/**
	 * Adds the employee.
	 *
	 * @param employeeBean the employee bean
	 * @param result the result
	 * @return the model and view
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addEmployee(@ModelAttribute("command") EmployeeBean employeeBean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		System.out.println("In add method");
		model.put("employees",
				prepareListofBean(employeeService.listEmployeess()));
		return new ModelAndView("addEmployee", model);
	}
	
	/**
	 * Edits the employee.
	 *
	 * @param employeeBean the employee bean
	 * @param result the result
	 * @return the model and view
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView editEmployee(
			@ModelAttribute("command") EmployeeBean employeeBean,
			BindingResult result) {
		System.out.println("In delete method");
		employeeService.deleteEmployee(prepareModel(employeeBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employee", null);
		model.put("employees",
				prepareListofBean(employeeService.listEmployeess()));
		return new ModelAndView("addEmployee", model);
	}

	/**
	 * Delete employee.
	 *
	 * @param employeeBean the employee bean
	 * @param result the result
	 * @return the model and view
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(	@ModelAttribute("command") EmployeeBean employeeBean, BindingResult result) {
		System.out.println("In edit method");
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employee", prepareEmployeeBean(employeeService
				.getEmployee(employeeBean.getId())));
		model.put("employees",
				prepareListofBean(employeeService.listEmployeess()));
		return new ModelAndView("addEmployee", model);
	}

	/**
	 * Prepare model.
	 *
	 * @param employeeBean the employee bean
	 * @return the employee
	 */
	private Employee prepareModel(EmployeeBean employeeBean) {
		Employee employee = new Employee();
		employee.setEmpAddress(employeeBean.getAddress());
		employee.setEmpAge(employeeBean.getAge());
		employee.setEmpName(employeeBean.getName());
		employee.setSalary(employeeBean.getSalary());
		employee.setEmpId(employeeBean.getId());
		employeeBean.setId(null);
		return employee;
	}

	/**
	 * Prepare listof bean.
	 *
	 * @param employees the employees
	 * @return the list
	 */
	private List<EmployeeBean> prepareListofBean(List<Employee> employees) {
		List<EmployeeBean> beans = null;
		if (employees != null && !employees.isEmpty()) {
			beans = new ArrayList<EmployeeBean>();
			EmployeeBean bean = null;
			for (Employee employee : employees) {
				bean = new EmployeeBean();
				bean.setName(employee.getEmpName());
				bean.setId(employee.getEmpId());
				bean.setAddress(employee.getEmpAddress());
				bean.setSalary(employee.getSalary());
				bean.setAge(employee.getEmpAge());
				beans.add(bean);
			}
		}
		return beans;
	}

	/**
	 * Prepare employee bean.
	 *
	 * @param employee the employee
	 * @return the employee bean
	 */
	private EmployeeBean prepareEmployeeBean(Employee employee) {
		EmployeeBean bean = new EmployeeBean();
		bean.setAddress(employee.getEmpAddress());
		bean.setAge(employee.getEmpAge());
		bean.setName(employee.getEmpName());
		bean.setSalary(employee.getSalary());
		bean.setId(employee.getEmpId());
		return bean;
	}
}
