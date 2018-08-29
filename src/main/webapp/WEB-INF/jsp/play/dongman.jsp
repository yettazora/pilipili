<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>${videoInfo.biaoti}<c:if test="${!empty videoInfo.num}">：第${videoInfo.num}集 ${videoInfo.title}</c:if>-${seoInfo.title}</title>
	<link rel="shortcut icon" href=${pageContext.request.contextPath}/static/favicon.ico type=image/x-icon>
<meta name="keywords" content="${mediaInfo.biaoti}-${seoInfo.keywords}" />
<meta name="description" content="${mediaInfo.jianjie}" />
<c:import url="../common/common.jsp"></c:import>
	<%--<script src="/static/default/js/danmu.js"></script>--%>
	<script src="/static/default/vide7.1.0/js/video.min.js"></script>
	<link rel="stylesheet" href="/static/default/vide7.1.0/css/video-js.min.css">
	<%--<link rel="stylesheet" href="/static/default/css/danmu.css">--%>
</head>
<style>
.player{position: relative;background: url(${pageContext.request.contextPath}/static/default/images/loading.gif) no-repeat center center;}
.block h2 {line-height: 50px;border-bottom: 0;padding-left: 0;}
.play-list{width:300px;margin-left: 20px;background: url(${pageContext.request.contextPath}/static/default/images/loading.gif) no-repeat center center;}
.play-list-ul::-webkit-scrollbar {width: 12px;height: 12px;}
.play-list-ul::-webkit-scrollbar-thumb {background-color: #616161;background-clip: padding-box;min-height: 28px;}
.play-list-ul::-webkit-scrollbar-track-piece {background-color: #1a1a1a;}
.play-list-ul{top: 68px;height: 564px; overflow:auto;}
.play-info{display: flex;margin-bottom:10px;}
.play-info-img{width:112px;height: 63px;}
.play-info-text{width:170px;margin-left: 10px;position: relative;}
.play-info-title{margin-top: 5px;}
.play-info-count{position: absolute;bottom: 5px;color:#555;}

.play-list-ul .v-li.drama{padding-left: 15px;background: #242424;border-radius: 2px;margin-bottom: 2px;box-sizing: border-box;}
.play-list-ul .v-li{cursor: pointer;position: relative;}
.play-list-ul .v-li .drama-item{display: block;padding: 13px 0;font-size: 14px;margin-right: 28px;overflow: hidden;text-overflow: ellipsis;white-space: nowrap;color:#fff;}
.play-list-ul .v-li.drama.selected:after{content: "";display: block;position: absolute;top: 0;left: 0;bottom: 0;right: 0;border-radius: 4px;border: 2px solid #2fb3ff;}
.play-list-ul .v-li.drama:hover{background:#1e1e1e}

.jianjie p {display: initial;}
.equal-3 a:link, .fengge a:link{color: #2fb3ff;}
.equal-3 a:visited, .fengge a:visited{color: #2fb3ff;}
.equal-3 a:hover, .fengge a:hover{color: #ff3c00;}
</style>

<body>
	<!-- 头部 -->
	<div class="yaoqishan-header">
		<c:import url="../common/header.jsp"></c:import>
	</div>

	<!--播放内容-->
	<div style="width: 1340px; margin: 20px auto;">
		<div class="block no-shadow" style="background-color:#1a1a1a;">
			<!--正文内容-->
			<div class="main-0">
				<div style="display: flex;">
					<div class="player">
						<h2 id="video_title" style="color: #fff;padding-left: 20px;">
							${videoInfo.biaoti}<c:if test="${!empty videoInfo.num}">：第${videoInfo.num}集 ${videoInfo.title}</c:if>
						</h2>
						<span style="position: absolute;color: #ddd;right: 0;top: 20px;">${videoInfo.viewCount} 次播放</span>
						<div id="player" style="width:1000px;height:564px;">

						</div>
					</div>
					<div class="play-list">
						<h2 style="color: #fff;">播放列表</h2>
						<ul id="play-list" class="play-list-ul">

						</ul>
					</div>
				</div>
			</div>
		</div>

        <%--弹幕--%>
		<%--<canvas style="width: 1000px;height: 564px;position: absolute;top: 285px;pointer-events: none; background-color: rgba(0,0,0,0.2)">你的浏览器不支持canvas</canvas>--%>

        <%--<div style="margin-top: -30px" class="bilibili-player-video-bottom-area">--%>

            <%--<div class="bilibili-player-video-sendbar">--%>
                <%--<div class="bilibili-player-video-info">--%>
                    <%--<div class="bilibili-player-video-info-people">--%>
                        <%--<span class="bilibili-player-video-info-people-number">461</span>--%>
                        <%--<span class="bilibili-player-video-info-people-text">人正在看，</span>--%>
                    <%--</div>--%>
                    <%--<div class="bilibili-player-video-info-danmaku">--%>
                        <%--<span class="bilibili-player-video-info-danmaku-number">385</span>--%>
                        <%--<span class="bilibili-player-video-info-danmaku-text">条弹幕</span>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <%--<div class="bilibili-player-video-danmaku-root">--%>
                    <%--<div style="margin-top: 10px" class="bilibili-player-video-danmaku-switch bui bui-switch"><input class="bui-checkbox" type="checkbox"--%>
                                                                                            <%--checked="">--%>
                        <%--<span class="bui-body">--%>
<%--<span class="bui-dot">--%>
<%--<span><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 10 10"><path--%>
        <%--d="M1.311 3.759l-.153 1.438h2.186c0 1.832-.066 3.056-.175 3.674-.131.618-.688.959-1.683 1.023-.284 0-.568-.021-.874-.043L.317 8.818c.284.032.59.053.896.053.546 0 .852-.17.929-.511.077-.341.12-1.076.12-2.204H0l.306-3.344h1.847V1.427H.098V.479h3.18v3.28H1.311zM4 1.747h1.311A8.095 8.095 0 0 0 4.492.426L5.53.085c.306.426.579.873.809 1.363l-.689.299h1.508c.306-.544.569-1.129.809-1.747l1.082.373c-.219.511-.47.969-.743 1.374h1.268V6.23H7.322v.82H10v1.044H7.322V10H6.208V8.094H3.607V7.05h2.601v-.82H4V1.747zm4.568 3.557v-.831H7.322v.831h1.246zm-2.36 0v-.831H5.016v.831h1.192zM5.016 3.557h1.191v-.873H5.016v.873zm2.306-.873v.873h1.246v-.873H7.322z"></path></svg></span>--%>
<%--</span>--%>
<%--</span></div>--%>
                    <%--<div class="bilibili-player-video-danmaku-setting"><span class="bp-svgicon"><svg--%>
                            <%--xmlns="http://www.w3.org/2000/svg" viewBox="0 0 22 22"><path--%>
                            <%--d="M16.5 8c1.289 0 2.49.375 3.5 1.022V6a2 2 0 0 0-2-2H4a2 2 0 0 0-2 2v10a2 2 0 0 0 2 2h7.022A6.5 6.5 0 0 1 16.5 8zM7 13H5a1 1 0 0 1 0-2h2a1 1 0 0 1 0 2zm2-4H5a1 1 0 0 1 0-2h4a1 1 0 0 1 0 2z"></path><path--%>
                            <%--d="M20.587 13.696l-.787-.131a3.503 3.503 0 0 0-.593-1.051l.301-.804a.46.46 0 0 0-.21-.56l-1.005-.581a.52.52 0 0 0-.656.113l-.499.607a3.53 3.53 0 0 0-1.276 0l-.499-.607a.52.52 0 0 0-.656-.113l-1.005.581a.46.46 0 0 0-.21.56l.301.804c-.254.31-.456.665-.593 1.051l-.787.131a.48.48 0 0 0-.413.465v1.209a.48.48 0 0 0 .413.465l.811.135c.144.382.353.733.614 1.038l-.292.78a.46.46 0 0 0 .21.56l1.005.581a.52.52 0 0 0 .656-.113l.515-.626a3.549 3.549 0 0 0 1.136 0l.515.626a.52.52 0 0 0 .656.113l1.005-.581a.46.46 0 0 0 .21-.56l-.292-.78c.261-.305.47-.656.614-1.038l.811-.135A.48.48 0 0 0 21 15.37v-1.209a.48.48 0 0 0-.413-.465zM16.5 16.057a1.29 1.29 0 1 1 .002-2.582 1.29 1.29 0 0 1-.002 2.582z"></path></svg></span>--%>
                    <%--</div>--%>
                    <%--<div class="bilibili-player-video-inputbar unlogin">--%>
                        <%--<div class="bilibili-player-video-inputbar-wrap">--%>
                            <%--<div class="bilibili-player-video-btn bilibili-player-video-btn-danmaku">--%>
                        <%--<span class="bilibili-player-iconfont bilibili-player-iconfont-danmakutype"><span--%>
                                <%--class="bp-svgicon"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 22 22"><path--%>
                                <%--d="M17 16H5c-.55 0-1 .45-1 1s.45 1 1 1h12c.55 0 1-.45 1-1s-.45-1-1-1zM6.96 15c.39 0 .74-.24.89-.6l.65-1.6h5l.66 1.6c.15.36.5.6.89.6.69 0 1.15-.71.88-1.34l-3.88-8.97C11.87 4.27 11.46 4 11 4s-.87.27-1.05.69l-3.88 8.97c-.27.63.2 1.34.89 1.34zM11 5.98L12.87 11H9.13L11 5.98z"></path></svg></span></span>--%>
                            <%--</div>--%>
                            <%--<c:choose>--%>
                                <%--<c:when test="${empty userInfo}">--%>
                            <%--<div class="bilibili-player-video-danmaku-wrap" style="display: block;">请先<a--%>
                                    <%--href="${pageContext.request.contextPath}/portal/login.action" class="bilibili-player-quick-login">登录</a>或<a--%>
                                    <%--href="${pageContext.request.contextPath}/portal/register.action" target="_blank">注册</a></div>--%>
                                <%--</c:when>--%>
                                <%--<c:otherwise>--%>
                                    <%--<c:if test="${not empty userInfo}">--%>
                            <%--<input class="bilibili-player-video-danmaku-input" placeholder="发个友善的弹幕见证当下" style="display: block;">--%>
                                    <%--</c:if>--%>
                                <%--</c:otherwise>--%>
                            <%--</c:choose>--%>
                            <%--<div class="bilibili-player-video-hint" style="display: block;"><a--%>
                                    <%--href="//www.bilibili.com/blackboard/help.html#弹幕相关" target="_blank"><span>弹幕礼仪 </span><span--%>
                                    <%--class="bp-svgicon"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16"><path--%>
                                    <%--d="M9.188 7.999l-3.359 3.359a.75.75 0 1 0 1.061 1.061l3.889-3.889a.75.75 0 0 0 0-1.061L6.89 3.58a.75.75 0 1 0-1.061 1.061l3.359 3.358z"></path></svg></span></a>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="bilibili-player-video-btn-send bui bui-button bui-button-blue bui-button-disabled">发送</div>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>

		<div class="grid-25-8 spacing-20">
			<div>
				<!--视频介绍-->
				<div class="block no-shadow">
					<div class="main" style="margin-bottom: -20px;">
						<div class="grid-3-20 spacing-20">
							<div style="min-width: 140px;height: 210px;">
								<a href="profile.action?mediaId=${mediaInfo.media_id}" target="_blank">
									<img src="${mediaInfo.haibao}" width="100%" height="100%" />
								</a>
							</div>
							<div style="color: #666;position: relative;">
								<h1><a href="profile.action?mediaId=${mediaInfo.media_id}" target="_blank">${mediaInfo.biaoti}</a></h1>

								<ul class="equal-3" style="margin-top: 10px;">
									<li>地区：<a href="javascript:;" target="_blank">${mediaInfo.dongman_diqu}</a></li>
									<li>年份：<a href="javascript:;" target="_blank">${mediaInfo.nianfen}</a></li>
									<li>状态：<a href="javascript:;" target="_blank">${mediaInfo.zhuangtai}</a></li>
									<span class="clearfix"></span>
								</ul>
								<div class="fengge" style="margin-top: 10px">
									风格：
									<c:forEach items="${mediaInfo.dongman_fengge}" var="value" varStatus="status">
										<c:choose>
											<c:when test="${(status.index+1)==fn:length(mediaInfo.dongman_fengge)}">
												<a href="javascript:;" target="_blank" class="tag-link-item">${value}</a>
											</c:when>
											<c:otherwise>
												<a href="javascript:;" target="_blank" class="tag-link-item">${value}</a>
												<i style="color: #ccc;margin: 0 3px;">/</i>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</div>
								<div style="margin-top: 10px;">声优：${mediaInfo.shengyou}</div>
								<div class="jianjie" style="margin-top: 10px;">
									简介：${fn:substring(mediaInfo.jianjie, 0, 80)}
									<a style="color:#2fb3ff;" href="profile.action?mediaId=${mediaInfo.media_id}" target="_blank"> 查看详情</a>
								</div>
							</div>
						</div>
					</div>
				</div>

				<!--评论-->
				<div class="block no-shadow">
					<div class="main">
						<!-- 评论列表 -->
						<div id="comment" class="comment">

						</div>

						<!-- 分页 -->
						<div class="page">
							<ul id="page" class="pagination"></ul>
						</div>
					</div>
				</div>
			</div>
			<div>
				<!--广告位-->
				<c:import url="../ad/ad2.jsp"></c:import>
			</div>
		</div>
	</div>

	<!--底部-->
	<div class="footer-wrap" >
		<c:import url="../common/footer.jsp"></c:import>
	</div>
</body>
<script>
	var mediaId = "${mediaInfo.media_id}";
	var videoId = "${videoId}";
	var pageNum = "1";

	$(function() {
		var videoPower = "${videoInfo.power}";
		if (videoPower=="" || videoPower==null || videoPower=="0") {
			getVideoPlay();
		} else {
			var userPower = "${userInfo.power}";
			if (userPower=="" || userPower==null) {
				loginDialog();
			} else {
				if (parseInt(userPower)<parseInt(videoPower)) {
					javaex.alert({
						content : "您没有权限观看该视频"
					});
				} else {
					getVideoPlay();
				}
			}
		}

		// 获取评论列表
		getCommentList(pageNum);

		// 获取该媒体的播放列表
		getVideoList(mediaId);
	});

    // $(function () {
    //     $('canvas').barrager([{"msg": "这是我发的。。。哈哈哈"}]);
    //     $('canvas').barrager([{"msg": "看着不错。。。。"}, {"msg": "哈哈哈。。。。"}, {"msg": "不错不错。。"}, {"msg": "真好看。。。。"}]);
    // });
	// 获取评论列表
	function getCommentList(pageNum) {
		// 获取评论条数
		$.ajax({
			url : "${pageContext.request.contextPath}/portal/comment_info/get_comment_count.json",
			type : "POST",
			dataType : "json",
			data : {
				"videoId" : videoId
			},
			success : function(rtn) {
				if (rtn.code=="999999") {
					getCommentList(pageNum);
					return;
				}
				var commentCount = rtn.data.count;

				// 获取评论列表
				$.ajax({
					url : "${pageContext.request.contextPath}/portal/comment_info/get_comment_list.json",
					type : "POST",
					dataType : "json",
					data : {
						videoId : videoId,
						pageNum : pageNum
					},
					success : function(rtn) {
						if (rtn.code=="999999") {
							getCommentList(pageNum);
							return;
						}

						var pageInfo = rtn.data.pageInfo;
						var currentPage = pageInfo.pageNum;
						var pageCount = pageInfo.pages;

						var list = pageInfo.list;

						for(var i=0;i<list.length;i++){
                            list[i].updateTime=formatDatebox(list[i].updateTime);
                            var replyInfoList=list[i].replyInfoList;
                            for (var j=0;j<replyInfoList.length;j++){
                                replyInfoList[j].updateTime=formatDatebox(replyInfoList[j].updateTime);
                            }
                        }


						javaex.comment({
							id : "comment",
                            avatar : "avatar",
                            url : "123",
							commentCount : commentCount,
							list : list,
							commentMapping : {
								commentId : "id",
								userId : "userId",
								userName : "loginName",
								avatar : "avatar",
								content : "content",
								time : "updateTime",
								replyInfoList : "replyInfoList"
							},
							replyMapping : {
								userId : "userId",
								userName : "loginName",
								avatar : "avatar",
								toUserId : "toUserId",
								toUserName : "toLoginName",
								content : "content",
								time : "updateTime"
							},
							userId : getCookie("UID"),
							callback: function (rtn) {
								if (rtn.type=="comment") {
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
							id : "page",
							pageCount : pageCount,	// 总页数
							currentPage : currentPage,// 默认选中第几页
							// 返回当前选中的页数
							callback:function(rtn) {
								getCommentList(rtn.pageNum);
							}
						});
					}
				});
			}
		});
	}

    Date.prototype.format = function (format) {
        var o = {
            "M+": this.getMonth() + 1, // month
            "d+": this.getDate(), // day
            "h+": this.getHours(), // hour
            "m+": this.getMinutes(), // minute
            "s+": this.getSeconds(), // second
            "q+": Math.floor((this.getMonth() + 3) / 3), // quarter
            "S": this.getMilliseconds()
            // millisecond
        }
        if (/(y+)/.test(format))
            format = format.replace(RegExp.$1, (this.getFullYear() + "")
                .substr(4 - RegExp.$1.length));
        for (var k in o)
            if (new RegExp("(" + k + ")").test(format))
                format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
        return format;
    }
    function formatDatebox(value) {
        if (value == null || value == '') {
            return '';
        }
        var dt;
        if (value instanceof Date) {
            dt = value;
        } else {
            dt = new Date(value);
        }

        return dt.format("yyyy-MM-dd hh:mm:ss"); //扩展的Date的format方法(上述插件实现)
    }


    // 对视频的评论
	function comment(content) {
		$.ajax({
			url : "${pageContext.request.contextPath}/portal/comment_info/save.json",
			type : "POST",
			dataType : "json",
			data : {
				"videoId" : videoId,
				"userToken" : getCookie("userToken"),
				"content" : content
			},
			success : function(rtn) {
				if (rtn.code=="000000") {
					// 获取评论列表
					getCommentList(pageNum);
				} else {
					javaex.optTip({
						content : rtn.message,
						type : "error"
					});
				}
			}
		});
	}

	// 回复
	function reply(commentId, toUserId, toUserName, content) {
		$.ajax({
			url : "${pageContext.request.contextPath}/portal/reply_info/save.json",
			type : "POST",
			dataType : "json",
			data : {
				"videoId" : videoId,
				"commentId" : commentId,
				"userToken" : getCookie("userToken"),
				"toUserId" : toUserId,
				"toLoginName" : toUserName,
				"content" : content
			},
			success : function(rtn) {
				if (rtn.code=="000000") {
					// 获取评论列表
					getCommentList(pageNum);
				} else {
					javaex.optTip({
						content : rtn.message,
						type : "error"
					});
				}
			}
		});
	}

	// 打开登录框
	function loginDialog() {
		javaex.dialog({
			type : "login",	// 弹出层类型
			width : "400",
			height : "320",
			url : "${pageContext.request.contextPath}/portal/login.action"
		});
	}

	// 获取视频地址
	function getVideoPlay() {
		$.ajax({
			url : "${pageContext.request.contextPath}/api/get_video_play.json",
			type : "POST",
			dataType : "json",
			data : {
				"videoId" : videoId
			},
			success : function(rtn) {
				if (rtn.code=="999999") {
					getVideoPlay();
					return;
				}
				$("#player").append(rtn.data.videoPlay);
			}
		});
	}

	// 获取该媒体的播放列表
	function getVideoList(mediaId) {
		$.ajax({
			url : "${pageContext.request.contextPath}/api/get_video_list.json",
			type : "POST",
			dataType : "json",
			data : {
				"mediaId" : mediaId
			},
			success : function(rtn) {
				if (rtn.code=="999999") {
					getVideoList(mediaId);
					return;
				}
				var list = rtn.data.list;
				if (list.length>0) {
					var html = '';
					for (var i=0; i<list.length; i++) {
						var num = "";
						if (list[i].num=="" || list[i].num==null) {

						} else {
							if (list[i].title==null || list[i].title=="") {
								num = "第"+list[i].num+"集";
							} else {
								num = "第"+list[i].num+"集：";
							}
						}
						if (videoId==list[i].videoId) {
							html += '<li id="li_video_'+videoId+'" class="v-li drama selected">';
						} else {
							html += '<li class="v-li drama">';
						}
						if (videoId==list[i].videoId) {
							if (list[i].title==null || list[i].title=="") {
								html += '<a href="play.action?videoId='+list[i].videoId+'" class="drama-item">'+num+'</a>';
							} else {
								html += '<a href="play.action?videoId='+list[i].videoId+'" class="drama-item">'+num+list[i].title+'</a>';
							}
						} else {
							if (list[i].title==null || list[i].title=="") {
								html += '<a href="play.action?videoId='+list[i].videoId+'" class="drama-item">'+num+'</a>';
							} else {
								html += '<a href="play.action?videoId='+list[i].videoId+'" class="drama-item">'+num+list[i].title+'</a>';
							}
						}
						html += '</li>';
					}

					$(".play-list").css("background", "none");
					$("#play-list").append(html);
					javaex.render();

					var diff = $("#li_video_"+videoId).position().top;
					if (diff>520) {
						diff = diff-67+"px";
						$("#play-list").animate({"scrollTop": diff}, 1000);
					}
				}
			}
		});
	}
</script>
</html>