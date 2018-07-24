<%@page import="com.hcl.bean.CarBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
List<CarBean> list=(List<CarBean>)request.getAttribute("list");
%>
<% 
  if(list.size()> 0)
  {
	  %>
<h1> Car details</h1>
<table border="1">
<th>carid</th>
<th>carname</th>
<th>carnumber</th>
<th>carseater</th>
<th>cartype</th>
<%
for(CarBean bean: list)
{
	int carid=bean.getCarid();
	
	String carname=bean.getCarname();
	String carnumber=bean.getCarnumber();
	int carseater=bean.getCarseater();
	String cartype=bean.getCartype();
%>

<tr>
   <td><%=carid%></td>  
   <td><%=carname%></td>
    <td><%=carnumber%></td>
     <td><%=carseater%></td>
      <td><%=cartype%></td>
      
   <td><a href="CarDeleteServlet?car_id=<%=carid%>">DELETE</a> </td>
   <td><a href="CarUpdateServlet?carname=<%=carname%>">UPDATE</a> </td>
  </tr> 
  <%
 }
  %>
</table>
<%
  }
  else
  {
	  out.println(" NO RECORD FOUND ");
  }
  %>
</body>
</html>