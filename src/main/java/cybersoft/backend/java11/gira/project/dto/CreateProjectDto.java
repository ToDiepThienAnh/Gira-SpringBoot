package cybersoft.backend.java11.gira.project.dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import cybersoft.backend.java11.gira.utils.DateUtils;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProjectDto {
	private String name;
	
	private String code;
	
	private String description;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtils.DATE_FORMAT)
	@DateTimeFormat(pattern = DateUtils.DATE_FORMAT)
	private LocalDateTime startDate;
	
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtils.DATE_FORMAT)
	@DateTimeFormat(pattern = DateUtils.DATE_FORMAT)
	private LocalDateTime endDate;
	
	private Long projectTypeId;
	
	private Long ownerId;
	
	private Long managerId;
}
