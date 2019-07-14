package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "nice")
@Entity


public class Nice {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "report_id", nullable = false)
    private Integer report_id;

    @Column(name = "employee_id", nullable = false)
    private Integer employee_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getreport_id() {
        return report_id;
    }

    public void setreport_id(Integer report_id) {
        this.report_id = report_id;
    }

    public Integer getemployee_id() {
        return employee_id;
    }

    public void setemployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

}
