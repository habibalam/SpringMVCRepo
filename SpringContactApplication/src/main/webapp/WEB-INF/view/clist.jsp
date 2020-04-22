<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@taglib uri="http://www.springframework.org/tags" prefix="s"%>  
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <html>
     <head>
       <title>Contact List Contact Application-</title>   
         <s:url var= "url_css" value="/staticResource/css/style.css"/>
         <link href= "${url_css}" rel="stylesheet" type="text/css"/> 
    </head>
       <s:url var= "url_bg" value="/staticResource/image/imge.jpg"/>
 
  <body background="${url_bg}">
     <table border="1" width="80%" align="center">
        <tr>
           <td height="80px">
            <%-- header area--%> 
            <jsp:include page="include/header.jsp"/>
           </td>
        
         </tr>
        <tr>
           <td height="25px">
           <%-- menu area--%> 
           <jsp:include page="include/meanu.jsp"/>
           </td>
        </tr>
        
        <tr>
           <td height="350px" valign="top">
           <%-- content  area--%> 
           <h1>Contact List</h1>
            <table border="1">
               <tr>
                  <td>SR</td>
                  <td>CID</td>
                  <td>NAME</td>
                  <td>PHONE</td>
                  <td>EMAIL</td>
                  <td>ADDRESS</td>
                  <td>REMARK</td>
                  <td>ACTION</td>
               
               </tr> 
               
                <c:forEach var="c" items="${contactList}" varStatus="st">
                 <tr>
                  <td>${st.count}</td>
                  <td>${c.contactId}</td>
                  <td>${c.name }</td>
                  <td>${c.phone}</td>
                  <td>${c.email}</td>
                  <td>${c.address}</td>
                  <td>${c.remark }</td>
                  <td>Edit | Delete</td>
               
               </tr> 
               
               </c:forEach>
            </table> 
           </td>
        </tr>
        
        
        <tr>
           <td height="25px">
           <%-- footer area--%> 
           <jsp:include page="include/footer.jsp"/>
           </td>
        </tr>
     </table>
 </body>
 </html>   
   