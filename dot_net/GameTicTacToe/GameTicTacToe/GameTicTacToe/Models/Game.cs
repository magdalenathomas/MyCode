using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace GameTicTacToe.Models
{
    public class Game
    {
        public Player player1 { get; set; }
        public Player player2 { get; set; }
        public bool IsOver { get; private set; } //koniec gry
        public bool IsDraw { get; private set; } //remis

        private readonly Player[] field = new Player[9]; //tworzymy tablice reprezetancje pola gry - 9 pól numerowanych 0-8
        private int movesLeft = 9; //w całej grze można wykonać w sumie 9 ruchów

        //stworzenie pola do gry
        public Game(Player player1, Player player2)
        {
            this.player1 = player1;
            this.player2 = player2;
            for (var i=0; i<field.Length; i++)
            {
                field[i]= null; //wpisujemy nulle, bo zaden gracz nie zagral na tym polu jeszcze
            }
        }

        public bool Play(Player player, int position)
        {
            if (this.IsOver)
            {
                return false;
            }
            this.MakeMove(player, position);
            return Victory();
        }

        private bool Victory()
        {
            for (int i = 0; i < 3; i++) {
                if (
                   ((field[i * 3] != null && field[(i * 3)].Equals(field[(i * 3) + 1]) && field[(i * 3)].Equals(field[(i * 3) + 2])) ||
                    (field[i] != null && field[i].Equals(field[i + 3]) && field[i].Equals(field[i + 6]))))
                { 
                    this.IsOver = true;
                    return true;
                }
                        
            }
            if ((field[0] != null && field[0].Equals(field[4]) && field[0].Equals(field[8])) || (field[2] != null && field[2].Equals(field[4]) && field[2].Equals(field[6])))
            {
                IsOver = true;
                return true;
            }
            return false;
        }

        private void MakeMove(Player player, int position)
        {
            if (--this.movesLeft <= 0)  //nie mamy już ruchu
            {
                this.IsOver = true; //koniec gry
                this.IsDraw = true; //remis
            }
            if (position < field.Length && field[position] == null) //wpisanie symbolu w pole
            {
                field[position] = player;
            }

        }


    }
}