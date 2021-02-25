package xyz.microloong.cloudLabel.model.esl;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.Power;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.InputType;
import xyz.erupt.annotation.sub_field.sub_edit.Search;
import xyz.erupt.jpa.model.BaseModel;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author MicroLOONG
 * @date 2021-2-10
 */
@Erupt(
        name = "门店管理",
        power = @Power(importable = true, export = true)
)
@Table(name = "store")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
public class Store extends BaseModel {

    @EruptField(
            views = @View(
                    title = "门店名", sortable = true
            ),
            edit = @Edit(
                    title = "门店名",
                    type = EditType.INPUT, notNull = true,
                    inputType = @InputType(fullSpan = true),
                    search = @Search(vague = true)
            )
    )
    private String storeName;

    @EruptField(
            views = @View(
                    title = "地址", sortable = true
            ),
            edit = @Edit(
                    title = "地址",
                    type = EditType.INPUT,
                    inputType = @InputType(fullSpan = true)
            )
    )
    private String address;

    @EruptField(
            views = @View(
                    title = "负责人", sortable = true
            ),
            edit = @Edit(
                    title = "负责人",
                    type = EditType.INPUT,
                    inputType = @InputType(fullSpan = true)
            )
    )
    private String personInCharge;

    @EruptField(
            views = @View(title = "电话"),
            edit = @Edit(
                    title = "电话",
                    type = EditType.INPUT,
                    inputType = @InputType(fullSpan = true, type = "tel")
            )
    )
    private String tel;

}
