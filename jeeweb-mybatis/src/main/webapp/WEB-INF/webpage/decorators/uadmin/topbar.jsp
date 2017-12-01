<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<c:set var="menus" value="${fns:getMenuList()}" />
<c:set var="currentMenu" value="${fns:getCurrentMenu()}" />
<c:set var="pmenuids" value="${currentMenu.parentIds}" />
<!--BEGIN TOPBAR-->
<div id="header-topbar-option-demo" class="page-header-topbar">
    <nav id="topbar" role="navigation" style="margin-bottom: 0; z-index: 2;" class="navbar navbar-default navbar-static-top">
       <div class="navbar-header">
           <button type="button" data-toggle="collapse" data-target=".sidebar-collapse" class="navbar-toggle"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>
           </button><a id="logo" href="${adminPath}" class="navbar-brand"><span class="fa fa-rocket"></span><span class="logo-text">JeeWeb</span><span style="display: none" class="logo-text-icon">JW</span></a>
       </div>
       <div class="topbar-main"><a id="menu-toggle" href="#" class="hidden-xs"><i class="fa fa-bars"></i></a>
           <ul class="nav navbar-nav    ">
               <li class="active"><a href="${adminPath}">控制台</a>
               </li>
               <li><a href="javascript:;" data-toggle="dropdown" class="dropdown-toggle">Layouts&nbsp;<i class="fa fa-angle-down"></i></a>
           </ul>
       </div>
   </nav>
   <!--BEGIN MODAL CONFIG PORTLET-->
   <div id="change-password" class="modal fade">
       <div class="modal-dialog">
           <div class="modal-content">
               <div class="modal-header">
                   <button type="button" data-dismiss="modal" aria-hidden="true" class="close">&times;</button>
                   <h4 class="modal-title">修改密码</h4>
               </div>
               <div class="modal-body">
                  <form  id="changePasswordForm"  method="post" action="${adminPath}/sys/user/${fns:getUser().id}/changePassword" class="form"> 
	                <div class="form-group">
	                    <div class="input-icon right"><i class="fa fa-key"></i>
	                          <input type="password" value="" name="password"  class="form-control" datatype="*6-16" nullmsg="请设置密码！" errormsg="密码范围在6~16位之间！" />
		             		  <label class="Validform_checktip"></label>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <div class="input-icon right"><i class="fa fa-key"></i>
	                        <input type="password" value="" name="userpassword2" class="form-control" datatype="*" recheck="password" nullmsg="请再输入一次密码！" errormsg="您两次输入的账号密码不一致！" />
		             		<label class="Validform_checktip"></label>
	                    </div>
	                </div>
		          </form>
               </div>
               <div class="modal-footer">
                   <button type="button" data-dismiss="modal" class="btn btn-default">关闭</button>
                   <button type="button" class="btn btn-primary" onclick="changePassword()">修改密码</button>
               </div>
           </div>
       </div>
   </div>
   <!--END MODAL CONFIG PORTLET-->
</div>
<!--END TOPBAR-->