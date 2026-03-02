#ej 4 de forma poo 
class Estadistica:
    def __init__(self, vec):
        self.__vec = vec
    def promedio (self):
        sum = 0
        for i in len(self.__vec):
            sum += i
        return sum / len(self.__vec)
    def desviacion (self):
        prom = self.promedio()
        sum = 0
        for i in self.__vec:
            sum += (i - prom)**2
        return (sum / (len(self.__vec)-1))**0.5
class Main():
    vec = [0] * 10
    for i in range(len(vec)):
        vec[i] = int(input(f"ingrese el numero {i+1}: "))
        arr = vec
    e1= Estadistica(arr)
    print(f"el promedio es: {e1.promedio()}")
    print(f"la desviacion estandar es: {e1.desviacion()}")