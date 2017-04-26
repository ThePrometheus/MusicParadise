<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<div class="col-lg-offset-1 col-sm-9 container general-content">
    <h2>My orders</h2>
     <c:forEach var="order" items="${orders}">
         <div class="list-group-item form-group list-item">
             <div class="row">

                 <div class="col-xs-12 align-items-center vcenter"> <strong>Order time: </strong>${order.order_time}</div>
                 <div class="col-xs-12 align-items-center vcenter"> <strong>Ship time </strong>${order.ship_time}</div>
                 <div class="col-xs-12 align-items-center vcenter"> <strong>Order id </strong>${order.id}</div>
                 <div class="col-xs-12 align-items-center vcenter"> <strong>Order price </strong>${order.price}</div>
                 <div class="col-xs-offset-4 col-xs-3 vcenter">
                     <a class="btn btn-default btn-sm accept_order"
                        href="/order/receipt/${order.id}">Details</a>
                 </div>
             </div>
         </div>
     </c:forEach>
</div>

<%@include file="footer.jsp" %>