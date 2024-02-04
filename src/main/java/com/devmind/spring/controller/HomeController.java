package com.devmind.spring.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devmind.spring.model.User;

@Controller
public class HomeController {

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	/*
	-  controllerul e intermediar intre model si view
	- obiectul model "Model" e folosit pt a transmite date (dtaa formatata, usernameul
	de la controller la view
	- viewurile asociate cu URLurile "/" si "user" sunt rezolvate pe baza numelor de view
	returnate ("home" si "user") care sunt asociate cu JSPurile cu acelasi nume
	 - nota: daca tipul de return este String, atunci Spring MVC il interpreteza ca
	 logical view name pentru ca avem configurarea cu InternalResourceViewResolver
	 facuta in spring-servlet.xml
	 - tipurile returnate mai pot fi "ModelAndView" (paseaza si model si view),
	 void (Spring MVC presupune ca numele viewului si data model-ul sunt deja setate in
	 obiectul Model, mai pot fi JSON, XML, List, Maps sau obiecte custom

	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		System.out.println("Home Page Requested, locale = " + locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	/*
	Alternativa folosind serviciu:
	TimeService timeService = new TimeService();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		System.out.println("Home Page Requested, locale = " + locale);
		model.addAttribute("serverTime", timeService.getTimeAndDate(locale));

		return "home";
	}

	 */
	/*
	Explicatii:
	 -  metoda se ocupa de requesturi GET la rootul URL "/"
	 -  primeste un obiect "Locale" si un obiect "Model" ca si parametri
	 - logheaza un mesaj care indica ca a fost dat request la homepage
	 - sustrage data curenta si o formateaza bazat pe locale-ul care e provided
	 - adauga data firmatata la model attribute numit "serverTime" ( care observam
	 ca apare in bodyul de la home.jsp
	 - returneaza numele de view "Home"
	 */

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String user(@Validated User user, Model model) {
		System.out.println("User Page Requested");
		model.addAttribute("userName", user.getUserName());
		model.addAttribute("email", user.getEmail()); // Add email to the model
		model.addAttribute("phoneNumber", user.getPhoneNumber()); // Add phone number to the model
		model.addAttribute("birthDate", user.getBirthDate()); // Add birthdate to the model
		return "user";
	}
	/*
	- la fel, userName apare si in user.jsp in body
	 */

}
