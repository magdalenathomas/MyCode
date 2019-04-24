import time
import random

class AbstractAlgorithm:

    def setAlgorithm(self, alg):
        self.alg = alg

    def forwardRequest(self, wektor):
        pass


class Stoper:

    def start(self):
        self.start = time.ctime()
        return self.start

    def stop(self):
        self.stop = time.ctime()
        return self.stop

    def wynik(self):
        self.wynik = self.start() - self.stop()
        print self.wynik


class CubicAlgorithm(AbstractAlgorithm):

   def forwardRequest(self, wektor):
    stoper.start()
    maxsofar = 0
    i = wektor[0]
    j = len(wektor)-1
    n = len(wektor)
    k = 0

    for i in range(0, n-1):
        for j in range(0, n-1):
            sum = 0
            for k in range(0, j):
                sum += wektor[k]
                maxsofar = max(maxsofar, sum)
    stoper.stop()

    if stoper.wynik() <= 0.010:
        print "Algorytm sześcienny: ", maxsofar
    else:
        alg.forwardRequest(wektor)


class SquareAlgorithm(AbstractAlgorithm):

    def forwardRequest(self, wektor):
        stoper.start()
        maxsofar = 0
        i = wektor[0]
        j = len(wektor) - 1
        n = len(wektor)
        k = 0

        for i in range(0, n - 1):
            sum = 0
            for j in range(0, n - 1):
                    sum += wektor[k]
                    maxsofar = max(maxsofar, sum)
        stoper.stop()

    if stoper.wynik() <= 0.05:
        print "Algorytm kwadratowy: ", maxsofar
    else:
        alg.forwardRequest(wektor)


class LinearAlgorithm(AbstractAlgorithm):

    def forwardRequest(self, wektor):
        stoper.start()
        maxsofar = 0
        maxhere = 0
        i = wektor[0]
        n = len(wektor)

        for i in range(0, n - 1):
            maxhere = max(maxhere + wektor[i], 0)
            maxsofar = max(maxsofar, maxhere)
        stoper.stop()
        print "Algorytm liniowy: ", maxsofar


stoper = Stoper()

wektor = []
for i in range(1, 20):
    x = random.randint(0, 10)
    wektor.append(x)

szescienny = CubicAlgorithm()
kwadratowy = SquareAlgorithm()
linowy = LinearAlgorithm()

szescienny.setAlgorithm(kwadratowy)
kwadratowy.setAlgorithm(linowy)
szescienny.forwardRequest(wektor)
