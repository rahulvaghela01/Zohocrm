package com.zoho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zoho.entities.Contacts;
import com.zoho.services.ContactService;

@Controller
public class ContactsController {
	@Autowired
	ContactService contactService;
	
	@RequestMapping("/listcontacts")
	public String listContacts(Model model) {
		List<Contacts> contacts = contactService.getAllContacts();
		model.addAttribute("contacts",contacts);
		return "list_contact";
	}
	@RequestMapping("/contactInfo")
	public String contactInfo(@RequestParam("id")long id, Model model) {
		Contacts contact = contactService.findContactById(id);
		model.addAttribute("contact", contact);
		return "contact_info";
	}
}
