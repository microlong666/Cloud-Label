package xyz.microloong.cloudLabel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import xyz.erupt.core.annotation.EruptRouter;
import xyz.erupt.core.constant.EruptRestPath;
import xyz.erupt.upms.service.EruptUserService;

/**
 * 首页登录用户名获取
 *
 * @author MicroLOONG
 */
@RestController
@RequestMapping(EruptRestPath.ERUPT_API + "/")
public class HomePageController {

    @Autowired
    private EruptUserService eruptUserService;

    @RequestMapping("/user")
    @ResponseBody
    @EruptRouter(verifyType = EruptRouter.VerifyType.LOGIN, authIndex = 0) //配置接口登录后可用
    public String getUserName() {
        return eruptUserService.getCurrentEruptUser().getName();
    }

}
