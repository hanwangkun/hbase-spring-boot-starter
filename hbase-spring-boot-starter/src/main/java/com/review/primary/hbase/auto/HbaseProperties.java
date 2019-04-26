package com.review.primary.hbase.auto;

import org.springframework.boot.context.properties.ConfigurationProperties;
/**
 * 
 * @ClassName:  HbaseProperties   
 * @Description: Hbase属性  
 * @author: 纵横-review
 * @date:   Apr 26, 2019 3:43:20 PM   
 */
@ConfigurationProperties(value = "spring.review.hbase")
public class HbaseProperties 
{
    private String quorum;

    private String rootDir;

    private String nodeParent;

    public String getQuorum() {
        return quorum;
    }

    public void setQuorum(String quorum) {
        this.quorum = quorum;
    }

    public String getRootDir() {
        return rootDir;
    }

    public void setRootDir(String rootDir) {
        this.rootDir = rootDir;
    }

    public String getNodeParent() {
        return nodeParent;
    }

    public void setNodeParent(String nodeParent) {
        this.nodeParent = nodeParent;
    }
}
