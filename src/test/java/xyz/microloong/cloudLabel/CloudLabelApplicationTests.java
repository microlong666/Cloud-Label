package xyz.microloong.cloudLabel;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.microloong.cloudLabel.dao.StoreRepository;
import xyz.microloong.cloudLabel.model.esl.Store;

@SpringBootTest
public class CloudLabelApplicationTests {

    @Autowired
    private StoreRepository storeRepository;

    // 获取所有门店
    @Test
    void findStoreList() {
        for (Store store : storeRepository.findAll()) {
            System.out.println(store.toString());
        }
    }

    //根据门店名获取门店
    @Test
    void findStoreByStoreName() {
        for (Store store : storeRepository.findByStoreName("广百新一城店")) {
            System.out.println(store.toString());
        }
    }

    //删除
    @Test
    void deleteStore() {
//        storeRepository.deleteById(1L);
    }

    //新增门店 or 更新门店
    @Test
    void saveArticle() {
        Store store = new Store();
        store.setStoreName("佛大店");
        store.setAddress("南海区广云路33号仙溪湖畔");
        store.setPersonInCharge("MicroLOONG");
        store.setTel("0757");
        storeRepository.save(store);
    }
}
