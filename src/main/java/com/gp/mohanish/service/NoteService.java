package com.gp.mohanish.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gp.mohanish.dao.INoteDao;
import com.gp.mohanish.model.Note;

/**
 * @author mohanish
 *
 */
@Service("iNoteService")
public class NoteService implements INoteService{

	@Autowired
	INoteDao iNoteDao;
	
	public void addNewNote(Note note){
		iNoteDao.addNewNote(note);
	}
	
	public List<Note> getAllNotes(Long userId) {
		return iNoteDao.getAllNotes(userId);
	}
	
	public boolean removeNoteById(Long noteId, Long userId){
		return iNoteDao.removeNoteById(noteId, userId);
	}
	
	public boolean modifyNote(Note note, Long userId){
		return iNoteDao.modifyNote(note,userId);
	}
}
