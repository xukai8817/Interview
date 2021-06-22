package com.proxy.dynamic;

import java.lang.reflect.Proxy;

/**
 * @author xukai
 * @since 2021/6/21 11:29
 */
public class DynamicProxyTest {

    public static void main(String[] args) {
        DynamicProxyTest dynamicProxyTest = new DynamicProxyTest();
        // 被代理类
        Supplier jingdongSupplier = new JingdongSupplier();
        // 调度处理器
        JdkSupplierHandler handler = new JdkSupplierHandler(new JingdongSupplier());
        // 代理类实例
        Supplier proxyInstance = dynamicProxyTest.newProxyInstance(jingdongSupplier, handler);
        proxyInstance.sendPackage("顺丰");
    }

    public Supplier newProxyInstance(Object object, JdkSupplierHandler handler) {
        return (Supplier) Proxy
            .newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), handler);
    }

}
