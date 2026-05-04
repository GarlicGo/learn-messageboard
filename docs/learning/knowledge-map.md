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

## 工具

| 知识点 | 状态 | 备注 |
|---|---|---|
| Maven `pom.xml` | 初步理解 | 管理依赖和插件。 |
| Lombok `@Data` | 基本理解 | 生成对象常用方法。 |
| Lombok 构造器注解 | 基本理解 | 生成无参和全参构造。 |
| Lombok `@Slf4j` | 初步理解 | 提供日志对象。 |
| SLF4J 日志 | 初步理解 | 有级别的结构化日志。 |
