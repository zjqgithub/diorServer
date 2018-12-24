package com.yang.dior.controller;

import com.yang.dior.core.Result;
import com.yang.dior.core.ResultGenerator;
import com.yang.dior.request.ShareRequest;
import com.yang.dior.service.ShareMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 *
 * @Author zhangjiqiang
 * @Description
 * @Date 2018-12-13 19:53
 *
 ***/
@RestController
@RequestMapping("/share")
public class ShareController {

    @Autowired
    private ShareMapService shareMapService;

    @PostMapping("/saveRecord")
    public Result saveRecord(@RequestBody ShareRequest request) {
        shareMapService.share(request);
        return ResultGenerator.genSuccessResult(null);
    }

}
