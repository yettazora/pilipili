package com.yetta.pilipili.controller.portal;

import com.yetta.pilipili.entity.*;
import com.yetta.pilipili.exception.SystemException;
import com.yetta.pilipili.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/portal")
public class PortalController {

    @Autowired
    private SeoInfoService seoInfoService;

    @Autowired
    private TemplateInfoService templateInfoService;

    @Autowired
    private WebInfoService webInfoService;

    @Autowired
    private NavInfoService navInfoService;

    @Autowired
    private VideoInfoService videoInfoService;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private MediaInfoService mediaInfoService;

    @Autowired
    TypeInfoService typeInfoService;

    //获得所选的模板,在以后写了手机端的时候就可以用了
    //String template=templateInfoService.selectNameByType("pc");

    /**
     * 跳转到首页
     * @return
     */
    @RequestMapping("/index.action")
    public String index(ModelMap modelMap, HttpServletRequest request){

        //网站首页seo
        SeoInfo seoInfo=seoInfoService.selectByType("index");
        modelMap.put("seoInfo", seoInfo);

        return "index";
    }

    /**
     * 打开登录弹出层
     * @return
     */
    @RequestMapping("/login.action")
    public String login(){

        return "user/login";
    }

    /**
     * 跳转到注册页面
     * @param modelMap
     * @return
     */
    @RequestMapping("/register.action")
    public String register(ModelMap modelMap){
        //站点信息
        WebInfo webInfo=webInfoService.select();
        modelMap.put("webInfo", webInfo);

        //可用导航列表
        List<NavInfo> navInfoList=navInfoService.listIsUse();
        modelMap.put("navlist", navInfoList);

        return "user/register_page";
    }

    /**
     * 跳转到登录页面
     * @param modelMap
     * @return
     */
    @RequestMapping("/login_page.action")
    public String loginPage(ModelMap modelMap){

        //获取站点信息
        WebInfo webInfo=webInfoService.select();
        modelMap.put("webInfo", webInfo);

        return "user/login_page";
    }

    /**
     * 跳转到找回密码页面
     * @param modelMap
     * @return
     */
    @RequestMapping("/find_pwd.action")
    public String findPwd(ModelMap modelMap){

        //获取站点信息
        WebInfo webInfo=webInfoService.select();
        modelMap.put("webInfo", webInfo);

        return "user/find_pwd";
    }


    @RequestMapping("/play.action")
    public String play(ModelMap modelMap, HttpServletRequest request,@RequestParam("videoId") String videoId){
        //站点信息
        WebInfo webInfo=webInfoService.select();
        modelMap.put("webInfo", webInfo);

        //判断合法性
        try {
            Integer.valueOf(videoId);
        }catch (Exception e){
            return "error/404";
        }

        //获得改视频的信息
        VideoInfo videoInfo=videoInfoService.selectByIdWithPortal(Integer.valueOf(videoId));

        if (videoInfo==null){
            //404
            return "error/404";
        }

        if ("0".equals(videoInfo.getStatus())){
            //404
            return "error/404";
        }

        //视频播放页
        SeoInfo seoInfo=seoInfoService.selectByType("play");
        modelMap.put("seoInfo", seoInfo);

        //获取用户信息
        UserInfo userInfo=userInfoService.getUserInfo(request);
        modelMap.put("userInfo", userInfo);

        //获取可用导航
        List<NavInfo> navInfoList=navInfoService.listIsUse();
        modelMap.put("navlist", navInfoList);

        //根据主键获取媒体信息
        Map<String,Object> mediaInfo=null;
        try {
            mediaInfo=mediaInfoService.selectByMediaId(videoInfo.getMediaId());
        } catch (SystemException e) {
            return "error/404";
        }
        modelMap.put("mediaInfo", mediaInfo);

        TypeInfo typeInfo=typeInfoService.selectById((Integer) mediaInfo.get("type_id"));

        modelMap.put("videoInfo", videoInfo);

        modelMap.put("videoId", videoId);

        return "play/dongman";
    }

    @RequestMapping("/profile.action")
    public String profile(ModelMap modelMap,HttpServletRequest request,@RequestParam("mediaId") String mediaId){
        //站点信息
        WebInfo webInfo=webInfoService.select();
        modelMap.put("webInfo", webInfo);

        //判断合法性
        try {
            Integer media=Integer.valueOf(mediaId);
        }catch (Exception e){
            return "error/404";
        }

        //根据主键获取媒体信息
        Map<String,Object> mediaInfo=null;
        try {
            mediaInfo=mediaInfoService.selectByMediaId(Integer.valueOf(mediaId));
            modelMap.put("mediaInfo", mediaInfo);
        } catch (SystemException e) {
            return "error/404";
        }

        //网站首页
        SeoInfo seoInfo=seoInfoService.selectByType("profile");
        modelMap.put("seoInfo", seoInfo);

        //获取可用导航
        List<NavInfo> navInfoList=navInfoService.listIsUse();
        modelMap.put("navlist", navInfoList);

        TypeInfo typeInfo=typeInfoService.selectById((Integer) mediaInfo.get("type_id"));
        String profileTemplate=typeInfo.getProfileTemplate();

        if (StringUtils.isEmpty(profileTemplate)){
            //该分类是没有详情页面的
            return "error/404";
        }

        modelMap.put("mediaId", mediaId);

        return "profile/"+profileTemplate;
    }

    @RequestMapping("/search.action")
    public String search(ModelMap modelMap,HttpServletRequest request,@RequestParam("keyWord") String keyWord){
        //获取网站信息
        WebInfo webInfo=webInfoService.select();
        modelMap.put("webInfo", webInfo);

        //获取用户信息
        UserInfo userInfo=userInfoService.getUserInfo(request);
        modelMap.put("userInfo", userInfo);

        //获取可用导航
        List<NavInfo> navInfoList=navInfoService.listIsUse();
        modelMap.put("navlist", navInfoList);

        modelMap.put("keyWord", keyWord);

        return "search/search";
    }


}
