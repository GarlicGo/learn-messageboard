# 学习进度

## 当前位置

- 当前课程：第 3 课
- 当前主题：第 3 课起始代码已同步，准备逐步补齐本课代码
- 当前状态：第 1 课基础骨架已完成；第 2 课的设计内容和课末代码已完成。`repos/messageboard-lessons/lesson-03/` 已同步为和 `lesson-02` 一致的起始状态，后续会在该目录中逐步补齐第 3 课代码。

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

## 还不够熟悉

- Spring Boot 自动配置的内部细节。
- Servlet 容器和外部 Tomcat 部署模型。
- 完整的 Spring MVC 请求处理生命周期。
- `ResponseBodyAdvice` 的精确执行时机。
- 参数转换或校验失败后的完整异常流程。
- 全局异常处理和返回包装器如何配合。
- 第 3 课将要接触的新业务代码和新分层结构。

## 下一步建议

- 进入第 3 课，结合具体代码把前两课的设计真正落到项目里。
- 继续留意接口文档、数据库表结构和生成代码之间的对应关系。
