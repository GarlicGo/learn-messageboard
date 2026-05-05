# 第 1 课学习记录

## 本课主题

项目创建、Lombok、Jackson、Spring IOC、Controller 请求处理、统一返回模板。

## 写过或讨论过的代码

### Spring Boot 启动类

生成的应用入口类包含 Java `main` 方法，并调用 `SpringApplication.run(...)`。

作用：

- 启动 Java 程序。
- 启动 Spring Boot 应用。
- 创建 Spring 容器。
- 触发组件扫描和自动配置。
- 启动内置 Tomcat，用于接收 Web 请求。

对应知识点：

- Java 程序入口。
- Spring Boot 启动流程。
- 内置 Web 服务器。
- 组件扫描。

### `application.yml`

用于配置端口、应用名等项目运行参数。

作用：

- 替代可读性较弱的 `application.properties`。
- 集中维护项目配置。
- 后续继续承载数据库、MyBatis、Security、环境等配置。

对应知识点：

- YAML 配置。
- Spring Boot 配置读取。
- 运行环境参数。

### Lombok 演示：`Person`

临时创建 `Person` 类，对比手写 Java 样板代码和 Lombok 注解。

作用：

- 说明 `@Data` 可以生成 getter、setter、`toString`、`equals`、`hashCode`。
- 说明构造器注解可以生成无参构造和全参构造。

对应知识点：

- `@Data`
- `@NoArgsConstructor`
- `@AllArgsConstructor`
- Java 构造方法
- Java 对象相等判断

状态：

- `Person` 是临时演示类。
- Lombok 的写法会在最终项目中持续使用。

### Jackson 演示

使用 `ObjectMapper` 把 Java 对象转成 JSON，再把 JSON 转回 Java 对象。

作用：

- 理解后端对象如何变成 JSON 响应。
- 理解 JSON 请求体如何变成 Java 参数对象。

对应知识点：

- JSON 序列化。
- JSON 反序列化。
- `ObjectMapper`。
- `SomeClass.class`。
- `@SneakyThrows`。

状态：

- 演示代码是临时代码。
- 这个机制会被 Spring MVC 使用，尤其体现在 `@RequestBody` 上。

### SLF4J 日志演示

使用 `@Slf4j` 打印结构化日志。

作用：

- 替代简单的 `System.out.println`。
- 学习日志级别和占位符写法。

对应知识点：

- `log.info`。
- `log.warn`。
- `log.error`。
- `{}` 占位符。
- 日志级别。

### IOC 演示：School、College、Dormitory、Student

用临时类对比手动创建对象和 Spring 管理依赖。

作用：

- 说明手动 `new` 对象并用 setter 连接依赖会变得繁琐。
- 说明 Spring 可以自动创建对象并装配依赖。

对应知识点：

- Spring 容器。
- Bean。
- IOC。
- DI。
- `@Component`。
- `@Autowired`。
- `@Value`。
- Bean 作用域。

状态：

- 这些类是临时演示类。
- 对应思想会演变成真实项目里的 `Controller -> Service -> Mapper`。

### 配置类演示

讨论了 `@Configuration`、`@Bean`、`@Import`，它们也可以把对象注册进 Spring 容器。

作用：

- 说明 Bean 注册不只依赖 `@Component`。
- 认识配置类。

对应知识点：

- `@Configuration`。
- `@Bean`。
- `@Import`。
- Bean 名称。

状态：

- 演示类是临时代码。
- 配置类思想会在最终项目中继续使用。

### 多个 Bean 候选演示

用 `Operation` 接口和 `Add`、`Subtract` 等实现类说明：当一个依赖类型有多个 Bean 候选时，Spring 可能不知道该注入哪个。

作用：

- 理解为什么有时 Spring 无法决定注入哪个实现类。
- 学习用 `@Primary` 或 `@Qualifier` 指定候选 Bean。

对应知识点：

- 面向接口编程。
- 多实现类。
- `@Primary`。
- `@Qualifier`。
- Bean 默认名称。

状态：

- 演示代码是临时代码。
- 这种模式在真实后端项目中很常见。

### Controller 演示

创建临时 Controller 测试请求路径、请求方法和参数提取。

作用：

- 学习后端接口如何接收 HTTP 请求。
- 学习 URL、header、query、body、path 参数如何绑定到方法参数。

对应知识点：

- `@RestController`。
- `@RequestMapping`。
- `@GetMapping`。
- `@PostMapping`。
- `@PutMapping`。
- `@DeleteMapping`。
- `@RequestHeader`。
- `@RequestParam`。
- `@RequestBody`。
- `@PathVariable`。

状态：

- 临时 Controller 后续会删除。
- 这种写法会成为后续用户、留言、评论、管理员接口的基础。

### 统一返回：`CommonResult`

`CommonResult` 定义统一接口返回格式。

作用：

- 让所有 API 响应结构一致。
- 区分成功状态、业务状态码、提示信息和业务数据。

对应知识点：

- API 返回设计。
- VO 对象。
- 静态工厂方法。

状态：

- 这是正式项目基础设施，会继续保留。

### 自动返回包装：`CommonResultWrapper`

`CommonResultWrapper` 实现 `ResponseBodyAdvice`，自动包装 Controller 返回值。

作用：

- 避免每个 Controller 方法都重复写 `CommonResult.success(...)`。
- 把普通返回值包装进统一返回模板。
- 已经是 `CommonResult` 的对象保持原样。
- 对 `String` 返回值使用 `ObjectMapper` 特殊处理。

对应知识点：

- `@RestControllerAdvice`。
- `ResponseBodyAdvice`。
- Spring MVC 响应生命周期。
- Jackson 序列化。
- 横切增强。

状态：

- 这是正式项目基础设施，会继续保留。

## 已经理解

- `main` 是 Java 程序入口，`SpringApplication.run(...)` 是 Spring Boot 启动调用。
- Spring 和 Spring Boot 相关但不是同一个东西，Spring Boot 简化了 Spring 应用搭建。
- 内置 Tomcat 会在 Spring Boot 应用运行时接收 HTTP 请求。
- Spring 容器负责管理 Bean 对象。
- IOC 表示对象创建和依赖装配的控制权交给容器。
- DI 是 Spring 实现 IOC 的主要方式，也就是由容器注入依赖。
- `@Autowired` 表示让 Spring 注入匹配的 Bean。
- `@Qualifier("add")` 表示选择名为 `add` 的 Bean。
- Controller 参数顺序通常比较灵活，因为 Spring 主要根据注解解析参数。
- 请求体不一定总能转换成参数类，JSON 格式、Content-Type、字段类型、对象结构都可能导致失败。
- `CommonResultWrapper` 会在 HTTP 响应写出之前拦截并包装 Controller 返回值。

## 还不够熟悉

- Spring Boot 自动配置内部如何实现。
- 内置 Tomcat 和外部 Tomcat 在 Servlet 层面的区别。
- Spring MVC 如何选择 `HttpMessageConverter`。
- 参数转换失败时的具体异常类型和处理路径。
- 全局异常处理和返回包装器的完整配合关系。

## 重点讨论过的问题

- `main` 方法是 Java 的要求还是 Spring 的要求。
- Spring 和 Spring Boot 的关系。
- 内置 Tomcat、自动配置、组件扫描。
- `Person.class` 的含义。
- `@RequestBody` 内部是否使用 Jackson。
- Spring 容器、Bean、IOC、DI 的关系。
- `@Autowired` 的含义。
- `@Qualifier("add")` 的含义。
- Controller 方法参数顺序是否重要。
- 请求参数不能转换时会发生什么。
- `CommonResultWrapper` 如何工作。

## 复习任务

- 画一遍 `Controller -> Service -> Mapper` 的关系。
- 重新阅读最终项目中的 `CommonResult` 和 `CommonResultWrapper` 代码。
- 写一个小 Controller，同时练习 header、query、body、path 参数。
- 不使用框架术语，自己解释一遍 IOC 和 DI。

## 本次实践结果

已经把自己的跟练仓库搭成了第 1 课基础骨架，包含：

- Spring Boot 启动类 `MessageboardApplication`。
- `application.yml`。
- 统一返回模板 `CommonResult`。
- 自动包装器 `CommonResultWrapper`。
- 示例接口 `HelloController`。
- 请求参数演示接口 `RequestDemoController`。

目前这一课的代码快照保存在：

- `repos/messageboard-lessons/lesson-01/`

## 当前限制

- 当前环境里没有可直接调用的 `mvn` 命令，所以这次没法完成真实 Maven 构建验证。
- 代码结构已经对齐第 1 课，但后续还需要在可用 Maven 环境里做一次启动和接口验证。
