package com.example.demo.controller;

import java.util.List;

import com.example.demo.Repoitories.LineItemRepository;
import com.example.demo.entites.LineItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LineItemController {
	
	@Autowired
	LineItemRepository lineitemRepository;
	
	@GetMapping("/lineitems")
	public List<LineItem> getAll(){
		List<LineItem> lstItemls = lineitemRepository.findAll();
		return lstItemls;
	}
	
	@PostMapping("/lineitem")
	public LineItem create(@RequestBody LineItem lineItem) {
		LineItem line = lineitemRepository.save(lineItem);
		return line;
	}
	
	@PutMapping("/lineitem/{id}")
	public ResponseEntity<LineItem> update(@PathVariable(name = "id", required = false)Integer id, LineItem lineItem ){
		lineItem.setLineItemId(id);
		lineitemRepository.save(lineItem); 
		return ResponseEntity.ok(lineItem);
	}
	
	@DeleteMapping("lineitem/{id}")
	public ResponseEntity<Void> delet(@PathVariable(name = "id") Integer id, LineItem lineItem ){
		lineItem.setLineItemId(id);
		lineitemRepository.delete(lineItem);
		return ResponseEntity.ok().build();
	}
	
}
