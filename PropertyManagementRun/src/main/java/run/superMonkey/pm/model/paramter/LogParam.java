package run.superMonkey.pm.model.paramter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import run.superMonkey.pm.model.enums.LogType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogParam {
	
	
	@Size(max = 1023, message = "Length of log key must not be more than {max}")
	private String logKey;
	
	@NotNull(message = "Log type must not be null")
	private LogType type;
	
	@NotBlank(message = "Log content must not be blank")
    @Size(max = 1023, message = "Log content must not be more than 1023")
	private String content;
	
}
