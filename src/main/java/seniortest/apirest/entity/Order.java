package seniortest.apirest.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="tb_order")
public class Order implements Serializable{


        @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private UUID id;

    @Column(name = "number")
    private int number;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date")
    private Date date = new Date();

    @Column(name = "percentualDiscount")
    private Double percentualDiscount;

    @Column(name = "totalValue")
    private Double totalValue;


}

