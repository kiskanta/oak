package ksh.mongo;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class MongoConnect {
	
	public static void main(String[] args) {
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
		String connectionString = System.getProperty("mongodb.uri");
		
		try(MongoClient mongoClient = MongoClients.create(connectionString)){
			List<Document> databases = mongoClient.listDatabases().into(new ArrayList<>());
			databases.forEach(db -> System.out.println(db.toJson()));
			
		}
	}
}
