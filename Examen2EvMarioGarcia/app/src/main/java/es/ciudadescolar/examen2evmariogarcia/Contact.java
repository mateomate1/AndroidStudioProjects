package es.ciudadescolar.examen2evmariogarcia;

public class Contact {
    private int imageResourceId;
    private String name;
    private String phone;
    private String email;

    public Contact(int imageResourceId, String name, String phone, String email) {
        this.imageResourceId = imageResourceId;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    // Getters
    public int getImageResourceId() { return imageResourceId; }
    public String getName() { return name; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
}

