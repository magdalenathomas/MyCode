###############################################################################
#
# Python 3
#
# Wcięcia realizowane są czterema spacjami.
#
# Doczytanie bibliotek numpy i matplotlib:
# pip install numpy
# pip install matplotlib
#
# Uruchamianie skryptu:
#python dane.py
# albo wymuszając Pythona 3 gdy nie jest on domyślny:
# py -3 dane.py
#
###############################################################################
#
# Plik dane.csv zawiera dane zbierane na węźle ciepłowniczym przez 
# przedsiębiorstwo dostarczające ciepło do budynku (patrz opisy kolumn w pliku). 
# Niniejszy skrypt dokonuje podstawowej analizy tych danych.
#
# A.
# Wczytanie obserwacji dla wybranych zmiennych.
#
# B.
# Sprawdzenie podstawowych statystyk dla poszczególnych zmiennych.
# Wykreślenie histogramów.
#
# C.
# Identyfikacja zmiennych, w których występują potencjalnie błędne dane (obserwacje)
# lub braki danych. Naprawa danych.
#
# D.
# Obliczenie unormowanych korelacji pomiędzy poszczególnymi zmiennymi.
#
# E.
# Przeprowadzenie regresji liniowej dla wybranych zmiennych, wraz z wykresami.
#
###############################################################################


import csv

# from matplotlib.backends.backend_pdf import PdfPages
# pp = PdfPages('multipage.pdf')

import matplotlib.pyplot as plt
import numpy as np

#######################
# A. Wczytanie danych #
#######################
  
przeplyw = []        # Przepływ wody przez węzeł
temp_in = []         # Temperatura wody na wejściu do węzła
temp_out = []        # Temperatura wody na wyjściu z węzła 
roznica_temp = []    # Różnica temperatur, wynikająca z oddanej energii w węźle
moc = []             # Moc oddana w węźle


plik = open('dane.csv', 'rt')
dane = csv.reader(plik, delimiter=',')
next(dane)                # Opuszczamy pierwszy wiersz
for obserwacja in dane:   # Iterujemy po poszczególnych obserwacjach.
     przeplyw.append(float(obserwacja[6]))
     temp_in.append(float(obserwacja[7]))
     temp_out.append(float(obserwacja[8]))
     roznica_temp.append(float(obserwacja[9]))
     moc.append(float(obserwacja[12]))
plik.close()


### ZADANIE (0.5p.) ###
# Dane w listach są ułożone od najnowszych do najstarszych.
# Odwrócić dane na listach tak, żeby były ułożone chronologicznie.
### KONIEC ###

# oprzeplyw = reversed(przeplyw)
# otemp_in = reversed(temp_in)
# otemp_out = reversed(temp_out)
# oroznica_temp = reversed(roznica_temp)
# omoc = reversed(moc)
#
# for i in oprzeplyw:
#     print(i)

        
# Tworzymy słownik: kluczem jest nazwa zmiennej a wartością - zmienna
zmienne = {"temp_in":temp_in, "temp_out":temp_out, "roznica_temp":roznica_temp, "przeplyw":przeplyw, "moc":moc}


######################################
# B. Podstawowe statystyki i wykresy #
######################################
    
# Iterujemy po słowniku, wyświetlając statystyki dla poszczególnych zmiennych
for nazwa,zmienna in zmienne.items():
    print()
    print("Zmienna:",nazwa)
    print("MIN:", min(zmienna))
    print("MAX:", max(zmienna))
    print("ŚREDNIA:", np.mean(zmienna))
    print("MEDIANA:", np.median(zmienna))
    print("ZAKRES:", np.ptp(zmienna))
    print("ODCHYLENIE STANDARDOWE:", np.std(zmienna))
    print("WARIANCJA:", np.var(zmienna))
    print("PERCENTYL 90%:", np.percentile(zmienna,90) )
    print("HISTOGRAM:", np.histogram(zmienna))

    # Czcionka do wykresów, z polskimi znakami.
    plt.rc('font', family='Arial')

    # Wykres - histogram
    plt.hist(zmienna, 100)
    plt.title('Histogram dla: ' + nazwa)
    plt.xlabel('Przedział')
    plt.ylabel('Liczba obserwacji')
    plt.show()


############################################
# C. Analiza anomalii i czyszczenie danych #
############################################

# Zidentyfikowaliśmy problem - "dziwne", znacząco za duże niektóre wartości dla zmiennych:
zmienne_do_naprawienia = {"roznica_temp":roznica_temp, "przeplyw":przeplyw, "moc":moc}

print()
print("CZYSZCZENIE DANYCH")

for nazwa,zmienna in zmienne_do_naprawienia.items():
    for index,wartosc in enumerate(zmienna): # Iterujemy po wszystkich obserwacjach
        # Zakładamy (na podstawie analizy danych), że anomalia to wartość powyżej 10000
        if (wartosc > 10000):
            print("Dla zmiennej {} pod indeksem {} znaleziono anomalię o wartości {}".format(nazwa, index, wartosc))
            # Wstawiamy medianę:
            mediana = np.median(zmienna)
            print("Naprawiam. Stara wartość: {}, nowa wartość: {}".format(zmienna[index], mediana))
            zmienna[index] = mediana

# Statystyki dla naprawionych zmiennych
for nazwa,zmienna in zmienne.items():
    print()
    print("Zmienna (naprawiona):",nazwa)
    print("MIN:", min(zmienna))
    print("MAX:", max(zmienna))
    print("ŚREDNIA:", np.mean(zmienna))
    print("MEDIANA:", np.median(zmienna))
    print("ZAKRES:", np.ptp(zmienna))
    print("ODCHYLENIE STANDARDOWE:", np.std(zmienna))
    print("WARIANCJA:", np.var(zmienna))
    print("PERCENTYL 90%:", np.percentile(zmienna,90))
    print("HISTOGRAM:", np.histogram(zmienna))

#with PdfPages('multipage_pdf.pdf') as pdf:
    plt.hist(zmienna, 100)
    plt.title('Histogram dla: ' + nazwa)
    plt.xlabel('Przedział')
    plt.ylabel('Liczba obserwacji')
   # plt.plot()
    #plt.savefig('wykres.pdf')
    #print("zapisano")
    #plt.close()


# ### ZADANIE (1.5p.) ###
# # Zapisać powyższe statystyki i wykresy do plików PDF, osobnych dla poszczególnych zmiennych
# # (można wykorzystać dowolny moduł/bibliotekę).
# ### KONIEC ###
#
#
#########################################
# D. Badanie korelacji między zmiennymi #
#########################################

print()
print("KORELACJE")

# Piszemy funkcję, która zwróci korelację unormowaną między zestawami danych
def ncorrelate(a,b):
    '''Funkcja zwraca unormowaną wartość korelacji'''
    a = (a - np.mean(a)) / (np.std(a) * len(a))
    b = (b - np.mean(b)) / np.std(b)
    return np.correlate(a, b)[0]

# Badamy korelacje między wszystkimi (różnymi od siebie) zmiennymi
for nazwa1,zmienna1 in zmienne.items():
    for nazwa2,zmienna2 in zmienne.items():
        if nazwa1 != nazwa2:
            print("Korelacja między", nazwa1,"a", nazwa2,"wynosi:", end=" ")
            print(ncorrelate(zmienna1,zmienna2))

#Przykładowe wykresy

# 1. Zmienne z dużą korelacją dodatnią: moc, przeplyw

# Wykres liniowy
plt.plot(range(len(moc)), moc, "x")
plt.plot(range(len(przeplyw)), przeplyw, "+")
plt.title("Duża korelacja dodatnia")
plt.ylabel('x: moc; +: przeplyw')
plt.xlabel('Numer obserwacji')
plt.show()

# Dla lepszej ilustracji: wycinek danych.
# Zmienna moc przemnożnona przez 10, aby lepiej było widać korelację.
plt.plot(range(len(moc[1000:1100])), [i*10 for i in moc[1000:1100]])
plt.plot(range(len(przeplyw[1000:1100])), przeplyw[1000:1100])
plt.title("Duża korelacja dodatnia. Zmienna moc przemnożona przez 10.")
plt.ylabel('dół: moc; góra: przeplyw')
plt.xlabel('Numer obserwacji')
plt.show()

# Wykres zależności przeplyw od moc
plt.plot(moc, przeplyw, '.')
plt.title("Duża korelacja dodatnia")
plt.xlabel('moc')
plt.ylabel('przeplyw')
plt.show()


# 2. Zmienne skorelowane ujemnie: roznica_temp, temp_out

# Wykres liniowy
plt.plot(range(len(roznica_temp)), roznica_temp, "x")
plt.plot(range(len(temp_out)), temp_out, "+")
plt.title("Średnia korelacja ujemna")
plt.ylabel('x: roznica_temp; +: temp_out')
plt.xlabel('Numer obserwacji')
plt.show()

# Dla lepszej ilustracji: wycinek danych
plt.plot(range(len(roznica_temp[1000:1100])), roznica_temp[1000:1100])
plt.plot(range(len(temp_out[1000:1100])), temp_out[1000:1100])
plt.title("Średnia korelacja ujemna.")
plt.ylabel('dol: roznica_temp; gora: temp_out')
plt.xlabel('Numer obserwacji')
plt.show()

# Wykres zależności temp_out od roznica_temp
plt.plot(roznica_temp, temp_out, '.')
plt.title("Średnia korelacja ujemna.")
plt.xlabel('roznica_temp')
plt.ylabel('temp_out')
plt.show()


#######################
# E. Regresja liniowa #
#######################

# Analiza przeprowadzona tylko dla jednej zmiennej, temp_in

print()
print("REGRESJA LINIOWA")
# Wybieramy zmienną temp_in w funkcji numeru obserwacji
x = range(len(temp_in))
y = temp_in
# Liczymy współczynniki regresji - prostej
a,b = np.polyfit(x,y,1)  # Wielomian 1 rzędu - prosta
print("Wzór prostej: y(x) =",a,"* x +",b)
# Wyliczamy punkty prostej otrzymanej w wyniku regresji
yreg =  [a*i + b for i in x]
# Wykresy
plt.plot(x,y)
plt.plot(x,yreg)
plt.title("Regresja liniowa dla całosci danych zmiennej temp_in")
plt.xlabel('Numer obserwacji')
plt.ylabel('temp_in')
plt.show()


#
# print()
# print("Regresja liniowa dla dwóch zakresów")
# # Wybieramy zmienną temp_in w funkcji numeru obserwacji
# x = range(len(temp_in))
# y = temp_in
# y2 = len(temp_in)/2
# x1 = temp_in[:17261]
# x2 = temp_in[17262:]
# # Liczymy współczynniki regresji - prostej
# a1,b1 = np.polyfit(x1,y2,1)  # Wielomian 1 rzędu - prosta
# a2,b2 = np.polyfit(x2,y2,1)  # Wielomian 1 rzędu - prosta
# print("Wzór pierwszej prostej: y(x) =",a1,"* x +",b1)
# print("Wzór drugiej prostej: y(x) =",a2,"* x +",b2)
# # Wyliczamy punkty prostej otrzymanej w wyniku regresji
# yreg1 =  [a1*i + b1 for i in x1]
# yreg2 =  [a2*i + b2 for i in x2]
# # Wykresy
# plt.plot(x,y)
# plt.plot(x1,yreg1)
# plt.plot(x2,yreg2)
# plt.title("Regresja liniowa dla połowy zmiennej temp_in")
# plt.xlabel('Numer obserwacji')
# plt.ylabel('temp_in')
# plt.show()


# ### ZADANIE (1.5p.) ###
# # Z wykresu widać, że regresja liniowa dla całości zmiennej temp_in słabo się sprawdza.
# # Wynika to z tego, że inaczej dane rozkładają się w róznych porach roku.
# # Należy więc podzielić dane na kilka podzakresów i regresję wykonać osobno
# # dla każdego z podzakresu. Narysować odpowiedni wykres.
# ### KONIEC ###
#
#
# ### ZADANIE (1.5p.) ###
# # Przeprowadzić regresję wielomianową wielomianem 2 stopnia dla zmiennej temp_in.
# # Narysować wykres otrzymanej krzywej na tle zmiennej temp_in.
# ### KONIEC ###
#
print()
print("REGRESJA LINIOWA DRUGIEGO STOPNIA")
x = range(len(temp_in))
y = temp_in
a,b,c = np.polyfit(x,y,2)
print("Wzór prostej: y(x) =",a,"* x^2 +",b,"* x +",c)
yreg =  [a*i^2 +b*i + c for i in x]
plt.plot(x,y)
plt.plot(x,yreg)
plt.title("Regresja liniowa drugiego stopnia dla zmiennej temp_in")
plt.xlabel('Numer obserwacji')
plt.ylabel('temp_in')
plt.show()
#
# # Regresja liniowa dla zmiennych z dużą korelacją dodatnią: moc, przeplyw
# a,b = np.polyfit(moc,przeplyw,1)  # Wielomian 1 rzędu - prosta
# yreg =  [a*i + b for i in moc]
# # Wykresy
# plt.plot(moc,przeplyw,".")
# plt.plot(moc,yreg)
# plt.title("Regresja liniowa")
# plt.xlabel('moc')
# plt.ylabel('przeplyw')
# plt.show()
#
#
# # Regresja liniowa dla zmiennych ze słabą korelacją ujemną: roznica_temp, temp_out
# a,b = np.polyfit(roznica_temp,temp_out,1)  # Wielomian 1 rzędu - prosta
# yreg =  [a*i + b for i in roznica_temp]
# # Wykresy
# plt.plot(roznica_temp,temp_out,".")
# plt.plot(roznica_temp,yreg)
# plt.title("Regresja liniowa")
# plt.xlabel('roznica_temp')
# plt.ylabel('temp_out')
# plt.show()
#
# # Predykcja danych z losowej listy
# roznica_temp = []
# import random
# for i in range(20):
# 	roznica_temp.append(random.randint(0,100))
#
# # Wyliczenie wyników na podstawie regresji i zapis do listy
# temp_out = [[i, a*i+b] for i in roznica_temp]
# print("Wyniki predykcji:",temp_out)
#
