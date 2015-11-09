package connection;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoConnection {
	private final MongoClient mongo;
	private final MongoDatabase db;
	
	private static MongoConnection singleTonInstance;

	private MongoConnection() {
		mongo = new MongoClient();
		db = mongo.getDatabase("testdb");
	}


	public static MongoConnection getSingleInstance() {

		if (singleTonInstance == null) {

			synchronized (MongoConnection.class) {

				if (singleTonInstance == null) {

					singleTonInstance = new MongoConnection();

				}

			}

		}

		return singleTonInstance;

	}
	
	public MongoCollection<Document> getCollection(final String collectionName){
		return db.getCollection(collectionName);
	}
	
}
