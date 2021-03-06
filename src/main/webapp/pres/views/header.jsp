<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="blank.jsp" %>
<nav class="navbar navbar-default sidebar" role="navigation">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#bs-sidebar-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">MENU</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-sidebar-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <%--admin menu--%>
                <sec:authorize access="hasRole('ADMIN')">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Create...<span class="caret"></span>
                            <span style="font-size:16px;"
                                  class="pull-right hidden-xs showopacity glyphicon glyphicon-pencil"></span></a>
                        <ul class="dropdown-menu forAnimate" role="menu">
                            <li><a href="/dept/create">Department</a></li>
                            <li><a href="/instrument/create">Instrument</a></li>
                            <li><a href="/consultant/create">Consultant</a></li>


                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Interesting<span
                                class="caret"></span>
                            <span style="font-size:16px;"
                                  class="pull-right hidden-xs showopacity glyphicon glyphicon-stats"></span></a>
                        <ul class="dropdown-menu forAnimate" role="menu">
                            <li><a href="/stats/orders">Orders</a></li>
                            <li><a href="/stats/instruments">Instruments</a></li>
                            <li><a href="/stats/consultants">Consultants</a></li>

                        </ul>
                    </li>
                </sec:authorize>
                <%--client menu--%>
                <sec:authorize access="hasRole('CLIENT')">
                    <li><a href="/order/create">Choose your instrument <span style="font-size:16px;"
                                                                 class="pull-right hidden-xs showopacity glyphicon glyphicon-plus"></span></a>
                    </li>
                    <li><a href="/client/all_orders">My orders<span style="font-size:16px;"
                                                                    class="pull-right hidden-xs showopacity glyphicon glyphicon-list-alt"></span></a>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Interesting<span
                                class="caret"></span>
                            <span style="font-size:16px;"
                                  class="pull-right hidden-xs showopacity glyphicon glyphicon-stats"></span></a>
                      <%-- <ul class="dropdown-menu forAnimate" role="menu">
                            <li><a href="/stats/cars">Cars</a></li>
                            <li><a href="/stats/veterans">Veterans</a></li>
                        </ul>  --%>
                    </li>
                </sec:authorize>
                <sec:authorize access="hasRole('CONSULTANT')">
                    <li><a href="/consultant/orders_to_affirm">Manage corders<span style="font-size:16px;"
                                                                                 class="pull-right hidden-xs showopacity glyphicon glyphicon-home"></span></a>
                    </li>
                    <%--<li><a href="/staff/dispatcher/orders_awaiting">Manage orders<span style="font-size:16px;"
                                                                                       class="pull-right hidden-xs showopacity glyphicon glyphicon-list-alt"></span></a>
                    </li> --%>
                    <li><a href="/consultant/all_orders">ALl given orders <span style="font-size:16px;"
                                                                              class="pull-right hidden-xs showopacity glyphicon glyphicon-list"></span></a>
                    </li>
                   <%-- <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Interesting<span
                                class="caret"></span>
                            <span style="font-size:16px;"
                                  class="pull-right hidden-xs showopacity glyphicon glyphicon-stats"></span></a>
                        <ul class="dropdown-menu forAnimate" role="menu">
                            <li><a href="/stats/cars">Cars</a></li>
                            <li><a href="/stats/veterans">Veterans</a></li>
                        </ul>
                    </li> --%>
                </sec:authorize>

            </ul>
        </div>
    </div>
</nav>
<div class="main container">
