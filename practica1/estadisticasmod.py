#ej 4 de forma modularizada
def promedio (vec):
    suma = 0
    for i in vec:
        suma += i
    return suma / len(vec)
def desviacion (vec):
    prom = promedio(vec)
    suma = 0
    for i in vec:
        suma += (i - prom)**2
    return (suma / (len(vec)-1))**0.5

    
vec = [0] * 10
for i in range(len(vec)):
    vec[i] = int(input(f"ingrese el numero {i+1}: "))
    


print(f"el promedio es: {promedio(vec)}")
print(f"la desviacion estandar es: {desviacion(vec)}")