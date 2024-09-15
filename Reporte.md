### Nombre: Daniel Emiliano Vazquez Amador

##Practica 01

Con esta práctica se simuló una clase conjuntos a partir de arreglos de tipo genérico. Los métodos de la clase son algunas de las  operaciones que podemos hacer con ellos, como unir dos conjuntos, encontrar la intersección de dos conjuntos, la diferencia y diferencia simétrica. 
Para hacer esto, primero se programó la interfaz Conjuntable, la cual contiene todos los métodos que usará la clase conjuntos mediante la implementación. Además, se implementó la interfaz Iterable, que por la estructura de nuestro programa nos será útil. Los parámetros de la clase conjunto son un arreglo de tipo genérico <T> y un contador de elementos llamado “elementos”. Se usó el tipo genérico para que se puedan crear conjuntos de cualquier tipo, ya  sean primitivos o no. Posteriormente se creó la subclase IteradorConjunto, la cual implementa la interfaz Iterator, y cuyos métodos son “hasNext” que nos permite saber si dado una posición y orden, hay un siguiente elemento, porque puede darse el caso de que el siguiente elemento sea nulo o en el arreglo  no haya espacio; el otro método es “next()” que te da el siguiente elemento del conjunto, después de que se haya comprobado que este existe. 
El primer constructor es el de omisión “Conjunto()” el cual construye un objeto del tipo conjunto vacío y de tamaño 1. El siguiente constructor es “Conjunto(Conjunto<T> c)” el cual recibe como parámetro otro objeto tipo conjunto, y copia todos los elementos de este en un nuevo conjunto, esto se hace mediante el uso del iterador. Por ultimo tenemos un constructor que recibe como parámetro un arreglo de tipo “T[]”, en el cual se copian todos los elementos de este arreglo en un conjunto nuevo. 
Los siguientes métodos son para trabajar con un conjunto. Son los siguientes: 
1. “esVacio”, el cual mediante el uso del atributo elementos te dice si el conjunto es vacío o no. Retorna una variable tipo boolean.
2.“cardinalidad”, también mediante el atributo elementos retorna el numero de elementos del conjunto. 
3.“Vaciar”, este método elimina todos los elementos del conjunto. 
4.“agregar”, tiene como parámetro una variable de tipo T, y lo que hace es agregar la variable al Conjunto, esto si la variable no está. Como sabemos los conjuntos no tienen orden, pero como se simuló mediante el uso de arreglos entonces la variable se agrega en el último al final del arreglo.
5. “eliminar” recibe como parámetro una variable tipo T, y lo que hace es eliminar dicha variable y no dejar espacios vacíos. 
6.“Contiene” que recibe como parámetro  un elemento tipo T, y te dice si el elemento se encuentra o no en el conjunto. Para hacer esto se hace uso del método next del tirador para comparar cada elemento del conjunto con la variable tipo T. En caso de que si este, regresa una variable boolean del tipo true, y false en caso de que no.
Los siguientes métodos son todas las operaciones que se pueden hacer con conjuntos. Todos los siguientes métodos reciben como parámetro un objeto “c” tipo conjuntable y de igual forma regresan otro objeto tipo conjuntable. Los métodos son: 
1. “union” que une dos conjuntos sin que se repitan elementos.
2. “Intersección” el método que regresa la intersección de dos conjuntos.
3. “Diferencia”, el cual regresa la diferencia del dos conjuntos.
4. “DiferenciaSimétrica” que regresa la diferencia simétrica de dos conjuntos.
5. “Subconjunto” que te dice si el conjunto c es subconjunto del conjunto “conjunto”.

Para los métodos anteriores se uso el iterador y el método “next()” para acceder a los elementos de los conjuntos y compararlos con los del otro conjunto, para finalmente meterlos en un nuevo conjunto que representa la unión, intersección, diferencia, diferencia simétrica, etc. 
El método posterior es el “toString” que mediante el uso del iterador y del next() imprime todos los elementos del conjunto.
El último método es el iterator, que crea un tirador para el conjunto.
Para concluir, con esta práctica se aprendió a usar y su porqué de los iteradores y de los genéricos, los cuales forman parte muy importantes de toda estructura de datos. 