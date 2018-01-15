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
package cn.ucaner.mongo.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import cn.ucaner.mongo.entity.BaseMongoEntity;
import cn.ucaner.mongo.vo.ConditionVo;

/**
* @Package：cn.ucaner.mongo.service   
* @ClassName：BaseMongoService   
* @Description：   <p> BaseMongoService</p>
* @Author： - DaoDou   
* @CreatTime：2018年1月12日 上午11:41:45   
* @Modify By：   
* @ModifyTime：  2018年1月12日
* @Modify marker：   
* @version    V1.0
 */
public interface BaseMongoService<T extends BaseMongoEntity, PK extends Serializable> {
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
	 * @param conditionMap
	 *            条件
	 * @param sortMap
	 *            排序
	 * @param page
	 * @return
	 */
	public PageInfo<T> findListByPage(Map<String, Object> conditionMap, Map<String, Object> sortMap, Page<T> page);

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
	 * 更新
	 * 
	 * @param entity
	 */
	public void update(T entity);

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
	 */
	public String createIndex(String fieldNames);

	/**
	 * @Description 根据对象属性查找对象,多个条件默认and连接 条件都为等值判断
	 * @param paraMap
	 * @return
	 */
	public List<T> findByParams(Map<String, Object> paraMap);

	/**
	 * @Description 根据条件查询 多个条件默认and连接
	 * @param vos
	 * @return
	 * @return 更新记录的条数
	 */
	public List<T> findByCondition(ConditionVo... vos);

	/**
	 * @Description 根据条件更新信息 多个条件默认and连接,条件都为等值判断
	 * @param conditionMap
	 * @param updateMap
	 * @return 更新记录的条数
	 */
	public Long update(Map<String, Object> conditionMap, Map<String, Object> updateMap);

	/**
	 * @Description 根据条件更新信息 多个条件为and连接
	 * @param conditions
	 * @param updateMap
	 * @return 更新记录的条数
	 */
	public Long update(List<ConditionVo> conditions, Map<String, Object> updateMap);

}
