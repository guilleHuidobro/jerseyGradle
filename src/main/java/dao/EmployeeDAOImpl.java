package dao;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

import connection.MongoConnection;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public Document getDocumentByName(String name) {
		MongoCollection<Document> collection = MongoConnection
				.getSingleInstance().getCollection("user");
		Document filter = new Document();
		filter.append("firstName", "Guillermo");
		return collection.find(filter).first();
	}

	@Override
	public void saveDocument(Document doc, String name) {
		MongoCollection<Document> collection = MongoConnection
				.getSingleInstance().getCollection("user");
		collection.insertOne(doc);
	}

	@Override
	public FindIterable<Document> getAll() {
		MongoCollection<Document> collection = MongoConnection
				.getSingleInstance().getCollection("user");
		return collection.find();
	}

	@Override
	public Long getCount() {
		MongoCollection<Document> collection = MongoConnection
				.getSingleInstance().getCollection("user");
		return collection.count();
	}

	@Override
	public Document getDocumentById(String id) {
		MongoCollection<Document> collection = MongoConnection
				.getSingleInstance().getCollection("user");
		Document filter = new Document();
		filter.append("_id", new ObjectId(id));
		return collection.find(filter).first();
	}

	@Override
	public void updateDocument(Document doc, String name) {
		MongoCollection<Document> collection = MongoConnection
				.getSingleInstance().getCollection("user");

//		collection
//				.updateOne(new Document("_id",doc.getObjectId("_id")), new Document("$set",
//						doc).append("$currentDate", new Document(
//						"lastModified", true)));
		
		collection
		.updateOne(new Document("firstName",doc.getString("firstName")), new Document("$set", new Document("firstName","Guidorolo")));
		
		collection
		.updateOne(new Document("_id",doc.getString("_id")), new Document("$set", new Document("firstName","Guidorolo")));

	}

}
