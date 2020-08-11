package review;
import java.util.Set;

import com.mongodb.*;

public class ConnectMongo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MongoClient mongoClient = new MongoClient("192.168.2.151",30000);  //根据IP、端口连mongo
		DB db = mongoClient.getDB("nsitedb");   //选择数据库
		Set<String> collectionNames = db.getCollectionNames();
		System.out.println(db.getName()+ "包含如下集合：" + collectionNames.size());
		for (String collectionName : collectionNames) {
			System.out.println(collectionName);
		}
		 System.out.println("数据库连接成功");
	}

}
