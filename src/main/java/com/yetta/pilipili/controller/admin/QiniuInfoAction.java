package com.yetta.pilipili.controller.admin;

import java.io.IOException;

import com.yetta.pilipili.entity.QiniuInfo;
import com.yetta.pilipili.exception.SystemException;
import com.yetta.pilipili.service.impl.QiniuInfoService;
import com.yetta.pilipili.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("qiniu_info")
public class QiniuInfoAction {

	@Autowired
	private QiniuInfoService qiniuInfoService;
	
	/**
	 * 配置指定类型
	 * @param map
	 * @param type
	 * @return
	 */
	@RequestMapping("edit.action")
	public String edit(ModelMap map,
			@RequestParam(value="type") String type) {
		
		QiniuInfo qiniuInfo = qiniuInfoService.selectByType(type);
		map.put("qiniuInfo", qiniuInfo);

		map.put("type", type);
		
		return "admin/qiniu_info/edit";
	}

	/**
	 * 保存配置
	 * @param qiniuInfo
	 * @return
	 */
	@RequestMapping("save.json")
	@ResponseBody
	public Result save(QiniuInfo qiniuInfo) {
		
		qiniuInfoService.save(qiniuInfo);
		return Result.success();
	}
	
	/**
	 * 上传本地图片到七牛云
	 * @param file
	 * @param type 类型
	 * @return
	 * @throws IOException
	 * @throws SystemException
	 */
	@RequestMapping("upload_image.json")
	@ResponseBody
	public Result uploadImage(
			MultipartFile file,
			@RequestParam(value="type") String type) throws IOException, SystemException {
		
		QiniuInfo qiniuInfo = qiniuInfoService.selectByType(type);
		String imgUrl = qiniuInfoService.uploadImage(file, qiniuInfo);
		
		return Result.success().add("imgUrl", imgUrl);
	}
	
	/**
	 * 远程图片上传到七牛云
	 * @param imgUrl 远程图片地址
	 * @param type 类型
	 * @return
	 * @throws IOException
	 * @throws SystemException
	 */
	@RequestMapping("upload_image_by_yuancheng.json")
	@ResponseBody
	public Result uploadImageByYuancheng(
			@RequestParam(value="imgUrl") String imgUrl,
			@RequestParam(value="type") String type) throws IOException, SystemException {
		
		QiniuInfo qiniuInfo = qiniuInfoService.selectByType(type);
		imgUrl = qiniuInfoService.uploadImageByYuancheng(imgUrl , qiniuInfo);
		
		return Result.success().add("imgUrl", imgUrl);
	}
}
