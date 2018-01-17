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
package cn.ucaner.common.freemark;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

/**     
* @Package：cn.ucaner.common.freemark   
* @ClassName：CustomerFreeMark   
* @Description：   <p> 自定义视图解析器</p>
* @Author： - DaoDou   
* @CreatTime：2018年1月17日 下午2:04:22   
* @Modify By：   
* @ModifyTime：  2018年1月17日
* @Modify marker：   
* @version    V1.0
*/
public class CustomerFreeMark  extends FreeMarkerView{
	
	public static Logger logger = LoggerFactory.getLogger(CustomerFreeMark.class);
	
	public static String DEFAULT_VERSION_NUMBER = "1.0";
	
	@Override
	protected void exposeHelpers(Map<String, Object> model, HttpServletRequest request) throws Exception {
		String path = request.getContextPath();
		model.put("path", path);
		super.exposeHelpers(model, request);
	}

}
