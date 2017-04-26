

$(function () {
    $("#footer").hide();



    //MENU UI
    htmlbodyHeightUpdate()
    $(window).resize(function () {
        htmlbodyHeightUpdate()
    });
    $(window).scroll(function () {
        height2 = $('.main').height()
        htmlbodyHeightUpdate()
    });


    //car add/edit validation
    var addEditInstrument = function (e, firstEdit) {
        if ($(this).attr('disabled')) {
            return;
        }
        var instrument;
        if (!firstEdit) {
            instrument = {
                id: $('#instr_id').val(),
                model: $('#instr_model').val(),
                category: $('#instr_category').val(),
                trademark: $('#instr_trademark').val(),
                company_index: $('#instr_company_index').val(),
                purchase_date: $('#instr_purchase_date').val(),
                sell_date: $('#instr_sell_date').val(),
                functioning: $('#instr_func').val(),
                department_id: $('#instr_department').find('option:selected').attr('id'),
                price: $('#instr_price').val(),
                description: $('#instr_description').val()
            }
        } else {
            instrument = {
                model: $('#instr_model').val(),
                category: $('#instr_category').val(),
                trademark: $('#instr_trademark').val(),
                company_index: $('#instr_company_index').val(),
                purchase_date: $('#instr_purchase_date').val(),
                sell_date: $('#instr_sell_date').val(),
                functioning: $('#instr_func').val(),
                department_id: $('#instr_department').find('option:selected').attr('id'),
                price: $('#instr_price').val(),
                description: $('#instr_description').val()
            }
        }

        var error = false;

        if (instrument.trademark.length === 0) {
            error = true;
            $('#fg_instrument_trademark').addClass('has-warning')
            $.notify({
                icon: 'glyphicon glyphicon-warning-sign',
                title: 'Error on Instrument trademark!',
                message: 'Input instrument trademark',
                target: '_blank'
            }, {
                type: 'warning'
            });
        }
        if (instrument.model.length === 0) {
            error = true;
            $('#fg_instrument_model').addClass('has-warning');
            $.notify({
                icon: 'glyphicon glyphicon-warning-sign',
                title: 'Error on instrument model!',
                message: 'No model found',
                target: '_blank'
            }, {
                type: 'warning'
            });
        }

        if (isNaN(instrument.price) || instrument.price < 0) {
            error = true;
            $('#fg_instrument_price').addClass('has-warning');
            $.notify({
                icon: 'glyphicon glyphicon-warning-sign',
                title: 'Error on price of instrument!',
                message: 'Price should be a valid number ',
                target: '_blank'
            }, {
                type: 'warning'
            });
        }

        if (!error) {
            $('#fg_instrument_model').removeClass('has-warning');
            $('#fg_instrument_category').removeClass('has-warning');
            $('#fg_instrument_trademark').removeClass('has-warning');
            $('#fg_instrument_purchase_date').removeClass('has-warning');
            $('#fg_instrument_sell_date').removeClass('has-warning');
            $('#fg_instrument_price').removeClass('has-warning');
            $('#btn_instrument_edit').attr('disabled', true);
            $('#btn_instrument_create').attr('disabled', true);
            $.notify({
                icon: 'glyphicon glyphicon-envelope',
                title: 'request sent: ',
                message: 'waiting for response',
                target: '_blank'
            }, {
                type: 'info',
                showProgressbar: true
            });
            $.ajax({
                method: 'POST',
                url: (firstEdit) ? '/instrument/create' : ('/instrument/edit'),
                contentType: 'application/json; charset=UTF-8',
                data: JSON.stringify(instrument),
                dataType: 'json',
                success: function () {
                    $.notify({
                        icon: 'glyphicon  glyphicon-ok',
                        title: 'Success: ',
                        message: 'Instrument modified',
                        target: '_blank'
                    }, {
                        type: 'success'
                    });

                    $(this).attr('disabled', false);
                    //TO-DO: redirect after 10 sec. if success
                },
                error: function () {
                    $.notify({
                        icon: 'glyphicon glyphicon-remove',
                        title: 'Error: ',
                        message: 'did not changed instrument',
                        target: '_blank'
                    }, {
                        type: 'danger'
                    });
                    $(this).attr('disabled', false);
                }
            });
        }
    };

    $('#btn_instrument_create').click(function (e) {
        addEditInstrument(e, true);
    });
    $('#btn_instrument_edit').click(function (e) {
        addEditInstrument(e, false);
    });

    //consultanat add/edit validation
    var addEditConsultant = function (elem, firstEdit) {
        if (elem.attr('disabled')) {
            return;
        }
        var error = false;
        var consultant
        if(!firstEdit){
            consultant = {
                id: $('#consultant_id').val(),
                surname: $('#consultant_full_name').val(),
                firstname: $('#consultant_first_name').val(),
                middlename: $('#consultant_middle_name').val(),
                birth_date: $('#consultant_birth_date').val(),
                telephone_number: $('#consultant_tel_num').val(),
                salary: $('#consultant_salary').val(),
                department_id: $('#consultant_dept').find('option:selected').attr('id'),
                login: $('#consultant_login').val(),


            };
            console.log(consultant);
            }
        else {
         consultant = {

           // password: $('#consultant_pass').val(),
            surname: $('#consultant_full_name').val(),
            firstname: $('#consultant_first_name').val(),
            middlename: $('#consultant_middle_name').val(),
            birth_date: $('#consultant_birth_date').val(),
            telephone_number: $('#consultant_tel_num').val(),
            salary: $('#consultant_salary').val(),
            department_id: $('#consultant_dept').find('option:selected').attr('id'),
            login: $('#consultant_login').val(),


        };
        }

        var user  = {
            login: $('#consultant_login').val(),
            password: $('#consultant_pass').val(),
            role: 'CONSULTANT'

        };
        if(user.password.length==0  || user.login.length==0){
            $('#fg_consultant_login').addClass('has-warning');
            $.notify({
                icon: 'glyphicon glyphicon-remove',
                title: 'No login',
                message: 'input login in the field',
                target: '_blank'
            }, {
                type: 'warning'
            });

        }


        if (consultant.login.length === 0) {
            error = true;
            $('#fg_consultant_login').addClass('has-warning');
            $.notify({
                icon: 'glyphicon glyphicon-remove',
                title: 'Wrong login',
                message: 'Input unique(for consultant) login',
                target: '_blank'
            }, {
                type: 'warning'
            });
        }

        if (consultant.surname.length === 0) {
            error = true;
            $('#fg_consultant_sur_name').addClass('has-warning');
            $.notify({
                icon: 'glyphicon glyphicon-remove',
                title: 'Blank fiel',
                message: 'surname is  wrong',
                target: '_blank'
            }, {
                type: 'warning'
            });
        }
        if (consultant.middlename.length === 0) {
            error = true;
            $('#fg_consultant_middle_name').addClass('has-warning');
            $.notify({
                icon: 'glyphicon glyphicon-remove',
                title: 'Blank field',
                message: 'fill middlename',
                target: '_blank'
            }, {
                type: 'warning'
            });
        }
        if (consultant.firstname.length === 0) {
            error = true;
            $('#fg_consultant_first_name').addClass('has-warning');
            $.notify({
                icon: 'glyphicon glyphicon-remove',
                title: 'Blank field!',
                message: 'Wrong firstname',
                target: '_blank'
            }, {
                type: 'warning'
            });
        }
        if (!(/^\+[0-9]{12}$/.test(consultant.telephone_number))) {
            error = true;
            $('#fg_consultant_tel_num').addClass('has-warning');
            $.notify({
                icon: 'glyphicon glyphicon-remove',
                title: 'Error on phone number!',
                message: 'Not valid number',
                target: '_blank'
            }, {
                type: 'warning'
            });
        }

        if (!error) {
            console.log(consultant);
            $('#fg_consultant_login').removeClass('has-warning');
            $('#fg_consultant_pass').removeClass('has-warning');
            $('#fg_consultant_sur_name').removeClass('has-warning');
            $('#fg_consultant_middle_name').removeClass('has-warning');
            $('#fg_consultant_first_name').removeClass('has-warning');
            $('#fg_consulant_tel_num').removeClass('has-warning');

            elem.attr('disabled', true);
            $.notify({
                icon: 'glyphicon glyphicon-envelope',
                title: 'reuqest sent: ',
                message: 'waiting for  resposne',
                target: '_blank'
            }, {
                type: 'info',
                showProgressbar: true
            });
            if(firstEdit) {
                $.ajax({
                    method: 'POST',
                    url: '/user/create',
                    contentType: 'application/json; charset=UTF-8',
                    data: JSON.stringify(user),
                    dataType: 'json',
                    success: function (data) {
                        if (data.code === '200') {
                            $.notify({
                                icon: 'glyphicon glyphicon-ok',
                                title: 'Created: ',
                                message: 'user is created',
                                target: '_blank'
                            }, {
                                type: 'success'
                            });
                        } else {
                            $.notify({
                                icon: 'glyphicon glyphicon-envelope',
                                title: 'Error: ' + data.code,
                                message: 'Waiting for user modification: ' + data.message,
                                target: '_blank'
                            }, {
                                type: 'success'
                            });
                        }
                        elem.attr('disabled', false);
                    },
                    error: function (data) {
                        $.notify({
                            icon: 'glyphicon glyphicon-remove',
                            title: 'Error: ' + data.code,
                            message: 'user is not created;creation of consultant is impossible' + data.message,
                            target: '_blank'
                        }, {
                            type: 'danger'
                        });
                        elem.attr('disabled', false);
                    }
                });

            }


            $.ajax({
                method: 'POST',
                url: (firstEdit) ? '/consultant/create' : ('/consultant/edit'),
                contentType: 'application/json; charset=UTF-8',
                data: JSON.stringify(consultant),
                dataType: 'json',
                success: function (data) {
                    if (data.code === '200') {
                        $.notify({
                            icon: 'glyphicon glyphicon-ok',
                            title: 'Created: ',
                            message: 'consultant',
                            target: '_blank'
                        }, {
                            type: 'success'
                        });
                    } else {
                        $.notify({
                            icon: 'glyphicon glyphicon-ok',
                            title: 'Waiting: ' + data.code,
                            message: 'Could but wait to  modify consultant' + data.message,
                            target: '_blank'
                        }, {
                            type: 'info'
                        });
                    }
                    elem.attr('disabled', false);
                },
                error: function (data) {
                    $.notify({
                        icon: 'glyphicon glyphicon-remove',
                        title: 'Error: ' + data.code,
                        message: 'Could not modify consultant' + data.message,
                        target: '_blank'
                    }, {
                        type: 'danger'
                    });
                    elem.attr('disabled', false);
                }
            });
        }
    };
    $('#btn_consultant_create').click(function (e) {
        addEditConsultant($(this), true);
    });
    $('#btn_consultant_edit').click(function (e) {
        addEditConsultant($(this), false);
    });


    //login & registration UI
    $('#login-form-link').click(function (e) {
        $("#login-form").delay(100).fadeIn(100);
        $("#register-form").fadeOut(100);
        $('#register-form-link').removeClass('active');
        $(this).addClass('active');
        e.preventDefault();
    });
    $('#register-form-link').click(function (e) {
        $("#register-form").delay(100).fadeIn(100);
        $("#login-form").fadeOut(100);
        $('#login-form-link').removeClass('active');
        $(this).addClass('active');
        e.preventDefault();
    });

    //show warning on illegal registration arguments
    $("#register-submit").click(function (e) {
        if ($("#pass").val() !== $("#pass_conf").val()) {
            e.preventDefault();
            $.notify({
                icon: 'glyphicon glyphicon-warning-sign',
                title: 'Password confirmation failed',
                message: 'passwords don\'t match' ,
                target: '_blank'
            }, {
                type: 'warning'
            });
        } else if (!(/^\+[0-9]{12}$/.test($("#phone_num").val()))) {
            e.preventDefault();
            $.notify({
                icon: 'glyphicon glyphicon-warning-sign',
                title: 'Invalid phone number type',
                message: 'Please input phone number in requested format',
                target: '_blank'
            }, {
                type: 'warning'
            });
        }
    });




    function htmlbodyHeightUpdate() {
        var height3 = $(window).height()
        var height1 = $('.nav').height() + 50
        height2 = $('.main').height()
        if (height2 > height3) {
            $('html').height(Math.max(height1, height3, height2) + 10);
            $('body').height(Math.max(height1, height3, height2) + 10);
        }
        else {
            $('html').height(Math.max(height1, height3, height2));
            $('body').height(Math.max(height1, height3, height2));
        }

    }
})