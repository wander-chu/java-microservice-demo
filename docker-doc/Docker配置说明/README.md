## Docker配置说明
### 一.CentOS的Docker配置
#### 允许远程

- 修改配置文件

	$ vim /usr/lib/systemd/system/docker.service

编辑文件，"ExecStart=/usr/bin/dockerd……"这一行改为：

	ExecStart=/usr/bin/dockerd -H tcp://0.0.0.0:2375 -H unix://var/run/docker.sock
	
- Docker重新读取配置文件

	$ systemctl daemon-reload
	
- 重新启动Docker服务

	$ systemctl restart docker
	
- 查看Docker进程

出现"tcp://0.0.0.0:2375"说明成功。

	$ ps aux | grep docker
	
- 查看系统的网络端口

将会看到tcp的2375端口是docker的守护进程在监听。
	
	$ netstat -tulp
