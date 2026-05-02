会议主题：1-后端培训项目 留言板 讲解（4）-480P 标清-AVC
上传时间：2026年3月31日（周二） 02:23 （GMT+08）
智能纪要由 AI 生成，可能不准确，请谨慎甄别后使用

总结
暂时无法在飞书文档外展示此内容
视频围绕 JWT 工具类、密码加密、认证与授权以及接口开发等内容展开详细讲解与实践操作，内容如下：
- JWT 工具类讲解
  - JWT 原理与结构
    - 原理阐述：用户登录时提供用户名和密码，服务器验证后返回 JWT，用户携带 JWT 访问接口，接口从 JWT 提取用户信息并处理请求。
    - 结构说明：JWT 数据结构由 header、payload 和 Signature 三部分组成，中间用点隔开。header 描述算法，payload 装载要保存的信息，Signature 是通过前两部分加密得出的签名。
[图片]
  - 工具类使用
    - 引入依赖：在 POM.xml 中引入 JWT 依赖，加载变更后可正常使用相关类。
    - 配置参数：使用 @value 注解从配置文件读取 secret 和 expiration 参数，并在 application.yml 中进行相应配置。
    - 方法测试：在测试类中使用 get TOKEN from user 方法根据用户信息生成 TOKEN，使用 get user from token 方法从 TOKEN 还原用户信息，验证工具类的功能。
- 密码加密处理
  - 引入依赖：引入 spring security 的依赖 spring boot STARTER security，加载 Maven 变更后生效。
  - 接口与实现类：passwordencoder 接口有 encode 和 matches 两个重要方法，项目选用 bcryptpasswordencoder 作为实现类。
  - 注入容器：由于 bcryptpasswordencoder 默认不被 spring 管理，需使用 import 注解将其注入 IOC 容器，以便在测试类中正常使用。
  - 加密与匹配测试：调用 passwordencoder 的 encode 方法对密码进行加密，使用 matches 方法判断加密前后的密码是否匹配，根据结果返回 true 或 false。
- 认证与授权配置
  - 复制类文件：将示范项目中的 securityconfig 和 tokenfilter 类复制到新项目中，并进行相应的配置和修改。
  - user 类实现接口：user 类需实现 userdetails 接口，重写 getauthorities、getpassword、getusername 等方法，确保认证通过。
  - securityconfig 配置
    - 类注解与注入：使用 @configuration 注解表明是配置类，导入 bcryptpasswordencoder 实现密码加密和匹配，启用 @enable global method security 注解使 Controller 方法上的 Pre authorize 注解生效。
    - 方法重写与配置：重写 configure 方法，指定从数据库获取用户信息的类和密码加密方式，关闭 CSRF 和 session，配置哪些接口需要认证和授权。
    - 过滤器配置：将 tokenfilter 注入 IOC 容器，并在 spring config 中添加到过滤器链中，同时配置认证失败处理器。
  - tokenfilter 类逻辑
    - 过滤逻辑：根据用户是否携带 TOKEN 以及 TOKEN 是否有效进行不同处理，若未带 TOKEN 则不设置标志位并放行，带了 TOKEN 但无效则抛异常，带了 TOKEN 有效则设置标志位并放行。
    - 异常处理：若解析 TOKEN 失败，抛出异常并由认证失败处理器捕获，设置返回状态码为 401 表示认证失败。
  - Controller 方法原理：在 Controller 方法中使用 authentication principle 注解获取用户信息，spring security 通过 security context holder 设置用户信息和权限，判断用户是否有权限访问接口。
- 接口开发
  - 注册接口
    - 参数校验：使用注解对登录参数进行入参校验，包括用户名和密码的非空、长度等要求，并设置详细的错误信息。
    - 密码加密：使用 passwordencoder 对密码进行加密，将密文存入数据库。
    - 异常处理：若用户名已存在，抛出异常并由全局异常处理器捕获，返回相应的错误信息。
    - 并发问题解决：为避免并发注册导致的用户名重复问题，在用户表中添加用户名的唯一索引，捕获 duplicate key exception 异常并处理。
  - 登录接口
    - 认证处理：使用 authentication manager 进行认证，若认证失败抛出 Authentication exception 异常，捕获异常并打印日志，再抛出业务异常返回登录失败信息。
    - 生成 TOKEN：认证成功后，从 authentication 中提取用户信息，使用 JWT util 生成 TOKEN，并将 TOKEN 设置到 response 的 header 中返回给前端。
  - 其他接口
    - 获取自己信息：创建 user VO 类，使用 getmapping 注解，使用 has any role 注解进行授权，使用 authentication principle 注解获取当前用户信息，调用 user service 的 info 方法返回用户视图对象。
    - 获取指定用户信息：使用 getmapping 注解，使用 path variable 注解提取 URL 中的 user ID 参数，返回 user vo 对象。
    - 修改自己信息：使用 putmapping 注解，创建 modifyuserparam 类接收前端传来的 body 参数，进行参数校验，使用 authentication principle 注解获取当前用户 ID，调用 user service 的 modifyinfra 方法进行修改操作。
- 授权功能测试
  - 接口分类：根据是否需要认证和授权将接口分为三类，即既不需要认证也不需要授权、需要认证但不需要授权、既需要认证也需要授权。
[图片]
  - Pre authorize 注解使用：在 spring security config 中开启注解功能，在 Controller 方法上使用 Pre authorize 注解，可使用 has authority、has any authority、has role、has any role 四种类型进行授权配置。
  - 测试验证：通过修改 TOKEN 中的用户权限，测试不同授权配置下接口的访问情况，验证授权功能的正确性。
- 接口测试
  - 获取自己信息：在 header 中携带 TOKEN 发送请求，验证接口返回的用户信息。
  - 获取指定用户信息：设置 user ID 并在 header 中携带 TOKEN 发送请求，验证接口返回的指定用户信息。
  - 修改自己信息：在 header 中携带 TOKEN，在 body 中设置要修改的参数，测试参数校验功能，验证修改操作的正确性。
暂时无法在飞书文档外展示此内容

智能章节
00:01  JWT使用流程：用户登录获Token后访问接口
本章节介绍了JWT的使用流程。用户登录时将用户名和密码提供给服务器，服务器验证后返回JWT。用户带上JWT访问接口，接口从JWT中提取用户信息，知晓用户身份后处理请求，并将响应结果返回给用户，同时还展示了JWT使用的图示。
00:35  JWT 数据结构、各部分内容及签名计算方式
本章节介绍了JWT的数据结构，其由三部分组成，分别是header、payload和Signature，中间用两个点隔开。header部分描述算法，payload部分可装载自定义信息，Signature是指定签名，它通过前两部分结合服务器存储的密码，按照header里指定的算法加密得出。
01:47  复制JWT工具类并引入项目依赖操作
本章节主要介绍了示范项目中JWT工具类的操作。说话人将JWT工具类复制到新建的util包下，为使用JWT，需引入其依赖。说话人从POM.xml中复制JWT依赖到项目的POM.xml里，加载变更后，项目新增了java - JWT依赖，此即所需的JWT依赖。
02:53  JWT工具类配置、结构及重点方法介绍
本章节主要围绕 JWT 工具类展开。说话人指出工具类已找到对应类，用 @value 注解从配置文件读取 secret 和 expiration，随后将相关内容复制到 application.yml 中，能定位 expiration 及其值。提到类中有两个字段和两个方法，logger 用 SLF 4J 装配，编译期会有，重点关注 get TOKEN from user 和 get user from token 这两个方法。
04:25  JWT工具类使用演示：用户与TOKEN互转测试
本章节介绍了一个工具类的使用。说话人先在测试类里装配 jwtutil，创建新用户并设置信息，将其转换为 TOKEN 查看其三段式结构。接着测试把 TOKEN 还原成用户信息，能成功拿出之前设定的内容。最后指出该工具类重要方法，即把 user 转 string、string 变 user，还提到密码需加密不能明文存数据库。
09:20  引入 springsecurity 依赖使用加密工具类
本章节指出 springsecurity 为用户提供了现成的加密工具类，若要使用，需引入 springsecurity 的依赖，可前往之前注释掉的部分进行操作。
09:30  Spring Security密码加密及匹配方法介绍
本章节主要介绍了Spring Security相关内容。取消注释spring boot STARTER security依赖，加载Maven变更后会增加Spring Security依赖。提到其重要接口passwordencoder，有encode和matches两个重要方法，注册接口用encode加密密码存进数据库，Spring Security调用matches对比前端密码和数据库密文，加密是单向不可逆的。
11:03  BcryptPasswordEncoder加密及匹配功能演示
本章节主要介绍了 passwordencoder 接口及其实现类，项目选用 bcryptpasswordencoder 实现类。该类默认不被 spring 管理，直接 autowired 会报错，需用 import 注解将其注入 IOC 容器。注入后可调用 encode 方法加密密码，加密后长度为 60，所以将 user 的 password 设成 X60，还能用 matches 方法判断密码是否匹配。
17:34  Spring Security认证授权项目代码操作讲解
本章节主要围绕项目中认证和授权的内容展开，项目使用spring security进行认证和授权。说话人将示范项目里的securityconfig类和tokenfilter类复制到当天项目，分别放在config和filter包下。在编写根据用户名获取用户信息的方法时，补充了方法、添加param注解，将result type换成result map以解决字段映射问题，最后格式化代码。
21:06  TokenFilter报错处理与用户角色权限设置
本章节主要围绕tokenfilter报错问题展开，说话人1提到需修改示范项目里的user，使其实现userdetails接口，要实现如getauthorities等方法且恒定返回true。还提及用户角色枚举user role，不同角色有对应权限，数据库中role列默认普通用户为0。清空数据库后，介绍了user返回权限的逻辑，最后表示要再看TOKEN filter。
24:50  Spring Security配置类详细讲解及功能说明
本章节主要围绕security config展开。重点讲解两个导入类，从spring security的configuration开始，介绍注入的类和注解作用，如bequeath password encoder用于加密匹配密码等。还提及重写configure方法配置spring security，指定获取用户信息类、密码加密方式，说明注入authentication manager的原因，以及认证、授权情况，添加tokenfilter和配置认证失败处理器。
30:16  静态类跨域设置与用户信息获取实现讲解
本章节主要介绍两个要点，一是静态类允许跨域，不仅要在 MVC config 里开启，在 spring security 中也要开启；二是关于 userdetailserviceimpl，它实现了 userdetailservice 接口，定义了从数据库根据用户名获取用户信息的方式，需重写 loadUserByUsername 方法，通过 userMapper 获取用户信息并返回实现了 userdetails 接口的 user 对象。
31:15  Spring Security认证失败处理及异常处理说明
本章节主要围绕springsecurity相关内容展开。因使用springsecurity，user需实现userdetails接口；定义了authenticationentrypointimpl实现authenticationentrypoint，作为认证失败处理器处理filter抛出的异常，因该异常在进入Servlet前出现，全局异常处理器无法处理；还提到注入objectmapper，设置返回状态码为401。
32:01  Token过滤器、JWT工具类及Spring Security原理
本章节主要介绍了认证相关逻辑，tokenfilter 类作为过滤器，根据 TOKEN 情况处理请求。jwtutil 可生成和还原 TOKEN。dofilter 方法是过滤器链关键分隔点。dofilter internal 方法用于解析 TOKEN，失败会抛异常被处理器捕获。Controller 方法中用 authentication principle 获用户信息，spring security 通过 user 的 getauthorities 方法判断权限，基于 Threadlocal 实现。
37:54  注册与登录接口开发及并发问题解决
本章节介绍注册和登录接口编写。先按Controller、service、Mapper顺序，用注解完成登录参数校验。在Controller里写登录接口，注意返回值不能是void。注册时用password encoder加密密码，处理用户存在与否的异常。最后指出注册并发问题，通过建用户名唯一索引解决，捕获重复键异常并抛出自定义异常。
53:31  注册与登录接口开发及认证异常处理讲解
本章节主要讲述注册和登录接口的编写。注册时需用passwordencoder对密码加密后存入数据库。登录接口使用Authentication，要将相关注解注入IOC容器。认证时用authenticationmanager，认证失败抛异常，捕获后打日志并抛出业务异常给前端。认证成功则提取认证主体，若为普通用户生成TOKEN存入header返回给前端。
01:00:10  Spring Security认证与授权部分讲解及接口分类
本章节继续讲解 spring security 认证和授权中的授权部分。以示例项目为例，在 security config 的 configure 方法里，三个接口无需认证，其余接口需认证。认证是判断用户是否为系统用户，授权是认证后判断接口权限。接口按认证和授权需求分三类，如 register 既无需认证也无需授权，加 preauthorize 注解的接口需授权。
01:02:17  Spring接口认证与授权的不同情况说明
本章节介绍了接口在认证和授权方面的不同情况。有的接口需要认证但不需要授权，如 getuserinfo 接口，只要带上合法 TOKEN，普通用户或管理员都可访问；有的接口既需要认证也需要授权，在 securityconfig 里需认证，还带有 preauthorize 注解，不仅要带合法 TOKEN，还会校验是否有相应权限。
01:03:19  展示preauthorize注解使用及TOKEN获取过程
本章节主要围绕 preauthorize 注解的使用展开。说话人在新项目中运行已写好的 login 和 register 接口，先清空数据库，在 apifox 注册账号“小明”并设置密码，注册成功后数据库显示加密后的密码。接着使用注册信息登录，操作成功后从 header 中获取 TOKEN 并复制保存。
01:05:15  测试授权功能接口认证情况及异常处理
本章节主要围绕测试授权功能展开。创建测试接口，该接口需认证但无需授权，只要带合法 TOKEN 即可访问。取消全局异常处理器里授权失败的注释，以便捕获授权失败异常。通过快捷请求测试，未带 TOKEN 时认证失败，带上则操作成功，故意删参数值或不带 TOKEN 又会认证失败，补上后再次成功。
01:08:59  Spring Security授权注解及权限匹配讲解
本章节介绍了授权功能，使用Pre authorize注解需在spring security config里开启注解功能。在Controller方法上使用该注解，可写has role、has any role、has authority、has any authority四种类型。通过调试展示了获取用户权限的过程，还对比了不同注解的匹配规则，可根据需求选用合适功能完成授权。
01:26:02  开发用户接口，介绍权限与注解使用方法
本章节主要围绕用户接口开发展开。已完成用户注册和登录接口，接下来要写获取自己信息、获取指定用户信息和修改自己信息三个接口。先编写获取自己信息接口，创建用户视图对象，设置访问权限，普通用户用 has any role user，管理员用 has any role admin，还介绍了 authentication principle 注解可直接获取当前访问用户。
01:30:43  获取指定用户信息及路径参数提取讲解
本章节主要介绍获取用户信息的相关操作，通过get user ID可得知当前访问用户ID，获取指定用户信息的方法带有pass参数。使用get mapping方法，因类上已写users，方法后无需重复。通过大括号提取path参数，在Controller方法里用pass variable注解提取URL里的path参数，返回user vo，即get user path variable。
01:31:55  用户信息接口开发及参数校验与异常处理
本章节主要围绕接口文档修改自己信息的方法展开，使用 putmapping 及相关 URL，创建 modifyuserparam 类接收前端 body 参数并添加参数校验。利用注解提取用户信息，调用 user service 方法修改信息。同时编写 Mapper 里返回 user VO 的方法，对 userid 进行有效性判断，异常会被全局捕获，最后完成三个接口编写并学习授权和提取用户信息的方法。
01:42:41  TOKEN接口测试及参数校验测试过程与结果
本章节主要讲述对三个接口的测试过程。说话人先获取自己的信息，在header里填写生成的TOKEN并发送请求；接着获取指定用户信息，设置user ID为17后带上TOKEN发送；最后修改自己的信息，设置body里的参数时，经多次尝试解决参数校验问题，最终操作成功，查看数据库和获取自己信息均显示修改有效。
暂时无法在飞书文档外展示此内容

关键决策
- 关键决策：完成用户注册、登录、获取自己信息、获取指定用户信息和修改自己信息接口的编写，并实现认证和授权功能。
  - 问题：需要实现用户相关接口的开发，包括注册、登录、信息获取和修改，同时要确保接口的安全性，实现认证和授权功能。
  - 讨论方案：
    - 说话人1提出使用 JWT 进行用户认证，通过 JWT 工具类生成和解析 TOKEN。
    - 使用 spring security 进行认证和授权，配置 securityconfig 和 tokenfilter 类。
    - 对密码进行加密，使用 bcryptpasswordencoder 实现加密和密码匹配功能。
    - 在 Controller 方法中使用注解进行参数校验和授权控制。
  - 决策依据：JWT 可以有效实现用户认证，spring security 提供了完善的认证和授权机制，加密密码可以保障用户信息安全，注解可以简化代码并提高开发效率。

---
- 其他决策：
  1. 在数据库中为用户名添加唯一索引，避免并发注册时出现重复用户名。
  2. 在 Controller 方法中使用注解进行参数校验，确保前端传入的参数符合要求。
  3. 在全局异常处理器中捕获异常，并按照规定的返回模板返回错误信息给前端。
暂时无法在飞书文档外展示此内容

金句时刻
「把一层一层的写更方便，这样省去了反复切换。」
—— 说话人 1，强调了按顺序分层编写代码的优势，能提高开发效率，避免反复切换带来的混乱。

「我的建议是每一个注解都写 message，虽然你不写 message，它也是有默认的那种提醒，但那种提醒不直观，所以我不是很推荐用它默认的那种提示。」
—— 说话人 1，提醒开发者在使用注解时要详细编写 message，使错误提示更直观，便于排查问题。

「认证就是说判断你这个用户是不是我们系统的用户，授权是更高级别的一级，就是先认证以后，然后我们再授权，看你这个接口有没有对应的权限。」
—— 说话人 1，清晰地阐述了认证和授权的概念及关系，有助于理解系统的安全机制。
暂时无法在飞书文档外展示此内容
