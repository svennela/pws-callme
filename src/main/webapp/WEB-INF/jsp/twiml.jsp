<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String digits = request.getParameter("Digits");
System.out.println("digits"+digits);
response.setContentType("application/xml");
String xml="<Response><Say>Hi Dan,Thank you for contacting pivotal support, we are now connecting to support, please wait</Say><Dial><Number>afsaf</Number></Dial></Response>";
response.getWriter().print(xml);
%>
