package sample;

import javax.tools.ToolProvider;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;

public class JavaClassExecutorUtil {
    public static void executeJavaClassFromString(String className, String javaSourceCodeAsString) throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException, MalformedURLException {

        var compiler = ToolProvider.getSystemJavaCompiler();
        var fileObjects = new ArrayList<JavaSourceFromString>();
        fileObjects.add(new JavaSourceFromString(className, javaSourceCodeAsString));
        var options = Arrays.asList("-d","classesGeneratedByEditor");
        compiler.getTask(null, null, null, options, null, fileObjects).call();

        URL[] urls = new URL[]{new File("classesGeneratedByEditor").toURI().toURL()};
        var urlClassLoader = new URLClassLoader(urls);
        var classes = urlClassLoader.loadClass(className);
        var m = classes.getMethod("main", new Class[]{String[].class});
        var _args = new Object[]{new String[0]};
        m.invoke(null, _args);
    }
}
