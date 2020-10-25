/* Verwandlung Online Judge - A cross-platform judge online system
 * Copyright (C) 2018 Haozhe Xie <cshzxie@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 *
 *                              _ooOoo_  
 *                             o8888888o  
 *                             88" . "88  
 *                             (| -_- |)  
 *                             O\  =  /O  
 *                          ____/`---'\____  
 *                        .'  \\|     |//  `.  
 *                       /  \\|||  :  |||//  \  
 *                      /  _||||| -:- |||||-  \  
 *                      |   | \\\  -  /// |   |  
 *                      | \_|  ''\---/''  |   |  
 *                      \  .-\__  `-`  ___/-. /  
 *                    ___`. .'  /--.--\  `. . __  
 *                 ."" '<  `.___\_<|>_/___.'  >'"".  
 *                | | :  `- \`.;`\ _ /`;.`/ - ` : | |  
 *                \  \ `-.   \_ __\ /__ _/   .-` /  /  
 *           ======`-.____`-.___\_____/___.-`____.-'======  
 *                              `=---=' 
 *
 *                          HERE BE BUDDHA
 *
 */
package com.moxi.judge.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 试题的Model.
 * 对应数据库中的voj_problems数据表.
 *
 */
@Data
@NoArgsConstructor
public class Problem implements Serializable {

	
	/**
	 * Problem的构造函数.
	 * @param isPublic - 试题是否公开
	 * @param problemName - 试题的名称
	 * @param timeLimit - 最大运行时间
	 * @param memoryLimit - 最大运行内存
	 * @param description - 试题描述
	 * @param inputFormat - 试题输入格式描述
	 * @param outputFormat - 试题输出描述
	 * @param sampleInput - 试题样例输入
	 * @param sampleOutput - 试题样例输出
	 * @param hint - 试题提示
	 */
	public Problem(boolean isPublic, String problemName, int timeLimit, int memoryLimit,
					String description, String inputFormat, String outputFormat,
					String sampleInput, String sampleOutput, String hint) {
		this.isPublic = isPublic;
		this.problemName = problemName;
		this.timeLimit = timeLimit;
		this.memoryLimit = memoryLimit;
		this.description = description;
		this.inputFormat = inputFormat;
		this.outputFormat = outputFormat;
		this.sampleInput = sampleInput;
		this.sampleOutput = sampleOutput;
		this.hint = hint;
	}
	
	/**
	 * Problem类的构造函数.
	 * @param problemId - 试题唯一标识符
	 * @param isPublic - 试题是否公开
	 * @param problemName - 试题的名称
	 * @param timeLimit - 最大运行时间
	 * @param memoryLimit - 最大运行内存
	 * @param description - 试题描述
	 * @param inputFormat - 试题输入描述
	 * @param outputFormat - 试题输出描述
	 * @param sampleInput - 试题样例输入
	 * @param sampleOutput - 试题样例输出
	 * @param hint - 试题提示
	 */
	public Problem(long problemId, boolean isPublic, String problemName, int timeLimit, 
					int memoryLimit, String description, String inputFormat, String outputFormat, 
					String sampleInput, String sampleOutput, String hint) { 
		this(isPublic, problemName, timeLimit, memoryLimit, description, inputFormat, outputFormat, sampleInput, sampleOutput, hint);
		this.problemId = problemId;
	}

	/**
	 * 试题的唯一标识符.
	 */
	private long problemId;
	
	/**
	 * 试题是否公开.
	 */
	private boolean isPublic;
	
	/**
	 * 试题名称. 
	 */
	private String problemName;
	
	/**
	 * 最大运行时间.
	 */
	private int timeLimit;
	
	/**
	 * 最大运行内存.
	 */
	private int memoryLimit;
	
	/**
	 * 试题描述.
	 */
	private String description;
	
	/**
	 * 输入格式.
	 */
	private String inputFormat;
	
	/**
	 * 输出格式.
	 */
	private String outputFormat;
	
	/**
	 * 样例输入.
	 */
	private String sampleInput;
	
	/**
	 * 样例输出.
	 */
	private String sampleOutput;
	
	/**
	 * 试题提示.
	 */
	private String hint;
	
	/**
	 * 唯一的序列化标识符.
	 */
	private static final long serialVersionUID = 4703482016721365341L;
}
