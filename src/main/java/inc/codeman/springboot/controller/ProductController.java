package inc.codeman.springboot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import inc.codeman.springboot.data.entities.Product;
import inc.codeman.springboot.data.repo.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	ProductRepository repository;

	@GetMapping
	public Iterable<Product> getProducts() {
		return repository.findAll();
	}

	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		return repository.save(product);
	}

	@PutMapping
	public Product updateProduct(@RequestBody Product product) {
		return repository.save(product);
	}

	@GetMapping("/{id}")
	public Product getProduct(@PathVariable("id") Long id) {
		Optional<Product> result = repository.findById(id);
		return result.get();
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable("id") Long id) {
		repository.deleteById(id);
	}

}
