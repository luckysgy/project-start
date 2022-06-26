package com.concise.createproject;

/**
 * @author shenguangyang
 * @date 2021-09-14 20:21
 */
public class CreateProjectConfig {
    /** 工程名 */
    public static final String projectName = "code-generator";
    /** 工程名简写 每个模块的前缀 */
    public static final String projectNameShort = "code-gen";
    /** 包名 */
    public static final String packageName = "com.code_gen";
    /**
     * 是否更改组件包名为 {@link #packageName}
     */
    public static final Boolean isUpdateComponentPackageName = false;
}
