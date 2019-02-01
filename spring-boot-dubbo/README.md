# Spring Boot整合Dubbo
Sping Boot整合Dubbo。

---

**1.安装zookeeper**

安装步骤请参考[安装zookeeper注册中心](../dubbo-doc/安装zookeeper注册中心/)

**2.搭建dubbo-admin控制台**

搭建步骤请参考[搭建dubbo-admin控制台](../dubbo-doc/搭建dubbo-admin控制台/)

**3.工程搭建**

我们把之前搭建的Spring Boot多模块项目拷贝过来，稍加修改，改成web、service都可以启动。

修改内容:

	1.service模块增加启动类
	2.pom配置中web模块只依赖base模块，不再依赖service模块
	3.web模块关于数据库的配置移动到service模块下面
	4.base模块中的实体添加implements Serializable
	5.web模块取消数据库自动配置，因为我们虽然引用了实体类中添加了@Entity注解的base模块，但是我们并不需要直接连数据库
	@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class})
	6.web、service分别设置不同的server.port

下面我们会把service当成生产者、web当成消费者注册到zookeeper。

**4.增加dubbo配置**

我们实现的是xml的dubbo配置。

生产者添加内容如下：

	java/integration/service/config/DubboConfig.java
	resources/dubbo/dubbo-provider.xml
	resources/dubbo/dubbo.properties

消费者添加内容如下：

	java/integration/web/config/DubboConfig.java
	resources/dubbo/dubbo-consumer.xml
	resources/dubbo/dubbo.properties

**5.测试**

运行service、web项目，在dubbo-admin查看注册情况，在浏览器中访问消费者页面查看运行情况。



