from abc import abstractmethod


class Context:

    def __init__(self, strategy):
        self._strategy = strategy

    def context_interface(self):
        self._strategy.travel()


class Strategy():

    @abstractmethod
    def travel(self):
        pass


class Bike(Strategy):

    def travel(self):
        print "You are travelling by bike"


class Bus(Strategy):

    def travel(self):
        print "You are travelling by bus"


class Taxi(Strategy):

    def travel(self):
        print "You are travelling by taxi"


while True:
    money = int(raw_input("Enter money: "))
    time = int(raw_input("Enter time: "))
    risk = int(raw_input("Enter risk (1 - small, 2 - medium, 3 - big): "))
    if money < 3:
        context = Context(Bike())
        context.context_interface()
        break
    if money >= 3 & money < 20:
        context = Context(Bus())
        context.context_interface()
        break
    if money >= 20:
        context = Context(Taxi())
        context.context_interface()
        break
    if money >= 20 & risk == 1:
        context = Context(Taxi())
        context.context_interface()
        break
    if time >= 30 & risk > 1:
        context = Context(Bike())
        context.context_interface()
        break