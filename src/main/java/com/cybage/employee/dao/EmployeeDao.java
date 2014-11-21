/**
 * 
 */
package com.cybage.employee.dao;


import java.util.List;

import com.cybage.employee.model.Employee;

/**
 * @author Janardhan
 *
 */
public interface EmployeeDao {
 
 public void addEmployee(Employee employee);

 public List<Employee> listEmployeess();
 
 public Employee getEmployee(int empid);
 
 public void deleteEmployee(Employee employee);
}
