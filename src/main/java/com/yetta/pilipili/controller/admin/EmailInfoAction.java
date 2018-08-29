package com.yetta.pilipili.controller.admin;

import java.util.ArrayList;
import java.util.List;

import com.yetta.pilipili.entity.EmailInfo;
import com.yetta.pilipili.exception.SystemException;
import com.yetta.pilipili.service.EmailInfoService;
import com.yetta.pilipili.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("email_info")
public class EmailInfoAction {

	@Autowired
	private EmailInfoService emailInfoService;
	
	/**
	 * 查询所有邮件设置
	 */
	@RequestMapping("list.action")
	public String list(ModelMap map) {
		
		List<EmailInfo> list = emailInfoService.list();
		map.put("list", list);
		
		return "admin/email_info/list";
	}
	
	/**
	 * 保存邮件设置
	 * @param idArr 主键数组
	 * @param smtpArr SMTP 服务器数组
	 * @param portArr 端口数组
	 * @param emailArr 发信人邮件地址数组
	 * @param passwordArr SMTP 身份验证密码数组
	 * @return
	 * @throws SystemException
	 */
	@RequestMapping("save.json")
	@ResponseBody
	public Result save(
			@RequestParam(value="idArr") Integer[] idArr,
			@RequestParam(value="smtpArr") String[] smtpArr,
			@RequestParam(value="portArr") Integer[] portArr,
			@RequestParam(value="emailArr") String[] emailArr,
			@RequestParam(value="passwordArr") String[] passwordArr) throws SystemException {
		
		List<EmailInfo> emailInfoList = new ArrayList<EmailInfo>();
		
		// 判断是否已有既存数据
		if (idArr.length==0) {
			// 全是新增
			// 遍历smtpArr数组
			for (int i=0; i<smtpArr.length; i++) {
				EmailInfo emailInfo = new EmailInfo();
				emailInfo.setSmtp(smtpArr[i]);
				emailInfo.setPort(portArr[i]);
				emailInfo.setEmail(emailArr[i]);
				emailInfo.setPassword(passwordArr[i]);
				
				emailInfoList.add(emailInfo);
			}
		} else {
			// 遍历idArr数组
			for (int i=0; i<idArr.length; i++) {
				EmailInfo emailInfo = new EmailInfo();
				emailInfo.setId(idArr[i]);
				emailInfo.setSmtp(smtpArr[i]);
				emailInfo.setPort(portArr[i]);
				emailInfo.setEmail(emailArr[i]);
				emailInfo.setPassword(passwordArr[i]);
				
				emailInfoList.add(emailInfo);
			}
		}

		emailInfoService.save(emailInfoList);

		return Result.success();
	}
	
	/**
	 * 删除
	 * @param idArr 邮件设置主键数组
	 * @throws SystemException
	 */
	@RequestMapping("delete.json")
	@ResponseBody
	public Result delete(@RequestParam(value="idArr") Integer[] idArr) throws SystemException {
		
		emailInfoService.delete(idArr);
		return Result.success();
	}

}
