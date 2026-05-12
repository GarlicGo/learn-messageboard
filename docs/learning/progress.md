# 学习进度

## 当前位置

- 当前课程：第 4 课
- 当前主题：准备学习认证、授权、JWT、密码加密，以及用户注册/登录/信息接口
- 当前状态：第 1、2、3 课已完成。接下来进入第 4 课，重点从“能通过 HTTP 操作数据库”推进到“系统知道当前请求是谁发出的，以及这个用户有没有权限访问接口”。

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
- 已经完成第 1 课基础代码搭建，包括启动类、`application.yml`、统一返回模板、自动包装器、示例 Controller 和请求参数演示接口。
- 已经将代码结构调整为：
  - `repos/messageboard-lessons/lesson-01/`：第 1 课代码快照
  - `repos/messageboard-lessons/lesson-02/`：第 2 课课末代码快照
  - `repos/messageboard-lessons/lesson-03/`：第 3 课起始代码，已从第 2 课同步
  - 后续课程会直接落在对应的 `lesson-0x/` 目录中
- 第 2 课已经整体理解：先做需求分析和接口文档，再做 VO/Param 设计、数据库概念/逻辑/物理设计，最后演示 MyBatis X 代码生成。
- 已经能区分第 2 课里的概念内容、手工录入内容、工具生成内容，以及哪些内容会进入最终项目结构。
- 第 2 课代码已通过插件生成到课末状态，新增了 Entity、Mapper、Service、ServiceImpl 和 Mapper XML 骨架。
- 第 3 课已完成：学习了 MyBatis 增删改查、`resultMap` 字段映射、通过 Controller 调用 Service/Mapper 操作数据库、枚举、参数校验、全局异常处理、自定义异常和事务。

## 还不够熟悉

- Spring Boot 自动配置的内部细节。
- Servlet 容器和外部 Tomcat 部署模型。
- 完整的 Spring MVC 请求处理生命周期。
- `ResponseBodyAdvice` 的精确执行时机。
- 参数转换或校验失败后的完整异常流程。
- 全局异常处理和返回包装器如何配合。
- Spring Security 过滤器链、认证失败处理器和方法级授权的执行流程。
- JWT 的签名、过期时间、解析失败等细节。
- `UserDetails`、`SecurityContextHolder`、`@AuthenticationPrincipal` 之间的关系。

## 下一步建议

- 进入第 4 课，先理解 JWT 和 Spring Security 在一次请求中的分工。
- 学习时重点跟踪一条链路：注册用户 -> 登录获取 token -> 请求携带 token -> `TokenFilter` 解析用户 -> Controller 获取当前用户。
