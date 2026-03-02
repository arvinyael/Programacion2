#ecuaciones cuadraticas

class EcuacionLineal:
    def __init__(self, a, b, c): 
        self.__a = a
        self.__b = b
        self.__c = c
    def getDiscriminante(self):
        self.__discriminante = self.__b**2 - 4*self.__a*self.__c
        return self.__discriminante
    def Raiz1(self):
        self.__raiz1 = (-self.__b + self.getDiscriminante()**0.5) / (2*self.__a)
        return self.__raiz1
    def Raiz2(self):
        self.__raiz2 = (-self.__b - self.getDiscriminante()**0.5) / (2*self.__a)
        return self.__raiz2
class Main():
        a = int(input("ingrese a: "))
        b = int(input("ingrese b: "))
        c = int(input("ingrese c: "))
        r1 = EcuacionLineal(a, b, c)

        if (r1.getDiscriminante() > 0):
            print(f"la raiz 1 es: {r1.Raiz1()} y la raiz 2 es: {r1.Raiz2()}")
        elif r1.getDiscriminante() == 0:
            print(f"la raiz es: {r1.Raiz1()}")
        else:
            print("no tiene raices reales")