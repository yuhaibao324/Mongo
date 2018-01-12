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
package cn.ucaner.mongo.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.mongodb.BasicDBObject;

import cn.ucaner.mongo.entity.BaseMongoEntity;

/**
* @Package：cn.ucaner.mongo.dao   
* @ClassName：BaseMongoDao   
* @Description：   <p> BaseMongoDao</p>
* @Author： - DaoDou   
* @CreatTime：2018年1月12日 上午11:42:34   
* @Modify By：   
* @ModifyTime：  2018年1月12日
* @Modify marker：   
* @version    V1.0
 */
public interface BaseMongoDao<T extends BaseMongoEntity, PK extends Serializable> {
	/**
	 * 查询
	 * 
	 * @param entity
	 * @return
	 */
	public T find(T entity);

	/**
	 * 通过Id查询
	 * 
	 * @param id
	 * @return
	 */
	public T findById(PK id);

	/**
	 * 根据ID集合来查询
	 * 
	 * @param ids
	 * @return
	 */
	public List<T> findByIds(List<PK> ids);

	/**
	 * 查询列表
	 * 
	 * @param entity
	 * @return
	 */
	public List<T> findList(T entity);

	/**
	 * 查询列表
	 * 
	 * @param condition
	 *            查询条件
	 * @param page
	 *            sort 排序字段和排序规则
	 * @return
	 */
	public PageInfo<T> findListByPage(BasicDBObject condition, BasicDBObject sort, Page<T> page);

	/**
	 * 查询所有记录
	 * 
	 * @return
	 */
	public List<T> findAll();

	/**
	 * 查询总记录数
	 * 
	 * @return
	 */
	public Long count();

	/**
	 * 查询总记录数
	 * 
	 * @param entity
	 * @return
	 */
	public Long count(T entity);

	/**
	 * 添加
	 * 
	 * @param entity
	 */
	public PK insert(T entity);

	/**
	 * 删除
	 * 
	 * @param entity
	 */
	public void delete(T entity);

	/**
	 * 根据Id删除
	 * 
	 * @param id
	 */
	public void deleteById(PK id);

	/**
	 * 根据ID集合删除
	 * 
	 * @param ids
	 */
	public void deleteByIds(List<PK> ids);

	/**
	 * 删除所有记录
	 */
	public void deleteAll();

	/**
	 * 检查数据是否已经存在
	 * 
	 * @param params
	 * @return
	 */
	public boolean check(Map<String, Serializable> params);

	/**
	 * 根据ID集合批量删除
	 * 
	 * @param ids
	 */
	public void batchDelete(List<PK> ids);

	/**
	 * 批量插入
	 * 
	 * @param entitys
	 */
	public void batchInsert(List<T> entitys);

	/**
	 * 批量更新
	 * 
	 * @param entitys
	 */
	public void batchUpdate(List<T> entitys);

	/**
	 * @Description 生成索引
	 * @param fieldNames
	 * @return 索引Name
	 * @date 2017年6月5日
	 */
	public String createIndex(String fieldNames);

	/**
	 * @Description 根据查询条件查找对象
	 * @param queryCond
	 * @return
	 * @date 2017年6月5日
	 */
	public List<T> findByCondition(BasicDBObject queryCond);

	/**
	 * @Description
	 * @param condition
	 *            更新条件
	 * @param newObj
	 *            需更新的信息 <br>
	 *            eg:将name=yuce的记录的年龄更新为32<br>
	 *            BasicDBObject condition = new BasicDBObject();<br>
	 *            condition.put("name","yuce");<br>
	 *            BasicDBObject newObj=new BasicDBObject();<br>
	 *            newObj.put("age",32);<br>
	 *            update(condition , newObj);
	 * @date 2017年6月5日
	 */
	public Long update(BasicDBObject condition, BasicDBObject newObj);
}
