package cn.ucaner.mongo.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.junit.Before;
import org.junit.Test;

import com.mongodb.client.result.UpdateResult;
import cn.ucaner.mongo.dao.MongoDbDao;
import cn.ucaner.mongo.util.LoadMongoProps;

/**
* @Package：cn.ucaner.mongo.test   
* @ClassName：mongoDbTest   
* @Description：   <p> mongoDbTest </p>
* @Author： - DaoDou   
* @CreatTime：2017年12月29日 下午4:41:32   
* @Modify By：   
* @ModifyTime：  2017年12月29日
* @Modify marker：   
* @version    V1.0
 */
public class mongoDbTest {

	@Before
	public void before() {
		//MongoDbDao.connect("xxxx", "xxxxx", "192.168.200.xxxx", 27017);
		String addresses = LoadMongoProps.instance().getAddresses();
		String[] strs = addresses.split(":");
		Map<String, String> params = new HashMap<String, String>();
		params.put("port",strs[1]);
		params.put("hostName", strs[0]);
		params.put("databaseName", strs[0]);
		params.put("collectionName", strs[0]);
		String hostName = params.get("hostName");
		String databaseName = params.get("databaseName");
		String collectionName = params.get("collectionName");
		MongoDbDao.connectByProps(params);
	}

	@Test
	public void testInsert() {
		Document document = new Document();
		document.append("name", "test1").append("sex", "0");
		MongoDbDao.insert(document);
	}

	@Test
	public void testFindAll() {
		List<Document> results = MongoDbDao.queryAll();
		for (Document doc : results) {
			System.out.println(doc.toJson());
		}
	}

	@Test
	public void testFindBy() {
		Document filter = new Document();
		filter.append("name", "louis");
		List<Document> results = MongoDbDao.queryBy(filter);
		for (Document doc : results) {
			System.out.println(1 + "\t" + doc.toJson());
		}
	}

	@Test
	public void testUpdateOne() {
		Document filter = new Document();
		filter.append("name", "sex");
		// 注意update文档里要包含"$set"字段
		Document update = new Document();
		update.append("$set", new Document("name", "louis2"));
		UpdateResult result = MongoDbDao.updateOne(filter, update);
		System.out.println("matched count = " + result.getMatchedCount());
	}

	@Test
	public void testUpdateMany() {
		Document filter = new Document();
		filter.append("name", "louis");

		// 注意update文档里要包含"$set"字段
		Document update = new Document();
		update.append("$set", new Document("name", "male"));
		UpdateResult result = MongoDbDao.updateMany(filter, update);
		System.out.println("matched count = " + result.getMatchedCount());
	}

	@Test
	public void testReplace() {
		Document filter = new Document();
		filter.append("name", "louis");

		// 注意：更新文档时，不需要使用"$set"
		Document replacement = new Document();
		replacement.append("value", 123);
		MongoDbDao.replace(filter, replacement);
	}

	@Test
	public void testDeleteOne() {
		Document filter = new Document();
		filter.append("value", 123);
		MongoDbDao.deleteOne(filter);
	}

	@Test
	public void testDeleteMany() {
		Document filter = new Document();
		filter.append("name", "louis");
		MongoDbDao.deleteMany(filter);
	}

}
