package com.rdr.sglserverjava.security;

public final class TenantContext {

    private static final ThreadLocal<Integer> tenantId = new InheritableThreadLocal<>();

    public static void setTenantId(int id) {
        System.out.println("setTenantId =" + id);
        tenantId.set(id);
    }

    public static int getTenantId() {
        var id = tenantId.get();
        System.out.println("getTenantId =" + id);
        return id;
    }

    public static void clearTenantId() {
        tenantId.remove();
    }
    
}
