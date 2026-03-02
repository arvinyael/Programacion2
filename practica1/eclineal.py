class EcuacionLineal: 
    def __init__(self, a, b, c, d, e, f):
        self.__a = a
        self.__b = b
        self.__c = c
        self.__d = d
        self.__e = e
        self.__f = f
    def tienesol(self):
        if(self.__a*self.__d - self.__b * self.__c != 0): 
            return True
        else: 
            return False
    def getx(self):
        self.__x = (self.__e * self.__d - self.__b * self.__f) / (self.__a * self.__d - self.__b * self.__c)
        return self.__x
    def gety(self): 
        self.__y = (self.__a * self.__f - self.__e * self.__c) / (self.__a * self.__d - self.__b * self.__c)
        return self.__y

class Main():    
    a = int(input("ingrese el alor de a: "))
    b = int(input("ingrese el valor de b: "))
    c = int(input ("ingrese el valor de c: "))
    d = int(input("ingrese el valor de d: "))
    e = int(input("ingrese el valor de e: "))
    f = int(input("ingrese el valor de f: "))
    ecuacion = EcuacionLineal(a, b, c, d, e, f)
    if (ecuacion.tienesol()):
        print(f"la solucion es x: {ecuacion.getx()} y: {ecuacion.gety()}")
    else: 
        print ("la ecuacion no tiene solucion")
        