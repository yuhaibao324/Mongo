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
package cn.ucaner.mongo;

/**
* @Package：cn.ucaner.mongo   
* @ClassName：DBConstant   
* @Description：   <p> DBConstant</p>
* @Author： - DaoDou   
* @CreatTime：2018年1月12日 上午11:37:31   
* @Modify By：   
* @ModifyTime：  2018年1月12日
* @Modify marker：   
* @version    V1.0
 */
public class DBConstant {
	/**
	 * mongoDB 主键的固定名称
	 */
	public static final String PK_FIELD = "_id";

	public static final int SORT_ASC = 1;

	public static final int SORT_DESC = -1;

	/**
	 * @Description MongoDB 条件操作符号
	 * @Why&What is modify
	 */
	public enum DBCondition {
		/**
		 * 等值条件 eg:find({"name":{$eq:"steven"}})
		 */
		EQ("$eq"),

		/**
		 * 大于 eg:find({"age":{$gt:19}})
		 */
		GT("$gt"),

		/**
		 * 大于等于
		 */
		GTE("$gte"),
		/**
		 * 小于
		 */
		LT("$lt"),
		/**
		 * 小于等于
		 */
		LTE("$lte"),
		/**
		 * 不等于
		 */
		NE("$ne"),

		/**
		 * 在...范围 eg：find({"name":{$in:["steven","jack"]}})
		 */
		IN("$in"),
		/**
		 * 不在...范围
		 */
		NIN("$nin"),

		/**
		 * eg: find({"$or" : [{"name":"steven"},{"age":20}]})
		 */
		OR("$or"),

		/**
		 * find({"$and" : [{"name":"steven"},{"age":20}]})
		 */
		AND("$and"),

		/**
		 * eg:age 大于等于20<br>
		 * find({"age":{"$not":{"$lt":20}}})
		 */
		NOT("$not"),

		/**
		 * eg:name=steven 或者 age=20 的全部过滤掉<br>
		 * find({"$nor" : [{"name":"steven"},{"age":20}]})
		 */
		NOR("$nor"),

		/**
		 * eg:<br>
		 * find({"name":{"$exists":true}}) 包含name这个key的文档全部返回<br>
		 * find({"name":{"$exists":false}}) 不包含name这个key的文档全部返回<br>
		 */
		EXISTS("$exists"),

		/**
		 * eg：返回所有name字段为String类型的所有文档<br>
		 * find({"name":{"$type":2}})
		 */
		TYPE("$type"),

		/**
		 * eg:返回age的值和 4 求余后 结果为 0 的数据<br>
		 * find({"age" : {"$mod" : [4,0]}})
		 */
		MOD("$mod"),

		/**
		 * eg:返回 name 符合指定正则的数据，option选项限定正则的形式<br>
		 * find({"name" : {$regex:"stev*",$options:"i"}})
		 */
		REGEX("$regex"),
		/**
		 * 
		 */
		TEXT("$text"),
		/**
		 * 
		 */
		WHERE("$where"),
		/**
		 * 
		 */
		ALL("$all"),
		/**
		 * 
		 */
		ELEMMATCH("$elemMatch"),
		/**
		 * 
		 */
		SIZE("$size"),
		/**
		 * 
		 */
		COMMENT("$comment"),
		/**
		 * 
		 */
		GEOWITHIN("$geoWithin"),
		/**
		 * 
		 */
		GEOINTERSECTS("$geoIntersects"),
		/**
		 * 
		 */
		NEAR("$near"),
		/**
		 * 
		 */
		NEARSPHERE("$nearSphere"),
		/**
		 * 
		 */
		META("$meta"),
		/**
		 * 数组类型字段的投影操作，返回原来数据的一个子集.针对一个数组，其有如下几种返回子集的方式<br>
		 * eg:<br>
		 * 返回博客的前10条评论 find({"comments":{"$slice":10}}) <br>
		 * 返回博客的后10条评论 find({"comments":{"$slice":-10}}) <br>
		 * 返回博客跳过前10条，然后返回第11 ~ 15条 find({"comments":{"$slice":[10,5]}})
		 */
		SLICE("$slice");

		private String keyword;

		private DBCondition(String keyword) {
			this.keyword = keyword;
		}

		public String getKeyword() {
			return keyword;
		}

		public void setKeyword(String keyword) {
			this.keyword = keyword;
		}
	}

	public enum DBOperational {
		/**
		 * 增加一个指定值<br>
		 * eg:<br>
		 * 对指定字段进行增量增加，当字段不存在时，则在该文档中添加字段并赋值 <br>
		 * doc.updateOne(Filters.eq("name", "张三"), new Document("$inc",new Document("age",10)));
		 */
		INC("$inc"),

		/**
		 * $mul的用法与$inc的用法差不多，差别在于$mul为相乘，$inc为相加，若字段不存在，添加字段并赋值为0
		 */
		MUL("$mul"),
		/**
		 * 
		 * 修改document的字段名<br>
		 * doc.updateOne(Filters.eq("name", "张三"), new Document("$rename",new Document("phone","telPhone")));
		 */
		RENAME("$rename"),

		/**
		 * 
		 */
		SET_ON_INSERT("$setOnInsert"),

		/**
		 * 只修改指定字段值，当字段不存在时，则在该文档中添加一个新的字段并赋值
		 *
		 * doc.updateOne(Filters.eq("age", 20), new Document("$set",new Document("sex",2222)));
		 */
		SET("$set"),

		/**
		 * 
		 */
		UN_SET("$unset"),
		/**
		 * 
		 */
		MIN("$min"),
		/**
		 * 
		 */
		MAX("$max"),
		/**
		 * 
		 */
		CURRENT_DATE("$currentDate");

		private String keyword;

		private DBOperational(String keyword) {
			this.keyword = keyword;
		}

		public String getKeyword() {
			return keyword;
		}

		public void setKeyword(String keyword) {
			this.keyword = keyword;
		}
	}
}
