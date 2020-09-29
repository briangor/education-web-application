package com.brian.educationwebapp.api;

import com.brian.educationwebapp.ejb.RecordsBean;
import com.brian.educationwebapp.utils.JsonResponse;
import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author brian
 */
@Stateless
@Path("records")
@Produces({MediaType.APPLICATION_JSON})
public class Records {

    @EJB
    private RecordsBean rBean;

    @GET
    @Path("institutions")
    public Response getAllInstitutions() {
        return Response.ok(rBean.getAllInstitutions()).build();
    }

    @GET
    @Path("institution/{id}")
    public Response getInstitutionById(@PathParam("id") Integer id) {
        return Response.ok(rBean.getInstitution_ById(id)).build();
    }

    @POST
    @Path("institution")
    public Response addInstitution(HashMap data_hm) {
        JsonResponse jr = rBean.addInstitution(data_hm);

        return Response.status(jr.getResponse_code()).entity(jr).build();
    }


    @GET
    @Path("courses")
    public Response getAllCourses() {
        return Response.ok(rBean.getAllCourses()).build();
    }

    @GET
    @Path("course/{id}")
    public Response getCourseById(@PathParam("id") Integer id) {
        return Response.ok(rBean.getCourse_ById(id)).build();
    }

    @POST
    @Path("course")
    public Response addCourse(HashMap data_hm) {
        JsonResponse jr = rBean.addCourse(data_hm);

        return Response.status(jr.getResponse_code()).entity(jr).build();
    }

    @GET
    @Path("students")
    public Response getAllStudents() {
        return Response.ok(rBean.getAllStudents()).build();
    }

    @GET
    @Path("student/{id}")
    public Response getStudentById(@PathParam("id") Integer id) {
        return Response.ok(rBean.getStudent_ById(id)).build();
    }

    @POST
    @Path("student")
    public Response addStudent(HashMap data_hm) {
        JsonResponse jr = rBean.addStudent(data_hm);

        return Response.status(jr.getResponse_code()).entity(jr).build();
    }

}
    


