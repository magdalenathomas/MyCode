using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Web;
using System.Web.Routing;
using GameTicTacToe.Models;
using Microsoft.AspNet.SignalR;

namespace GameTicTacToe
{
    public class GameHub : Hub
    {
        private static Player player1;
        private static Player player2;
        private static Game game;

        private void isReadyToStart()
        {
            if (player1 != null && player2 != null)
            {
                Clients.All.ready(new { ready = true });
            }
            else
            {
                Clients.All.ready(new { ready = false });
            }
            
        }

        public void NewPlayer(string data)
        {
            if (player1 == null)
            {
                player1 = new Player { ConnectionId = Context.ConnectionId, Name = data };
            } else if(player2 == null)
            {
                player2 = new Player { ConnectionId = Context.ConnectionId, Name = data };
            }

            isReadyToStart();
        }

        public override Task OnDisconnected(bool stopCalled)
        {
            var player = player1;
            var opponent = player2;
            if (player2 != null && player2.ConnectionId == Context.ConnectionId)
            {
                player = player2;
                opponent = player1;
                player2 = null;
            } else {
                player1 = null;
            }

            Clients.Client(opponent.ConnectionId).opponentDisconnected(player.Name);

            game = null;

            isReadyToStart();
            return base.OnDisconnected(stopCalled);
        }

        public void Play(int position)
        {
            if (game == null) return;

            var player = game.player1;
            var opponent = game.player2;

            if (game.player2.ConnectionId == Context.ConnectionId)
            {
                player = game.player2;
                opponent = game.player1;
            }
            if (player.WaitingForMove) return;

            Clients.All.addMarker(new { Position = position, Symbol = player.Symbol});

            if (game.Play(player, position))
            {
                Clients.All.gameOver(player.Name);
            }

            if (game.IsOver && game.IsDraw)
            {
                game = null;
                Clients.All.gameOver("draw!");
            }

            player.WaitingForMove = !player.WaitingForMove;

            if (game != null && !game.IsOver)
            {
                opponent.WaitingForMove = !opponent.WaitingForMove;

                Clients.Client(opponent.ConnectionId).waitingFor(opponent.Name);
            } else {
                game = null;
            }
            
        }

        public void StartGame()
        {  
            player1.Symbol = "X";
            player1.WaitingForMove = false; //zawsze zaczyna x;
            player2.Symbol = "O";
            player2.WaitingForMove = true;

            Clients.Client(player1.ConnectionId).startGame("/Content/X.png"); //przypisanie obrazkow
            Clients.Client(player2.ConnectionId).startGame("/Content/O.png");

            game = new Game (player1,  player2);
        }
    }
    

}