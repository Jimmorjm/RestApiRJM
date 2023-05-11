package com.example.RestApiRJM.test;

import java.util.ArrayList;
import java.util.List;

import com.example.RestApiRJM.model.Perfil;
import com.example.RestApiRJM.model.Usuario;

public class DemoVo {

	static int numeroHilo = 1;
	
	
//	public static void main (String[] args){
//        Runtime rt = Runtime.getRuntime();
//        System.out.println("Memoria Total de la JVM: " +
//        rt.totalMemory()); System.out.println("Memoria Antes: " + rt.freeMemory()); 
//        Date d = null; 
//        for (int i = 0; i < 10000; i++){
//            d = new Date(); 
//            d = null; 
//        } 
//        System.out.println("Memoria Despues: " + rt.freeMemory()); 
//        rt.gc();
//        System.out.println("Despues del GC: " + rt.freeMemory()); 
//    } 
	

	public static void main(String[] args) {
		System.out.println("Hilo principal iniciando.");

		List<Usuario> lst = new ArrayList<>();
		Usuario usu = null;
		for (int i = 0; i < 27; i++) {
			usu = new Usuario();
			usu.setNombre("Usuario #" + i);
			usu.setApellido("Apellido #" + i);
			usu.setPerfil(new Perfil());
			usu.getPerfil().setIdPerfil(1);
			usu.getPerfil().setNombre("Admin");
			lst.add(usu);
		}
		List<List<Usuario>> lstSplit = chopIntoParts(lst, 4);
		System.out.println("Lista dividida en " + lstSplit.size());

		long initialTime = System.currentTimeMillis();

		lstSplit.forEach((list) -> {
			HilosVo hilo = new HilosVo(list, "Hilo " + numeroHilo, initialTime);
			hilo.start();
			numeroHilo++;
		});

		System.out.println("Hilo principal finalizado");
	}

	public static <T> List<List<T>> chopIntoParts(final List<T> ls, final int iParts) {
		final List<List<T>> lsParts = new ArrayList<List<T>>();
		final int iChunkSize = ls.size() / iParts;
		int iLeftOver = ls.size() % iParts;
		int iTake = iChunkSize;

		for (int i = 0, iT = ls.size(); i < iT; i += iTake) {
			if (iLeftOver > 0) {
				iLeftOver--;

				iTake = iChunkSize + 1;
			} else {
				iTake = iChunkSize;
			}

			lsParts.add(new ArrayList<T>(ls.subList(i, Math.min(iT, i + iTake))));
		}

		return lsParts;
	}
	
}
