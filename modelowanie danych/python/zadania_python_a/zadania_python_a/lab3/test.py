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

print ("hallo")
