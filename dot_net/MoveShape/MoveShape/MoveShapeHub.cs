using System;
using System.Threading;
using Microsoft.AspNet.SignalR;
using Newtonsoft.Json;

namespace MoveShape
{
    public class Broadcaster
    {
        private readonly static Lazy<Broadcaster> _instance =
            new Lazy<Broadcaster>(() => new Broadcaster());
        //max 25 wiadomości, czyli czas wysyłania 40ms
        private readonly TimeSpan BroadcastInterval =
            TimeSpan.FromMilliseconds(40); //wysyła wiadoności co 40ms
        private readonly IHubContext _hubContext; //odowłujemy się do referencji huba 
        private Timer _broadcastLoop;
        private ShapeModel _model;
        private bool _modelUpdated;

        public Broadcaster()
        {
            //tworzy połączenie hub, zapamiętuje referencję, więc możemy je cały czas używać
            _hubContext = GlobalHost.ConnectionManager.GetHubContext<MoveShapeHub>();
            _model = new ShapeModel();
            _modelUpdated = false;
            // zaczyna zliczać wychodzące wiadomości
            _broadcastLoop = new Timer(
                BroadcastShape,
                null,
                BroadcastInterval,
                BroadcastInterval);
        }
        public void BroadcastShape(object state)
        {
            // jeżeli położenie się zmieni to serwer informuje klientów
            if (_modelUpdated)
            {
                _hubContext.Clients.AllExcept(_model.LastUpdatedBy).updateShape(_model);
                _modelUpdated = false;
            }
        }
        public void UpdateShape(ShapeModel clientModel)
        {
            _model = clientModel;
            _modelUpdated = true;
        }
        public static Broadcaster Instance
        {
            get
            {
                return _instance.Value;
            }
        }
    }

    public class MoveShapeHub : Hub
    {
        // Is set via the constructor on each creation
        private Broadcaster _broadcaster;
        public MoveShapeHub()
            : this(Broadcaster.Instance)
        {
        }
        public MoveShapeHub(Broadcaster broadcaster)
        {
            _broadcaster = broadcaster;
        }
        public void UpdateModel(ShapeModel clientModel)
        {
            clientModel.LastUpdatedBy = Context.ConnectionId;
            // updatuje shapemodel po stronie klienta w zależności od tego co dostał
            _broadcaster.UpdateShape(clientModel);
        }
    }
    public class ShapeModel
    {
        //przesyła nowe współrzędne x,y w fromacie Json
        [JsonProperty("left")]
        public double Left { get; set; }
        [JsonProperty("top")]
        public double Top { get; set; }
        // We don't want the client to get the "LastUpdatedBy" property
        [JsonIgnore]
        public string LastUpdatedBy { get; set; }
    }
}