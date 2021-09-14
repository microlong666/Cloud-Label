package xyz.microloong.cloudLabel.model.esl;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.Filter;
import xyz.erupt.annotation.sub_erupt.LinkTree;
import xyz.erupt.annotation.sub_erupt.Power;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.ViewType;
import xyz.erupt.annotation.sub_field.sub_edit.*;
import xyz.erupt.upms.model.base.HyperModel;
import xyz.microloong.cloudLabel.service.CommodityService;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

/**
 * @author MicroLOONG
 * @date 2021-2-11
 */
@Erupt(
        name = "商品列表",
        linkTree = @LinkTree(field = "category"),
        power = @Power(export = true),
        dataProxy = {CommodityService.class},
        filter = @Filter("CommodityList.isDeleted = false"),
        orderBy = "updateTime desc"
)
@SQLDelete(sql = "update commodity set is_deleted = 1 where id = ?")
@Table(name = "commodity")
@Getter
@Setter
@Entity
public class CommodityList extends HyperModel {

    @EruptField(
            views = @View(
                    title = "商品情况", sortable = true
            ),
            edit = @Edit(
                    title = "商品情况",
                    type = EditType.BOOLEAN, notNull = true,
                    boolType = @BoolType(trueText = "在架", falseText = "下架"),
                    search = @Search(vague = true)
            )
    )
    private Boolean commodityCondition;

    @EruptField(
            views = @View(
                    title = "促销情况", sortable = true
            ),
            edit = @Edit(
                    title = "促销情况",
                    type = EditType.BOOLEAN, notNull = true,
                    boolType = @BoolType(trueText = "促销", falseText = "正常"),
                    search = @Search(vague = true)
            )
    )
    private Boolean saleCondition;

    @EruptField(
            views = @View(
                    title = "商品图片"
            ),
            edit = @Edit(
                    title = "商品图片",
                    type = EditType.ATTACHMENT,
                    attachmentType = @AttachmentType(type = AttachmentType.Type.IMAGE, maxLimit = 3)
            )
    )
    private String picture;

    @EruptField(
            views = @View(
                    title = "商品名称", sortable = true
            ),
            edit = @Edit(
                    title = "商品名称",
                    type = EditType.INPUT, notNull = true,
                    inputType = @InputType,
                    search = @Search(vague = true)
            )
    )
    private String commodityName;

    @EruptField(
            views = @View(
                    title = "品牌", sortable = true
            ),
            edit = @Edit(
                    title = "品牌",
                    type = EditType.INPUT,
                    inputType = @InputType,
                    search = @Search(vague = true)
            )
    )
    private String brand;

    @ManyToOne
    @EruptField(
            views = @View(
                    title = "品类", sortable = true, column = "name"
            ),
            edit = @Edit(
                    title = "品类",
                    type = EditType.REFERENCE_TREE, notNull = true,
                    referenceTreeType = @ReferenceTreeType(pid = "parent.id")
            )
    )
    private Category category;


    @ManyToMany
    @JoinTable(
            name = "commodity_store",
            joinColumns = @JoinColumn(name = "commodity_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "store_id", referencedColumnName = "id")
    )
    @EruptField(
            views = @View(
                    title = "关联门店"
            ),
            edit = @Edit(
                    title = "关联门店",
                    type = EditType.TAB_TABLE_REFER, notNull = true
            )
    )
    private Set<Store> store;

    @EruptField(
            views = @View(
                    title = "编码", sortable = true
            ),
            edit = @Edit(
                    title = "编码",
                    type = EditType.INPUT,
                    inputType = @InputType,
                    desc = "代号或货号",
                    search = @Search(vague = true)
            )
    )
    private String code;

    @EruptField(
            views = @View(
                    title = "条码"
            ),
            edit = @Edit(
                    title = "条码",
                    type = EditType.INPUT, notNull = true,
                    inputType = @InputType,
                    search = @Search(vague = true)
            )
    )
    private String barCode;

    @EruptField(
            views = @View(
                    title = "二维码", type = ViewType.QR_CODE
            ),
            edit = @Edit(
                    title = "二维码",
                    type = EditType.INPUT,
                    inputType = @InputType(type = "url"),
                    desc = "填写链接"
            )
    )
    private String qrCode;

    @EruptField(
            views = @View(
                    title = "产地"
            ),
            edit = @Edit(
                    title = "产地",
                    type = EditType.INPUT,
                    inputType = @InputType
            )
    )
    private String placeOfOrigin;

    @EruptField(
            views = @View(
                    title = "规格"
            ),
            edit = @Edit(
                    title = "规格",
                    type = EditType.INPUT,
                    inputType = @InputType
            )
    )
    private String spec;

    @EruptField(
            views = @View(
                    title = "单位"
            ),
            edit = @Edit(
                    title = "单位",
                    type = EditType.INPUT,
                    inputType = @InputType
            )
    )
    private String unit;

    @EruptField(
            views = @View(
                    title = "等级"
            ),
            edit = @Edit(
                    title = "等级",
                    type = EditType.INPUT,
                    inputType = @InputType
            )
    )
    private String level;

    @EruptField(
            views = @View(
                    title = "生产日期"
            ),
            edit = @Edit(
                    title = "生产日期",
                    type = EditType.DATE,
                    dateType = @DateType
            )
    )
    private Date pd;

    @EruptField(
            views = @View(
                    title = "保质期"
            ),
            edit = @Edit(
                    title = "保质期",
                    type = EditType.INPUT,
                    inputType = @InputType
            )
    )
    private String exp;

    @EruptField(
            views = @View(
                    title = "售价"
            ),
            edit = @Edit(
                    title = "售价",
                    type = EditType.NUMBER, notNull = true,
                    numberType = @NumberType(min = 0),
                    desc = "原价"
            )
    )
    private BigDecimal price;

    @EruptField(
            views = @View(
                    title = "会员价"
            ),
            edit = @Edit(
                    title = "会员价",
                    type = EditType.NUMBER,
                    numberType = @NumberType(min = 0)
            )
    )
    private BigDecimal memberPrice;

    /**
     * 分割线
     * 该字段不需要持久化，所以使用Transient注解修饰
     */
    @Transient
    @EruptField(
            edit = @Edit(title = "促销管理", type = EditType.DIVIDE)
    )
    private String divide;

    @EruptField(
            views = @View(
                    title = "促销价"
            ),
            edit = @Edit(
                    title = "促销价",
                    type = EditType.NUMBER,
                    numberType = @NumberType(min = 0)
            )
    )
    private BigDecimal salePrice;

    @EruptField(
            views = @View(
                    title = "促销起始时间", sortable = true
            ),
            edit = @Edit(
                    title = "促销起始时间",
                    type = EditType.DATE,
                    dateType = @DateType
            )
    )
    private Date saleBegin;

    @EruptField(
            views = @View(
                    title = "促销结束时间", sortable = true
            ),
            edit = @Edit(
                    title = "促销结束时间",
                    type = EditType.DATE,
                    dateType = @DateType
            )
    )
    private Date saleEnd;

    @EruptField(
            views = @View(
                    title = "备注说明"
            ),
            edit = @Edit(
                    title = "备注说明",
                    type = EditType.TEXTAREA
            )
    )
    private @Lob
    String remark;

    private Boolean isDeleted = false;

}
