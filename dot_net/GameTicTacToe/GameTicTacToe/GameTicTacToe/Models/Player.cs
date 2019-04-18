using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace GameTicTacToe.Models
{
    public class Player
    {
        public string Name { get; set; } 
        public bool WaitingForMove { get; set; } //flaga
        public string Symbol { get; set; } //przypisanie X lub O
        public string ConnectionId { get; set; } //identyfikacja gracza
    }
}