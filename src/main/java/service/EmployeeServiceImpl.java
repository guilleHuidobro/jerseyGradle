package service;

import org.bson.Document;

import com.mongodb.client.FindIterable;

import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;

public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeDAO employeeDAO = new EmployeeDAOImpl();

	@Override
	public Document getDocument(String name) {
		// TODO Auto-generated method stub
		return employeeDAO.getDocumentByName(name);
	}

	@Override
	public void saveDocument(Document doc,String name) {
		// TODO Auto-generated method stub
		employeeDAO.saveDocument(doc, name);
	}

	@Override
	public FindIterable<Document> getDocuments() {
		// TODO Auto-generated method stub
		return employeeDAO.getAll();
	}

	@Override
	public Long getCount() {
		// TODO Auto-generated method stub
		return employeeDAO.getCount();
	}

}
