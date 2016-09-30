jQuery(document).ready(function () {

    $('.page-container form').submit(function () {
        var username = $(this).find('.username').val();
        var password = $(this).find('.password').val();
        var username_reg = /^[0-9]{11}$/
        if (!username_reg.test(username)) {
            $(this).find('.error').fadeOut('fast', function () {
                $(this).css('top', '27px');
            });
            $(this).find('.error').fadeIn('fast', function () {
                $(this).parent().find('.username').focus();
            });
            return false;
        }
        var password_reg = /^[0-9a-zA-Z]{6,20}$/
        if (!password_reg.test(password)) {
            $(this).find('.error').fadeOut('fast', function () {
                $(this).css('top', '96px');
            });
            $(this).find('.error').fadeIn('fast', function () {
                $(this).parent().find('.password').focus();
            });
            return false;
        }

    });

    $('.page-container-register form').submit(function () {
        var username = $(this).find('.username').val();
        var password = $(this).find('.password').val();
        var re_password = $(this).find('.re_password').val();
        var username_reg = /^[0-9]{11}$/
        if (!username_reg.test(username)) {
            $(this).find('.error').fadeOut('fast', function () {
                $(this).css('top', '27px');
            });
            $(this).find('.error').fadeIn('fast', function () {
                $(this).parent().find('.username').focus();
            });
            return false;
        }
        var password_reg = /^[0-9a-zA-Z]{6,20}$/
        if (!password_reg.test(password)) {
            $(this).find('.error').fadeOut('fast', function () {
                $(this).css('top', '96px');
            });
            $(this).find('.error').fadeIn('fast', function () {
                $(this).parent().find('.password').focus();
            });
            return false;
        }
        if (password != re_password) {
            $(this).find('.error').fadeOut('fast', function () {
                $(this).css('top', '165px');
            });
            $(this).find('.error').fadeIn('fast', function () {
                $(this).parent().find('.re_password').focus();
            });
            return false;
        }

    });

    $('.page-container form .username, .page-container form .password').keyup(function () {
        $(this).parent().find('.error').fadeOut('fast');
    });

    $('.page-container-register form .username, .page-container-register form .password, .page-container-register form .re_password').keyup(function () {
        $(this).parent().find('.error').fadeOut('fast');
    });

});
