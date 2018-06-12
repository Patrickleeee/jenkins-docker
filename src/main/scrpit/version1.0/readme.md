#jenkins配置

##Build  
        Root POM: pom.xml
        Goals and options: clean install
        
##Post Steps-执行shell
`注意1：/opt/script/jenkins-docker目录可自行创建作为脚本的目录`<br>
```Bash
#!/bin/bash
echo "Execute shell Start"
cd /opt/script/jenkins-docker
chmod 777 ./stop.sh
sh stop.sh
chmod 777 ./replace.sh
sh replace.sh
echo "Execute shell Finish"
chmod 777 /opt/script/jenkins-docker/startup.sh
BUILD_ID=dontKillMe nohup /opt/script/jenkins-docker/startup.sh &
```

`注意2：需要赋予/opt/script/jenkins-docker目录权限给jenkins用户组下的用户jenkins`<br>
```Bash
cd /opt/script	
chown -R jenkins:jenkins ./jenkins-docker/
```

`stop.sh`
```Bash
echo "==========Stopping jenkins-docker Start=========="
pid=`ps -ef | grep jenkins-docker-1.0.jar | grep -v grep | awk '{print $2}'`
if [ -n "$pid" ]
then
   echo "kill -9 的pid:" $pid
   kill -9 $pid
fi
echo "==========Stopping jenkins-docker Finish=========="
```

`replace.sh`
```Bash
chmod 777 /var/lib/jenkins/workspace/demo/target/jenkins-docker-1.0.jar
cp /var/lib/jenkins/workspace/demo/target/jenkins-docker-1.0.jar /opt/script/jenkins-docker
```

`startup.sh`
```Bash
echo "授予当前用户权限"
chmod 777 /opt/script/jenkins-docker/jenkins-docker-1.0.jar
java -jar /opt/script/jenkins-docker/jenkins-docker-1.0.jar
```