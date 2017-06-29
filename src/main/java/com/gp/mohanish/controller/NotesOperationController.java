package com.gp.mohanish.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gp.mohanish.helper.AuthHelper;
import com.gp.mohanish.model.Note;
import com.gp.mohanish.model.User;
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
	
	@RequestMapping(value = "/addNewNote", method = RequestMethod.POST, consumes = {"application/json"})
	public ResponseEntity<String> addNewNote(@RequestHeader("Authorization") String credentials,@RequestBody Note note) {
		User user = null;		
	    String[] userObj = AuthHelper.getUserDetailsFromAuthHelper(credentials);
	    if(userObj != null && userObj.length > 0 ){
	    	user = iUserService.getUser(userObj);
	    }
	    if(user != null && note != null ){
	    	note.setUser(user);
	    	if(note.getDescription().length() > 1000){
	    		return new ResponseEntity<String>("Max allowed description length is 1000", HttpStatus.BAD_REQUEST);
	    	}else if(note.getTitle().length() > 50){
	    		return new ResponseEntity<String>("Max allowed title length is 50", HttpStatus.BAD_REQUEST);
	    	}
	    	iNoteService.addNewNote(note);
	    	return new ResponseEntity<String>("Note successfully added", HttpStatus.OK);
	    }
	    return new ResponseEntity<String>("Invalid information provided", HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "/getAllNotesByUser", method = RequestMethod.GET)
	public ResponseEntity<List<Note>> getAllNotesByUser(@RequestHeader("Authorization") String credentials) {
		User user = null;		
	    String[] userObj = AuthHelper.getUserDetailsFromAuthHelper(credentials);
	    if(userObj != null && userObj.length > 0 ){
	    	user = iUserService.getUser(userObj);
	    }
	    List<Note> notes = null;
	    if(user !=  null){
	    	notes = iNoteService.getAllNotes(user.getId());
	    	return new ResponseEntity<List<Note>>(notes, HttpStatus.OK);	  
	    }
	    return new ResponseEntity<List<Note>>(HttpStatus.NO_CONTENT);
	}
	
}
