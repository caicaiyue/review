package review;
import java.util.Set;

import com.mongodb.*;

public class ConnectMongo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MongoClient mongoClient = new MongoClient("192.168.2.151",30000);  //����IP���˿���mongo
		DB db = mongoClient.getDB("nsitedb");   //ѡ�����ݿ�
		Set<String> collectionNames = db.getCollectionNames();
		System.out.println(db.getName()+ "�������¼��ϣ�" + collectionNames.size());
		for (String collectionName : collectionNames) {
			System.out.println(collectionName);
		}
		 System.out.println("���ݿ����ӳɹ�");
	}

}
