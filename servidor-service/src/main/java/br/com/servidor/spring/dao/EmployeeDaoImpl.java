package br.com.servidor.spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import br.com.servidor.spring.model.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl extends AbstractDao implements EmployeeDao {

	public void saveEmployee(Employee employee) {
		persist(employee);
	}

	@SuppressWarnings("unchecked")
	public List<Employee> findAllEmployees() {
		Criteria criteria = getSession().createCriteria(Employee.class);
		return (List<Employee>) criteria.list();
	}

	public void deleteEmployeeBySsn(String ssn) {
		Query query = getSession().createSQLQuery("delete from Employee where ssn = :ssn");
		query.setString("ssn", ssn);
		query.executeUpdate();
	}

}
