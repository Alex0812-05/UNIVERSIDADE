import java.util.ArrayList;
	import java.util.List;

	public class Universidade {
	
	    String nome;
	    String ra; // Registro Acadêmico
	    List<Double> notas; // Lista para armazenar notas
	    boolean ead; // Indica se o aluno está em uma disciplina EAD
	    double presencas; // Percentual de presença
	    
	    public Universidade () {
	    	
	    }

	    // Construtor para disciplinas presenciais
	    public Universidade(String nome, String ra, boolean ead, double presencas, Double... notas) {
	        this.nome = nome;
	        this.ra = ra;
	        this.ead = ead;
	        this.presencas = presencas;
	        this.notas = new ArrayList<>();
	        for (Double nota : notas) {
	            this.notas.add(nota);
	        }
	    }

	    //Construtor para realizar o calculo da nota final
	    public double calcularNotaFinal() {
	        double notaFinal = 0.0;
	        int numNotas = notas.size(); 

	        if (numNotas <= 2) {
	         
	            for (double nota : notas) {
	                notaFinal += nota;
	            }
	            notaFinal /= numNotas;
	        } else if (numNotas == 3) {
	    
	            notaFinal = (notas.get(0) + (2 * notas.get(1)) + (2 * notas.get(2))) / 5;
	        } else if (numNotas == 4) {
	           
	            notaFinal = (notas.get(0) * 0.15) + (notas.get(1) * 0.30) + (notas.get(2) * 0.10) + (notas.get(3) * 0.45);
	        }
	        return notaFinal;
	    }

	  
	   //Construtor responsável por saber se o aluno está aprovado ou reprovado
	    public String situacao() {
	        double notaFinal = calcularNotaFinal();
	        if (ead) {
	         
	            return notaFinal >= 5 ? "Aprovado" : "Reprovado";
	        } else {
	            
	            return (notaFinal >= 5 && presencas >= 75) ? "Aprovado" : "Reprovado";
	        }
	    }
	   
	    	
	   //Imprimindo as informações 
	    public void imprimirInformacoes() {
	        double notaFinal = calcularNotaFinal();
	        System.out.println("Nome: " + nome);
	        System.out.println("RA: " + ra);
	        System.out.println("Nota Final: " + notaFinal);
	        System.out.println("Situação: " + situacao());
	    
	}
	    
}