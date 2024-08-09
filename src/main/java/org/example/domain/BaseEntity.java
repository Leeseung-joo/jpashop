package org.example.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
@MappedSuperclass  //매핑 정보만 받는 부모클래스,수퍼클래스임
public class BaseEntity {
    @Column(name = "INSERT_MEMBER")
    private String createdBy;
    private LocalDateTime createdDate;   //이 속성들을 상속받아 쓰고 싶음
    @Column(name = "MODIFIED_MEMBER")
    private String LastModifiyedBy;
    private LocalDateTime lastModifiedDate;


    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiyedBy() {
        return LastModifiyedBy;
    }

    public void setLastModifiyedBy(String lastModifiyedBy) {
        LastModifiyedBy = lastModifiyedBy;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

}
