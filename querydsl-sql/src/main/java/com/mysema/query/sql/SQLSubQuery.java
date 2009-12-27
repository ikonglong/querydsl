/*
 * Copyright (c) 2009 Mysema Ltd.
 * All rights reserved.
 * 
 */
package com.mysema.query.sql;

import com.mysema.query.DefaultQueryMetadata;
import com.mysema.query.QueryMetadata;
import com.mysema.query.QueryMixin;
import com.mysema.query.support.QueryBaseWithDetach;
import com.mysema.query.types.expr.EBoolean;
import com.mysema.query.types.path.PEntity;

/**
 * @author tiwe
 *
 */
public class SQLSubQuery extends QueryBaseWithDetach<SQLSubQuery>{

    public SQLSubQuery() {
        this(new DefaultQueryMetadata());
    }
    
    public SQLSubQuery(QueryMetadata metadata) {
        super(new QueryMixin<SQLSubQuery>(metadata));
        this.queryMixin.setSelf(this);
    }
        
    public SQLSubQuery from(PEntity<?>... args){
        return queryMixin.from(args);
    }
    
    public SQLSubQuery fullJoin(PEntity<?> target) {
        return queryMixin.fullJoin(target);
    }
    
    public SQLSubQuery innerJoin(PEntity<?> target) {
        return queryMixin.innerJoin(target);
    }
    
    public SQLSubQuery join(PEntity<?> target) {
        return queryMixin.join(target);
    }
    
    public SQLSubQuery leftJoin(PEntity<?> target) {
        return queryMixin.leftJoin(target);
    }
    
    public SQLSubQuery on(EBoolean... conditions){
        return queryMixin.on(conditions);
    }
    
    @Override
    public String toString(){
        if (!queryMixin.getMetadata().getJoins().isEmpty()){
            SQLSerializer serializer = new SQLSerializer(SQLTemplates.DEFAULT);
            serializer.serialize(queryMixin.getMetadata(), false);
            return serializer.toString().trim();
        }else{
            return super.toString();
        }        
    }
}
