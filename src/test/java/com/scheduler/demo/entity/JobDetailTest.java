package com.scheduler.demo.entity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
public class JobDetailTest {

    

    @Test
    public void test_DTO_or_Model_data_Parameters() throws Exception {
    	String packageName="com.scheduler.demo.entity";
    	InputStream stream = ClassLoader.getSystemClassLoader()
    	          .getResourceAsStream(packageName.replaceAll("[.]", "/"));
    	        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
    	        Set<Class> clset= reader.lines().filter(line -> line.endsWith(".class")).map(line -> getClass(line, packageName)).collect(Collectors.toSet());
      clset.forEach(cl->{    	  
        	for (Method m : cl.getMethods()) {
                if (m.getName().startsWith("set")) {
                    System.out.println(String.format("", m.getName()));
                    
                }else {
                	System.out.println(String.format("", m.getName()));
                }
        }
        });
    }
    private Class getClass(String className, String packageName) {
        try {
            return Class.forName(packageName + "."
              + className.substring(0, className.lastIndexOf('.')));
        } catch (ClassNotFoundException e) {
            // handle the exception
        }
        return null;
    }
}
