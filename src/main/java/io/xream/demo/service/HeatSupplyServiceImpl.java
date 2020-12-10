package io.xream.demo.service;

import io.xream.demo.bean.HeatSupply;
import io.xream.demo.repository.HeatSupplyRepository;
import io.xream.sqli.builder.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author Sim
 */
@Service
public class HeatSupplyServiceImpl implements HeatSupplyService{

    @Autowired
    private HeatSupplyRepository repository;
    @Override
    public boolean create(HeatSupply heatSupply) {
        return this.repository.create(heatSupply);
    }

    @Override
    public boolean create(List<HeatSupply> list) {
        return this.repository.createBatch(list);
    }

    @Override
    public List<Map<String,Object>> find(Criteria.ResultMapCriteria criteria) {
        return this.repository.list(criteria);
    }
}
