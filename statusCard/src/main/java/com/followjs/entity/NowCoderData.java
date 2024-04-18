package com.followjs.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 功能：
 * 日期：2024/4/15 上午8:34
 */
@Getter
@Setter
public class NowCoderData {
    public String rating;
    public String ratingRank;
    public String competitionCount;
    public String hasPassedProblem;

    // toString
    @Override
    public String toString() {
        return "NowCoderData{" +
                "rating=" + rating +
                ", ratingRank=" + ratingRank +
                ", competitionCount=" + competitionCount +
                ", hasPassedProblem=" + hasPassedProblem +
                '}';
    }
}