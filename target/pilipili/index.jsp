<%@page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" language="java" %>
<jsp:forward page="/portal/index.action"/>
<script src="/static/default/javaex/pc/lib/jquery-1.7.2.min.js"></script>
<script src="/static/default/js/cookie.js"></script>
<script src="/static/default/javaex/pc/js/javaex.min.js"></script>
<script src="/static/default/js/danmu.js"></script>

<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <link rel="shortcut icon" href=${pageContext.request.contextPath}/static/favicon.ico type=image/x-icon>

    <link rel="stylesheet" href="/static/default/css/search.css">
    <link rel="stylesheet" href="/static/default/css/danmu.css">


</head>

<body>

<head>

    <link rel="stylesheet" href="/static/default/vide7.1.0/css/video-js.min.css">
    <script src="/static/default/vide7.1.0/js/videojs-ie8.min.js"></script>
    <script src="/static/default/vide7.1.0/js/video.min.js"></script>
</head>

<video id="my-video" class="video-js" controls preload="auto" width="640" height="264"
       poster="/statics/dongman/Sherlock Season1/sherlockHaibao.webp" data-setup="{}">
    <source src="/statics/dongman/young/S01E01.mp4" type='video/mp4'>
    <source src="/statics/dongman/Sherlock Season1/S01E01.webm" type='video/webm'>
    <p class="vjs-no-js">
        <a href="https://videojs.com/html5-video-support/" target="_blank">supports HTML5 video</a>
    </p>
</video>


<canvas style="width: 1280px;height: 720px;background-color: rgba(0,0,0,0.2)">你的浏览器不支持canvas</canvas>
<script>
    $('canvas').barrager([{"msg": "这是我发的。。。哈哈哈"}]);
    $('canvas').barrager([{"msg": "看着不错。。。。"}, {"msg": "哈哈哈。。。。"}, {"msg": "不错不错。。"}, {"msg": "真好看。。。。"}]);

    // $('canvas').barrager("clear");//关闭弹幕
</script>

<div class="bilibili-player-video-bottom-area">

    <div class="bilibili-player-video-sendbar">
        <div class="bilibili-player-video-info">
            <div class="bilibili-player-video-info-people">
                <span class="bilibili-player-video-info-people-number">461</span>
                <span class="bilibili-player-video-info-people-text">人正在看，</span>
            </div>
            <div class="bilibili-player-video-info-danmaku">
                <span class="bilibili-player-video-info-danmaku-number">385</span>
                <span class="bilibili-player-video-info-danmaku-text">条弹幕</span>
            </div>
        </div>
        <div class="bilibili-player-video-danmaku-root">
            <div class="bilibili-player-video-danmaku-switch bui bui-switch"><input class="bui-checkbox" type="checkbox"
                                                                                    checked="">
                <span class="bui-body">
<span class="bui-dot">
<span><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 10 10"><path
        d="M1.311 3.759l-.153 1.438h2.186c0 1.832-.066 3.056-.175 3.674-.131.618-.688.959-1.683 1.023-.284 0-.568-.021-.874-.043L.317 8.818c.284.032.59.053.896.053.546 0 .852-.17.929-.511.077-.341.12-1.076.12-2.204H0l.306-3.344h1.847V1.427H.098V.479h3.18v3.28H1.311zM4 1.747h1.311A8.095 8.095 0 0 0 4.492.426L5.53.085c.306.426.579.873.809 1.363l-.689.299h1.508c.306-.544.569-1.129.809-1.747l1.082.373c-.219.511-.47.969-.743 1.374h1.268V6.23H7.322v.82H10v1.044H7.322V10H6.208V8.094H3.607V7.05h2.601v-.82H4V1.747zm4.568 3.557v-.831H7.322v.831h1.246zm-2.36 0v-.831H5.016v.831h1.192zM5.016 3.557h1.191v-.873H5.016v.873zm2.306-.873v.873h1.246v-.873H7.322z"></path></svg></span>
</span>
</span></div>
            <div class="bilibili-player-video-danmaku-setting"><span class="bp-svgicon"><svg
                    xmlns="http://www.w3.org/2000/svg" viewBox="0 0 22 22"><path
                    d="M16.5 8c1.289 0 2.49.375 3.5 1.022V6a2 2 0 0 0-2-2H4a2 2 0 0 0-2 2v10a2 2 0 0 0 2 2h7.022A6.5 6.5 0 0 1 16.5 8zM7 13H5a1 1 0 0 1 0-2h2a1 1 0 0 1 0 2zm2-4H5a1 1 0 0 1 0-2h4a1 1 0 0 1 0 2z"></path><path
                    d="M20.587 13.696l-.787-.131a3.503 3.503 0 0 0-.593-1.051l.301-.804a.46.46 0 0 0-.21-.56l-1.005-.581a.52.52 0 0 0-.656.113l-.499.607a3.53 3.53 0 0 0-1.276 0l-.499-.607a.52.52 0 0 0-.656-.113l-1.005.581a.46.46 0 0 0-.21.56l.301.804c-.254.31-.456.665-.593 1.051l-.787.131a.48.48 0 0 0-.413.465v1.209a.48.48 0 0 0 .413.465l.811.135c.144.382.353.733.614 1.038l-.292.78a.46.46 0 0 0 .21.56l1.005.581a.52.52 0 0 0 .656-.113l.515-.626a3.549 3.549 0 0 0 1.136 0l.515.626a.52.52 0 0 0 .656.113l1.005-.581a.46.46 0 0 0 .21-.56l-.292-.78c.261-.305.47-.656.614-1.038l.811-.135A.48.48 0 0 0 21 15.37v-1.209a.48.48 0 0 0-.413-.465zM16.5 16.057a1.29 1.29 0 1 1 .002-2.582 1.29 1.29 0 0 1-.002 2.582z"></path></svg></span>
            </div>
            <div class="bilibili-player-video-inputbar unlogin">
                <div class="bilibili-player-video-inputbar-wrap">
                    <div class="bilibili-player-video-btn bilibili-player-video-btn-danmaku">
                        <span class="bilibili-player-iconfont bilibili-player-iconfont-danmakutype"><span
                                class="bp-svgicon"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 22 22"><path
                                d="M17 16H5c-.55 0-1 .45-1 1s.45 1 1 1h12c.55 0 1-.45 1-1s-.45-1-1-1zM6.96 15c.39 0 .74-.24.89-.6l.65-1.6h5l.66 1.6c.15.36.5.6.89.6.69 0 1.15-.71.88-1.34l-3.88-8.97C11.87 4.27 11.46 4 11 4s-.87.27-1.05.69l-3.88 8.97c-.27.63.2 1.34.89 1.34zM11 5.98L12.87 11H9.13L11 5.98z"></path></svg></span></span>
                    </div>
                    <div class="bilibili-player-video-danmaku-wrap" style="display: block;">请先<a
                            href="javascript:void(0);" class="bilibili-player-quick-login">登录</a>或<a
                            href="https://www.bilibili.com/register" target="_blank">注册</a></div>
                    <input class="bilibili-player-video-danmaku-input" placeholder="发个友善的弹幕见证当下" style="display: none;">
                    <div class="bilibili-player-video-hint" style="display: block;"><a
                            href="//www.bilibili.com/blackboard/help.html#弹幕相关" target="_blank"><span>弹幕礼仪 </span><span
                            class="bp-svgicon"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16"><path
                            d="M9.188 7.999l-3.359 3.359a.75.75 0 1 0 1.061 1.061l3.889-3.889a.75.75 0 0 0 0-1.061L6.89 3.58a.75.75 0 1 0-1.061 1.061l3.359 3.358z"></path></svg></span></a>
                    </div>
                </div>
                <div class="bilibili-player-video-btn-send bui bui-button bui-button-blue bui-button-disabled">发送</div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
<script>


    $(function () {

        videoId = 3495;

        getCommentList(1);
    });


    // 获取评论列表
    function getCommentList(pageNum) {
        // 获取评论条数
        $.ajax({
            url: "${pageContext.request.contextPath}/portal/comment_info/get_comment_count.json",
            type: "POST",
            dataType: "json",
            data: {
                "videoId": videoId
            },
            success: function (rtn) {
                if (rtn.code == "999999") {
                    getCommentList(pageNum);
                    return;
                }
                var commentCount = rtn.data.count;

                // 获取评论列表
                $.ajax({
                    url: "${pageContext.request.contextPath}/portal/comment_info/get_comment_list.json",
                    type: "POST",
                    dataType: "json",
                    data: {
                        videoId: videoId,
                        pageNum: pageNum
                    },
                    success: function (rtn) {
                        if (rtn.code == "999999") {
                            getCommentList(pageNum);
                            return;
                        }

                        var pageInfo = rtn.data.pageInfo;
                        var currentPage = pageInfo.pageNum;
                        var pageCount = pageInfo.pages;

                        var list = pageInfo.list;

                        javaex.comment({
                            id: "comment",
                            avatar: "avatar",
                            url: "123",
                            commentCount: commentCount,
                            list: list,
                            commentMapping: {
                                commentId: "id",
                                userId: "userId",
                                userName: "loginName",
                                avatar: "avatar",
                                content: "content",
                                time: "updateTime",
                                replyInfoList: "replyInfoList"
                            },
                            replyMapping: {
                                userId: "userId",
                                userName: "loginName",
                                avatar: "avatar",
                                toUserId: "toUserId",
                                toUserName: "toLoginName",
                                content: "content",
                                time: "updateTime"
                            },
                            userId: getCookie("UID"),
                            callback: function (rtn) {
                                if (rtn.type == "comment") {
                                    // 对视频的评论
                                    comment(rtn.content);
                                } else {
                                    // 对评论的回复
                                    reply(rtn.commentId, rtn.toUserId, rtn.toUserName, rtn.content);
                                }
                            }
                        });

                        $("#page").empty();
                        javaex.page({
                            id: "page",
                            pageCount: pageCount,	// 总页数
                            currentPage: currentPage,// 默认选中第几页
                            // 返回当前选中的页数
                            callback: function (rtn) {
                                getCommentList(rtn.pageNum);
                            }
                        });
                    }
                });
            }
        });
    }
</script>
