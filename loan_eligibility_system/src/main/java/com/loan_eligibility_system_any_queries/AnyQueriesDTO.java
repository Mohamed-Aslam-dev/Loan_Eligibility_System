package com.loan_eligibility_system_any_queries;

import java.time.LocalDateTime;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AnyQueriesDTO {

	@NotBlank(message = "Name is required")
	@Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
	private String userName;

	@NotBlank(message = "Email is required")
	@Email(message = "Enter a valid email address")
	private String email;

	@NotNull(message = "Please select a query type")
	@Enumerated(EnumType.STRING)
	private QueriesType queryType;

	@NotBlank(message = "Message is required")
	@Size(min = 10, max = 500, message = "Message must be between 10 and 500 characters")
	private String message;

	private String tokenId;

	private LocalDateTime queryRaisedDateAndTime;
	
	@Enumerated(EnumType.STRING)
	private QueriesStatus queryStatus;

	public AnyQueriesDTO() {

	}

	public AnyQueriesDTO(
			@NotBlank(message = "Name is required") @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters") String userName,
			@NotBlank(message = "Email is required") @Email(message = "Enter a valid email address") String email,
			@NotNull(message = "Please select a query type") QueriesType queryType,
			@NotBlank(message = "Message is required") @Size(min = 10, max = 500, message = "Message must be between 10 and 500 characters") String message,
			String tokenId, LocalDateTime queryRaisedDateAndTime, QueriesStatus queryStatus) {
		super();
		this.userName = userName;
		this.email = email;
		this.queryType = queryType;
		this.message = message;
		this.tokenId = tokenId;
		this.queryRaisedDateAndTime = queryRaisedDateAndTime;
		this.queryStatus = queryStatus;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public QueriesType getQueryType() {
		return queryType;
	}

	public void setQueryType(QueriesType queryType) {
		this.queryType = queryType;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public LocalDateTime getQueryRaisedDateAndTime() {
		return queryRaisedDateAndTime;
	}

	public void setQueryRaisedDateAndTime(LocalDateTime queryRaisedDateAndTime) {
		this.queryRaisedDateAndTime = queryRaisedDateAndTime;
	}
	
	

	public QueriesStatus getQueryStatus() {
		return queryStatus;
	}

	public void setQueryStatus(QueriesStatus queryStatus) {
		this.queryStatus = queryStatus;
	}

	@Override
	public String toString() {
		return "AnyQueriesDTO [userName=" + userName + ", email=" + email + ", queryType=" + queryType + ", message="
				+ message + ", tokenId=" + tokenId + ", queryRaisedDateAndTime=" + queryRaisedDateAndTime
				+ ", queryStatus=" + queryStatus + "]";
	}

}
