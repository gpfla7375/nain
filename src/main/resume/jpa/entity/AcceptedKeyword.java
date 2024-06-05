import jakarta.persistence.Id;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "accepted_keyword")
public class AcceptedKeyword {
    
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "jobTitle", columnDefinition = "CHAR(36)")
    private UUID jobTitle;

    @Column(name = "keyword")
    private String keyword;

}

