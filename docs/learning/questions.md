# 问题记录

## 已解决

- 第 4 课视频中的 `SecurityConfig` 为什么和当前示例仓库不同：视频使用的是继承 `WebSecurityConfigurerAdapter` 的旧写法；当前示例仓库基于 Spring Boot 2.7.1 / Spring Security 5.7+，已迁移为组件式配置。旧写法里的 `configure(HttpSecurity)` 主要对应现在的 `@Bean SecurityFilterChain filterChain(...)`；旧写法里注入的 `TokenFilter`、`AuthenticationEntryPoint`、`PasswordEncoder`、`UserDetailsService` 等并没有消失，而是通过方法参数、独立 `@Component` 或 `@Bean` 继续进入 Spring 容器并参与认证流程。

### `main` 方法是 Java 的要求还是 Spring 的要求？

`main` 方法是 Java 程序入口。`SpringApplication.run(...)` 是 Spring Boot 的启动调用，会创建 Spring 应用上下文、读取配置、扫描组件，并启动内置 Tomcat。

### Spring 和 Spring Boot 是同一个东西吗？

不是。Spring 是底层框架，提供 IOC、DI、AOP、Spring MVC、事务管理和集成能力。Spring Boot 基于 Spring，主要通过 starter 依赖、自动配置、内置服务器和应用配置来简化项目搭建。

### 什么是内置 Tomcat？

Tomcat 是 Web 服务器 / Servlet 容器，负责监听 HTTP 请求并把请求分发给 Java Web 应用。内置 Tomcat 表示 Tomcat 被打包在 Spring Boot 应用内部，会随着 Java 应用一起启动。

### 如果没有 Spring Boot 或没有 Tomcat 会怎样？

没有 Spring Boot 也可以运行 Spring Web 应用，但通常需要外部 Tomcat 或其他 Servlet 容器，并且要写更多手动配置。如果没有任何 Web 服务器或 Servlet 容器，HTTP 请求就无法进入 Controller。

### `Person.class` 是什么意思？

它是 Java 中 `Person` 类型对应的 `Class` 对象，用来传递运行时类型信息。例如告诉 Jackson 把 JSON 反序列化成 `Person` 对象。

### `@RequestBody` 内部使用 Jackson 吗？

在标准 Spring Boot Web JSON 场景下，是的。`@RequestBody` 由 Spring MVC 处理，Spring 会选择合适的 `HttpMessageConverter`，默认 JSON 转换器通常使用 Jackson。

### Spring 容器、Bean、IOC、DI 是什么关系？

Spring 容器是对象管理器。Bean 是被容器管理的对象。IOC 是一种思想，表示对象创建和依赖装配由容器控制，而不是由业务代码控制。DI 是实现 IOC 的主要方式，也就是容器把需要的依赖注入给对象。

### DI 是 IOC 中的一个步骤吗？

更准确地说，DI 是 IOC 的主要实现方式，不只是普通步骤。在 Spring 启动过程中，依赖注入确实发生在容器创建和装配 Bean 的过程中。

### `@Autowired` 是什么？

`@Autowired` 表示让 Spring 从容器中找到匹配的 Bean，并注入到字段、构造器或方法参数中。

### `@Qualifier("add")` 是什么意思？

当多个 Bean 都符合某个依赖类型时，`@Qualifier("add")` 表示选择名为 `add` 的 Bean。

### Controller 参数顺序重要吗？

通常不重要。Spring MVC 主要根据 `@RequestBody`、`@RequestParam`、`@RequestHeader`、`@PathVariable` 等注解解析参数。为了可读性，请求体参数通常放最后。一个方法通常只应该有一个 `@RequestBody`。

### 请求参数一定能转换成参数类吗？

不一定。JSON 格式错误、Content-Type 不对、字段类型不匹配、缺少合适的对象构造方式、对象结构不兼容等都会导致转换失败。Spring MVC 会抛出异常，这些异常可以被全局异常处理器统一处理。

### `CommonResultWrapper` 是怎么工作的？

它实现了 `ResponseBodyAdvice`。这是 Spring MVC 的扩展点，会在 Controller 方法返回之后、响应体写出之前执行。它会把 `null`、普通对象和字符串包装成 `CommonResult`，已经是 `CommonResult` 的对象则保持原样。

### `@Component` 和 `@RestController` 这类注解有什么区别？

`@Component` 这类注解主要职责是把类注册成 Spring Bean；而 `@RestController`、`@RestControllerAdvice` 这类注解通常是“业务角色注解 + Bean 注册”合在一起，它们在完成具体框架功能的同时，也会让类进入 Spring 容器。

### 本项目中使用的 Bean 都是单例模式的吗？

在没有额外声明 `@Scope` 的情况下，Spring Bean 默认是单例作用域。本项目中的 Controller、Service 实现类、`CommonResultWrapper` 这类由 Spring 管理的组件通常都是单例 Bean。MyBatis Mapper 在配置扫描后也通常以代理对象的形式交给 Spring 管理，使用上也可以理解为单例 Bean。

但 Entity、Param、VO 这类数据对象通常不是 Spring Bean，它们是请求处理、业务组装或数据库映射过程中临时创建的普通 Java 对象。单例 Bean 会被多个请求共享，所以不要在 Controller 或 Service 的成员变量里保存某个请求自己的临时数据。

## 待复习

- Spring Boot 自动配置细节。
- Spring MVC 请求处理生命周期。
- `HttpMessageConverter` 如何被选择。
- 参数绑定和参数校验的异常流程。
- `GlobalExceptionHandler` 和 `CommonResultWrapper` 如何配合。
- 本地是否具备完整 Maven 构建环境，后续需要补一次真实启动验证。
- 第 2 课中的数据库概念设计、逻辑设计、物理设计分别解决什么问题。
- MyBatis X 生成出来的 Entity、Mapper、Service、XML 各自做什么。

## 已解决

- VO、Param、Entity 三类对象的区别：VO 面向展示返回，Param 面向请求入参，Entity 面向持久化表结构。
- `testUserMapper` 报 `Failed to configure a DataSource`：本次是 `application.yml` 缩进错误导致 Spring Boot 没有读到 `spring.datasource`；修正后还需要保证 `mybatis.mapper-locations` 指向实际 XML 路径。
- `update t_user` 报 `near 'set=1'`：原因是 `UserMapper.xml` 里把 `sex` 字段写成了 `set=#{sex}`，正确写法应该是 `sex=#{sex}`，不能把 SQL 关键字 `set` 当字段名。
- `delete t_user where user_id=?` 报错：原因是删除语句少了 `from`，正确写法应是 `delete from t_user where user_id = #{userId}`。
- `CommonResult.failure(ResultCodeEnum.PARAM_VALIDATE_FAILED.getCode(), message)` 报错：原因是当前 `CommonResult` 只定义了 `failure(String message)`，还没有定义 `failure(Integer code, String message)` 这个重载方法。
