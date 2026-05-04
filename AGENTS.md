# AGENTS.md

本项目是一个用于学习 Java 后端开发的 Spring Boot 留言板课程工作区。

## 项目结构

- `docs/course-notes/`：固定课程资料，包括逐字稿和纪要。除非明确要求整理课程资料，否则不要随意改动。
- `docs/api-specification.md`：留言板接口文档。
- `docs/learning/`：学习者和 AI 助手共用的学习上下文记录，应该随着学习持续更新。
- `.codex/skills/learning-context-maintainer/`：当前项目使用的学习上下文维护 Skill。
- `repos/messageboard-example-repo/`：老师授课时写出的完整示例代码。
- `repos/messageboard/`：学习者自己跟随课程实现的代码。

## 辅助学习时的读取顺序

当用户要求继续学习、复习、进入下一课、解释课程内容或根据当前学习状态提供帮助时，优先读取：

1. `docs/learning/progress.md`
2. 当前课程对应的 `docs/learning/lesson-xx.md`
3. `docs/learning/knowledge-map.md`
4. `docs/learning/questions.md`
5. 必要时再读取 `docs/course-notes/` 中对应课程的逐字稿和纪要
6. 需要对照代码时读取 `repos/messageboard-example-repo/`

## 学习记录维护规则

- 学习记录使用中文，既方便学习者复盘，也方便 Codex、Claude Code 等 AI 工具读取上下文。
- 学习记录是给人和 AI 助手看的，不是给 Java 框架或 Spring Boot 运行时读取的配置。
- 原始课程资料保持相对稳定，个人理解、问题和掌握状态写入 `docs/learning/`。
- AI 助手应在合适时机主动更新学习记录，不必每次等待用户显式要求。
- 适合主动更新的时机：
  - 完成一课的讲解、复盘或问答后。
  - 用户明确表示“理解了”“学到了这里”“继续下一课”。
  - 讨论解决了一个重要疑问，足以改变 `questions.md` 或 `knowledge-map.md`。
  - 对某个知识点的掌握状态发生明显变化，例如从“听过”变成“基本理解”。
  - 完成一次和课程相关的代码实践后。
- 不需要主动更新的时机：
  - 用户只是在问一个很小的澄清问题，且没有形成新的稳定结论。
  - 用户明确要求只回答问题、不要改文件。
  - 当前对话还在探索中，结论尚未稳定。
- 每次主动更新时，不一定要改所有文件，应按实际变化最小化更新：
  - `docs/learning/progress.md`
  - 对应的 `docs/learning/lesson-xx.md`
  - `docs/learning/knowledge-map.md`
  - `docs/learning/questions.md`
  - `docs/learning/glossary.md`
- 不要虚构学习进度。只记录已经学习、讨论或明确确认过的内容。
- 如果发现用户对某个知识点还不熟，优先在 `knowledge-map.md` 和 `questions.md` 中体现。
- 主动更新完成后，在回复中简短说明更新了哪些学习记录文件。

## 代码学习原则

- 对照示例代码讲解时，区分“课程演示代码”和“最终项目保留代码”。
- 修改 `repos/messageboard/` 时，优先让学习者理解每一步为什么这么写。
- 不要直接覆盖学习者已有实现，除非用户明确要求。
