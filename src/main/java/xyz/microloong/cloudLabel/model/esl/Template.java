package xyz.microloong.cloudLabel.model.esl;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.Filter;
import xyz.erupt.annotation.sub_erupt.RowOperation;
import xyz.erupt.annotation.sub_erupt.Tpl;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.AttachmentType;
import xyz.erupt.annotation.sub_field.sub_edit.ChoiceType;
import xyz.erupt.annotation.sub_field.sub_edit.InputType;
import xyz.erupt.annotation.sub_field.sub_edit.Search;
import xyz.erupt.upms.handler.DictChoiceFetchHandler;
import xyz.erupt.upms.model.base.HyperModel;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * @author MicroLOONG
 * @date 2021-2-15
 */
@Erupt(
        name = "模板管理",
        filter = @Filter("Template.isDeleted = false"),
        rowOperation = {
                @RowOperation(
                        code = "CUSTOM",
                        title = "模板定制",
                        tip = "自定义模板页面入口",
                        icon = "fa fa-cog",
                        type = RowOperation.Type.TPL,
                        tpl = @Tpl(path = "/tpl/template.html")
                        // operationParam = "",
                        // operationHandler = OperationHandlerImpl.class
                )
        }
)
@SQLDelete(sql = "update template set is_deleted = 1 where id = ?")
@Table(name = "template")
@Getter
@Setter
@Entity
public class Template extends HyperModel {

    @EruptField(
            views = @View(
                    title = "模板名称", sortable = true
            ),
            edit = @Edit(
                    title = "模板名称",
                    type = EditType.INPUT, notNull = true,
                    inputType = @InputType,
                    search = @Search(vague = true)
            )
    )
    private String templateName;

    @EruptField(
            views = @View(
                    title = "描述"
            ),
            edit = @Edit(
                    title = "描述",
                    type = EditType.TEXTAREA
            )
    )
    private @Lob
    String description;

    @EruptField(
            views = @View(
                    title = "显示尺寸", sortable = true
            ),
            edit = @Edit(
                    title = "显示尺寸",
                    type = EditType.CHOICE, notNull = true,
                    choiceType = @ChoiceType(
                            fetchHandler = DictChoiceFetchHandler.class,
                            fetchHandlerParams = "DisplaySize"
                    ),
                    search = @Search(vague = true)
            )
    )
    private String displaySize;

    @EruptField(
            views = @View(
                    title = "支持颜色", sortable = true
            ),
            edit = @Edit(
                    title = "支持颜色",
                    type = EditType.CHOICE, notNull = true,
                    choiceType = @ChoiceType(
                            fetchHandler = DictChoiceFetchHandler.class,
                            fetchHandlerParams = "Color"
                    ),
                    search = @Search(vague = true)
            )
    )
    private String displayColor;

    @EruptField(
            views = @View(
                    title = "模板上传"
            ),
            edit = @Edit(
                    title = "模板上传",
                    type = EditType.ATTACHMENT,
                    attachmentType = @AttachmentType
            )
    )
    private String upload;

    private Boolean isDeleted = false;

}
