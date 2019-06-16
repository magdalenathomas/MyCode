import matplotlib.pyplot as plt
import pandas as pd
import sklearn
from matplotlib.backends.backend_pdf import PdfPages
from sklearn.metrics import r2_score
from sklearn.linear_model import LinearRegression
from sklearn.preprocessing import PolynomialFeatures

#wczytanie danych do analizy
data = pd.read_csv('wine.csv')

#wyświetlenie informacji o danych, które zostaną poddane analizie
print(data.head())
print()
print(data.info())
print()

#zamiana zmiennej na zmienną kategoryczną
data['Cultivar'] = data['Cultivar'].astype('category')

#wyświetlenie liczby wierszy w zależności od rodzaju odmianu (1, 2 lub 3)
print(data['Cultivar'].value_counts())

#utworzenie zbioru z analizą chemiczną składników w winie o odmianie numer 2 (zmaleziono najwięcej wystąpień)
kat_2 = data[data['Cultivar'] == 2]

#przygotowanie zbiorów do modelowania (zależność ilości alkoholu od odcienia wina)
x = kat_2.iloc[:, 1:2].values
y = kat_2.iloc[:, 11].values

############MODEL REGRESJI LINIOWEJ
regression = LinearRegression()
regression.fit(x, y)
y_reg = regression.predict(x)

mae = sklearn.metrics.mean_absolute_error(y,y_reg)
r = r2_score(y, y_reg)
print("MAE of linear regression: ", mae)
print("R2 of linear regression: ", r)
print()

#zobrazowanie wyników na wykresie
plt.scatter(x, y, color='black')
plt.plot(x, y_reg, color='blue')
plt.title('Linear Regression')
plt.xlabel('Analized component - alcohol')
plt.ylabel('Analized component - hue')
plt.show()


############MODEL WIELOMIANOWY
poly = PolynomialFeatures(degree=2)
x_poly = poly.fit_transform(x)
poly.fit(x_poly, y)
regression.fit(x_poly, y)
y_reg_poly = regression.predict(x_poly)

mae2 = sklearn.metrics.mean_absolute_error(y,y_reg_poly)
r2 = r2_score(y, y_reg)
print("MAE of polynomial regression: ", mae2)
print("R2 of polynomial regression: ", r2)


#zobrazowanie wyników na wykresie
plt.scatter(x, y, color='black')
plt.plot(x,y_reg_poly, color='red')
plt.title('Polynomial Regression')
plt.xlabel('Analized component - alcohol')
plt.ylabel('Analized component - hue')
plt.show()

#zestawienie modelu regresji liniowej oraz wielomianowej, zapisanie wykresu w formacie pdf
with PdfPages("{}.pdf".format('regression2')) as pdf:
    plt.scatter(x, y, color='black')
    plt.plot(x,y_reg_poly, color='red')
    plt.plot(x, y_reg, color='blue')
    plt.title('Lineral and Polynomial Regression')
    plt.xlabel('Analized component - alcohol')
    plt.ylabel('Analized component - hue')
    pdf.savefig()
    plt.show()