package in.ashokit.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import in.ashokit.entity.Product;
import in.ashokit.repository.ProductRepo;

@Service
public class ProductService {
	@Autowired
	private ProductRepo productRepo;
	
	public void saveProduct()
	{
		Product p1=new Product(101,"Mouse",500.50);
		Product p2=new Product(102,"harddisk",5000.50);
		Product p3=new Product(103,"keyboard",1500.50);
		Product p4=new Product(104,"Monitor",1200.50);
		Product p5=new Product(105,"pcTable",5000.50);
		Product p6=new Product(106,"AC",1000.00);
		Product p7=new Product(107,"TV",65000.00);
		
		productRepo.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7));
	}
	
	public void getProducts()
	{
		List<Product> all = productRepo.findAll(Sort.by("price").descending());//if you want sort by price
		//List<Product> all = productRepo.findAll();
		all.forEach(getall->{
			System.out.println(getall);
		});
	}
	public void pagination()//used to retrieve the data from pages.deviding total nmr of records into multiple pages
	{
		int pageSize=3;
		int pageNum=0;//0 means page-1
		PageRequest of = PageRequest.of(pageNum, pageSize);
		Page<Product> page = productRepo.findAll(of);
		int totalPages=page.getTotalPages();
		System.out.println("Total Pages Requird::"+totalPages);
		List<Product> products = page.getContent();
		products.forEach(p->{
			System.out.println(p);
		});
	}
	public void qbeEx()//query by example used to create dynamic quiries as we want
	{
		Product entity=new Product();
		entity.setName("mouse");//dynamicquiry is created to get mouse object
		
		List<Product> products = productRepo.findAll(Example.of(entity));
		products.forEach(p->{
			System.out.println(p);
		});
	}

}
