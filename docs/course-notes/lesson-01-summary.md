会议主题：1-后端培训项目 留言板 讲解（1）-480P 标清-AVC
上传时间：2026年3月31日（周二） 02:17 （GMT+08）
智能纪要由 AI 生成，可能不准确，请谨慎甄别后使用

总结
暂时无法在飞书文档外展示此内容
视频围绕 Java 项目开发展开，涵盖项目创建、工具使用、Spring IOC 应用、Controller 编写以及通用返回模板设置等内容，旨在帮助参会者掌握项目开发的关键技术和方法，内容如下：
- 项目创建与配置
  - 项目初始化
- 创建步骤：通过文件新建项目，选择 Spring Initializer，项目名为 message board，位置为 D 盘根目录，语言选 Java，类型选 Maven，组为 club.devHub，工件与名字一致，JDK 选 17，打包成 jar 包，勾选所需依赖后点击创建。
[图片]
    - 结构精简：删除项目中用不到的文件，如 help.md、mvnw、mvnw.cmd 等，由于是前后端分离项目，可删除 static 和 templates 文件夹。
  - POM.xml 管理
    - 依赖管理：Maven 是项目管理工具，可对 Java 项目进行自动化构建和依赖管理。在 dependencies 中添加依赖，Maven 会自动从中央仓库下载 jar 包。每次对 POM.xml 更改后，需点击加载 Maven 变更使更改生效。
    - 插件管理：POM.xml 中的 plugins 对应插件，Spring 初始化自动引用了 spring boot 插件，Maven 也会自动导入一些插件。插件提供特定功能，可直接使用。
    - 编译运行：点击启动类运行项目，Maven 会将 src 下的资源编译成字节码存于 target 文件夹。Maven clean 可删除 target 文件夹，再次运行会重新编译。
- 工具使用
  - Lombok 注解
    - 简化类编写：Lombok 注解可简化类的编写，如 @Data 注解可自动生成 getter、setter、toString、equals、hashCode 等方法，@AllArgsConstructor 生成全参构造方法，@NoArgsConstructor 生成无参构造方法。
    - 示例验证：创建 Person 类，未使用 Lombok 注解时，需手动生成构造方法、重写 toString、equals、hashCode 等方法；使用注解后，代码大幅简化，且功能正常。
  - ObjectMapper 转换
    - 对象转 JSON：使用 ObjectMapper 的 writeValueAsString 方法将对象转换为 JSON 字符串，需处理 JSONProcessingException 异常，可在 main 方法上添加 @SneakyThrows 注解简化处理。
    - JSON 转对象：使用 ObjectMapper 的 readValue 方法将 JSON 字符串转换为对象，传入 JSON 字符串和目标类的 Class 对象。
  - SLF4J 日志
    - 注解使用：在类上添加 @SLF4J 注解，可直接使用 log.info、log.warn、log.error 等方法打印日志，能显示时间、级别、当前类及内容。
    - 占位符打印：使用占位符可使日志打印更清晰，如 log.info("参数1: {}, 参数2: {}", 123, 456)。
- Spring IOC 应用
  - 实体类创建
    - 创建实体：在 messagebroker 包下新建 entity 包，创建 School、College、Dormitory 和 Student 实体类，添加 @Data 注解简化编写。
    - 关系梳理：学校包含学院和宿舍，学院和宿舍包含学生，明确各实体间的依赖关系。
  - 依赖注入
    - 组件注解：使用 @Component、@Service、@Controller、@Repository 注解将类注入 Spring IOC 容器，这些注解功能相同，仅用于区分类的类型。
    - 依赖管理：使用 @Value 注解注入基本属性值，@Autowired 注解注入引用类型的依赖。
    - 配置文件读取：可从 application.yml 配置文件中读取属性值，如 @Value("${school.name}")。
  - Scope 注解
    - 单例模式：默认情况下，Spring 创建的 Bean 是单例的，多次从容器中获取同一 Bean 得到的是同一个实例。
    - 原型模式：使用 @Scope("prototype") 注解可使每次获取 Bean 时返回新的实例。
  - Bean 注入方式
    - 组件注解：在类上添加 @Component 等注解将类注入容器。
    - 配置类：创建配置类，使用 @Configuration 注解，在方法上使用 @Bean 注解返回要注入的 Bean。
    - Import 注解：在配置类上使用 @Import 注解导入要注入的类。
- Controller 编写
  - 请求报文分析
    - 组成部分：HTTP 请求报文由请求行、请求头和请求体组成，请求行包含方法、URL 和版本，URL 可携带信息，请求头用首部字段和字段值表示，请求体一般用 JSON 格式。
    - API Fox 对应：API Fox 中，query 参数对应 URL 中的参数，header 参数对应请求头中的参数，body 参数对应请求体中的参数。
  - Controller 注解
    - RestController：在前后端分离项目中，使用 @RestController 注解，它是 @Controller 和 @ResponseBody 注解的结合。
    - GetMapping：使用 @GetMapping 注解处理 GET 请求，可指定请求路径，默认在项目根目录。
    - RequestMapping：将通用的请求前缀提到类上，使用 @RequestMapping 注解，方法上的注解路径会与类上的路径拼接。
  - 参数提取
    - RequestHeader：使用 @RequestHeader 注解提取请求头参数，可设置 required 和 defaultValue 属性。
    - RequestParam：使用 @RequestParam 注解提取 URL 中的 query 参数，默认必填，可设置 required 和 defaultValue 属性。
    - RequestBody：使用 @RequestBody 注解提取请求体中的参数，只能用于自定义类。
    - PathVariable：使用 @PathVariable 注解提取 URL 中两个斜线之间的参数，可使用多个。
- 通用返回模板
  - 模板引入
    - 克隆项目：从代码仓库克隆项目，导入 Maven 项目，同步依赖。
    - 模板复制：将 commonresult 模板复制到项目中，用于统一返回格式。
  - 包装器实现
    - 启用判断：实现 CommonResultWrapper 包装器，supports 方法返回 true 表示永远启用。
    - 增强处理：beforeBodyWrite 方法根据返回值类型进行包装，若返回值为 null 或字符串，进行相应包装；若已为 CommonResult 类型，则直接返回。
  - 序列化配置
    - Jackson 配置：将 Jackson 配置复制到项目中，设置 defaultPropertyInclusion 为非 null 字段才序列化，避免 null 字段序列化。
    - 代码简化：使用包装器后，Controller 代码可更简洁，无需每次手动返回 CommonResult。
暂时无法在飞书文档外展示此内容

智能章节
00:02  新建Spring项目的步骤及配置要点
本章节介绍了新建项目的操作步骤。点击文件新建项目，选择 spring initializer，项目名为 message board，位置放 d 盘根目录。语言选 Java，类型选 Maven，组选 club.dev Hub，工件与名字一致，JDK 选 17，Java 选 17 并打成 jar 包。选版本 6.2.6.9，勾选 springweb、spring security、Mybatis、MySQL 等依赖，最后点击创建。
01:29  项目结构精简及各文件夹用途说明
本章节主要介绍项目结构精简操作。说话人1指出可删除如help.MD、maven-wrapper相关文件、static和templates文件夹，因前后端分离项目无需这些。还说明Java文件夹放源代码，resource文件夹放配置文件，test下Java文件夹放测试类，POM.xml是Maven构建规范，gitignore规定不上传内容，src是主要代码。
03:49  Maven项目POM文件配置及编译运行操作
本章节主要围绕 Maven 构建规范 POM.xml 展开。介绍了其继承的父项目、版本等信息，强调可在 dependencies 中添加依赖，Maven 会自动下载 jar 包。还提及插件 plugins，以及每次修改 POM.xml 后需加载变更。此外，通过操作演示了依赖的添加与去除、项目的编译运行、target 文件夹的清理等内容。
10:50  application配置文件类型及端口设置演示
本章节主要介绍了application配置文件的相关操作。application的property在classes文件夹下，可用classpath引用。默认的properties配置文件不好用，可改成YML类型。新建application.yml文件后，可指定端口和应用名，如将端口从默认的8080改成9090等，若设为0会选未占用的随机端口，若8080被占可换其他未占用端口。
13:46  Lombok与Jackson工具使用及日志打印演示
本章节介绍项目初始化完成后用到的工具。先讲 Lombok，展示不用注解时编写构造器、toString 等方法的繁琐，添加相关注解可简化编写。接着介绍用 ObjectMapper 实现对象与 JSON 互转，还提到 SLF4J 注解用于打印日志，有不同级别，且可用占位符打印含多参数的日志，使输出更美观。
27:04  Spring IOC管理实例依赖关系对比传统方式
本章节主要讲解 spring 的 IOC。先在 messagebroker 包下新建 entity 包，创建包含学校、学院、宿舍和学生四个实体类并添加 data 注解。接着分析不用 spring IOC 管理依赖关系的情况，通过创建各实体实例并设置依赖，发现需多次 new 和调用 set 方法，过程麻烦且依赖紧密，最后引出 spring 管理依赖的内容。
33:01  Spring IOC容器注入管理及依赖关系简化
本章节介绍了将类注入 Spring IOC 容器的方法，通过添加 component 注解把类交给容器管理，用 value 注解设置属性、autowired 注解处理依赖关系。重新启动后可查看注入情况，通过启动类获取 IOC 容器并从中取出所需的 bean。使用 Spring IOC 能简化依赖关系，无需手动 new 对象和 set 注入值。
41:28  Spring四个注解功能相同，可相互替换使用
本章节介绍了 Spring 框架中 component、service、Controller、repository 四个注解。这四个注解功能相同，都可标注在类上，让 Spring 容器将其实例化并放入 IOC 容器，依赖关系由 Spring 管理。它们表面不同仅为方便区分类型，实质功能一样，可相互替换，使用后 bean 都由 Spring 管理。
43:15  从 application.yml 配置文件读取 value 值
本章节主要介绍了从配置文件中读取值的方法。当前 value 是写死的，可从 application.yaml 配置文件读取。以 school name 为例，在 value 里用 $ 加括号，括号内写配置文件的值路径，多级用点分开，如 school.name 。重新运行可看到从配置文件读取的名字，无标黄警告，还可将其他值也改成从配置文件读取。
44:59  容器单例与原型模式下getbin结果实验
本章节主要介绍了 rvalue 是注入属性值，还提及 scope 注解。默认 scope 为 Singleton 单例模式，多次从容器 get bin 返回同一对象，实验验证了这一点。将 scope 改成 prototype 后，每次 get bin 返回新对象。最后建议将之前改动恢复，默认使用单例模式，删除 scope 注解。
48:08  Spring中component注解删除影响及替代方法探讨
本章节主要探讨Spring框架中组件注解的作用。说话人先提到使用`component`注解可让类交给容器托管，随后注释掉该注解进行测试，发现`student`类无法被Spring托管，装配时找不到该类型的bean，恢复注解后可正常装配。最后还提出若不使用`component`注解，是否还有其他让类被容器管理的办法。
49:30  配置类与 Bean 注解注入 IOC 容器操作讲解
本章节介绍了使用配置类将 bean 注入 IOC 容器的方法。创建配置类并添加 configuration 注解，用 bind 注解返回想创建的类型，方法名即 bean 名。虽 student 未用 component 注解，但可从配置类注入。还可关闭显示库 bean 只显示自定义 bean，student 依赖 dormitory 和 college，由配置类创建，atbin 注解可创建 bean 并导航到自动装配候选项。
52:09  多种方式实现 Bean 注入及效果验证
本章节介绍了将类注入 IOC 容器的方法。除了在 configuration 里用 bind 注解注入，还可用 import 注解加到配置类上。试验发现，未加 import 注解时因容器中无 student 类会报错，添加后容器正常启动且 actuator 显示 student 在容器里。创建 Bean 可加 component 注解、用配置类加 atBean 注解，或用 atimport 写类的 class，均可完成注入。
54:32  多类符合装配要求时指定注入类的方法
本章节讲解当有很多类符合装配要求时的处理方法。先创建calculator类、接口及实现类，将接口类型装配到calculator类并注入IOC容器。运行时发现有多个实现类符合要求会报错，可使用primary注解指定优先装配的类，标注后能正常运行，优先调用标注了primary注解的类。
01:02:09  Spring装配方式及新增方法操作演示
本章节主要介绍了 Spring 中自动装配的方法。说话人先演示了使用 substring 方法和 qualifier 注解，不加 primary 注解时会报错，用 qualifier 指定可解决。说明了类名默认规则及可自定义名字。还展示添加新方法，新建类实现接口，用注解注入容器，最后提到不用 qualifier 用 primary 也可成功装配所需 bean。
01:08:38  HTTP请求报文组成及API Fox参数对应讲解
本章节在讲解编写 Controller 前，先介绍了 HTTP 请求报文格式，其由请求行、请求头和请求体三部分组成。请求行含方法、URL 等，URL 可带信息；请求头用首部字段和字段值表示；请求体常用 JSON 格式。还说明了 API Fox 中 query、header、body 参数与请求报文各部分的对应关系，最后提及新建 Controller 软件包和 my Controller 类。
01:11:14  前后端分离项目Rest Controller注解使用及请求模拟
本章节主要介绍前后端分离项目中 rest Controller 注解，它是 Controller 与 response body 注解的结合。以 hello world 为例，用 get mapping 接收 get 请求，默认在 8080 端口访问。可添加端点路径，修改内容后重启项目会更新。因浏览器只能发 get 请求，可使用 API Fox 模拟 get、post、put、delete 等请求。
01:15:22  8080端口请求方法测试及前缀优化演示
本章节主要围绕端口与请求方法设置及优化展开。在8080端口测试了get、post、put、delete等请求方法，展示不同方法使用及修改后的响应情况；将通用请求前缀APIV1提到类上用request mapping注解，拼接匹配URL；还可将接口测试工具的前缀提到环境设置，设置好前置URL后，短URL也能正常请求，省事高效。
01:21:38  Controller中使用注解提取header参数的方法及设置
本章节主要介绍了在Controller中提取header参数的方法。可使用request header注解提取，在API Fox设置header参数运行方法验证，该注解默认必填，不带header发送会报错，设require为false可使其非必填。若不想绑定为null，还可加default value设默认值，最后还将重启验证默认值能否正常使用。
01:24:26  RequestParam注解提取Query参数及默认值设置
本章节主要介绍了如何提取 query 参数，使用 requestparam 注解，query 参数写在 URL 里。requestparam 默认必填，可通过 require=false 设为非必填，还能用 default value 设置默认值。尝试用 requestparam 接收自定义类提取 URL 中 query 参数会报错，不加该注解则可行，也能为自定义类设置默认值。
01:31:50  RequestBody注解使用测试及自定义类接收示例
本章节主要介绍如何提取 body 参数，使用 request body 注解。该注解只能用于自定义类，不能用于 Java 官方提供的 string、integer、long 等。通过测试发现，用 string 接收会将整个 json 赋值，用 int 接收会报错。而使用自定义的 userprarm 类能成功接收 body 里的 name 和 age 参数。
01:35:30  使用pathvariable注解提取URL中path参数演示
本章节介绍了提取 path 参数的方法，path 参数是写在 URL 两个斜线之间的参数，可用 pathvariable 注解提取。重启项目后，不用 body、params、header。通过示例展示，单 pathvariable 可准确获取 ID，多 pathvariable 也能正确匹配，能将 URL 中两个斜线间的内容提取并绑定到对应 ID 上。
01:37:18  通用返回模板包装器讲解及项目克隆导入
本章节主要介绍通用返回模板的包装器。说话人先让从代码仓库克隆地址，在 idea 中新建来自版本控制的项目并粘贴地址克隆，在新窗口打开同步 Maven 项目。接着说明 SQL 文件夹用于初始化数据库，介绍了 Maven 的 POM.xml 依赖。最后复制相关内容到新建文件夹和 VO 中，讲解通用返回模板 commonresult 各字段含义。
01:40:25  Controller返回格式统一及序列化配置优化
本章节主要围绕Controller返回格式展开。说话人通过实验测试返回字符串、void、Hashmap、自定义对象等不同类型的前端效果，为统一返回格式引入common result wrapper，介绍了其相关方法及配置。还调整了Jackson的JSON序列化配置，避免null字段序列化。使用包装器可避免Controller代码重复，使代码更简洁。
暂时无法在飞书文档外展示此内容

关键决策
本次会议为分享类会议，无关键决策。会议关键内容总结如下：
- 项目初始化：介绍了使用 Spring Initializer 创建 Spring Boot 项目的步骤，包括选择项目类型、配置依赖、设置项目结构等。
- 工具使用：讲解了 Lombok、Jackson 等工具的使用，以及如何使用这些工具简化代码编写。
- Spring IOC：阐述了 Spring IOC 的概念和使用方法，包括如何将 Bean 注入到 Spring 容器中，以及如何管理 Bean 之间的依赖关系。
- Controller 编写：说明了如何编写 Controller 类，以及如何处理 HTTP 请求和响应，包括如何提取请求参数、设置请求方法和路径等。
- 通用返回模板：讲述了如何使用通用返回模板包装器来统一返回格式，以及如何配置 JSON 序列化。
暂时无法在飞书文档外展示此内容

金句时刻
「为了让一个类能够正常使用，我们做了这么多工作，只有两个属性，就产生了包括构造器、toString、equals、hashCode，以及 get 和 set 等大量代码。其实我们这些都不用，只需要一个注解就够了。」
—— 说话人 1，强调了 Lombok 注解的强大功能，能够大大简化代码编写，提高开发效率。

「我们把之前手动 new 出来，然后用 set 注入的操作都省略了，全都交给 Spring 容器管理。只要在类上加一个 component 注解，需要的属性可以用 value 注入，也可以用 autowired 注入。使用 Spring 的 IOC 可以帮我们简化它们之间的依赖关系。」
—— 说话人 1，突出了 Spring IOC 的优势，即可以简化对象之间的依赖关系，提高代码的可维护性和可扩展性。

「通过这个包装器可以让我们的 Controller 不用每次都 return 一个 commonResult 了，这样在 Controller 的代码里就可以更加简洁。」
—— 说话人 1，说明了通用返回模板包装器的作用，能够减少代码的重复，使 Controller 代码更加简洁。
暂时无法在飞书文档外展示此内容
