package com.yetta.pilipili.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yetta.pilipili.entity.VideoInfo;
import com.yetta.pilipili.exception.SystemException;
import com.yetta.pilipili.service.MediaInfoService;
import com.yetta.pilipili.service.VideoInfoService;
import com.yetta.pilipili.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class APIController {

    @Autowired
    VideoInfoService videoInfoService;

    @Autowired
    MediaInfoService mediaInfoService;

    /**
     * 获取视频地址
     * @param videoId 视频信息主键
     * @return
     */
    @RequestMapping("/get_video_play.json")
    @ResponseBody
    public Result getVideoPlay(@RequestParam("videoId")String videoId){

        String videoPlay=videoInfoService.selectVideoPlayById(Integer.valueOf(videoId));

        return Result.success().add("videoPlay",videoPlay);
    }


    @RequestMapping("/get_video_list.json")
    @ResponseBody
    public Result getVideoList(@RequestParam("mediaId") String mediaId){
        List<VideoInfo> videoInfoList=videoInfoService.listByMediaId(Integer.valueOf(mediaId));
        return Result.success().add("list", videoInfoList);
    }

    /**
     * 搜索
     * @param keyWord 关键字
     * @param pageNum
     * @param pageSize
     * @return
     * @throws SystemException
     */
    @RequestMapping("/search.json")
    @ResponseBody
    public Result search(@RequestParam("keyWord") String keyWord,@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,@RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize ) throws SystemException {
        List<Map<String,Object>> list=new ArrayList<>();
        //引入pagehelpe插件
        //只要在查询之前调用,传入当前页码,以及每一页显示多少条
        PageHelper.startPage(pageNum, pageSize);
        List<Integer> mediaIdList= mediaInfoService.search(keyWord);
        PageInfo<Integer> pageInfo=new PageInfo<>();

        if (mediaIdList!=null && mediaIdList.size()>0){
            int len=mediaIdList.size();
            for (int i = 0; i < len; i++) {
                Integer mediaId=mediaIdList.get(i);

                //获取每一条媒体信息的主要数据
                Map<String,Object> mediaMap=mediaInfoService.selectByMediaId(mediaId);

                //获取每一条媒体信息下的集数
                List<VideoInfo> videoInfoList=videoInfoService.listByMediaId(mediaId);

                mediaMap.put("videoList", videoInfoList);

                list.add(mediaMap);
            }
        }
        return Result.success().add("pageInfo", pageInfo).add("list", list);
    }

    @RequestMapping("/rank.json")
    @ResponseBody
    public Result rank(@RequestParam("apiId") Integer apiId) throws SystemException {

        List<Map<String,Object>> list=mediaInfoService.getRankDataByApiId(apiId);

        return Result.success().add("list", list);
    }
    @RequestMapping("/list_rank.action")
    public String listRank(){

        return "rank/list_rank";
    }
}
