会议主题：1-后端培训项目 留言板 讲解（5）-480P 标清-AVC
上传时间：2026年3月31日（周二） 02:25 （GMT+08）
智能纪要：1-后端培训项目 留言板 讲解（5）-480P 标清-AVC 2026年3月31日

说话人 1 00:00:01
我们现在来讲一下 spring AOP。spring 的最核心的就是一个 IOC， 一个是 AOP， 就是面向切面编程，我们可以用 AOP 来进行日志记录事务管理权限认证，然后性能监测等，这些像连接点切入点通知目标植入代理切面，这都是 AOP 的概念，不过这个看不懂也没关系。

说话人 1 00:00:27
这个是 spring AOP 的分类，它分为 before 前置通知， after 后置通知，还有 after returning 返回后通知， after throwing。抛出异常通知和 around 环绕通知，我们一会演示的就是使用这个 around 环绕通知，我们来到这个示范项目里面，这个示范项里，项目里面写好了一个 AOP 的演示了，是在这个，在 Handler 里面这有一个 service aspect， 我们把它复制到我们的新项目里，我们看一下这个有什么作用？我们在这里边现应该 Handler 这个软件包其实叫什么都可以，也可以不叫 Handler。也可以叫 advice， 也可以叫 aspect， 也可以这个没有具体的规定，也可以叫它 aspect。

说话人 1 00:01:26
我们想要使用这个 AOP 功能，我们需要新一种依赖，不然它这个爆红说找不到包。我们来到新项目看这个 POM 点 XML， 这个就是 Maven 的依赖管理。看到这个 AOP 了吗？我们需要它，然后把它。复制到我们的新项目的 POM， 点 XML 里面，我们给它粘进来，然后我们加载一下这个 Maven 变更，看它一会就会多出一个。好，现在多出了一个，这就是我们加载完变更以后，它引出来一个叫做 spring boot starter AOP 的一个依赖，我们有了它以后，我们再回到刚才的这个地方，它也不爆红了，就说明它已经找到这个类了。

说话人 1 00:02:15
我们来看一下我们引进来这个类，其实代码量不多，就是在这个类上面用这个 aspect 标注了一下，然后用 component 给它注入了这个 IOC 容器。我们先用这个 pointcut 定义了一个 pointcut 切面，这个是 ex- expression 表达式，我们这个意思就是说这个星儿就是方法任意返回类型都可以匹配，然后这个指定了一个包，我们看一下指定的是 impl， 是在 src 里面的 main 点 Java 的 Hub dev Hub messageport 里边有个 impl 是在 service 在这。有个 impl 就指定这样一个包，这个点星就是这包里的所有类，包括这四个类都算，然后这里边再点星，就是这里面类的所有方法。

说话人 1 00:03:30
这个括号点就表示这个方法里边可有任意的参数，就相当于这个包下，就是这个四个时间类里面所有的方法都符合要求，都能匹配上这个 around 就是指的是环绕通知，就是我们刚才看的有几类型，像 before after around， 这 around 就是这个一种类型。我们用 around 通知就是它既可以在方法执行前进行处理，也可以在方法执行后进行处理。像这个 join point proceed， 这个就是执行了我们真正代理的方法，这个 log 就是在它的执行前打印这个，就在它执行后打印我们这个短短的一些代码，就是完成这个打印日志的功能。

说话人 1 00:04:22
我们看一下这个日志，这是一个日志切面，我们用这个类展示了这个 spring 的面向切面编程。我们看一下这个新的图标，看一下，点一下它可以帮我们检测出它是帮我们提取了哪些方法。它这些方法都是匹配到的，我们可以随便点一个，我们看这边这个方法，这边也有一个这个图标，一点还可以点到这里，点这儿它可以看到导航到建议方法点进去以后点这个标就可以导航到 AOP， 建议我们来看一下有什么效果吧。

说话人 1 00:05:04
我们先不把它注入容器，我们看一下不启用是什么效果。我们运行一下，我们来到注册这个接口，我们点击运行，先随便生成点东西，这边启动起来了吗？哦，他还在编译，稍等一下，好了，现在才启动起来了，我们点击发送。回到这边看一下，这个是他没有打印这些日志的时候的一个控制台，发现我们这个 register 这个方法， register 是在 user MPL， 就是这个方法的，它的入参返回值都没有打印，我们把这个 component 注解取消一下。

说话人 1 00:06:34
我们再重新启动一下看看，这次我们把这个 aspect 注入到这个 spring 容器以后，让它生效了，它这个控制台能打印出什么？

说话人 1 00:06:55
这个时候我们生成一个，然后点击发送，这时候可以看到这个 AOP 前置处理，就是在这个调用方法执行前打印的，我们打印出了这个执行类是什么执行方法是什么？还有方法的入参，这个 AOP 后置处理就是在调用这个方法后的处理。我们反映了方法的出参，其实这不仅增强这一个方法，就是不仅增强了注册方法，连这个获取信息的方法也增强了，包括登录，包括获取信息，包括修改信息都可以通过 AOP 打印了日志，我们来看一下他们这参数是什么，复制一下，我们来登录一下，看一下他是不是也会打印这个，通过 AOP 打印信息。

说话人 1 00:08:05
发送我们来看一下有没有打印。这是 AOP 前置处理，他在调用方法前打印出来了这个执行类执行方法和方法入参。在执行完之后他有一个 AOP 后置处理，他打印出来了方法出参，把这个方法出参全打印出来了，这就很方便，我们就不用在每个方法都用一大堆 log 来写了，我们把它抽取出来，就专门抽取出来一个专门打印日志的一个切面，这样要修改的话只在这里边修改。

说话人 1 00:08:49
如果你日志格式想改的话，就在这个切面里边改就行了，也就不用每个方法都把他那个 log 改一大，改一遍就很麻烦，我们再看一下在获取把这个 TOKEN 复制一下，在获取自己信息的时候，这个 OP 还能作用吗？把 authorization 这一粘，我们来到控制台，诶，点错了。

说话人 1 00:09:21
你看 AOP 前置处理，这是有执行类执行方法，然后方法入参。方法出参，这个正是我们给前端显示的，所以说明这个 AOP 我们在这个时间类里面并没有打印任何的 log， 但它却帮我们打印了方法入参和方法出参，正是因为我们这是用 AOP 实现了这个日志打印，用户这些接口我们都写完了，我们现在开始写的是留言相关的接口，首先我们要写的是发表留言，我们看一下这个接口里边内容是什么。

说话人 1 00:10:09
这是一个 post 请求，我们需要在里边写的是留言类别和留言内容。我们来到我们的项目里面，我们需要新建一个 Controller， 因为是留言，我们就写的是 message Controller。新建 Controller 我们是要加 rest Controller 这个注解，这个 Controller 我们是需要装配的是 message service， 所以我们用 autowired 一个 message service。这个 message service 它是一个接口，它给你装配的其实是它的一个实现类。我们看一下它装配了什么？它装配的是这个 message service， 这个 impl 是实现了这个接口，一个实现类，我们回到接口文档，这是 post 请求，当然是要用 post Mapping。

说话人 1 00:11:12
我们用 ad post mapping， 这个 request mapping 我们复制一下，我们粘过来，但是这个我们就不是 user 了，我们这回叫 messages， 我们叫 messages。好，我们来看一下接口文档，它的环境是这个 API， 然后 message board V1，然后后边跟着是 messages。我们这个类上面用 request mapping 注解，上面写的是 API message ve messages， 这说明我们这个 post mapping 后边就不用再往后边接任何东西了，就不用再往后跟任何的 URL， 所以我们直接这样 post mapping， 这样让它孤零零一个注解就够了。因为这个发布没有什么返回值，我们就返回 void 方法，我们就叫做 publish。

说话人 1 00:12:28
我看一下这个文档里要求了哪些参数，还有 body 参数，我们所有的要需要 body 参数的，我们都是在这个 param 里面新建一个类，这个类我们叫做什么呢？叫做 publish message param。这意思就是说这是我们要接收发表留言的 body 里的参数，就是这块 body 参数这俩一个是 category， 一个是 content， 上来先按 data 注解，让它帮我们生成 get 和 set， 它有两个属性，一个是 category， 还有一个是 string 类型的 content。入参校验，千万别忘了我们使用注解进行参数校验，这个写错了，应该是 not null。对于 int 类型的话， not blank 是不适用的。not blank 它是用于字符串类型的，但是这种 int 类型的话不想让它为 null。

说话人 1 00:13:49
我们用的是 not null， 然后 message 需要写一下的 message， 就是说如果我们在这个参数校验失败的时候给前端显示的是什么信息？这取值范围也是有限的，最小是0， message 也要写一下，它最大也是有取值范围的， Max 就是限制它最大的取值范围， message 也是要写一下，这样前端才知道。

说话人 1 00:14:41
我们这个是哪里的参数校验失败？那我们这个 category 的这个参数校验已经写完了，我们用了 not null 注解，还有 min 注解，还有 max 注解，我们现在来搞这个 content 是个字符串，我们就是可以用 not blank， not blanks 既限制它不能是 null， 也不能是空字符串，不能是全是空格的字符串。

说话人 1 00:15:13
message 写一下，留言内容不能为空。还有这个字符串的长度我们也可以限制一下，用 lens， 我们这个数据库里设计的时候，我们这个我看一下 message 表展开这个列，可以看到这个 content 是 VARCHAR 25五，我们给它限制一下，最大别超过255 message， 我们也写一下。

说话人 1 00:15:49
现在我们这个 param 就写完了，我们回到这个 Controller 里去，首先这个是需要知道这是谁发的 authentication principle user， 然后导一下类这个文档上要求。我们先不管这个 request ID， 一会我再演示这个是什么用的，然后我们需要有从 body 里面取值，这个 value 的注解要加的，我们需要加上这个 value 的注解来开启这个入参校验。publish message。我们可以用 message service 来发布一下。

说话人 1 00:16:58
我们的这个留言 data userid， 这个 user 就是 spring security 帮我们的已经验证好这个请求的用户是谁了，他帮我们包装到这个 user 里面，我们可以直接用这个 user 的 get userid 来获取这个请求的用户的 userid。integer。诶，不对，这个是 category， 是 publisharm， 点 getcategory。以及 publish param 点 get 这是 content。

说话人 1 00:17:42
我们用 Alt enter 创建一个方法找到它的实现类，点击实现方法，点击确定，帮我们填好这个框架。这个 service 层我们是需要依赖 Mapper 的，我们来 Autowire 一下，诶，写错了， autowire private 这个我们要需要 message Mapper， 我们 Controller 是需要 autowire user service， 而我们的 user service 需要 user 依赖 user Mapper， 它们是。Controller 要 service， 然后 service 要 Mapper， 我们要 message Mapper 我们需要 insert 一下， insert 要包括 userid， 然后 category 还有 content。这个 Mapper 我们也是生成一下它的方法，我们 generate 一下这个基本的增改删查还是很简单的。

说话人 1 00:19:03
这个写起来很简单， values 井号大括号提取我们的参数值 u 没有代码提示吗哦？这个我们是要加那个 param 注解，里边写上 userid， 这个也要 param 注解。category 这个也要 param 注解，叫做 content。现在我们这样 param 注解以后，它肯定就会有这个代码补全了，我们再来试一下 user ID category content， 我们 control alt l 格式化一下，这样一条 insert 就写好了，我们可以去用测试类测试一下我们这个 insert 是否正常。我们来到这个 test 点开。先把它删掉，我们直接 autowired 一个 message Mapper， 然后用 add test 标注一下我们的测试方法。

说话人 1 00:20:36
我们可以调用 message Mapper 点 insert， 至于 user ID 我们就可以瞎编了，八八。然后种类就写个一，然后内容就开始写，随便写个内容，我们来运行一下这个测试方法。一开始这个是什么都没有的，我们让它编译一下，那它测试已通过，我们再来看这个 message 表里有没有东西刷新一下，诶？有了。

说话人 1 00:21:37
这个 user ID 是88，然后 category 是一，然后 content 随便写的内容，其他的 comment name 默认值 next four 默认值 create time 和 update time 由默认填充，说明这个方法是没问题的，把它关掉，这个也可以关掉，我们回到这个实现类，这个也不用。Controller 这。我想让它只有用户权限的才可以发送。我们用 Pre authorized as any role， 我只准。用户权限的人发送，于是就是 has any role user 这里面就不要带 role 那个前缀，因为他是，他会把 role 前缀和这个 user 拼起来，拼完以后他就给你用的权限对比，你加这个 role 前缀以后，他反而对不上了，我们来运行一下启动类，让他跑起来了。

说话人 1 00:23:11
之前我存了一个 TOKEN 在这里，我们把它复制一下，复制我们去接口测试工具发表一条，点击运行这个 header， 我们是要带的这个 request ID， 我们先，诶不可关闭吗？那先把它，我们先不填它，一会再演示这个功能是干什么的？把它关掉， body 里生成一个发送，这个 category 还给我们限制了最大不能超过4，那写2。现在操作成功了，我们去数据库看一眼。

说话人 1 00:24:13
真的有，我们刚才插入的这个是 category 二，然后 content 就是我们在接口测试工具里帮我们生成的一个，但是这有带来一个问题，我们就反复的发送、发、再发、再发，就如果前端它是如果连续点了很多次发送的话，那么它同一个内容在数据库里就会有很多条，我们看一下。

说话人 1 00:24:43
这么多条都是一样的内容，这不是我们想看到的，我们想让他对于发送的同样的内容，我们就数据库里只存一遍，对于重复请求我们就直接拒绝掉，不存入数据库。这个时候我们可以用一些手段来处理，有一个拦截器，我们可以用拦截器加上我们的缓存来搞定这个问题，我们就首先需要创一个注解。把这个 annotation 复制过去， annotation 就是注解的意思，有个注解这个 target 就是写可以标注在什么上面，我写的是可以标注在方法上面，然后这个 retention 就写的是可以保留到什么地方，我写的是可以在运行的时候都可以看到这个注解，所以写的是 runtime， 我们把。这个拦截器 interceptor 也复制过去。

说话人 1 00:25:58
粘过来，这个是一个拦截器，还有俩类也给搞过来，一个是要做 catchconfig， 叫做 m v cconfig 也给粘过去，放到 config 下面，就一共搞过来4个，那我们先看这个注解，注解看过了，这个注解就是标注在一个方法上面，然后我们看拦截器，来看这个拦截器。

说话人 1 00:26:32
拦截器它的作用就是它注入了一个 Concurrenthashmap， 用作缓存，这个是我们在这个 cacheconfig 这个配置类里面用这个 bin 注解去注入了一个 Concurrenthashmap， 我把它作为这个项目的缓存。其实这个用 Concurrenthashmap 其实不怎么合适，其实更适合用 Redis， 因为 Redis 它可以设置过期时间。

说话人 1 00:26:56
这个 prehandle 注解就是在进入这个 Controller 方法之前，可以判断它是否符合我们的拦截要求。如果它被拦截的话。要么抛出异常或者是返回 false 的时候。它就不会再进入 Controller 方法，就在这个拦截器返回 true 的时候，它这个请求才会进入 Controller 的方法里面。

说话人 1 00:27:22
这句话就是从这个 handler 我们要执行的 Controller 方法里面提取出来我们这个注解，如果这个方法上标注了这个注解，那么这个就不为 null， 就会进入这个 if， 如果这个方法上没有进入，没有标注这个注解，就会进入 else。就是直接放行就返回到 return true， 如果这个方法上标注了这个注解。

说话人 1 00:27:50
那么会进到这里面，他会先打印一条日志，说需要保证幂等性，他保证幂等性的方法就是从这个 request 里面拿出这个 request ID， 假如说两个请求他们有一样的 request ID， 那么先来的请求在这个 put if absent 就会返回 null， 这样的话他就会不会进入这里面？最后打印幂等性验通过返回 true 就会进入这个请求。

说话人 1 00:28:24
会进入 control 的方法，如果是第二个请求他有一样的 request ID， 那么他在执行这。那个 put if absent 的时候，它会返回之前那个旧值，它就不等于不为 not 会进入这个 if 小的 if 里面，它会抛出一个重复操作的异常，这个原理就是两个请求，他们想发相同的留言内容的话，他们就会带上相同的 request ID， 这样我们第一个请求会放行，第二个请求我们会判断它在缓存里面已经有这个 request ID 了，我们就会把它拦截住，它就不会再进入 Controller， 这样就保证了。

说话人 1 00:29:04
这个发布留言的一个幂，等我们来把这个 request 必填勾上，点击保存，现在讲完这个拦截器 interceptor， 我们还得把它开启，因为我们只用这个 component， 注， IOC 容器还不够，我们需要在 Web MVC configure 那里配置，这个是这个 Web MVC 一个配置类。我们实现这个 Web mvcconfigurer 以后，这个就成为了我们这个 spring MVC 的配置类。里面你可以使用这个 addinterceptor 方法来添加一个拦截器，我们看一下拦截器是什么呢？这就是我们自己写的拦截器，它实现了这个 handlerinterceptor 接口，然后我们用这个 autowired 注解注入到，诶哪去了？用 autowired 注解注入到这个 Web， 注入到这个 mvcconfig 里面，然后把这个类，然后。传到这个 addinterceptor 方法里面，并且设置这个匹配的路径是所有路径都会开启，我们来试一下效果，我们这回随便写一个值。

说话人 1 00:31:04
点击发送，第一次发是没问题的，我们看一下有没有这个内容，我们去数据库里，关键是有这个刚发送的内容的，我们再想发一遍，发两个同样的内容发送。操作成功，怎么又来一条？对。我们想开启这个功能的话，我们需要在 master Controller 这个方法上标注一下这个注解。in dub。

说话人 1 00:31:57
标注完注解以后，我们在拦截器里面。就会检测这个方法有没有这个注解，就直接放行，有这个注解就会进行更详细的判断，如果这是第一次看到这个 request ID 就会放行，如果之前已经有过这个 request ID 了，就会拦截抛出异常，就不会再往后走这个注解我们就是标在我们要发布留言的这个 Controller 的方法上面，先把它清空一下。

说话人 1 00:32:52
这个我们随便取一个值，第一次发送成功，看一下数据库里有没有这一条记录，它也是有的，这个内容也是我们刚才写进去的，第二次发再发现这重复操作，数据库里看有没有新增，就不会有新增了，我们多试几遍也是同样的效果。

说话人 1 00:33:26
复制一遍也是重复操作，看一下控制台的报错，可以看到它被拦截器拦截，因为这个 Controller 方法上标注了这个注解，于是它就会保证幂等性，它会每次都会校验这个 request ID， 它之前有没有出现过，如果之前已经有这个 request ID 的话，说明这是重复请求。它就不会再出这个请求了，如果是新的 request ID 的话，它就认为这是第一次请求，它就会去处理这个请求。我们把这个 request ID 改一改，把这 request ID 换一个值再发送，这回它就可以成功了。看一下数据库里。发现又有了，多了一条，我们再点发送，发现它重复请求了，因为我们这 request ID 它是同一个，对于同一个 request ID 请求的话，它认为这是重复的，它只请它只处理第一个请求。我们可以用创建一个注解，然后用拦截器的方式去保证这个接口的幂等性。

说话人 1 00:34:52
我顺便讲一下这个跨域，在这个 MVC config 类里面，你实现这个 Web MVC configurer 以后，你可以重写它的 addcrossorigin 这个方法。这样可以修改它的一些跨域的配置，因为我们前后端分离的项目一般是不同源的，就是要求协议、域名、端口号这三个完全一样才可以同源，是浏览器的一个保护策略，你把这个按照，把 registry， 然后按照这么一配，它就可以解决跨域问题了。

说话人 1 00:35:28
我们来继续写留言相关的接口，我们去现在来写编辑留言和删除留言。我们先看编辑留言，我们打开我们这个 Controller， 到 message Controller 里面看下这个文档，这个是 put， put 方法肯定是用 putmapping， 我们回到这里面，用 at putmapping 是用来匹配 put 方法的。

说话人 1 00:35:55
看一下这个 URL， 这个是 messages， 后边跟 message ID， 而这个 messages 我们已经标注在这个类上的 requestmapping 上面了，所以这个 messages 我们就不要写了，我们就直接写。叫做 message ID， 因为他会把这个 put Mapping 拼接到这个 request Mapping 后面，因为这是 pass 参数，我们需要用这个大括号把它括起来。

说话人 1 00:36:33
put mapping 这个也是没有返回值的，我们就用 void 里面用 authentication principle。来获取，这是哪个用户就在这发提取 pass 参数，我们是用的 pathvariable 注解，我们需要有个 body 体，看一下，这里边需要有 body 参数，对于 body 参数我们需要在 param 里面新建一个类，新建。这个是叫做编辑留言。叫 editmessageparam 上来先给加一个艾特 data 注解，让它帮我们生成 getter 和 setter， 然后写我们要的字段，一个是 category， 一个是 content， 然后别忘了要入参校验，我们先用注解来对它前端传过来的 param 进行校验，这个其实可以抄之前的，叫做。publish message param 就完。可以直接抄，我们就直接抄了，我就不再写一遍了。

说话人 1 00:38:04
这个也是，我就直接抄了复制过来，然后一粘 not null 就是表示不能为空，不能为 null， 不能为空串不能全是空格，最小值、最大值这个 not blank， 而 not blank 是指不能为 null， 不能为空串，不能为全是空格。not null 就是单纯的指不能为 null， 这个 lens 是限制字符串。

说话人 1 00:38:36
还有个最大长度不能超过这个长度，我们把它关掉，我们回到 Controller 里面，因为这是在 body 方 body 参数，我们看一下这个接口文档，这确定是 body 参数？对于这个 body 参数我们是用 request 的 body 注解，我们需要开启参数校验，就我们加上这个 valid， 后边跟这个是 Edit。

说话人 1 00:39:08
messagePara 我们定的是 message 的 service 的 edit 方法，我们需要传进去的一个是 user 的 ID get user ID， 还有一个是这个 message ID， 还有是编辑参数的种类别，还有编辑参数的内容，我们把它都传进去。

说话人 1 00:39:44
我们先把 Controller 写完，再管 service 层，这个是删除留言，它的方法是 delete 方法，我们肯定是用 delete mapping， 我们这里添加一个 delete mapping， 我们看这个文档它的 URL 多少是 messages， 然后 message ID， 然后这个 messages 我们在这个类上面已经有了，我们就不在这个 delete mapping 里边重复写了，就直接大括号，后边跟 message ID 直接写这个 pass 参数，就是现在 URL 里的参数。这个 delete 我们也没有返回值，我们可以照抄前面的，其实很多都可以复制，不用自己写一遍。这是 path 参数，我们用 path variable 来提取其中的 path 参数 long， 然后 message ID， 我们调用 message service 的 delete 方法，我们需要传给它是 user 的 user ID。

说话人 1 00:40:56
还有就是 message ID， 我想让它只有拥有用户角色的用户才可以来请求这个接口，于是我在这个接口上又加了一个 preauthorize， 里面用 has any role user 来限定，只有用户角色的用户才可以请求我们把这个在接口里面建一下，这个也一样，建一下，找到它的实现类，点击实现方法，把这点方法一实现。

说话人 1 00:41:30
对于这个 Edit 这个方法我们首先需要在 Mapper， 我们还没处理好，我们得先处理一下 Mapper， 我们来到这个项目里面 Mapper， 找一下 Mapper 在哪。Mapper， 在这儿找到 message Mapper。我们一会需要用到的是这个，给它粘过去，我们还要用到的是 update， 我们需要更新，这个也要用到给它粘过去。

说话人 1 00:42:37
除了这个方法，我们还要用到的是。DELETE 的 ID 这个也粘过去， delete， 我们要删除它。

说话人 1 00:43:01
好，我们顺便去把那个 XXML 复制一下， Mapper 的 XML 在哪呢？直接点这个跳转到这里。

说话人 1 00:43:18
诶， result map 我们就直接，诶是选哪个？选这个 result map 我们直接复制粘过来。result map 还是之前讲过的解决数据库字段名和实体类字段名它们不一致的问题。我们用到了 get， update， delete 这也粘过来。

说话人 1 00:43:55
这个就是根据 message ID 去选出 user ID， 这个是给定一个 message ID， 你去更新它的 category 和 content， 这个是从表中删除指定的 message ID， 我们回到之前的 service 里脚编辑我们肯定得先确定这是不是他发布的，要是都不是他发布，那肯定没法编辑。

说话人 1 00:44:36
getuserbyid， 但是他提供这个 message ID 可能是无效的，也就是说数据库里根本就没有这个 message ID， 所以我们需要对它进行判空，假如它是 null 的话，那么就要抛出，诶，抛出异常，就是说这个请求是。请求的资源是不存在，而他不是，但是他的这个选出来这个请求的发布者和我们这个请求编辑的用户 ID 他又不是一样的，证明这人想编辑其他人发布的留言，点 equals user ID， 这个 user ID 是我们这个请求的人的 user ID， 然后 publish ID 是我们这条。留言的发布者的 ID， 他们可能是一样的，也可能不是一样的。假如说有人想编辑其他人发布的留言，那我们就可以抛出违法操作的异常，这些异常都是会被全局异常处理器捕获，然后按照我们的返回模板给前端返回。

说话人 1 00:46:10
这个我们尽量写清楚一点，这样如果排查问题的话，也好排查能运行到这里说明这条 message ID 肯定是真实的，肯定是有。并且发布者确也是请求的这个用户 ID。请求这个用户，那么我们就可以进行更新了，可以看到这有参数提示，第一个是 message ID， 第二是 category， 第三个是 content， 我们把它传进去就行，我们再来看 delete 方法还是像之前那样，我们肯定是先给筛出来筛选，首先我们用 getuserbyid 先把 message ID 传进去，假如说这个 publisher 为 null， 说明这个 message ID 根本就是无效的，根本就数据库里就没有这条留言。就会抛出 not found exception， 然后就会返回404。

说话人 1 00:47:33
假如说它这个 publisher ID 和请求这个 user ID 它不是一个，说明有人在想删除别人发布的留言，我们可以抛出 illegal operation exception， 这个时候评论区处理器捕获以后就会返回403，我们来改一下，但是这个时候还没完，因为我们不仅要删除这个留言，删除留言的时候还会连带把所这个留言下面所有的评论也删除。

说话人 1 00:48:12
那么还需要 commentmapper， 把 commentmapper 装配进来，我们需要调用它的 delete batch 这个方法我们还没写呢，这个等到我们 comment 那里边再写，我先把它注释掉，这个方法就是说我们不仅要删除 message， 我们还要删除。它下面所属的所有 comment， 现在我们这个编辑留言和删除留言就都写完了。

说话人 1 00:49:07
我们来写一下查看留言列表这个接口，我们看一下这个留言列表，它是用 get 方法，然后 URL 是 messages。它比较复杂一点，就是它需要有一个分页，这 current 是当前页码，然后 page size 是一页显示多少条，那返回的响应也是比较复杂的，它里边套了一层分页的返回模板，然后在 list 里面选出来的是留言的 VO。我们来到项目里面，首先看它的方法，它是 get 方法，我们要用 get Mapping。再给他的 URL 它是 messages， 而我们这个 messages 已经写到这些类的路径上面了，所以我们这个 get mapping 后边什么都不用写，看一下他要返回的东西，他在返回的是一个分页的返回模板，我们去把返回模板给粘过来。

说话人 1 00:50:26
在 VO 里面 page result 粘到这里面，这个 total 是一共多少条符合要求？不是这个 list 的长度， total 通常是要比这个 list 的长度要大的，然后 Pre 是上页 next 下页，然后这个 list 是个装数据的列表，这个 t 就是指定这个 list 里边装的是什么类型的。我们。返回的就是 page result， 我们要返回的是留言示例对象，但我们还没有这个类，我们把它复制过来，我们来看一下这个对象，它有 message ID， 然后 user ID、 nickname、 category content， 然后 comment name， 看一下这个文档，发现它们是一样的， message ID， user ID， nickname， 然后 category， 然后 content， comment name。

说话人 1 00:51:39
这个 comment VO 其实就是和这个接口文档里的这个数据模型里的留言的这个视图对象，它是一个东西，我们要返回的就是用分页和模板封装的这个 message VO。

说话人 1 00:52:14
怎么有个报错？看一下无法解析符号，我们把 common VO 也粘进来，粘到这个 VO 里面， VO 就是显示给前端的，那就不报错了，这个可以按照不同的条件来查询，所以我就给它起名叫 search。

说话人 1 00:52:52
从接口文档里边看一下这个接口要提供哪些参数，发现它提供的参数都是 query 参数，这 query 4个 query 参数，我本来是可以把它们放在一个类里面写完的，但是我觉得这个 current 和 page size 很有可能以后可以复用，所以把这个 current 和 page size 单独用了一个类封装。

说话人 1 00:53:24
在这个 params 里面用到了分页 pagingparams， 我是把它单独用一个 params 来封装了这个分页的这两个参数，一个是 carry 一个 page size， 剩下的就是搜索用的，那剩下两个参数，一个 category， 然后一个 user ID， 我把它也粘过来，我们来看一下这两个参数，这个是分页参数。

说话人 1 00:53:58
分页参数，我是用注解限制一下它最小值，还有这个 query 有最小是一，然后 page size 我限制了最小是一，最大是100，但是我没有用 non null， 就是说前端你不传的话也是可以的，如果前端不传，虽然我用这个 min 和 Max 限制了，但是它传进来填进来是为 null 的话，它也是符合要求的。为了防止前端不传，我这里边设置了默认值。

说话人 1 00:54:29
我们再看一下这个 category， 我也设置了最小是0，最大是4，以及 user ID， 它最小是1。因为负数的 userid 显然是没有意义的，我就给他设置了最小是一，既然它用的是 query 参数，那我们用什么注解接收呢？一般来说， query 参数是用 requestparam 注解，但是我们这是自定义的类是它是不能用 requestparam 注解的，所以我们只能直接用这个类名，然后，诶哪去了？直接用这个类名。

说话人 1 00:55:15
引进去，还有然后再加一个 wally 的注解， requestparam 注解虽然是提取 query 参数了，但它只能应用于。像 string integer 这种简单的类，我们这个 searchmessageparams 和这个 pageparams 都是我们自定义的类，这种是不能加 requestparams 注解的，就什么都不加就可以了。我们为了启动参数校验，我们还加了一个 value 的注解，这个接受参数就这样就写完了。我们 return 一下 message service 点这个名，这个我们需要给它。告诉他种类，还有告诉他 USEID， 虽然这个种类和 USEID 都是可以为，那告诉他当前的页数，还有告诉他单页多少条，我们鼠标放上来，让他帮我们创建方法，我们到时间类里面。让它帮我们生成实现方法。

说话人 1 00:57:00
这个图标就是 AOP 帮我们增强了的意思，可以看到我们这个 test 方法已经被 AOP 增强了，我们会给这个方法执行前后打印日志，还有自动运行推断，它可以帮我们填写这些方法的签名，就不用我们写了，这要分页，所以我们需要引入新的依赖。虽然你不用引入这个依赖也可以，那就直接在这个 SQL 语句里边硬编码，就是写 offset 多少， limit 多少，但是这样的话比较麻烦，如果你以后遇到很多要分页的东西的话，你就每个 SQL 都要写一个 offset limit， 这就太麻烦了。

说话人 1 00:57:52
我们引入了一个分页插件，我们把它复制过来，来到我们这个新项目的 POM 点 XML 里面粘进来。现在还没有，因为我们还没有加载它的变更，我们点一下加载变更，现在它就有了。我们引进来之后，我们到这个配置文件，我们把它这个一粘也粘进来，这个是配置分页插件的一个配置粘进来，现在我们这个分页插件也已经搞完了。其实这个分析开点非常。简单，你直接用 page helper， 然后导进来这个类，点 start page， start page 第一个可以传 pagenum， 第二个传 pagesize。我们选用这个方法，就是两参数，这个方法第一个我们传 current， 这个我们传 pagesize。然后我们需要去写一个获得 getlist 的方法，在这个 messagemapper 里面，我去那里边粘进来，在 messagemapper 找一下 Mapper 在哪，这粘到这里面，然后我们 generate statement。

说话人 1 01:00:05
它返回的是这个 message VO， 但是我不建议用 result type， 因为用 result type 的话，它是因为有数据库字段和实体类名不一样，导致它的有些字段要绑定为 NULL， 所以我们要用 result map， 能往前翻一下看到 result map。我们用这个 resultmap 都是写到这个 XML 的开头的位置，这个 resultmap 我指定了 type， 就是我们要的这个 messagevo， 这个 resultmap 的名字叫做 messageabstractresultmap， ID 是指数据库里的主键， result 是指数据库里非主键字段。property 是指实体类的字段名，而 column 是数据库里的字段名，这样我们就把数据库里的字段。与实体类的字段完成一个映射，这里我们就不要写 result type 了，我们这里直接指定 result map， 指定 result map 写我们刚才的这个 result map 的名字，也就是 result map 的 ID， 我们把 SQL 语句也粘进来。

说话人 1 01:01:34
诶，是这个。

说话人 1 01:01:43
这个 left join user， 就是我们因为要获取 user 表中的 nickname， 所以我们把两表进行一个连接。where 条件，这用了动态 SQL， 如果 category 不等于 NULL 的话，我们才会在后面拼上 where。如果 userid 不等于 NULL 的话，它会到后面拼上 userid， 一会它会控制它会打印这个 SQL。

说话人 1 01:02:06
然后我们去机构测试工具来看一下，如果我们这 category 不填或者 userid 不填，它执行的 SQL 语句是什么样的，你们就知道这个。where 和 if 是做什么的了？这个 order by message ID DSC 就是按照 message ID 逆序排序，因为我想做的是最新发布的，它展示在最前面，你当然可以用 order by create time DSC， 但是那样的话不如 order by message ID 好，因为 message ID 它是一个主键，它主键是自带有索引的。如果你用 order by create time 的话，你还得再给 create time 加一个索引，那就没有，我觉得没有这个必要，所以我直接用 message ID。

说话人 1 01:02:55
来进行排序，因为 message ID 它也是根据 create time 的增加而增加的，我们回到之前的 service impl， 这里面我们需要注意的是我们这个 get list 它是没有写 limit 和 offset 的，那它是怎么分页的呢？就是我们根据这个分页插件，它帮我们分页的，它会拦截这个 SQL 执行，然后在后边加上把 SQL 改写。这样我们不用写 offset 和 limit， 它也可以帮我们完成 offset 和 limit 功能。这个方法返回的是一个 list， message vo， 导一下这个类用的是 message mapper， 点 get list。第一个是 category， 第二个是 user ID， 我们创建一个 pageinfo， pageinfo 是一个很好用的一个工具，它可以把我们返回来这个 list 传到 pageinfo 以后，它可以帮我们计算出很多我们需要的参数。我一会演示一下，我们创建一个 pageinfo， 倒进来一下这个类导入。

说话人 1 01:04:34
等于 new 一个 pageinfo， 在这个 pageinfo 的构造函数里面，我们把这个 list 传进来，现在我们准备这个生成这个返回的结果了，我们首先 new 一个 pageResult， 这 pageResult 是在 VO 那个包下面的，给前端的一个分页后的返回模板，里面有4个属性，我们来分别设置一下这四个属性。首先设置一下 total 的属性， set total。我们把 shares 这个 list 传到了 pageinfo 里面，我们可以用 pageinfo 直接得出我们需要的一些分页之后的结果，比如 pageinfo 点 gettotal， 我们还继续设置一下它的前一页 pageinfo 它提供了是否有前页，我们可以用 is has previous page 来判断它是否有前页，如果它有前页的话，那么就返回它的前一页。

说话人 1 01:05:57
如它没有前页的话，那么就返回-1，我们现在来设置 page result 的下一页，我们可以用 page infer 的是否有下页的方法来判断它是否有下页，如果它有下页的话，我们就可以返回这个下页，如果它没有下页。页的话我们就返回-1，最后我们把 list 设置到 pageinfo 里， page result 里面，这个 page result 就是我们要返回给前端的分页返回的模板，最后 return result， 这个方法我们就写完了，我们首先用 page helper start page 开启分页功能，然后传回来了这个 message。list message vo， 接着我们是用把这个 list 传到了这个 pageinfo 里面，然后用 pageinfo 获取了我们需要的一些信息，包括它的总数，是否有前页，是否有后页。

说话人 1 01:07:25
最后我们把这个 list 设置到这个 result 的 set list 里面，然后返回这个 list， 返回这个 result， 我们来看一下这个方法执行之后是什么样的，我们来启动一下。

说话人 1 01:07:55
我们到接口测试工具里面点击运行这个接口，我想的是只有用户权的人才可以访问，所以这里边加一个 Pre authorize。只有用户权限的人才可以访问我们，到这里面把我们之前的 TOKEN 复制一下，我们什么都不填，看一下它返回去的参数是什么样的。

说话人 1 01:08:58
重点看控台打印的这个 SQL 语句，第一个 select， 这是查出了它的总条数。第二句 select， 我们明明没有写查询两条 SQL 语句，它就执行了两条，这意味着我们使用了分页插件，分页插件会先帮我们 select 一下它的总条数，然后如果总条数不等于0的话，就是大于0的话，它再去帮我们查出实际的数据。所以分页插件帮我们省了很多事儿。

说话人 1 01:09:35
分页插件还有一个功能，就是如果确定查出来的条数为0的话，它就不会再去查询第二次，就不会再进行第二次查询，把里边数据查出来了。我们看一下现在执行的第一次 select 它的条数，发现总条数是0，于是。他就没有再查询我们第二个 SQL 语句，也就没有去 getlist 把它具体是什么查出来了，就相当于减少了数据库的负担，在我们这四个参数都不写的情况下，他执行的语句是，我看一下。

说话人 1 01:10:32
order by， 然后 join us on， 然后后面就直接跟着 order by 了，没有带 where 条件，我们再来开启一个，假如 category 限制一下，这个时候他带了一个 where 条件，他筛选了这个 t m 点 category， 我们把它关上，然后把 user ID 开上看一下。

说话人 1 01:11:12
这个时候它也带了一个 where 条件，它是按照 user ID 进行筛选，我们把两个都开上，可以发现这时候它带了两个 where 条件，它既要求 category， 也要求 user ID， 我们看一下 Mapper， 这是因为我们判断了如果 category 不等于 NULL， 我们才会在后边拼接 where category 等于多少。

说话人 1 01:11:46
如果 userid 不等于为 null， 我们还在后边拼接这个 userid 是多少？我们再来测试一下 current 和 page size， 如果我们什么都不发，那么控制台打印出来的，我们看一下它的入参，就是一和10，第一页10条，如果我们把 current 改一下。

说话人 1 01:12:22
改成2，这个时候它打出来就是2和10，第二页一页10条，我们刚才写完了查看留言列表这个接口，我们现在写一下查看留言详情页和查看留言列表不同，我们在查看留言详情页的时候，我们需要把这个 comment list 也显示出来，就包括这个留言下边有哪些评论。

说话人 1 01:12:54
我们现在开始写，首先这是一个 get 方法，用 get 方法肯定是要用 get mapping， 因为它是 get 方法，所以就用 get mapping， 看一下 URL， 这后边有一个 messages 或者跟了一个 path 参数，这是 messages ID， 但是这个 messages 我们就写在这个类上面了，所以我们后边只用写 messages ID 就够了，我们可以把它复制过来。后边跟一个斜线，然后大括号里面有个 message ID。返回值是一个 message VO 方法名，我就要叫它 getdetails 了，我们需要把这个 path 参数提取出来。

说话人 1 01:13:44
提取这个 path 参数，我们用的是 pathvariable 这个注解，把它提出来，还有参数吗？我看一下它就只有一个这个参数。需要我们提出来，其他的参数我们都用不到，然后我们 return 一个 use message service 的 getdetails 方法，这个方法我们还没有写，我们传进去的就是它的这个 message ID， 我们让它生成一下，生成，然后我们来到它的这个实现类里面，我们点击实现方法，点击确定。

说话人 1 01:14:39
现在我们到了它的实现类，我们肯定是需要从数据库里面。拿出 messagevo 用的就是 messageMapper， messageMapper 是专门操作 message 这张数据库表的，我们用 getvoByid 方的方法拿出这个 messagevo， 传进的参数是 messageid， 当然他给的这个 messageid 可能是无效的，这样的话他这个选出来的 messagevo 就会为 null， 我们要进行一个判空，如果 messagevo 为 null 的话，那么就会抛出异常说这个找不到。然后就会在全局异常处理器里给前端返回404，如果运行到这里设为说明这个 messagevo 不为，我们就可以给前端返回这个 messagevo， 我们这个 getvo by ID 方法还爆红，因为我们还没有写这个方法。

说话人 1 01:15:55
我们来写一下，我们。这有个 generate statement， 我们 generate 一下，这回我们去这个项目里面与原来的项目有一个 result map， 我们把它复制过来，这个 result map 和之前的 result map 有一些区别，我们来重点关注一下。诶，粘错了，我应该粘上面这个。

说话人 1 01:16:39
首先它这个名字不一样，这是肯定的，它这个种类是一样的，因为我们返回的 type 都是这个 message vo， message vo 长这样，我们看一下这是留言视图对象，它最后有一个 list 是 comment VO 类型的 list， 它名字叫 comment list。

说话人 1 01:16:57
那为什么两个这个 result map 不一样呢？关键就在于这多了一个叫 collection， 前面这些它们是一样的，但是它多了一个 collection， 这个 collection 的作用就是如果我们返回的 result map。里边有 collection 的时候，它会帮我们再去执行一条 SQL 语句，执行 SQL 语句的名字就在于这，在这个 commentmapper 点 listvoBymessageid， 但是我们这个方法还没有写，我们把它复制一下到这个 commentmapper 里面，我去那个项目里复制，我们来到。

说话人 1 01:17:45
完整的项目能找到 commentmapper 这个方法我们复制一下粘过来，它这个还在爆红，我们 generate statement， 我们来到另一个项目里面跳转，把它这一复制，然后粘过来，我们看一下这个 SQL 语句是干什么？这个语句就是从这个 comment 表里面选出 comment ID， 然后 message ID， 然后 nickname content 这些内容。然后和这个 user 表进行连接，按照这个 where 是按照 message ID 进行筛选，我们传回去的也是一个 message ID， 它的意思就是说我们会选择属于这个 message ID 的所有 comment， 说白了就是获取指定留言下面的所有评论，这个 result map 还没有，因为它在爆红，我们把那个 result map 也复制过来。

说话人 1 01:19:12
一个 result map 就是进行数据库字段和我们实体类字段的一个映射的 comment VO 就是这个，我们的评论实例对象里边有 comment ID、 message ID、 floor、 user ID 这些。我们 commentmapper 接口和 XML 我们都写完了，我们新增了一个叫做 listviewbymessageid 方法，并且在这个 commentmapper 点 XML 里边写出来，它怎么实现？这就是它的实现。

说话人 1 01:19:47
后边用 order by comment ID desc 就是指我想按照最新发布排在前面，我不用 order by create time desc 意思就是如果我要用 order by create time 的话，我还得在 create time 再加条索引，但是你这个主键它就是按照晚来的晚发的它主键就大，所以我们完全可以用按照主键排序。可以达到和按照归 time 排序一样的效果，而且主键它自带索引，我们还不用额外建立个索引，所以我选择的是选择是按照 comment ID 进行逆序排序。

说话人 1 01:20:27
collection 这个 property 和前面 property 一样，就是写的是这个 type 的，也就是我们这个 message VO 的字段对应的这里就是 comment list。我们看下 select 语句，指的是写了一个全类名里的一个方法，这里写的是 commentmapper 的 list Web message ID 指定了一个方法，其实准确的说它不仅指定一个方法，更是指定了这个方法对应的 SQL 语句是什么？column 指的是数据库的列名，不是说数据库的列名，这给它传进去的这个参数名。我们看一下，咦，哪去了？

说话人 1 01:21:30
message map 站这个 column 意思就是说我们按照前面就是诶那个语句，我们把它粘进来，我再讲这个叫做 get view by ID。get vo 在下面这个 column 指的是我们这个 SQL 语句的返回的哪一列作为这个 select 传进去的参数。

说话人 1 01:22:27
我们看一下这条 SQL 语句，它会返回 message ID， 然后 user ID、 nickname content comment name、 create time， 还有与 user 表连接后，这个 nickname 其实就是 user 表里的 nickname， 它有这么多列会返回，而这个 column 指的是我们把返回中的哪一列作为 select 语句传进去的参数，我们就是会把返回的。

说话人 1 01:22:58
message id。作为这条 select 语句程序的参数，也就是这个 long message ID， 我们把这个作为参数，以后这一条 list view by message ID 会拿我们刚才传进来的 message ID 作为参数，用在这 where 条件里进行筛选，这样我们就可以找到这条留言下面所有的评论。

说话人 1 01:23:33
所以说这个 result map 虽有 collection， 看上去是一个 result map， 实际上它是做了两步查询，第一步查询是先执行。这条 select 语句，然后绑定到了这些值上面。第二步，拿返回值里面的 message ID 作为参数去执行这条语句，然后把这个语句的返回值绑定到了 comment list 上面，所以它是两步查询这个 comment list， 它是一个列表，所以看到我们可以用 collection。

说话人 1 01:24:16
来做到别的表证多，对到这张事例类，这个事例类中的一，这就是 Mybatis 支持一对多的查询。其实 Mybatis 还支持 Mybatis， 它还有很多其他的用法，这个就是你们可以看网上的视频来学习，我这里就不细讲了，因为细讲的话估计可能要讲很久。

说话人 1 01:24:41
我们这个 getviewbyid 已经写完了，虽然里面没有涉及到 comment 表的查询，但是我们用这个 collection。让它并且指定了 select 语句，所以在我们返回 result map 的时候，它会帮我们去执行 comment 表中的查询，我们试一下效果就知道是什么样的结果了。我们在这个 message map 里没有写 comment 表相关查询，它也是可以返回我们 comment 表中的信息的。

说话人 1 01:25:15
我们在 message 表里面 d message ID 等于9，那我们在这里边添加一条。应该两条 message ID 等于9 generate， 表示它会主键自增，帮我们自动生成。default 表示它设置了默认值，会帮我们自动填充提交。我们运行一下这个项目，把这个 TOKEN 复制一下运行。

说话人 1 01:26:49
param 指定 message ID， 我们要看的 message ID 它是多少来着？它是9，我们指定9，点击发送，我们看一下它返回的 message 9 user ID nickname。然后这边 comment list 返回了它下面的两条评论。

说话人 1 01:27:25
测试2测试一，它这个排序方式是最新发布的，排在前，如果你不喜欢这种排，你可以自己设置你的 order by 的排序。这个 nickname 当然不是我们的 message 表里存的，它是用这个表连接从这个 user 表里边拿的。这个 nickname 也是这个 nickname 也不是我们这个 comment 表存的。这是通过表连接，从这个 user 表里面拿的，我们来看一下控制台的 SQL 语句，你们就对这个执行过程有更好的了解。

说话人 1 01:27:59
这个是请求进来入参是9，看两个箭头，第一个箭头，然后，哎哪去了啊？第二个箭头 select， 这是一条语句，这个是找出 message ID 相关的， message 相关的东西，它不涉及 comment。来看第二条语句。select 这个是从 comment 表里找，重点看这个 from t message， 这把 message 表里相关信息选了出来，然后看这个 from from t comment， 这是从 t comment 表里面选了出来，我们 comment 几条，然后绑定到我们这个例子上面，一个例子承接了多条 comment， 我们到那个 messageMapper 里面。

说话人 1 01:29:01
这个里面是写了 from t message， 我们在 collection 里面指定了 from t comment， 于是我们用这，诶用这一个方法就执行了两条 SQL 语句，这样我们的查看留言详情页的接口，留言里面我们把发表编辑删除，查看列表和查看详情页已经写完了，我们现在写一下举报留言。

说话人 1 01:29:42
我们来到这个 Controller 里面，我们看一下文档，它这个是 post 请求， post 请求，我们肯定是要用 post mapping 来写 post mapping， 我们看一下 URL， 它这个是 messages， 然后 message ID， 然后 report 其中的 message ID 是一个 path 参数，而这个 messages 已经写到这个类上的 request mapping 里面了，所以我们直接在后边从 message ID 开始写 message ID 这个 path 参数我们用大括号括起来。最后跟上 report， 我们会把这个 message ID 拼到这个 request mapping 上面，这个是没有有效的返回值的。

说话人 1 01:30:34
什么返回？void 方法名我们就写 report， 我们需要用 pathvariable 注解把它提出来。由于只有用户才能举报，所以我们给加上一个 Pre authorize， 再限定一下，只有拥有用户角色的用户才可以举报，我们用 authentication principle 提取出当前发请求的用户是谁，我们再看一下接口文档，它这个里面有一个 body 参数，对于 body 参数我们需要建一个类来接收。

说话人 1 01:31:25
我们来到这个 param 里面，我们新建一个类，这个类就叫做 reportparam， 上来先用 add data 注解，让它帮我们生成 get 和 set， 我们看一下这个文档里的这个 body 参数只有一个 reason， 它是一个 string， 我们也写 string， 然后 reason 别忘了加上注解来进行参数校验，这 string 就用 not blank 注解表示它不能为 null， 不能为空串，也不能全是空格。理由不能为空，当然这个限制还不够，我们再用 lens 限制一下。

说话人 1 01:32:20
lens 可以写 min， 可以写 Max， 我们看一下数据库是怎么设计的。我们来到举报表展开这个列，看这个 reason， 它是 VARCHAR 255，我们这个就写一个 MAX 2等于255，让它不要超过255。字 message 也是写一下，现在我们这个接收 body 参数的这个 report param 也写完了，它放在这个 param 包下面的，我们把它先关掉，它是放在 body 里面的，所以我们用 request body 这个注解去接收它。别忘了加上注解来进行参数校验，我们调用方法进行举报，我们要提供他的 user ID。还有从 Paas 参数从用 passvariable 注解提取出来的 message ID。还有他的举报理由给 report 方法我们还没写，所以它爆红，我们生成一下，找到它的实现类，我们找到这的实现方法，点一下，点击确定会帮我们生成一个 report 方法。

说话人 1 01:34:12
首先我们是要判断这个 message ID 它到底是不是存在的。我可以用查看它的 publisher ID。用 messageMapper 点 get userid byid， 然后 messageid， 假如说这个 messageid 根本就不存在，那么它返回的这个 userid， 也就是这个 publishid 肯定是 null， 我们就需要进行一个判空，如果这个 publishid 是 null 的话，那说明前端提供的这个 messageid 是无效的，不存在这样一条 messageid。

说话人 1 01:35:11
假如说这个 publish ID 是存在的，也就是说存在这样一个一条留言，我们还需要判断这个留言它是不是自己发的，这 user ID 是这个请求的，这个发请求这个人的 ID， 然后 publish ID 是这个 message ID 对应的留言的发布者 ID， 假如它们俩相等的话，就是说这个人在举报自己的。

说话人 1 01:35:44
留言这个是非法的，他要举报的话，为什么不直接删了呢？我们就可以抛出 illegal operation exception， 这些异常都会被全局异常处理器捕获，对于 not found exception 被捕获以后会给前端返回404，而 illegal operation exception 被全局异常处理器捕获以后会返回给前端403。

说话人 1 01:36:37
运行到这里，说明这条留言存在，而且是自己发的，但是有可能用户已经举报过了，我们不想让用户反复举报同一条留言，这个时候我们需要用到 reportmapper， 因为我们需要操作 report 这张表。我们需要在里边，我直接复制了，找到 reportmapper， 我们把这两条方法粘过来，这个 insert 就是往举报表里插入一条举报，而这个 count 就是统计。

说话人 1 01:37:43
目标举报目标是否已经被这个用户举报过一遍了？把这个 XML 我们也复制过来，来到这个 member 的 XML， 我们看下这个 insert， 它就是往这个 report 表里面插入了 report type， 它是 ID reason 和 user ID， 然后 count 就是。在这 report 里边，按照指定的目标就是指定一条留言或者评论。看看这个用户是否已经举报过一遍了，我们用 reportmapper 点 count 第一个选择的是举报类型，我们有一个枚举，就是专门存这个举报类型的，我们直接用枚举，我们这个是一个 message service， 所以它举报肯定是 message。我们要写他的举报目标的 ID， 这个就是 message ID， 还有是谁举报，是 user ID 就可以看到是谁举报。

说话人 1 01:39:10
我们首先需要看他是否已经举报过一遍了，如果举报过一遍的话，我们就不能让再让他再举报了，反复举报没有意义，这样你会给数据库里存入大量重复的数据，如果 count 大于0，说明他已经举报过了。这个 log 标红是因为我们没有在这个类上加上SLF4J的注解，把这个注解一加。你就可以用 log 打印我们的日志了，现在它就爆红了。这个用 war 感觉更合适一些，后边我。这个大括号就是我们这个日志的占位符，我们需要在后边把它写上，如果他看了大于0，那举报过一遍，我们就要抛出一个异常，抛出异常以后后面语句不会再被执行。

说话人 1 01:40:46
我设计的这个业务状态码也就只有几种，如果你觉得有必要的话，你可以再添加几种。

说话人 1 01:40:58
到这里说明看了等于0，说明之前没有举报过，我们就可以插入了。首先插入的是举报类型，我们这个是 message service， 所以他肯定举报的是 message。第二个是 target ID， 我们这里是 message ID。第三个让你写原因，我们这是 reason， 第四个让你写，谁举报的，我们这是 user ID， 这里看就写完了。但是这有个隐含的问题，就是如果用户同连着点了两次举报，可能会发生第一个线程，这里 count 了一下。发现这个用户没有举报过，运行到了这里即将插入，然后第二个线程也用 count 算了一下，发现这个用户没有举报，也准备插入，然后线程一插入了一条举报，线程2也插入一条举报，于是这个举报表里就出现两条一样的数据，这个不是我们想看到的，于是我们可以通过。

说话人 1 01:42:00
加独立索引来解决，我们找到举报表，我们来右键修改一下，加一条索引列，我们就选择我看一下这个表是怎么建的，再加 target ID、 user ID 和 report type。我们来加一下更改表， target ID user ID， order time 要排序我就写一下，我就写 ASC， 这个唯一肯定是要勾上的，我们需要用它的唯一索引。这个列的顺序非常重要。为什么非常重要呢？因为这个索引列的顺序会直接影响你查询的效率，我们会把选择性最好的列放在前面，像 target ID 和 user ID 它们选择性都不错。而 report type 它就有两种，就只有0和一，所以它的选择性非常差，我们把选择性差的放在后面，而 target ID 和 user ID 选择性都好，那到底是把哪个放第一，把哪个放第二个？这就得看我们。

说话人 1 01:43:47
用 where 条件是怎么样的了？把 target 放第一个，把 user ID 放第二个。根据索引的最左匹配原则，你在用 where target ID 等于时候是可以用到索引的。你在用 where target ID 等于 and user ID 等于的时候也可以用到索引的。在你用 target ID 等于， user ID 等于 report type 等于时候，也可以用到索引，这是根据索引的最左匹配原则。

说话人 1 01:44:12
我们看一下，我们先执行，因为它已经执行完了，加了条独立索引。我们去 report mapper 里面看一下。它这里面需要用到这个根据，看一下，根据 target ID 进行删除，因为这个方法我们要用到指定一个 target ID， 我们来看一下我们家的索引，而我们 target ID 正是放在第一个的，所以我们可以用到这个索引。假如你把 user ID 放到第一个，像刚才那种 where target ID 等于多少就用不到这个索引了。

说话人 1 01:45:20
既然建完唯一索引以后，出现刚才那种并发情况，就是两个线程同时往数据库里插入重复数据的时候，这时候它就会抛出 duplicate key exception， 我们捕获一下 try catch， 然后 catch 里面就写 duplicate key， 这个时候就是重复操作一个用户举报两次同一个目标。这个我们也可以直接粘过来，那我们这个方法就写完了。

说话人 1 01:46:15
我们来运行一下，我们找到我们之前的 TOKEN， 拿复制一下，我们看一下 message 表里边有哪些？一共有两条，一个是 message ID 是9，一个 message ID 是10。那我们就先举报 message ID 为9的吧。我们点击运行 header 里边 authorization， 放上我们刚才已经获得的 TOKEN param part 参数，我们写一下，我们先写8，试一下 body， 写一下，我们发送他说请求资源不存在，因为8确实没有。我们现在请求9，我们要举报 message ID 为9的留言操作非法。嗯，我看一眼是怎么回事。哦，他是在举报自己的留言，那我们把 message 这条 userid 我们给改一下，那我们就说这是16发的，更新一下，我们重新来一遍，现在就操作成功了，我们来数据库里看一眼，发现他多了一条举报，其中 report type 是0，说明举报的是留言，他这 ID 是9，说明我们举报的留言 ID 是9 reason 写了举报理由。

说话人 1 01:48:16
user ID 写的是谁在举报？create time 和 update time 是由数据库自动帮我们填充的，我们重复举报一遍，这个时候会说重复操作，我们看下控制台，这个时候点一下这个蓝字，可以跳转到是在哪里抛出了异常，因为 count 大于0，所以在这里抛出了异常，我们看一下数据库里它有没有插入重复数据，刷新发现它只有一条数据，它并没有把一个用户对同一个目标的重复举报插入到数据库里去，这样我们的举报接口也写。