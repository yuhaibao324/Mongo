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
package cn.ucaner.common.framework.log;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import ch.qos.logback.ext.spring.web.WebLogbackConfigurer;

/**     
* @Package：cn.ucaner.common.framework   
* @ClassName：LogbackConfigListener   
* @Description：   <p> LogbackConfigListener</p>
* @Author： - DaoDou   
* @CreatTime：2018年1月18日 下午1:39:21   
* @Modify By：   
* @ModifyTime：  2018年1月18日
* @Modify marker：   
* @version    V1.0
*/
public class LogbackConfigListener implements ServletContextListener{

	
	public LogbackConfigListener(){
		
    }
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		WebLogbackConfigurer.initLogging(sce.getServletContext());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		WebLogbackConfigurer.shutdownLogging(sce.getServletContext());
	}

}
