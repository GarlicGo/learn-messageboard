---
name: learning-context-maintainer
description: Use when assisting a user in a learning-oriented project and the workspace has, or should have, persistent learning-context files such as docs/learning/progress.md, knowledge-map.md, questions.md, glossary.md, lesson notes, AGENTS.md, or similar. Helps AI assistants read, update, and preserve learning progress automatically after lessons, Q&A, reviews, and course-related practice without waiting for an explicit "update notes" request.
metadata:
  short-description: Maintain learning context
---

# Learning Context Maintainer

Use this skill to maintain persistent learning context for a project, course, tutorial, book, codebase study, or domain-learning workspace.

The goal is to support both:

- the learner, who wants to review progress and weak spots;
- future AI assistants, which need compact context to continue teaching effectively.

These files are learning aids, not runtime configuration for the user's app/framework.

## When To Use

Use this skill when any of these are true:

- The user asks to continue learning, review, study a lesson, explain course material, or track progress.
- The workspace contains `docs/learning/`, `learning/`, `AGENTS.md`, or similar learning-context files.
- The user wants learning notes to be updated automatically.
- A session changes stable learning state: a lesson is completed, an important question is resolved, a weak area is identified, or a course-related coding practice is completed.
- The user asks to design or initialize a reusable learning workflow.

Do not use this skill for one-off factual answers unrelated to a learning track, unless the user asks to record the result.

## Read Order

When resuming or assisting learning, read project-specific instructions first:

1. `AGENTS.md` or equivalent project-agent instructions, if present.
2. Learning index such as `docs/learning/README.md`.
3. Current progress file, commonly `docs/learning/progress.md`.
4. Current lesson/topic file, commonly `docs/learning/lesson-xx.md` or `docs/learning/lessons/...`.
5. `knowledge-map.md`, `questions.md`, and `glossary.md` as needed.
6. Fixed source material, course notes, API specs, reference code, or textbooks only when needed for the immediate task.

If project-specific instructions conflict with this skill, follow the project-specific instructions unless they would cause fabricated or misleading learning records.

## Expected File Contract

Prefer this structure when creating a new learning context:

```text
docs/learning/
├── README.md
├── progress.md
├── knowledge-map.md
├── questions.md
├── glossary.md
└── lesson-01.md
```

Use existing project structure if it already has one. Do not rename or reorganize existing files unless the user asks.

Recommended responsibilities:

- `README.md`: purpose, reader, update rules, file list.
- `progress.md`: current location, learned items, weak spots, next step.
- `lesson-xx.md`: detailed record for a lesson/session/topic.
- `knowledge-map.md`: topic-level mastery status.
- `questions.md`: resolved questions, open questions, review queue.
- `glossary.md`: terms and concise definitions.

## Update Triggers

Proactively update learning records when:

- A lesson, chapter, module, or substantial topic has been completed.
- The user says they understand, learned something, reached a stopping point, or wants to continue to the next topic.
- A significant question is answered with a stable conclusion.
- A knowledge-point mastery status clearly changes.
- The user completes course-related code practice, review, debugging, or implementation.
- You identify a notable weak area that should affect future teaching.

Usually do not update when:

- The exchange is a tiny clarification with no durable new conclusion.
- The discussion is still exploratory and conclusions are unstable.
- The user explicitly says not to edit files or only wants an answer.
- The update would be speculative.

When uncertain, prefer a small update only if it will materially help future continuation.

## Update Rules

- Use the learner's preferred language; if unknown, use the language already used in the learning files.
- Record only evidence-backed state from the current session, existing files, or explicit user confirmation.
- Do not invent progress, confidence, completed work, or understanding.
- Minimize edits: update only files and sections whose state actually changed.
- Preserve fixed source material such as course transcripts, reference docs, API specs, and example repositories unless the user asks to edit them.
- Keep entries concise and useful for future continuation.
- Distinguish:
  - learned/understood;
  - not yet solid;
  - open question;
  - resolved question;
  - recommended next step.
- If updating mastery status, use the project's existing status scale. If none exists, use:
  - 未接触 / 听过 / 初步理解 / 基本理解 / 熟悉 / 可独立使用
- After updating files, briefly tell the user which learning-context files changed.

## Teaching Workflow

For a learning turn:

1. Restore context from the read order above.
2. Answer or teach using the current learning state.
3. Watch for update triggers during the conversation.
4. If triggered, update learning records near the end of the turn.
5. In the final response, include the answer and a short note about updated learning files.

If the user asks for a plan or architecture for reusable learning context, propose the split:

- CLI/template: creates file structure and initial templates.
- Project `AGENTS.md`: stores project-specific reading order and local rules.
- Skill: provides cross-project update heuristics and maintenance workflow.
- `docs/learning`: stores actual learning state.

## Initialization Template Guidance

When creating learning-context files, keep them simple and adaptable. Avoid overfitting to a single subject.

Minimum `progress.md` sections:

```md
# 学习进度

## 当前位置

## 已经学习

## 还不够熟悉

## 下一步建议
```

Minimum `knowledge-map.md` sections:

```md
# 知识掌握地图

掌握状态：未接触 / 听过 / 初步理解 / 基本理解 / 熟悉 / 可独立使用
```

Minimum `questions.md` sections:

```md
# 问题记录

## 已解决

## 待复习

## 待解决
```

Minimum `glossary.md` sections:

```md
# 术语表
```

## Anti-Patterns

- Rewriting all learning files after every small answer.
- Treating learning context as app runtime configuration.
- Marking a topic "understood" only because it was explained once.
- Hiding uncertainty. If the learner is still shaky, record that plainly.
- Mixing fixed course notes with personal learning state.
