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
    
        普通jar包自动化发布，参见分支Version-1.0，内含脚本
        打包成镜像，放置在docker容器内发布，参见分支Version-1.1，内含脚本