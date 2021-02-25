package xyz.microloong.cloudLabel.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import xyz.microloong.cloudLabel.model.esl.Esl;

/**
 * @author MicroLOONG
 * @date 2021-2-25
 */
public interface EslRepository extends Repository<Esl, Long> {

    /**
     * 基站所连接 ESL 数目统计
     *
     * @param id 基站 id
     * @return ESL 连接数
     */
    @Query(value = "select count(*) from esl left join ap on esl.connected_ap_id=ap.id where esl.status=1 and ap.id=?", nativeQuery = true)
    Integer connectedAp(Long id);
}
