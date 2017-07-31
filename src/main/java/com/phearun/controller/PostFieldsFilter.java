package com.phearun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.phearun.service.PostService;

import ch.mfrey.jackson.antpathfilter.Jackson2Helper;

@RestController
@RequestMapping(value = "/posts")
public class PostFieldsFilter {

	@Autowired
	private Jackson2Helper jackson2Helper;

	@Autowired
	private PostService postService;

	@RequestMapping
	public String findAllPosts(@RequestParam(value = "fields", required = false, defaultValue = "**") String... fields) {
		return jackson2Helper.writeFiltered(postService.findAll(), fields);
	}

	/*@RequestMapping
	@ResponseBody
	public String getSomeObject(FieldFilter fields) {
		return jackson2Helper.writeFiltered(postService.findAll(), fields.getFields());
	}
	 */
}
