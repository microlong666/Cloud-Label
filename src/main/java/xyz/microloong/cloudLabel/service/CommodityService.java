package xyz.microloong.cloudLabel.service;

import org.springframework.stereotype.Service;
import xyz.erupt.annotation.fun.DataProxy;
import xyz.erupt.core.exception.EruptWebApiRuntimeException;
import xyz.microloong.cloudLabel.model.esl.CommodityList;

/**
 * CommodityList 操作行为代理
 *
 * @author MicroLOONG
 * @date 2021-2-13
 */
@Service
public class CommodityService implements DataProxy<CommodityList> {

    @Override
    public void beforeAdd(CommodityList commodity) {
        if (commodity.getSalePrice() != null && commodity.getSalePrice().compareTo(commodity.getPrice()) > 0) {
            throw new EruptWebApiRuntimeException("请检查促销价");
        }
        if (commodity.getSaleBegin() != null && commodity.getSaleEnd() != null && commodity.getSaleBegin().after(commodity.getSaleEnd())) {
            throw new EruptWebApiRuntimeException("请选择恰当的促销日期");
        }

        if (commodity.getSalePrice() == null || commodity.getSaleBegin() == null || commodity.getSaleEnd() == null) {
            if (commodity.getSaleCondition()) {
                throw new EruptWebApiRuntimeException("请填写完整促销信息");
            }
        } else {
            if (!commodity.getSaleCondition()) {
                commodity.setSaleCondition(true);
            }
        }
    }

    @Override
    public void beforeUpdate(CommodityList commodity) {
        beforeAdd(commodity);
    }
}
