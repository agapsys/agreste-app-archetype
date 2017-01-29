package com.example;

import com.agapsys.agreste.AgresteApplication;
import com.agapsys.web.toolkit.modules.PersistenceModule;
import com.example.entities.User;
import javax.persistence.EntityManager;
import javax.servlet.annotation.WebListener;

@WebListener
public class Application extends AgresteApplication {

    public static Application getRunningInstance() {
        return (Application) AgresteApplication.getRunningInstance();
    }

    @Override
    public String getName() {
        return Defs.APP_NAME;
    }

    @Override
    public String getVersion() {
        return Defs.APP_VERSION;
    }


    @Override
    protected void afterAgresteStart() {
        super.afterAgresteStart();;

        EntityManager em = getModule(PersistenceModule.class).getEntityManager();
        em.getTransaction().begin();

        User.findOrCreate(em, "username", "password", Roles.SAMPLE_ROLE);
        User.findOrCreate(em, "username2", "password2");

        em.getTransaction().commit();
        em.close();
    }

}
