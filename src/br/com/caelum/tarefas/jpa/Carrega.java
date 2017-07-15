package br.com.caelum.tarefas.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.tarefas.modelo.Tarefa;

public class Carrega {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager manager = factory.createEntityManager();
		
		//Tarefa encontrada = manager.find(Tarefa.class, 1L);
		//System.out.println(encontrada.getDescricao());
		//encontrada.setDescricao("nova tarefa teste");
		
		Tarefa t2 = new Tarefa();
		t2.setId(1L);
		t2.setDescricao("hibernate teste");
		
		manager.getTransaction().begin();
		t2 = manager.merge(t2);
		t2.setDescricao("brincadeira o hibernate é top");
		manager.getTransaction().commit();
		manager.close();
		
		factory.close();
		
		
	}
}
