# UcanerX
* Project：Ucaner
* OfficialWebsite：http://mongo.ucaner.cn
* describe：收集学习资料

# Ucaner

> You are what you want to be. - w.b

### Introduce:

Ucaner
MongoDB  学习

MongoDB整合一些常见的

MongoDB 是一个基于分布式文件存储的数据库,由C++语言编写,旨在为WEB应用提供可扩展的高性能数据存储解决方案.
mongoDB	是一个介于关系数据库和非关系数据库之间的产品，是非关系数据库当中功能最丰富，最像关系数据库的。
他支持的数据结构非常松散，是类似json的bson格式，因此可以存储比较复杂的数据类型。
Mongo最大的特点是他支持的查询语言非常强大，其语法有点类似于面向对象的查询语言，几乎可以实现类似关系数据库单表查询的绝大部分功能，而且还支持对数据建立索引。 



http://mongo.ucaner.cn


### Ucaner mongo


> 常见工具收集
- MongoDB JDBC
- 基本的类型的了解
- (文档)文档时mongodb中数据的基本单元，类似关系型数据库中的行。
- (集合)集合在mongodb中是一组文档，类似关系型数据库中的数据表。
- (数据库)mongodb中多个文档构成集合，多个集合构成数据库。
- (Shell)Mongodb Shell即自带的javascript shell,javascript解释器.运行mongo启动shell后自动连接Mongodb服务器,运行javascript程序

  1.创建：db.a.insert({"name":"jason","age":23})
          db.a.insert({"name":"andy","age":22})
          
  2.查找：db.a.find()                  --全查
          db.a.findOne()               --只取多个的第一个
          db.a.find({"name":"jason"})   --根据条件查找
          
  3.更新：db.a.update({"name":"jason"},{"age":18})
  
  4.删除：db.a.remove()                --删除所有文档，集合保留
          db.a.remove({"name":"andy"}) --删除复合条件的文档
          db.a.drop()                  --删除集合，于此同时所有文档也删除了



### FAQ
- Maven很多依赖估计有问题
- MongoDB 启动时加载DataSource问题
- Pom配置问题
- MongoDB加载启动问题
- MongoDB JDBC

### ENV
- JDK 1.8
- Intellij IDEA 14
- Mysql 5.5
- Git
- gitHub
- gitee

## Contact
- QQ:603043194
- E-Mail: jasonandy@hotmail.com

## License
开源协议 [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)