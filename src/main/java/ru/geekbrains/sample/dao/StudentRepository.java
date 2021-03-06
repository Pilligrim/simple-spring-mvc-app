package ru.geekbrains.sample.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.sample.persistence.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Student> findAllStudents() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> query = builder.createQuery(Student.class);
        Root<Student> root = query.from(Student.class);
        query.select(root).where(builder.and(builder.equal(root.get("graduated"), false)));
        return entityManager.createQuery(query).getResultList();
    }

    public Student findById(UUID uuid) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> query = builder.createQuery(Student.class);
        Root<Student> root = query.from(Student.class);
        query.select(root).where(builder.and(builder.equal(root.get("uuid"), uuid)));
        return entityManager.createQuery(query).getSingleResult();
    }

    @Transactional
    public void addStudent(Student student) {
        if (student != null) {
            entityManager.persist(student);
        }
    }

}