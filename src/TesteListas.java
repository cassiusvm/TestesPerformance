import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TesteListas {

	public static void main(String[] args) {

		System.out.println("**** ArrayList vs LinkedList ***");

		List<Integer> numerosArrayList = new ArrayList<>();
		List<Integer> numerosLinkedList = new LinkedList<>();
		int quantidadeElementos = 10000000;

		Duration tempoArrayList = insereElementosNo(numerosArrayList, quantidadeElementos);
		Duration tempoLinkedList = insereElementosNo(numerosLinkedList, quantidadeElementos);

		System.out.println("Inserção na ArrayList demorou " + tempoArrayList.toMillis() + " milisegundos");
		System.out.println("Inserção na LinkedList demorou " + tempoLinkedList.toMillis() + " milisegundos");

		tempoArrayList = removePrimeirosElementos(numerosArrayList);
		tempoLinkedList = removePrimeirosElementos(numerosLinkedList);

		System.out.println("Remoção da ArrayList demorou " + tempoArrayList.getSeconds() + " segundos");
		System.out.println("Remoção da LinkedList demorou " + tempoLinkedList.getNano() + " nanosegundos");
	}

	/*
	 * removendo 100 elementos sempre na primeira posição
	 */
	private static Duration removePrimeirosElementos(List<Integer> numeros) {
		Instant inicio = Instant.now();

		for (int i = 0; i < 1000; i++) {
			numeros.remove(0); // removendo sempre o primeiro elemento
		}

		return Duration.between(inicio, Instant.now());
	}

	private static Duration insereElementosNo(List<Integer> numeros, int quantidade) {
		Instant inicio = Instant.now();

		for (int i = 0; i < quantidade; i++) {
			numeros.add(i);
		}

		return Duration.between(inicio, Instant.now());
	}

}