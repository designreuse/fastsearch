package com.berg.fastsearch.admin.account.controller;

import com.berg.fastsearch.core.system.base.web.controller.BaseUrlController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p></p>
 *
 * @author bo.he02@hand-china.com
 * @version v1.0
 * @apiNote Created on 18-5-7
 */
@RequestMapping("/admin/account/user")
@Controller
public class AdminUserUrlController extends BaseUrlController<Long> {

    @Override
    protected String getPrefix() {
        return "admin/account/user";
    }
}