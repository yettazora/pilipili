package com.yetta.pilipili.service.impl;

import com.yetta.pilipili.dao.*;
import com.yetta.pilipili.entity.*;
import com.yetta.pilipili.exception.SystemException;
import com.yetta.pilipili.service.MediaInfoService;
import com.yetta.pilipili.util.ErrorMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

@Service("mediaInfoService")
public class MediaInfoServiceImpl implements MediaInfoService {

    @Autowired
    MediaInfoMapper mediaInfoMapper;

    @Autowired
    FieldInfoMapper fieldInfoMapper;

    @Autowired
    FieldProfileInfoMapper fieldProfileInfoMapper;

    @Autowired
    ApiInfoMapper apiInfoMapper;

    @Autowired
    VideoInfoMapper videoInfoMapper;

    @Autowired
    TagInfoMapper tagInfoMapper;


    @Override
    public Map<String, Object> selectByMediaId(Integer mediaId) throws SystemException {
        Map<String,Object> map=mediaInfoMapper.selectByMediaId(mediaId);

        //校验视频信息
        if (map==null){
            throw new SystemException(ErrorMsg.ERROR_300003);
        }

        //遍历map，获取字段对应的文本
        for (String key:map.keySet()){
            if ("media_id".equals(key)||"tag".equals(key)||"haibao".equals(key)||"biaoti".equals(key)||"kandian".equals(key)||"jieshao".equals(key)){
            }
            else {
                String fieldProfileId=map.get(key).toString();
                String arr[]=fieldProfileId.split(",");
                if (arr!=null&&arr.length>0){
                    //判断该字段是否为复选框
                    FieldInfo fieldInfo=fieldInfoMapper.selectByVarName(key);
                    if (fieldInfo!=null){
                        //判断字段类型
                        if ("radio".equals(fieldInfo.getInputType())){
                            //单选框
                            String value=fieldProfileInfoMapper.selectById(Integer.valueOf(fieldProfileId));
                            if (!StringUtils.isEmpty(value)){
                                map.put(key, value);
                            }
                        }
                        else if ("checkbox".equals(fieldInfo.getInputType())){

                            Integer arrInt[]=new Integer[arr.length];
                            for (int i = 0; i < arr.length; i++) {
                                arrInt[i]=Integer.valueOf(arr[i]);
                            }

                            //复选框
                            List<String> list=fieldProfileInfoMapper.selectByIdArr(arrInt);

                            if (list!=null&&list.isEmpty()==false){
                                map.put(key, list);
                            }
                        }
                    }
                }
            }
        }
        return map;
    }

    /**
     * 搜索关键字
     * @param keyWord
     * @return
     */

    @Override
    public List<Integer> search(String keyWord) {
        if (StringUtils.isEmpty(keyWord)){
            return null;
        }

        return mediaInfoMapper.searchIdByKeyWord(keyWord);
    }


    /**
     * 根据接口自定义排行榜查询数据
     * @param apiId 接口主键
     * @return
     * @throws SystemException
     */
    @Override
    public List<Map<String, Object>> getRankDataByApiId(Integer apiId) throws SystemException {

        Map<String,Object> apiInfo=apiInfoMapper.selectById(apiId);

        if (apiInfo==null){
            throw new SystemException(ErrorMsg.ERROR_700002);
        }

        StringBuffer sql=new StringBuffer();

        sql.append("select mi.media_id,mi.biaoti,mi.fengmian,vi.view_count from" +
                " media_info mi ,(select media_id , ");
        if ("day".equals(apiInfo.get("rank_type"))){
            sql.append("SUM(view_count_day) AS view_count");
        }else if ("week".equals(apiInfo.get("rank_type"))){
            sql.append("SUM(view_count_week) AS view_count");
        }else if ("month".equals(apiInfo.get("rank_type"))){
            sql.append("SUM(view_count_month) AS view_count");
        }else if ("year".equals(apiInfo.get("rank_type"))){
            sql.append("SUM(view_count_year) AS view_count");
        }else {
            return null;
        }
        sql.append(
                " from video_info group by media_id  ) vi where mi.status ='1' and" +
                " mi.has_video ='1' and mi.media_id = vi.media_id and mi.type_id = ");
        sql.append(apiInfo.get("type_id"));
        sql.append(
                " order by vi.view_count Desc limit ");
        sql.append(apiInfo.get("num"));

        //返回查询结果
        List <Map<String,Object>> list=mediaInfoMapper.selectSqlByApi(sql.toString());

        //判断是否要查询视频信息
        String selectVideo= String.valueOf(apiInfo.get("select_video")) ;


        if ("0".equals(selectVideo)){
            //不查询
        }
        else {
            if (list!=null&&list.isEmpty()==false){
                int len=list.size();
                for (int i = 0; i < len; i++) {
                    Integer mediaId= (Integer) list.get(i).get("media_id");
                    VideoInfo videoInfo=null;
                    if ("1".equals(selectVideo)){
                        //查询第一集
                        videoInfo=videoInfoMapper.selectByMediaIdFirst(mediaId);
                    }
                    if ("2".equals(selectVideo)){
                        //查询最新一集
                        videoInfo=videoInfoMapper.selectByMediaIdLast(mediaId);
                    }
                    if (videoInfo!=null){
                        list.get(i).put("videoInfo", videoInfo);
                    }

                }
            }
        }

        return list;
    }

    /**
     * 根据主键查询媒体信息
     * @param mediaId 主键
     * @return
     */
    @Override
    public MediaInfo selectById(Integer mediaId) {
        return mediaInfoMapper.selectById(mediaId);
    }

    /**
     * 查询媒体列表
     * @param param
     * @return
     */
    @Override
    public List<MediaInfo> list(Map<String, Object> param) {
        return mediaInfoMapper.list(param);
    }

    /**
     * 保存媒体信息
     * @param param
     * @throws SystemException
     */
    public void save(Map<String, Object> param) throws SystemException {
        // 生成标签
        if (StringUtils.isEmpty(param.get("tag"))) {
            // 清空该媒体的标签
            param.put("tag", "");
        } else {
            String tags = param.get("tag").toString();
            // 1.0 将得到的标签转为数组格式
            String[] tagArr = tags.split(",");
            for (int i=0; i<tagArr.length; i++) {
                // 根据标签中文名称，查询标签是否已存在
                int count = tagInfoMapper.countByName(tagArr[i]);
                if (count==0) {
                    // 不存在，插入新标签
                    TagInfo tagInfo = new TagInfo();
                    tagInfo.setName(tagArr[i]);

                    tagInfoMapper.insert(tagInfo);
                }
            }

            // 2.0 重新根据用户输入的标签，查询标签的主键，按从小到大排序
            List<String> idList = tagInfoMapper.listIdByNameArr(tagArr);

            // 3.0 将集合转为 1,3这种字符串
            String str = "";
            for (int i=0; i<idList.size(); i++) {
                if (i==0) {
                    str = idList.get(i);
                } else {
                    str = str + "," + idList.get(i);
                }
            }

            // 4.0 保存新的标签
            param.put("tag", str);
        }

        // 分类
        String typeId = param.get("type_id").toString();
        // 标题
        String biaoti = param.get("biaoti").toString();
        // 判断是否允许标题重复
        String repeat = param.get("repeat").toString();

        // 查询字段列表
        List<FieldInfo> fieldInfoList = fieldInfoMapper.listByTypeId(Integer.valueOf(typeId));
        if (fieldInfoList!=null && fieldInfoList.isEmpty()==false) {
            // 判断是新增还是更新
            String mediaId = param.get("media_id").toString();
            if (StringUtils.isEmpty(mediaId)) {
                // 新增
                // 1.0 判断是否允许标题重复
                if (!"1".equals(repeat)) {
                    // 校验标题是否重复
                    int count = mediaInfoMapper.countByBiaoti(biaoti, null);
                    if (count>0) {
                        // 重复
                        throw new SystemException(ErrorMsg.ERROR_300001);
                    }
                }

                //2.0 生成插入数据SQL文
                StringBuffer sql = new StringBuffer();
                sql.append(" INSERT INTO ");
                sql.append(" media_info ");
                sql.append(" ( ");
                for (FieldInfo fieldInfo : fieldInfoList) {
                    sql.append(fieldInfo.getVarName() + ",");
                }
                sql.append(" tag, ");
                sql.append(" type_id, ");
                sql.append(" haibao, ");
                sql.append(" dafengmian, ");
                sql.append(" fengmian, ");
                sql.append(" biaoti, ");
                sql.append(" bieming, ");
                sql.append(" jianjie, ");
                sql.append(" status, ");
                sql.append(" has_video, ");
                sql.append(" update_time ");
                sql.append(" ) ");
                sql.append(" VALUES ");
                sql.append(" ( ");
                for (FieldInfo fieldInfo : fieldInfoList) {
                    String value = "";
                    if (param.get(fieldInfo.getVarName())!=null) {
                        value = param.get(fieldInfo.getVarName()).toString();
                    }
                    sql.append(" '"+value+"', ");
                }
                sql.append(" '"+param.get("tag").toString()+"', ");
                sql.append(" '"+typeId+"', ");
                sql.append(" '"+param.get("haibao").toString()+"', ");
                sql.append(" '"+param.get("dafengmian").toString()+"', ");
                sql.append(" '"+param.get("fengmian").toString()+"', ");
                sql.append(" '"+biaoti+"', ");
                sql.append(" '"+param.get("bieming").toString()+"', ");
                sql.append(" '"+param.get("jianjie").toString()+"', ");
                sql.append(" '1', ");
                sql.append(" '0', ");
                sql.append(" NOW() ");
                sql.append(" ) ");

                mediaInfoMapper.insert(sql.toString());
            } else {
                // 更新
                // 1.0 判断是否允许标题重复
                if (!"1".equals(repeat)) {
                    int count = mediaInfoMapper.countByBiaoti(biaoti, Integer.valueOf(mediaId));
                    if (count>0) {
                        // 重复
                        throw new SystemException(ErrorMsg.ERROR_300001);
                    }
                }

                // 2.0 生成更新数据SQL文
                StringBuffer sql = new StringBuffer();
                sql.append(" UPDATE ");
                sql.append(" media_info ");
                sql.append(" SET ");
                for (FieldInfo fieldInfo : fieldInfoList) {
                    String value = "";
                    if (param.get(fieldInfo.getVarName())!=null) {
                        value = param.get(fieldInfo.getVarName()).toString();
                    }
                    sql.append(fieldInfo.getVarName() + "=" + "'" + value + "',");
                }
                sql.append(" tag='"+param.get("tag").toString()+"', ");
                sql.append(" haibao='"+param.get("haibao").toString()+"', ");
                sql.append(" dafengmian='"+param.get("dafengmian").toString()+"', ");
                sql.append(" fengmian='"+param.get("fengmian").toString()+"', ");
                sql.append(" biaoti='"+biaoti+"', ");
                sql.append(" bieming='"+param.get("bieming").toString()+"', ");
                sql.append(" jianjie='"+param.get("jianjie").toString()+"' ");
                sql.append(" WHERE ");
                sql.append(" media_id = '" + mediaId + "' ");

                mediaInfoMapper.update(sql.toString());
            }
        }
    }

    /**
     * 根据主键和分类id，获取媒体字段信息
     * @param mediaId 主键
     * @param typeId 分类id
     * @return
     */
    public Map<String, Object> selectByIdAndTypeId(String mediaId, Integer typeId) {
        // 1.0 根据分类id，查询该媒体使用了哪些字段
        List<FieldInfo> list = fieldInfoMapper.listByTypeId(typeId);
        if (list!=null && list.isEmpty()==false) {
            // 生成媒体查询sql（查哪些字段）
            StringBuffer sql = new StringBuffer();
            sql.append(" SELECT ");
            for (int i=0; i<list.size(); i++) {
                if (i==(list.size()-1)) {
                    sql.append(list.get(i).getVarName());
                } else {
                    sql.append(list.get(i).getVarName() + ",");
                }
            }
            sql.append(" FROM ");
            sql.append(" media_info ");
            sql.append(" WHERE ");
            sql.append(" media_id = '" + mediaId + "' ");

            // 返回查询结果
            return mediaInfoMapper.selectSqlById(sql.toString());
        }

        return null;
    }

    /**
     * 批量更新媒体的状态
     * @param param
     */
    public void batchUpdateStatus(Map<String, Object> param) {
        // 批量更新媒体的状态
        mediaInfoMapper.batchUpdate(param);

        // 批量更新视频状态
        videoInfoMapper.batchUpdate(param);
    }

    /**
     * 批量移动到分类
     * @param param
     */
    public void batchUpdateType(Map<String, Object> param) {
        mediaInfoMapper.batchUpdate(param);
    }

    /**
     * 批量删除
     * @param mediaIdArr 主键数组
     */
    public void batchDelete(Integer[] mediaIdArr) {
        // 1.0 删除其下的视频信息
        videoInfoMapper.batchDeleteByMediaId(mediaIdArr);

        // 2.0 删除媒体信息
        videoInfoMapper.batchDelete(mediaIdArr);
    }

    /**
     * 根据主键，查询该媒体信息标题
     * @param mediaId 主键
     * @return
     */
    public String selectBiaotiById(Integer mediaId) {
        return mediaInfoMapper.selectBiaotiById(mediaId);
    }


}
