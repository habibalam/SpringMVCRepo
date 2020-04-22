<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags"  prefix="s" %>

<s:url var="url_logout" value="/logout"/>

<c:if test="${sessionScope.userId==null}">
<s:url var="url_reg_from" value="/reg_from"/>

<%--user is not logged in here  guest menu--%>
<a href="#">Home</a> | 
<a href="#">Login</a> |
<a href="${url_reg_from}">Register</a> |
<a href="#">About</a> |
<a href="#">Help</a>
</c:if>



<c:if test="${sessionScope.userId!=null && sessionScope.role == 1}">
<%--Admin is logged in Admin menu--%>
<a href="#">Home</a>|
<a href="#">User List</a>|
<a href="${url_logout}">Logout</a>|
<a href="#">Help</a>
</c:if>

<c:if test="${sessionScope.userId!=null && sessionScope.role == 2}">
<%--genral user logged in user  menu--%>

<s:url var="url_uhome" value="/user/dashboard"/>
<s:url var="url_cform" value="/user/contact_form"/>
<s:url var="url_clist" value="/user/clist"/>
<a href="${url_uhome}">Home</a>|
<a href="${url_cform}">AddContact</a>|
<a href="${url_clist}">Contact List</a>|
<a href="${url_logout}">Logout</a>|
<a href="#">Help</a>
</c:if>


