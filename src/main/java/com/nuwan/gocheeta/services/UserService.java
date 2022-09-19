package com.nuwan.gocheeta.services;

import com.nuwan.gocheeta.db.AbstractDbUtil;
import com.nuwan.gocheeta.db.UserDBUtils;
import com.nuwan.gocheeta.model.Login;
import com.nuwan.gocheeta.model.User;
import java.sql.SQLException;

/**
 *
 * @author Nuwan
 */

public class UserService extends AbstractService<User> {

    private static final AbstractDbUtil utils = new UserDBUtils();

    public UserService() {
        super(utils);
    }

    public boolean login(Login login) throws SQLException{
        UserDBUtils userDBUtils = new UserDBUtils();
        User user = userDBUtils.login(login);
        
        return user!=null;
    }

}
