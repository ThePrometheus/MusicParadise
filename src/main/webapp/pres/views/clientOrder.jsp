<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<div class="row">
    <div class="col-sm-6 container general-content">
        <div id="map"></div>

    </div>
    <div class="col-sm-5 container general-content" id="area_to_print">
        <h2>Order info:</h2>
        <div style="float: right" class="btn btn-default" id="print_order"><span class="glyphicon glyphicon-print"></span> </div>
        <div class="row">

            <div class="col-xs-12 align-items-center vcenter"> ${client_order.client.surname + " " + client_order.client.firstname}
                t:${client_order.client.phoneNumber}</div>
            <div class="col-xs-12 align-items-center vcenter"><strong>Ordered:  </strong>${client_order.order.order_time}
            </div>
            <div class="col-xs-12 align-items-center vcenter"><strong>Must be shipped </strong>${client_order.order.ship_time}
            </div>
            <div class="col-xs-12 align-items-center vcenter"><strong>Is shipped </strong>${client_order.order.shipped}
            </div>
            <div class="col-xs-12 align-items-center vcenter"><strong>Price: </strong>${client_order.order.price}
            </div>

            <div class="col-xs-12 align-items-center vcenter"><strong>Instrument: </strong>
                <c:choose>
                    <c:when test="${not empty order_instrument_list}">
                        <c:forEach items="${order_instrument_list}" var="order_instrument">
                            ${order_instrument.instrument.model}<br>
                            ${order_instrument.instrument.category}<br>
                            ${order_instrument.instrument.price}<br>
                        </c:forEach>

                    </c:when>
                    <c:otherwise>
                        n/a
                    </c:otherwise>
                </c:choose>
            </div>

            <div class="col-xs-12 align-items-center vcenter"><strong>Consultant: </strong>
                <c:choose>
                    <c:when test="${not empty consultant}">
                        ${consultant.surname}<br>
                        ${consultant.firstname}<br>

                    </c:when>
                    <c:otherwise>
                        n/a
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
        <%--
        <form id="ratingsForm">
            <div class="stars">
                <input type="radio" name="star" class="star-1" rate="1" id="star-1"
                       <sec:authorize access="!hasRole('CLIENT')">disabled</sec:authorize>>
                <label class="star-1" for="star-1">1</label>
                <input type="radio" name="star" class="star-2" rate="2" id="star-2"
                       <sec:authorize access="!hasRole('CLIENT')">disabled</sec:authorize>>
                <label class="star-2" for="star-2">2</label>
                <input type="radio" name="star" class="star-3" rate="3" id="star-3"
                       <sec:authorize access="!hasRole('CLIENT')">disabled</sec:authorize>>
                <label class="star-3" for="star-3">3</label>
                <input type="radio" name="star" class="star-4" rate="4" id="star-4"
                       <sec:authorize access="!hasRole('CLIENT')">disabled</sec:authorize>>
                <label class="star-4" for="star-4">4</label>
                <input type="radio" name="star" class="star-5" rate="5" id="star-5"
                       <sec:authorize access="!hasRole('CLIENT')">disabled</sec:authorize>>
                <label class="star-5" for="star-5">5</label>
                <span></span>
            </div>
        </form>
        <sec:authorize access="hasRole('CLIENT')">
            <div class="btn btn-lg btn-primary main-btn" order_id="${client_order.order.id}" id="btn_rate_order"
                 <c:if test="${empty client_order.order.finishTime}">disabled</c:if>
            >Rate!
            </div>
        </sec:authorize>
        --%>
    </div>
</div>

<link rel="stylesheet" href="<c:url value="../css/stars.css"/>"/>


<%@include file="footer.jsp" %>