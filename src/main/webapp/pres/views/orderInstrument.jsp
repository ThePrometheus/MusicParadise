<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach var="order_instrument" items="${order_instruments}">
    <div class="list-group-item list-item">
        <div class="row">
            <div class="col-sm-3 col-xs-11 align-items-center vcenter"> Price ${order_instrument.instrument.model} ${order_instrument.instrument.category} ${order_instrument.isntrument.price} </div>
            <div class="col-sm-4 col-xs-12 align-items-center vcenter"> Consultant ${order_instrument.conulstant}</div>
            <div class="col-sm-2 col-xs-12 align-items-center vcenter">
                <c:if test="${order_instrument.enabled eq false}">
                    <span class="label label-success n-service vcenter">Your order is enabled </span>
                </c:if>
            </div>
            <div class="col-sm-1 col-sm-offset-1 col-xs-offset-8 col-xs-3 vcenter">order_id="${order_instrument.order.id}"
                </span>
            </div>
        </div>
    </div>
</c:forEach>