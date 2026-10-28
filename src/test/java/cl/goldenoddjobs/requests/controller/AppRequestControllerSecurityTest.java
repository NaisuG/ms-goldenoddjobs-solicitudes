package cl.goldenoddjobs.requests.controller;

import cl.goldenoddjobs.requests.model.AppRequest;
import cl.goldenoddjobs.requests.model.Proposal;
import org.junit.jupiter.api.Test;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.jwt.Jwt;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AppRequestControllerSecurityTest {

    private String ruleOf(Method method) {
        PreAuthorize rule = method.getAnnotation(PreAuthorize.class);
        assertNotNull(rule, method.getName() + " must be protected with @PreAuthorize");
        return rule.value();
    }

    @Test
    void onlyRequestersCanCreateRequests() throws Exception {
        Method method = AppRequestController.class.getMethod("createRequest", AppRequest.class, Jwt.class);
        assertEquals("hasRole('SOLICITANTE')", ruleOf(method));
    }

    @Test
    void onlyDevelopersCanListAvailableRequestsAndSubmitProposals() throws Exception {
        assertEquals("hasRole('DESARROLLADOR')", ruleOf(AppRequestController.class.getMethod("listAvailable")));
        assertEquals("hasRole('DESARROLLADOR')",
                ruleOf(AppRequestController.class.getMethod("submitProposal", Long.class, Proposal.class, Jwt.class)));
    }

    @Test
    void onlyAdminsCanListEveryRequest() throws Exception {
        assertEquals("hasRole('ADMIN')", ruleOf(AppRequestController.class.getMethod("listAll")));
    }
}
