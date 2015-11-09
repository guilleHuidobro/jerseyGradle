package dao;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

import connection.MongoConnection;

public class EmployeeDAOImpl implements EmployeeDAO{

	@Override
	public Document getDocumentByName(String name) {
		MongoCollection<Document> collection = MongoConnection.getSingleInstance().getCollection("user");
		Document filter = new Document();
		filter.append("firstName", "Guillermo");
		return collection.find(filter).first();
	}


	
	@Override
	public void saveDocument(Document doc,String name) {
		MongoCollection<Document> collection = MongoConnection.getSingleInstance().getCollection("user");
		collection.insertOne(doc);
	}



	@Override
	public FindIterable<Document> getAll() {
		MongoCollection<Document> collection = MongoConnection.getSingleInstance().getCollection("user");				
		return collection.find();
	}



	@Override
	public Long getCount() {
		MongoCollection<Document> collection = MongoConnection.getSingleInstance().getCollection("user");
		return collection.count();
	}



}
