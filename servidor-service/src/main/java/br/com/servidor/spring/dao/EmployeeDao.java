package br.com.servidor.spring.dao;

import java.util.List;

import br.com.servidor.spring.model.Employee;

public interface EmployeeDao {
	void saveEmployee(Employee employee);

	List<Employee> findAllEmployees();

	void deleteEmployeeBySsn(String ssn);
}
