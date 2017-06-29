/**
 * 
 */
package com.gp.mohanish.dao;

import java.util.List;

import com.gp.mohanish.model.Note;

/**
 * @author mohanish
 *
 */
public interface INoteDao {

	public void addNewNote(Note note);

	public List<Note> getAllNotes(Long userId);

}
