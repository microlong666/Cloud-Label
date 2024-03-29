package xyz.microloong.cloudLabel.model.esl;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.Filter;
import xyz.erupt.annotation.sub_erupt.Tree;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.AttachmentType;
import xyz.erupt.annotation.sub_field.sub_edit.NumberType;
import xyz.erupt.annotation.sub_field.sub_edit.ReferenceTreeType;
import xyz.erupt.upms.model.base.HyperModel;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author MicroLOONG
 * @date 2021-2-10
 */
@Erupt(
        name = "商品分类",
        orderBy = "Category.sort",
        tree = @Tree(pid = "parent.id"),
        filter = @Filter("Category.isDeleted = false")
)
@SQLDelete(sql = "update category set is_deleted = 1 where id = ?")
@Table(name = "category")
@Getter
@Setter
@Entity
public class Category extends HyperModel {

    @EruptField(
            views = @View(title = "类别图片"),
            edit = @Edit(title = "类别图片", type = EditType.ATTACHMENT,
                    attachmentType = @AttachmentType(type = AttachmentType.Type.IMAGE))
    )
    private String picture;

    @EruptField(
            views = @View(title = "类别名称"),
            edit = @Edit(title = "类别名称", notNull = true)
    )
    private String name;

    @EruptField(
            views = @View(title = "显示顺序"),
            edit = @Edit(
                    title = "显示顺序",
                    numberType = @NumberType(min = 0)
            )
    )
    private Integer sort;

    @ManyToOne
    @EruptField(
            edit = @Edit(
                    title = "上级树节点",
                    type = EditType.REFERENCE_TREE,
                    referenceTreeType = @ReferenceTreeType(pid = "parent.id")
            )
    )
    private Category parent;

    private Boolean isDeleted = false;

}
