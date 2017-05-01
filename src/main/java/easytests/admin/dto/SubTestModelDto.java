package easytests.admin.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;


/**
 * @author malinink
 */
@Data
public class SubTestModelDto {
    @NotNull
    private Integer id;

    @NotNull
    @NotEmpty
    @Size(min = 2, max = 30)
    private String name;

    public SubTestModelDto() {

    }

    public SubTestModelDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
