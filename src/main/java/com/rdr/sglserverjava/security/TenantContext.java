package com.rdr.sglserverjava.security;

public final class TenantContext {

    private static final ThreadLocal<Long> tenantId = new InheritableThreadLocal<>();

    public static void setTenantId(Long id) {
        System.out.println("setTenantId =" + id);
        tenantId.set(id);
    }

    public static Long getTenantId() {
        var id = tenantId.get();
        System.out.println("getTenantId =" + id);
        return id;
    }

    public static void clearTenantId() {
        tenantId.remove();
    }
    
}
