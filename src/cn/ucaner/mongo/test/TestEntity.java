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
package cn.ucaner.mongo.test;

import cn.ucaner.mongo.entity.BaseMongoEntity;
import cn.ucaner.mongo.util.Hashing;

/**
* @Package：cn.ucaner.mongo.test   
* @ClassName：TestEntity   
* @Description：   <p> TestEntity  </p>
* @Author： - DaoDou   
* @CreatTime：2018年1月12日 下午1:54:43   
* @Modify By：   
* @ModifyTime：  2018年1月12日
* @Modify marker：   
* @version    V1.0
 */
public class TestEntity extends BaseMongoEntity {


	private static final long serialVersionUID = 1732907054137857465L;

	/**
	 */
	private String name;

	/**
	 * 
	 */
	private String code;
	

	 
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}


	@Override
	public Long buildDbObjectId() {
		if (_id == null) {
			_id = Hashing.MURMUR_HASH.hash(code);
		}
		return _id;
	}
}
