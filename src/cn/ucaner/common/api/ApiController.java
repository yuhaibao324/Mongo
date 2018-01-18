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
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

import cn.ucaner.common.api.vo.Entity;
import cn.ucaner.common.api.vo.ParmsVo;
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
@ApiModel(description = "api归类！")
public class ApiController {
	
	private static Logger logger = LoggerFactory.getLogger(ApiController.class);
	
	@Autowired
	private TestEntityService testEntityService;
	
	@ResponseBody
	@RequestMapping(value = "/add",method=RequestMethod.POST)
	@ApiOperation(value = "apidoc添加操作",notes = "这是一个实现Swagger演示案例，结合SwaagerUI 学习使用!")
	@ApiParam(name = "参数名称", value = "参数具体描述")
	@ApiResponses({ @ApiResponse(code = 200, message = "Sunds Intersting!") })
	public Long add(ParmsVo parmas) {
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
	
	
	@ResponseBody
	@RequestMapping(value = "/test",method=RequestMethod.POST)
	@ApiOperation(value = "apidoc添加test操作",notes = "Swagger演示案例,结合SwaagerUI 学习使用!",response = Entity.class)
	@ApiParam(name = "参数名称entity", value = "参数具体描述one two three")
	public Entity test(Entity entity) {
		Entity entt = new Entity();
		entt.setOne("One");
		entt.setTwo("Two");
		entt.setThree("Three");
		System.out.println(JSON.toJSONString(entity));
		return entt;
	}
	
}
