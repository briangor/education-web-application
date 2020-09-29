package com.brian.educationwebapp.ejb_db;

import com.brian.educationwebapp.entities.Course;
import com.brian.educationwebapp.entities.Institution;
import com.brian.educationwebapp.entities.Student;
import com.brian.educationwebapp.jpa.TransactionProvider;
import java.awt.image.AffineTransformOp;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author brian
 */
@Stateless
public class DbBean_Entities {

    @EJB
    private TransactionProvider provider;

    public List<Institution> getInstitutions() {
        List<Institution> list = new ArrayList();
        try {
            EntityManager em = provider.getEM();

            Query q = em.createQuery("SELECT i FROM Institution i");
            list = provider.getManyFromQuery(q);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return list;
        }
    }

    public Institution getInstitution_ByInstitutionId(Integer institutionid) {
        Institution res = null;
        try {
            if (institutionid != null) {
                EntityManager em = provider.getEM();

                Query q = em.createQuery("SELECT i FROM Institution i WHERE i.institutionid = :institutionid");
                q.setParameter("institutionid", institutionid);
                res = provider.getSingleResult(q);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return res;
        }
    }


    public List<Course> getCourses() {
        List<Course> list = new ArrayList();
        try {
            EntityManager em = provider.getEM();

            Query q = em.createQuery("SELECT i FROM Course i");
            list = provider.getManyFromQuery(q);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return list;
        }
    }

    public Course getCourse_ByCourseId(Integer courseid) {
        Course res = null;
        try {
            if (courseid != null) {
                EntityManager em = provider.getEM();

                Query q = em.createQuery("SELECT i FROM Course i WHERE i.courseid = :courseid");
                q.setParameter("courseid", courseid);
                res = provider.getSingleResult(q);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return res;
        }
    }


    public List<Student> getStudents() {
        List<Student> list = new ArrayList();
        try {
            EntityManager em = provider.getEM();

            Query q = em.createQuery("SELECT i FROM Student i");
            list = provider.getManyFromQuery(q);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return list;
        }
    }

    public Student getStudent_ByStudentId(Integer studentid) {
        Student res = null;
        try {
            if (studentid != null) {
                EntityManager em = provider.getEM();

                Query q = em.createQuery("SELECT i FROM Student i WHERE i.studentid = :studentid");
                q.setParameter("studentid", studentid);
                res = provider.getSingleResult(q);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return res;
        }
    }
}
