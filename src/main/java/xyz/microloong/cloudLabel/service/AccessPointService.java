package xyz.microloong.cloudLabel.service;

import org.springframework.stereotype.Service;
import xyz.erupt.annotation.fun.DataProxy;
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

    RandomMac mac = new RandomMac();

    @Override
    public void afterAdd(AccessPoint accessPoint) {
        if (accessPoint.getStatus()) {
            accessPoint.setMacAddress(mac.randomMac());
        }
        if (accessPoint.getEslNum() == null) {
            accessPoint.setEslNum(0);
        }
    }

    @Override
    public void afterUpdate(AccessPoint accessPoint) {
        if (accessPoint.getStatus() && accessPoint.getMacAddress() == null) {
            accessPoint.setMacAddress(mac.randomMac());
        }
    }
}
