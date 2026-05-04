# Messageboard

一个基于 Spring Boot 的留言板后端项目，用于学习 Java 后端开发。

## 学习路线

课程共 5 节课，按以下顺序循序渐进：

| 课次 | 主题 | 涉及技术 |
|------|------|----------|
| 第1课 | 项目创建、Lombok、Spring IOC、Spring MVC、返回模板 | Spring Boot, Maven, Lombok, Jackson |
| 第2课 | 需求分析、接口文档、数据库设计、代码生成 | API 设计, MySQL |
| 第3课 | MyBatis、编写接口、枚举、参数校验、异常处理、事务 | MyBatis, Validation, Exception Handling |
| 第4课 | JWT、Spring Security 认证与授权、用户注册登录 | Spring Security, JWT |
| 第5课 | Spring AOP、留言 CRUD、举报功能 | AOP, 完整业务逻辑 |

## 文档

- [接口文档](docs/api-specification.md) — 留言板所有 API 接口的完整定义
- [课程笔记](docs/course-notes/README.md) — 课程大纲、逐字稿（完整内容）及纪要（AI 总结仅供参考）
- [学习记录](docs/learning/README.md) — 面向学习者和 AI 助手的学习进度、知识掌握情况、问题记录和术语表

## 代码仓库

- [repos/messageboard-example-repo](repos/messageboard-example-repo) — 老师授课时编写的示例代码
- [repos/messageboard](repos/messageboard) — 我自己跟随课程实现的代码

## 学习状态

学习状态维护在 `docs/learning` 中。这些文档既用于自己复盘，也用于 Codex、Claude Code 等 AI 工具快速恢复学习上下文；它们不是 Java 框架或 Spring Boot 运行时配置。

- [当前进度](docs/learning/progress.md)
- [知识掌握地图](docs/learning/knowledge-map.md)
- [问题记录](docs/learning/questions.md)
- [术语表](docs/learning/glossary.md)

每次完成一课或一次重要学习讨论后，更新这些文件，方便自己和 AI 助手在下次继续学习时快速恢复上下文。

## 如何使用

1. 按照学习路线顺序阅读对应课程的逐字稿（transcript）全文，纪要（summary）仅作课后快速回顾，存在 AI 失真，以逐字稿为准
2. 参考示例代码仓库，在 `repos/messageboard` 中自己动手实现
3. 接口文档作为 API 参考，贯穿全课程使用
4. 学习过程中同步维护 `docs/learning`，记录进度、问题和掌握状态
