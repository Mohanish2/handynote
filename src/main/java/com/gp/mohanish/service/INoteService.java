package com.gp.mohanish.service;

import java.util.List;

import com.gp.mohanish.model.Note;

/**
 * @author mohanish
 *
 */

public interface INoteService {

	public void addNewNote(Note note);

	public List<Note> getAllNotes(Long userId);

	public boolean removeNoteById(Long noteId, Long userId);

	public boolean modifyNote(Note note, Long userId);
	

}
