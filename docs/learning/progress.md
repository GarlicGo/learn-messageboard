# 学习进度

## 当前位置

- 当前课程：第 2 课
- 当前主题：需求分析、接口文档、视图对象、数据库设计、MyBatis 代码生成
- 当前状态：第 1 课的基础骨架已经完成；已经开始学习第 2 课，重点从“如何接收请求”转向“留言板项目要做什么、接口如何定义、数据库如何设计”。

## 已经学习

- Spring Boot 项目入口和 `main` 方法。
- Java `main` 方法和 `SpringApplication.run` 的关系。
- Spring 和 Spring Boot 的区别与关系。
- 内置 Tomcat 的含义。
- 自动配置和组件扫描的基本含义。
- `application.yml` 的作用。
- Lombok 基础：`@Data`、`@NoArgsConstructor`、`@AllArgsConstructor`、`@Slf4j`。
- Jackson 基础：Java 对象和 JSON 互相转换。
- `Person.class` / `SomeClass.class` 的含义。
- Spring 容器、Bean、IOC、DI。
- `@Autowired` 表示由 Spring 容器注入依赖。
- `@Qualifier` 用于多个候选 Bean 中指定某一个。
- Controller 接收请求的基本方式。
- 使用 `@RequestHeader`、`@RequestParam`、`@RequestBody`、`@PathVariable` 绑定参数。
- Spring Boot Web 中 `@RequestBody` 默认使用 Jackson 进行 JSON 转换的基本流程。
- 使用 `CommonResult` 设计统一返回格式。
- 使用 `CommonResultWrapper` 自动包装 Controller 返回值。
- 已经在 `repos/messageboard` 中完成第 1 课基础代码搭建，包括启动类、`application.yml`、统一返回模板、自动包装器、示例 Controller 和请求参数演示接口。

## 还不够熟悉

- Spring Boot 自动配置的内部细节。
- Servlet 容器和外部 Tomcat 部署模型。
- 完整的 Spring MVC 请求处理生命周期。
- `ResponseBodyAdvice` 的精确执行时机。
- 参数转换或校验失败后的完整异常流程。
- 全局异常处理和返回包装器如何配合。

## 下一步建议

- 继续梳理第 2 课的接口设计和数据库设计。
- 之后在自己的跟练仓库中补充第 2 课相关代码结构，例如 VO、参数类、实体类和 SQL 文件。
