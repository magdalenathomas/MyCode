using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace GameTicTacToe.Controllers
{
    public class HomeController : Controller
    {
        // GET: Game
        public ActionResult Index()
        {
            return View();
        }
    }
}