package br.com.servidor.spring.service;

import java.util.List;

import br.com.servidor.spring.model.Employee;

public interface EmployeeService {
	void saveEmployee(Employee employee);

	List<Employee> findAllEmployees();

	void deleteEmployeeBySsn(String ssn);
}
