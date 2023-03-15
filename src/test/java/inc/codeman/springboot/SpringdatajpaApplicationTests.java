package inc.codeman.springboot;

import java.util.List;
import java.util.Optional;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import inc.codeman.springboot.data.entities.Product;
import inc.codeman.springboot.data.repo.ProductRepository;

@SpringBootTest
class SpringdatajpaApplicationTests {

	@Autowired
	ApplicationContext context;
	@Test
	void saveProduct() {
		ProductRepository productRepo = context.getBean(ProductRepository.class);
		Product product = new Product();
		product.setId(60L);
		product.setName("Sir Vaathi");
		product.setDescription("Nice Movie Kada?");
		product.setPrice(90.0);
		productRepo.save(product);	
		Optional<Product> optionalProduct = productRepo.findById(60L);
		if(optionalProduct.isPresent()) {
			Product res = optionalProduct.get();
			System.out.println(res);
			res.setDescription("Worst Movie");
			res.setPrice(120.0);
			productRepo.save(res);
		}
		productRepo.findAll().forEach(p->{System.out.println(p.getName());});
		System.out.println("No. of Records present: "+productRepo.count());
		List<Product> resList = productRepo.findByName("Sir Vaathi");
		resList.forEach(l->{System.out.println(l);});
		List<Product> resList1 = productRepo.findByNameAndId("Sir Vaathi",50L);
		resList1.forEach(l->{System.out.println(l.getDescription());});
	}

}
