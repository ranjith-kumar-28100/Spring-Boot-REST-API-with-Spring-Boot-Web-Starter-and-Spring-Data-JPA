package inc.codeman.springboot.data.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import inc.codeman.springboot.data.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
List<Product> findByName(String name);
List<Product> findByNameAndId(String name, Long id);
}
