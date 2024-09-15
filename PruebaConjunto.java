public class PruebaConjunto{
	
	public static void main(String[] args){
		Integer[] i = {1,2,3,4,5};
		Integer[] j = {2,4,5,6,7,8};
		Conjunto<Integer> c1 = new Conjunto(i);
		Conjunto<Integer> c2 = new Conjunto(j);
		System.out.println("El conjunto 1 es: ");
		System.out.println(c1);
		Conjunto<Integer> union = (Conjunto<Integer>)(c1.union(c2));
		Conjunto<Integer> interseccion = (Conjunto<Integer>)(c1.interseccion(c2));
		System.out.println("El conjunto interseccion es: ");
		System.out.println(interseccion);
		System.out.println("El conjunto union es; ");
		System.out.println(union);
		
	}
}