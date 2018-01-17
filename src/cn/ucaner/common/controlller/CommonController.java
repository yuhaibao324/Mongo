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
package cn.ucaner.common.controlller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**     
* @Package：cn.ucaner.common.controlller   
* @ClassName：CommonController   
* @Description：   <p> CommonController api 路由</p>
* @Author： - DaoDou   
* @CreatTime：2018年1月17日 下午1:58:49   
* @Modify By：   
* @ModifyTime：  2018年1月17日
* @Modify marker：   
* @version    V1.0
*/
@Controller
@RequestMapping("/mongo")
public class CommonController {
	
	@RequestMapping("/swagger")
    public ModelAndView swagger() {
		///Mongo/WebRoot/WEB-INF/views/swagger/index.ftl
        ModelAndView model = new ModelAndView("swagger/index");
        return model;
    }

}
