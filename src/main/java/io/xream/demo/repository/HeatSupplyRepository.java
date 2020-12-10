package io.xream.demo.repository;

import io.xream.demo.bean.HeatSupply;
import io.xream.sqli.api.BaseRepository;
import io.xream.sqli.api.ResultMapRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author Sim
 */
@Repository
public interface HeatSupplyRepository extends BaseRepository<HeatSupply>, ResultMapRepository {
}
