package com.projectstart.start.biz1.model.dto;

/**
 * 更新密码请求dto
 * @author shenguangyang
 * @date 2022-03-04 20:45
 */
public class UpdatePasswordReqDTO {
    private String oldPassword;
    private String newPassword;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
