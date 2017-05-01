package easytests.admin.controllers;

import easytests.admin.dto.TestModelDto;
import easytests.admin.dto.UserModelDto;
import easytests.admin.validators.UserModelDtoValidator;
import easytests.common.controllers.AbstractCrudController;
import easytests.common.exceptions.NotFoundException;
import easytests.models.UserModel;
import easytests.models.UserModelInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;


/**
 * @author malinink
 */
@Controller
@SuppressWarnings("checkstyle:MultipleStringLiterals")
@RequestMapping("/admin/test/")
public class TestController extends AbstractCrudController {
    @GetMapping("")
    public String update(Model model) {
        final TestModelDto testModelDto = new TestModelDto("test name", 9);
        model.addAttribute("test", testModelDto);
        return "admin/test/form";
    }

    @PostMapping("")
    public String save(Model model, @Valid TestModelDto testModelDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("test", testModelDto);
            model.addAttribute("errors", bindingResult);
            return "admin/test/form";
        }

        return "redirect:/admin/test/";
    }

}
