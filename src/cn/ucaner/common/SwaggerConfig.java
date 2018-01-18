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
package cn.ucaner.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

/**     
* @Package：cn.ucaner.common   
* @ClassName：SwaggerConfig   
* @Description：   <p> SwaggerConfig</p>
* @Author： - DaoDou   
* @CreatTime：2018年1月17日 上午11:57:26   
* @Modify By：   
* @ModifyTime：  2018年1月17日
* @Modify marker：   
* @version    V1.0
*/
@Configuration
@EnableSwagger
@EnableWebMvc
public class SwaggerConfig {
	
    private SpringSwaggerConfig springSwaggerConfig;
    
    /**
     * @Description: 注入springSwaggerConfig
     * @param springSwaggerConfig void
     * @Autor:Jason-2018年1月18日
     */
    @Autowired
    public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig){
        this.springSwaggerConfig = springSwaggerConfig;
    }
 
    @Bean
    public SwaggerSpringMvcPlugin customImplementation(){
         return new SwaggerSpringMvcPlugin(this.springSwaggerConfig)
         .apiInfo(apiInfo())
         .includePatterns(".*?");
    }
    
 
    private ApiInfo apiInfo(){
        ApiInfo apiInfo = new ApiInfo(
                "UcanerX - Mongo", 
                "Mongo-API + Swagger [接口文档]",
                "Api 接口", 
                "jasonandy@hotmail.com", 
                "API Licence",
                "http:mmongo.ucaner.cn");
        return apiInfo;
    }
}