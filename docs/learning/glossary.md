# 术语表

## Bean

由 Spring 容器创建、保存和管理的对象。

## Spring 容器

Spring 中的对象管理器，负责创建 Bean、保存 Bean、注入依赖和管理生命周期。

## IOC

Inversion of Control，控制反转。表示对象创建和依赖装配的控制权从业务代码转移给外部容器。

## DI

Dependency Injection，依赖注入。Spring 实现 IOC 的主要方式，容器把 Bean 需要的依赖对象注入进去。

## Spring

Java 框架，提供 IOC、DI、AOP、Spring MVC、事务管理和集成能力。

## Spring Boot

基于 Spring 的框架，用来简化项目创建、依赖管理、配置、自动配置和应用启动。

## Tomcat

Web 服务器和 Servlet 容器，负责接收 HTTP 请求并分发给 Java Web 应用。

## 内置 Tomcat

打包在 Spring Boot 应用内部的 Tomcat，会随着 Java 应用一起启动。

## 组件扫描

Spring 扫描指定包下带有 `@Component`、`@Service`、`@RestController` 等注解的类，并把它们注册为 Bean 的过程。

## 自动配置

Spring Boot 根据当前依赖和已有配置，自动创建常见框架配置的机制。

## Controller

Web 层组件，负责接收 HTTP 请求并返回响应。

## `@RequestBody`

Spring MVC 注解，用于读取 HTTP 请求体，并把请求体转换成 Java 对象。

## `@RequestParam`

Spring MVC 注解，用于读取 URL 中的 query 参数。

## `@RequestHeader`

Spring MVC 注解，用于读取请求头。

## `@PathVariable`

Spring MVC 注解，用于读取 URL 路径中的变量。

## Jackson

Java JSON 库。Spring Boot Web 通常默认使用它进行 JSON 序列化和反序列化。

## `ObjectMapper`

Jackson 的核心对象，用于 Java 对象和 JSON 之间互相转换。

## `SomeClass.class`

Java 获取某个类型的 `Class` 对象的语法，常用于传递运行时类型信息。

## `CommonResult`

留言板项目的统一 API 返回对象，包含 `success`、`code`、`message`、`data`。

## `ResponseBodyAdvice`

Spring MVC 扩展点，可以在 Controller 返回值写入 HTTP 响应体之前修改返回值。
