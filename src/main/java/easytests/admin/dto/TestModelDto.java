package easytests.admin.dto;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;


/**
 * @author malinink
 */
@Data
public class TestModelDto {
    @NotNull
    @NotEmpty
    @Size(min = 2, max = 30)
    private String name;

    @NotNull
    @Min(10)
    private Integer value;

    @Valid
    private List<SubTestModelDto> subTests;

    public TestModelDto() {

    }

    public TestModelDto(String name, Integer value) {
        this.name = name;
        this.value = value;
        this.subTests = new ArrayList<>();
        this.subTests.add(new SubTestModelDto(1, "sub test name first"));
        this.subTests.add(new SubTestModelDto(3, "sub test name second"));
    }

}
