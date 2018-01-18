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
package cn.ucaner.common.api.vo;

import java.util.Map;

/**     
* @Package：cn.ucaner.common.api.vo   
* @ClassName：ParmsVo   
* @Description：   <p> ParmsVo 传输参数</p>
* @Author： - DaoDou   
* @CreatTime：2018年1月18日 下午3:10:14   
* @Modify By：   
* @ModifyTime：  2018年1月18日
* @Modify marker：   
* @version    V1.0
*/
public class ParmsVo {
	
	private String id;
	
	private Object obj;
	
	private Map<String, Object> parmas;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public Map<String, Object> getParmas() {
		return parmas;
	}

	public void setParmas(Map<String, Object> parmas) {
		this.parmas = parmas;
	}

}
