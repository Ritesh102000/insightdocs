package com.ritesh.insightdocs.model;

public enum OrgPlan {
    FREE(10,10,100),
    PRO(50,50,5000),
    ENTERPRISE(-1,-1,-1);

    private final int maxUsers;
    private final int maxDocuments;
    private final int maxQueriesPerUserPerMonth;

    OrgPlan(int maxUsers, int maxDocuments, int maxQueriesPerUserPerMonth) {
    this.maxUsers = maxUsers;
    this.maxDocuments = maxDocuments;
    this.maxQueriesPerUserPerMonth = maxQueriesPerUserPerMonth;
}
    public int getMaxUsers(){
        return this.maxUsers;
    }
    public int getMaxDoc(){
        return this.maxDocuments;
    }
    public int getMaxQueries(){
        return this.maxQueriesPerUserPerMonth;
    }

    
}
