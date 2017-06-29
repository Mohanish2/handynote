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
	
	public boolean removeNoteById(Long noteId, Long userId){
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("delete Note where id = "+noteId+" where user_id = "+userId);
		int noOfDeletedInstances = q.executeUpdate();
		if(noOfDeletedInstances>0){
			return true;
		}
		return false;
	}
	
	public boolean modifyNote(Note note, Long userId){
		Session session = sessionFactory.getCurrentSession();
		Long noteId = note.getId();
		Note dbNote = (Note) session.get(Note.class, noteId);
		if(dbNote!=null && userId.equals(dbNote.getUser().getId())){
			Query query = session.createQuery("update Note set title = :title, description = :description " + " where id = :noteid");
			query.setString("title", note.getTitle());
			query.setString("description", note.getDescription());
			query.setParameter("noteid", note.getId());
			query.executeUpdate();
			
			/*session.evict(dbNote);
			session.saveOrUpdate(note);*/
			return true;
		}
		return false;
	}
	
}
