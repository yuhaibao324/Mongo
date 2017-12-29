package cn.ucaner.mongo.base;

import java.util.ArrayList;  
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;  
import com.mongodb.MongoCredential;  
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;  

/**
* @Package：cn.ucaner.mongo.base   
* @ClassName：MongoJDBC   
* @Description：   <p> MongoJDBC 链接</p>
* @Author： - DaoDou   
* @CreatTime：2017年12月29日 下午3:14:44   
* @Modify By：   
* @ModifyTime：  2017年12月29日
* @Modify marker：   
* @version    V1.0
 */
public class MongoJDBC {  
	
    public static void main(String[] args){  
        try {  
            //连接到MongoDB服务 如果是远程连接可以替换“localhost”为服务器所在IP地址  
            //ServerAddress()两个参数分别为 服务器地址 和 端口  
            ServerAddress serverAddress = new ServerAddress("66.112.210.101",27017);  
            List<ServerAddress> addrs = new ArrayList<ServerAddress>();  
            addrs.add(serverAddress);  
            //MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码  
            MongoCredential credential = MongoCredential.createScramSha1Credential("admin", "ucaner", "admin".toCharArray());  
            List<MongoCredential> credentials = new ArrayList<MongoCredential>();  
            credentials.add(credential);  
            //通过连接认证获取MongoDB连接  
            MongoClient mongoClient = new MongoClient(addrs,credentials);  
            //连接到数据库  
            MongoDatabase mongoDatabase = mongoClient.getDatabase("ucaner");
            
            System.out.println(mongoDatabase.getName());
            System.out.println("Connect to database successfully");

            //创建集合
            mongoDatabase.createCollection("test");
            //----------------------------------------
            MongoCollection<Document> collection = mongoDatabase.getCollection("test");
            
            /** 
             * 1. 创建文档 org.bson.Document 参数为key-value的格式 
             * 2. 创建文档集合List<Document> 
             * 3. 将文档集合插入数据库集合中 mongoCollection.insertMany(List<Document>) 插入单个文档可以用 mongoCollection.insertOne(Document) 
             * */
             Document document = new Document("title", "MongoDB").  
             append("description", "database").  
             append("likes", 100).  
             append("by", "Fly");  
             List<Document> documents = new ArrayList<Document>();  
             documents.add(document);  
             //插入documents
             collection.insertMany(documents);  
             System.out.println("文档插入成功");  
        } catch (Exception e) {  
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );  
        }  
    }  
}  
