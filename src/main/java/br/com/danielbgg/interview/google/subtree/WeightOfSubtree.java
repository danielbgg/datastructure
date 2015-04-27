package br.com.danielbgg.interview.google.subtree;

import java.util.ArrayList;
import java.util.List;

/*
 * http://www.careercup.com/question?id=5648527329853440
 */
public class WeightOfSubtree {

	public static void main(String[] args) {
		List<Node> l = new ArrayList<Node>();
		l.add(new Node(10, 30, 1));
		l.add(new Node(30, 0, 10));
		l.add(new Node(20, 30, 2));
		l.add(new Node(40, 20, 5));

		WeightOfSubtree eg = new WeightOfSubtree();
		System.out.println(eg.getSubTreeWeight(l, 10));
		System.out.println(eg.getSubTreeWeight(l, 30));
		System.out.println(eg.getSubTreeWeight(l, 20));
		System.out.println(eg.getSubTreeWeight(l, 40));
		// 10 -> 1
		// 30 -> 18
		// 20 -> 7
		// 40 -> 5
	}

	public int getSubTreeWeight(List<Node> lst, int id) {
		// programacao defensiva

		// encontrar na lista o meu objeto id
		// sumarizador do peso = id.getWeight();
		int totalWeight = 0;

		Node target = null;
		for (int i = 0; i < lst.size(); i++) {
			Node n = lst.get(i);
			if (n.getId() == id) {
				// no encontrado
				// sair do loop
				target = n;
			}
		}

		// programacao defensiva
		totalWeight = target.getWeight();

		// encontrar na lista os objetos que sao filhos do meu objeto id
		for (int i = 0; i < lst.size(); i++) {
			Node n = lst.get(i);
			if (n.getParent_id() == target.getId()) {
				totalWeight = totalWeight + getSubTreeWeight(lst, n.getId());
			}
		}
		// sumarizador do peso = sumarizador do peso + id.getWeight() //de cada
		// filho encontrado

		// encontrar na lista os objetos que sao filhos dos filhos do meu objeto
		// id
		// sumarizador do peso = sumarizador do peso + id.getWeight() //de cada
		// filho do filho encontrado

		return totalWeight;
	}
}
