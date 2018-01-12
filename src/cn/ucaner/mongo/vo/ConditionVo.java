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
package cn.ucaner.mongo.vo;

import cn.ucaner.mongo.DBConstant.DBCondition;

/**
* @Package：cn.ucaner.mongo.vo   
* @ClassName：ConditionVo   
* @Description：   <p> ConditionVo</p>
* @Author： - DaoDou   
* @CreatTime：2018年1月12日 上午11:37:42   
* @Modify By：   
* @ModifyTime：  2018年1月12日
* @Modify marker：   
* @version    V1.0
 */
public class ConditionVo {
	/**
	 * 字段名称
	 */
	private String fieldName;

	/**
	 * 字段值
	 */
	private Object fieldVal;

	/**
	 * 比较（Comparsion）操作条件
	 */
	private String ComparsionCondition;

	public ConditionVo() {
		super();
	}

	public ConditionVo(String fieldName, Object fieldVal, String comparsionCondition) {
		super();
		this.fieldName = fieldName;
		this.fieldVal = fieldVal;
		ComparsionCondition = comparsionCondition;
	}

	public ConditionVo(String fieldName, Object fieldVal) {
		super();
		this.fieldName = fieldName;
		this.fieldVal = fieldVal;
		ComparsionCondition = DBCondition.EQ.getKeyword();
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public Object getFieldVal() {
		return fieldVal;
	}

	public void setFieldVal(Object fieldVal) {
		this.fieldVal = fieldVal;
	}

	public String getComparsionCondition() {
		return ComparsionCondition;
	}

	public void setComparsionCondition(String comparsionCondition) {
		ComparsionCondition = comparsionCondition;
	}
}