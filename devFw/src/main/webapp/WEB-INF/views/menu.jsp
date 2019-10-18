<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<ul class="sidebar navbar-nav">



 <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-fw fa-folder"></i>
            <span>인사관리</span>
          </a>
          <div class="dropdown-menu" aria-labelledby="pagesDropdown">
            <h6 class="dropdown-item">인사기록카드</h6>       <!--<h6 class="dropdown-header">Login Screens:</h6>-->
            <a class="dropdown-item" href="login">인사정보등록</a>         
            <a class="dropdown-item" href="login">인사발령등록</a>
            
            <a class="dropdown-item" href="register">인사발령(사원별)</a>
            <a class="dropdown-item" href="forgot-password">인사발령공고</a>
             <a class="dropdown-item" href="forgot-password">인사발령리포트</a>
          </div>
        </li>
        
        
        
     <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-fw fa-folder"></i>
            <span>근태관리</span>
          </a>
          <div class="dropdown-menu" aria-labelledby="pagesDropdown">
          
            <h6 class="dropdown-header" >출퇴근</h6>
            <a class="dropdown-item" href="login">일일근태등록</a>
            <a class="dropdown-item" href="login">월마감관리</a>
            <a class="dropdown-item" href="register">월근태마감</a>
            <a class="dropdown-item" href="forgot-password">휴일연장야간근무관리</a><br>
            <div class="dropdown-divider"></div>
            <h6 class="dropdown-header">휴가/출장/외근</h6>
            <a class="dropdown-item" href="404">휴가조회신청</a>
            <a class="dropdown-item" href="blank">출장조회신청</a>
            <a class="dropdown-item" href="blank">외근보고서작성</a><br>
             <div class="dropdown-divider"></div>
            <h6 class="dropdown-header">연차관리</h6>
            <a class="dropdown-item" href="404">휴가일수계산</a>
          </div>
        </li>


 <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-fw fa-folder"></i>
            <span>기초설정관리</span>
          </a>
          <div class="dropdown-menu" aria-labelledby="pagesDropdown">
            <h6 class="dropdown-header">등록정보관리</h6><a class="dropdown-item" href="login">회사등록</a>
            <a class="dropdown-item" href="login">사업장등록</a>
            <a class="dropdown-item" href="register">부서등록</a>
            <a class="dropdown-item" href="forgot-password">사원등록</a>
            <a class="dropdown-item" href="forgot-password">사용자권한설정</a><br>
            
            <div class="dropdown-divider"></div>
            <h6 class="dropdown-header">기초환경설정</h6>
            <a class="dropdown-item" href="404">호봉테이블등록</a>
            <a class="dropdown-item" href="blank">급/상여 지급일자 등록</a>
            <a class="dropdown-item" href="blank">인사/급여환경설정</a>
            <a class="dropdown-item" href="blank">인사기초코드등록</a>
            
          </div>
        </li>
        
          <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-fw fa-folder"></i>
            <span>급여/퇴직정산관리</span>
          </a>
          <div class="dropdown-menu" aria-labelledby="pagesDropdown">
            <h6 class="dropdown-header">급여관리</h6>
            <a class="dropdown-item" href="login">근태결과입력</a>
            <a class="dropdown-item" href="register">급여입력및계산</a>
            <a class="dropdown-item" href="forgot-password">급여이체현황</a><br>
            <div class="dropdown-divider"></div>
            <h6 class="dropdown-header">퇴직정산관리</h6>
            <a class="dropdown-item" href="404">퇴직기준설정</a>
            <a class="dropdown-item" href="blank">퇴직금산정</a>
            <a class="dropdown-item" href="blank">퇴직금산정현황</a>
            
          </div>
        </li>
        
        
 <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-fw fa-folder"></i>
            <span>결재문서함</span>
          </a>
          <div class="dropdown-menu" aria-labelledby="pagesDropdown">
            <a class="dropdown-header">새결재진행</a>
              <a class="dropdown-item" href="404">새결재진행</a><br>
            <div class="dropdown-divider"></div>
            <h6 class="dropdown-header">자주쓰는양식</h6>
            <a class="dropdown-item" href="404">blank</a>
            <a class="dropdown-item" href="blank">blank</a><br><br>
            <h6 class="dropdown-header">결재문서함</h6>
            <a class="dropdown-item" href="404">미결재문서</a>
            <a class="dropdown-item" href="blank">결재완료문서</a>
            <a class="dropdown-item" href="login">전체미결문서</a>
            <a class="dropdown-item" href="register"></a><br><br>
             <h6 class="dropdown-header">결재문서함</h6>
            <a class="dropdown-item" href="404">상신문서</a>
            <a class="dropdown-item" href="blank">임시보관</a>
            <a class="dropdown-item" href="login">결재완료</a>
            <a class="dropdown-item" href="register">회수문서</a>
            <a class="dropdown-item" href="forgot-password">반려문서</a>
            <a class="dropdown-item" href="forgot-password">수신문서함</a><br>
            <a class="dropdown-header" >부서문서함</a>
            <a class="dropdown-item" href="forgot-password">부서문서함</a>
       
          </div>
        </li>
      </ul>
      
      
      
      
      
      
     