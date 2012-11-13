package mrs;

import com.mongodb.Mongo;
import com.mongodb.WriteConcern;

public class MongoSingleton {
	
	public static Mongo mongoInstance;

	public static Mongo getInstance()
	{
		if(!(mongoInstance == null))
		{
			return mongoInstance;
		}
		
		try {
			mongoInstance = new Mongo("ec2-54-243-59-26.compute-1.amazonaws.com",27017);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mongoInstance.setWriteConcern(WriteConcern.SAFE);
		 
		 return mongoInstance;
	}

}
