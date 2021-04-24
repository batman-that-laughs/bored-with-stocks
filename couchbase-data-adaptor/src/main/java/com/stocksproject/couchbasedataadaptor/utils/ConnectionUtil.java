package com.stocksproject.couchbasedataadaptor.utils;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.Collection;
import com.couchbase.client.java.Scope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ConnectionUtil {

    @Autowired
    private Environment environment;

    private static Cluster clusterObject = null;

    private Cluster getClusterObject(){
        if(null == clusterObject) {
            String connectionString = environment.getProperty("couchbase-config.url");
            String username = environment.getProperty("couchbase-config.auth.username");
            String password = environment.getProperty("couchbase-config.auth.password");
            clusterObject = Cluster.connect(connectionString, username, password);
        }
        return clusterObject;
    }

    public Bucket getBucket(String bucketName){
        return this.getClusterObject().bucket(bucketName);
    }

    public Scope getScope(String bucketName, String scopeName){
        return this.getClusterObject().bucket(bucketName).scope(scopeName);
    }

    public Collection getCouchbaseCollection(String bucketName, String scopeName, String collectionName){
        return this.getClusterObject().bucket(bucketName).scope(scopeName).collection(collectionName);
    }

}
