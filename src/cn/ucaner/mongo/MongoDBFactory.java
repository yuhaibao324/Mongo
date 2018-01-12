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
package cn.ucaner.mongo;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.MongoException;
import com.mongodb.ServerAddress;

import cn.ucaner.mongo.config.MongoDBConfig;

/**
* @Package：cn.ucaner.mongo   
* @ClassName：MongoDBFactory   
* @Description：   <p> MongoDBFactory</p>
* @Author： - DaoDou   
* @CreatTime：2018年1月12日 上午11:37:22   
* @Modify By：   
* @ModifyTime：  2018年1月12日
* @Modify marker：   
* @version    V1.0
 */
public class MongoDBFactory {
	
	private MongoDBConfig config;
	
	private static MongoClient client;
	
	public static String DEFAULT_DATA_BASE;

	private void init() {
		// 构建server列表
		List<ServerAddress> serverList = new ArrayList<ServerAddress>();
		if (StringUtils.isNotBlank(config.getServerAddresses())) {
			String[] serverAddressArray = config.getServerAddresses().split(",");
			for (String serverAddress : serverAddressArray) {
				if (StringUtils.isBlank(serverAddress) || serverAddress.indexOf(":") < 0 || serverAddress.split(":").length != 2) {
					throw new MongoException("serverAddress is invalid for mongoDB connection.serverAddress:" + serverAddress);
				} else {
					ServerAddress server = new ServerAddress(serverAddress.split(":")[0], Integer.valueOf(serverAddress.split(":")[1]));
					serverList.add(server);
				}
			}
		} else {
			throw new MongoException("not found address config for mongoDB connection!");
		}
		if (serverList.size() == 0) {
			throw new MongoException("not config serverAddress for mongoDB connection!");
		}

		// 构建鉴权信息
		List<MongoCredential> credentialsList = new ArrayList<MongoCredential>();
		credentialsList.add(MongoCredential.createScramSha1Credential(config.getUser(), config.getDataBase(), config.getPassWord().toCharArray()));

		// 构建操作选项,默认参数满足大多数场景
		MongoClientOptions options = MongoClientOptions.builder().sslEnabled(config.getSslEnabled())
				.connectionsPerHost(config.getConnectionsPerHost())
				.threadsAllowedToBlockForConnectionMultiplier(config.getThreadsAllowedToBlockForConnectionMultiplier())
				.maxWaitTime(config.getMaxWaitTime()).connectTimeout(config.getConnectTimeout()).socketTimeout(config.getSocketTimeout()).build();
		client = new MongoClient(serverList, credentialsList, options);
		DEFAULT_DATA_BASE = config.getDataBase();
	}

	public MongoClient createClient() {
		if (client == null) {
			init();
		}
		return client;
	}

	public MongoDBConfig getConfig() {
		return config;
	}

	public void setConfig(MongoDBConfig config) {
		this.config = config;
	}
}
