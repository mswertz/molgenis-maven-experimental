package org.molgenis.db.jpa;

/**
 *
 * @author joris lops
 */
public class JpaFrameworkFactory {
    public static JpaFramework createFramework() {
        return new HibernateImp();
    }
}
