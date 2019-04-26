package com.review.primary.hbase.auto;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.hadoop.hbase.HbaseTemplate;

/**
 * 
 * @ClassName:  HbaseAutoConfiguration   
 * @Description: HbaseTemplate自动配置类  
 * @author: 纵横-review
 * @date:   Apr 26, 2019 3:44:07 PM   
 */

@Configuration
@ConditionalOnClass(HbaseTemplate.class)
@EnableConfigurationProperties(HbaseProperties.class)
public class HbaseAutoConfiguration 
{
    private static Logger LOG = LoggerFactory.getLogger(HbaseAutoConfiguration.class);
    
    private static final String HBASE_QUORUM = "hbase.zookeeper.quorum";
    private static final String HBASE_ROOTDIR = "hbase.rootdir";
    private static final String HBASE_ZNODE_PARENT = "zookeeper.znode.parent";
    
	
	@Autowired
	private HbaseProperties hbaseProperties;
	
    @Bean
    @ConditionalOnMissingBean
    public HbaseTemplate createHbaseTemplate()
    {
    	    LOG.info("Hbase自动配置【Start】");
      	org.apache.hadoop.conf.Configuration config = HBaseConfiguration.create();
      	// zookeeper 地址
      	config.set(HBASE_QUORUM,hbaseProperties.getQuorum());
      	// Hdfs的路径
      	config.set(HBASE_ROOTDIR,hbaseProperties.getRootDir());
      	// zookeeper中的hbase存储路径
      	config.set(HBASE_ZNODE_PARENT,hbaseProperties.getNodeParent());
      	HbaseTemplate template = new HbaseTemplate(config);
	    LOG.info("Hbase自动配置【End】");
      	return template;
    }
}
