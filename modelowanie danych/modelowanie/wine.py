import csv
import matplotlib.pyplot as plt
import numpy as np

#stworzenie tablic do przechowywania odczytanych danych
alcohol = []
malic_acid = []
magnesium = []
total_phenols = []
flavanoids = []
nonflavanoid_phenols = []
color_intensity = []
hue = []
diluted_wines = []

#wczytanie danych do analizy, dodanie odpowiednich wartości kolumn do przygotowanych tablic
plik = open('wine.csv', 'rt')
dane = csv.reader(plik, delimiter=',')
next(dane)                # Opuszczamy pierwszy wiersz
for wiersz in dane:   # Iterujemy po poszczególnych obserwacjach.
     alcohol.append(float(wiersz[1]))
     malic_acid.append(float(wiersz[2]))
     magnesium.append(float(wiersz[5]))
     total_phenols.append(float(wiersz[6]))
     flavanoids.append(float(wiersz[7]))
     nonflavanoid_phenols.append(float(wiersz[8]))
     color_intensity.append(float(wiersz[10]))
     hue.append(float(wiersz[11]))
     diluted_wines.append(float(wiersz[12]))
plik.close()

#stworzenie słownika dla lepszego poruszania sie po zmiennych
zmienne = {"alcohol":alcohol,"malic_acid":malic_acid, "magnesium":magnesium, "total_phenols":total_phenols, "flavanoids":flavanoids, "nonflavanoid_phenols":nonflavanoid_phenols, "color_intensity":color_intensity, "hue":hue, "diluted_wines":diluted_wines}

#####STATYSKYKA OGÓLNA DLA POSZCZEGÓLNYCH ZMIENNYCH
for nazwa,zmienna in zmienne.items():
    print()
    print("Zmienna:",nazwa)
    print("MIN:", min(zmienna))
    print("MAX:", max(zmienna))
    print("ŚREDNIA:", np.mean(zmienna))
    print("MEDIANA:", np.median(zmienna))
    print("ODCHYLENIE STANDARDOWE:", np.std(zmienna))


######WARTOŚĆ ŚREDNIA
#składniki poddane analizie podzielono na 3 części,
#następnie z każdego z trzech zbiorów obliczono jego wartość średnią
#obliczenie wartości średniej z całego zakresu danego składnika oraz porównanie ze średnimi wartościami z poszczególnych podzbiorów

for nazwa,zmienna in zmienne.items():
     print()
     print("Składnik:", nazwa)
     r = [] #stworzenie tablicy w ktorej beda przechowywane wartosci podzielone na 3 gatunki
     z = np.asarray(zmienna)
     for chunk in np.array_split(z,3):
          r += [np.mean(chunk)]  #obliczenie średniej wartości z każdego gatunku
     srednia = np.mean(zmienna)
     roznica = []

     for i in r:
          roznica += [srednia - i]

     #indeks najmniejszej roznicy to numer gatunku wina
     if (roznica.index(min(roznica))==0):
          print("Dla:", nazwa,  "najbardziej zbliżoną do obliczonej wartość średnią ma gatunek pierwszy")
     if (roznica.index(min(roznica))==1):
          print("Dla:", nazwa,  "najbardziej zbliżoną do obliczonej wartość średnią ma gatunek drugi")
     if (roznica.index(min(roznica)) == 2):
          print("Dla:", nazwa, "najbardziej zbliżoną do obliczonej wartość średnią ma gatunek trzeci")


########REGRESJA LINIOWA DLA POSZCZEGÓLNYCH SKŁADNIKÓW
for nazwa,zmienna in zmienne.items():
     print()
     print("REGRESJA LINIOWA - składnik - ", nazwa)
     x = range(len(zmienna))
     y = zmienna
     a, b= np.polyfit(x, y, 1)
     print("Wzór prostej: y(x) =", a, "* x +", b)
     yreg = [a * (i) + b for i in x]
     #zobrazowanie wyników
     plt.plot(x, y)
     plt.plot(x, yreg)
     title = "Regresja liniowa dla składnika ", nazwa
     plt.title(title)
     plt.xlabel('Numer analizy')
     labely = "Zawartość składnika ", nazwa
     plt.ylabel(labely)
     plt.show()


##############REGRESJA WIELOMIANOWA CZWARTEGO STOPNIA DLA POSZCZEGOLNYCH SKŁADNIKÓW
for nazwa,zmienna in zmienne.items():
     print()
     print("REGRESJA WIELOMIANOWA -  składnik - ", nazwa)
     x = range(len(zmienna))
     y = zmienna
     a, b, c, d, e = np.polyfit(x, y, 4)
     print("Wzór prostej: y(x) =", a, "* x +", b)
     yreg = [a * (i ** 4) + b * (i ** 3) + c * (i ** 2) + d *i + e for i in x]
     #zobrazowanie wyników
     plt.plot(x, y)
     plt.plot(x, yreg)
     title = "Regresja wielomianowa czwartego stopnia dla składnika ", nazwa
     plt.title(title)
     plt.xlabel('Numer analizy')
     labely = "Zawartość składnika ", nazwa
     plt.ylabel(labely)
     plt.show()








