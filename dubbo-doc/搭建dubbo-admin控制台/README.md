## 搭建dubbo-admin控制台
### 一.Windows上搭建dubbo-admin控制台

**1.下载源码**

下载地址：https://github.com/apache/incubator-dubbo/tree/dubbo-2.5.8

你也可以选择下载其它的版本。

**2.生成war文件**

解压，打开cmd进入解压后的子目录dubbo-admin目录下，在cmd中输入命令：

	mvn clean install

在target目录下会生成dubbo-admin-2.5.8.war，然后将该war包放入tomcat的webapps目录下，启动tomcat。

**3.访问dubbo-admin**

在浏览器中访问localhost:[端口]/dubbo-admin-2.5.8，输入默认的用户名和密码：root/root。