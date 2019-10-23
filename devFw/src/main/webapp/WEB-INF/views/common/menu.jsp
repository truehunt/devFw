<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

	<div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li class="sidebar-search">
                           	<form id="searchForm" name="searchForm"  method="post" action="boardList">
                                <input type="hidden" name="searchType" value="brdtitle,brdmemo">
								<div class="input-group custom-search-form">
	                                <input class="form-control" type="text" name="globalKeyword" id="globalKeyword" placeholder="검색어를 입력하세요">
	                                <span class="input-group-btn">
	                                    <button class="btn btn-default" type="button" onclick="fn_search()">
	                                        <i class="fa fa-search"></i>
	                                    </button>
	                                </span>
	                            </div>                           	
                            </form>
	                                <script>
	                                	function fn_search(){
	                                		if ($("#globalKeyword").val()!=="") {
		                                		$("#searchForm").submit();
	                                		}
	                                	}
	                                </script>                            <!-- /input-group -->
                        </li>
                        <!-- 관리자메뉴 --> 
                        <c:if test='${sessionScope.SAWON_VIEW_PERMISSION == "A"}'>  
	                        <li>
	                            <a href="#"> <s:message code="memu.admin"/></a>
	                        </li>
	                        <li>
	                            <a href="adBoardGroupList"><i class="fa fa-files-o fa-fw"></i> <s:message code="memu.board"/></a>
	                        </li>
	                        <li>
	                            <a href="#"><i class="fa fa-sitemap fa-fw"></i> 등록정보관리<span class="fa arrow"></span></a>
	                            <ul class="nav nav-second-level">
	                                <li>
	                                    <a href="adDepartment">사업장등록</a>
	                                </li>
	                                <li>
	                                    <a href="adUser">부서등록</a>
	                                </li>
	                                <li>
	                                    <a href="adUser">사원등록</a>
	                                </li>
	                                <li>
	                                    <a href="adUser">사용자권한설정</a>
	                                </li>
	                            </ul>
	                        </li>
	                        <li>
	                            <a href="#"><i class="fa fa-sitemap fa-fw"></i> 기초환경설정<span class="fa arrow"></span></a>
	                            <ul class="nav nav-second-level">
	                                <li>
	                                    <a href="adDepartment">호봉테이블등록</a>
	                                </li>
	                                <li>
	                                    <a href="adUser">급/상여 지급일자 등록</a>
	                                </li>
	                                <li>
	                                    <a href="adUser">인사/급여환경설정</a>
	                                </li>
	                                <li>
	                                    <a href="adUser">인사기초코드등록</a>
	                                </li>
	                            </ul>
	                        </li>
	                        <li>
	                            <a href="#"><i class="fa fa-sitemap fa-fw"></i> 인사관리<span class="fa arrow"></span></a>
	                            <ul class="nav nav-second-level">
	                                <li>
	                                    <a href="adDepartment">인사기록카드</a>
	                                </li>
	                                <li>
	                                    <a href="adUser">인사정보등록</a>
	                                </li>
	                                <li>
	                                    <a href="adUser">인사발령등록</a>
	                                </li>
	                                <li>
	                                    <a href="adUser">인사발령(사원별)</a>
	                                </li>
	                                <li>
	                                    <a href="adUser">인사발령공고</a>
	                                </li>
	                                <li>
	                                    <a href="adUser">인사발령리포트</a>
	                                </li>
	                            </ul>
	                        </li>
                             <li>
                                 <a href="adSignDocTypeList"><i class="fa fa-sitemap fa-fw"></i> 결재문서양식</a>
                             </li>
                             <li>
                                 <a href="adCodeList"><i class="fa fa-sitemap fa-fw"></i> 공통코드관리</a>
                             </li>
	                	</c:if>
                        <!-- 일반 사원 단 조회 가능메뉴들 -->
                        <li>
                            <a href="#"><i class="fa fa-edit fa-fw"></i> 인사관리<span class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
                                <li>
                                    <a href="signDocTypeList">내정보보기</a>
                                </li>
	                        </ul>                             
                        </li>
                         <!-- 근태/연차 관리 -->
                        <li>
                            <a href="#"><i class="fa fa-edit fa-fw"></i> 근태/연차관리<span class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
                                <li>
                                    <a href="signDocTypeList">일일근태등록</a>
                                </li>
                                <li>
                                    <a href="signDocTypeList">월마감관리</a>
                                </li>
                                <li>
                                    <a href="signDocTypeList">월근태마감</a>
                                </li>
                                <li>
                                    <a href="signDocTypeList">휴일연장야간근무관리</a>
                                </li>
                                <li>
                                    <a href="signDocTypeList">휴가조회신청</a>
                                </li>
                                <li>
                                    <a href="signDocTypeList">출장조회신청</a>
                                </li>
                                <li>
                                    <a href="signDocTypeList">외근보고서작성</a>
                                </li>
                                <li>
                                    <a href="signDocTypeList">휴가일수계산</a>
                                </li>
	                        </ul>                             
                        </li> 
                        <!-- 급여/퇴직정산관리 -->
                        <li>
                            <a href="#"><i class="fa fa-edit fa-fw"></i> 급여/퇴직정산관리<span class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
                                <li>
                                    <a href="signDocTypeList">근태결과입력</a>
                                </li>
                                <li>
                                    <a href="signDocTypeList">급여입력 및 계산</a>
                                </li>
                                <li>
                                    <a href="signDocTypeList">급여이체현황</a>
                                </li>
                                <li>
                                    <a href="signDocTypeList">퇴직기준설정</a>
                                </li>
                                <li>
                                    <a href="signDocTypeList">퇴직금산정</a>
                                </li>
                                <li>
                                    <a href="signDocTypeList">퇴직금산정현황</a>
                                </li>
	                        </ul>                             
                        </li>
                        <!-- 일정관리 -->             
                        <li>
                            <a href="/devFw/schList"><i class="fa fa-calendar fa-fw"></i> 일정관리</a>
                        </li>
                        <!-- 기존 있던 소스 -->   
                        <!-- 게시판 -->
                        <li>
                            <a href="boardList"><i class="fa fa-files-o fa-fw"></i> <s:message code="board.boardName"/></a>
                        </li>        
                        <!-- 메일 -->                        
                        <li>
                            <a href="#"><i class="fa fa-envelope-o fa-fw"></i> 메일<span class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
                                <li>
                                    <a href="mailForm">새메일</a> 
                                </li>
                                <li>
		                            <a href="receiveMails">받은 메일</a>
                                </li>
                                <li>
		                            <a href="sendMails">보낸 메일</a>
                                </li>
	                        </ul>                             
                        </li>                        
                       
                        	        
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->

