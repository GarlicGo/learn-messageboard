会议主题：1-后端培训项目 留言板 讲解（3）-480P 标清-AVC
上传时间：2026年3月31日（周二） 02:21 （GMT+08）
智能纪要由 AI 生成，可能不准确，请谨慎甄别后使用

总结
暂时无法在飞书文档外展示此内容
视频围绕 Mybatis 数据库操作展开，涵盖数据插入、查询、更新、删除等操作的详细步骤，同时介绍了参数校验、异常处理和数据库事务的相关知识，内容如下：
- Mybatis 数据插入操作
  - 依赖引入
    - 取消注释并加载：取消 POM.xml 中 Mybatis 和 Mysql 驱动依赖的注释，重新加载 Maven 变更，确保依赖成功引入。
    - 检查依赖数量：加载变更后，依赖项从 3 条增加到 5 条，新增的 Mybatis 和 Mysql 依赖成功引入。
  - 数据源配置
    - 复制粘贴配置：将之前项目的数据源配置复制到 application.yml 中，注意保持 data source 与 application、Jackson 等处于同一级别。
    - 修改关键信息：将用户名、密码和数据库名修改为自己数据库的连接信息。
  - Mapper 注解添加
    - 添加注解：在 src/main/java 里的 Mapper 文件夹下，给每个 Mapper 类添加 @Mapper 注解，使其能被 Spring 管理。
    - 检查添加情况：确认 4 个 Mapper 类都已成功添加注解。
  - SQL 语句编写与测试
    - 编写接口：在 user service 中添加 insert 接口，使用 @Param 注解指定参数名。
    - 生成 SQL 语句：在 Mapper 接口中添加方法后，若 XML 文件中未定义该语句，可点击 generate statement 自动生成。
    - 测试插入：使用测试类 @Autowired 注入 user Mapper，使用 @Test 注解标注测试方法，运行测试前检查数据库是否有数据，运行测试时若出现问题，需检查 Mybatis Mapper locations 配置和 SQL 语句拼写。
- Mybatis 数据查询操作
  - 实体类属性修改：将实体类中的 password 改为 password，user row 改为 row。
  - Mapper 接口查询方法：在 Mapper 接口中添加 select 方法，使用 @Param 注解指定参数名，点击 generate 生成 SQL 语句。
  - 结果映射问题解决
    - 问题分析：由于数据库字段名与实体类属性名不一致，导致查询结果部分字段为 null。
    - 解决方案：使用 result map 进行映射，在 userMapper XML 中添加 result map 配置，指定 ID 和 type，将数据库字段名与实体类属性名进行映射，将 result type 改为 result map。
- Mybatis 数据更新与删除操作
  - 编写 SQL 语句
    - 更新语句：在 userMapper 中编写 update 语句，根据用户 ID 更新昵称和性别。
    - 删除语句：编写 delete 语句，根据用户 ID 删除记录。
    - 格式化代码：使用 Ctrl + Alt + L 快捷键格式化代码，使代码更整洁。
  - 返回值处理：虽然未设置返回值类型，但默认返回 int，表示 where 条件匹配的行数。
  - 测试操作
    - 更新测试：在测试类中调用 update by ID 方法，传递用户 ID、新昵称和新性别，运行测试后检查数据库记录是否更新。
    - 删除测试：调用 delete by ID 方法，传递用户 ID，运行测试后检查返回值和数据库记录是否删除。
- 通过 HTTP 请求操作数据库
  - 创建 Controller 包和类
    - 创建包和类：创建 Controller 包，在包中新建 usercontroller 类，添加 @RestController 和 @Slf4j 注解。
    - 设置请求前缀：在类上添加 @RequestMapping 注解，设置请求前缀为 API message board V1 users。
  - 处理请求参数
    - 创建参数类：创建 param 包，在包中新建 registerparam 类，添加 @Data 注解，包含用户名和密码属性。
    - 提取参数：在 usercontroller 方法中使用 @RequestBody 注解从 HTTP 请求体中提取用户名和密码。
  - 调用服务方法
    - 注入服务：在 usercontroller 中 @Autowired 注入 user service 接口，导航到自动装配的依赖项，发现装配的是 user service impl 实现类。
    - 调用方法：调用 user service 的 register 方法，将用户名和密码插入数据库。
  - 接口测试
    - 运行项目：运行项目，使用接口测试工具发送 post 请求，携带用户名和密码，检查返回结果和数据库记录。
    - 插入多条数据：多次发送请求，插入多条数据，检查数据库记录是否增加。
- 枚举类型的使用
  - 创建枚举类
    - 创建包和类：创建 constant 包，在包中新建枚举类，如 user sex 枚举。
    - 定义枚举值：按照命名规范，使用大写字母和下划线定义枚举值，如 UNKNOWN(0)、MALE(1)、FEMALE(2)。
    - 生成构造函数和 getter 方法：生成枚举类的构造函数和 getter 方法，确保枚举值不可更改。
  - 其他枚举类：将示范项目中的其他枚举类复制到 constant 包中，如 user role、result code、举报类型、留言种类 等。
  - 枚举值获取：通过枚举类的 get code 和 get message 方法获取枚举值。
- 参数校验与异常处理
  - 入参校验
    - 引入依赖：在 POM.xml 中引入 spring boot starter validation 依赖，重新加载 Maven 变更。
    - 添加注解：在 registerparam 类的字段上添加 @NotBlank、@Length 等注解，设置参数校验规则。
    - 启用校验：在 Controller 方法上添加 @Valid 注解，启用参数校验。
  - 全局异常处理器
    - 复制处理器：将示范项目的 global exception handler 复制到项目中，注释掉 spring security 相关代码。
    - 处理异常：使用 @RestControllerAdvice 和 @ExceptionHandler 注解处理异常，将异常信息格式化后返回符合通用返回模板的结果。
  - 自定义异常信息：在 registerparam 类的注解中添加 message 属性，指定更详细的错误信息。
- 自定义异常
  - 创建异常类
    - 创建包和类：创建 exception 包，在包中新建异常类，如 notfoundexception、illegaloperationexception、business exception 等。
    - 继承异常类：自定义异常类继承 RuntimeException 类，生成构造函数。
  - 异常处理
    - 捕获异常：在全局异常处理器中使用 @ExceptionHandler 注解捕获自定义异常，使用 @ResponseStatus 注解设置 HTTP 状态码。
    - 测试异常：在 Controller 中抛出不同类型的异常，检查返回的 HTTP 状态码和错误信息。
- 数据库事务
  - 事务特性：数据库事务需遵守 ACID 特性，即原子性、一致性、隔离性和持久性。
  - Spring 事务实现
    - 插入数据：在 Controller 的 register 方法中调用 service register 方法，插入三条数据。
    - 异常处理：在插入过程中抛出异常，未使用 @Transactional 注解时，部分数据插入成功，产生脏数据；使用 @Transactional 注解后，异常发生时所有操作回滚，数据库无脏数据。
  - 注解使用建议：在对数据库进行多个更改操作的方法中添加 @Transactional 注解，单纯查询操作无需添加。
暂时无法在飞书文档外展示此内容

智能章节
00:01  Mybatis插入首条数据及POM依赖引入操作
本章节主要讲解如何利用 Mybatis 插入第一条数据。为使用 Mybatis，需取消 POM.xml 中 Mybatis 依赖和 Mysql 驱动依赖的注释并引入。初始只有三条依赖，重新加载 Maven 变更后依赖项变为 5 条，Mysql 和 Mybatis 依赖是取消注释后新增的。
00:55  YML中数据源配置及信息修改说明
本章节说话人1指导配置数据源的操作。先将之前写好项目中的data source复制到spring application的YML文件里，调整缩进使其与application、Jackson级别一致。指出driver class name、user name、password、URL是data source的下层。强调要将用户名、密码和数据库名字修改为自己数据库连接的对应信息，不能照抄。
02:37  添加数据源后给 Mapper 文件夹文件加注解操作
本章节主要介绍了数据源添加到 application yml 后的操作。需找到 src main 下 Java 里的 Mapper 文件夹并打开，给其中每个 Mapper 加上 Mapper 注解，加完注解后会出现绿色图标，加上注解可使 Mapper 被 spring 管理，不加则无法被管理，最后确认 4 个 Mapper 都已添加注解。
03:33  以user表为例写SQL语句及XML配置处理
本章节主要围绕编写第一条 SQL 语句展开，以 user 表为例，在 user service 加 insert 接口。强调接口完成后对应 XML 文件为空，介绍接口里返回值、方法名、param 注解的作用，指出传基础类型需加 param 注解。还提到将内容加到 userMapper 时出现问题，通过点击 generate statement 生成相关声明，最后给出 insert 语句示例。
06:35  Mybatis测试插入数据遇问题及解决过程
本章节主要讲述了数据库插入操作的测试过程。先在测试类中自动装配 user Mapper，用 test 注解标注测试方法。运行前发现数据库无数据，首次运行报错，原来是忘了配置 Mybatis 的 Mapper locations 及 password 拼写错误，改正后测试通过。插入数据时，主键自增，部分字段采用默认值，创建和更新时间由数据库自动填充。
11:04  讲完insert后介绍select及实体类修改
本章节说话人1在讲完insert后，开始介绍select相关内容，并提及实体类方面的操作。具体是可以把实体类中的password保持原样，将user row改为row。
11:25  Mapper接口select操作及参数注解代码提示情况
本章节说话人1介绍在Mapper接口中进行select操作，返回值为user并导入传参。点击generate后，井号和大括号里的值与跳转和harem里的值相同。若修改内容，代码提示会与param注解里的字符串一致，最后说话人将内容改回userid。
13:01  用getbyid测试并对比结果与数据库数据
本章节说话人1提出要在测试类里使用getbyid进行测试并打印结果，查看运行效果。还提到要对比测试结果与数据库内容是否一致，随后点开数据库查看了相关字段信息，包括user ID为null、user name正常、password为null等多个字段情况。
14:13  利用result map解决实体类与数据库名不一致问题
本章节主要讨论了实体类和数据库字段名不一致导致查询结果为 null 的问题。解决方法是在项目的 userMapper XML 里使用 result map 进行映射，指定 ID 和 type，区分主键与非主键。将 result type 改为 result map 并写入其 ID，修改后查询显示数据库字段信息已能正常写入实体类，强调要熟练编写增删改查相关内容。
18:11  Mybatis x 插件下更新与删除语句编写讲解
本章节主要介绍了数据库操作中 update 和 delete 的实现。发言者表示将依据用户 ID 更新昵称和性别、按 ID 删除记录。借助 Mybatis x 插件可在代码和 XML 文件间便捷跳转，通过 generate 生成相关语句，还可使用快捷键格式化代码。虽未设置返回值，但 update 和 delete 操作默认返回 where 条件匹配的行数，可用 int 类型接收。
22:29  数据库更新、删除操作及数据添加演示
本章节主要介绍数据库操作。先在测试类更新用户信息，update by ID 需传递 ID、昵称和性别，返回值为匹配行数。接着演示 delete 操作，填不同 ID 测试返回值，返回 0 表示未匹配到，返回 1 则成功删除一行。最后说明添加用户，填用户名和密码并提交，user ID 自增，部分字段采用默认值或由数据库自动填充。
28:00  设置日志级别为 debug 方便 SQL 调试
本章节主要讨论了让控制台显示 SQL 语句以方便调试的方法。说话人将旧项目里 logging 的三行内容复制到 application.yml 文件，把 club Hive message board map 包的日志级别改成 debug。运行项目后，控制台输出了如 get by ID、update by ID、delete by ID 等 SQL 语句，这种设置使开发调试更便捷。
30:37  HTTP 请求操作数据库的 Controller 创建方法
本章节介绍了通过 HTTP 请求操作数据库的步骤。首先要创建名为 Controller 的软件包，接着在该包中新建类 usercontroller，为前后端分离项目，给类加上 restcontroller 注解，还添加 SLF4J 注解用于打印日志。在类上添加 requestmapping 作为类中所有方法的前缀，如“API message board V1”，get Mapping、post Mapping 等会拼接其上。
31:49  用户注册接口文档解读与代码实现过程
本章节主要介绍了用户注册接口文档的实现。将“users”提到类的 request mapping 上，新建“param”包存放注册参数类“registerparam”。Controller 依赖 Service，Service 依赖 Mapper，通过 requestbody 注解提取参数，利用 IDE 工具自动生成方法，调用 userMapper 的 insert 方法将用户信息插入数据库完成注册。
36:29  用接口测试工具向数据库插入新用户操作演示
本章节主要讲述使用接口测试工具向数据库插入新用户的过程。先查看 user 里内容，修改接口测试工具环境，点击运行、自动生成并发送请求，返回结果显示操作成功。接着去数据库查看，发现有默认值数据。随后多次插入不同用户，数据库行数增多，因设置自增，userid 由数据库生成，最终完成新用户插入。
38:45  Java中枚举类创建及使用示例讲解
本章节主要介绍了将接口文档中的常量写入 Java 代码的方法。先在项目中新建名为 constant 的软件包存放枚举，以 user sex 枚举为例，示范创建枚举的过程，包括按规范命名枚举值、生成构造函数和 getter 方法，强调枚举字段可设为 final 防止值被更改，最后将其他枚举复制到该包中。
42:47  Consan枚举介绍及获取枚举值演示
本章节主要介绍了 consan 里的枚举内容，包括 user role、authorities、result code、举报类型等。指出 authorities 是 spring security 工具类可不管，result code 用于业务状态码。强调枚举内字段类型无限制，可含 int、string 等，命名需全大写用下划线隔开，字段定义为 private final，还展示了通过构造函数及 get 方法获取枚举值并打印的操作。
45:37  注册接口入参问题及引入校验依赖解决办法
本章节指出已完成的简单注册接口存在问题，用户瞎填内容接口也会接受，如填空或超长字符，会出现数据库not null约束异常或data too long错误。为防止用户乱输入，需进行入参校验，要在POM.xml里引入spring boot starter validation依赖，重新加载Maven变更后即可进行入参校验，方法较为简单。
48:46  param参数校验及数据库字段长度限制说明
本章节主要讨论参数校验和数据库限制。param不能为空，not null和not blank有区别，后者要求更高，如password用not blank修饰。数据库对username长度限制为最多20，虽password加密后定长，但为防输入过长，限制其最大长度为60。同时指出param一个字段上参数校验注解可不止一个，not blank和length限制可同时生效。
50:09  参数校验功能开启测试及返回格式优化探讨
本章节主要介绍参数校验相关操作。在 Controller 方法上加 advalid 注解开启参数校验，只需在 param 字段加约束及在方法前加注解即可。测试时故意传入空字符串，出现参数校验失败异常，且未进入 Controller 方法。但控制台打印内容繁杂，返回格式不符合自定义模板，需想办法使其符合之前定义的返回模板。
52:45  配置全局异常处理器，注释相关代码后重启项目
本章节主要围绕全局异常处理器展开。说话人1打开示范项目中的global exception handler并复制粘贴到当前操作中，将部分spring security相关内容注释掉以消除报错，之后打算重启项目。
53:43  全局异常处理器功能、内容及返回格式解析
本章节主要围绕全局异常处理器展开。发送空字符串符合返回模板得益于全局异常处理器，说话人提出查看请求、异常类型和原因。展示了全局异常处理器代码，它用 restcontrolleradvice 标注注入容器，用 exceptional handler 标注处理异常类型，将参数校验失败异常格式化，以 VAR 级别打印并返回 common result，使后端返回符合通用格式。
55:46  参数校验注解及错误信息指定方法介绍
本章节主要围绕参数校验展开。可在param包的registerparam里通过加message方法指明详细错误信息，如用户名、密码相关要求。通过在param类上加not blank等注解，在Controller上加ad valid注解启用校验，在全局异常处理器捕获异常并包装返回。还介绍了多种注解，如min、Max等，及它们的具体作用。
01:00:34  项目中自定义异常的创建与使用说明
本章节主要介绍了项目中自定义异常的相关内容。需在项目里创建 exception 包存放异常，自定义异常通常继承 runtimeexception 类，生成构造函数即可。示范项目中有非法操作、请求资源不存在、业务异常三种异常，分别对应 HTTP 状态码 403、404，业务异常构造函数可传入枚举及信息。
01:03:31  全局异常处理器捕获异常及状态码设置说明
本章节主要围绕全局异常处理器展开，指出抛出异常需在其中捕获，否则返回格式不符合通用模板。介绍了`response status`注解可设置给前端的 HTTP 状态码，未设置默认返回 200。还列举了不同异常对应的 HTTP 状态码，如业务请求格式不对返回 400、`illegaloperationexception`返回 403 等，未匹配的异常由`exception class`捕获，返回 500。
01:06:20  Controller 异常抛出测试及全局异常处理说明
本章节进行在 Controller 里抛出异常的实验，分别抛出 not found exception、illegal operation 和 business exception，观察其返回的 HTTP 状态码，如 404、403、200 等，其中业务异常返回 200 但在请求 body 指明 code 和信息。还提到可在 exception 包定义更多异常，在全局异常处理器捕获，按需求设状态码并按通用返回模板返回。
01:10:00  数据库事务特性及原子性概念讲解
本章节主要介绍了数据库事务需遵守的ACID四个特性，即原子性、一致性、隔离性和持久性。重点解释了原子性，指一个事务中所有操作要么全部完成，要么全部不完成，不存在在中间某个环节结束的情况，如同要么全做完，要么全不做。
01:10:23  Spring事务实现及@Transactional注解使用说明
本章节主要介绍了 Spring 实现事务的相关内容。首先演示在 Controller 的 register 方法中插入三条数据，无异常时正常插入，抛异常则产生脏数据。接着说明使用 @Transactional 注解可解决此问题，添加该注解后，方法内操作在抛异常时会回滚。强调对数据库多更改操作时需加此注解，单纯查询则无需添加，避免滥用。
暂时无法在飞书文档外展示此内容

关键决策
- 关键决策：在项目中开启入参校验功能，并使用全局异常处理器使返回结果符合通用返回模板。
  - 问题：当前简单的注册接口会接受用户瞎填的内容，甚至在违背数据库 not null 约束或插入数据过长时才报错，且返回格式不符合通用返回模板。
  - 讨论方案：
    - 说话人1提出在 POM.xml 中引入 spring boot starter validation 依赖以开启入参校验。
    - 在 param 类的字段上加 @NotBlank、@Length 等注解进行约束，并在 Controller 方法上加 @Valid 注解启用参数校验。
    - 复制示范项目的全局异常处理器到项目中，捕获参数校验失败等异常，并使用 CommonResult 包装返回结果。
    - 在 param 类的注解中使用 message 属性指定更详细的错误信息。
  - 决策依据：通过实际测试，开启入参校验和使用全局异常处理器后，能有效拦截不符合要求的输入，且返回结果符合通用返回模板，便于前端处理和理解。

---
- 其他决策：
  1. 在项目里创建 constant 包存放枚举类，按规范定义枚举，如 user sex 枚举。
  2. 创建 exception 包存放自定义异常，自定义异常继承 RuntimeException 类，并在全局异常处理器中捕获相应异常并设置返回的 HTTP 状态码。
  3. 在对数据库一个方法内进行多个更改操作时添加 @Transactional 注解以保证事务的原子性，避免产生脏数据，但单纯的 select 操作无需添加该注解。
暂时无法在飞书文档外展示此内容

金句时刻
「RML 里面的 result map 非常有用，它解决了实体类和数据库名字不一样的问题，增改、删查一定要熟练编写。」
—— 说话人 1，突出了 result map 在解决实体类与数据库字段映射问题上的重要性，强调了对增删改查操作熟练掌握的必要性，是关于 Mybatis 操作的关键结论。

「通过在 param 类上面加 @NotBlank、@Length 等注解，在 Controller 上面通过 @Valid 注解启用参数校验，别忘了在全局异常处理器里面捕获异常，并用 CommonResult 包装起来，这样前端返回的就是一个符合通用返回模板的请求。」
—— 说话人 1，清晰地总结了开启入参校验和使用全局异常处理器的步骤和作用，是解决接口输入校验和返回格式问题的关键方法。

「在对数据库一个方法内进行多个更改的时候，@Transactional 注解肯定是要加的，但如果单纯的 select 操作，就没有必要加这个注解，不要滥用。」
—— 说话人 1，明确指出了 @Transactional 注解的使用场景和注意事项，避免开发者在使用该注解时出现滥用的情况，具有重要的指导意义。
暂时无法在飞书文档外展示此内容
