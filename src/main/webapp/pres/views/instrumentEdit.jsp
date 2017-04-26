<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>

<div class="row">
    <div class="col-sm-6 container general-content">
        <h2>EDIT INSTRUMENT </h2>
        <!-- choose dept-->
        <div class="form-group">
            <label for="instr_dept">Department: </label>
            <c:if test="${firstEdit eq false}">
                <select class="form-control" id="instr_dept" disabled>
                    <option id="${department.id}"></option>
                </select>
            </c:if>
            <c:if test="${firstEdit eq true}">
                <select class="form-control" id="instr_dept">
                    <c:forEach items="${departments}" var="dept">
                        <option id="${dept.id}">${dept.address}</option>
                    </c:forEach>
                </select>
            </c:if>
        </div>

        <input id="instr_id" value="${instrument.id}" type="hidden">
        <div class="form-group" id="fg_instr_model">
            <label class="form-control-label">Insrument model: </label>
            <input class="form-control" type="text" placeholder="Type a model " id="instr_model" value="${instrument.model}">
        </div>
        <div class="form-group" id="fg_instr_category">
            <label class="form-control-label">Category: </label>
            <input type="text" class="form-control" id="instr_category" value="${instrument.category}">
        </div>
        <div class="form-group" id="fg_instr_trademark">
            <label class="form-control-label">Trademark: </label>
            <input type="text" class="form-control" id="instr_trademark" value="${instrument.trademark}">
        </div>
        <div class="form-group" id="fg_instrument_purchase_date">
            <label class="form-control-label">Purchase date: </label>
            <input type="date" class="form-control" id="instr_purchase_date"
                   value="${instrument.purchase_date}">
        </div>
        <div class="form-group" id="fg_instrument_sell_date">
            <label class="form-control-label">Sell date: </label>
            <input type="date" class="form-control" id="instr_sell_date"
                   value="${instrument.sell_date}">
        </div>
        <div class="form-group" id="fg_instrument_price">
            <label class="form-control-label">Price: </label>
            <input type="text" class="form-control" id="instr_price"
                   value="${instrument.price}">
        </div>
        <div class="form-group" id="fg_instrument_description">
            <label class="form-control-label">Desciption: </label>
            <input type="text" class="form-control" id="instr_desciption"
                   value="${instrument.desciption}">
        </div>

        <div class="form-group" id="fg_department">
            <label class="form-control-label">Department: </label>
            <input type="number" min="1"  class="form-control" id="department_id"
                   value="${instrument.department}">
        </div>


    </div>

    </div>
</div>

<%@include file="footer.jsp" %>