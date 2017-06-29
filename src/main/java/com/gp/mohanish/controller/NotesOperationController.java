package com.gp.mohanish.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.gp.mohanish.service.INoteService;
import com.gp.mohanish.service.IUserService;

/**
 * @author mohanish
 *
 */

@RestController
public class NotesOperationController {
	
	@Autowired
	INoteService iNoteService;
	
	@Autowired
	IUserService iUserService;
	
}
