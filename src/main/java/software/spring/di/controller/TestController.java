package software.spring.di.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import software.spring.di.service.TestService;

@Controller
public class TestController {
	@Autowired
	private TestService testService;
}
