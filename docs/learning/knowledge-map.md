# 知识掌握地图

掌握状态：

- 未接触
- 听过
- 初步理解
- 基本理解
- 熟悉
- 可独立使用

## Spring Boot 基础

| 知识点 | 状态 | 备注 |
|---|---|---|
| Java `main` 方法 | 基本理解 | Java 程序入口。 |
| `SpringApplication.run` | 基本理解 | 启动 Spring Boot 应用。 |
| Spring 和 Spring Boot | 基本理解 | Spring Boot 用来简化 Spring 应用搭建。 |
| 内置 Tomcat | 初步理解 | 应用运行时接收 HTTP 请求。 |
| 自动配置 | 听过 | 后续需要继续深入。 |
| 组件扫描 | 初步理解 | 扫描注解类并注册 Bean。 |
| `application.yml` | 基本理解 | 集中维护项目配置。 |

## Spring 核心

| 知识点 | 状态 | 备注 |
|---|---|---|
| Spring 容器 | 基本理解 | 管理 Bean 的对象管理器。 |
| Bean | 基本理解 | 被 Spring 管理的对象。 |
| IOC | 基本理解 | 对象创建和依赖装配的控制权交给容器。 |
| DI | 基本理解 | 容器把依赖注入到对象中。 |
| `@Component` | 初步理解 | 把类注册为 Bean。 |
| `@Service` | 初步理解 | Service 层 Bean 标识。 |
| `@Controller` / `@RestController` | 初步理解 | Controller 层 Bean 标识。 |
| `@Repository` | 听过 | 持久层 Bean 标识。 |
| 组件注解和功能注解的区别 | 初步理解 | 有些注解专门注册 Bean，有些注解在实现框架功能时顺带注册 Bean。 |
| `@Autowired` | 基本理解 | 注入匹配的 Bean。 |
| `@Qualifier` | 基本理解 | 根据名称选择 Bean。 |
| `@Primary` | 初步理解 | 设置默认候选 Bean。 |
| `@Configuration` | 初步理解 | 声明配置类。 |
| `@Bean` | 初步理解 | 把方法返回值注册为 Bean。 |

## Web 和 Controller

| 知识点 | 状态 | 备注 |
|---|---|---|
| HTTP 请求结构 | 基本理解 | 请求行、请求头、请求体。 |
| `@RequestMapping` | 基本理解 | 定义通用路径前缀。 |
| `@GetMapping` 等方法映射 | 基本理解 | 匹配 HTTP 方法和路径。 |
| `@RequestHeader` | 基本理解 | 读取请求头。 |
| `@RequestParam` | 基本理解 | 读取 query 参数。 |
| `@RequestBody` | 基本理解 | 把 JSON 请求体读取成对象。 |
| `@PathVariable` | 基本理解 | 读取路径参数。 |
| 参数转换失败 | 初步理解 | 转换失败时 Spring MVC 会抛异常。 |

## 接口和需求设计

| 知识点 | 状态 | 备注 |
|---|---|---|
| 需求分析 | 初步理解 | 已开始梳理普通用户和管理员的功能边界。 |
| RESTful 接口设计 | 基本理解 | 知道 URL 用名词、HTTP 方法表示操作。 |
| 接口文档 | 基本理解 | 已了解接口文档需要描述路径、方法、请求参数和响应结构。 |
| 视图对象 VO | 基本理解 | 面向前端展示，不等同于数据库表。 |
| 参数对象 Param | 初步理解 | 用于接收前端请求参数。 |
| 实体对象 Entity | 初步理解 | 更贴近数据库表结构。 |
| VO / Param / Entity 区分 | 基本理解 | 已知道三者分别面向返回、请求、持久化。 |
| Entity 与表结构关系 | 基本理解 | 通常高度接近，但不要求绝对完全一致。 |

## 数据库设计

| 知识点 | 状态 | 备注 |
|---|---|---|
| 一对多关系 | 基本理解 | 用户-留言、用户-评论、留言-评论都是一对多。 |
| 外键思想 | 基本理解 | 一对多通常把一方主键放到多方表中。 |
| 字段冗余 | 初步理解 | `comment_num`、`next_floor` 用于提高查询或写入效率。 |
| 建表规约 | 初步理解 | 表名字段名全小写、下划线分隔、每表有 ID/create_time/update_time。 |
| 概念/逻辑/物理设计 | 初步理解 | 已开始区分三层设计分别关注什么。 |
| MyBatis 代码生成 | 听过 | 第 2 课会用 MyBatis X 生成基础代码。 |

## JSON 和返回

| 知识点 | 状态 | 备注 |
|---|---|---|
| JSON | 基本理解 | 前后端通信常用数据格式。 |
| Jackson | 初步理解 | Spring Boot Web 默认常用的 JSON 转换库。 |
| `ObjectMapper` | 初步理解 | 用于 Java 对象和 JSON 互转。 |
| `SomeClass.class` | 基本理解 | 表示目标类型的 Class 对象。 |
| `CommonResult` | 基本理解 | 统一 API 返回模板。 |
| `ResponseBodyAdvice` | 初步理解 | 响应体写出前的扩展点。 |
| `CommonResultWrapper` | 基本理解 | 自动包装 Controller 返回值。 |
| 第 1 课项目骨架搭建 | 基本理解 | 已在跟练仓库中完成基础结构。 |

## 工具

| 知识点 | 状态 | 备注 |
|---|---|---|
| Maven `pom.xml` | 初步理解 | 管理依赖和插件。 |
| Lombok `@Data` | 基本理解 | 生成对象常用方法。 |
| Lombok 构造器注解 | 基本理解 | 生成无参和全参构造。 |
| Lombok `@Slf4j` | 初步理解 | 提供日志对象。 |
| SLF4J 日志 | 初步理解 | 有级别的结构化日志。 |
