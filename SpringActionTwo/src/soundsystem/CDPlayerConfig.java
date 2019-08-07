package soundsystem;

import org.springframework.context.annotation.ComponentScan;

import org.springframework.context.annotation.Configuration;

@Configuration //标注了这是一个配置类,等同于xml配置
//这是一个扫描包的类,若是没有指定包,会扫描此类所在的包,可加载多个包,basePackages为复数形式
@ComponentScan (basePackageClasses= {SgtPeppers.class,CDPlayerTest.class}) 
public class CDPlayerConfig {

}
