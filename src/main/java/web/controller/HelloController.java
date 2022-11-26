package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.ServiceCar;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {
		List<String> messages = new ArrayList<>();
		messages.add("Hello!");
		messages.add("I'm Spring MVC application");
		messages.add("5.2.0 version by sep'19 ");
		model.addAttribute("messages", messages);
		return "index";
	}

	@GetMapping(value = "/cars")
	public String showCars(ModelMap model, @RequestParam(name = "count", defaultValue = "5") String count) {
		List<Car> cars = new ArrayList<>();
		cars.add(new Car(1, "aaa", 111));
		cars.add(new Car(2, "bbb", 222));
		cars.add(new Car(3, "ccc", 333));
		cars.add(new Car(4, "ddd", 444));
		cars.add(new Car(5, "eee", 555));

		if (Integer.parseInt(count) < 5) {
			model.addAttribute("cars", ServiceCar.getCars(cars, Integer.parseInt(count)));
		}
		else {
			model.addAttribute("cars", cars);
		}
		return "cars";
	}
	
}