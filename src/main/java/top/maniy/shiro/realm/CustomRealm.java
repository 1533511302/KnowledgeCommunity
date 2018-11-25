package top.maniy.shiro.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import top.maniy.entity.User;
import top.maniy.mapper.UserMapper;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author liuzonghua
 * @Package top.maniy.test
 * @Description:
 * @date 2018/10/6 13:59
 */
public class CustomRealm extends AuthorizingRealm{

    @Autowired
    private UserMapper userMapper;
//    Map<String,String> userMap =new HashMap<String, String>(16);
//    {
//        userMap.put("maniy","993121f227e2cef658c392549708d60c");
//        super.setName("customRealm");
//    }
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String userName = (String) principalCollection.getPrimaryPrincipal();
        Set<String> roles =getRolesByUserName(userName);

        Set<String> permissions = getPermissionByUserName(userName);
        SimpleAuthorizationInfo simpleAuthorizationInfo =new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setStringPermissions(permissions);
        simpleAuthorizationInfo.setRoles(roles);

        return simpleAuthorizationInfo;
    }

    private Set<String> getPermissionByUserName(String userName) {
        List<String> listR =userMapper.queryRolesByUserName(userName);
        List<String>listP=new ArrayList<String>();
        for(String str:listR){
             listP.addAll(userMapper.queryPermissionByUserName(str));
        }

        Set<String> sets =new HashSet<String>(listP);
//     Set<String> sets =new HashSet<String>();
//     sets.add("user:delete");
//     sets.add("user:add");
     return sets;
    }

    private Set<String> getRolesByUserName(String userName) {
        System.out.println("从数据库中获取授权数据");
        List<String> list =userMapper.queryRolesByUserName(userName);

        Set<String> sets=new HashSet<String>(list);
//        Set<String> sets =new HashSet<String>();
//        sets.add("admin");
//        sets.add("user");
        return sets;
    }

       protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {
        //1.从主体传过来额认证信息中，获得用户名
        String userName = (String) authenticationToken.getPrincipal();
        //2.通过用户名到数据库中获取凭证
        String password = getPasswordByUserName(userName);
        if(password == null){
            return null;
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo =new SimpleAuthenticationInfo
                (userName,password,"customRealm");
        //shiro需要知道用了什么盐，在去解析密码
        simpleAuthenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(userName));

               return simpleAuthenticationInfo;
    }

    /**
     * 模拟数据库查询认证
     * @param username
     * @return
     */
    private String getPasswordByUserName(String username){
        //
        User user =userMapper.findUserByUsername(username);

        if(user!=null){
            //        //用session 对象保存当前登陆用户
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest req = attributes.getRequest();

            if(req.getSession().getAttribute("User")==null) {

                req.getSession().setAttribute("User", user);
            }
            return user.getPassword();
        }else {
            return null;
        }
        //return userMap.get(username);
    }


    //清除缓存
    public void clearCached() {
        PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
        super.clearCache(principals);
    }


    public static void main(String[] args) {
        //单一的是密码加密容易破解，这时候就需要 加盐
        Md5Hash md5Hash= new Md5Hash("123456","admin");
        System.out.println(md5Hash.toString());

        if("f0f8c900cc3816a7bfd1aaf8f890a05e"=="f0f8c900cc3816a7bfd1aaf8f890a05e"){
            System.out.println("相同");
        }


    }
}
