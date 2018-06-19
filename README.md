# 自动化部署简介
* 操作系统<br>

        CentOS 7.4 64位

* 框架

        Springboot 1.5.4
        Spring Security Oauth2
        mybatis 3.2.8

* 自动化部署

        jenkins(包括：maven、git、jdk)
        docker
        
* 目的

        代码提交到github上后，在jenkins的后台自动构建部署，发布
        
* 说明
    
        分支Version-1.0：普通jar包，自动发布，内含脚本
        分支Version-1.1：打包成镜像，放置在服务器docker容器内，自动发布，内含脚本
        分支Version-1.2：mybatis-generator插件（pom中注释了）
        
* 参考资料

    [mysql安装教程](https://www.cnblogs.com/bigbrotherer/p/7241845.html) <br>
    [git安装教程](https://blog.csdn.net/u014066037/article/details/70224780) <br>
    [maven安装教程](https://www.cnblogs.com/taomylife/p/7997814.html) <br>
    [jenkins安装教程](https://blog.csdn.net/linjingke32/article/details/77799878) <br>
    [jenkins离线问题](https://blog.csdn.net/txyzqc/article/details/77885367) <br>
    [jenkins配置教程](http://baijiahao.baidu.com/s?id=1589036484535314228&wfr=spider&for=pc) <br>
    [docker安装教程](https://yeasy.gitbooks.io/docker_practice/content/install/centos.html) <br>
    
    