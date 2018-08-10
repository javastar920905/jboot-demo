package javastar920905.shiro;

/**
 * @author ouzhx  on ${date}
 *  extends DefaultWebSubjectFactory
 */
public class JwtSubjectFactory  {

   /* @Override
    public Subject createSubject(SubjectContext context) {
        if (context.getAuthenticationToken() instanceof JwtAuthenticationToken) {
            // jwt 不创建 session
            context.setSessionCreationEnabled(false);
        }

        return super.createSubject(context);
    }
*/
}
