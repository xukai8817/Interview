package com.proxy.dynamic;

/**
 * @author xukai
 * @since 2021/6/21 11:25
 */
public class JingdongSupplier implements Supplier {

    @Override
    public void sendPackage(String packageName) {
        System.out.println("京东供应商发送包裹：" + packageName);
    }
}
