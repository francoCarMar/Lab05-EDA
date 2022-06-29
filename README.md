<div align="center">
<table>
    <theader>
        <tr>
            <td><img src="https://github.com/rescobedoq/pw2/blob/main/epis.png?raw=true" alt="EPIS" style="width:50%; height:auto"/></td>
            <th>
                <span style="font-weight:bold;">UNIVERSIDAD NACIONAL DE SAN AGUSTIN</span><br />
                <span style="font-weight:bold;">FACULTAD DE INGENIERÍA DE PRODUCCIÓN Y SERVICIOS</span><br />
                <span style="font-weight:bold;">ESCUELA PROFESIONAL DE INGENIERÍA DE SISTEMAS</span>
            </th>
            <td><img src="https://github.com/rescobedoq/pw2/blob/main/abet.png?raw=true" alt="ABET" style="width:50%; height:auto"/></td>
        </tr>
    </theader>
    <tbody>
        <tr><td colspan="3"><span style="font-weight:bold;">Formato</span>: Guía de Práctica de Laboratorio / Talleres / Centros de Simulación</td></tr>
        <tr><td><span style="font-weight:bold;">Aprobación</span>:  2022/03/01</td><td><span style="font-weight:bold;">Código</span>: GUIA-PRLD-001</td><td><span style="font-weight:bold;">Página</span>: 1</td></tr>
    </tbody>
</table>
</div>

<div>
<span style="font-weight:bold;">INFORME DE LABORATORIO</span><br />

<table>
<theader>
<tr><th colspan="6">INFORMACIÓN BÁSICA</th></tr>
</theader>
<tbody>
<tr><td>ASIGNATURA:</td><td colspan="5">Estructura de Datos y Algoritmos</td></tr>
<tr><td>TÍTULO DE LA PRÁCTICA:</td><td colspan="5">Árboles</td></tr>
<tr>
<td>NÚMERO DE PRÁCTICA:</td><td>05</td><td>AÑO LECTIVO:</td><td>2022 A</td><td>NRO. SEMESTRE:</td><td>III</td>
</tr>
<tr>
<td>FECHA DE PRESENTACIÓN:</td><td>29/06/2022</td><td>HORA DE PRESENTACIÓN:</td><td colspan="3"></td>
</tr>
<tr><td colspan="3">INTEGRANTE(s):
<ul>
<li>Cárdenas Martínez Franco Luchiano - fcardenasm@unsa.edu.pe</li>
<li>Carrillo Daza Barbara Rubi - bcarrillo@unsa.edu.pe</li>
<li>Diaz Portilla Carlo Rodrigo - cdiazpor@unsa.edu.pe</li>
<li>Hancco Condori Bryan Orlando - bhanccoco@unsa.edu.pe</li>
<li>Mamani Cañari Gabriel Anthony - gmamanican@unsa.edu.pe</li>
</ul>
</td>
<td>NOTA:</td><td colspan="2"></td>
</<tr>
<tr><td colspan="6">DOCENTE(s):
<ul>
<li>Richart Smith Escobedo Quispe - rescobedoq@unsa.edu.pe</li>
</ul>
</td>
</<tr>
</tbody>
</table>

<!-- Reportes -->
## SOLUCIÓN Y RESULTADOS
  
---

I. SOLUCIÓN DE EJERCICIOS/PROBLEMAS <br>
* La organización del repositorio es la siguiente
    ```sh
    .
    ├── Ejercicio01
    │   ├── ExceptionIsEmpty.java
    │   ├── Node.java
    │   ├── Stack.java
    │   ├── StackLink.java
    │   └── Test.java
    ├── Ejercicio02Graficas
    │   ...	
    │   └── graficas
    ├── Ejercicio03
    │   ├── AVL.java
    │   ├── ItemDuplicated.java
    │   ├── ItemNotFound.java
    │   └── Test.java
    └── README.md
    ```
  * **Nota :** Para los Ejercicios 1 y 3 se debera compilar y ejecutar "Test.java".
* **Ejercicio 1:** Corchetes equilibrados
  Para este ejercicio se implemento un Stack, por su modo de acceso a los datos LIFO. Por otro lado para la determinacion de el balance de las cadenas de corchetes se considero el siguiente metodo.
  ```java
  public static String isBalanced(String s) throws ExceptionIsEmpty{
    if(s == null || s.isEmpty() || s.length()%2 == 1) return "NO"; // casos obvios NO
    StackLink<Character> stack = new StackLink<>();
    int i = 0;
    //bucle para insertar en el stack 	
    while(i < s.length() && !isNegative(s.charAt(i))){ 
      stack.push(s.charAt(i++));
    }    
    while(i < s.length() && !stack.isEmpty() && arePairs(stack.top(), s.charAt(i++))){ 
      stack.pop(); // si tiene pareja se elimina en este bucle	
    }
    //stack vacio y ya se itero la cadena completa es SI
    if(stack.isEmpty() && i == s.length()) return "SI"; 
    return "NO";					     		
  }
  ```    
* **Ejercicio 2:** Operaciones de árbol AVL

  Para el ejercicio 2 se simuló las siguientes operaciones realizadas en un árbol AVL.

  Insert: 100 - 200 - 300 - 400 - 500 - 50 - 25 - 350 - 375 - 360 - 355 - 150 - 175 - 120 - 190

  Delete: 100 - 200 - 300 - 400 - 500 - 50 - 25 - 350 - 375 - 360 - 355 - 150 - 175 - 120 - 190

  * **Operaciones Insert**
  * insert(**100**)
  
    En el primer <code>insert</code> se reconoce que el árbol AVL está vacío, entonces insertamos el primer elemento y será nuestro <code>root</code> del árbol.

    <img src="Ejercicio02Graficas/insert1.jpeg" style="width:50%; height:auto"/>

  * insert(**200**)
  
    Cuando se inserta 200 el factor de equilibrio (f.b.) de la raíz será igual a 1, notando que el árbol está inclinado a la derecha. Pero debido a que no estamos en valores críticos como -2 o 2, no se produce balance y continuamos.

    <img src="Ejercicio02Graficas/insert2.jpeg" style="width:50%; height:auto"/>

  * insert(**300**)
  
    Cuando se inserta 300 notamos que se produce un desequilibrio a la derecha, cuando se actualizan los factores de equilibrio se llega a 2, pero para equilibrar el árbol solo será necesario una <code>rotacionSimpleIzquierda()</code>.

    <img src="Ejercicio02Graficas/insert3.jpeg" style="width:60%; height:auto"/>

  * insert(**400**)
  
    Cuando se inserta 400 el árbol se inclina a la derecha con factores de balance de 1, entonces no es necesario balancear.

    <img src="Ejercicio02Graficas/insert4.jpeg" style="width:50%; height:auto"/>

  * insert(**500**)
  
    Cuando se inserta 500 se produce un desequilibrio a la derecha con factores de balance de 2, para equilibrar el árbol solo será necesario una <code>rotacionSimpleIzquierda()</code>.

    <img src="Ejercicio02Graficas/insert5.jpeg" style="width:70%; height:auto"/>

  * insert(**50**)
  
    Cuando se inserta 50 se producen cambios de factores de balance a la izquierda de -1, pero no es necesario balancear el árbol.

    <img src="Ejercicio02Graficas/insert6.jpeg" style="width:50%; height:auto"/>

  * insert(**25**)
  
    Cuando se inserta 25 se produce un desequilibrio a la izquierda, resultando en factores de balance de -2, entonces es necesario equilibrar. Para este caso notamos que los factores de balance son -2 y luego -1, entonces necesitaremos aplicar una <code>rotacionSimpleDerecha()</code> para equilibrar el árbol.
    
    <img src="Ejercicio02Graficas/insert7.jpeg" style="width:70%; height:auto"/>

  * insert(**350**)
  
    Cuando se inserta 350 el árbol se inclina a la derecha, los factores de balance cambian a 1 pero no es necesario equilibrar.
    
    <img src="Ejercicio02Graficas/insert8.jpeg" style="width:50%; height:auto"/>

  * insert(**375**)
  
    Cuando se inserta 375 el árbol no está equilibrado. Analizando los factores de balance 2 y 1 sabemos que tenemos que aplicar una <code>rotacionSimpleIzquierda()</code>.
    
    <img src="Ejercicio02Graficas/insert9.jpeg" style="width:70%; height:auto"/>

  * insert(**360**)
  
    Cuando se inserta 360 se produce un desequilibrio en el árbol, pero en este caso notamos que los factores de balance son -2 y 1, esto nos indica que tenemos que hacer una rotación doble. Para equilibrar este árbol tenemos que realizar una <code>rotacionDobleDerecha()</code> que consiste en realizar primero una <code>rotacionSimpleIzquierda()</code> y luego una <code>rotacionSimpleDerecha()</code>.
    
    <img src="Ejercicio02Graficas/insert10.jpeg" style="width:70%; height:auto"/>

  * insert(**355**)
  
    Cuando se inserta 355 y se actualizan los factores de balance nos resulta en 2 y -1, entonces para equilibrar este árbol se tiene aplicar una <code>rotacionDobleIzquierda()</code> que sería el resultado de hacer una <code>rotacionSimpleDerecha()</code> y una <code>rotacionSimpleIzquierda()</code>.
    
    <img src="Ejercicio02Graficas/insert11.jpeg" style="width:70%; height:auto"/>

  * insert(**150**)
  
    Cuando se inserta el 150 el árbol no está equilibrado debido a los factores de balance -2 y 1, para equilibrar este árbol se aplica una <code>rotacionDobleDerecha()</code>.
    
    <img src="Ejercicio02Graficas/insert12.jpeg" style="width:70%; height:auto"/>

  * insert(**175**)
  
    Cuando se inserta el 175 los factores de balance cambian a -1 y 1, entonces no es necesario balancear el árbol.
    
    <img src="Ejercicio02Graficas/insert13.jpeg" style="width:50%; height:auto"/>

  * insert(**120**)
  
    Cuando se inserta el 120, igualmente que el caso anterior, no es necesario balancear el árbol.
    
    <img src="Ejercicio02Graficas/insert14.jpeg" style="width:50%; height:auto"/>

  * insert(**190**)
  
    Cuando se inserta el 190 el árbol no se encuentra equilibrado debido a los factores de balance -2 y 1, entonces para equilibrar el árbol se aplica una <code>rotacionDobleDerecha()</code>.
    
    <img src="Ejercicio02Graficas/insert15.jpeg" style="width:70%; height:auto"/>


  * **Operaciones Delete**
  * delete(**100**)
  
    Cuando eliminamos el 100 notamos que tiene 2 hijos, entonces es necesario buscar el sucesor <code>in orden</code> (nodo verde) del 100, reemplazarlo y luego recién eliminarlo.
    
    <img src="Ejercicio02Graficas/delete1.jpeg" style="width:70%; height:auto"/>

  * delete(**200**)
  
    Cuando eliminamos el 200, igual que el caso anterior, tenemos que buscar el sucesor (nodo verde) y reemplazarlo, entonces el nodo recién se elimina.
    
    <img src="Ejercicio02Graficas/delete2.jpeg" style="width:70%; height:auto"/>

  * delete(**300**)
  
    Cuando eliminamos el 300 notamos que solo tiene un hijo, entonces no es necesario buscar sucesores, solo conectamos el nodo hijo al padre y se elimina el nodo.
    
    <img src="Ejercicio02Graficas/delete3.jpeg" style="width:70%; height:auto"/>

  * delete(**400**)
  
    Cuando eliminamos el 400, igual que el caso anterior, solo tiene un solo hijo, entonces lo conectamos al nodo padre y el nodo se elimina.
    
    <img src="Ejercicio02Graficas/delete4.jpeg" style="width:70%; height:auto"/>

  * delete(**500**)
  
    Cuando eliminamos el 500 se produce un desequilibrio en el árbol y los factores de balance son -2 y -1 lo cual nos indica que se tiene que realizar una <code>rotacionSimpleDerecha()</code>.
    
    <img src="Ejercicio02Graficas/delete5.jpeg" style="width:70%; height:auto"/>

  * delete(**50**)
  
    Cuando eliminamos el 50 solo tenemos que conectar su único hijo al nodo padre para poder eliminar el nodo.
    
    <img src="Ejercicio02Graficas/delete6.jpeg" style="width:70%; height:auto"/>

  * delete(**25**)
  
    Cuando eliminamos el 25, el árbol no está balanceado, entonces verificando los factores de balance 2 y 0 aplicamos una <code>rotacionSimpleIzquierda()</code>.
    
    <img src="Ejercicio02Graficas/delete7.jpeg" style="width:70%; height:auto"/>

  * delete(**350**)
  
    Cuando eliminamos el 350 debido a que tiene dos nodos hijos tenemos que encontrar el sucesor (verde), luego reemplazarlo y eliminarlo.
    
    <img src="Ejercicio02Graficas/delete8.jpeg" style="width:70%; height:auto"/>

  * delete(**375**)
  
    Cuando eliminamos el 375 se produce un desequilibrio en el árbol, evaluando los factores de balance -2 y -1 tenemos que aplicar una <code>rotacionSimpleDerecha()</code>.
    
    <img src="Ejercicio02Graficas/delete9.jpeg" style="width:70%; height:auto"/>

  * delete(**360**)
  
    Cuando eliminamos el 360 no hay problemas debido a que es una hoja y solo tenemos que desvincularlo.
    
    <img src="Ejercicio02Graficas/delete10.jpeg" style="width:60%; height:auto"/>

  * delete(**355**)
  
    Cuando eliminamos el 355, igual que el caso anterior, solo lo desvinculamos del nodo padre.
    
    <img src="Ejercicio02Graficas/delete11.jpeg" style="width:60%; height:auto"/>

  * delete(**150**)
  
    Cuando eliminamos el 150, al ser nodo hoja solo tenemos que desvincularlo del nodo padre.
    
    <img src="Ejercicio02Graficas/delete12.jpeg" style="width:60%; height:auto"/>

  * delete(**175**)
  
    Cuando eliminamos el 175 notamos que tiene 2 nodos hijos, entonces tenemos que buscar el sucesor (verde) y reemplazarlo.
    
    <img src="Ejercicio02Graficas/delete13.jpeg" style="width:60%; height:auto"/>

  * delete(**120**)
  
    Cuando eliminamos el 120, al ser nodo hoja solo tenemos que desvincularlo del nodo padre.
    
    <img src="Ejercicio02Graficas/delete14.jpeg" style="width:50%; height:auto"/>

  * delete(**190**)
  
    Cuando eliminamos el 190 estamos eliminando el último elemento del árbol, por lo que el árbol AVL ya no tiene elementos.
    
    <img src="Ejercicio02Graficas/delete15.jpeg" style="width:50%; height:auto"/>


* **Ejercicio 3:** Árbol AVL
---

II. CONCLUSIONES
	
- 
	
---
    
## RETROALIMENTACIÓN GENERAL
 <pre>
 
 </pre>
---
    
### REFERENCIAS Y BIBLIOGRAFÍA
<ul>
    <li>https://www.w3schools.com/java/</li>
    <li>https://www.eclipse.org/downloads/packages/release/2022-03/r/eclipse-ide-enterprise-java-and-web-developers</li>
    <li>https://algorithmtutor.com/Data-Structures/Tree/AVL-Trees/</li>
    <li>https://docs.oracle.com/javase/tutorial/java/generics/types.html</li>
</ul>
