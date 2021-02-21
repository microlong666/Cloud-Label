package xyz.microloong.cloudLabel.service;

import org.springframework.stereotype.Service;
import xyz.erupt.annotation.fun.DataProxy;
import xyz.microloong.cloudLabel.model.esl.ESL;
import xyz.microloong.cloudLabel.util.RandomMac;


/**
 * ESL 操作行为代理
 *
 * @author MicroLOONG
 * @date 2021-2-21
 */
@Service
public class ESLService implements DataProxy<ESL> {

    /**
     * 仅作演示用途
     */
    private final static String[] RSSI = {"强", "中", "弱"};

    RandomMac mac = new RandomMac();

    @Override
    public void afterAdd(ESL esl) {
        if (esl.getStatus()) {
            esl.setMacAddress(mac.randomMac());
            esl.setRssi(RSSI[(int) (Math.random() * 3)]);
            esl.setSoc((int) (Math.random() * 101) + "%");
        }
    }

    @Override
    public void afterUpdate(ESL esl) {
        if (esl.getStatus()) {
            if (esl.getMacAddress() == null) {
                esl.setMacAddress(mac.randomMac());
            }
            if (esl.getRssi() == null) {
                esl.setRssi(RSSI[(int) (Math.random() * 3)]);
            }
            if (esl.getSoc() == null) {
                esl.setSoc((int) (Math.random() * 101) + "%");
            }
        }
    }
}
