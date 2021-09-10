var main = {
    init: function () {
        var _this = this;

        $("#send").on("click", function () {
            _this.send();
        });
    },

    send: function () {
        if (!this.validate()) {
            return;
        }
        var param = {
            url: $("#url").val(),
            type: $("#type").val(),
            unit: $("#unit").val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/crawler',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(param)
        }).done(function (data) {
            var result = data;
            $("#resultMsg").html("");
            $("#quotient").html(result.quotient);
            $("#remains").html(result.remains);

        }).fail(function (error) {
            alert("오류가 발생했습니다");
            if (error.status === 400) {
                $("#resultMsg").html("입력값을 확인해주세요");
            }
            if (error.status === 500) {
                $("#resultMsg").html("요청 처리중 요류가 발생했습니다.");
            }
        });
    },
    validate: function () {
        var result = true;
        var url = $("#url").val();
        var type = $("#type").val();
        var unit = $("#unit").val();
        if (!url) {
            alert("빈값이 입력되어서는 안됩니다.");
            result = false;
        }
        if (!type) {
            alert("빈값이 입력되어서는 안됩니다.");
            result = false;
        }
        if (!unit || unit.length > 0 && unit < 0) {
            alert("0보다 커야합니다.");
            result = false;
        }
        return result;
    }
};

main.init();
