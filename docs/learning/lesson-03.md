# 第 3 课学习记录

## 本课主题

待学习。当前刚进入第 3 课，先把 `repos/messageboard-lessons/lesson-03/` 同步成和 `lesson-02` 一致的起始状态。

## 当前学习状态

- 已经完成第 1、2 课。
- `repos/messageboard-lessons/lesson-03/` 已从 `repos/messageboard-lessons/lesson-02/` 同步起始代码。
- 后续第 3 课的代码实践会直接在 `lesson-03` 目录中逐步补齐，直到达到第 3 课结束时的状态。
- 已排查一次 `testUserMapper` 启动失败：根因是 `application.yml` 中 `datasource` 缩进错误，没有配置成 Spring Boot 能识别的 `spring.datasource`；同时修正了 MyBatis XML 扫描路径。

## 本课已解决问题

### `testUserMapper` 报 `Failed to configure a DataSource`

这类错误说明 Spring Boot 已经因为引入 JDBC/MyBatis 依赖而尝试创建 `DataSource`，但没有读到有效的数据库连接配置。

本次原因是 `application.yml` 缩进错误：`datasource` 原本被放进了 `spring.application` 下面，正确位置应当和 `application`、`jackson` 同级，即 `spring.datasource`。

另外，当前 Mapper XML 实际存放在 `src/main/resources/club/devhub/messageboard/mapper/` 下，因此 `mybatis.mapper-locations` 需要指向 `classpath*:club/devhub/messageboard/mapper/*.xml`。

## 起始代码包含

- Spring Boot 启动类。
- 第 1 课留下的示例 Controller、统一返回对象和返回包装器。
- 第 2 课生成或保留的 Entity、Mapper、Service、ServiceImpl 和 Mapper XML 骨架。
- `pom.xml` 和 `application.yml`。

## 后续待实践

- 跟随第 3 课逐步补充业务代码。
- 学习过程中继续区分“课程演示代码”和“最终项目会保留的代码”。
