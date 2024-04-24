package com.inovationbehavior.backend.controller;

import com.inovationbehavior.backend.annotation.LogAnnotation;
import com.inovationbehavior.backend.model.Patent;
import com.inovationbehavior.backend.model.Result;
import com.inovationbehavior.backend.service.intf.PatentService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/patents")
public class PatentController {
    @Autowired
    PatentService patentService;

    @LogAnnotation("根据No号查询详情")
    @GetMapping("/{No}")
    public Result getPatentByNo(@PathVariable String No) {
        Patent tmp = patentService.getPatentByNo(No);
        if (tmp != null) {
            return Result.success(tmp);
        }
        return Result.error("未找到No：" + No);
    }
    @LogAnnotation("根据Company和No范围查询专利号")
    @GetMapping("")
    public Result getPatentByKey(@PathParam("company") String company,
                                @PathParam("no") String no) {

        return Result.success( patentService.getPatentByKey(company,no));
    }
    @LogAnnotation("根据Company范围查询公司名")
    @GetMapping("/company")
    public Result getCompanyByKey(@PathParam("key") String key){
        System.out.println(key);
        return Result.success(patentService.getCompanyByKey(key));
    }
}
