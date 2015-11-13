package dao;

import org.bson.Document;

import com.mongodb.client.FindIterable;


public interface EmployeeDAO {
	
	Document getDocumentByName(String name);
	
	FindIterable<Document> getAll();
	
	Document getDocumentById(String id);
	
	Long getCount();
	
    void saveDocument(Document doc,String name);
}
