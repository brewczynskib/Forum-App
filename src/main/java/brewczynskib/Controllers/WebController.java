package brewczynskib.Controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import brewczynskib.Domain.Admin;
import brewczynskib.Domain.Forum;
import brewczynskib.Domain.User;
import brewczynskib.Forms.ForumForm;
import brewczynskib.Forms.UserForm;
import brewczynskib.Repositories.AdminRepository;
import brewczynskib.Repositories.ForumRepository;
import brewczynskib.Repositories.UserRepository;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;
import java.util.List;

@Controller
public class WebController {


    @Autowired
    UserRepository userRepository;
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    ForumRepository forumRepository;

    // Set Admin Object at start
    @Autowired
    public WebController(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
        Admin admin = new Admin();
        admin.setLogin("admin");
        admin.setPassword("admin");
        adminRepository.save(admin);
    }

    //Register page - u have to complete the form
    @RequestMapping("/Register")
    public String registration(HttpServletRequest request, @ModelAttribute("userForm") @Valid UserForm userForm, BindingResult result) {
        if (!result.hasErrors() && request.getMethod().equalsIgnoreCase("post")) {

            //check if in database there is no user with that login
            User foundUser = userRepository.findByLogin(userForm.getLogin());

            if (foundUser != null) {
                return "redirect:/Login";
            }
            //If there is no that user and if login pattern is correct. Create new one .
            else {
                User user = new User();
                // Set User login
                if (Pattern.matches("[a-zA-Z]{5,10}", userForm.getLogin())) {
                    user.setLogin(userForm.getLogin());
                }
                // if login patter is wrong -> try again
                else {
                    return "redirect:/Register";
                }
                // set User password.
                user.setPassword(userForm.getPassword());
                // set Administrator for this user .
                user.setAdmin(adminRepository.findAdminByLogin("admin"));
                //set User to repository
                userRepository.save(user);
                // If Login And Password added correctly return to mainPage
                return "redirect:/MainPage";
            }
        }
        //If Form is not completed correctly -> try again ( form example request method is get (?) )
        return "Register";
    }


    @RequestMapping("/Login")
    public String login(HttpServletResponse response, HttpServletRequest request, @ModelAttribute("userForm") @Valid UserForm userForm, BindingResult result) {
        if (!result.hasErrors() && request.getMethod().equalsIgnoreCase("post")) {
            // Check if in dataBase is User with following data.
            User foundUser = userRepository.findByLoginAndPassword(userForm.getLogin(), userForm.getPassword());
            // On the same page admin can log too.
            Admin foundAdmin = adminRepository.findAdminByLogin("admin");
            //If in dataBase is User with that login and password save his data in cookies and redirect to welcome page.
            if (foundUser != null && foundUser.getLogin().equals(userForm.getLogin()) && foundUser.getPassword().equals(userForm.getPassword())) {
                Cookie foo = new Cookie("foo", userForm.getLogin());
                response.addCookie(foo);
                return "redirect:/Welcome";
            }
            //If Admin logging to page redirect to admin Welcome Page .
            if (foundAdmin != null && foundAdmin.getLogin().equalsIgnoreCase(userForm.getLogin())
                    && foundAdmin.getPassword().equals(userForm.getPassword())) {
                //Its not necessary but I save adm data to cookies ( I can also use admin - password and login in return )
                Cookie adm = new Cookie("adm", foundAdmin.getLogin());
                adm.setPath("/Admin");
                response.addCookie(adm);
                return "redirect:/Admin";
                // If there is no User with that data (login and password) redirect to Register page to save new user.
            } else return "redirect:/Register";
        }
        return "Login";
    }

    @RequestMapping("/Admin")
    public String Admin(Model model) {
        // Find All users which are connecting to admin.
        List<User> adminList = adminRepository.findAllUsers();
        // Send to jsp File adminList which is List with all users connecting to admin .
        model.addAttribute("user", adminList);
        return "Admin";
    }

    // Welcome Page is page that user see after login
    @RequestMapping("/Welcome")
    public String welcome(HttpServletResponse response, Model model, @CookieValue("foo") Cookie cookie) {
        //Find a user with this login and password which are stored in cookies
        String login = cookie.getValue();
        User user = userRepository.findByLogin(login);
        // Add this user to jsp file
        model.addAttribute("user", user);

        // return view with name Welcome --> it's possible with ViewResolver -> Bean in configuration file
        return "Welcome";
    }

    @RequestMapping("/MainPage")
    public String MainPage() {
        return "MainPage";
    }


    @RequestMapping("/ChangePassword")
    public String changePassword(@CookieValue("foo") Cookie cookie, HttpServletRequest request, @ModelAttribute("userForm")
    @Valid UserForm userForm, BindingResult result) {
        // It's exactly like register or login page but here I replace password with new one.
        if (!result.hasErrors() && request.getMethod().equalsIgnoreCase("post")) {
            //Using cookies to find user -> which want to change pass
            String login = cookie.getValue();
            User user = userRepository.findByLogin(login);
            user.setPassword(userForm.getPassword());
            userRepository.save(user);
            // if form is completed correctly redirect to login page
            return "redirect:/Login";
        }
        return "ChangePassword";
    }

    //I'm using here user login from jsp file as a link to find This user which I want to delete from dataBase
    //Ofc only ADMIN can do it
    @RequestMapping("/UserInfo{login}")
    public String userDelete(@PathVariable("login") String login) {
        User user = userRepository.findByLogin(login);
        userRepository.delete(user);
        return "/UserInfo";
    }

    // On that page User can add new text to "forum"
    @RequestMapping("/Forum")
    public String forum(@CookieValue("foo") Cookie foo, HttpServletRequest request, @ModelAttribute("forumForm") @Valid ForumForm forumForm, BindingResult result) {
        if (!result.hasErrors() && request.getMethod().equalsIgnoreCase("post")) {
            // I'm looking for user that clicked that link("Forum")
            //Again it works as a register page.
            User user = userRepository.findByLogin(foo.getValue());
            Forum forum = new Forum();
            forum.setText(forumForm.getText());
            forum.setSubject(forumForm.getSubject());
            forum.setUser(user);
            forumRepository.save(forum);
            return "redirect:/WelcomeForum";
        }
        return "Forum";
    }

    // On this page u can see all topic added by users :) .
    @RequestMapping("/WelcomeForum")
    public String forum(Model model) {
        List<Forum> forum = forumRepository.findAllForums();
        model.addAttribute("forum", forum);
        return "/WelcomeForum";
    }


}