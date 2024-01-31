# RungeKutta

Este repositorio contiene un programa en Java para resolver un sistema de ecuaciones diferenciales utilizando el método
de Runge-Kutta. El programa solicita la entrada del usuario para parámetros como el tamaño del paso (h), condiciones
iniciales **(x1 e y1)**, y el rango de iteraciones. Luego realiza los cálculos y muestra los resultados tanto en forma
tabular como gráfica.

## Tabla de Contenidos

* [Requisitos Previos](#requisitos-previos)
* [Instalación](#instalación)
* [Formato de Entrada](#formato-de-entrada)
* [Ejemplo de Entrada](#ejemplo-de-entrada)
* [Ejemplo de Salida](#ejemplo-de-salida)
* [Dependencias](#dependencias)
* [Nota](#nota)

## Requisitos Previos

Antes de ejecutar la aplicación, asegúrese de tener instalados los siguientes requisitos previos:

1. [x] Java 8 o posterior
2. [x] Maven

## Instalación

Para instalar la aplicación, siga los siguientes pasos:

1. Clone el repositorio en su máquina local:

```bash 
git clone https://github.com/OmerJuve2023/RungeKutta.git
```

2. Navegue a la carpeta del proyecto:

```bash
cd RungeKutta
```

3. Compile el proyecto:

```bash
mvn clean install
```

4. Ejecute el proyecto:

```bash
java -jar target/RungeKutta-1.0.0.jar
```

## Formato de Entrada

* **h:** Tamaño del paso para cada iteración.
* **Función A y Función B:** Expresiones matemáticas que representan el sistema de ecuaciones diferenciales.
* **x1 e y1:** Condiciones iniciales para las variables.
* **Rango inicial y Rango final:** El rango de iteraciones.

## Ejemplo de Entrada

```shell script
Income h: 1
Income Function A: 2*x+2
Income Function B: 3*y+1
Income x1: 1
Income y1: 2
Income init range: 0
Income final range: 10
```

## Ejemplo de Salida

```shell script
----------------------------
itera: 1		t: 1
K1: 4	L1: 7
k2: 2*8.0+2=8		L2: 3*17.5+1=17.5
k3: 2*12.0+2=12		L3: 3*33.25+1=33.25
k4: 2*28.0+2=28		L4: 3*106.75+1=17.5
----------------------------------------------------------
itera: 2		t: 2
K1: 28	L1: 114.625
k2: 2*56.0+2=56		L2: 3*286.5625+1=286.5625
k3: 2*84.0+2=84		L3: 3*544.46875+1=544.46875
k4: 2*196.0+2=196		L4: 3*1748.03125+1=286.5625
----------------------------------------------------------
itera: 3		t: 3
K1: 196	L1: 1876.984375
k2: 2*392.0+2=392		L2: 3*4692.460938+1=4692.460938
k3: 2*588.0+2=588		L3: 3*8915.675781+1=8915.675781
k4: 2*1372.0+2=1372		L4: 3*28624.011719+1=4692.460938
----------------------------------------------------------
...

iteration		T			X			Y
	1	|		0.00	|	01.000000	|	02.000000
	2	|		1.00	|	13.000000	|	37.875000
	3	|		2.00	|	97.000000	|	625.328125
	4	|		3.00	|	685.000000	|	10244.873047
	5	|		4.00	|	4801.000000	|	167764.921143
	6	|		5.00	|	33613.000000	|	2747155.708710
	7	|		6.00	|	235297.000000	|	44984679.855122
	8	|		7.00	|	1647085.000000	|	736624137.752616
	9	|		8.00	|	11529601.000000	|	12062220260.824093
	10	|		9.00	|	80707213.000000	|	197518856776.119540
Continue:    si/no 
```

## Dependencias

```xml

<dependencies>
    <dependency>
        <groupId>org.scijava</groupId>
        <artifactId>jep</artifactId>
        <version>2.4.2</version>
    </dependency>
    <dependency>
        <groupId>com.github.yannrichet</groupId>
        <artifactId>JMathPlot</artifactId>
        <version>1.0.1</version>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.18.30</version>
        <scope>provided</scope>
    </dependency>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-api</artifactId>
        <version>5.10.1</version>
    </dependency>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-engine</artifactId>
        <version>5.10.0</version>
        <scope>test</scope>
    </dependency>
</dependencies>

```

## Nota

Este programa utiliza el método de Runge-Kutta para aproximar soluciones a un sistema de ecuaciones diferenciales. La
precisión de los resultados depende del tamaño del paso (h). Ajusta el tamaño del paso en función de las características
específicas del sistema que estás modelando.