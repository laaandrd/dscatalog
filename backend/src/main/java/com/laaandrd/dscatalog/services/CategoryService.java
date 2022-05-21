package com.laaandrd.dscatalog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laaandrd.dscatalog.dto.CategoryDTO;
import com.laaandrd.dscatalog.entities.Category;
import com.laaandrd.dscatalog.repositories.CategoryRepository;
import com.laaandrd.dscatalog.services.exceptions.EntityNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	@Transactional(readOnly = true)
	public List<CategoryDTO> findAll(){
		List<Category> list = repository.findAll();
		return list.stream().map(x -> new CategoryDTO(x)).toList();
	}
	
	@Transactional(readOnly = true)
	public CategoryDTO findById(Long id){
		Category c = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity not found."));
		return new CategoryDTO(c);
	}
	
}
