package sportsApp.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sportsApp.data.SportsRepository;
import sportsApp.model.Registration;

@Controller
public class MainController {

	@Autowired //ani kalau interface vid 5
	SportsRepository spRepo;
	int curentParticipantId;
	
	@RequestMapping(value="/")
	public String employees(ModelMap modelMap) {
		//Adding emplyee data to employee table
		Registration registrator = new Registration(13, "Red", "01-123251", "2KM Marathon", "akmal@gmail.com");
		spRepo.save(registrator);
//		Employee employee2 = new Employee(15, "01-123456", "Axerz", 1399, Calendar.getInstance());
//		empRepo.save(employee2);
		
		//Retrieve employee data from emplyee table
//		Employee employee = empRepo.findById(13).get();
//		System.out.println(employee.getId() + " " + employee.getName() + " " + employee.getIcNumber());
		
//		Iterable<Employee> employees = empRepo.findAll();
//		for(Employee e : employees) {
//			System.out.println(e.getId() + " " + e.getName() + " " + e.getIcNumber());
//		}
//		
//		Iterable<Employee> employeeSpecific = empRepo.findAllById(Arrays.asList(13, 15));
//		for(Employee es : employeeSpecific) {
//			System.out.println(es.getId() + " " + es.getName() + " " + es.getIcNumber());
//		}
		
		// Edit employee data fromemployee table
//		Employee employee2 = empRepo.findById(13).get();
//		employee2.setName("Evade");
//		empRepo.save(employee2);
		
		//delete employee data from employee table
//		Employee employee2 = empRepo.findById(13).get();
//		empRepo.delete(employee2);
//		//or
//		empRepo.deleteById(13);
		
		//ani retrieve data ke html vid 7
		Iterable<Registration> participants = spRepo.findAll();
		modelMap.put("registration", participants);
		System.out.println(participants);
		return "Registration";
	}
	
	@RequestMapping(value="/add 2km Participants")
	public String showAddEmployeePage() {
		return "2 Km Marathon";
	}
	
	@RequestMapping(value="/add 5km Participants")
	public String showAddEmployeePage2() {
		return "5 KM Marathon";
	}
	
	@RequestMapping(value="/add 2km Participants/add")
	public String addParticipants(
			@RequestParam(required=true) int participants_id,
			@RequestParam(required=true) String full_name,
			@RequestParam(required=true) String ic_number,	
			@RequestParam(required=true) String sports,
			@RequestParam(required=true) String email
			) throws ParseException {
		Registration register = new Registration (participants_id, full_name, ic_number, sports, email);
		spRepo.save(register);
		return "redirect:/";
	}
	
	@RequestMapping(value="/editParticipants/{ParticipantsId}")
	public String showEditParticipantsPage(@PathVariable int participants_id, ModelMap modelMap) {
		Registration register = spRepo.findById(participants_id).get();
		modelMap.put("registration", register);
		curentParticipantId = participants_id;
		return "Edit Page";
	}
	
	@RequestMapping(value="/editParticipants/{ParticipantsId}/edit")
	public String editEmployee(
			@RequestParam(required=true) String full_name,
			@RequestParam(required=true) String ic_number,
			@RequestParam(required=true) String sports,
			@RequestParam(required=true) String email,
			@PathVariable int participantsId
			) throws ParseException {
		if(curentParticipantId == participantsId) {
			Registration employee = spRepo.findById(participantsId).get();
			employee.setName(full_name);
			employee.setIcNumber(ic_number);
			employee.setName(sports);
			employee.setName(email);
			spRepo.save(employee);
		}
		return "redirect:/";
	}
	
	@RequestMapping(value="/deleteParticipants/{ParticipantsId}")
	public String deleteParticipants(@PathVariable int participantsId) {
		spRepo.deleteById(participantsId);
		return "redirect:/";
	}
}
