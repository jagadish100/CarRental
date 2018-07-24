<%@page import="com.hcl.bean.CustomerBean"%>
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
List<CustomerBean> list=(List<CustomerBean>)request.getAttribute("customerlist");
%>
<% 
  if(list.size()> 0)
  {
	  %>
<h1> Customer details</h1>
<table border="1">
<th>Customer Id</th>
<th>Name</th>
<th>Username</th>
<th>Userpass</th>
<th>Gender</th>
<th>Address</th>
<th>Contact Number</th>
<th>Email id</th>
<%
for(CustomerBean bean: list)
{
	int customerid=bean.getCustomer_id();
	String name=bean.getName();
	String username=bean.getUsername();
	String userpass=bean.getUserpass();
	String gender=bean.getGender();
	String address=bean.getAddress();
	double contactno=bean.getContactno();
	String emailid=bean.getEmailid();
%>

<tr>
<td><%=customerid%></td> 
   <td><%=name%></td>  
   <td><%=username%></td>
    <td><%=userpass%></td>
     <td><%=gender%></td>
      <td><%=address%></td>
      <td><%=contactno%></td>
      <td><%=emailid%></td>
      
   <td><a href="CustomerDeleteServlet?CUSTOMER_ID=<%=customerid%>">DELETE</a> </td>
   <td><a href="CustomerUpdateServlet?CUSTOMER_USER_NAME=<%=username%>">UPDATE</a> </td>
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