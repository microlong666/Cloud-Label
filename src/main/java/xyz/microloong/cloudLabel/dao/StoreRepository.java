package xyz.microloong.cloudLabel.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.microloong.cloudLabel.model.esl.Store;

import java.util.List;

/**
 * JPA CRUD接口
 * Store 门店类
 *
 * @author MicroLOONG
 * @date 2021-2-21
 */
public interface StoreRepository extends JpaRepository<Store, Long> {

    /**
     * 根据门店名查找门店
     *
     * @param storeName 门店名
     * @return 门店信息
     */
    List<Store> findByStoreName(String storeName);

}
