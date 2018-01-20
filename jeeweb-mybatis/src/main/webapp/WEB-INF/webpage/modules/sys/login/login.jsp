<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<!DOCTYPE html>
<html lang="en">

<head>
    <title><spring:message code="sys.site.title" arguments="${platformName}"/></title>
    <meta name="keywords" content="<spring:message code="sys.site.keywords" arguments="${platformName}"/>">
    <meta name="description" content="<spring:message code="sys.site.description" arguments="${platformName}"/>">
    
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="Thu, 19 Nov 1900 08:52:00 GMT">
    <!--Loading bootstrap css-->
    <link type="text/css" rel="stylesheet" href="${staticPath}/vendors/jquery-ui-1.10.4.custom/css/ui-lightness/jquery-ui-1.10.4.custom.min.css">
    <html:css  name="favicon,bootstrap,font-awesome,animate,pace,iCheck,toastr,bootstrapvalidator"/>
    <!--Loading style-->
    <link type="text/css" rel="stylesheet" href="${staticPath}/uadmin/css/themes/style1/orange-blue.css" class="default-style">
    <link type="text/css" rel="stylesheet" href="${staticPath}/uadmin/css/themes/style1/orange-blue.css" id="theme-change" class="style-change color-change">
    <link type="text/css" rel="stylesheet" href="${staticPath}/uadmin/css/style-responsive.css"> 
</head>

<body id="signin-page">
    <div class="page-form">
        <div class="top_con">
            <h2>四川省高校就业趋势分析系统</h2>
            <p>
                College employment trend analysis system of Sichuan
            </p>
        </div>
        <div class="bot_con">
            <div class="b_l_con">
                <p><img src="${staticPath}/uadmin/css/themes/style1/image/zhe.png"></p>
                <p><img src="${staticPath}/uadmin/css/themes/style1/image/pie.png"></p>
            </div>
            <div class="b_r_con">
                <form id="loginform" method="post" class="form bv-form" novalidate="novalidate"><button type="submit" class="bv-hidden-submit" style="display: none; width: 0px; height: 0px;"></button>
                    <div class="header-content">
                        <h1>登&nbsp;&nbsp;录</h1>
                    </div>
                    <div class="body-content">
                        <p>欢迎您！</p>
                        <div class="form-group">
                            <div class="input-icon right"><i class="fa fa-user"></i>
                                <input name="username" class="form-control" placeholder="用户名" required="" data-bv-field="username">
                            </div>
                            <small class="help-block" data-bv-validator="notEmpty" data-bv-for="username" data-bv-result="NOT_VALIDATED" style="display: none;">请填写必填项目</small></div>
                        <div class="form-group">
                            <div class="input-icon right"><i class="fa fa-key"></i>
                                <input name="password" type="password" class="form-control" placeholder="密码" required="" data-bv-field="password">
                            </div>
                            <small class="help-block" data-bv-validator="notEmpty" data-bv-for="password" data-bv-result="NOT_VALIDATED" style="display: none;">请填写必填项目</small></div>

                        <div class="form-group" style="margin-top:10px;">
                            <div class="pull-left">
                                <div class="checkbox-list">
                                </div>
                            </div>
                            <div class="pull-right">
                                <button type="submit" class="btn btn-success">登&nbsp;&nbsp;录 &nbsp;
                                    <i class="fa fa-chevron-circle-right"></i>
                                </button>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                        <b>
                        </b></div><b>

                    </b>
                </form>
            </div>
        </div>

    </div>
    <div class="copyright">Copyright©2017 版权所有</div>
    <b>

</b></body>

</html>