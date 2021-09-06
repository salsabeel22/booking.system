package com.booking.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.booking.models.Customer;
import com.booking.models.Employee;
import com.booking.models.Food;
import com.booking.models.Reservation;

import com.booking.service.CustomerService;
import com.booking.service.EmployeeService;
import com.booking.service.FoodService;
import com.booking.service.ReservationService;


@Controller
public class HomeControllers {
	@Autowired
	EmployeeService employeeservice ;

	@Autowired
	FoodService foodservice ;
		@Autowired
		CustomerService customerservice ;

		@Autowired
		private ReservationService reservationservice ;
		
		
	@GetMapping("/home")
	public String home(Model model) {
		List<Customer> s =  customerservice.getAllCustomer();
		model.addAttribute("customer", s);
		return "home";
	}
	
	@GetMapping("/menu")
	public String menu() {
	
		return "foodmenu";
	}
	
	@GetMapping("/food order")
	public String food(Model model) {
		List<Food> s =  foodservice.getAllFood();
		model.addAttribute("food", s);
		return "food";
	}
	@GetMapping("/reservation")
	public String reservation(Model model) {
		List<Reservation> s =  reservationservice.getAllReservation();
		model.addAttribute("reservation", s);
		return "reservation";
	}
	
	@GetMapping("/profile")
	public String home () {
		return "profile";
	}

	@GetMapping("/")
	public String Home () {
		return "/profile";
	}
	
	
	@GetMapping("/delete-reservation/{id}")
	public String deletereservation(@PathVariable Integer id, Model model) {
		reservationservice.deletereservation(id);
		List<Reservation> s =  reservationservice.getAllReservation();
		model.addAttribute("reservation", s);
		return "reservation";
	}
	

	@PostMapping("/customer-with-details/{customerId}")
	public String getCustomerWithDetails(@PathVariable Integer customerId,Model model) {
		Customer s = customerservice.getCustomerById(customerId);
		model.addAttribute("customer", s);
			return "customerWithDetails";
	}
	
	
	

	@GetMapping("/delete-orderfood-for-customer/{foodid}/customers/{customerid}")
	public String deletefood(@PathVariable Integer foodid ,@PathVariable Integer customerid ,Model model)
			
	{
		
		customerservice.deleteFoodFromCustomer(foodid,customerid);
		Customer s = customerservice.getCustomerById(customerid);
		model.addAttribute("customer", s);
		return "customerWithDetails";
	
	}
	@GetMapping("/delete-reservation-for-customer/{reservationid}/customers/{customerid}")
	public String deletereservation(@PathVariable Integer reservationid ,@PathVariable Integer customerid ,Model model)
			
	{
		
		customerservice.deleteReservationFromCustomer(reservationid,customerid);
		
		return "deletedReservationfromcustomer";
	
	}
	
	@GetMapping("/subscribe/{customerId}")
	public String subscribecustomer(Model model,@PathVariable Integer customerId) {
		List<Food> foods = foodservice.getAllFood();

		model.addAttribute("customerId",customerId);
		model.addAttribute("foods",foods);
		return "subscribe";
	}

	/*@PostMapping("/subscribe-customer_order/{customerid}")
	public String subscribeFood(Food food) {

		System.out.print(food);
		return "subscribe";}*/


	
	@PostMapping(value="/subscribe-customer_order/{customerId}") 
	public String addFoodToCustomer(@PathVariable Integer customerId ,Food food ,Model model) {
		 customerservice.addFoodToCustomer(customerId, food.getId() );
		 Customer s = customerservice.getCustomerById(customerId);
			model.addAttribute("customer", s);
	return "customerWithDetails";
			}		


/*	@PostMapping("/update-student/{id}")
	public String updateStudent(@PathVariable Integer id,Student student) {
		studentService.updateStudent(id,student);
		return "studentUpdateSuccessful";
	}*/
	@PostMapping("/edit-reservation/{id}")
	public String editReservation(Model model,@PathVariable Integer id) {
		Reservation reservation= reservationservice.getReservationById(id);
		model.addAttribute("reservation",reservation);
		
		return "editreservation";
	}
	
	@PostMapping("/update-reservation/{id}")
	public String updatereservation(@PathVariable Integer id,Reservation reservation,Model model) {
		reservationservice.updatereservation(id,reservation);
		List<Reservation> s =  reservationservice.getAllReservation();
		model.addAttribute("reservation", s);
		return "reservation";
	}


	@PostMapping("/reservation/{customerId}")
	public String createreservation(@PathVariable Integer customerId,Model model) {
		Reservation r = new Reservation();
		Customer s = customerservice.getCustomerById(customerId);
		model.addAttribute("customer", s);
		model.addAttribute("reservation", r);
			return "reservationSignup";
	}

	
	@PostMapping("/create-reservation/{customerId}")
	public String createreservationResponse(@PathVariable Integer customerId,Reservation reservation,Model model) {
		reservationservice.creatReservationforCustomer(reservation,customerId);
		
		Customer s = customerservice.getCustomerById(customerId);
		model.addAttribute("customer", s);
		return "customerWithDetails";
	}
	
	@GetMapping("/employee")
	public String employee(Model model) {
		List<Employee> s =  employeeservice.getAllEmployee();
		model.addAttribute("employee", s);
		return "employee";
	}
	
	@GetMapping("/delete-employee/{id}")
	public String deleteemployee(@PathVariable Integer id,Model model) {
		employeeservice.deletEmployee(id);
		List<Employee> s =  employeeservice.getAllEmployee();
		model.addAttribute("employee", s);
	return "employee";
	}
	
	@PostMapping("/edit-employee/{id}")
	public String editemployee(Model model,@PathVariable Integer id) {
		Employee employee= employeeservice.getEmployeeById(id);
		model.addAttribute("employee",employee);
		
		return "editEmployee";
	}
	
	@PostMapping("/update-employee/{id}")
	public String updateemployee(@PathVariable Integer id,Employee employee,Model model) {
		employeeservice.updateEmployee(id,employee);
		List<Employee> s =  employeeservice.getAllEmployee();
		model.addAttribute("employee", s);
		return "employee";
	}
	
	
	@PostMapping("/create")
	public String createEmployee(Model model) {
		Employee s = new Employee();
		model.addAttribute("employee", s);
			return "employeeSignup";
	}
	
	
	@PostMapping(value="/create_employee")
	public String creatEmployee( Employee employee,Model model){	
			
	employeeservice.creatEmployee(employee);//save new obj in db (new obj in class employee)
	List<Employee> s =  employeeservice.getAllEmployee();
	model.addAttribute("employee", s);
	return "employee";
			}
	
	
	@PostMapping("/employee-with-details/{employeeId}")
	public String getemployeeWithDetails(@PathVariable Integer employeeId,Model model) {
		Employee s = employeeservice.getEmployeeById(employeeId);
		model.addAttribute("employee", s);
			return "EmployeeWithDetails";
	}

	
	@GetMapping("/delete-customer/{id}")
	public String deletecustomer(@PathVariable Integer id ,Model model) {
		customerservice.deletCustomer(id);
		List<Customer> s =  customerservice.getAllCustomer();
		model.addAttribute("customer", s);
		return "home";
	}
	
	@PostMapping("/customer/{employeeId}")
	public String createcustomer(@PathVariable Integer employeeId,Model model) {
		Customer r = new Customer();
		Employee s = employeeservice.getEmployeeById(employeeId);
		model.addAttribute("employee", s);
		model.addAttribute("customer", r);
			return "customerSignup";
	}
	
	@PostMapping("/create-customer/{employeeId}")
	public String createcustomerResponse(@PathVariable Integer employeeId,Customer customer,Model model) {
		customerservice.creatCustomerforEmployee(customer,employeeId);
		Employee s = employeeservice.getEmployeeById(employeeId);
		model.addAttribute("employee", s);
		return "EmployeeWithDetails";
	}

	@PostMapping("/edit-customer/{id}")
	public String editecustomer(Model model,@PathVariable Integer id) {
		Customer customer= customerservice.getCustomerById(id);
		model.addAttribute("customer",customer);
		
		return "editCustomer";
	}
	@PostMapping("/update-customer/{id}")
	public String updatecustomer(@PathVariable Integer id,Customer customer,Model model) {
		customerservice.updateCustomer(id,customer);
		List<Customer> s =  customerservice.getAllCustomer();
		model.addAttribute("customer", s);
		return "home";
	}
	@GetMapping("/delete-food/{id}")
	public String deletefood(@PathVariable Integer id,Model model) {
		foodservice.deletFood(id);
		List<Food> s =  foodservice.getAllFood();
		model.addAttribute("food", s);
		return "food";
	}
/*	@PostMapping("/create_foodInMenu/{customerId}")
	public String createfood(@PathVariable Integer customerId ,Model model) {
	Food r = new Food();
		Customer s = customerservice.getCustomerById(customerId);
		model.addAttribute("customer", s);
		model.addAttribute("food", r);
	
			return "FoodInMenu";
	}
	
	@PostMapping(value="/create_foods/{customerId}")
	public String createfoodResponse(@PathVariable Integer customerId,Food food) {
			
		customerservice.addFoodToCustomer(customerId,food.getId());	
		return "createFood";
			}*/

	@PostMapping("/add_food")
	public String createFood(Model model) {
		Food s = new Food();
		model.addAttribute("food", s);
			return "FoodInMenu";
	}
	
	
	@PostMapping(value="/create_food")
	public String create( Food food, Model model){	
			
	foodservice.creatFood(food);
	List<Food> s =  foodservice.getAllFood();
	model.addAttribute("food", s);
	return "food";
			}
	
	@PostMapping("/edit-food/{id}")
	public String editFood(Model model,@PathVariable Integer id) {
		Food food= foodservice.getFoodById(id);
		model.addAttribute("food",food);
		
		return "editFood";
	}
	
	@PostMapping("/update-food/{id}")
	public String updatefood(@PathVariable Integer id,Food food,Model model) {
		foodservice.updatefood(id,food);
		List<Food> s =  foodservice.getAllFood();
		model.addAttribute("food", s);
		return "food";
	}

	
	
	
}		
		
		
		
		
		
		

	

