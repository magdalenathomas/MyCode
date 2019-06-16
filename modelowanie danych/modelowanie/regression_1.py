from matplotlib.backends.backend_pdf import PdfPages
import matplotlib.pyplot as plt
import pandas as pd
import sklearn.preprocessing
from sklearn.metrics import mean_squared_error, r2_score
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LinearRegression
from sklearn.preprocessing import PolynomialFeatures

#wczytanie danych do analizy
t = pd.read_csv('wine.csv', index_col=0)

#przygotowanie do modelowania zależności ilości alkoholu od odcienia wina
#podział danych na próbę uczącą się(80%) oraz testową(20%)
x_train, x_test, y_train, y_test = train_test_split(t['Alcohol'], t['Hue'], test_size=0.2, random_state=0)
x_train = pd.DataFrame(data=x_train)
x_test = pd.DataFrame(data=x_test)

##########MODEL REGRESJI LINIOWEJ
regressor = sklearn.linear_model.LinearRegression()
regressor.fit(x_train, y_train)
y_pred = regressor.predict(x_test)
ptrain= regressor.predict(x_train)

mae = sklearn.metrics.mean_absolute_error(y_test,y_pred)
r = r2_score(y_test, y_pred)
print("MAE of linear regression: ", mae)
print("R2 of linear regression: ", r)
print()

#zobrazowanie wyników na wykresie
plt.scatter(x_test, y_test, color='black')
plt.plot(x_test, y_pred, color='orange')
plt.title('Linear Regression')
plt.xlabel('Analized component - alcohol')
plt.ylabel('Analized component - hue')
plt.show()

##############MODEL WIELOMIANOWY
polynomial = PolynomialFeatures(degree=2)
x_train_poly = polynomial.fit_transform(x_train)
regressor.fit(x_train_poly, y_train)
y_train_predicted = regressor.predict(x_train_poly)
y_test_predict = regressor.predict(polynomial.fit_transform(x_test))

mae2 = sklearn.metrics.mean_absolute_error(y_test,y_test_predict)
r2 = r2_score(y_test, y_test_predict)
print("MAE of polynomial regression: ", mae2)
print("R2 of polynomial regression: ", r2)
print()

#zobrazowanie wyników na wykresie
plt.scatter(x_test, y_test, color='black')
plt.plot(x_test, y_test_predict, color='green')
plt.title('Polynomial Regression')
plt.xlabel('Analized component - alcohol')
plt.ylabel('Analized component - hue')
plt.show()

#zestawienie modelu regresji liniowej oraz wielomianowej, zapisanie wykresu w formacie pdf
with PdfPages("{}.pdf".format('regression1')) as pdf:
    plt.scatter(x_test, y_test, color='black')
    plt.plot(x_test, y_pred, color='orange')
    plt.plot(x_test, y_test_predict, color='green')
    plt.title('Lineral and Polynomial Regression')
    plt.xlabel('Analized component - alcohol')
    plt.ylabel('Analized component - hue')
    pdf.savefig()
    plt.show()