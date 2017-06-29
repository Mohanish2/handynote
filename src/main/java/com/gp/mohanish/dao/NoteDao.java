package com.gp.mohanish.dao;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gp.mohanish.model.Note;

@Repository("iNoteDao")
@Transactional
public class NoteDao implements INoteDao {
	
	@Autowired 
	private SessionFactory sessionFactory;

	public void addNewNote(Note note){
		note.setCreated_at(new Date());
    	note.setModified_at(new Date());
		Session session = sessionFactory.getCurrentSession();
		session.save(note);
	}
	
}
