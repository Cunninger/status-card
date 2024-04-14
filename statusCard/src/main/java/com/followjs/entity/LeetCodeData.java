package com.followjs.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 功能：
 * 日期：2024/4/14 下午3:54
 */
@Getter
@Setter
public class LeetCodeData {
    private int total_solved;
    private int easy_solved;
    private int medium_solved;
    private int hard_solved;
    private String theme;


    public void add(LeetCodeData other) {
        this.total_solved += other.total_solved;
        this.easy_solved += other.easy_solved;
        this.medium_solved += other.medium_solved;
        this.hard_solved += other.hard_solved;
    }
}