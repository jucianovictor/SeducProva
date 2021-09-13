package br.gov.ce.seduc.prova.questoes.tres;

import org.junit.jupiter.api.Test;

public class QuestaoTresD {
	@Test
	public void runnableLambda() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello world!");
			}
		}).start();

		new Thread(() -> System.out.println("Hello world!")).start();
	}
}
