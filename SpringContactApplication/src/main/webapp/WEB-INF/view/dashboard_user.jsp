<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@taglib uri="http://www.springframework.org/tags" prefix="s"%>  
 <html>
     <head>
       <title>User DashBoard Contact Application-</title>   
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
           <h1>User DashBoard</h1>
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
   