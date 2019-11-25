package valid.condition;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class OneThing {
    @NotEmpty
    private String testEmpty;
    @NotBlank
    private String testBlank;
    @NotNull
    private Integer testInt;
}

