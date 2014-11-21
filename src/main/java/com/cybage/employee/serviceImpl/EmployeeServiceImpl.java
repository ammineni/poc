package com.cybage.employee.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cybage.employee.dao.EmployeeDao;
import com.cybage.employee.model.Employee;
import com.cybage.employee.service.EmployeeService;

/**
 * @author Janardhan
 *
 */
@Service("employeeService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

 @Autowired
 private EmployeeDao employeeDao;
 
 @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
 public void addEmployee(Employee employee) {
  employeeDao.addEmployee(employee);
 }
 
 public List<Employee> listEmployeess() {
  return employeeDao.listEmployeess();
 }

 public Employee getEmployee(int empid) {
  return employeeDao.getEmployee(empid);
 }
 
 public void deleteEmployee(Employee employee) {
  employeeDao.deleteEmployee(employee);
 }

}

