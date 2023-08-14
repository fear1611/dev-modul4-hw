package converter.example;

import converter.example.mbn.LogControl;
import converter.example.aspectj.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;


@Component
final class App {
     private App() {
     }
    public static void main(final String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        Converter converter = context.getBean("ConverterBean", Converter.class);

        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("converter.example.mbn:type=LogControl");
        LogControl mbean = new LogControl();
        mbs.registerMBean(mbean, name);

        Processor processor = new Processor(converter, mbean);
        processor.processUserInput();

        context.close();

    }
}
