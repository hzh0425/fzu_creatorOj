package com.moxi.judge.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/29 14:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PerResult {
    private String judgeId;
    private int curPoint;
    private boolean isOk;
    private double score;
}
