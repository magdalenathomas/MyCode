import pd as pd
import sklearn.linear_model
import csv
from sklearn.model_selection import train_test_split
alcohol = []
malic_acid = []
plik = open('wine.csv', 'rt')
dane = csv.reader(plik, delimiter=',')
next(dane)                # Opuszczamy pierwszy wiersz
for wiersz in dane:
    alcohol.append(float(wiersz[0]))
    malic_acid.append(float(wiersz[1]))
plik.close()
#X = malic_acid
#y = range(len(malic_acid))

dataset = pd.read_csv('wine.csv')
X = dataset.iloc[:, 1:2].values
y = dataset.iloc[:, 3].values
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=0)

# Fitting Linear Regression to the dataset
from sklearn.linear_model import LinearRegression
lin_reg = LinearRegression()
lin_reg.fit(X, y)

# Visualizing the Linear Regression results
def viz_linear():
    plt.scatter(X, y, color='red')
    plt.plot(X, lin_reg.predict(X), color='blue')
    plt.title('Truth or Bluff (Linear Regression)')
    plt.xlabel('Position level')
    plt.ylabel('Salary')
    plt.show()
    return
viz_linear()

#mnk = sklearn.linear_model.LinearRegression()

#mnk.fit(X,y)

mnk.intercept_

#mnk.coef_

#x_nowy = X.mean().values.reshape(1,-1)
#x_nowy
#dodajmy też małą wartość do x_nowy, np. 0.001

#mnk.predict(x_nowy)

#ocena jakości modelu
#porównanie wartości dopasowanych, obliczonych za pomocą modelu z wartościami oryginalnymi
#y_pred = mnk.predict(X)
#y_pred[0:8]

#y[0:8]

#współczynnik determinacji R2
#mnk.score(X,y)

#sklearn.metrics.r2_score(y, y_pred)

#lub inne miary błędów dopasowania
#MSE
#sklearn.metrics.mean_squared_error(y, y_pred)

#MAE
#sklearn.metrics.mean_absolute_error(y, y_pred)

#MedAE
#sklearn.metrics.median_absolute_error(y, y_pred)

#zależy nam na dobrych zdolnościach predykcyjnych modelu
#ale uważamy też żeby nie przeuczyć modelu,
#zatem dzielimy zbiór na próbę uczącą (80%) i testową (20%)
#X_ucz, X_test, y_ucz, y_test = sklearn.model_selection.train_test_split(X, y, test_size=0.2, random_state=12345)
#print(X_ucz.shape)
#print(X_test.shape)
#print(y_ucz.shape)
#print(y_test.shape)

#stworzymy funkcję, która dopasowuje model regresji liniowej do danej próby
#oraz oblicza miary błędów dopasowania

