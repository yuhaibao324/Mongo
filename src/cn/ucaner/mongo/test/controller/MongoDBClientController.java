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
package cn.ucaner.mongo.test.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import cn.ucaner.mongo.test.MongoDBClientTest;
import cn.ucaner.mongo.test.TestEntity;
import cn.ucaner.mongo.test.service.TestEntityService;
import cn.ucaner.mongo.util.Hashing;

/**     
* @Package：cn.ucaner.mongo.test.controller   
* @ClassName：MongoDBClientController   
* @Description：   <p> MongoDBClientController</p>
* @Author： - DaoDou   
* @CreatTime：2018年1月12日 下午3:50:52   
* @Modify By：   
* @ModifyTime：  2018年1月12日
* @Modify marker：   
* @version    V1.0
*/
@Controller
@RequestMapping("/mongo/test")
public class MongoDBClientController {
	
private static Logger logger = LoggerFactory.getLogger(MongoDBClientTest.class);
	
	@Autowired
	private TestEntityService testEntityService;
	
	
	@RequestMapping(value = "/mongoTest")
	public ModelAndView mongoTest() {
		ModelAndView view =new ModelAndView("/login");;
		return view;
	}

	/**
	 * @Description: add测试
	 * @return Long
	 * @Autor:Jason-2018年1月12日
	 */
	@ResponseBody
	@RequestMapping(value = "/add")
	public Long save() {
		TestEntity entity = new TestEntity();
		entity.set_id(11111L);
		Long entity_Id = testEntityService.insert(entity);
		logger.info("id:{}",entity_Id);
		return entity_Id;
	}
	
	/**
	 * @Description:  创建索引
	 * @Autor:Jason-2018年1月12日
	 */
	@ResponseBody
	@RequestMapping(value = "/index")
	public void index() {
		String indexName = testEntityService.createIndex("name");
		logger.info("indexName:{}", indexName);
	}
	
	/**
	 * @Description: 根据参数查询数据
	 * @return List<TestEntity>
	 * @Autor:Jason-2018年1月12日
	 */
	@ResponseBody
	@RequestMapping(value = "/find")
	public List<TestEntity> findParams() {
		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("code", "Ucaner");
		paraMap.put("project", "MongoDB");
		List<TestEntity> entities = testEntityService.findByParams(paraMap);
		for (TestEntity entity : entities) {
			logger.info("queryRes:{}", JSON.toJSONString(entity, SerializerFeature.NotWriteDefaultValue));
		}
		return entities;
	}
	
	
	
	
	
	
	public void findById() {
		Long id = Hashing.MURMUR_HASH.hash("Ucaner");
		TestEntity entity = testEntityService.findById(id);
		logger.info("name:{}", entity.getName());
	}

	public void createIndex() {
		String indexName = testEntityService.createIndex("name");
		logger.info("indexName:{}", indexName);
	}

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
