package com.gself.study.jpattern;

import com.gself.study.jpattern.proxy.Developer;
import com.gself.study.jpattern.proxy.JavaDeveloper;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author:gtt
 * @Description
 * @Date: 2020/1/20 14:39
 */
public class ProxyDemoTest {

    /**
     * 代理模式测试
     */
    @Test
    public void test01(){
        JavaDeveloper jdl = new JavaDeveloper();
        Developer dl =(Developer) Proxy.newProxyInstance(JavaDeveloper.class.getClassLoader(), JavaDeveloper.class.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("========proxy demo");
                return method.invoke(jdl,args);
            }
        });
        dl.code();
    }
}
