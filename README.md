# tdengine-demo
TDengine ORM demo


## ORM 框架 
   [SQLI](http://sqli.xream.io)
   ```xml        
       <dependency>
            <groupId>io.xream.x7</groupId>
            <artifactId>x7-spring-boot-starter</artifactId>
            ....
       </dependency>
   ```

## 实体类注解
    public class HeatSupply {

        @X.Key
        private Long id; //System.currentTimeMillis()
        private BigDecimal value;
        @X.Tag
        private String city;
        @X.Tag
        private String zone;
        @X.TagTarget //标注sn作为子表名后缀
        private String sn;
        
        ....
       
##  Repository 
    @Repository
    public interface HeatSupplyRepository extends BaseRepository<HeatSupply>, ResultMapRepository {}
    
## 插入
        HeatSupply heatSupply = new HeatSupply();
        heatSupply.setId(System.currentTimeMillis());
        heatSupply.setCity("北京市");
        heatSupply.setZone("朝阳区");
        heatSupply.setSn("H100003");
        heatSupply.setValue(new BigDecimal(15));
        
        this.heatSupplyRepository.create(heatSupply);
        
## 查找
        CriteriaBuilder.ResultMapBuilder criteriaBuilder = CriteriaBuilder.resultMapBuilder();
        criteriaBuilder.reduce(ReduceType.SUM, "value");
        criteriaBuilder.eq("city","北京市").eq("zone","朝阳区");
        //criteriaBuilder.xAggr("INTERVAL(?)", interval); //报语法错误 INTERVAL('2s'), 等TDengine官方支持
        if (StringUtil.isNotNull(interval)) {//需要显示判断是否为null
            criteriaBuilder.xAggr("INTERVAL(" + interval + ")");//INTERVAL(2s)
        }

        criteriaBuilder.paged().page(1).rows(10).ignoreTotalRows();
        
        Criteria.ResultMapCriteria criteria = criteriaBuilder.build();

        List<Map<String,Object>> list = this.heatSupplyRepository.find(criteria);
        
        