import time
import random
from abc import ABCMeta, abstractmethod

TIMEOUT = 0.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000005


class AbstractAlgorithm(object):

    __metaclass__ = ABCMeta

    def __init__(self, alg=None):
        self._alg = alg

    @abstractmethod
    def forward_request(self, vector):
        pass


class CubicAlgorithm(AbstractAlgorithm):
    def forward_request(self, vector):
        start = time.time()
        max_so_far = 0
        for i in range(len(vector)):
            for j in range(i, len(vector)):
                acc = 0
                for k in range(i, j+1):
                    acc += vector[k]
                    max_so_far = max(max_so_far, acc)

        time_elapsed = time.time() - start

        if time_elapsed >= TIMEOUT:
            print("Timeout exceeded using cubic algorithm ({} seconds)".format(time_elapsed))
            self._alg.forward_request(vector)
        else:
            print("Cubic algorithm: {} in time: {}".format(max_so_far, time_elapsed))


class SquareAlgorithm(AbstractAlgorithm):
    def forward_request(self, vector):
        start = time.time()
        max_so_far = 0
        for i in range(len(vector)):
            acc = 0
            for j in range(i, len(vector)):
                acc += vector[j]
                max_so_far = max(max_so_far, acc)

        time_elapsed = time.time() - start

        if time_elapsed >= TIMEOUT:
            print("Timeout exceeded using square algorithm ({} seconds)".format(time_elapsed))
            self._alg.forward_request(vector)
        else:
            print("Square algorithm: {} in time: {} \n".format(max_so_far, time_elapsed))


class LinearAlgorithm(AbstractAlgorithm):
    def forward_request(self, vector):
        start = time.time()

        max_so_far = 0
        max_here = 0

        for i in range(len(vector)):
            max_here = max(max_here + vector[i], 0)
            max_so_far = max(max_so_far, max_here)

        time_elapsed = time.time() - start
        print("Linear algorithm result: {} in time: {} \n".format(max_so_far, time_elapsed))


if __name__ == '__main__':
    linear = LinearAlgorithm()
    square = SquareAlgorithm(linear)
    cubic = CubicAlgorithm(square)

    vector = random.sample(range(100), 20)
    cubic.forward_request(vector)

    vector = [1, 2, 3, -3, -5, 3, 4]
    cubic.forward_request(vector)
