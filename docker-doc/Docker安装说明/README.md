## Docker安装说明
### 一.CentOS上安装Docker
**1.查看内核版本**

Docker 要求 CentOS 系统的内核版本高于 3.10 ，查看本页面的前提条件来验证你的CentOS 版本是否支持 Docker 。
通过 uname -r 命令查看你当前的内核版本。

	$ uname -r
	
**2.更新yum**

使用 root 权限登录 Centos。确保 yum 包更新到最新。

	$ sudo yum update

**3.卸载旧版本**

	$ sudo yum remove docker  docker-common docker-selinux docker-engine

**4.安装需要的软件包**

yum-util 提供yum-config-manager功能，另外两个是devicemapper驱动依赖的。

	$ sudo yum install -y yum-utils device-mapper-persistent-data lvm2
	
**5.设置yum源**

	$ sudo yum-config-manager --add-repo https://download.docker.com/linux/centos/docker-ce.repo

**6.查看docker版本**

	$ yum list docker-ce --showduplicates | sort -r
	
**7.安装docker**

安装最新版本。

	$ sudo yum install docker-ce
	
安装特定版本(例如:sudo yum install docker-ce-17.12.0.ce)。

	$ sudo yum install <FQPN>
	
**8.启动并加入开机启动**

	$ sudo systemctl start docker
	
	$ sudo systemctl enable docker

**9.验证安装是否成功**

输出中有client和service两部分表示docker安装启动都成功了。

	$ docker version