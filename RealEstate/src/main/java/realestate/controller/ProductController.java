package realestate.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import realestate.dto.ProductDto;
import realestate.dto.response.ProductsByUserIdResponse;
import realestate.service.abstracts.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;

	
	@GetMapping(value = "/products")
	public ResponseEntity<List<ProductDto>> getAllProducts(){

		return ResponseEntity.ok().body(productService.findAll());
	}
	
	@GetMapping(value = "/products",params = "productId")
	public ResponseEntity<ProductDto> getPaymentById(@RequestParam("productId") Long producId){

		ProductDto productDto = productService.findById(producId);

		return ResponseEntity.ok().body(productService.findById(productDto.getId()));
	}
	
	@GetMapping(value="/products",params = "userId")
	public ProductsByUserIdResponse getByUserIdResponse(@RequestParam("userId") Long userId ) {
		return productService.getProductByUserId(userId);
	}
	
	@PostMapping(value = "/products")
	public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto){
		ProductDto product = productService.save(productDto);
		return new ResponseEntity<>(product,HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/products/{product}")
	public ResponseEntity<?> deleteUserById(@PathVariable Long productId) {
		productService.deleteById(productId);
		return new ResponseEntity<>("The Product " + productId + " has been deleted...",HttpStatus.OK);
	}
	
	
	
	
	
}
