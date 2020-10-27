package org.okcoder.app.task.result.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
public class AuthContorller {
    private Logger logger = LoggerFactory.getLogger(AuthContorller.class);

    public static class AuthInfo{
        private String userId;
        private String token;
        private List<MenuItem> menus = new ArrayList<>();

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public List<MenuItem> getMenus() {
            return menus;
        }

        public void setMenus(List<MenuItem> menus) {
            this.menus = menus;
        }
    }
    public static class MenuItem{
        private String cssClass;
        private String title;
        private String index;
        private List<MenuItem> children=new ArrayList<>();
        public MenuItem(){}
        public MenuItem(String title, String index,String cssClass) {
            this.cssClass = cssClass;
            this.title = title;
            this.index = index;
        }

        public String getCssClass() {
            return cssClass;
        }

        public void setCssClass(String cssClass) {
            this.cssClass = cssClass;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getIndex() {
            return index;
        }

        public void setIndex(String index) {
            this.index = index;
        }

        public List<MenuItem> getChildren() {
            return children;
        }

        public void setChildren(List<MenuItem> children) {
            this.children = children;
        }
    }
    @PostMapping("auth")
    @CrossOrigin
    public AuthInfo auth(@RequestBody Map<String,Object> body){
        AuthInfo auth = new AuthInfo();
        auth.userId="abcd";
        auth.token="token1";

        auth.menus.add(new MenuItem("Home","/","el-icon-s-home"));
        auth.menus.add(new MenuItem("Master","","el-icon-menu"));
        auth.menus.get(1).getChildren().add(new MenuItem("User","/master/userList","el-icon-user-solid"));
        auth.menus.get(1).getChildren().add(new MenuItem("Department","/master/departmentList","el-icon-office-building"));
        auth.menus.get(1).getChildren().add(new MenuItem("Item","/master/itemList","el-icon-shopping-cart-full"));
        auth.menus.add(new MenuItem("Invoice","/invoice/search","el-icon-notebook-2"));
        auth.menus.add(new MenuItem("menu3","/3","el-icon-setting"));
        logger.info("{}",body);
        return auth;
    }
}
