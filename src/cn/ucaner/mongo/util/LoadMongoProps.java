package cn.ucaner.mongo.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
* @Package：cn.ucaner.mongo.util   
* @ClassName：LoadMongoProps  
* @Description：   <p> 加载配置文件 </p>
* @Author： - DaoDou   
* @CreatTime：2017年12月29日 下午3:24:22   
* @Modify By：   
* @ModifyTime：  2017年12月29日
* @Modify marker：   
* @version    V1.0
 */
public class LoadMongoProps{
	
	private static Logger logger = Logger.getLogger(LoadMongoProps.class);

	private static String FILE_NAME = "resources/mongo.properties";
	
	private static LoadMongoProps config = null;
	
	//private static HashMap<String,Object> propsMap = null;

	/**
	 * 数据库
	 */
	private String dataBase;
	
	/**
	 * 地址
	 */
	private String addresses;
	
	/**
	 * 用户名
	 */
	private String user;
	
	/**
	 * 密码
	 */
	private String passWord;
	
	
	/**
	 * 实例化配置文件
	 */
	public static LoadMongoProps instance() {
		if (config == null) {
			config = new LoadMongoProps();
			config.ReadMongoConfig();
		}
		return config;
	}
	
	public static String getConfigFile() {
		return FILE_NAME;
	}

	public static void setConfigFile(String file) {
		FILE_NAME = file;
	}


	public static LoadMongoProps getConfig() {
		return config;
	}

	public static void setConfig(LoadMongoProps config) {
		LoadMongoProps.config = config;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getDataBase() {
		return dataBase;
	}

	public void setDataBase(String dataBase) {
		this.dataBase = dataBase;
	}

	public String getAddresses() {
		return addresses;
	}

	public void setAddresses(String addresses) {
		this.addresses = addresses;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	
	@Override
	public String toString() {
		return "LoadMongoProps [user=" + user + ", dataBase=" + dataBase + ", addresses=" + addresses + ", passWord="
				+ passWord + "]";
	}
	
	/**
	 *读取配置文件 
	 */
	private void ReadMongoConfig() {
		Properties rb = new Properties();
		try {	
			logger.info("Loading  加载MongoDB配置文件 ["+FILE_NAME+"] ...");
			rb.load(new FileInputStream(FILE_NAME));
			user = rb.getProperty("mongo.server.user").trim();
			dataBase = rb.getProperty("mongo.server.dataBase").trim();
			addresses=rb.getProperty("mongo.server.addresses").trim();
			passWord = rb.getProperty("mongo.server.passWord").trim();
		/*	propsMap.put("dataBase", dataBase);
			propsMap.put("addresses", addresses);
			propsMap.put("user", user);
			propsMap.put("passWord", passWord);*/
		}catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
/*	public static HashMap<String, Object> getPropsMap() {
		return propsMap;
	}

	public static void setPropsMap(HashMap<String, Object> propsMap) {
		LoadMongoProps.propsMap = propsMap;
	}*/

	/**
	* @Description Test For Jason
	 */
	public static void main(String[] args) {
		System.out.println(LoadMongoProps.instance());
	}	
}
