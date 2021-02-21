package xyz.microloong.cloudLabel.model.esl;

import lombok.Getter;
import lombok.Setter;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.Power;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.*;
import xyz.erupt.upms.handler.DictChoiceFetchHandler;
import xyz.erupt.upms.model.EruptUser;
import xyz.erupt.upms.model.base.HyperModel;
import xyz.microloong.cloudLabel.service.ESLService;

import javax.persistence.*;
import java.util.Date;

/**
 * @author MicroLOONG
 * @date 2021-2-16
 */
@Erupt(
        name = "价签管理",
        power = @Power(export = true),
        dataProxy = {ESLService.class},
        orderBy = "updateTime desc"
)
@Table(name = "esl")
@Getter
@Setter
@Entity
public class ESL extends HyperModel {

    @EruptField(
            views = @View(
                    title = "设备号", sortable = true
            ),
            edit = @Edit(
                    title = "设备号",
                    type = EditType.INPUT, notNull = true,
                    inputType = @InputType,
                    search = @Search(vague = true)
            )
    )
    @Column(unique = true)
    private String eslCode;

    @EruptField(
            views = @View(
                    title = "型号"
            ),
            edit = @Edit(
                    title = "型号",
                    type = EditType.CHOICE, notNull = true,
                    choiceType = @ChoiceType(
                            fetchHandler = DictChoiceFetchHandler.class,
                            fetchHandlerParams = "Model"
                    ),
                    search = @Search(vague = true)
            )
    )
    private String model;

    @EruptField(
            views = @View(
                    title = "状态", sortable = true
            ),
            edit = @Edit(
                    title = "状态",
                    type = EditType.BOOLEAN,
                    boolType = @BoolType(trueText = "在线", falseText = "离线"),
                    search = @Search(vague = true)
            )
    )
    private Boolean status;

    @ManyToOne
    @EruptField(
            views = @View(
                    title = "门店绑定", sortable = true, column = "storeName"
            ),
            edit = @Edit(
                    title = "门店绑定",
                    type = EditType.REFERENCE_TABLE,
                    referenceTableType = @ReferenceTableType(label = "storeName"),
                    search = @Search(vague = true)
            )
    )
    private Store boundStore;

    @ManyToOne
    @EruptField(
            views = @View(
                    title = "商品绑定", sortable = true, column = "commodityName"
            ),
            edit = @Edit(
                    title = "商品绑定",
                    type = EditType.REFERENCE_TABLE,
                    referenceTableType = @ReferenceTableType(label = "commodityName"),
                    search = @Search(vague = true)
            )
    )
    private CommodityList boundCommodity;

    @ManyToOne
    @EruptField(
            views = @View(
                    title = "模板选择", sortable = true, column = "templateName"
            ),
            edit = @Edit(
                    title = "模板选择",
                    type = EditType.REFERENCE_TABLE,
                    desc = "请选择匹配所选价签型号的模板",
                    referenceTableType = @ReferenceTableType(label = "templateName"),
                    search = @Search(vague = true)
            )
    )
    private Template chosenTemplate;

    @Lob
    @EruptField(
            views = @View(
                    title = "内容推送", export = false
            ),
            edit = @Edit(
                    title = "内容推送",
                    type = EditType.HTML_EDITOR,
                    desc = "推送自定义内容到电子价签",
                    htmlEditorType = @HtmlEditorType(HtmlEditorType.Type.UEDITOR)
            )
    )
    private String push;


    @EruptField(
            views = @View(
                    title = "MAC地址"
            ),
            edit = @Edit(
                    title = "MAC地址",
                    type = EditType.HIDDEN
            )
    )
    private String macAddress;

    @EruptField(
            views = @View(
                    title = "信号强度"
            ),
            edit = @Edit(
                    title = "信号强度",
                    type = EditType.HIDDEN
            )
    )
    private String rssi;

    @EruptField(
            views = @View(
                    title = "剩余电量"
            ),
            edit = @Edit(
                    title = "剩余电量",
                    type = EditType.HIDDEN
            )
    )
    private String soc;

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
