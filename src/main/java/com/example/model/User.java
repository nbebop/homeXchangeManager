@Entity
@Table(name = "users")
public class User {

    @NotBlank
    @NotNull
    @Column(name = "full_name", nullable = false)
    private String fullName;

    @NotBlank
    @NotNull
    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @NotBlank
    @NotNull
    @Column(name = "password", nullable = false)
    private String password;

    @NotNull
    @Column(name = "age")
    private Integer age;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @Column(name = "billing_address")
    private String billingAddress;

    @Column(name = "description")
    private String description;

    @NotBlank
    @NotNull
    @Column(name = "phone_number", unique = true, nullable = false)
    private String phoneNumber;

    @NotBlank
    @NotNull
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    public User(Long id, String fullName, String username, String password, Integer age, Gender gender, String billingAddress, String description, String phoneNumber, String email) {
        this.id = id;
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.billingAddress = billingAddress;
        this.description = description;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

enum Gender {
    MALE,
    FEMALE,
    OTHER
}