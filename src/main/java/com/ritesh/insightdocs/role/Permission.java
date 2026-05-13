package com.ritesh.insightdocs.role;

//This is a enum acts like a class 
public enum Permission {
    QUERY_DOCUMENT(1L << 0), // 1
    UPLOAD_DOCUMENT(1L << 1), // 2
    DELETE_DOCUMENT(1L << 2), // 4
    MANAGE_DOCUMENT(1L << 3), // 8
    INVITE_USER(1L << 4), // 16
    REMOVE_USER(1L << 5), // 32
    MANAGE_ROLES(1L << 6), // 64
    MANAGE_ORG(1L << 7), // 128
    VIEW_ANALYTICS(1L << 8), // 256
    MANAGE_BILLING(1L << 9); // 512

    private final long value;

    Permission(long value) {
        this.value = value;
    }

    public long getValue() {
        return this.value;
    }

    public static long combine(Permission... permissions) {
        long result = 0;
        for (Permission p : permissions) {
            result = result | p.getValue();
        }
        return result;
    }

    public static long remove(long result,Permission... permissions) {
        
        for (Permission p : permissions) {
            result = result & ~p.getValue();
        }
        return result;
    }

}