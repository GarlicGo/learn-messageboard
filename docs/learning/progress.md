# 学习进度

## 当前位置

- 当前课程：第 1 课
- 当前主题：Spring Boot 项目基础、Spring IOC/DI、Controller 参数接收、统一返回包装器
- 当前状态：第 1 课的核心概念已经完成梳理和问答。下一步可以选择在 `repos/messageboard` 中动手搭建第 1 课项目骨架，也可以继续进入第 2 课。

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

## 还不够熟悉

- Spring Boot 自动配置的内部细节。
- Servlet 容器和外部 Tomcat 部署模型。
- 完整的 Spring MVC 请求处理生命周期。
- `ResponseBodyAdvice` 的精确执行时机。
- 参数转换或校验失败后的完整异常流程。
- 全局异常处理和返回包装器如何配合。

## 下一步建议

- 如果重视动手实践：在 `repos/messageboard` 中搭建第 1 课 Spring Boot 项目骨架。
- 如果重视课程推进：开始第 2 课，学习需求分析、接口文档、数据库设计和代码生成。
