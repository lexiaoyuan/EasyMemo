# EasyMemo ——易备

> 一个简单的账号密码备忘录

## 1.说明
&ensp; &ensp; &ensp;目前只完成了很小的一部分功能，但是EasyMemo也只计划提供这么多功能，我希望他能够足够简洁，越简洁越好。只提供简单的功能，但却够用并且足够方便，能尽可能的节约时间。简洁和方便的操作可以尽可能的减少我们使用的时间。

## 2. 开发模式
- 本项目目前采用的是JSP+Servlet+JavaBean+DAO的开发模式

## 3.已完成的功能
- **登录** ——只需使用手机号即可登录，当然，以后他的登录会变得足够方便
- **注册** ——只需要手机号即可注册，当然，以后他的注册也会变得足够方便
- **新建** ——仅仅需要填写简单的信息让你知道这个账号是在哪里使用的，当然，还需要填写账号和密码
- **查看** ——就是查看一下你记录的东西，目前做的很简陋，但是以后会更加方便和强大并且简洁，这很重要！
- **修改** ——目前还没有完成。。。待续
- **删除** ——目前还没有完成。。待续

## 4.使用
1. 将源代码下载下来，并导入到你新建的Java web工程中
2. 将 easymemo.sql 文件导入到在MySQL新建的数据库中
3. 你也许需要修改一下 src/db.properties 文件中的内容：
```java
driver=com.mysql.jdbc.Driver
url=jdbc:mysql://localhost:3306/easymemo?useUnicode=true&characterEncoding=utf-8&useSSL=false
username=root
password=123456
```
>这是一个连接数据库的配置文件，需要修改的内容可能有:
1. 端口号：3306 ——这个是连接数据库的端口号
2. 新建的数据库的名称：easymemo
3. 登录数据库的用户名：root
4. 登录数据库的密码：123456
5. 其他的也可以改，只要不出bug ^_^

## 5.我使用的一些工具资源及版本
| 工具 | 版本 |
| --- | --- |
| MyEclipse 10 | 10.0 |
| MySQL | 5.7.15 |
| Navicat for MySQL | 10.1.7 |
| Google Chrome | 71.0.3578.98（正式版本） |
<br>

| 一些资源 | 说明 |
| --- | --- |
| Tomcat 7.0 | 本项目使用的服务器，需要将其部署到你的工程中
| mysql-connector-java-5.1.47-bin.jar | 连接数据库的驱动程序文件
| jstl.jar | JSTL的Jar包 |
| standard.jar | JSTL的Jar包 |

## 6.项目结构
```
├─src
│  ├─beans
│  ├─dao
│  ├─dbc
│  └─servlets
└─WebRoot
    ├─css
    ├─img
    ├─META-INF
    └─WEB-INF
        ├─classes
        │  ├─beans
        │  ├─dao
        │  ├─dbc
        │  └─servlets
        └─lib
```
