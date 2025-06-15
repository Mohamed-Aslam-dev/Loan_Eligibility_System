package com.loan_eligibility_system_any_queries;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AnyQueries {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sNo;
	private String userName;
	private String email;
	@Enumerated(EnumType.STRING)
	private QueriesType queryType;
	private String message;
	private String tokenId;
	private LocalDateTime queryRaisedDateAndTime;
	@Enumerated(EnumType.STRING)
	private QueriesStatus queryStatus;

	public AnyQueries() {

	}

	public AnyQueries(Integer sNo, String userName, String email, QueriesType queryType, String message, String tokenId,
			LocalDateTime queryRaisedDateAndTime, QueriesStatus queryStatus) {
		
		this.sNo = sNo;
		this.userName = userName;
		this.email = email;
		this.queryType = queryType;
		this.message = message;
		this.tokenId = tokenId;
		this.queryRaisedDateAndTime = queryRaisedDateAndTime;
		this.queryStatus = queryStatus;
	}

	public Integer getsNo() {
		return sNo;
	}

	public void setsNo(Integer sNo) {
		this.sNo = sNo;
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
		return "AnyQueries [sNo=" + sNo + ", userName=" + userName + ", email=" + email + ", queryType=" + queryType
				+ ", message=" + message + ", tokenId=" + tokenId + ", queryRaisedDateAndTime=" + queryRaisedDateAndTime
				+ ", queryStatus=" + queryStatus + "]";
	}

}
