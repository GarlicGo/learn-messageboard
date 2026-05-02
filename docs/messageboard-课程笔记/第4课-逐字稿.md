会议主题：1-后端培训项目 留言板 讲解（4）-480P 标清-AVC
上传时间：2026年3月31日（周二） 02:23 （GMT+08）
智能纪要：1-后端培训项目 留言板 讲解（4）-480P 标清-AVC 2026年3月31日

说话人 1 00:00:01
我们来讲一下 JWT， 这是 JWT 使用的一幅张图示，首先用户在登录的时候会把他的用户名密码给服务器，然后服务器会验证他用户名和密码返回 JWT， 然后用户带上这 JWT， 然后再访问接口，然后接口会从 JWT 中提用户信息，就知道用户是谁了，然后响应这处理这个请求，然后把响应写回用户。

说话人 1 00:00:35
这是 JWT 的数据结构，它有三部分，第一个是 header 部分，第二个是 payload 部分，第三部分是 Signature 部分，中间是用点隔开，就两个点，然后有三部分 header 部分描述了是它的这个算法。payload 部分， payload 就装载了我们要保存的一些信息，我们可以在 payload 里面自己写一些我们要写到 JWT 里的信息，然后 Signature 写的是。指定的签名，它是通过前两部分通过加密算法算出来的一个 secret 密码 header 里面指定了算法，然后 secret 就是密码是存在服务器的，它会把前两部分进行，按照这个算法使用这个密码进行加密，加密完以后得出来这块字符串，就是第三部分的 Signature。

说话人 1 00:01:47
我们来看一下示范项目里边的 JWT 的工具类，我们把它复制过来，工具类我们是放在 util 包下面，我们新建一个叫做 util 包，然后粘进来，这是 JWT util 要想使用 JWT 对我们得先引入一下 JWT 的依赖，我们到 POM 点 XML 里面看一下 JWT 的依赖，对，这个就是。把它复制一下到我们这个项目里面，这个 POM 点 XML 粘进来，我们可以看到目前只有这几个依赖，我们来加载一下变更，这发现它多了一个叫做 java 杠 JWT 的依赖，这个就是我们要的 JWT 的依赖。

说话人 1 00:02:53
我们看一下，现在它就不爆红了，说明它已经找到相应的类了，这是一个 JWT 的工具类，我用 atvalue 注解，从配置文件里面读取了它的 secret 和 expiration， 因为它是从配置文件里面读取的，所以我们也在配置文件里面写一下。我们来到这个 application 点 yml， 把它也复制过来，粘到我们这个 application 点 yml 里面。粘过来。那我们可以看它能定位到这个 expiration， 也能定位到7，按住 Ctrl 鼠标放上去，它可以显示出来它这个 value 装配的值是什么？这个都是我们配置文件里面写的这个 expiration， 它是以天为单位，这里边有两个方法，我们看一下这里边的结构，这有两个字段，然后两个方法。这个 logger 是用 SLF 4J来装配的，它是它在这个代码里没有，但是它编译期会编译的时候会有。

说话人 1 00:04:19
我们重点关注这个 get TOKEN from user 和 get user from token 这两个方法。前面这个方法是根据 user 信息生成 TOKEN， 后边这个方法是根据 TOKEN 还原回 user 的信息，我们到测试类里去试验一下，我们看测试类是在 test 里面这个类。先把它删干净，我们来装配一个 jwtutil， 现在它可以找到我们这个 jwtutil。这我们。先创建一个新用户，然后往用户里面写一些内容，例如 set ID 叫做456，然后 set 一下 row 是0，我们把它 user 用 JWT util 把它转化成 TOKEN。

说话人 1 00:06:15
加上 test， 现在它就可以运行了。我们来看一下，我们往 user 里边设一个 ID 是456，然后是一个 row 是0，看一下它 JWT 是什么样子的？

说话人 1 00:06:47
它是这个东西，我们把它复制出来。我们先看一下他是不是说了三段式，这是一个点，然后我们看这是两个点，可以看出他两个点分成了三段，这叫第一段，然后这个叫第二段，这个叫做第三段，这也是对应了这个是 header， 这个是 payload， 然后这个是 Signature 三部分，我们把它复制出来，可以看出这个是完全一串密文，我们都看不懂。我们现在要测试能不能把它还原出来，今天换成 string 粘进来，这很长一段，我们用 jwtutil， 这次我们是 getuserfromtoken 传进去的，是个 TOKEN 会给我们还原一个 user。

说话人 1 00:08:05
我们把它 userid 打出来，同时我们要把它的 row 也打出来，我们看一下这个 TOKEN 是我们刚才用工具类得到的密码。我们现在把它用 getuserfromtoken 方式把它还原成 user， 看一下它能不能拿出我们之前摄入的设定的信息。

说话人 1 00:08:45
可以看到 userid 是456， role 是0，这就是我们之前设定的信息，这就是这个工具类的使用，我们在使用的时候用 autowired。把它装配进来，我们用这个方法 gettokenfromuser， 可以把 user 转换成一串 string， 然后我们可以用 getuserfromtoken 可以把 string 变成 user， 这就是这个工具类两个很重要的方，我们密码肯定是不能明文放在数据库里的，所以我们会对密码进行加密。

说话人 1 00:09:20
springsecurity 已经为我们提供了现成的加密的工具类，我们需要引入 springsecurity 的依赖，我们来到之前注释掉的。这里把它取消，注释这个 spring boot STARTER security 就是 spring security 的依赖，我们加载这个 Maven 变更，发现它多了一个就是 spring security 的依赖，看这个就是 spring security 有一个很重要的接口，就是 passwordencoder， 我们来看一下这个接口， passwordencoder。然后点进去，这里面有两个重要的方法，一个叫做 encode， 一个叫做 matches， 这个 encode 就是给我们一个加密前的密码，然后他会给你一个加密后的密码，然后这个 matches 会给你一个加密前的密码，还有一个加密后的密码，然后会判断它们是否匹配。

说话人 1 00:10:27
在注册接口中，我们是用这个 encode 方法把原先没有加密的密码加密后。把密文存进数据库，而 matches 是 spring security， 会帮我们调用 matches 方法，它会把我们从前端传过来的密码以及数据库里加密后的密码进行一个对比。如果两者是一样的，那就返回 true， 如果不一样，就会返回 false。它不会把密码再还原成之前的原文密码，而是把原文加密之后和我们的密文进行对比，这种加密是单向的，它是不可逆的。

说话人 1 00:11:03
我们来看一下这个 passwordencoder 这个接口，它有很多实现类，看有多少这么多都是实现这个接口。像 i script。然后像 lazypassword， 然后像 bcrypt， 然后这些我们这个项目选用的是 bcryptpasswordencoder， 它是这个实现类实现了这个接口，也就是说这个 bcryptpassing passwordencoder 提供了这个 encode 功能，也提供了它这个 matches 功能。我们想用它，我们就得用 autowired 把它装配一个，但是这个类它默认是不被 spring 管理的。

说话人 1 00:11:52
如果我们直接 autowire 的话，它是会报错的，我们可以试一下它为什么要报错？我们装配都是直接装配接口，看一下这个标红的，他说无法自动装配，找不到 passwordencoder 类型的 bin， 说明我们只有这个接口，但是没有任何一个这个接口的实现类装入注入到了这个 IOC 容器里面，所以我们需要把它注入进来。

说话人 1 00:12:32
我们就用 import 注解，我们注入的是 bcrypt.passwordencoder。点 class 好用这个 import 注解，就把这个 bcrypt.passwordencoder 注到我们的 IOC 容器里面了。这个类由于实现了这个 passwordencoder 这个接口，于是我们现在再来到测试类里面，可以看到它不爆红了。这个里面它这个导航到自动装配的依赖项，我们一点就导航到了这个 becreft， 然后这个 passwordencoder， 我们正是通过在这个启动类上用 import 这个注解把它注入进来的。

说话人 1 00:13:17
既然这个容器里面已经有这个 passwordencoder 的实现类，我们就试一下它的方法吧。我们调用它这个 passwordencoder， 点 encode 方法，这是加密之前的返回，我就写这是原文。是写加密之，这是加密之前的密码，它会返回一个字符串，我们把它打印出来。

说话人 1 00:14:26
诶，看到了，这就是打印出来加密之后的密码，我们把它复制一下。先把它注释。

说话人 1 00:14:40
我们。看一下它有多长，我们用点 lens 它有多长？看一下60。他这串密码是60，这就解释了我为什么要把这个 user 的 password 设成X60了吧。我设成这个定长串60，正是因为它加密以后这个长度正好是60，所以我才把这个 password 字段设成了X60。

说话人 1 00:15:33
这串密码我们已经知道了，我们现在怎么判断它是否和原文匹配的呢？我们可以用 passwordencoder 的 matches 方法看一下这个第一个参数是原先的密码，第二个参数是已经加密之后的密码，我们原先的密码是这个加密之前的密码，然后我们已经加密后的我就叫 encoded。如果它们两个是匹配的，那么这个 matches 方法应该返回 true。

说话人 1 00:16:30
发现它真的返回了 true， 因为加密之前的密码，加密之后确实是这个，然后它们两个是一样的，于是它就返回了 true。如果我们把原先的密码改一下，它还能返回 true 吗？

说话人 1 00:17:00
发现它返回了 false， 说明这个和这个密文它不匹配。于是我们可以用这个接口来完成我们的加密与判断是否匹配，这只是个接口，它的实现类，我们选用了这个 bcrypt password encoder， 而这个 encoder 是在我们这个启动类上用 import 注解导入进来的。通过 import 注解，我们把它装配到了，注入到了这个 IOC 容器里面。

说话人 1 00:17:34
这节课我们来讲一下比较难的地方，就是认证和授权，我们这个项目是用 spring security 进行认证和授权，我们来到示范项目里面。这 springsecurity 是用到了两个类，一个是在 config 里边的这个 securityconfig， 然后还有一个是在 filter 里的 tokenfilter， 我们把这两个类都给它复制到我们今天项目里面去。

说话人 1 00:18:00
首先来这个 securityconfig， 这个是在 config 文件夹的，这它是一个配置类，我们把配置相关的类都放到 config 文件夹下，我们新建一个包叫做 config， 我们把它粘过来叫 spring secsecure securityconfig。然后我们去把这个 filter 底下这个 TOKEN filter 也粘过来，这个是一个过滤器，我们过滤器是放到 filter 包下面的，我们新建一个软件包叫做 filter， 把它粘过来，看一下这个报错是怎么回事。这是个方法，没有写那。把这个方法补一下，创建，我们这是要写一个根据用户名，然后获得用户信息的一个方法，我为了省事儿，我用 select 星了，但是。你们最好不用 select 星，因为最好是指定要哪些字段，要那些不要的字段就不 select 出来了。

说话人 1 00:19:42
where user name 等于 user， 我看看那个哦，没有写 param 注解，我说这个怎么没有提示呢？他一点提示都没有，我把这个 param 注解加一下。

说话人 1 00:20:09
user name 现在我们用 param 注解标注了这个 string 是 user name， 我们回到这个 Mapper 这个 XML 里面， user 现在有代码提示了 user name 这个 result type， 不要用 result type。之前说过这个字段的映射问题，我们给它换成 result map， 我用的是 user result map， 这个 user， 这个 result map 是我们在这个 XML 开头这里定义的 user result map。它是把我们一些数据库字段和实体类字段不一样的问题给解决了， password、 passwd， 还有 user role， 然后 role 它解决了这种字段名不一样的问题。我们把这个方法写完了，我们格式化一下， Ctrl Alt l， 这样让它更好看一点。我们回到之前的这个 tokenfilter， 看一下它还哪报错，无法解析这个 user， 我们还得改一下我们到示范项目里的 user。

说话人 1 00:21:23
brainsecurity 是要求 user 要实现这个实体类，在这儿 user 要实现这个叫做 userdetails 接口，我们看一下这个接口里有什么东西，这里边一个叫做 getauthorities， 这个是获得这个用户他有哪些权限？然后这个是 getpassword， 说后面这个获得这个用户加密之后的密码 getusername 获得这个用户的用户名，然后 isaccountnon。

说话人 1 00:21:56
是这个返回这个账户是否过期？是否没有过期？isaccountnonlock 是否这个账户没有被锁？然后是否这个凭证没有过期？然后这个是否启用？我们来看下我们这个实现这个接口是怎么实现的？我们把它整个粘过去，把这个释放向你的 user， 整个粘到我们这个新项目里面，找到 entity， 然后整个替换，其实它也没有改很多，就是在这个。旧版上面增加了一些东西，就是实现了这个接口而已，它实现这个 user detail， 所以它是要必须实现这些 get authorities， 然后 is account， non expire 这些方法。我们这些方法都是一定要返回 true 的，不然它认证了要通不过去。我们这恒定返回 true， 然后我们看，诶，这怎么还有报错？user role 嗯 enum 我们这枚举没有吗？我看看这个枚举 user role， 我把它注释了，我们现在取消注释，我们就要用到这个枚举了。

说话人 1 00:23:11
这个就是我们 spring security， 也不是 spring security， 是我们需要定义的一个用户所具有角色的角色拥有的权限，像这个普通用户他的 role 就是0，他对应的权限就是有 role user， 然后他这个管理员他的对应的 role 就是一，他用的权限就是有 role admin。

说话人 1 00:23:36
这个 role 这个零一释放到我们这个 user 数据库里的，这个叫 role 这一列它默认都是0，什么它默认都是普通用户？我们先把这个数据库清空一下，现在数据库里就没东西了，我们再看一下这个 user 它是怎么返回它这个权限的。首先这个 role 先用了这个判断，它不能是 null， 然后我们遍历这个枚举的所有的类型。如果他这个枚举，他这个肉和这个类上面的肉。是相等的，那么就返回对应的这个枚举的权限就相当于这个，这样如果他是管理员的话，他 row 是一，对应的权限就是 row admin， 如果他是普通用户的话，他 row 就是0，他返回的这个权限就是 row user， 然后返回一个 ArrayList， 然后把它如果都没有的话就返回一个 ArrayList， 然后我们看一下这个 TOKEN filter， 看一下这个。

说话人 1 00:24:50
security config 现在它就不报错了，我们来看一下这个方法，现在我们重点讲的是这两个类，因为我们导入的就是从那个新项目，导入的就是这两个类。先从这个 spring security 开始讲这个 configuration， 表明这是一个配置类，然后 import 注解导入，注入了我们之前说的那个 bequeath password encoder， 它实现了 password encoder 的接口，我们可以用它来加密，还有匹配我们的密码是否是匹配的，然后这个 enable global method security 是启用我们在 Controller 方法上的那些。注解，我们需要把它 Pre post enable 设置为 true， 我们在 Controller 上的这些 Pre authorize 的注解才有作用。

说话人 1 00:25:44
我们看一下类里面这个 autowire TOKEN filter， 就是指这个 TOKEN filter。一会我们会讲到这个 authenticationentrypoint 是我们的认证失败处理器，这个 passwordencoder 是密码加密用的。它装配的是 becreate password encoder， 因为我们在前面导进来的注入的就是 becreate password encoder， 这个是 user details service， 它是可以帮助我们从数据库里根据用户名返回一个用户信息。

说话人 1 00:26:18
我们点开看一下这个接口有什么，它就有一个方法有 loaduserbyusername， 我们需要实现这个方法，实现类必须实现这个方法，根据用户名返回一个 userdetails 接口，就是它的实现类。我们看下它在哪实现了，其实它在后边，在这个类的后边实现，这也是在 spring security 的类里面有一个静态类。我们一会讲到这里 configure， 它是一个配置 spring security， 我们重写它。这 configure 方法可以指定我们是用哪个类来获取，从数据库里获取它的用户信息。我们指定了是用这个 user detail service 接口的实现类，我们来找到它导航一下。打到这里。说明我们指定了是用这个类来实现，我们 load user by user name， 然后 password encoder 是指定用哪个 password encoder 进行密码的加密，然后我们来看一下装配到哪里，装配到这里说明我们只能用 bcrypt password encoder 进行密码的加密，然后我们看一下这个 authentication manager 这个注入 b， 其实注入 b 并不是用于这个 config 这个配置类的，我们是用于。

说话人 1 00:27:51
看一下这个示范项目里这个有一个 user， 不对，这个 user service 里边有一个 autowired， 它需要 autowired 一个 authentication manager， 它是为了这个 user service impl 需要装配，所以我们才用 bin 注解注入的。就是如果你不用这个配置类 configuration， 这个配置类里的这个 bin 注解，把它注入到这个 IOC 容器里的话，你那个 user service impl 它是没法 autowired。

说话人 1 00:28:28
这个 authentication。manager 这一类的，所以我们用 bin 注解，然后 return 一个 authenticationmanager， 就是为了我们到时候实那个是 service 类，要用这个 configure 重写，他的方法是配了，也是为了配置 springsecurity 的这个 CR i CSRF 我们要关掉，然后这个 session 也是要关掉，这个注释我都写的比较清楚，你可以看一下这些注释。

说话人 1 00:29:01
这个是判断哪些是需要认证，哪些不需要认证？这三个接口是需要认证的，其他所有接口都不需要认证的，认证和授权它不是一个东西，需要我们是先认证，然后再授权。有的接口它是既不需要认证也不需要授权。有的接口是需要认证，但不需要授权。有的接口是需要认证，也需要进行授权。

说话人 1 00:29:37
这个是我们需要添加一个 filter， 这个 tokenfilter 我们看一下它导航到哪？导航到了这里，这个就是我们用 component 的注解，注到我们 IOC 容器里一个 filter， 我们需要你光用这个 component 的注解注入还不够，还需要在 spring config 里配置，我们就在这个 addfilterbefore 这里，在里边给它添加到了过滤器链中，这里是配置的，是认证失败处理器，我们看一下这个处理器是在哪，导航一下。

说话人 1 00:30:11
导航到了这儿，这个也是在这个 security config 里面的一个。静态的类，我们一会儿也会讲到这个是允许跨域，这个和 MVC config 里面的跨域两个都需要开启允许才行，只有这里边在 spring security 这里边也要开启允许跨域，这个就是我们的 userdetailserviceimpl 的，它实现了这个 userdetailservice 接口，它就是定义了我们如何从数据库里根据用户名拿到我们的用户信息，我们需要重写它的 load。

说话人 1 00:30:51
user by username 提供给一个 username， 然后我们是通过 userMapper 获取他的用户信息，然后返回了 user， 它返回值是一个接口，说明我们是返回必须要返回一个这个接口的实现类，而我们这个 user 恰好实现了这个 userdetails 接口，所以这个返回 user 符合要求的。

说话人 1 00:31:15
因为我们要用到 springsecurity， 所以我们才要这个 user 要实现这个 userdetails 接口，这个是我们定义的 authenticationentrypointimpl， 它实现了这个 authenticationentrypoint， 这个是我们的认证失败处理器，它可以处理 filter 抛出的异常。

说话人 1 00:31:33
在 filter 抛出的异常，在全局异常处理其它没法处理的，因为它在进入 Servlet 之前它就异常就出现了，而全局异常处理器是只能处理经过 Servlet 后面的异常，所以像认证失败异常就是在这个 TOKEN filter 中抛出的，异常是在这里边处理的。

说话人 1 00:31:54
我们注了一个 objectmapper， 然后我们设置返回状态码是401，然后设置。它的这个 body 是认证失败，我们再看一下这个 tokenfilter 类，这个它是一个过滤器，它有三种可能，如果没带 TOKEN 的话，那就不设置标志位并放行，带了 TOKEN 但无效就直接抛异常就不会往里走了。然后如果带 TOKEN 有效，那就会设置标志位 true， 然后放行。

说话人 1 00:32:27
这个 jwtutil 就是我们之前讲过的 JWT 工具类，它提供了一个是根据用户信息生成 TOKEN， 一个是从 TOKEN 中还原成用户，还原为用户信息。这里面就是一个 dofilter 方法， dofilter internal 里面有个关键的方法是这个 dofilter 它是由，它是一个过滤器链，因为 Brook secure 它是通过一个过滤器链实现的一个过滤器，然后再经过下个过滤器，然后返回来以后也会回到上一个过滤器，它这个分隔点就是这个 dofilter 方法，它这么执行的，假如说这些都不抛异常，它就从这走到这，然后从这个 dofilter 这里就去下个过滤器了，然后下个过滤器一回来，然后回来以后从这个打印这个请求离开了。

说话人 1 00:33:24
就有点像那个方法对应的栈，就是 a 过滤器在这走，然后 dofilter 到 b 过滤器，然后再执行前面的，再 dofilter 到 c 过滤器，然后再执行，最后执行一大圈以后回来在 c 过滤器后边执行 dofilter 后边方法，然后回来到 b 过滤器执行 b 过滤器的 dofilter 后边那段。

说话人 1 00:33:46
代码，然后再回来到 a 过滤器执行， a 过滤器后边那段代码就相当于这儿，前面执行到这 do filter， 然后去后边过滤器了，然后回来以后再执行这个 lo info， 如果你在前面这段有抛出异常的话，那它根本就不会执行这个 do filter 方法，就连后边的过滤器都不会进入，它就返回了。

说话人 1 00:34:08
我们看一下这个 do filter internal 方法是里边哪些逻辑，它先打印了来，打印了日志，然后进行了一个 TOKEN， 如果 TOKEN 是有值的话，它会尝试。去从这个 TOKEN 里面去提取用户信息，如果提取用户信息失败的话，它就会在这个控制台打印一条 war， 然后并抛出异常，这个异常就会被我们的这个认证失败处理器捕获，它就会在这个 Commonresult 里面设置认证失败。所以你们如果不带 TOKEN 去访问那些需要 TOKEN 的接口的话，就会看到这样的一句。就是因为在这个 filter 这里，他在解析 TOKEN 的时候他就出错，然后抛出异常，被外边这个认证失败处理器捕获，然后就写了这样一个返回值，然后并设置 http 的状态码401表示认证的失败。

说话人 1 00:35:13
在 Controller 方法中我们可以用，可以看一下这个项目， Controller 方法中我们可以用。这个 authentication principle。来获得这个用户信息是哪来的呢？还有这个 Pre authorized 我们怎么知道它是有权限的呢？就是 spring security， 它是怎么知道当前这个请求？这个用户是有这个权限，而且它是怎么知道这个主体是谁？我们看一下它是怎么实现的？它是在，就是在这里 SEC security context holder， 然后 set authority authentication 这里第一个参数。

说话人 1 00:36:01
点开看这个就是 principle， principle， 看一下 Controller 代码， principle 就是这一个东西，这里的 user 就是你在诶 TOKEN filter 里边设置的这个第一个参数， user 就是我们从 TOKEN 里提取出来的 user， 还有他是怎么知道权限呢？就是这个第三个参数。

说话人 1 00:36:32
这个有个 collections authorities， 它是根据你提供给它的 authorities 判断它有哪些权限的。我们从这里面 user 点 getauthorities 方法。还会调用 users 的这个 getauthorities 方法，它的原理就是根据这个 user 的 role， 然后去这个枚举里面去获取它有哪些权限，然后返回到这个方法里面，然后设置到 security 的 context 里面，就是 security 的上下文里面，然后到这里面，等到这个 control 方法的时候，他就知道这个权限是有多少了，还有知道他这个主体是谁了。

说话人 1 00:37:20
这个原理是用 Threadlocal 实现的，不过 Threadlocal 你们也不用了解这么深，因为这是 Java 多线程的时候会学 Threadlocal 什么东西，你们就知道你们在 Controller 的时候用到的这个 user 信息是在你这里设置进去的，然后 spring security 它判断用户的权限够不够，也是通过这个 user 点 getauthorities 这个方法返回值来获取的就可以了。

说话人 1 00:37:54
这节课我们来写一下注册接口和登录接口。我们从这个文档开始写，我的习惯是把 Controller 都写完了，然后再去写 service， 然后把 service 都写完了，再去写 Mapper。我觉得把一层一层的写更方便，这样省去了反复切换。我们看一下这个接口文档，这个 body 参数有一个 user name 和 password， 这个是登录用的，注册用的这个 body 参数，那我们看下登录用的，登录也要用 body 参数，所以我们去这个 param 里面加一条叫做登录参数。登录参数就用 loginparam， 我们还是要给它加上一个 adddata 注解这个登录参数是需要有这个 username， 还有需要有它的密码，我们使用注解进行入参校验。

说话人 1 00:39:03
首先这个用户名不能是空诶，不能是 not null。这个 not blank 和 not null 还是有区别的，然后我们这个注解里边每个注解都应该用 message 来写一下到底是什么原因导致的认证失败？我的建议是每一个注解都写 message， 虽然你不写 message， 它也是有默认的那种提醒，但那种提醒不直观，所以我不是很推荐用它默认的那种提示。

说话人 1 00:39:46
还有一个是 lenlength， 还有一个最大值，最大值是20， message 就写密码最长是最长，不能超过20，这个也是有 not blank 的要求，不能是 null， 然后也不能是空字符串，也不能是全是空格。message 也写一下，密码不能为空，再用 length 约束一下，最长就20。message 还是每个都要写一下，现在我们就用注解完成了参数校验，真是非常的省事。

说话人 1 00:40:43
我们来到 control 里面接口文档上怎么说的方法是 post post 就是 post Mapping， 我们同理可得 get 就 get Mapping， 然后 post 就 post Mapping， 那 put 就当然就 put Mapping。然后 delete， 当然就是 delete mapping， 这个是 users login， 我们这个 users 已经写在类上的这个 request mapping 上面了，然后后边这个字符串是拼在它后面的，所以我们这后边这 users 就不要重复写了，我们就只写 login， 最后它一拼就成了这个 API message board， 而唯一 users login。因为这个没有什么可返回的，我们就返回 void， 不过返回 void 一会儿有个坑，一会儿我再讲。因为是从 body 提取值，用 valid 开启参数校验，这里我们是用 HTTP 注入一个 HTTP serverless 的 response， 我们是可以直接在这个。方法的这个参数列表里边注入 http serverless request 或者是 http serverless response， 这都可以，它是可以直接获取到我们返回的那个 response， 然后直接对它进行修改。我们想要从 user service 里边拿到用户信息，先导入一下这个类，导进来 login。

说话人 1 00:42:41
我们要提供给他的当然就是用户名，还有密码标红，不用管它，一会我们一键生成，我的习惯就是把这个 Controller 里所有方法全写完了以后，然后这样一键生成里边所有方法，然后接口里边方法都生成好了，然后去找实现类，实现类里边一键生成所有的实现方法，这样可以省时间。这个我们是留的是普通用户登录的接口，因为管理员他有专门的接口。对，我是写的是如果他返回这个用户，他是普通用户，诶，对，如果他不是普通用户的话，那应该告诉他不在这里登录。

说话人 1 00:43:57
也就相当于他的用户名和密码是有问题的，毕竟普通用户的登录界面和管理员的登录界面应该不是一个抛出异常，然后这个异常是用了这个构造函数，第一个传进去一个 resultcodeenum， 然后第二写一下他这个 message。能运行到这儿是因为他确实是普通用户，我们就可以用，先注入一下，我们想用 JWT util， 然后他没有，我们就用 autover 把它这个 util 我们注入一下，他就有了。auto aware 以后它就注入了，我们可以看导航到自动装配的依赖项，可以看到装配的确实是这个，然后这个 value 值也是从我们的配置文件里边取的。现在我们已经有 JWT util 了，我们就可以用它来生成我们的 TOKEN， 然后我们去 response 里边设置我们的 header。header 的 key 就是我们的 TOKEN， 就是这些都是接口文档里边约定好的，你们，你们可以去看一下这个文档，确实是这么说的，然后就不用了，看一下这个文档用户登录这个是这个说明里边 HTTP 的 header 部分会有 TOKEN 字段，这个就是我们生成的 JWT。

说话人 1 00:45:55
我们看一下这个代码里边，确实是在这个 HTTP 这个 serverlet response 里边，我们设置一下它的 header， 然后 TOKEN 就有这个 TOKEN 字段了。但这个坑，我讲一下这坑是啥？我们来到 advice 里边这个 resultwrapper。这个 resultwrapper 它是如果 Controller 的方，这个参数列表里边有，如果有 http serverresponse 的话，如果你返回值还是 void 或者 null 的话，这个包装器它又没法工作了。

说话人 1 00:46:26
所以有这个问题我们恰好符合这种要求，就是你返回是 void， 而且你还装配了一个 response， 所以你不能直接去用 void 返回，为了返回点东西，我就 return 一个 newobject， 现在我们再来，诶，你 return newobject。现在我们再来 Alt， 然后 enter， 然后再 enter， 直接生成这个方法，我们点击这个，点击实现方法，然后点击确定，直接插入我们这个 overried， 还有这个方法签名都写在这了，我们直接写实现就好了。

说话人 1 00:47:13
我们今天这个 regiser 呢？明显是还没有写，把它删了。我们不先把 regiser 写一下， regiser 我们密码肯定是不能直接存明文的，我们肯定是要存密文。我们在需要用 password。encoder 我们就在这里装配一个 autowire， 一个 password encoder 它是一个接口，它装配肯定不是装配接口，它装配进来是一个实现类，它实际装配的，看一下它实际装配的是 bcrypt password encoder， 它实现了这个接口，所以我们要求装配这个接口，它给我们装配了一个这个接口的实现类，既然我们已经装配进来这个 password encoder 以后，我们就可以用它来进行密码加密了。

说话人 1 00:48:04
首先我们需要从数据库里获得。这个用户，但是这个用户有可能不存在，因为用户他前端提供的用户名可能是一个假的用户名，这个用户根本就没在这里注册，这个时候他这个 user 就会为 Null， 还有可能就是用户已经存在了，这个时候 user 就不是 Null， 如果不是 Null 的话就说明这个用户名已经重复了，这个时候我们就要应该抛出异常，抛异常的话我们会有一个全局异常处理器，然后把异常捕获。

说话人 1 00:48:53
我们来看一下，就是在这里 global exception handler， 这是一个全局异常处理器，这里然后它有一个 exception handler， 它这个方法可以捕获住我们抛出来的这个 business exception。然后在控制台打印一条 war， 然后返回一个 commonresult 包装好的一个对象，我们在这里就大胆的抛异常就可以，因为到时候会有那个全局异常处理器帮我们补货，然后封装好，按照我们这个返回模板封装好我们这个异常的信息。

说话人 1 00:49:39
对于这个异常信息我觉得还是应该写得详细一些，我就把具体哪一个用户名存在都写上，如果写得不详细的话，问题出问题也不太好排查。这个时候我们用 userMapper 点 insert 看下这个提示，第一个是 user name， 第二个是 password， 刚好提供的是第一个是 user name， 第二个是 password， 现在我们这个接口就写完了。但是还有一个问题，就是假如两个人他同时想要注册同一个用户名，这样的话就会带来一个并发的问题。

说话人 1 00:50:26
用户一来了，然后他要注册一个用户名，用户二也来，他也要注册一个用户，他们的用户名是相同的，然后这个时候两个线程同时进行处理，第一个线程从数据库里看发现没有这个用户名，第二个用户也来，线程2，从数据库里查发现也没有这个用户名，于是这个判断不会进去，于是他们都会往里面插入一条数据，于是线程一插入了一条用户名。

说话人 1 00:50:59
这个数据，然后新2又插入一条同样的数据，就导致了数据库里面有两个一样的用户名，这是我们不想看到的。解决这个一个办法就是加唯一索引，我们来到这个用户表里面，我们点击这个新建，看可以新建这么多检查列，而外键索引建表，我们来点这个索引，我们想建什么索引呢？当然是就是用户名的索引。我们想建用户名的索引，然后一定要把它设为唯一索引，这个索引，这个怎么还有中文呀？我不在这建，我去那里建，去修改表，这里建，这里索引就是中文了， user name， 然后让它排个序，一定要勾上唯一，一定要勾上这个唯一索引，通过唯一索引我们可以避免这种两条插入两个一样的用户名的问题。

说话人 1 00:52:18
执行，现在它就有这个唯一索引了，对，这个 username 的唯一索引，但这样的话，如果不出现刚才那种并发的情况，线程一插入一条用户名，线程2插入一条同样的用户名，这样它会抛出 duplicate key exception， 我们需要把它捕获。

说话人 1 00:52:44
把它放进去，点一下这个异常，当 KT 捕获，如果出现这个异常，就说明晚来的那个人他的用户名已经被别人先抢先注册了，数据库已经有一个同样的用户名了，就没法再注册了。这个时候我们可以抛出我们的异常，说用户名已存在，我直接复制了。诶，复制。到现在为止我们这个注册接口就写完了，接下来我们看登录接口怎么写。对，还没写完。这个 password 怎么可能存明文呢？是先用 passwordencoder 加密一下。我们先用 password， 这个 encoder 里边有一个 encode 方法，我们需要把这个 password 加密一下，这个 password encoder 加密以后它就是密文了，然后我们把这个密文存入数据库，数据库里的密码肯定是不能存明文的，肯定是要存加密之后的，我们现在来写一下我们这个。登录接口。登录接口我们需要用到 Authentication， 看一下导航到哪，它导航到了，我们用注解注入的这个地方，这就是我上次强调的这个注解，要把它注入到这个 IOC 容器里面，正是要给我们这个 user service impl 用的。如果你不用这个 bin 注解，我们就看一下什么效果。不用这个 bin 注解，看一下它马上就开始爆红，说无法自动装配，找不到这个类型的 bin， 我们肯定是要把这个 bin 注解加上，这样可以看到还能不报错，可以找到这个类型的 bin， 然后装配进来 login， 这个方法也提供了用户名和密码。

说话人 1 00:55:41
我们先。用一个 authentication 诶，写错了，不是不要前面的前缀就 authentication 导入这个 org.springframework security core 里这个东西点它。我们在认证的时候如果认证失败会抛异常，所以我们得捕获它 authentication 点 authentication manager 这个 manager。就是我们之前装备前这个 manager 他可以帮我们进行认证，他会帮我们从数据库里拿出这个密码，然后去把原文用这个 passwordencoder， 然后加密，然后去和数据库的密码进行比对，如果是成功的话，他会返回这个，对，这个加密之后这个用户这个 authentication 若匹配失败，他会抛异常，我们得捕获这个异常，他这个方法是 authenticate， 我们是用户名和密码。所以我们 new 一个 user name password authentication TOKEN， 第一个把用户名。

说话人 1 00:57:00
第二个传密码，我们让他就让这个 authenticationmanager 去帮我们进行认证，我们把用户名和密码告诉他，如果认证成功，那他就会在这 authentication 这返回一个 authentication， 如果认证失败，就抛异常了，他抛出的异常他是抛的异常种类是 Authentication man Authentication exception。我们来找一下 Authentication exception， 捕获一下。

说话人 1 00:57:33
打一下日志，说明打日志它爆红是因为我们没有在这个类上加SLF4J，要打日的话我们得加上一个这个注解，加完这个注解以后它就可以正常的使用 log 来打日志了。用 war 登录失败，然后我们这里写登录失败这个打日志以后我们也可以更方便排查问题，这个里边最好写清楚一些是为什么失败。

说话人 1 00:58:10
我们把这个 exception message 我们也给写进来，在控制台打完日志以后，我们也不能就这么直接的就把异常捕获住，我们就不管了，我们还得抛出去，因为我们需要返回一个登录失败的一个错误，那就是用户名或密码错误的一个错误信息给前端，所以我们还得把这个业务异常抛出去，我们选择是 warm username or password。

说话人 1 00:58:45
如果他认证失败，那么就会在这里，他会抛出 authentication my exception， 然后被这里捕获，在日台控制台里边打条日志，然后 business exception 又会往外抛出去，以后被我们那个全局异常处理器捕获，然后按照我们规定的返回模板返回给前端说用户名或密码错误，这样前端就可以看到是用户的用户名和密码输入错误导致的登录失败。

说话人 1 00:59:10
如果运行到这里的话，说明这认证已经成功了，我们直接从这个 authentication 这里提取出 getprincipal， 提取去它的认证主体，它认证主体就是我们的 user。这个就是认证主体，就是实现了这个 userdetails 接口的这个类，我们实验 userdetails 这个接口类是 user， 所以它返回的就是 user， 我们把它进行一个进行转化，返回过去，然后它在这个 login 里面，如果它的这个 role 是普通用户，那么就没问题，就会给它生成一个 TOKEN， 把这个 TOKEN 续到 header 里面返回给前端，这样前端就会在 header 里边拿出这个 TOKEN， 然后保存下来以后再进行需要认证接口的时候，访问的时候就会在这个。请求的 header 里面带上，这样我们后端就可以知道这是哪个用户了。

说话人 1 01:00:10
我们这节课继续来讲 spring security， 我们这节课讲的是认证和授权中的授权部分，我们首先会来到这个示例项目，我们不要把这个认证和授权搞混，我们来到这个 security config， 怎么判断哪个接口是不是要需要认证呢？在这个里边有这个 configure 方法，这个传进去 HTTP security 这个参数，这里这个看到 permit all， 看到这三行了吗？这个三行这三个接口他们是不需要认证的。

说话人 1 01:00:50
还有后边这个是 any request authenticated， 就是说除了这三个接口不需要认证以外，其他接口都需要认证。认证就是说判断你这个用户是不是我们系统的用户，就管你是用户，不管你是普通用户还是管理员，只要你是我们的用户，都算是认证成功，那授权。是更高级别的一级，就是先认证以后，然后我们再授权，看你这个接口有没有对应的权限。

说话人 1 01:01:22
这三个接口不需要认证，其他所有接口都需要认证，我们再看一看，我拿 usercontroller 举例，像所有标准这个 preauthorize 的注解的接口都是需要授权的，像这个 preauthorize 还有其他的一些。像这个里面 preauthorize 这些都需要授权才可以接口，你可以按照是否需要认证和授权分为三类，一类就是既不需要认证也不需要授权的。像这个 register 他这个写的是 permit all register， 他既不需要认证，然后我们看一下这个 register， 他也没有用 preauthorize 的注解标注，这个是既不需要认证，也不需要授权。而我们有的是需要认证，但不需要授权。

说话人 1 01:02:19
我们来到 spring 这个 securityconfig， 除了上面这三个接口以外都需要认证，但是有的接口它没有标 preauthorize 的注解，像这个接口，像 getuserinfo 这个接口这个方法它需要认证，但是它不需要授权，就是说不管你是普通用户还是管理员，你只要是带上合法的 TOKEN 都可以访问这个接口。

说话人 1 01:02:50
有的接口它是既需要认证也需要授权，例如这个接口它在这个 securityconfig 里面属于需要认证的，然后它还带了这个 preauthorize 的注解，就说明它既需要认证也需要授权，不仅需要带上合法 TOKEN， 而且我们还会校验你这个权限有没有这个 user 的权限。

说话人 1 01:03:19
既然说到了授权，我们就来讲一下这个 preauthorize 的注解的使用。我们来到这个新项目，我们刚才写好了 login 和 register 接口，我们来运行一下，我来展示如何从 header 中获取 TOKEN。我们把数据库清空一下，来到 apifox 进来注册一个账号，这个名称我就随便起了，叫小明，然后 password 来写一个。

说话人 1 01:04:02
ABCDEF， 我们点击发送，看到它已经注册成功，我们来到数据库里，点开这个 user 表，发现它这个小名就是 user name， 这个 password 是我们看不懂的一串密码，这个是经我们那个 password encoder 给加密之后的，这个密码我们看不懂没关系，这是正常现象，既然数据库已经有了，我们就去那个登录接口。这里写小名，然后我们的 password 就写刚才注册用的 ABC d e、 f， 我们点击发送操作成功。虽然这个包题里边没有，但是我们看 header 点这个 header 看这个 TOKEN 了吗？这个 TOKEN 我们就是我们自己设置的 TOKEN， 我们把它复制一下，我得先找个地方把它存一下，就先用这吧先注释，然后这里。让它放一下，为了测试授权功能，我们创建一个测试的接口，我用 Git Mapping， 这是专门用来测试的。现在这个接口是属于我们看一下 config 里面的 security config。

说话人 1 01:05:53
这个接口是属于需要认证的，因为它不在这个 permit all 里面，所以这个接口是需要认证的，但是这个接口又没有被 Pre authorize 注解修饰，就是上面没有这个，像其他项目里有的这个没有这个 Pre authorize 的注解，所以它是不需要授权的。就是说你只要带上合法的 TOKEN， 不管你是什么身份都可以访问，我们来试一下哦。对，我先把这个全局异常处理器里。授权失败的这个取消掉。

说话人 1 01:06:40
我们既然要用到授权功能的话，这个我们处理这个 access denied exception 这个全局异常处理的方法咱们就不注释了，因为如果我们授权失败的话，它就会抛出 access denied exception， 然后会被这个方法捕获，因为我用这个 exception handler 把它捕获了，如果我们把它注释掉的话，就没法捕获这个 access denied exception 了。

说话人 1 01:07:11
我们把它取消注释，现在我什么都不带，我现在是新建一个测试，诶？测试在哪？快捷请求？我们现在一个快捷请求 users test。我们这个环境是前置 URL 写在这面这里面了，所以我们这里就直接写 user 开头直接发送。发现这个有个认证失败，因为我们这个接口是需要认证的，虽然它不用授权，但是我们需要携带合法的 TOKEN， 因为我们没有在这个 header 里边带 TOKEN， 所以它就会你提示它认证失败，那我们把 TOKEN 带上。

说话人 1 01:08:12
复制一下，然后粘过来，这个参数名是一个，我看一下这个是在 tokenfilter 里面的，它是从 request header 里面提取 key 为这个东西的值，我们把它粘过去，我们再请求一下，这次发现操作成功，那我们把这个参数值故意删掉一个再发送。认证失败我们再给补上，然后再发送就操作成功。我们要是不带再发送就又认证失败，带上再发送就操作成功。

说话人 1 01:08:59
现在我们讲完了认证了，那我们继续讲授权，我们是用这个 Pre authorize 的注解，想开启注解功能，我们首先需要在这个 spring security config 里面。加一个，这个叫做 enable global method security， 然后把这个 Pre post enable 设为 true， 这样我们就可以用这个 Pre authorize 的注解来加到我们这个 Controller 里的方法上了。

说话人 1 01:09:31
我们来到 user Controller 里这个专门用于测试的方法 preauthorize 里面，这里面可以写 has role， 然后 ha has role， 然后 has any role， 然后 has authority has any authority， 这四个我们会一一测试。我们先点进去一个。user， 我先随便写一个 a b c， 这肯定是没有这个权限的，那我们就会看一下没有这个权限会怎么样？就是授权失败，发送权限不足，看一下我们这个控制台怎么说的。它在这个 global access exception handler， 这是全局异常处理器里把它捕获了，捕获的类型就是 access denied exception， 就是我们刚才说的这个授权失败的异常。

说话人 1 01:10:50
这个 Pre authorize 里面可以写四种类型，我来一写一下，第一个叫做 has role， 第一个叫做 has all， 点进去看，这可以看结构，一个是 has authority， 把它复制一下。好， authority， 好，第二个叫做 has any authorities， 这个里边是一个可变长的一个参数。第三个点进去叫做 has role， 翻过来叫 has role， 第四个叫做 has any role， 这四个都是我们可以在。先关掉在这个 preauthorize 注解里面写的，其中 hasauthority 和 hasrole 都是一个字符串的参数，而 hasanyauthority 和 hasanyrole 它们都是可以传进一个或者多个字符串的参数。其实 any 就是任何的意思， hasanyauthority 就是说你有其中任何一个权限就够了。hasanyrole 就是说你有其中任何一个权限就够了。我们先从 has authority 开始讲起这个，我们这个在 TOKEN 中它设置的 user 的值是 row 是值是0，像这样，因为它默认的就是 user row 是0，我们到 TOKEN filter 这儿你们就知道是怎么读取的，在这儿吧。然后我选择调试，我们在这设个断点，看一下这个取出来的这个 user 是什么，看一下这个 user， 我们来到这里重新请求一下，发送回到我们这个 idea， 看一下 user， 这个 user ID 是17。

说话人 1 01:13:30
然后 userrow 是0，这里用 user 点 getauthorities， 可以看到这个 user 带有哪些权限。我们下一步步入这个是我们 user 里面，我们现在是在遍历每一个 userrowenum， 看一下。大家可以看到现在是要返回一个普通用户，因为普通用户的 get role 就是0，他这个 user 的 role 也是0，所以它会返回这个普通用户的拥有的权限，这个 authorities 就是它的权限，它是一个 Arraylist， 它长度只有一，可以看到它有一个 role user， 就是我们前面设置的这个 role user 先停掉，现在我们就知道了这个，我们这个 TOKEN 里面因为是 row， 是0。所以他给他的权限都是在这个枚举 constant 在 user role 里面这里设置的，我们把它改一下，我们改成 ABC 这样，就是说我这个 TOKEN 所拥有的这个角色拥有的权限就有一个，就叫 ABC， 把它关掉，那这样来说应该就有 search。

说话人 1 01:15:20
它就能访问这个接口了，我们来启动项目试一下，看现在能访问了，因为我这个角色是0，它对应的权限就是有 ABC。然后他又要求有权限 ABC， 那假如说我们要。要求有 a b， 那现在看一下现在还能不能访问？

说话人 1 01:16:22
可以看到现在就访问不了了，因为我们拥有的权限是 ABC， 但是它要求你要有 AB 的权限，这不相符，所以访问不了，那我们可以。用 has any authority， 假如说你只有其中的任意一个，你就可以访问，我们看看现在可不可以访问这个 has any authority 就是说你有 AB 或者 ABC 中的任意一个权限，你就可以访问，我们点击发送。这个时候就发现能够访问了，能把 ABC 改成 ABD， 看一下，现在他的意思就是说你有 a、 b 或者 ABD 中的任意一个权限，你就可以访问，但是我们这个 role 是0，它对应的权限只有 ABC， 那现在还能不能访问这个接口？

说话人 1 01:17:40
可以看到现在访问不了，说都权限不足。

说话人 1 01:17:49
讲完这个 has authority 和 has any authority， 我们来讲一下这个 has role， 其实 has role 和 has any role 和前面比较像，它的不同点就在于会把你这个 authority 拼上一个不同的地方，它会把你的权限拼上一个。

说话人 1 01:18:22
row 下划线的前缀，我们可以试一下 hasrow， 就是说它会把你这个权限拼上一个这样的一个前缀，然后再去对比，我们用 hasrow， 诶，不对。快把 a、 b、 c， 然后拼上 row， 然后下划线，这里写 row， 快把。把这里的 ABC， 然后拼上前缀，我们点发送发现在是可以的，它原理就是它会先，它会把这个 ABC， 把这里的 ABC 拼接上这个 row 前缀，然后它会把这一整个字符串，它就和你拥有的权限去对比。看看 row 下划线 a、 b、 c 和你拥有权有符不符合，发现是符合的，所以它就会放行。假如说我们把这个 row 前缀一删，我们再试一下，看看现在还可不可以。

说话人 1 01:20:34
发现现在就不可以了，它原理就是它把这个 hash， string， 这个 ABC， 然后加上这个 row 下划线前缀拼成这个字符串，然后它这个字符串跟你用的权限对比，发现你这个权限里并没有一个叫做 row 下划线 ABC 的这个权限，于是它就会不让你放行，就把你拦在这里，你可以再加上这个前缀。row 下划线 ABC 它就可以了。

说话人 1 01:21:17
我们用的这个方法是 create authority list， 其实这里边可以不止放一个参数，一会演示一下如何放多个参数，现在它就可以了，因为他把这个 ABC 拼接上这个 row 前缀以后，拿这个东西跟你用的权限对比，看有没有符合的，这一相符就说明你有权限。然后最后一个是 has any role， 假如改成 d has any role， 意思就是说你有其中任何一个 role 就可以，还把 ABC 拼上一个前缀，就是 a role 下划线 ABC。然后它会把 d e 拼上一个前缀，就是 row， 然后 d e， 然后看你有没有 row ABC， 或者是 row d e， 你有其中的任意一个就会放你走，点击发送发现是可以操作成功的，因为你这个权限里边是有一个 row 下划线 d e， 然后正好符合它这个 row 下划线 d e， 所以它就匹配上了。这个里面是可以有多个，可以写多个参数的，假如说这写成这样，我们重启一下，看看这样可不可以放行。

说话人 1 01:23:34
点击发送，发现这是可以操作成功的，说明它放行，因为它把这个 de 变成了 row， 下划线以后，在这个用户有的权限里边找到了，所以它会放行，我们再来权限不改，我们用 has authority， has authority 不会给你拼接，就是原封不动的去匹配。

说话人 1 01:24:07
他就直接拿这个 de， 然后去和你用的这些权限，看有没有字符串相等的，点击发送就有权限不足。因为他拿这个 de， 然后去和你这里边遍历，发现没有相等的，于是就权限不足，那我们看一下 read 可以吗？

说话人 1 01:24:56
发现 read 是可以的，因为他拿 read 这个字符串去和你用的这些权限进行遍历，看有没有相等的，这有一个 read， 这俩等值匹配成功，所以它会放行，这样我们就可以用这个 preauthority authorize， 然后加上这个 has authority， 或者是 has any authority， 或者是 has role， 或者是 has any role 来完成我们的授权功能。

说话人 1 01:25:19
至于权限我们可以写在这个枚举里面，这个 create authority list 可以写多种，用 row 下划线开头的是。是它所属的角色，我们用它来和这个 has role 和 has any role 进行匹配。对于非 role 小写开头的就是他用的权限，我们用这些去和 has authority 和 has any authorities 进行匹配。

说话人 1 01:25:48
这四个就是我们在授权的 Pre auth authorize 的注解里面写的，我们可以在需要用它的时候选用合适的功能。我们用户一共有5个接口，我们的用户注册接口和用户登录接口已经写完了。我们现在把获取自己信息、获取指定用户信息和修改自己信息这三个接口写一下。首先我们来到获取自己信息，这是 get 方法，我们想当然的要用到 getmapping， 后边 users 跟 info。而这个 users， 我们引用类名上的，类上的 request mapping 写到类上面的这里面了，所以我们这方法的 get mapping 后边就不要写这个 users 了，我们直接写 info， 因为它会把这个 info 拼上到这个类上的 request Mapping 上面去，这个里面需要返回一个用户的视图对象，但这个用户视图对象我们还没有创建。我们新建一个包，已经有了，已经有，那就放在这里面新建 user。

说话人 1 01:27:14
VO 加 data 注解，加上看一下要返回什么？返回 user ID， 要 user name， nickname， sex 要这么写 private user ID， 然后 nickname 还有啥来着？还有 user name， 然后 nickname， sex， user name 和 sex。

说话人 1 01:27:56
然后一个是 Stack， 好了，这个 userview 我们就写完了，我们用这个 data 注解，让它帮我们去生成 getter 和 setter。我们导入一下，这个叫做获取自己的信息。

说话人 1 01:28:30
这个我想的是应该只有用户权限的信息，只有用户权限的。用户才能获取，我把它恢复一下，就改成 role user， 经过上一课的内容，我们就知道这个 role 下划线 user， 我们需要用 has role user 或者是 has any role user， 这样这个普通用户才能访问。而至于这个 role 下划线 admin， 我们需要用 has role admin。或是 has any role admin 这样对应的管理员才有权限访问而非授权的用户就访问不了。

说话人 1 01:29:09
我们这里用 has any role， 这 has role 也可以，因为你只有一个参数的话，其实它们俩是一个意思，可以拿这个 user， 然后拼上我们这个 role， 然后下划线，然后去和这个你拥有的权限对比，发现有字符串匹配的话，就说明你有这个权限。return， 点 user service， 点 info 这个方法肯定会标红，因为我们还没有创建它。

说话人 1 01:29:49
对，我需要现在，我现在还要讲一下，我们有一个注解叫做 authentication principle， 我们把它粘过来，这个注解非常强大。它可以直接知道我们这个请求的用户是谁，因为我们在看一下 TOKEN filter， 我们在这里，就在这，我们在这个 get context， 然后 set 一下 authentication， 第一个参数就是 principle， 我们设进去的就是 user， 我们在 Controller 里面直接用这个注解叫做 authentication principle， 直接把 user 一拿，我们就知道当前这个访问的用户是谁了。我们用 user 点。get user ID 就知道当前访问这个用户的这个 user ID 是多少，再来一个，看下这个文档，获取指定用户的信息，这后边跟着是一个 pass 参数。get 方法，当然是用 get mapping 了。get mapping 对于前面这个 users 已经写在这个类上面了，方法后边就不要再写重复写 users 了。

说话人 1 01:31:19
我们是提取 path 参数，我们使用 user ID， 看到这个大括号了吗？这个大括号就用来提取 path 参数的，我们需要在这个 Controller 的方法里面，我们是用 pass variable 注解来提取这个 URL 里面的这个 path 参数，这个也返回的也是一个 user vo， user vo 这个叫做 get user path variable， 这个我也之前讲过， path variable 是专门提取这个 URL 里面这个参数的。

说话人 1 01:31:55
这个参数是用大括号括起来，我们继续回到接口文档修改自己信息这个方法是 put， 既然是 put， 我们肯定要想到用 putmapping。然后后边跟的是 usersinfra， 这个是请求的 URL 先写上 putmapping， 因为这个 users 我们已经写到这个类上面了，所以我们后边就不要再重复写 user 了，我们直接写 infra 就够了，它会把这个 infra 拼接到我们这个类上面的 requestmapping 这个 URL 后面。public。这个修改的话是没有返回值的。modifyinfra。

说话人 1 01:33:07
后面我们仍然是用这个 authentication principle 这个注解提取出到底是谁在访问我们这个接口修改新用户信息需要有 body 参数，我们看一下接口文档这个 body 参数有哪些？body 参数一个叫做 nickname， 叫做 sex， 我们在这个 param 里面，对于这些要接收 body 参数的话，我们需要专门建一个类，我们叫做 modify。看一下名字怎么起的？这边是叫。modifyuserparam， 那我们跟它起一样的名字吧。新建一个类 modifyuserparam， 这个类是专门接收前端传来的 body 参数的，加上 at data 处理，让它帮我们生成 getter 和 setter。

说话人 1 01:34:18
这时候我们别忘了参数校验，因为前端传来的信息我们不能相信，前端传来信息都一定是对的，我们需要再加上一些注解，至于这个 nickname 我们就肯定是不能让它是空的， not blank， 然后这样 message 就写这个昵称不能为空。我们看一下数据库这个 nickname 给了多少？这个 nickname 它是给了10，所以我们对它这个长度再限制一下，用 length 限制它的长度。len， 然后后面接 Max， lens 里边可以写 min， 也可以写 Max， Max 就是最小，然后。

说话人 1 01:35:00
Max， min 就是最小， Max 就是最大，我们数据库里限制的最大长度是10，我们就对写 Max 等于10，这个别忘了写一下 message， 写上 message 以后给前端显示的这个错误提示，也就是我们自己定义的 message 了，这样显得更清楚一些。

说话人 1 01:35:16
昵称的最大长度为10，这个 size 我们也要限制最小，这是0。message 是性别最小是0，这个也有最大值的限制，不用 Max 注解来限制它的最大值，最大它就是2，性别最大是2，那我们用这个注解就完成了参数校验，就非常的方便，为了让参数校验生效，我们别忘了一会要加上。body 的注解 request body， 然后后边接 body body 的注解后面跟着我们的 MODI。

说话人 1 01:36:43
这个时候我们要用 user service 的 modifyinfra 的方法，我们需要指定是谁哪个用户在修改信息，至于哪个用户，我们已经用这个注解对应到这个 user 里面了，我们就用这个 user 点 get user ID 的方法，提取出请求用户的这个用户 ID， 然后还有这个 modify user param 里面的 nickname， 他想改成哪个 nickname？还有 modify user param 里面的。他想改成什么性别？现在我们还想让他只有拥有用户权限，用户角色的用户，诶，写错了。

说话人 1 01:37:40
这么写就是说明只有拥有用户角色的用户才可以访问这个接口，管理员是无法访问这个接口的。我们来生成一下方法，创建这个创建点击它的实现，在这里实现方法，这俩都选上，点击确定它，帮我们生成俩方法，我们把这个方法完善一下，这个时候我们要从数据库里选筛出 user VO， 但是我们看一下这个 user mapper， 它里面并没有一个返回 user VO 的一个方法，所以我们还得写一下返回 user VO 的方法。

说话人 1 01:38:26
user will。它的方法，先导一下类返回的方法，我就叫做 getviewbyid， 返回去的叫做 param userid， 它是一个浪型 userid， 比如没有，我们去 generate statement， 对，生成一下 resultmap 我就不想再写一遍了，我直接抄这个现有的项目，找到 XML， 把这复制一下。

说话人 1 01:39:14
粘过来，这就是 user view result map， 把这个 result map 这个 ID 我们复制一下，一会要用它默认生成的是 result type， 我们不用 result type， 把这 result type 删掉，我们要 result map， 然后写我们这个 user view， result map 还有 select 语句我也照抄了，我找一下 get view by ID， 我们把这个抄一下粘过来。现在我们这个 Mapper 里的这个 get view by ID 也写好了，点这个鸟可以跳转。这个是 get user by ID， 参数是 user ID， 返回一个 user vo， 就是给前端看的。

说话人 1 01:40:15
user view， 用 userMapper 点 get view by ID userid， 这个 userMapper 就是我们之前 filter 进来这个 userMapper， 但是这个 userid 可能是一个无效的 userid， 这个时候他 user view 就是 null， 我们需要判断一下 null， 如果他是 null 的话，说明他这个请求的资源就不存在，我们就要抛出异常，这个异常会被全局异常处理器捕获。然后返回请求的资源不存在，然后并设置 http 的状态码为404。

说话人 1 01:40:58
如果它设置了这个 userid 是有效的话，它就选筛选出来这个 uservo， 它不为 null 的话，那我们就可以直接返回这个 uservo 了，就像下面这样，我们可以直接返回这个 uservo， 就不为 null， 直接 return uservo。我们来看这个 modifyinfo 这里。

说话人 1 01:41:30
我们修改的时候可以用 user mapper 点 update by ID， 然后 user ID nickname， 然后 starts， 它会返回匹配的行数，要是它一行都不匹配，说明它提供的这个 user ID 就是无效的。诶，写错了 match 等于0，那这样的话我们就可以抛出提供了这个 user ID， 就没有这个。

说话人 1 01:42:00
用户抛出异常以后，这个异常会被全局异常处理器捕获，然后返回给前端这个请求的资源，不存在这个返回信息，现在我们连这个接口上的这个获取自己信息、获取指定用户信息，还有修改自己信息，这三个接口我们都写完了，我们在 control 里边学习了如何用 preauthenticated 来进行授权，还有如何用 authenticationprinciple 这个注解来提取当前请求的用户信息。

说话人 1 01:42:41
我们来测试一下，我们来启动一下这个 TOKEN， 我们要复制一下我们要用的，我们这三个接口，每接口都请求一遍，我们来到这个接口测试工具，我们先从获取自己的信息开始，我们点击这个运行在 header 里面，这个 authorization 就是写我们这个生成的 TOKEN， 把它粘过来，我们点击发送，看一看效果，发现。

说话人 1 01:43:13
这个就是我们设置的这个 user name， 但是它这个昵称和性别都是默认值，我们来这个获取指定用户信息也可以用我们运行一下，我们可以把 user ID 设为，诶，我们的用户 ID 是多少来着？我们来 user 用户 ID， 它是17，那我们把这个 user ID 就设置为17，然后在这个 header 里面带上我们这个 TOKEN， 然后点击发送，发现它这个也可以响应成我们这个。

说话人 1 01:43:51
数据库里的小明，我们再来看下修改自己的信息，修改自己信息，我们点击运行在这个 header 里面，这个 authorization 是要放到放我们之前获取这个 TOKEN， 这个 body 里面需要生成一些想改的参数，这个 sex， 行，我们先用3试一下，看看会有什么效果，会发现这个 sex 性别最大是2，这正是我们参数注解进行校验失败的结果。能把它改成-1，再试一下，改成负以后他说性别最小是。

说话人 1 01:44:30
0那我们把性别改成一，我们把这个名称写这么长，试一下，它说 nickname， 昵称最大长度是10，那我们就不写，用几个空格试一下，他说昵称不能为空，那我们就一定要写点字，现在再试一下，改成 h h h h。好，现在操作成功了。我们看一下数据库，确实改成了我们要的这个昵称是 HHHHH， 还有 sex 是一，我们的参数校验也是正常运行的，我们现在获取下自己的信息发送，发现我们这个 nickname 已经改了，这个 sex 也改了，说明我们这三个接口都写。