package io.xream.demo.service;

import io.xream.demo.bean.HeatSupply;
import io.xream.sqli.builder.Criteria;

import java.util.List;
import java.util.Map;

/**
 * @Author Sim
 */
public interface HeatSupplyService {

    boolean create(HeatSupply heatSupply);

    boolean create(List<HeatSupply> list);

    List<Map<String,Object>> find(Criteria.ResultMapCriteria criteria);
}
