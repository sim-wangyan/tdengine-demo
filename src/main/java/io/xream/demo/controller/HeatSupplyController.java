package io.xream.demo.controller;

import io.xream.demo.bean.HeatSupply;
import io.xream.demo.service.HeatSupplyService;
import io.xream.sqli.builder.Criteria;
import io.xream.sqli.builder.CriteriaBuilder;
import io.xream.sqli.builder.ReduceType;
import io.xream.x7.base.util.StringUtil;
import io.xream.x7.base.web.ViewEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author Sim
 */
@RestController
@RequestMapping("/heatsupply")
public class HeatSupplyController {

    @Autowired
    private HeatSupplyService service;

    @RequestMapping(value = "/create")
    public ViewEntity create() {

        HeatSupply heatSupply = new HeatSupply();
        heatSupply.setId(System.currentTimeMillis());
        heatSupply.setCity("北京市");
        heatSupply.setZone("朝阳区");
        heatSupply.setSn("H100003");
        heatSupply.setValue(new BigDecimal(15));

        HeatSupply heatSupply1 = new HeatSupply();
        heatSupply1.setId(System.currentTimeMillis());
        heatSupply1.setCity("北京市");
        heatSupply1.setZone("海淀区");
        heatSupply1.setSn("H100004");
        heatSupply1.setValue(new BigDecimal(16));

        List<HeatSupply> list = new ArrayList<>();
        list.add(heatSupply);
        list.add(heatSupply1);

        this.service.create(list);

        return ViewEntity.ok();
    }

    @RequestMapping(value = "/find/{interval}", method = RequestMethod.GET)
    public ViewEntity find(@PathVariable String interval) {

        CriteriaBuilder.ResultMapBuilder criteriaBuilder = CriteriaBuilder.resultMapBuilder();
        criteriaBuilder.reduce(ReduceType.SUM, "value");
        criteriaBuilder.eq("city","北京市").eq("zone","朝阳区");
//        criteriaBuilder.xAggr("INTERVAL(?)", interval); //报语法错误 INTERVAL('2s'), 等TDengine官方支持
        if (StringUtil.isNotNull(interval)) {//需要显示判断是否为null
            criteriaBuilder.xAggr("INTERVAL(" + interval + ")");//INTERVAL(2s)
        }

        criteriaBuilder.paged().page(1).rows(10).ignoreTotalRows();
        Criteria.ResultMapCriteria criteria = criteriaBuilder.build();

        List<Map<String,Object>> list = this.service.find(criteria);

        return ViewEntity.ok(list);
    }
}
