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
package cn.ucaner.mongo.entity;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

/**
* @Package：cn.ucaner.mongo.entity   
* @ClassName：BaseMongoEntity   
* @Description：   <p> BaseMongoEntity</p>
* @Author： - DaoDou   
* @CreatTime：2018年1月12日 上午11:42:17   
* @Modify By：   
* @ModifyTime：  2018年1月12日
* @Modify marker：   
* @version    V1.0
 */
public abstract class BaseMongoEntity implements Serializable {

	private static final long serialVersionUID = 1772706032833294100L;

	protected Long _id;

	@JSONField(name = "_id")
	public Long get_id() {
		return buildDbObjectId();
	}

	@JSONField(name = "_id")
	public void set_id(Long _id) {
		this._id = _id;
	}

	public abstract Long buildDbObjectId();

}
