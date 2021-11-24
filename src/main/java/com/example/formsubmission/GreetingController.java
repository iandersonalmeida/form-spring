package com.example.formsubmission;

import org.springframework.stereotype.Controller; //No pacote stereotype está contido as funções dos tipos e métodos na
												  //na arquitetura geral do spring;	


import org.springframework.ui.Model;//Uma interface que define atributos de modelo. Adiciona atributos ao modelo;


import org.springframework.web.bind.annotation.GetMapping; //No pacote web.bind.annotation se encontram anotações.
import org.springframework.web.bind.annotation.ModelAttribute;
//Estas anotações vinculam requests a controladores e
														   //metódos manipuladores. Também vinculam parâmetros de solicitação
														   //a argumentos de método;	
import org.springframework.web.bind.annotation.PostMapping;

@Controller //O spring vai entender esta classe como um controller, ou em geral, um componente;
public class GreetingController {
	
	@GetMapping("/")//Esta anotação expressa HTTP GET requests em métodos manipuladores específicos;
	public String greetingForm(Model model) {
		model.addAttribute("greeting", new Greeting()); //Por que uma variável de interface pode chamar um método??
														//Se a variável do tipo interface é uma variável local, eu não
														// posso chamar o método (pre)definido na interface sem inicializar
														//a variável com uma instância de uma classe que implmenta a interface;	
														//Mas a variável pode ser declarada como parâmetro de um método
														//ou global, e com ela chamar o método pertecente a própria interface;
		
		return "greeting";
	}//O método greetingForm é mapeado(associado com) para GET, usando GetMapping, (/greeting);
	//A função deste método é adicionar atributos ao modelo (Model);
	
	
	//Esta anotação permite que HTTP POST requests sejam mapeadas a em métodos manipuladores específicos;
	@PostMapping("/greeting")
	public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
		model.addAttribute("greeting", greeting);
		
		return "result";
		
	}//A anotação @ModelAttribute permite vincular um parâmetro de um método ou um retorno ao atributo de modelo nomeado;
	

}
