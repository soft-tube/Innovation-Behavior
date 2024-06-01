package com.inovationbehavior.backend.service.intf;

import com.inovationbehavior.backend.entity.patent.Patent;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface PatentService {
    Patent getPatentByNo(String No);

    List<Map<String, String>> getPatentByKey(String company, String no);

    List<String> getCompanyByKey(String key);
}
