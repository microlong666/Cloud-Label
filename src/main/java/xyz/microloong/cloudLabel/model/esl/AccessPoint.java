package xyz.microloong.cloudLabel.model.esl;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.Filter;
import xyz.erupt.annotation.sub_erupt.Power;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.BoolType;
import xyz.erupt.annotation.sub_field.sub_edit.InputType;
import xyz.erupt.annotation.sub_field.sub_edit.ReferenceTableType;
import xyz.erupt.annotation.sub_field.sub_edit.Search;
import xyz.erupt.upms.model.EruptUser;
import xyz.erupt.upms.model.base.HyperModel;
import xyz.microloong.cloudLabel.service.AccessPointService;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author MicroLOONG
 * @date 2021-2-15
 */
@Erupt(
        name = "基站管理",
        power = @Power(export = true),
        dataProxy = {AccessPointService.class},
        filter = @Filter("AccessPoint.isDeleted = false"),
        orderBy = "updateTime desc"
)
@SQLDelete(sql = "update ap set is_deleted = 1 where id = ?")
@Table(name = "ap")
@Getter
@Setter
@Entity
public class AccessPoint extends HyperModel {

    @EruptField(
            views = @View(
                    title = "基站名称", sortable = true
            ),
            edit = @Edit(
                    title = "基站名称",
                    type = EditType.INPUT, notNull = true,
                    inputType = @InputType,
                    search = @Search(vague = true)
            )
    )
    private String apName;

    @EruptField(
            views = @View(
                    title = "SN", sortable = true
            ),
            edit = @Edit(
                    title = "SN",
                    type = EditType.INPUT, notNull = true,
                    inputType = @InputType,
                    search = @Search(vague = true)
            )
    )
    @Column(unique = true)
    private String sn;

    @EruptField(
            views = @View(
                    title = "状态", sortable = true
            ),
            edit = @Edit(
                    title = "状态",
                    boolType = @BoolType(trueText = "在线", falseText = "离线"),
                    search = @Search(vague = true)
            )
    )
    private Boolean status;

    @EruptField(
            views = @View(
                    title = "MAC地址"
            ),
            edit = @Edit(
                    title = "MAC地址",
                    type = EditType.HIDDEN,
                    search = @Search(vague = true)
            )
    )
    @Column(unique = true)
    private String macAddress;

    @EruptField(
            views = @View(
                    title = "连接ESL数量"
            ),
            edit = @Edit(
                    title = "连接ESL数量",
                    type = EditType.HIDDEN
            )
    )
    private Integer eslNum;

    @ManyToOne
    @EruptField(
            views = @View(
                    title = "门店绑定", sortable = true, column = "storeName"
            ),
            edit = @Edit(
                    title = "门店绑定",
                    type = EditType.REFERENCE_TABLE, notNull = true,
                    referenceTableType = @ReferenceTableType(label = "storeName"),
                    search = @Search(vague = true)
            )
    )
    private Store boundStore;

    @EruptField(
            views = @View(
                    title = "创建人", sortable = true, column = "name"))
    @ManyToOne
    private EruptUser createUser;

    @EruptField(
            views = @View(
                    title = "创建时间", sortable = true
            )
    )
    private Date createTime;

    @EruptField(
            views = @View(
                    title = "修改人", sortable = true, column = "name"))
    @ManyToOne
    private EruptUser updateUser;

    @EruptField(
            views = @View(
                    title = "更新时间", sortable = true
            )
    )
    private Date updateTime;

    private Boolean isDeleted = false;

}
