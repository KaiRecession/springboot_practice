### 注解

分清注解和注释，注解是给计算机看的，而注释是给程序员看的。注解也叫元数据

注解的本质是一个接口，只不过使用方式有一点特别而已，默认继承Annotation接口

注解（接口）中的抽象方法**必须有规定好的返回值类型**（不能为void，不能是自定义的类或者接口（但可以是注解接口））

注解可以套注解（有些注解是核心类已经规定好的直接用），就像接口能继承其它接口一样

注解就好像一个可以附着在其它类上面的接口，当定义好他的生效范围和接口中需要设置的值，可以直接通过class对象读取生成一个这个注解的接口对象，从而获取到注解里面的相关信息给程序。一个注解就代表一个注解的接口对象

当使用注解时只用到了注解的value（每个注解必须有）抽象方法的时候，value前缀可以省略（使用的时候，其他的抽象方法都有默认的返回值）

接口中的被default修饰：

​	普通的接口的default关键字在前面，是默认将方法实现，这样就相当于抽象类，但是它可以实现多继承。

​	注解这个特殊的接口，default关键字在后面，表示默认的返回值，大括号表示返回值是一个数组或者集合，普	通接口的大括号肯定就是代表方法体

```java
例子：@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
TYPE：接口、类、枚举、注解
FIELD:字段枚举的常量
METHOD：方法
PARAMETER：方法参数
CONSTRUCTOR：构造函数
LOCAL_VARIABLE：局部变量
ANNOTATION_TYPE：注解
PACKAGE：包
TYPE_PARAMETER：参数类型声明
TYPE_USE：使用的类型
```

```java
@Retention(RetentionPolicy.RUNTIME)
```

| RetentionPolicy.SOURCE  | 表示注解只保留在源文件，当java文件编译成class文件，就会消失  | 源文件            | 只是做一些检查性的操作，，比如 @Override 和 @SuppressWarnings |
| ----------------------- | ------------------------------------------------------------ | ----------------- | ------------------------------------------------------------ |
| RetentionPolicy.CLASS   | 注解被保留到class文件，但jvm加载class文件时候被遗弃，这是默认的生命周期 | class文件（默认） | 要在编译时进行一些预处理操作，比如生成一些辅助代码（如 ButterKnife） |
| RetentionPolicy.RUNTIME | 注解不仅被保存到class文件中，jvm加载class文件之后，仍然存在  | 运行时也存在      | 需要在运行时去动态获取注解信息                               |

### Spring两大特性：IOC && DI

#### IOC（Inversion Of Control反转控制）

耦合性高的都是直接new对象，现在是问工厂要，工厂会创造返回我们想要的对象。

工厂创造出来的对象放在map中，这个map就被称为容器

同时，程序将new对象的权利交由工厂，这就是控制反转，其实是控制权转移

我觉得Spring容器的存在让这些层间依赖的对象全部交由Spring来进行管理，这就很nice，防止程序的乱引用的对象的大量创建，反正好处多多

#### DI（Dependency Injection依赖注入）

依赖注入说白了就是来管理对象之间的依赖，因为两个对象之间难免有依赖，既然对象创建权利交给你了，那么依赖关系你也要给我维护

但是依赖注入的本质就是给参数赋值，如果一个对象的成员是另一个对象（依赖关系），那么就是给这个成员的赋值方法变成使用在配置文件中配置过的 bean进行赋值!

### Spring 常用注解

* @Controller @Service @Repository和@Component作用是一样的，只不过是为了区别一下三层架构。直接放在类名上面，vlaue就是id值。如果不写，默认就是类名的首字母小写值

  * @Controller：一般用于表现层的注解。

    @Service：一般用于业务层的注解。

    @Repository：一般用于持久层的注解。

* @Autowired：

  * 首先明白，Spring的Ioc容器里面的对象，只要是单例（多例也行）的，只要被注解了，那么加载xml文件或者扫描带有注解的包的时候，对象就会都被放在容器里面，而且是以Map集合的方式，id就是他的key
  * 标签是放在类的成员变量上的，自动注入，**不需要set方法**，首先，它会去IOC容器里面找类型和添加注解的属性（对象的属性，成员变量等）一样的bean（所有向上转型能转成本类的都算，搞一个object类都能配上59个bean，离谱），如果找到一个，那么就注入成功。**如果找到多个，就查看有没有id（Map的key）和成员变量名一样的**，如果有，则注入成功，否则报异常
  * 名字、类型都很重要。最好名字和注解写的key一样，那就肯定能成功
  * 不管是单例、多例的作用范围，自动注入都会按照规则拿到对象进行注入的
  * 有三种注入方式，构造函数、setter和属性注入。不推荐属性注入了已经。使用构造函数注入的时候，如果只有一个构造函数，可以省略autowired。由多个构造函数，容器会默认使用无参构造方法，加上autowired，容器就会去使用这个有参的构造了，也就可以注入了。setter建议加上autowired。优点就是解决执行顺序问题等

* @Qualifier：

  * 就是为了弥补@Autowired标签的报错，当不能自动注入了就寻找这个标签的id。
  * 必须和@Autowired配合才能使用

* @Resource：

  * 不使用自动注入，直接按照id注入

* @Value：

  * 上面三个标签都是注入引用数据类型的，这个标签才是用来注入基本数据类型和String类型数据
  * 这个标签，可以直接给对象的赋值，但Value就是要存在，体会一下

* @Scope：

  * 改变作用范围，就是对象是单例的，还是多例的
  * @Scope("prototype")//多实例，**IOC容器启动创建的时候，并不会创建对象放在容器在容器当中，当你需要的时候，需要从容器当中取该对象的时候，就会创建**。
    @Scope("singleton")//单实例 ，**IOC容器启动的时候就会调用方法创建对象，以后每次获取都是从容器当中拿同一个对象**（map当中）。
    @Scope("request")//同一个请求创建一个实例
    @Scope("session")//同一个session创建一个实例

* @PostConstruct：指定初始化方法

* @PreDestroy：指定销毁方法

* @Bean：**写在方法上**，表明用这个方法创建一个对象，并且放在容器里面

* @Import：用于导入其他配置类，比如jar包里面的对象导入进来放入容器里面

* 通过注解获取容器：

  ```xml
  ApplicationContext ac = 
  new AnnotationConfigApplicationContext(SpringConfiguration.class);
  ```

* @ServletComponentScan
  * SpringBootApplication 上使用@ServletComponentScan 注解后
    Servlet可以直接通过@WebServlet注解自动注册
    Filter可以直接通过@WebFilter注解自动注册
    Listener可以直接通过@WebListener 注解自动注册
  * 不使用这个注解，其他的requestMapping也能正常使用，就是单纯的上面几种不能使用

* @Mapper
  * 在接口类上添加了@Mapper，在编译之后会生成相应的接口实现类，并将实现类生成对象交给spring容器
  * 添加位置：接口类上面
* @MapperScan
  * 指定要变成实现类的接口所在的包，包下面的所有接口在编译之后都会生成相应的实现类，并将实现类生成对象交给spring容器
  * 添加位置：是在Springboot启动类上面添加，