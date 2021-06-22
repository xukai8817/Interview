package com.proxy.dynamic;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author xukai
 * @since 2021/6/21 11:27
 */
public class JdkSupplierHandler implements InvocationHandler {

    private Supplier supplier;

    public JdkSupplierHandler(Supplier supplier) {
        this.supplier = supplier;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("准备发送包裹");
        return method.invoke(supplier, args);
    }
}
