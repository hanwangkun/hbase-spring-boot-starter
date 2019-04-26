# hbase-spring-boot-starter
Hbase与springboot的自动配置整合


##使用说明
### 1、引入项目依赖：

		<dependency>
			<groupId>com.reivew.primary</groupId>
			<artifactId>hbase-spring-boot-starter</artifactId>
			<version>1.0.0</version>
		</dependency>

----------

### 2、在application.yml或application.properties或Apollo配置中心中添加如下配置：

    spring.review.hbase.quorum = namenode,SecondaryNameNode,datanode2,datanode3
    spring.review.hbase.rootDir = hdfs://namenode:9820/hbase
    spring.review.hbase.nodeParent = /hbase

----------


### 3、在项目使用:直接注入HbaseTemplate
    @RequestMapping(value = "/hbase")
    @RestController
    public class HbaseRest {
        private static Logger LOG = LoggerFactory.getLogger(HbaseRest.class);
        @Resource
        private HbaseTemplate hbaseTemplate;
        
----------

这样就可以完成hbase与SpringBoot的自动化配置集成。
