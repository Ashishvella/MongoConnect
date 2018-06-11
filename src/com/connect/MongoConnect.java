package com.connect;

import java.util.Iterator;
import java.util.*;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

public class MongoConnect {

	public static void main(String[] args) {
		MongoClient mongo = new MongoClient("localhost", 27017);
		MongoCredential credential;
		char[] ar = { 'p', 'a', 's', 's' };
		credential = MongoCredential.createCredential("sampleUser", "FirstMongoDatabase", ar);
		System.out.println("Welcome to the FirstMongoDatabase successfully");
		// Accessing the database
		MongoDatabase database = mongo.getDatabase("FirstMongoDatabase");
		System.out.println("Credentials ::" + credential);
		System.out.println("1.Create a collection \n");
		System.out.println("2.Show all the available collections\n");
		System.out.println("3..Select an existing collection ");
		
		
		Scanner input=new Scanner(System.in);
		int i=input.nextInt();
		switch(i)
		{
		case 1:
			createCollection(database);
			break;
	
		case 2:
			getAllCollections(database);
			break;
		case 3:
			//dropCollection(collection);
			
			/*			case 3:
			System.out.println("Please enter exact collection name you want to select");
			MongoCollection<Document> collection=getCollection(database);
			break;*/
		}
		//System.out.println("1.Create a new collection \n");
		//System.out.println("2.Select an existing collection \n");
		//System.out.println("3.Insert Document in an existing collection \n");
		//System.out.println("4.Update Document in an existing collection  \n");
		//System.out.println("5.Drop an existing collection \n");
		//System.out.println("6.Delete DocumentObject in an existing collection \n");
		//System.out.println("7.Retrieve All Documents in an existing collection \n");
		//System.out.println("8. Show all the available collections");
		
		
		//MongoCollection<Document> collection=getCollection(database);
		
//		MongoCollection<Document> collection = database.getCollection("FirstCollection");
//		System.out.println("Collection FirstCollection selected successfully");
		
	//createCollection(database);
		
			      //insertDocument(collection);
		    //  updateDocument(collection);
		//dropCollection(collection);
		  //  deleteDocument(collection);
	//		      retrieveAllDocument(collection);
			   //  getAllCollections(database);
			      
			      }
		
	
	private static void getCollection(MongoDatabase database) {
		MongoCollection<Document> collection=database.getCollection("FirstCollection");
		System.out.println("Collection FirstCollection selected successfully");
		
	}


	private static void createCollection(MongoDatabase database) {
		System.out.println("Enter the new collection name");
		Scanner input=new Scanner(System.in);
		
		
		String userCollection=input.next();
		database.createCollection(userCollection); 
	      System.out.println("Collection created successfully");
		
	}


	private static void getAllCollections(MongoDatabase database) {
		 for (String name : database.listCollectionNames()) { 
	         System.out.println(name); 
	      } 
		
	}


	private static void dropCollection(MongoCollection<Document> collection) {
		  collection.drop(); 
	      System.out.println("Collection dropped successfully");
		
	}


	private static void retrieveAllDocument(MongoCollection<Document> collection) {
		
		FindIterable<Document> iterDoc = collection.find(); 
	      int i = 1; 

	      // Getting the iterator 
	      Iterator it = iterDoc.iterator(); 
	    
	      while (it.hasNext()) {  
	         System.out.println(it.next());  
	         System.out.println("\n");
	         
	      i++;
	      }
		
	}

	private static void deleteDocument(MongoCollection<Document> collection) {
		
	     collection.deleteOne(Filters.eq("id", 1)); 
	      System.out.println("Document deleted successfully...");  
	}

	private static void updateDocument(MongoCollection<Document> collection) {
		collection.updateOne(Filters.eq("likes", 100), Updates.set("id", 150));
		collection.updateOne(Filters.eq("likes", 100), Updates.set("title","UpdatedDB"));
		
	      System.out.println("Document update successfully..."); 
		
	}

	private static void insertDocument(MongoCollection<Document> collection) {
		 Document document = new Document("title", "Document1") 
			      .append("id", 1)
			      .append("description", "This is Document 1") 
			      .append("content", "English") 
			      .append("url", "wipro") 
			      .append("by", "koi to h");  
			      collection.insertOne(document); 
			      System.out.println("Document inserted successfully");   
		
	}

}
