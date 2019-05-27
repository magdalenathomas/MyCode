import numpy
import csv
import random

def g(x):
    '''
    Funkcja aktywacji - tangens hiperboliczny
    '''
    return numpy.tanh(x)


def g1(x):
    '''
    Pochodna funkcji aktywacji
    '''
    return 1-numpy.tanh(x)*numpy.tanh(x)

    
def read_input_data(filename, X, Y, Nin):
    '''
    Wczytanie danych wejsciowych z pliku CSV.
    Format pliku: input1, input2, ..., output
                  ...
                  ...                  
    '''
    file = open(filename, 'rt')
    dataset = csv.reader(file, delimiter=',',quoting=csv.QUOTE_NONNUMERIC)
    for line in dataset:
        X.append(line[0:Nin])
        Y.append(line[Nin])
    file.close()

### ZADANIE (1p.) ###
# Przerobić funkcję read_input_data() tak, aby wczytywała dane z pliku YAML a nie CSV.
### KONIEC ###

def initialize_weigths(w, Nin):
    '''
    Inicjalizacja wag losowymi wartosciami
    '''
    for i in range(Nin):
        w.append(random.random())


def train(epochs, X, Y, Nin, weigths, eta, RMSE):
    '''
    Uczenie sieci
    '''   
    # Iterujemy po liczbie cykli uczenia
    for epoch in range(epochs):
        print("Epoch =",epoch+1)
        sumRMSE = 0
        # Obliczenie wyjscia z perceptronu
        for i in range(len(X)):
            # i - indeks po numerze wzorca wejsciowego
            sumWeighted = 0
            for j in range(Nin):
                # j - indeks po numerze wagi w danym wzorcu wejsciowym
                sumWeighted += weigths[j]*X[i][j]
            Yout = g(sumWeighted)

            # Obliczenie zmiany wag
            for j in range(Nin):
                weigths[j] += eta*g1(sumWeighted)*(Y[i]-Yout)*X[i][j]

            # Obliczenie kolejnego składnika RMS      
            sumRMSE += (Yout-Y[i])**2
            print("Wynik uzyskany = {}, wynik oczekiwany = {}".format(Yout,Y[i]))
        # Obliczenie błedu sredniego kwadratowego (RMS)
        RMSE.append(0.5*sumRMSE)
        print("RMSE =",RMSE[epoch])
        print()


def test(filename, Nin, weigths, Y):
    '''
    Test sieci
    '''   
    Xtest=[]
    Ytest=[]
    read_input_data(filename, Xtest, Ytest, Nin)
    # Obliczenie wyjscia z perceptronu
    for i in range(len(Xtest)):
        # i - indeks po numerze wzorca wejsciowego
        sumWeighted = 0
        for j in range(Nin):
            # j - indeks po numerze wagi w danym wzorcu wejsciowym
            sumWeighted += weigths[j]*Xtest[i][j]
        Y.append(g(sumWeighted))


    
if __name__ == '__main__':    
    '''
     Perceptron prosty

                 Yout
                  ^
                  |
                  O
                / | \         wagi: weigths[]
              Nin wejsć
    '''

    # Wczytanie wzorców do listy Xtrain i oczekiwanych wyników do Ytrain
    Xtrain=[]
    Ytrain=[]
    Nin = 2
    read_input_data("train_data.csv", Xtrain, Ytrain, Nin)

    # Inizjalizacja wag
    weigths = []
    initialize_weigths(weigths, Nin)
    
    # Trenowanie sieci
    epochs = 1000
    eta = 0.5
    RMSError=[]
    train(epochs, Xtrain, Ytrain, Nin, weigths, eta, RMSError)
    
### ZADANIE (0.5p.) ###
# Narysować wykres błędu uczenia w funkcji epoki.
### KONIEC ###

    # Test sieci
    # W zasadzie powinien być przeprowadzony na danych, na kórych sieć się nie uczyła,
    # ale my go przeprowadzimy na tych samych danych
    Y=[]
    test("train_data.csv", Nin, weigths, Y)
    print("Wyniki testu sieci:")
    print(Y)

    
### ZADANIE (1.5p.) ###
# Przerobić wszystkie funkcje w programie tak, aby zwracały obliczane 
# przez siebie wartości instrukcją return, a nie poprzez argumenty. 
# Przykładowo, zamiast przekazywać listę Y jako argument funkcji test(), należy 
# w programie głównym odebrać tę listę jako wynik działania tej funkcji.
### KONIEC ###
