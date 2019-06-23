import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class TestaPerformance {

	public static void main(String[] args) {

		Collection<Integer> arrayList = new ArrayList<Integer>();
		Collection<Integer> hashSet = new HashSet<>();

		System.out.println("Performance do ArrayList: Add e Contains");
		Duration tempoDeExecucao = performanceAddContains(arrayList);
		System.out.println("Tempo gasto: " + tempoDeExecucao.getSeconds() + " segundos.");

		System.out.println();

		System.out.println("Performance do HashSet: Add e Contains");
		tempoDeExecucao = performanceAddContains(hashSet);
		System.out.println("Tempo gasto: " + tempoDeExecucao.toMillis()+ " milissegundos.");

	}

	private static Duration performanceAddContains(Collection<Integer> numeros) {
		Instant inicio = Instant.now();

		for (int i = 1; i <= 200000; i++) {
			numeros.add(i);
		}

		for (Integer numero : numeros) {
			numeros.contains(numero);
		}

		Instant fim = Instant.now();

		Duration tempoDeExecucao = Duration.between(inicio, fim);

		return tempoDeExecucao;

	}

}