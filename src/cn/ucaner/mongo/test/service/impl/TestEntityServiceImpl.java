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
package cn.ucaner.mongo.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ucaner.mongo.dao.BaseMongoDao;
import cn.ucaner.mongo.service.impl.BaseMongoServiceImpl;
import cn.ucaner.mongo.test.TestEntity;
import cn.ucaner.mongo.test.dao.TestEntityDao;
import cn.ucaner.mongo.test.service.TestEntityService;


/**
* @Package：cn.ucaner.mongo.test.service.impl   
* @ClassName：TestEntityServiceImpl   
* @Description：   <p> TestEntityServiceImpl</p>
* @Author： - DaoDou   
* @CreatTime：2018年1月12日 上午11:40:44   
* @Modify By：   
* @ModifyTime：  2018年1月12日
* @Modify marker：   
* @version    V1.0
 */
@Service(value = "testEntityService")
public class TestEntityServiceImpl extends BaseMongoServiceImpl<TestEntity, Long> implements TestEntityService {

	@Autowired
	private TestEntityDao testEntityDao;

	@Override
	protected BaseMongoDao<TestEntity, Long> getDao() {
		return testEntityDao;
	}
}
