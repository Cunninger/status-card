package com.followjs.service;

import com.followjs.Repository.LeetCodeRepository;
import com.followjs.entity.LeetCodeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 功能：
 * 日期：2024/4/14 下午3:43
 */
@Service
public class LeetCodeService {

    @Autowired
    private LeetCodeRepository leetCodeRepository;

    public LeetCodeData getLeetCodeInfo(String username, String cn, String theme, String cn_username, String lang, String raw) {
        LeetCodeData data;
        if (cn_username == null) {
            if (cn != null) {
                data = leetCodeRepository.getLeetCodeCnInfo(username);
            } else {
                data = leetCodeRepository.getLeetCodeInfo(username);
            }
        } else {
            data = leetCodeRepository.getLeetCodeInfo(username);
            LeetCodeData cnData = leetCodeRepository.getLeetCodeCnInfo(cn_username);
            data.add(cnData);
        }
        data.setTheme(theme);
        return data;
    }
}
