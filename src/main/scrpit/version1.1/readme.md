#jenkins配置

##Build  
        Root POM: pom.xml
        Goals and options: clean package docker:build
        
##Post Steps-执行shell
`注意1：在服务器上，将jenkins用户加入到docker用户组中，否则无权限操作`<br>
```Bash
usermod -a -G docker jenkins
```

`shell脚本`<br>
* 8088端口是服务的接口，可自行定义
```Bash
#!/bin/bash
echo "Execute shell Start"
docker rm -f jenkins-docker      #删除已建的容器，防止容器名，端口冲突
sleep 1
docker run -d -p 8088:8088 --name jenkins-docker springboot/jenkins-docker   #运行镜像生成容器
sleep 1
docker images|grep none|awk '{print $3}'|xargs docker rmi  #删除无效镜像
echo "Execute shell Finish"
```
