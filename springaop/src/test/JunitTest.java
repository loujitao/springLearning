import com.steve.autoware.ADao;
import com.steve.autoware.AService;
import com.steve.autoware.AutowareConfig;
import com.steve.beanlifeCycl.Computer;
import com.steve.beanlifeCycl.MyBeanLifeCyclConfig;
import com.steve.beanlifeCycl.MyConfigOfPropertyValues;
import com.steve.config.PackageScanConfig;
import com.steve.config.PersonConfigration;
import com.steve.config.RegistrarConfig;
import com.steve.entity.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @Description: TODO
 * @Author: SteveTao
 * @Date: 2020/2/1310:06
 **/
public class JunitTest {

    //测试包扫描和过滤规则注解
    @Test
    public void myTest01(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(PackageScanConfig.class);
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String n:names  ) {
            System.out.println(n);
        }
    }
    //测试包扫描和过滤规则注解
    @Test
    public void myTest02(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(PersonConfigration.class);
        System.out.println("IOC容器创建完成。。。");
        Person person = (Person) applicationContext.getBean("person");
        Person person2 = (Person) applicationContext.getBean("person");
        System.out.println(person==person2);
    }

    //测试conditional注解   再测试的VM中设置参数改变系统变量： -Dos.name=xx
    @Test
    public void myTest03(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(PersonConfigration.class);
        String[] names = applicationContext.getBeanNamesForType(Person.class);
        for (String n:names  ) {
            System.out.println(n);
        }
    }
    /**
     *  给容器中注册组件Bean
     **/
    @Test
    public void myTest04() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(RegistrarConfig.class);
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String n : names) {
            System.out.println(n);
        }
        Object parent  = applicationContext.getBean("parentFactoryBean");
        System.out.println(parent.getClass());
        Object parentFactoryBean = applicationContext.getBean("&parentFactoryBean");
        System.out.println(parentFactoryBean.getClass());
    }

    /**
     *   Bean的生命周期
     **/
    @Test
    public void myTest05() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyBeanLifeCyclConfig.class);
        applicationContext.getBean("sthing");
        applicationContext.close();
    }
    /**
     *          Bean属性赋值相关配置
     * @Value 可以写哪些参数：
     * 1、基本数据类型，直接赋值（ 默认值）
     * 2、spEl表达式 #{}  表达式赋值给属性
     * 3、可以写${ }  取得spring加载了的配置文件中的值（也是从spring环境中取值）
     **/
    @Test
    public void myTest06() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfigOfPropertyValues.class);
        Computer computer = (Computer) applicationContext.getBean("computer");
        System.out.println(computer);

        //spring加载的配置文件信息，会放到运行环境中
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        //从环境中获取配置文件的值
        String property = environment.getProperty("computer.name");
        System.out.println(property);
    }

    /**
     *   自动注入
     *  1、 @Autoware:
     *      1)默认优先按照类型从容器中找对应的组件：
     *          applicationContext.getBean(ADao.class);
     *      2)如果找到多个相同的，再将属性名作为组件ID去容器中找
     *           applicationContext.getBean("ADao");
     *      3)@Qualifier("aDao2"): 使用@Qualifier指定需要装配的组件ID，而不是使用属性名
     *      4）自动装配时，容器中一定要有默认类型的实体，没有找到会报错
     *          可以使用 @Autowired(required = false),没有找到不注入
     *      5）@Primary: 让spring进行自动装配时，默认使用首选的bean;
     *              也可以继续使用@Qualifier("aDao2")指定需要装配的bean名字
     **/
    @Test
    public void myTest07() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AutowareConfig.class);
        AService service = applicationContext.getBean(AService.class);
        System.out.println(service);
        ADao aDao = (ADao) applicationContext.getBean("ADao");
        System.out.println(aDao);
    }
    /**
     * Java规范提供的自动注入注解
     *  @Resource ： JSR250   功能单一
     *         可以和@Autoware一样实现自动装配，默认按照组件属性名称装配；
     *   @Inject: JSR330    和@autoware一样，没有requrie=true选项
     *          需要导入javax.inject包依赖
     * */
    /**
     * @Autowired： 除了属性，还可以用在构造器、参数、方法上； 都是从容器中装配组件
     *      1）标注再方法位置： @Bean方法 + 方法参数；  参数从容器获取，可以省略@Autowired注解
     *      2）标注在构造器上： 如果组件中只有一个有参构造器，构造器参数可以省略@Autowired，参数从容器中获取
     *      3) 放在参数位置： 一般放在@Bean方法的参数上，可省略；Set()的参数上
     */
    /**
     * 自定义组件想要使用Spring容器底层的一些组件（ applicationContext BeanFactory ...）
     *      自定义组件Bean实现xxxAware接口即可： 在创建对象的时候，会调用接口规定的方法注入容器底层的组件
     *      原理: 每个xxxAware接口对应一个xxxProcessor后置处理器，执行底层组件赋值功能
     *
     */
}
