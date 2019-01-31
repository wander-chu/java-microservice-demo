# Spring Boot的远程Docker部署
使用远程Docker发布Spring Boot应用。

---


**1.CentOS服务器上安装Docker**

安装步骤请参考[Docker安装说明](../docker-doc/Docker安装说明/)

**2.修改Docker配置允许远程**

配置修改方法请参考[Docker配置说明](../docker-doc/Docker配置说明/)

**3.我们直接把我们创建的Spring Boot的CRUD程序拿过来，并通过IDEA打开，在此基础上增加远程Docker发布需要的配置。**

**4.IDEA安装Docker插件**

打开Idea，从File->Settings->Plugins->Install JetBrains plugin进入插件安装界面，在搜索框中输入docker，可以看到Docker integration，点击右边的Install按钮进行安装。安装后重启Idea。

**5.连接远程Docker**

从File->Settings->Build,Execution,Deployment->Docker打开配置界面。

点击+号添加一个docker配置，输入Name和Engine API URL，URL是docker服务地址。不出意外应该可以连接成功。

**6.项目根目录下增加Dockerfile文件**

若要查看Dockerfile内容请点击[Dockerfile代码](Dockerfile)

**7.增加Docker创建镜像和容器的配置**

从Run->Edit Configureations打开配置界面。点击+号，选择Docker->Dockerfile,新增一个配置页，信息填写如下

	Name:Docker
	Server:Docker(这里是选择的第5步时增加的Docker)
	Dockerfile:Dockerfile(这里选择的是第6步时增加的根目录下的Dockerfile文件)
	Context folder:.
	Image tag:springboot/springboot-docker:1.0
	Container name:springboot-docker
	Command line options:--link mysql:mysql -p 8080:8080

以上设置仅供参考，可以根据你的习惯进行配置。这里使用--link连接mysql容器,配置文件中spring.datasoure.url中应该是mysql:3306格式的配置，其中mysql为--link设置的我们部署mysql的容器的别名。当然这里并不是一定要这么设置，spring.datasoure.url依然可以保持host:port格式的设置，在Command line options中增加--net=host即可)

对应配置文件中的spring.datasoure.url配置请点击[application-prod.yml](src/main/resources/application-prod.yml)查看

保存后执行，就会根据我们的配置通过远程Docker创建镜像并创建容器。

**8.测试**

浏览器中访问：http://IP:8080
	
