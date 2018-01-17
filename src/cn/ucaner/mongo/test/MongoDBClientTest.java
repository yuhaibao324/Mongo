/**
 * <html>
 * <body>
 *  <P> Copyright 1994-2018 JasonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 2018年1月12日 </p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.mongo.test;

import cn.ucaner.mongo.test.service.TestEntityService;
import cn.ucaner.mongo.util.Hashing;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.junit.Test;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**     
* @Package：cn.ucaner.mongo.test   
* @ClassName：MongoDBClientTest   
* @Description：   <p> MongoDBClientTest</p>
* @Author： - DaoDou   
* @CreatTime：2018年1月12日 下午3:42:41   
* @Modify By：   
* @ModifyTime：  2018年1月12日
* @Modify marker：   
* @version    V1.0
*/
public class MongoDBClientTest {
	
	private static Logger logger = LoggerFactory.getLogger(MongoDBClientTest.class);
	
	@Autowired
	private TestEntityService testEntityService;
	
	@Test
	public void save() {
		TestEntity entity = new TestEntity();
		entity.set_id(11111L);
		Long entity_Id = testEntityService.insert(entity);
		logger.info("id:{}",entity_Id);
	}

	@Test
	public void findById() {
		Long id = Hashing.MURMUR_HASH.hash("Ucaner");
		TestEntity entity = testEntityService.findById(id);
		logger.info("name:{}", entity.getName());
	}

	@Test
	public void createIndex() {
		String indexName = testEntityService.createIndex("name");
		logger.info("indexName:{}", indexName);
	}

	@Test
	public void findByParams() {
		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("code", "Ucaner");
		paraMap.put("project", "MongoDB");
		List<TestEntity> entities = testEntityService.findByParams(paraMap);
		for (TestEntity entity : entities) {
			logger.info("queryRes:{}", JSON.toJSONString(entity, SerializerFeature.NotWriteDefaultValue));
		}
	}

}
