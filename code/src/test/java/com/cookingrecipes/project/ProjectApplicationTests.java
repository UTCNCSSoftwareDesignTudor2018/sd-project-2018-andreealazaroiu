package com.cookingrecipes.project;

import com.cookingrecipes.project.dataAccess.entities.Admin;
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

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectApplicationTests {
	@Autowired
	private UserRepository userRepository;
	@Test
	public void contextLoads() {
	}

	@Disabled
	@Test
	public void testInsert()
	{
		userRepository.save(new User("Cocias Raul","cocRaul","coco2000",null));
	}

	@Disabled
	@Test
	public void testGetByUsernameAndPassword()
	{
		System.out.println(userRepository.getByUsernameAndPassword("cocRaul","coco2000").toString());
		//System.out.println(userRepository.findById(1).toString());
	}

}
