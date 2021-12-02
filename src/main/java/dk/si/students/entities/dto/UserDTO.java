package dk.si.students.entities.dto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andreas
 */
public class UserDTO {
    private String userName;
    private List<String> roleList = new ArrayList();
    private int id;
    
    public UserDTO(String userName, List<String> roleList, int id) {
        this.userName = userName;
        this.roleList = roleList;
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<String> roleList) {
        this.roleList = roleList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
