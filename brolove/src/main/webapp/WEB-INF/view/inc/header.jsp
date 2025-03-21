<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta id="viewport" name="viewport" content="initial-scale=1.0, width=device-width, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <meta property="og:title" content="ANDW">
    <meta property="og:type" content="website">
    <meta property="og:image" content="${pageContext.request.contextPath }/images/link_preview.png">
    <meta property="og:description" content="GIDATA">
    <title>GIDATA</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath }/images/favicon.ico">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/swiper-bundle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/jquery.mCustomScrollbar.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css">
    <script src="${pageContext.request.contextPath }/js/jquery-3.4.1.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/swiper-bundle.js"></script>
    <script src="${pageContext.request.contextPath }/js/jquery.mCustomScrollbar.js"></script>
    <script src="${pageContext.request.contextPath }/js/jquery.keyframes.js"></script>
	<script type="text/javascript">
		<c:if test="${empty isMainPage}">
			<c:set var="isMainPage" value="false"/>
		</c:if>
	</script>
</head>

		<!-- HEADER -->
		<div class="header <c:if test='${isMainPage}'>main</c:if>">
			<div class="wrap">
		        <h1 class="logo">
		            <a href="/" class="메인으로 가기">
		                <img src="${pageContext.request.contextPath }/images/front/logo_W.png" alt="GIDATA" class="logo_W">
		                <img src="${pageContext.request.contextPath }/images/front/logo_B.png" alt="GIDATA" class="logo_B">
		            </a>
		        </h1>
		        <ul class="menu">
		        	<li>
		        		<a href="javascript:;">회사정보</a>
		        		<ul class="depth2">
		        			<li><a href="/company/introduction.do">GIDATA 소개</a></li>
		        			<li><a href="/company/vision.do">비전</a></li>
		        			<li><a href="/company/history.do">연혁</a></li>
		        			<li><a href="/company/location.do">위치 & 연락처</a></li>
		        			<li><a href="/company/organization.do">조직도</a></li>
		        			<li><a href="/company/financial.do">재무정보</a></li>
		        		</ul>
		        	</li>
		        	<li>
		        		<a href="javascript:;">비즈니스</a>
		        		<ul class="depth2">
		        			<li><a href="/business/finance.do">금융</a></li>
		        			<li><a href="/business/distribution.do">물류</a></li>
		        			<li><a href="/business/solution.do">솔루션</a></li>
		        		</ul>
		        	</li>
		        	<li>
		        		<a href="/partner/partnership.do">파트너십</a>
		        	</li>
		        	<li>
		        		<a href="javascript:;">미디어</a>
		        		<ul class="depth2">
		        			<li><a href="/media/news.do">보도자료</a></li>
		        			<li><a href="/media/notice.do">공지사항</a></li>
		        		</ul>
		        	</li>
		        	<li>
		        		<a href="javascript:;">채용</a>
		        		<ul class="depth2">
		        			<li><a href="/recruitment/culture.do">조직문화 & 복리후생</a></li>
		        			<li><a href="/recruitment/talent.do">인재상</a></li>
		        			<li><a href="/recruitment/procedures.do">채용 절차</a></li>
		        			<li><a href="/recruitment/posting.do">채용 공고</a></li>
		        		</ul>
		        	</li>
		        </ul>
		       <button class="menu_btn"><em></em><span class="blind">전체 메뉴</span></button>
             </div>
		</div>
		<!-- //HEADER -->
		
		