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
package cn.ucaner.mongo.service.impl;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.TypeReference;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;

import cn.ucaner.mongo.DBConstant;
import cn.ucaner.mongo.DBConstant.DBCondition;
import cn.ucaner.mongo.dao.BaseMongoDao;
import cn.ucaner.mongo.entity.BaseMongoEntity;
import cn.ucaner.mongo.service.BaseMongoService;
import cn.ucaner.mongo.vo.ConditionVo;

/**
* @Package：cn.ucaner.mongo.service.impl   
* @ClassName：BaseMongoServiceImpl   
* @Description：   <p> BaseMongoServiceImpl</p>
* @Author： - DaoDou   
* @CreatTime：2018年1月12日 上午11:42:01   
* @Modify By：   
* @ModifyTime：  2018年1月12日
* @Modify marker：   
* @version    V1.0
 */
public abstract class BaseMongoServiceImpl<T extends BaseMongoEntity, PK extends Serializable> implements BaseMongoService<T, PK> {
	/**
	 * 获取数据库操作类
	 * 
	 * @return
	 */
	protected abstract BaseMongoDao<T, PK> getDao();

	@Override
	public T find(T entity) {
		return getDao().find(entity);
	}

	@Override
	public T findById(PK id) {
		return getDao().findById(id);
	}

	@Override
	public List<T> findByIds(List<PK> ids) {
		return getDao().findByIds(ids);
	}

	@Override
	public List<T> findList(T entity) {
		return getDao().findList(entity);
	}

	@Override
	public PageInfo<T> findListByPage(Map<String, Object> conditionMap, Map<String, Object> sortMap, Page<T> page) {
		BasicDBObject condition = convertMapToDBObject(conditionMap);
		BasicDBObject sort = convertMapToDBObject(sortMap);
		return getDao().findListByPage(condition, sort, page);
	}

	@Override
	public List<T> findAll() {
		return getDao().findAll();
	}

	@Override
	public Long count() {
		return getDao().count();
	}

	@Override
	public Long count(T entity) {
		return getDao().count(entity);
	}

	@Override
	public PK insert(T entity) {
		return getDao().insert(entity);
	}

	@Override
	public void delete(T entity) {
		getDao().delete(entity);
	}

	/**
	 * @Description 生成索引
	 * @param fieldNames
	 * @return 索引Name
	 * @date 2017年6月5日
	 */
	@Override
	public String createIndex(String fieldNames) {
		return getDao().createIndex(fieldNames);
	}

	@Override
	public void deleteById(PK id) {
		getDao().deleteById(id);
	}

	@Override
	public void deleteByIds(List<PK> ids) {
		getDao().deleteByIds(ids);
	}

	@Override
	public void deleteAll() {
		getDao().deleteAll();
	}

	@Override
	public void update(T entity) {
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put(DBConstant.PK_FIELD, entity.get_id());

		Map<String, Object> updateMap = com.alibaba.fastjson.JSON.parseObject(com.alibaba.fastjson.JSON.toJSONString(this),
				new TypeReference<Map<String, Object>>() {
				});
		update(conditionMap, updateMap);
	}

	@Override
	public boolean check(Map<String, Serializable> params) {
		return getDao().check(params);
	}

	@Override
	public void batchDelete(List<PK> ids) {
		getDao().batchDelete(ids);
	}

	@Override
	public void batchInsert(List<T> entitys) {
		getDao().batchInsert(entitys);
	}

	@Override
	public void batchUpdate(List<T> entitys) {
		getDao().batchUpdate(entitys);
	}

	/**
	 * @Description 根据对象属性查找对象,多个条件默认and连接
	 * @param paraMap
	 * @return
	 * @date 2017年6月5日
	 */
	@Override
	public List<T> findByParams(Map<String, Object> paraMap) {
		// TODO Auto-generated method stub
		BasicDBObject queryCond = new BasicDBObject();

		for (String key : paraMap.keySet()) {
			queryCond.put(key, paraMap.get(key));
		}
		return getDao().findByCondition(queryCond);
	}

	/**
	 * @Description 根据条件查询 多个条件默认and连接
	 * @param vos
	 * @return
	 * @date 2017年6月6日
	 */
	@Override
	public List<T> findByCondition(ConditionVo... vos) {
		BasicDBObject condition = convertConditionVoToDBObject(Arrays.asList(vos));
		return getDao().findByCondition(condition);
	}

	/**
	 * @Description 根据条件更新信息 多个条件为and连接,条件都为等值判断,
	 * @param conditionMap
	 * @param updateMap
	 * @date 2017年6月6日
	 */
	@Override
	public Long update(Map<String, Object> conditionMap, Map<String, Object> updateMap) {
		long updateCount = 0;
		if (!CollectionUtils.isEmpty(updateMap)) {
			BasicDBObject condition = convertMapToDBObject(conditionMap);
			BasicDBObject update = convertMapToDBObject(updateMap);
			if (update != null) {
				updateCount = getDao().update(condition, update);
			}
		}
		return updateCount;
	}

	/**
	 * @Description 根据条件更新信息 多个条件为and连接
	 * @param conditions
	 * @param updateMap
	 * @date 2017年6月6日
	 * @return 更新记录的条数
	 */
	@Override
	public Long update(List<ConditionVo> conditions, Map<String, Object> updateMap) {
		long updateCount = 0;
		if (!CollectionUtils.isEmpty(updateMap)) {
			BasicDBObject condition = convertConditionVoToDBObject(conditions);
			BasicDBObject update = convertMapToDBObject(updateMap);
			if (update != null) {
				updateCount = getDao().update(condition, update);
			}
		}
		return updateCount;
	}

	/**
	 * @Description Map参数对象转BasicDBObject对象 逻辑连接:and
	 * @param infoMap
	 * @return
	 * @date 2017年6月5日
	 */
	protected BasicDBObject convertMapToDBObject(Map<String, Object> infoMap) {
		if (!CollectionUtils.isEmpty(infoMap)) {
			BasicDBObject dbObj = new BasicDBObject();
			for (String key : infoMap.keySet()) {
				dbObj.put(key, infoMap.get(key));
			}
			return dbObj;
		} else {
			return null;
		}
	}

	/**
	 * @Description ConditionVo集合转BasicDBObject 条件对象 逻辑连接:and
	 * @param vos
	 * @return
	 * @date 2017年6月6日
	 */
	protected BasicDBObject convertConditionVoToDBObject(List<ConditionVo> vos) {
		BasicDBObject condition = new BasicDBObject();
		if (CollectionUtils.isEmpty(vos)) {
			BasicDBList condList = new BasicDBList();
			for (ConditionVo vo : vos) {
				BasicDBObject cond = new BasicDBObject();
				cond.put(vo.getComparsionCondition(), vo.getFieldVal());

				BasicDBObject composeCond = new BasicDBObject();
				composeCond.put(vo.getFieldName(), cond);

				condList.add(composeCond);
			}
			condition.put(DBCondition.AND.getKeyword(), condList);
		}
		return condition;
	}
}
