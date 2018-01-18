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
package cn.ucaner.common.api;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import cn.ucaner.mongo.test.TestEntity;
import cn.ucaner.mongo.test.service.TestEntityService;

/**     
* @Package：cn.ucaner.common.api   
* @ClassName：ApiController   
* @Description：   <p> ApiController</p>
* @Author： - DaoDou   
* @CreatTime：2018年1月17日 下午1:40:07   
* @Modify By：   
* @ModifyTime：  2018年1月17日
* @Modify marker：   
* @version    V1.0
*/
@Controller
@RequestMapping("/apidoc")
@Api(value="ApiController")
public class ApiController {
	
	private static Logger logger = LoggerFactory.getLogger(ApiController.class);
	
	@Autowired
	private TestEntityService testEntityService;
	
	@ResponseBody
	@RequestMapping(value = "/add",method=RequestMethod.POST)
	@ApiOperation(value = "接口说明",notes = "接口发布说明")
	@ApiParam(name = "参数名称", value = "参数具体描述")
	public Long save() {
		TestEntity entity = new TestEntity();
		//随机
		 long random = new Random().nextLong();
		entity.set_id(random);
		entity.setCode("HelloWorld!  -- good test Ucaner!");
		entity.setName("Jason");
		Long entity_Id = testEntityService.insert(entity);
		logger.info("id:{}",entity_Id);
		return entity_Id;
	}
	
}
