package exercicio;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ArvoreEquacao {
	
	private NoBinario<String> raiz;
	private double resultadoAtual;
	String m, n, r;
	Scanner sc = new Scanner(System.in);
    char[] c;
    int k = 0;
	ListaLigada<String> listaIncognitas = new ListaLigada<String>();
	ListaLigada<String> listaAux = new ListaLigada<String>();
	
	public void fazerArvore(String equacao) {
		
	   PilhaDinamica<NoBinario> pilhaSubarvore= new PilhaDinamica<NoBinario>();
	   PilhaDinamica<NoBinario> pilhaOperador = new PilhaDinamica<NoBinario>(); 
	   StringTokenizer stringParaVerificar = new StringTokenizer(equacao, " ");
	   
	  
	   while(stringParaVerificar.hasMoreTokens()) {
		   
		   String s = stringParaVerificar.nextToken();
		   r = null;
		   
		   if((s.equals("*"))||( s.equals("+")) ||(s.equals("-"))||(s.equals("/"))) {
			
			 NoBinario<String> aux= new NoBinario<String>(s);
			 pilhaOperador.push(aux);
			
		   }else if(s.equals(")")) {
		     
		     NoBinario<String> auxSubArvore = new NoBinario<String>(null);

		     auxSubArvore = pilhaOperador.pop();
		 
		     r = (String) pilhaSubarvore.top().getInfo();
		     c = r.toCharArray();
		     
		     if((!Character.isDigit(c[0])) && (c[0] != '+') && (c[0] != '-') && (c[0] != '*') && (c[0] != '/')) {
		    	 listaIncognitas.add(r);
		    	 listaAux.add(r);
		     }
		     
		     auxSubArvore.setDireita(pilhaSubarvore.pop());
		     
		     r = (String) pilhaSubarvore.top().getInfo();
		     c = r.toCharArray();
		     
		     if((!Character.isDigit(c[0])) && (c[0] != '+') && (c[0] != '-') && (c[0] != '*') && (c[0] != '/')) {
		    	 listaIncognitas.add(r);
		    	 listaAux.add(r);
		     }
		     
		     auxSubArvore.setEsquerda(pilhaSubarvore.pop());
		     pilhaSubarvore.push(auxSubArvore);
		       
		     
		   }else if(s.equals("(")){
			  
		   }else{
			  
			   NoBinario<String> aux= new NoBinario<String>(s);
			   pilhaSubarvore.push(aux);
			   
		   }
	   }
	   System.out.println(equacao);
	   raiz = pilhaSubarvore.pop();
	   informarVariavel();
	   System.out.println();
	   System.out.println("Equação em ordem:");
	   imprimirEquacao(raiz);
	   System.out.println();
	   System.out.println();
	   System.out.println("Resultado do calculo:");
	   System.out.println(fazerCalculo(raiz));
	   }

   public double  fazerCalculo(NoBinario<String> a) {
	   
	   String operador;
	   double aux1,aux2,resultado=0;
	   NoBinario<String> aux = a;
	   
	   if(aux != null ) {
		   
		   if(aux.getInfo().equals("*")|| aux.getInfo().equals("/") || aux.getInfo().equals("+") || aux.getInfo().equals("-")) {
           
			   aux1 = fazerCalculo(aux.getEsquerda());
			   aux2= fazerCalculo(aux.getDireita());
			   operador = aux.getInfo();
		  	   resultado = fazerMiniCalculo(aux1, aux2, operador);
		   
		   }else {
			   
			   return Double.parseDouble(aux.getInfo());
			   
		   }
		
	   }
	   return resultado;
	   }
   
   public double fazerMiniCalculo(double a, double b, String operador) {
	
	 if( operador.equals("*")){
		 
		 resultadoAtual = (a) * (b);
	 
	 }else  if( operador.equals("/")){
		 
		 resultadoAtual =  (a) / (b);
	 
	 }else  if( operador.equals("-")){
		 
		 resultadoAtual =  (a) - (b);
	
	 }else  if( operador.equals("+")){
		 
		 resultadoAtual =  (a) + (b);
	 
	 } 
	   
	return resultadoAtual;
}
   
   public void informarVariavel() {
		boolean verifica = true;
		for(int i = 0; i < listaIncognitas.size(); i++) {
			
			System.out.println("Informe o valor da variavel " + listaIncognitas.get(i) + ":");
			
			do {
			
				m = sc.next();
			
				for(int j = 0; j < m.length(); j++) {
				
					if((!Character.isDigit(m.charAt(j))) && (m.charAt(j) != '.')) {
					verifica = false;
					break;
				
					}else {
					verifica = true;
				}
			}
			
				listaIncognitas.set(i, m);
			
			}while(verifica == false);
		}
	}
   
   
   private void imprimirEquacao(NoBinario<String> raizSubArvore) {
	   
	 
	   if (raizSubArvore != null) {
		   
		   r = raizSubArvore.getInfo();
		   c = r.toCharArray();
		   
		   if((!Character.isDigit(c[0])) && (c[0] != '+') && (c[0] != '-') && (c[0] != '*') && (c[0] != '/')) {
				
			   k=0;
			   
			   while(listaIncognitas.size() > 0) {     
			   
				   if(raizSubArvore.getInfo().equals(listaAux.get(k))) {
			        raizSubArvore.setInfo(listaIncognitas.get(k));
					listaIncognitas.remove(listaIncognitas.get(k));
					break;
					
				   }else {
						k++;
					}
			   }
				
		   } 
		       else {
					
				}
			
		    System.out.print("(");
			imprimirEquacao(raizSubArvore.getEsquerda());
			System.out.print( raizSubArvore.getInfo());
			imprimirEquacao(raizSubArvore.getDireita());
		    System.out.print(")");
			
		}
	}
   
 

}