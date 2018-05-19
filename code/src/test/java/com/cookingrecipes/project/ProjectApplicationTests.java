package com.cookingrecipes.project;

import com.cookingrecipes.project.dataAccess.entities.Admin;
import com.cookingrecipes.project.dataAccess.entities.Comment;
import com.cookingrecipes.project.dataAccess.entities.Recipe;
import com.cookingrecipes.project.dataAccess.entities.User;
import com.cookingrecipes.project.dataAccess.repositories.RecipeRepository;
import com.cookingrecipes.project.dataAccess.repositories.UserRepository;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.DisabledIf;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectApplicationTests {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	RecipeRepository recipeRepository;
	@Test
	public void contextLoads() {
	}



	@Disabled
	@Test
	public void testGetByUsernameAndPassword()
	{
		System.out.println(userRepository.getByUsernameAndPassword("cocRaul","coco2000").toString());
		//System.out.println(userRepository.findById(1).toString());
	}

	@Disabled
	@Test
	public void testComments()
	{
		Optional<Recipe> r= Optional.ofNullable(recipeRepository.findByTitle("Vegan Three-Bean Chili With Spring Pesto"));
		Recipe rr=new Recipe();
		if(r.isPresent())
			rr=r.get();
		List<Comment> c=rr.getComments();

		for(Comment co:c)
		{
			System.out.print(co.getId());
		}
		System.out.print(rr.getTitle()+rr.getId());

	}

	@Test
	public void testFind()
	{
		System.out.println(userRepository.getByName("Andreea Lazaroiu").toString());
	}

}
