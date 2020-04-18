<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
    <c:when test="${!empty listdto }">
    <center><table align:center border="1" color:red>
     <tr style="color:red">
      <th>SrNo.</th>  <th>EmpNo.</th> <th>EmpName.</th> <th>Designation.</th> <th>Salary.</th> <th>DeptNo.</th>
     </tr>
     <c:forEach var="dto" items="${listdto}">
      <tr bgcolor="yellow">
      <td>${dto.srNo}</td>
      <td>${dto.empNo}</td>
      <td>${dto. ename}</td>
      <td>${dto.job}</td>
      <td>${dto.esal}</td>
      <td>${dto.deptNo}</td>
       
       </tr>
     </c:forEach>
    </table></center>
    </c:when>
    
    <c:otherwise>
    
      <h1 style="text-align:center;color:red">Rcord Not found:-</h1>
    </c:otherwise>
  </c:choose>
  <br>
  <a href="welcome.htm">Back to home page</a>