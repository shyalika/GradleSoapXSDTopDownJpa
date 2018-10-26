package com.shyali.jpa.service;

import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.cxf.annotations.SchemaValidation;
import org.apache.cxf.annotations.SchemaValidation.SchemaValidationType;
import org.jboss.ws.api.annotation.WebContext;

import com.shyali.jpa.entity.Employee;
import com.shyali.xsd.service.HelloXSD;
import com.shyali.xsd.service.SayHelloRequest;
import com.shyali.xsd.service.SayHelloResponse;

@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
@WebService(
        serviceName = "HelloXSDService",
        portName = "HelloXSDPort",
        endpointInterface = "com.shyali.xsd.service.HelloXSD",
        targetNamespace = "http://service.shyali.com",
        wsdlLocation = "META-INF/wsdl/HelloXSD.wsdl")
@WebContext(contextRoot = "/shyali/GradleSoapTopDownXSD", urlPattern = "HelloService")
@SchemaValidation(type = SchemaValidationType.NONE)
@Stateless
@Startup
public class HelloSXDServiceImpl implements HelloXSD {

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public SayHelloResponse helloName(SayHelloRequest parameters) {
        SayHelloResponse res = new SayHelloResponse();

        TypedQuery<Employee> query = entityManager.createNamedQuery(
                "Employee.findByName", Employee.class);
        query.setParameter("firstName", parameters.getName());

        try {
            Employee employee = query.getSingleResult();
            res.setNameReturn(
                    "Hello " + parameters.getName() + " " + employee.getLastName() + " welcome");
        } catch (NoResultException e) {
            res.setNameReturn("Hello guest, welcome");
        }

        return res;
    }

}
