<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>

<div class="row">
    <div class="col-sm-6 container general-content">
        <h2>Consultant: </h2>
        <!-- choose dept-->
        <div class="form-group">
            <label for="consultant_dept">Department: </label>
            <c:if test="${firstEdit eq false}">
                <select class="form-control" id="consultant_dept" disabled>
                    <option id="${department.id}">${department.address}</option>
                </select>
            </c:if>
            <c:if test="${firstEdit eq true}">
                <select class="form-control" id="consultant_dept">
                    <c:forEach items="${departments}" var="dept">
                        <option id="${dept.id}">${dept.address}</option>
                    </c:forEach>
                </select>
            </c:if>
        </div>
        <div class="form-group" id="fg_consultant_login">
            <label class="form-control-label">Login: </label>
            <input class="form-control" type="text" id="consultant_login" value="${consultant.login}" <c:if test="${firstEdit eq false}">disabled</c:if>>
        </div>
        <c:if test="${firstEdit eq true}">
            <div class="form-group" id="fg_consultant_pass">
                <label class="form-control-label">Password: </label>
                <input class="form-control" type="password" id="consultant_pass">
            </div>
        </c:if>
        <div class="form-group" id="fg_consultant_sur_name">
            <label class="form-control-label">Surname: </label>
            <input type="text" class="form-control" id="consultant_full_name" value="${consultant.surname}">
        </div>
        <div class="form-group" id="fg_consultant_first_name">
            <label class="form-control-label">First name: </label>
            <input type="text" class="form-control" id="consultant_first_name" value="${consultant.firstName}">
        </div>
        <div class="form-group" id="fg_consultant_middle_name">
            <label class="form-control-label">Middle name: </label>
            <input type="text" class="form-control" id="consultant_middle_name" value="${consultant.middlename}">
        </div>
        <div class="form-group" id="fg_consultant_birth_date">
            <label class="form-control-label">Birth date(format Year-Month-Date </label>
            <input type="text" class="form-control" id="consultant_birth_date" value="${consultant.birth_date}">
        </div>
        <div class="form-group" id="fg_consultant_tel_num">
            <label class="form-control-label">Phone number: </label>
            <input type="tel" placeholder="+380XXXXXXXXX" class="form-control" id="consultant_tel_num"
                   value="${consultant.telephone_number}">
        </div>
        <div class="form-group">
            <label for="consultant_is_admin">Position: </label>
            <select class="form-control" id="consultant_is_admin" >
                <option id="false">Consultant</option>
                <option id="true">Admin<option>
            </select>
        </div>
       <%--v class="form-check" id="worker_licenses" <c:if test="${driver.isDriver eq false}">hidden</c:if>>
            <label>Licenses: </label>
            <label class="form-check-label">
                <input type="checkbox" id="A" class="form-check-input" <c:if test="${fn:contains(driver.licenses, 'A')}">checked</c:if>>
                A
            </label>
            <label class="form-check-label">
                <input type="checkbox" id="B" class="form-check-input" <c:if test="${fn:contains(driver.licenses, 'B')}">checked</c:if>>
                B
            </label>
            <label class="form-check-label">
                <input type="checkbox" id="C" class="form-check-input" <c:if test="${fn:contains(driver.licenses, 'C')}">checked</c:if>>
                C
            </label>
            <label class="form-check-label">
                <input type="checkbox" id="D" class="form-check-input" <c:if test="${fn:contains(driver.licenses, 'D')}">checked</c:if>>
                D
            </label>
        </div>
    </div>
  <%--  <div class="col-sm-5 container additional-content">
        <h2>Map view:</h2>
        <img src="//maps.googleapis.com/maps/api/staticmap?center=
        <c:if test="${firstEdit eq true}">${departments[0].city}</c:if>
        <c:if test="${firstEdit eq false}">${department.city}</c:if>
        &zoom=13&size=680x400&maptype=roadmap
&key=${gApiKey}" class="img-responsive static_map" alt="Static map" id="worker_static_map">
        <c:if test="${firstEdit eq true}">
            <div class="btn btn-lg btn-primary main-btn" id="btn_worker_create">Create</div>
        </c:if>
        <c:if test="${firstEdit eq false}">
            <div class="btn btn-lg btn-primary main-btn" id="btn_worker_edit">Edit</div>
        </c:if>

    </div>
</div>
--%>

<%@include file="footer.jsp" %>