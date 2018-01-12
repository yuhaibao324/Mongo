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
package cn.ucaner.mongo.test.dao.impl;

import org.springframework.stereotype.Repository;

import cn.ucaner.mongo.dao.impl.BaseMongoDaoImpl;
import cn.ucaner.mongo.test.TestEntity;
import cn.ucaner.mongo.test.dao.TestEntityDao;

/**
* @Package：cn.ucaner.mongo.test.dao.impl   
* @ClassName：TestEntityDaoImpl   
* @Description：   <p> TODO</p>
* @Author： - DaoDou   
* @CreatTime：2018年1月12日 上午11:41:24   
* @Modify By：   
* @ModifyTime：  2018年1月12日
* @Modify marker：   
* @version    V1.0
 */
@Repository(value = "testEntityDao")
public class TestEntityDaoImpl extends BaseMongoDaoImpl<TestEntity, Long> implements TestEntityDao {

}
