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
	                                <input class="form-control" type="text" name="globalKeyword" id="globalKeyword" placeholder="원하는 메뉴를 검색하세요">
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
                        <li>
                            <a href="boardList"><i class="fa fa-files-o fa-fw"></i> <s:message code="board.boardName"/></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-edit fa-fw"></i> 전자결재<span class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
                                <li>
                                    <a href="signDocTypeList">기안하기</a>
                                </li>
                                <li>
		                            <a href="signListTobe">결재 받을(은) 문서 </a>
                                </li>
                                <li>
		                            <a href="signListTo">결재 할(한) 문서</a>
                                </li>
	                        </ul>                             
                        </li>                        
                        <li>
                            <a href="schList"><i class="fa fa-calendar fa-fw"></i> 일정관리</a>
                        </li>                        
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
                       
                        <c:if test='${sessionScope.userrole == "A"}'>
	                        <li>
	                            <a href="#"> <s:message code="memu.admin"/></a>
	                        </li>
	                        <li>
	                            <a href="adBoardGroupList"><i class="fa fa-files-o fa-fw"></i> <s:message code="memu.board"/></a>
	                        </li>
	                        <li>
	                            <a href="#"><i class="fa fa-sitemap fa-fw"></i> <s:message code="memu.organ"/><span class="fa arrow"></span></a>
	                            <ul class="nav nav-second-level">
	                                <li>
	                                    <a href="adDepartment"><s:message code="memu.dept"/></a>
	                                </li>
	                                <li>
	                                    <a href="adUser"><s:message code="memu.user"/></a>
	                                </li>
	                            </ul>
	                        </li>
                             <li>
                                 <a href="adSignDocTypeList"><i class="fa fa-edit fa-fw"></i> 결재문서양식</a>
                             </li>
	                	</c:if>	        
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->

