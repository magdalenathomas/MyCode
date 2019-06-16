import csv
from _json import make_scanner
from sklearn import datasets
import matplotlib.pyplot as plt
import pandas as pd
import numpy as np
import sklearn.preprocessing
from scipy.sparse.linalg.isolve.tests.test_iterative import params
from sklearn.metrics import mean_squared_error
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LinearRegression
from math import sqrt

#stworzenie tablic do przechowywania zmiennych
alcohol = []
malic_acid = []
magnesium = []
total_phenols = []
flavanoids = []
nonflavanoid_phenols = []
color_intensity = []
hue = []
diluted_wines = []

#plik = open('wine.csv', 'rt')
#dane = csv.reader(plik, delimiter=',')
#next(dane)                # Opuszczamy pierwszy wiersz
#for wiersz in dane:   # Iterujemy po poszczególnych obserwacjach.
#     alcohol.append(float(wiersz[0]))
#     malic_acid.append(float(wiersz[1]))
#     magnesium.append(float(wiersz[4]))
#     total_phenols.append(float(wiersz[5]))
#     flavanoids.append(float(wiersz[6]))
#     nonflavanoid_phenols.append(float(wiersz[7]))
#     color_intensity.append(float(wiersz[9]))
#     hue.append(float(wiersz[10]))
#     diluted_wines.append(float(wiersz[11]))
#plik.close()

#stworzenie słownika dla lepszego poruszania sie po zmiennych
zmienne = {"malic_acid":malic_acid, "magnesium":magnesium, "total_phenols":total_phenols, "flavanoids":flavanoids, "nonflavanoid_phenols":nonflavanoid_phenols, "color_intensity":color_intensity, "hue":hue, "diluted_wines":diluted_wines}

#x = np.array(alcohol)
#y = np.array(flavanoids).reshape(1,-1)

#y=np.array(hue).reshape(1,-1)
#print(x)
print()
print()
#print(y)

t = pd.read_csv('wine.csv', index_col=0)
x_train, x_test, y_train, y_test = train_test_split(t['Alcohol'], t['Malic acid'], test_size=0.2, random_state=42)

x_train = pd.DataFrame(data=x_train)
x_test = pd.DataFrame(data=x_test)

regressor = sklearn.linear_model.LinearRegression()
regressor.fit(x_train, y_train)
#plt.plot(x_train, y_train)
y_pred = regressor.predict(x_test)
#ptrain= regressor.predict(x_train)
#print(ptrain)
#ptest = regressor.predict(x_test)
#print(ptest)
#plt.plot(ptrain, y_train)

rmse= sqrt(mean_squared_error(y_test, y_pred))
print(rmse)

print(regressor.intercept_)
print(regressor.coef_)

plt.scatter(x_test, y_test, color='black')
plt.plot(x_test, y_pred, color='blue')
plt.show()
def fit_regression(x_train, x_test, y_train,  y_test):
    r = sklearn.linear_model.LinearRegression()
    r.fit(X_ucz, y_ucz)
    y_ucz_pred = r.predict(X_ucz)
    y_test_pred = r.predict(X_test)
   # mse = sklearn.metrics.mean_squared_error
   # mae = sklearn.metrics.mean_absolute_error
    return {
        "r_score": r.score(X_ucz, y_ucz),
    #    "MSE_u": mse(y_ucz, y_ucz_pred),
     #   "MSE_t": mse(y_test, y_test_pred),
     #   "MAE_u": mae(y_ucz, y_ucz_pred),
      #  "MAE_t": mae(y_test, y_test_pred)
    }


#params = ["Reg. liniowa"]
#res = [fit_regression(x_train, x_test, y_train, y_test)]
#pd.DataFrame(res, index=params)


#y_pred = regressor.predict(X_test)

#x_ucz, x_test, y_ucz, y_test = sklearn.model_selection.train_test_split(x, y, test_size=0.2, random_state=1234)
#print("x ucz: ",x_train)
#print("x test: ",x_test)
#print("y ucz: ",y_train)
#print("y test: ",y_test)

#####STATYSKYKA OGÓLNA DLA POSZCZEGÓLNYCH ZMIENNYCH
#for nazwa,zmienna in zmienne.items():
#    print()
#    print("Zmienna:",nazwa)
#    print("MIN:", min(zmienna))
#    print("MAX:", max(zmienna))
#    print("ŚREDNIA:", np.mean(zmienna))
#   print("MEDIANA:", np.median(zmienna))
#    print("ODCHYLENIE STANDARDOWE:", np.std(zmienna))
#    print("HISTOGRAM:", np.histogram(zmienna))

#Czcionka do wykresów, z polskimi znakami.
plt.rc('font', family='Arial')

#Wykres - histogram
#plt.hist(zmienna, 100)
#plt.title('Histogram dla: ' + nazwa)
#plt.xlabel('Przedział')
#plt.ylabel('Wartość badanego składnika')
#plt.show()


######WARTOŚĆ ŚREDNIA - wyznaczenie wartości średniej każdego składnika dla każdego gatunku i wyznaczenie
#podział każego zbioru na trzy części, obliczenie wartości średniej z każdej części
#porównanie wartości średniej z całego zbioru z wartością z poszczególnych części

#for nazwa,zmienna in zmienne.items():
#     print()
#     print("Składnik:", nazwa)
#     r = [] #stworzenie tablicy w ktorej beda przechowywane wartosci podzielone na 3 gatunki
#     z = np.asarray(zmienna)
#     for chunk in np.array_split(z,3):
#          r += [np.mean(chunk)]  #obliczenie średniej wartości z każdego gatunku
#     srednia = np.mean(malic_acid)
#     roznica = []

#     for i in r:
#          roznica += [srednia - i]

     #indeks najmniejszej roznicy to numer gatunku wina
#     if (roznica.index(min(roznica))==0):
#          print("Dla:", nazwa,  "najbardziej zbliżoną do obliczonej wartość średnią ma gatunek pierwszy")
#     if (roznica.index(min(roznica))==1):
#          print("Dla:", nazwa,  "najbardziej zbliżoną do obliczonej wartość średnią ma gatunek drugi")
#     if (roznica.index(min(roznica)) == 2):
#          print("Dla:", nazwa, "najbardziej zbliżoną do obliczonej wartość średnią ma gatunek trzeci")


########REGRESJA LINIOWA DLA POSZCZEGÓLNYCH SKŁADNIKÓW (hurtowo)
#for nazwa,zmienna in zmienne.items():
#     print()
#     print("Składnik:", nazwa)
#     # Wybieramy zmienną  w funkcji numeru obserwacji
#     x = range(len(zmienna))
#     y = zmienna
#     # Liczymy współczynniki regresji - prostej
#     a, b= np.polyfit(x, y, 1)
#     print("Wzór prostej: y(x) =", a, "* x +", b)
#     # Wyliczamy punkty prostej otrzymanej w wyniku regresji
#     yreg = [a * (i) + b for i in x]
     # Wyliczenie miary błędu dopasowania
#     error = sklearn.metrics.mean_absolute_error(y, yreg)
#     print("Miała błędu dopasowania dla: ", nazwa, " wynosi: ", error)
     # Wykresy
#     plt.plot(x, y)
#     plt.plot(x, yreg)
#     plt.title("Regresja liniowa dla składnika: ") #nie wiem jak dopisac nazwe, dodanie po przecinku powoduje blad "AttributeError: 'str' object has no attribute 'pop'"
#     plt.xlabel('Numer analizy')
#    plt.ylabel('Zawartość składnika') #nie wiem jak dopisac nazwe, dodanie po przecinku powoduje blad "AttributeError: 'str' object has no attribute 'pop'"
#     plt.show()


##############REGRESJA WIELOMIANOWA DZIESIĄTEGO STOPNIA DLA POSZCZEGOLNYCH SKŁADNIKÓW (hurtowo)
#for nazwa,zmienna in zmienne.items():
#     print()
#     print("REGRESJA WIELOMIANOWA", nazwa)
#     # Wybieramy zmienną  w funkcji numeru obserwacji
#     x = range(len(zmienna))
#     y = zmienna
     # Liczymy współczynniki regresji - prostej
#     a, b, c, d, e, f, g, h, l, j, k = np.polyfit(x, y, 10)
#     print("Wzór prostej: y(x) =", a, "* x +", b)
#     # Wyliczamy punkty prostej otrzymanej w wyniku regresji
#     yreg = [a * (i ** 10) + b * (i ** 9) + c * (i ** 8) + d * (i ** 7) + e * (i ** 6) + f * (i ** 5) + g * (
 #                 i ** 4) + h * (i ** 3) + l * (i ** 2) + j * (i) + k for i in x]
     # Wyliczenie miary błędu dopasowania
#    error = sklearn.metrics.mean_absolute_error(y, yreg)
#    print("Miała błędu dopasowania dla: ", nazwa, " wynosi: ", error)
     # Wykresy
#    plt.plot(x, y)
#     plt.plot(x, yreg)
#     plt.title("Regresja wielomianowa dziesiątego stopnia dla składnika")
#     plt.xlabel('Numer analizy')
#     plt.ylabel('Zawartość składnika')
#     plt.show()

##############REGRESJA WIELOMIANOWA DZIESIĄTEGO STOPNIA DLA POSZCZEGOLNYCH SKŁADNIKÓW
#print()
#print("REGRESJA WIELOMIANOWA - kwas jabłkowy")
# Wybieramy zmienną  w funkcji numeru obserwacji
#x = range(len(malic_acid))
#y = malic_acid
# Liczymy współczynniki regresji - prostej
#a,b,c,d,e,f,g,h,l,j,k = np.polyfit(x,y,10)
#print("Wzór prostej: y(x) =",a,"* x +",b)
# Wyliczamy punkty prostej otrzymanej w wyniku regresji
#yreg =  [a*(i**10)+ b*(i**9) +c*(i**8) + d*(i**7) + e*(i**6) + f*(i**5) + g*(i**4) + h*(i**3) + l*(i**2) + j*(i) + k for i in x]
# Wykresy
#plt.plot(x,y)
#plt.plot(x,yreg)
#plt.title("Regresja wielomianowa dziesiątego stopnia dla składnika: kwas jabłkowy")
#plt.xlabel('Numer analizy')
#plt.ylabel('Zawartość kwasu jabłkowego')
#plt.show()

#print()
#print("REGRESJA WIELOMIANOWA - magnez")
# Wybieramy zmienną  w funkcji numeru obserwacji
#x = range(len(magnesium))
#y = magnesium
# Liczymy współczynniki regresji - prostej
#a,b,c,d,e,f,g,h,l,j,k = np.polyfit(x,y,10)
#print("Wzór prostej: y(x) =",a,"* x +",b)
# Wyliczamy punkty prostej otrzymanej w wyniku regresji
#yreg =  [a*(i**10)+ b*(i**9) +c*(i**8) + d*(i**7) + e*(i**6) + f*(i**5) + g*(i**4) + h*(i**3) + l*(i**2) + j*(i) + k for i in x]
# Wykresy
#plt.plot(x,y)
#plt.plot(x,yreg)
#plt.title("Regresja wielomianowa dziesiątego stopnia dla składnika: magnez")
#plt.xlabel('Numer analizy')
#plt.ylabel('Zawartość magnezu')
#plt.show()

#print()
#print("REGRESJA WIELOMIANOWA - fenole")
# Wybieramy zmienną  w funkcji numeru obserwacji
#x = range(len(total_phenols))
#y = total_phenols
# Liczymy współczynniki regresji - prostej
#a,b,c,d,e,f,g,h,l,j,k = np.polyfit(x,y,10)
#print("Wzór prostej: y(x) =",a,"* x +",b)
# Wyliczamy punkty prostej otrzymanej w wyniku regresji
#yreg =  [a*(i**10)+ b*(i**9) +c*(i**8) + d*(i**7) + e*(i**6) + f*(i**5) + g*(i**4) + h*(i**3) + l*(i**2) + j*(i) + k for i in x]
# Wykresy
#plt.plot(x,y)
#plt.plot(x,yreg)
#plt.title("Regresja wielomianowa dziesiątego stopnia dla składnika: fenole")
#plt.xlabel('Numer analizy')
#plt.ylabel('Zawartość fenoli')
#plt.show()

#print()
#print("REGRESJA WIELOMIANOWA - flawanoidy")
# Wybieramy zmienną  w funkcji numeru obserwacji
#x = range(len(flavanoids))
#y = flavanoids
# Liczymy współczynniki regresji - prostej
#a,b,c,d,e,f,g,h,l,j,k = np.polyfit(x,y,10)
#print("Wzór prostej: y(x) =",a,"* x +",b)
# Wyliczamy punkty prostej otrzymanej w wyniku regresji
#yreg =  [a*(i**10)+ b*(i**9) +c*(i**8) + d*(i**7) + e*(i**6) + f*(i**5) + g*(i**4) + h*(i**3) + l*(i**2) + j*(i) + k for i in x]
# Wykresy
#plt.plot(x,y)
#plt.plot(x,yreg)
#plt.title("Regresja wielomianowa dziesiątego stopnia dla składnika: flawanoidy")
#plt.xlabel('Numer analizy')
#plt.ylabel('Zawartość flawanoidów')
#plt.show()

#print()
#print("REGRESJA WIELOMIANOWA - intensywność koloru")
# Wybieramy zmienną  w funkcji numeru obserwacji
#x = range(len(color_intensity))
#y = color_intensity
# Liczymy współczynniki regresji - prostej
#a,b,c,d,e,f,g,h,l,j,k = np.polyfit(x,y,10)
#print("Wzór prostej: y(x) =",a,"* x +",b)
# Wyliczamy punkty prostej otrzymanej w wyniku regresji
#yreg =  [a*(i**10)+ b*(i**9) +c*(i**8) + d*(i**7) + e*(i**6) + f*(i**5) + g*(i**4) + h*(i**3) + l*(i**2) + j*(i) + k for i in x]
# Wykresy
#plt.plot(x,y)
#plt.plot(x,yreg)
#plt.title("Regresja wielomianowa dziesiątego stopnia dla składnika: intensywność koloru")
#plt.xlabel('Numer analizy')
#plt.ylabel('Intensywność koloru')
#plt.show()

#print()
#print("REGRESJA WIELOMIANOWA - odcień")
# Wybieramy zmienną  w funkcji numeru obserwacji
#x = range(len(hue))
#y = hue
# Liczymy współczynniki regresji - prostej
#a,b,c,d,e,f,g,h,l,j,k = np.polyfit(x,y,10)
#print("Wzór prostej: y(x) =",a,"* x +",b)
# Wyliczamy punkty prostej otrzymanej w wyniku regresji
#yreg =  [a*(i**10)+ b*(i**9) +c*(i**8) + d*(i**7) + e*(i**6) + f*(i**5) + g*(i**4) + h*(i**3) + l*(i**2) + j*(i) + k for i in x]
# Wykresy
#plt.plot(x,y)
#plt.plot(x,yreg)
#plt.title("Regresja wielomianowa dziesiątego stopnia dla składnika: odcień")
#plt.xlabel('Numer analizy')
#plt.ylabel('Odcień')
#plt.show()

#print()
#print("REGRESJA WIELOMIANOWA - rozcieńczenie win")
# Wybieramy zmienną  w funkcji numeru obserwacji
#x = range(len(diluted_wines))
#y = diluted_wines
# Liczymy współczynniki regresji - prostej
#a,b,c,d,e,f,g,h,l,j,k = np.polyfit(x,y,10)
#print("Wzór prostej: y(x) =",a,"* x +",b)
# Wyliczamy punkty prostej otrzymanej w wyniku regresji
#yreg =  [a*(i**10)+ b*(i**9) +c*(i**8) + d*(i**7) + e*(i**6) + f*(i**5) + g*(i**4) + h*(i**3) + l*(i**2) + j*(i) + k for i in x]
# Wykresy
#plt.plot(x,y)
#plt.plot(x,yreg)
#plt.title("Regresja wielomianowa dziesiątego stopnia dla składnika: rozcieńczenie win")
#plt.xlabel('Numer analizy')
#plt.ylabel('Rozcieńczenie win')
#plt.show()

#X=np.array(yreg).reshape(-1, 1)
#X=np.array(range(len(diluted_wines))).reshape(-1,1)
#y=np.array(diluted_wines).reshape(-1,1)

#X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=0)
#print(X_train.shape)
#print(X_test.shape)
#print(y_train.shape)
#print(y_test.shape)

#wielomian2 = sklearn.preprocessing.PolynomialFeatures(degree=2, include_bias=False)
#X2_ucz = wielomian2.fit_transform(X_train)
#X2_test = wielomian2.fit_transform(X_test)
#params.append("Reg. wielomianowa")
#res.append(fit_regression(X2_ucz, X2_test, y_train, y_test))
#pd.DataFrame(res, index=params)

#calosc_y = malic_acid

#x = np.array_split(calosc_y,3)
#y = range(len(x))
#z = np.asarray(alcohol)
#for chunk in np.array_split(z,3):
#    x = range(len(chunk))
#    a, b = np.polyfit(x, chunk, 1)
#    yreg += [a * i + b for i in x]
# # Wykresy
#plt.plot(x,y)
#plt.plot(calosc_x,y)
#plt.show()


#x = np.array(malic_acid).reshape(1,-1)
#y = np.array(range(len(malic_acid))).reshape(1, -1)
#print(x)
#print()
#print()
#print(y)

#X_ucz, X_test, y_ucz, y_test = sklearn.model_selection.train_test_split(x, y, test_size=0.2, random_state=12345)
#print(X_ucz.shape)
#print(X_test.shape)
#print(y_ucz.shape)
#print(y_test.shape)

