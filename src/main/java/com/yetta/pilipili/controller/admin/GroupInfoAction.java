package com.yetta.pilipili.controller.admin;

import java.util.ArrayList;
import java.util.List;

import com.yetta.pilipili.entity.GroupInfo;
import com.yetta.pilipili.exception.SystemException;
import com.yetta.pilipili.service.impl.GroupInfoServiceImpl;
import com.yetta.pilipili.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("group_info")
public class GroupInfoAction {

	@Autowired
	private GroupInfoServiceImpl groupInfoService;
	
	/**
	 * 查询所有用户组
	 */
	@RequestMapping("list.action")
	public String list(ModelMap map) {
		
		List<GroupInfo> list = groupInfoService.list();
		map.put("list", list);
		
		return "admin/group_info/list";
	}
	
	/**
	 * 保存用户组
	 * @param idArr 用户组主键数组
	 * @param sortArr 用户组排序数组
	 * @param nameArr 用户组名称数组
	 * @param powerArr 用户组权限值数组
	 * @throws SystemException
	 */
	@RequestMapping("save.json")
	@ResponseBody
	public Result save(
			@RequestParam(value="idArr") Integer[] idArr,
			@RequestParam(value="sortArr") Integer[] sortArr,
			@RequestParam(value="nameArr") String[] nameArr,
			@RequestParam(value="powerArr") Integer[] powerArr) throws SystemException {
		
		List<GroupInfo> groupInfoList = new ArrayList<GroupInfo>();
		
		// 遍历idArr数组
		for (int i=0; i<idArr.length; i++) {
			GroupInfo groupInfo = new GroupInfo();
			groupInfo.setId(idArr[i]);
			groupInfo.setSort(sortArr[i]);
			groupInfo.setName(nameArr[i]);
			groupInfo.setPower(powerArr[i]);
			
			groupInfoList.add(groupInfo);
		}
		
		groupInfoService.save(groupInfoList);

		return Result.success();
	}
	
	/**
	 * 删除
	 * @param idArr 用户组主键数组
	 * @throws SystemException
	 */
	@RequestMapping("delete.json")
	@ResponseBody
	public Result delete(@RequestParam(value="idArr") Integer[] idArr) throws SystemException {
		
		groupInfoService.delete(idArr);
		return Result.success();
	}
}
