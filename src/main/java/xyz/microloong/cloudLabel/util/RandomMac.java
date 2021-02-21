package xyz.microloong.cloudLabel.util;

import java.util.Random;

/**
 * 随机生成 MAC 地址
 *
 * @author MicroLOONG
 * @date 2021-2-21
 */
public class RandomMac {

    private static final String SEPARATOR_OF_MAC = ":";

    public String randomMac() {
        Random random = new Random();
        String[] mac = {
                String.format("%02x", random.nextInt(0xff)),
                String.format("%02x", random.nextInt(0xff)),
                String.format("%02x", random.nextInt(0xff)),
                String.format("%02x", random.nextInt(0xff)),
                String.format("%02x", random.nextInt(0xff)),
                String.format("%02x", random.nextInt(0xff))
        };
        return String.join(SEPARATOR_OF_MAC, mac);
    }
}
