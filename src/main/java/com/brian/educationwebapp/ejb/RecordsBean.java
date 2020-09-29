package com.brian.educationwebapp.ejb;

import com.google.common.base.Strings;
import com.brian.educationwebapp.ejb_db.DbBean_Entities;
import com.brian.educationwebapp.entities.Course;
import com.brian.educationwebapp.entities.Institution;
import com.brian.educationwebapp.entities.Student;
import com.brian.educationwebapp.entities.Course;
import com.brian.educationwebapp.jpa.TransactionProvider;
import com.brian.educationwebapp.utils.JsonResponse;
import com.brian.educationwebapp.utils.Utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/*
 *
 * @author brian
 */
@Stateless
public class RecordsBean {

    @EJB
    private DbBean_Entities entitiesBean;

    @EJB
    private TransactionProvider provider;

    public List getAllInstitutions() {
        List res = new ArrayList();

        try {
            List<Institution> alliInstitutions = entitiesBean.getInstitutions();

            for (Institution i : alliInstitutions) {
                HashMap hm = new HashMap();
                hm.put("institutionid", i.getInstitutionid());
                hm.put("name", i.getName());

                res.add(hm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return res;
        }
    }

    public HashMap getInstitution_ById(Integer id) {
        HashMap res = new HashMap();

        try {
            Institution i = entitiesBean.getInstitution_ByInstitutionId(id);

            if (i != null) {
                res.put("institutionid", i.getInstitutionid());
                res.put("name", i.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return res;
        }
    }

    public JsonResponse addInstitution(HashMap data_hm) {
        JsonResponse jr = new JsonResponse();
        jr.setResponse_code(500);
        jr.setResponse_msg("An error occurred");

        try {
            if (data_hm != null) {
                String name = Utils.getStringValue_FromHashMap(data_hm, "name");

                if (Strings.isNullOrEmpty(name)) {
                    jr.setResponse_msg("Please specify the name of the institution");
                } else {
                    Institution i = new Institution();
                    i.setName(name);

                    if (provider.createEntity(i)) {
                        jr.setResponse_code(200);
                        jr.setResponse_msg((name + " has been added as a new institution"));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return jr;
        }
    }
    
   
    public List getAllCourses() {
        List res = new ArrayList();

        try {
            List<Course> allCourses = entitiesBean.getCourses();

            for (Course i : allCourses) {
                HashMap hm = new HashMap();
                hm.put("courseid", i.getCourseid());
                hm.put("name", i.getName());

                res.add(hm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return res;
        }
    }

    public HashMap getCourse_ById(Integer id) {
        HashMap res = new HashMap();

        try {
            Course i = entitiesBean.getCourse_ByCourseId(id);

            if (i != null) {
                res.put("courseid", i.getCourseid());
                res.put("name", i.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return res;
        }
    }

    public JsonResponse addCourse(HashMap data_hm) {
        JsonResponse jr = new JsonResponse();
        jr.setResponse_code(500);
        jr.setResponse_msg("An error occurred");

        try {
            if (data_hm != null) {
                String name = Utils.getStringValue_FromHashMap(data_hm, "name");

                if (Strings.isNullOrEmpty(name)) {
                    jr.setResponse_msg("Please specify the course");
                } else {
                    Course i = new Course();
                    i.setName(name);

                    if (provider.createEntity(i)) {
                        jr.setResponse_code(200);
                        jr.setResponse_msg((name + " has been added as a new course"));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return jr;
        }
    }
    

    public List getAllStudents() {
        List res = new ArrayList();

        try {
            List<Student> allStudents = entitiesBean.getStudents();

            for (Student i : allStudents) {
                HashMap hm = new HashMap();
                hm.put("studentid", i.getStudentid());
                hm.put("name", i.getName());

                res.add(hm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return res;
        }
    }

    public HashMap getStudent_ById(Integer id) {
        HashMap res = new HashMap();

        try {
            Student i = entitiesBean.getStudent_ByStudentId(id);

            if (i != null) {
                res.put("studentid", i.getStudentid());
                res.put("name", i.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return res;
        }
    }

    public JsonResponse addStudent(HashMap data_hm) {
        JsonResponse jr = new JsonResponse();
        jr.setResponse_code(500);
        jr.setResponse_msg("An error occurred");

        try {
            if (data_hm != null) {
                String name = Utils.getStringValue_FromHashMap(data_hm, "name");

                if (Strings.isNullOrEmpty(name)) {
                    jr.setResponse_msg("Please specify the name");
                } else {
                    Student i = new Student();
                    i.setName(name);

                    if (provider.createEntity(i)) {
                        jr.setResponse_code(200);
                        jr.setResponse_msg((name + " has been added as a new student"));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return jr;
        }
    }
    
}
