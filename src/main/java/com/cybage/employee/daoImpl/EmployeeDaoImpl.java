package com.cybage.employee.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cybage.employee.dao.EmployeeDao;
import com.cybage.employee.model.Employee;

/**
 * @author Janardhan
 *
 */

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {

 @Autowired
 private SessionFactory sessionFactory;
 
 @Transactional
 public void addEmployee(Employee employee) {
   sessionFactory.getCurrentSession().saveOrUpdate(employee);
 }

 @SuppressWarnings("unchecked")
 @Transactional
 public List<Employee> listEmployeess() {
  return (List<Employee>) sessionFactory.getCurrentSession().createCriteria(Employee.class).list();
 }

 @Transactional
 public Employee getEmployee(int empid) {
  return (Employee) sessionFactory.getCurrentSession().get(Employee.class, empid);
 }

 @Transactional
 public void deleteEmployee(Employee employee) {
  sessionFactory.getCurrentSession().createQuery("DELETE FROM Employee WHERE empid = "+employee.getEmpId()).executeUpdate();
 }
}
