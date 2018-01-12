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
package cn.ucaner.mongo.test.dao;

import cn.ucaner.mongo.dao.BaseMongoDao;
import cn.ucaner.mongo.test.TestEntity;

/**
* @Package：cn.ucaner.mongo.test.dao   
* @ClassName：TestEntityDao   
* @Description：   <p> TestEntityDao</p>
* @Author： - DaoDou   
* @CreatTime：2018年1月12日 上午11:41:11   
* @Modify By：   
* @ModifyTime：  2018年1月12日
* @Modify marker：   
* @version    V1.0
 */
public interface TestEntityDao extends BaseMongoDao<TestEntity, Long> {

}
