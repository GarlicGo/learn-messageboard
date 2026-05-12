# 第 4 课学习记录

## 本课主题

第 4 课开始进入用户认证与授权。核心问题是：系统如何判断“你是谁”，以及认证成功以后如何判断“你能不能访问这个接口”。

## 本课主要内容

- JWT 的基本原理：登录成功后生成 token，前端后续请求携带 token，后端从 token 中还原用户身份。
- JWT 工具类：通过 `JwtUtil` 生成 token、解析 token，并从 `application.yml` 读取 `jwt.secret` 和 `jwt.expiration`。
- 密码加密：引入 Spring Security，使用 `BCryptPasswordEncoder` 对密码加密，并用 `matches` 判断明文密码和数据库密文是否匹配。
- Spring Security 基础配置：配置哪些接口放行、哪些接口必须认证，关闭 CSRF，禁用 session，并把自定义 `TokenFilter` 加入过滤器链。
- 自定义 token 过滤器：解析 `Authorization` 请求头中的 token，把认证成功后的用户信息放入 `SecurityContextHolder`。
- 认证失败处理：过滤器阶段抛出的认证异常不能靠普通全局异常处理器兜住，需要 `AuthenticationFailedHandler` 返回 401。
- 用户实体适配认证体系：`User` 实现 `UserDetails`，通过 `getAuthorities()` 返回用户角色/权限。
- 认证与授权的区别：认证判断用户是否登录且 token 合法；授权判断认证后的用户是否具备访问某个接口的权限。
- 用户接口开发：课程纪要中包含注册、登录、获取自己信息、获取指定用户信息、修改自己信息等接口设计与测试。

## 当前学习状态

- 用户已明确完成第 3 课，准备进入第 4 课。
- 当前应先从整体链路理解第 4 课，不急着记所有 Spring Security 配置细节。
- 本课建议把注意力放在“请求从进入过滤器到进入 Controller 之前发生了什么”。

## 学习时优先关注

- `JWT` 是一种携带身份信息的字符串，不是数据库会话。
- `TokenFilter` 负责根据 token 建立当前请求的认证状态。
- `SecurityContextHolder` 保存当前请求的认证信息，Controller 才能用 `@AuthenticationPrincipal` 取到当前用户。
- 注册和登录通常是放行接口；其他接口大多需要合法 token。
- 有 token 只能说明通过认证，不一定拥有接口要求的权限。

## 版本差异提醒

视频中讲解 `SecurityConfig` 时使用的是继承 `WebSecurityConfigurerAdapter` 并重写 `configure(...)` 的旧写法；当前示例仓库已经迁移为 Spring Security 5.7+ 推荐的组件式配置方式：通过 `@Bean SecurityFilterChain` 配置 `HttpSecurity`，通过 `@Bean BCryptPasswordEncoder` 暴露密码加密器，通过 `@Bean AuthenticationManager` 暴露认证管理器。

学习时不要把视频里的类结构和当前代码逐行硬对齐。应重点对齐概念和职责：

- 原来 `configure(HttpSecurity http)` 中的 URL 放行、认证规则、关闭 CSRF、禁用 session、添加 `TokenFilter`、配置认证失败处理器，现在主要在 `filterChain(...)` 这个 `@Bean` 方法里完成。
- 原来注入到旧版 `SecurityConfig` 字段里的 `TokenFilter`、`AuthenticationEntryPoint`，现在通过 `filterChain(...)` 方法参数传入，本质仍然是从 Spring 容器取 Bean。
- 原来旧版代码中显式配置 `UserDetailsService` 和 `PasswordEncoder`，当前代码把 `UserDetailsServiceImpl` 作为 `@Component` 放进容器，把 `BCryptPasswordEncoder` 作为 `@Bean` 放进容器；`AuthenticationManager` 会使用这些组件完成登录认证。
- 课程讲解中的认证/授权流程仍然有效：登录用用户名密码认证，认证成功后生成 JWT；后续请求由 `TokenFilter` 解析 JWT 并写入 `SecurityContextHolder`；Controller 使用 `@AuthenticationPrincipal` 获取当前用户，使用 `@PreAuthorize` 做授权。
