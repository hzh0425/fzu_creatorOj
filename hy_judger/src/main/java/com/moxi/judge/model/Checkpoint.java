
package com.moxi.judge.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 程序测试点的Model.
 * 对应数据库中的voj_problem_checkpoints数据表.
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Checkpoint implements Serializable {


	/**
	 * 试题的唯一标识符.
	 */
	private long problemId;
	
	/**
	 * 测试点的唯一标识符.
	 */
	private int checkpointId;
	
	/**
	 * 是否精确匹配测试点.
	 */
	private boolean isExactlyMatch;
	
	/**
	 * 测试点分值.
	 */
	private int score;
	
	/**
	 * 测试点的标准输入.
	 */
	private String input;
	
	/**
	 * 测试点的标准输出.
	 */
	private String output;
	
	/**
	 * 唯一的序列化标识符.
	 */
	private static final long serialVersionUID = -8129670699537187948L;
}
