package xyz.microloong.cloudLabel.handler;

import org.springframework.stereotype.Component;
import xyz.erupt.annotation.fun.OperationHandler;
import xyz.microloong.cloudLabel.model.esl.Template;

import java.util.List;

/**
 * 自定义模板显示按钮事件触发
 * 当 type = RowOperation.Type.ERUPT 时并配置后启用
 * <p>
 * 泛型说明：
 * Template 目标数据的类型
 * Void     暂时占位，支持使用另一个erupt类作为表单输入框
 *
 * @author MicroLOONG
 * @date 2021-2-15
 */
@Component
public class OperationHandlerImpl implements OperationHandler<Template, Void> {

    /**
     * 按钮事件触发
     *
     * @param data  行数据
     * @param v     表单输入数据
     * @param param 注解回传参数
     */
    @Override
    public void exec(List<Template> data, Void v, String[] param) {
        //ToDo 自定义模板编辑逻辑
    }
}
