package xyz.microloong.cloudLabel.model.esl;

import lombok.Getter;
import lombok.Setter;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.LinkTree;
import xyz.erupt.annotation.sub_erupt.Power;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.NumberType;
import xyz.erupt.annotation.sub_field.sub_edit.ReferenceTableType;
import xyz.erupt.annotation.sub_field.sub_edit.ReferenceTreeType;
import xyz.erupt.annotation.sub_field.sub_edit.Search;
import xyz.erupt.upms.model.EruptUser;
import xyz.erupt.upms.model.base.HyperModel;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author MicroLOONG
 * @date 2021-2-14
 */
@Erupt(
        name = "库存管理",
        linkTree = @LinkTree(field = "category"),
        power = @Power(export = true),
        orderBy = "updateTime desc"
)
@Table(name = "stock")
@Getter
@Setter
@Entity
public class Stock extends HyperModel {

    @ManyToOne
    @EruptField(
            edit = @Edit(
                    title = "品类",
                    type = EditType.HIDDEN,
                    referenceTreeType = @ReferenceTreeType(pid = "parent.id")
            ))
    private Category category;

    @ManyToOne
    @EruptField(
            views = @View(
                    title = "商品名称", sortable = true, column = "commodityName"
            ),
            edit = @Edit(
                    title = "商品名称",
                    type = EditType.REFERENCE_TABLE, notNull = true,
                    referenceTableType = @ReferenceTableType(label = "commodityName"),
                    desc = "请留意商品所属门店",
                    search = @Search(vague = true)
            )
    )
    private CommodityList commodityName;

    @EruptField(
            views = @View(
                    title = "在架数量"
            ),
            edit = @Edit(
                    title = "在架数量",
                    type = EditType.NUMBER,
                    numberType = @NumberType(min = 0)
            )
    )
    private Integer onSelfNum;

    @EruptField(
            views = @View(
                    title = "仓库存量"
            ),
            edit = @Edit(
                    title = "仓库存量",
                    type = EditType.NUMBER,
                    numberType = @NumberType(min = 0)
            )
    )
    private Integer storageNum;

    @EruptField(
            views = @View(
                    title = "今日销量"
            ),
            edit = @Edit(
                    title = "今日销量",
                    type = EditType.NUMBER,
                    numberType = @NumberType(min = 0)
            )
    )
    private Integer saleToday;

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

}
