package com.example.springapp.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.QuestionWrapper;
import com.example.springapp.model.Quiz;
import com.example.springapp.model.Response;
import com.example.springapp.service.QuizService;

@RestController
@RequestMapping
public class QuizController {

	@Autowired
	QuizService quizService;
	
	@PostMapping("create")
	public ResponseEntity<Quiz> createQuiz(@RequestParam String category, @RequestParam int num, @RequestParam String title)
	{
		return quizService.createQuiz(category, num, title);
	}
	

	@GetMapping("getQuiz/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQues(@PathVariable int id)
	{
		return quizService.getQuiz(id);
	}

	@GetMapping("getallQuiz")
	public List<Quiz> getall(){
		return quizService.getAllQuizzes();
	}
	@PostMapping("submit/{id}")
	public ResponseEntity<Integer> calculateRes(@PathVariable int id,@RequestBody List<Response> responses  )
	{
		return quizService.calculateRes(id, responses);
	}
}
