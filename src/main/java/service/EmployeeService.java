package service;

import org.bson.Document;

import com.mongodb.client.FindIterable;

public interface EmployeeService {
	
	Document getDocument(String name);
	FindIterable<Document> getDocuments();
	Long getCount();
	void saveDocument(Document doc, String name);
}
