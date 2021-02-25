package xyz.microloong.cloudLabel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.erupt.annotation.fun.DataProxy;
import xyz.microloong.cloudLabel.dao.EslRepository;
import xyz.microloong.cloudLabel.model.esl.AccessPoint;
import xyz.microloong.cloudLabel.util.RandomMac;

/**
 * AccessPoint 操作行为代理
 *
 * @author MicroLOONG
 * @date 2021-2-21
 */
@Service
public class AccessPointService implements DataProxy<AccessPoint> {

    @Autowired
    EslRepository esl;

    RandomMac mac = new RandomMac();

    @Override
    public void afterAdd(AccessPoint accessPoint) {
        if (accessPoint.getStatus()) {
            accessPoint.setMacAddress(mac.randomMac());
        }
        accessPoint.setEslNum(esl.connectedAp(accessPoint.getId()));
    }

    @Override
    public void afterUpdate(AccessPoint accessPoint) {
        if (accessPoint.getStatus() && accessPoint.getMacAddress() == null) {
            accessPoint.setMacAddress(mac.randomMac());
        }
        accessPoint.setEslNum(esl.connectedAp(accessPoint.getId()));
    }
}
