package com.gp.mohanish.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
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
	
	public List<Note> getAllNotes(Long userId) {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Note n where n.user.id=?");
		q.setParameter(0, userId);
		List<Note> notesList = q.list();
		return notesList;
	}
	
}
