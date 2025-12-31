package sa.edu.kau.fcit.cpit252;

import org.junit.jupiter.api.Test;
import sa.edu.kau.fcit.cpit252.logger.formatter.*;
import sa.edu.kau.fcit.cpit252.logger.handlers.BaseLogger;
import sa.edu.kau.fcit.cpit252.logger.handlers.ConsoleLogger;
import sa.edu.kau.fcit.cpit252.logger.handlers.DatabaseLogger;
import sa.edu.kau.fcit.cpit252.logger.handlers.FileLogger;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

public class Lab6Test {

    // FormatDecorator should be an abstract class, extends BaseLogger, and has an abstract method called getLabel()
    @Test
    public void shouldHaveDecoratorAbstractClass(){
        // 1. abstract class FormatDecorator extends BaseLogger
        assertTrue(Modifier.isAbstract(FormatDecorator.class.getModifiers())); // abstract
        assertEquals(BaseLogger.class, FormatDecorator.class.getSuperclass()); // extends FormatDecorator
        // 2. abstract String getLabel();
        Method method = FormatDecorator.class.getDeclaredMethods()[0];
        assertEquals(0, method.getParameterCount());
        assertTrue(Modifier.isAbstract(method.getModifiers()));
        assertTrue(method.getName().equalsIgnoreCase("getLabel"));
    }

    // BaseLogger should be an abstract class, and has an abstract method called getLevel()
    @Test
    public void shouldHaveBaseLoggerAbstractClass(){
        // 1. abstract class BaseLogger
        assertTrue(Modifier.isAbstract(BaseLogger.class.getModifiers())); // abstract
        // 2. should have two methods: abstract String getLevel() AND String getLabel()
        for(Method method : BaseLogger.class.getDeclaredMethods()){
            if(method.getName().equalsIgnoreCase("getLevel")){
                assertEquals(0, method.getParameterCount());
                assertTrue(Modifier.isAbstract(method.getModifiers()));
                assertTrue(Modifier.isPublic(method.getModifiers()));
                assertEquals(String.class.getTypeName(), method.getReturnType().getTypeName());

            } else if(method.getName().equalsIgnoreCase("getLabel")){
                assertEquals(0, method.getParameterCount());
                assertTrue(Modifier.isPublic(method.getModifiers()));
                assertEquals(String.class.getTypeName(), method.getReturnType().getTypeName());
            }
        }
    }

    @Test
    public void shouldHaveConcreteHandlers(){
        // Should have ConsoleLogger, DatabaseLogger, and FileLogger
        Class<? extends BaseLogger>[] subClasses = new Class[] { ConsoleLogger.class, DatabaseLogger.class, FileLogger.class };
        for(Class<?> c : subClasses){
            assertEquals(BaseLogger.class, c.getSuperclass()); // extends FormatDecorator
            assertEquals(1, c.getDeclaredMethods().length);
            Method method = c.getDeclaredMethods()[0];
            assertEquals(0, method.getParameterCount());
            assertFalse(Modifier.isAbstract(method.getModifiers()));
            assertTrue(Modifier.isPublic(method.getModifiers()));
            assertTrue(method.getName().equalsIgnoreCase("getLevel"));
        }
    }

    @Test
    public void shouldHaveConcreteFormatters(){
        // Should have CSVFormatter, HTMLFormatter, JSONFormatter, and YAMLFormatter
        Class<? extends FormatDecorator>[] subClasses = new Class[] { CSVFormatter.class, HTMLFormatter.class,
                JSONFormatter.class, YAMLFormatter.class };
        for(Class<?> c : subClasses){
            assertEquals(FormatDecorator.class, c.getSuperclass()); // extends FormatDecorator
            assertEquals(2, c.getDeclaredMethods().length);
            for(Method m: c.getDeclaredMethods()){
                assertTrue(m.getName().equalsIgnoreCase("getLevel") || m.getName().equalsIgnoreCase("getLabel"));
                assertEquals(0, m.getParameterCount());
                assertFalse(Modifier.isAbstract(m.getModifiers()));
                assertTrue(Modifier.isPublic(m.getModifiers()));
            }
        }

    }

    @Test
    public void shouldLogWithMultipleFormatters()
    {
        // create a console logger
        BaseLogger logger = new ConsoleLogger();
        // decorate it with a CSV and HTML formatters
        logger = new CSVFormatter(logger);
        logger = new HTMLFormatter(logger);
        assertTrue(logger.getLabel().contains("Console"));
        assertTrue(logger.getLabel().contains("CSVFormatter"));
        assertTrue(logger.getLabel().contains("HTMLFormatter"));
        assertTrue(logger.getLevel().toLowerCase().contains("info"));
    }
}
