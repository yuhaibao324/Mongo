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
package cn.ucaner.mongo.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Indexes;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.util.JSON;

import cn.ucaner.mongo.DBConstant;
import cn.ucaner.mongo.DBConstant.DBOperational;
import cn.ucaner.mongo.MongoDBFactory;
import cn.ucaner.mongo.dao.BaseMongoDao;
import cn.ucaner.mongo.entity.BaseMongoEntity;

/**
* @Package：cn.ucaner.mongo.dao.impl   
* @ClassName：BaseMongoDaoImpl   
* @Description：   <p> BaseMongoDaoImpl</p>
* @Author： - DaoDou   
* @CreatTime：2018年1月12日 上午11:42:58   
* @Modify By：   
* @ModifyTime：  2018年1月12日
* @Modify marker：   
* @version    V1.0
 */
public class BaseMongoDaoImpl<T extends BaseMongoEntity, PK extends Serializable> implements BaseMongoDao<T, PK> {
	
	@Resource
	protected MongoClient mongoClient;

	protected String dataBase;

	public String getDataBase() {
		return dataBase;
	}

	public void setDataBase(String dataBase) {
		this.dataBase = dataBase;
	}

	/**
	 * 获取接口的泛型类型，如果不存在则返回null
	 * @param clazz
	 * @return
	 */
	private Class<?> getGenericClass() {
		Type t = getClass().getGenericSuperclass();
		if (t instanceof ParameterizedType) {
			Type[] p = ((ParameterizedType) t).getActualTypeArguments();
			return ((Class<?>) p[0]);
		}
		return null;
	}

	/**
	 * 查找
	 */
	@Override
	public T find(T entity) {
		return null;
	}

	/**
	 * 根据id查找
	 */
	@Override
	public T findById(PK id) {
		MongoDatabase db = mongoClient.getDatabase(currentDataBase());
		MongoCollection<DBObject> collection = db.getCollection(getGenericClass().getName(), DBObject.class);
		DBObject object = collection.find(new BasicDBObject(DBConstant.PK_FIELD, id)).first();
		return (T) com.alibaba.fastjson.JSON.parseObject(object.toString(), getGenericClass());
	}

	/**
	 * 根据ids 查询list
	 */
	@Override
	public List<T> findByIds(List<PK> ids) {
		return null;
	}

	@Override
	public List<T> findList(T entity) {
		return null;
	}

	@Override
	public PageInfo<T> findListByPage(BasicDBObject condition, BasicDBObject sort, Page<T> page) {
		MongoDatabase db = mongoClient.getDatabase(currentDataBase());
		String className = getGenericClass().getName();
		//获取集合
		MongoCollection<DBObject> collection = db.getCollection(className, DBObject.class);
		int skip = page.getPageSize() * (page.getPageNum() - 1);
		MongoCursor<DBObject> cursor = collection.find(condition).sort(sort).skip(skip).limit(page.getPageSize()).iterator();

		PageInfo<T> info = new PageInfo<T>(new ArrayList<T>());
		info.setPageSize(page.getPageSize());
		info.setPageNum(page.getPageNum() + 1);
		while (cursor.hasNext()) {
			info.getList().add((T) com.alibaba.fastjson.JSON.parseObject(cursor.next().toString(), getGenericClass()));
		}
		return info;
	}

	@Override
	public List<T> findAll() {
		return null;
	}

	@Override
	public Long count() {
		return null;
	}

	@Override
	public Long count(T entity) {
		return null;
	}

	@Override
	public PK insert(T entity) {
		MongoDatabase db = mongoClient.getDatabase(currentDataBase());
		String className = entity.getClass().getName();
		DBObject dbObject = (DBObject) JSON.parse(com.alibaba.fastjson.JSON.toJSONString(entity));
		MongoCollection<DBObject> collection = db.getCollection(className, DBObject.class);
		collection.insertOne(dbObject);
		return (PK) entity.get_id();
	}

	@Override
	public void delete(T entity) {

	}

	@Override
	public void deleteById(PK id) {

	}

	@Override
	public void deleteByIds(List<PK> ids) {

	}

	@Override
	public void deleteAll() {

	}

	@Override
	public boolean check(Map<String, Serializable> params) {
		return false;
	}

	@Override
	public void batchDelete(List<PK> ids) {

	}

	@Override
	public void batchInsert(List<T> entitys) {
		if (!CollectionUtils.isEmpty(entitys)) {
			MongoDatabase db = mongoClient.getDatabase(currentDataBase());
			String className = entitys.get(0).getClass().getName();
			List<DBObject> dbObjects = new ArrayList<DBObject>();
			for (T entity : entitys) {
				DBObject dbObject = (DBObject) JSON.parse(com.alibaba.fastjson.JSON.toJSONString(entity));
				dbObjects.add(dbObject);
			}
			MongoCollection<DBObject> collection = db.getCollection(className, DBObject.class);
			collection.insertMany(dbObjects);
		}
	}

	@Override
	public void batchUpdate(List<T> entitys) {

	}

	private String currentDataBase() {
		if (StringUtils.isBlank(dataBase)) {
			dataBase = MongoDBFactory.DEFAULT_DATA_BASE;
		}
		return dataBase;
	}

	/**
	 * @Description 生成索引
	 * @param fieldNames
	 * @return 索引Name
	 */
	@Override
	public String createIndex(String fieldNames) {
		MongoDatabase db = mongoClient.getDatabase(currentDataBase());
		String className = getGenericClass().getName();
		MongoCollection<DBObject> collection = db.getCollection(className, DBObject.class);
		String indexName = collection.createIndex(Indexes.ascending(fieldNames));
		return indexName;
	}

	@Override
	public List<T> findByCondition(BasicDBObject queryCond) {
		MongoDatabase db = mongoClient.getDatabase(currentDataBase());
		String className = getGenericClass().getName();
		MongoCollection<DBObject> collection = db.getCollection(className, DBObject.class);
		MongoCursor<DBObject> cursor = collection.find(queryCond).iterator();
		List<T> list = new ArrayList<T>();
		while (cursor.hasNext()) {
			list.add((T) com.alibaba.fastjson.JSON.parseObject(cursor.next().toString(), getGenericClass()));
		}
		return list;
	}

	/**
	 * @Description
	 * @param condition
	 *            更新条件
	 * @param newObj
	 *            需更新的信息 <br>
	 *            eg:将name=yuce的记录的年龄更新为32<br>
	 *            BasicDBObject condition = new BasicDBObject();<br>
	 *            condition.put("name","jason");<br>
	 *            BasicDBObject newObj=new BasicDBObject();<br>
	 *            newObj.put("age",32);<br>
	 *            update(condition , newObj);
	 * @return 更新记录的条数<br>
	 *         注：通过updateOne，updateMany，replaceOne方法进行集合的文档更新。但是 _id 是不能更新的
	 */
	@Override
	public Long update(BasicDBObject condition, BasicDBObject newObj) {
		MongoDatabase db = mongoClient.getDatabase(currentDataBase());
		String className = getGenericClass().getName();
		MongoCollection<DBObject> collection = db.getCollection(className, DBObject.class);

		BasicDBObject setObj = new BasicDBObject(DBOperational.SET.getKeyword(), newObj);
		UpdateResult result = collection.updateMany(condition, setObj);
		return result.getModifiedCount();
	}
}
