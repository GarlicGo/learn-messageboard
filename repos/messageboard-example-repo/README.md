# 接口文档
https://www.apifox.cn/apidoc/project-1175609/doc-976306

# 项目运行方法
1. 进入MySQL，创建数据库“messageboard” 
2. 在数据库中运行sql文件夹下的schema.sql 
3. 更改application.yml里面的数据库连接配置
4. 运行MessageboardApplication
5. 使用“用户注册”接口注册一个账号
6. 使用“用户登录”接口进行登录，在response的header中获取token并保存
7. 在request的header部分authorization字段携带刚才获取的token
8. 如果需要管理员权限，可进入数据库t_user表，把user_role从0改为1，然后重新登录这个账号并获取token即可
