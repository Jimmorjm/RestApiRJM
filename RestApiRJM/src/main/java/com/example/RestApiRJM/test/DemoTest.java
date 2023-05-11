package com.example.RestApiRJM.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.example.RestApiRJM.model.Perfil;
import com.example.RestApiRJM.model.Usuario;

public class DemoTest {

	public static void main(String[] args) {

//		List<Integer> listNumber = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).stream().map(number -> {
//			return number;
//		}).collect(Collectors.toList());
//
//		listNumber.forEach(number -> {
//			System.out.println(number);
//		});

		List<String> names = Arrays
				.asList("John", "John", "Mariam", "Alex", "Mohammado", "Mohammado", "Vincent", "Alex", "Alex").stream()
				.map(number -> {
					return number;
				}).collect(Collectors.toList());

//		 List<Integer> largo = names.stream()
//	     .map(name -> name.length() )
//	     .collect(Collectors.toList());

//		 largo.forEach(System.out::println);

//		 names.stream()
//		   .sorted(Comparator.naturalOrder())
//		   .forEach(System.out::println);

//		 names.stream()
//		   .sorted(Comparator.comparing(String::length))
//		   .forEach(System.out::println);

//		 names.stream()
//		   .sorted( Comparator
//		           .comparing(String::length)
//		           .thenComparing(Comparator.naturalOrder()) )
//		   .forEach(System.out::println);

//		 names.stream()
//		 .distinct()
//		 .forEach(System.out::println);

//		 names.stream()
//		   .limit(5)
//		   .forEach(System.out::println);

//		long cantidad = names.stream().limit(5).count();
//		System.out.println(cantidad);

//		 String reduce = names.stream().reduce("", String::concat);
//		 System.out.println(reduce);

//		 List<String> collect = names.stream()
//				   .filter(s -> s.contains("o"))
//				   .collect(Collectors.toList());
//		 
//		 collect.forEach(System.out::println);

		List<Usuario> personas = new ArrayList<>();
		Usuario per = new Usuario();
		per.setIdUsuario(1);
		per.setNombre("Rocardo");
		per.setApellido("Jimenez");
		per.setPerfil(new Perfil(1, "Admin"));
		personas.add(per);

		per = new Usuario();
		per.setIdUsuario(2);
		per.setNombre("Rocardo2");
		per.setApellido("Jimenez2");
		per.setPerfil(new Perfil(2, "Root"));
		personas.add(per);

		per = new Usuario();
		per.setIdUsuario(3);
		per.setNombre("Rocardo3");
		per.setApellido("Jimenez3");
		per.setPerfil(new Perfil(1, "Admin"));
		personas.add(per);

		per = new Usuario();
		per.setIdUsuario(4);
		per.setNombre("Rocardo4");
		per.setApellido("Jimenez4");
		per.setPerfil(new Perfil(1, "Admin"));
		personas.add(per);

		per = new Usuario();
		per.setIdUsuario(3);
		per.setNombre("Rocardo5");
		per.setApellido("Jimenez5");
		per.setPerfil(new Perfil(1, "Admin"));
		personas.add(per);
		
		personas.stream().filter(s -> s.getPerfil().getIdPerfil().equals(1))
				.collect(Collectors.toList()).forEach(u -> System.out.println(u.getNombre()));


//		Map<String, Long> counting = names.stream()
//				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//		System.out.println(counting);

	}

}
