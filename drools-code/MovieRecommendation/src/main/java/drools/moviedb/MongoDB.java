
package drools.moviedb;

import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.ServerAddress;

import drools.constants.Collections;


import java.net.UnknownHostException;
import java.util.Arrays;

import org.json.simple.JSONObject;

public class MongoDB {
	private Mongo mongo;
	private DB db;
	public DBCursor cursor;
	public DBCursor history;
	private DBCollection  collection;
	public DBCollection historyCollection;
	public void connectMovieDB() throws UnknownHostException {
		mongo = new Mongo("ec2-54-243-59-26.compute-1.amazonaws.com",27017);
		db = mongo.getDB("movieDB");
	}
	
	public void connectUserDB() throws UnknownHostException {
		mongo = new Mongo("ec2-54-243-59-26.compute-1.amazonaws.com",27017);
		db = mongo.getDB("UserProfile");
	}
	
	public void getUserInfo() {
		
	}
	
	public void updateMovieRating(int mid, double movieRating) {
		BasicDBObject query = new BasicDBObject();
		collection = db.getCollection(Collections.MOVIE_COLLECTION.getName());
		query.put("mid", mid);
		DBObject movie = collection.findOne(query);
		if(movie == null) {
			movie = new BasicDBObject();
			movie.put("mid", mid);
			movie.put("rating", movieRating);
			collection.insert(movie);
			return;
		}
		System.out.println("Test: " + movie.get("rating"));
		double rating = (Double) movie.get("rating");
		double updatedRating = (rating + movieRating)/2;
		BasicDBObject movieUpdate = new BasicDBObject().append("$set", 
				new BasicDBObject().append("rating", updatedRating));
		collection.update(movie, movieUpdate);
	}
	
	public void getUserList() {
		collection = db.getCollection(Collections.TEST_COLLECTION.getName());
		cursor = collection.find();
	}
	
	public void removeUser(Object user) {
		collection = db.getCollection(Collections.TEST_COLLECTION.getName());
		//Object o = com.mongodb.util.JSON.parse(user.toString());
		DBObject dbObj = (DBObject) user;
		collection.remove(dbObj);
	}
	
	public void addUser(Object user) {
		collection = db.getCollection(Collections.TEST_COLLECTION.getName());
		Object o = com.mongodb.util.JSON.parse(user.toString());
		DBObject dbObj = (DBObject) o;
		collection.insert(dbObj);
	}
	
	
	public void insertMovie(Object movie, String collectionName) {
		System.out.println("Inserting movie");
		collection = db.getCollection(collectionName);
		Object o = com.mongodb.util.JSON.parse(movie.toString());
		DBObject dbObj = (DBObject) o;
		collection.insert(dbObj);
		/*BasicDBObject doc = new BasicDBObject();

        doc.put("name", "MongoDB");
        doc.put("type", "database");
        doc.put("count", 1);

        BasicDBObject info = new BasicDBObject();

        info.put("x", 203);
        info.put("y", 102);

        doc.put("info", info);

        collection.insert(doc);*/
		
	}
	
	public void closeDB() {
		mongo.close();
	}
}
