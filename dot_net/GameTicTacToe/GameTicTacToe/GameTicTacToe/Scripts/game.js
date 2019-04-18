$('document').ready(function () {

    $("#game").html("");
    $("#register").show();
    $("#start").hide();
    $("#game").hide();

    var game = $.connection.gameHub;

    game.client.ready = function (message) {
        if (message.ready == true) {
            $("#startGame").removeAttr('disabled');
        } else {
            $("#startGame").attr('disabled', 'disabled');
        }
     };

    game.client.waitingFor = function () {
        $("#information").html("Your turn!");
    };

    game.client.addMarker = function (message) {
        if (message.Symbol == "X") {
            $("#" + message.Position).addClass("mark1");
        }
        else {
            $("#" + message.Position).addClass("mark2");
        }

        $("#information").html("Waiting for the opponent!");
        $("#" + message.Position).addClass("marked");
    };

    game.client.opponentDisconnected = function () {
        $("#information").html("");
        $("#start").show();
        $("#game").hide();
    };

    game.client.gameOver = function (message) {
        $("#information").html('The winner is: ' + message);
        $("#game").hide();
        $("#start").show();
    };

    game.client.startGame = function (symbol) {
        $("#register").hide();
        $("#start").hide();
        $("#information").html("Your marker: <img src='" + symbol + "' height='30' width='30'/>");

        for (var i = 0; i < 9; i++) {
            $("#game").append("<span id=" + i + " class='box' />");
        }
        $("#game").show();
    };

    $(".box").live("click", function (event) {
        if ($(this).hasClass("marked")) return;
        game.server.play(event.target.id);
    });

    $("#registerName").click(function () {
        game.server.newPlayer($('#gamaName').val());
        $("#register").hide();
        $("#start").show();
    });

    $(".startGame").click(function () {
        startGame();
    });

    function startGame() {
        game.server.startGame();
    }

    $.connection.hub.start().done();
});